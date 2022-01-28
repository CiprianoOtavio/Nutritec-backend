package groupId.nutritec.repository;

import groupId.nutritec.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {

}
