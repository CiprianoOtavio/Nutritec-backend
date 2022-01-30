package groupId.nutritec.repository;

import groupId.nutritec.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {
    public Optional<Patient> findByCPF(String CPF);

    public Patient deleteByCPF(String CPF);
}
