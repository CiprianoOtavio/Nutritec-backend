package groupId.nutritec.service;

import groupId.nutritec.model.Nutritionist;
import groupId.nutritec.repository.NutritionistRepository;
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

    public Nutritionist findById(String id) {
        return nutritionistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nutritionist not found"));
    }

    public Nutritionist create(Nutritionist nutritionist){
        return nutritionistRepository.save(nutritionist);
    }

    public Nutritionist update(Nutritionist nutritionist){
        return nutritionistRepository.save(nutritionist);
    }

    public void delete(Long registration){
        nutritionistRepository.deleteNutritionistByRegistration(registration);
    }


}
