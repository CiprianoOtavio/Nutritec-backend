package groupId.nutritec.service;

import groupId.nutritec.model.Consulta;
import groupId.nutritec.model.ConsultaData;
import groupId.nutritec.model.Patient;
import groupId.nutritec.repository.ConsultaRepository;
import groupId.nutritec.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PatientRepository patientRepository;

    public List<Consulta> getAll() {
        return consultaRepository.findAll();
    }

    public List<Consulta> getAllByNutritionistId(String nutritionistId){
        return consultaRepository.findAllByNutritionistId(nutritionistId);
    }

    public Consulta create(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta update(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public void delete(String id){
        consultaRepository.deleteById(id);
    }

    public List<ConsultaData> getConsultasInAgeRange() {
        List<Consulta> consultas = consultaRepository.findAll();
        List<ConsultaData> consultaDatas = new ArrayList<ConsultaData>();

        for (int i = 0; i < consultas.size(); i++) {
            Optional<Patient> patient = patientRepository.findById(consultas.get(i).getPatientId());

                for (int j = 0; j < consultaDatas.size(); j++) {
                    if (consultaDatas.get(j).getPatientAge() != patient.get().getAge()) {
                        if (j+1 == consultaDatas.size()) {
                            consultaDatas.add(new ConsultaData(patient.get().getAge(), 1));
                        }
                        continue;
                    }
                    consultaDatas.get(j).setConsultaCount(consultaDatas.get(j).getConsultaCount() + 1);
                }
                if(consultaDatas.size() == 0){
                    consultaDatas.add(new ConsultaData(patient.get().getAge(), 1));
                }
        }
        return consultaDatas;
    }
}