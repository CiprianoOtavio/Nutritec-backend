package groupId.nutritec.service;

import groupId.nutritec.model.Nutritionist;
import groupId.nutritec.repository.NutritionistRepository;
import groupId.nutritec.util.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionistService {

    @Autowired
    private NutritionistRepository nutritionistRepository;

    public List<Nutritionist> getAll() {
        return nutritionistRepository.findAll();
    }

    public Nutritionist findByRegistration(String registration) {
        return nutritionistRepository.findByRegistration(registration).orElseThrow(() -> new IllegalArgumentException("Nutritionist not found"));
    }

    public Nutritionist create(Nutritionist nutritionist) {
        if (nutritionistRepository.findByRegistration(nutritionist.getRegistration()).isPresent())
            throw new CustomError("Nutritionist already registered");
        return nutritionistRepository.save(validateNutritionist(nutritionist));
    }

    public Nutritionist update(Nutritionist nutritionist) {
        if (nutritionistRepository.findByRegistration(nutritionist.getRegistration()).isEmpty())
            throw new CustomError("Nutritionist not found");
        return nutritionistRepository.save(validateNutritionist(nutritionist));
    }

    public void delete(String registration) {
        if (nutritionistRepository.findByRegistration(registration).isEmpty())
            throw new CustomError("Nutritionist not found");
        nutritionistRepository.deleteNutritionistByRegistration(registration);
    }

    public List<Nutritionist> findAllByHealthPlan(String healthPlan) {
        return nutritionistRepository.findAllByHealthPlan(healthPlan);
    }

    public Nutritionist validateNutritionist(Nutritionist nutritionist) {
        boolean name, age, registration, validRegistration = true;

        for (int i = 0; i < nutritionist.getRegistration().length(); i++) {
            if (!nutritionist.getRegistration().substring(i).matches("[0-9]*")) {
                validRegistration = false;
            }
        }
        name = (nutritionist.getName() == null || nutritionist.getName().isEmpty());
        age = (nutritionist.getAge() <= 0);
        registration = (nutritionist.getRegistration().length() != 4 || !validRegistration);

        if (name)
            throw new CustomError("Invalid name");
        else if (age)
            throw new CustomError("Invalid age");
        else if (registration)
            throw new CustomError("Invalid registration");

        return nutritionist;
    }
}
