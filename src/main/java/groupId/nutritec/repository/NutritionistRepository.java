package groupId.nutritec.repository;


import groupId.nutritec.model.Nutritionist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NutritionistRepository extends MongoRepository<Nutritionist, String> {

    public Nutritionist deleteNutritionistByRegistration(String registration);

    public List<Nutritionist> findAllByHealthPlan(String healthPlan);

    public Optional<Nutritionist> findByRegistration(String registration);
}
