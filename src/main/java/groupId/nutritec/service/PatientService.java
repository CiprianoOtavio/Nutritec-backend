package groupId.nutritec.service;

import groupId.nutritec.model.Patient;
import groupId.nutritec.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient findById(String id) {
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
    }

    public Patient create(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient update(Patient patient){
        return patientRepository.save(patient);
    }

    public void delete(String id){
        patientRepository.deleteById(id);
    }


}