package groupId.nutritec.repository;

import groupId.nutritec.model.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {

    public List<Consulta> findAllByNutritionistRegistration(String nutritionistRegistration);

    public Optional<Consulta> findByDate(String date);
}
