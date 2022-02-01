package groupId.nutritec.service;

import groupId.nutritec.model.Patient;
import groupId.nutritec.repository.PatientRepository;
import groupId.nutritec.util.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient findByCPF(String CPF) {
        return patientRepository.findByCPF(CPF).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
    }

    public Patient update(Patient patient) {
        if (patientRepository.findByCPF(patient.getCPF()).isEmpty())
            throw new CustomError("Patient not found");
        return patientRepository.save(validatePatient(patient));
    }

    public void delete(String CPF) {
        if (patientRepository.findByCPF(CPF).isEmpty())
            throw new CustomError("Patient not found");
        patientRepository.deleteByCPF(CPF);
    }

    public Patient create(Patient patient) {
        if (patientRepository.findByCPF(patient.getCPF()).isPresent())
            throw new CustomError("Patient already registered");
        return patientRepository.save(validatePatient(patient));
    }

    public Patient validatePatient(Patient patient) {
        boolean name, data, CPF, validCPF = true;

        for (int i = 0; i < patient.getCPF().length(); i++) {
            System.out.println("Teste");
            if (!patient.getCPF().substring(i).matches("[0-9]*")) {
                validCPF = false;
            }
        }
        name = (patient.getName() == null || patient.getName().isEmpty());
        data = (patient.getHeight().compareTo(BigDecimal.ZERO) <= 0 || patient.getWeight().compareTo(BigDecimal.ZERO) <= 0 || patient.getAge() <= 0);
        CPF = (patient.getCPF().length() != 11 || !validCPF);

        if (name)
            throw new CustomError("Invalid name");
        else if (data)
            throw new CustomError("Invalid data");
        else if (CPF)
            throw new CustomError("Invalid CPF");

        return patient;
    }
}