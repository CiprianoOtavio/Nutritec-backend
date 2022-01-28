package groupId.nutritec.repository;


import groupId.nutritec.model.Nutritionist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NutritionistRepository extends MongoRepository<Nutritionist, String> {

    public int deleteNutritionistByRegistration(Long registration);
}
