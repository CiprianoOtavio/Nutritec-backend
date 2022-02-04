package groupId.nutritec.service;

import groupId.nutritec.model.Consulta;
import groupId.nutritec.model.ConsultaData;
import groupId.nutritec.model.Patient;
import groupId.nutritec.repository.ConsultaRepository;
import groupId.nutritec.repository.NutritionistRepository;
import groupId.nutritec.repository.PatientRepository;
import groupId.nutritec.util.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private NutritionistRepository nutritionistRepository;

    public List<Consulta> getAll() {
        return consultaRepository.findAll();
    }

    public List<Consulta> getAllByNutritionistRegistration(String nutritionistRegistration) {
        return consultaRepository.findAllByNutritionistRegistration(nutritionistRegistration);
    }

    public Consulta findById(String id) {
        return consultaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Consulta not found"));
    }

    public Consulta create(Consulta consulta) {
        return consultaRepository.save(validateConsulta(consulta));
    }

    public Consulta update(Consulta consulta) {
        if (consultaRepository.findById(consulta.getId()).isEmpty())
            throw new CustomError("Appointment not found");
        return consultaRepository.save(validateConsulta(consulta));
    }

    public void delete(String id) {
        consultaRepository.deleteById(id);
    }

    public List<ConsultaData> getConsultasInAgeRange() {
        List<Consulta> consultas = consultaRepository.findAll();
        List<ConsultaData> consultaDatas = new ArrayList<ConsultaData>();

        System.out.println(consultas.size());
        for (int i = 0; i < consultas.size(); i++) {
            Optional<Patient> patient = patientRepository.findByCPF(consultas.get(i).getPatientCPF());

            for (int j = 0; j < consultaDatas.size(); j++) {
                if (consultaDatas.get(j).getPatientAge() != patient.get().getAge()) {
                    if (j + 1 == consultaDatas.size()) {
                        consultaDatas.add(new ConsultaData(patient.get().getAge(), 0));
                    }
                    continue;
                }
                consultaDatas.get(j).setConsultaCount(consultaDatas.get(j).getConsultaCount() + 1);
                break;
            }
            if (consultaDatas.size() == 0) {
                consultaDatas.add(new ConsultaData(patient.get().getAge(), 1));
            }
            System.out.println("\n");
        }
        return consultaDatas;
    }

    public String[][] getNutritionistsByHealthPlan() {
        String[][] count = new String[3][2];

        count[0][0] = "UT_MAIS";
        count[0][1] = String.valueOf(nutritionistRepository.findAllByHealthPlan("UT_MAIS").size());
        count[1][0] = "PLANO_VIDA";
        count[1][1] = String.valueOf(nutritionistRepository.findAllByHealthPlan("PLANO_VIDA").size());
        count[2][0] = "HAP_SAUDE";
        count[2][1] = String.valueOf(nutritionistRepository.findAllByHealthPlan("HAP_SAUDE").size());

        return count;
    }

    public Consulta validateConsulta(Consulta consulta) {
        if (Instant.now().getEpochSecond() >= Integer.parseInt(consulta.getDate()))
            throw new CustomError("Invalid Date");
        if (patientRepository.findByCPF(consulta.getPatientCPF()).isEmpty())
            throw new CustomError("Patient not found");
        if (nutritionistRepository.findByRegistration(consulta.getNutritionistRegistration()).isEmpty())
            throw new CustomError("Nutritionist not found");
        if (nutritionistRepository.findByRegistration(consulta.getNutritionistRegistration()).isPresent() && consultaRepository.findByDate(consulta.getDate()).isPresent())
            throw new CustomError("Appointment unavailable");

        return consulta;
    }
}