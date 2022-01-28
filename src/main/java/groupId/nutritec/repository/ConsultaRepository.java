package groupId.nutritec.repository;

import groupId.nutritec.model.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {

    public List<Consulta> findAllByNutritionistId(String nutritionistId);
}
