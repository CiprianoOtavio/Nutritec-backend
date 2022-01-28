package groupId.nutritec.controller;

import groupId.nutritec.model.Nutritionist;
import groupId.nutritec.service.NutritionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nutritionists")
@RequiredArgsConstructor

public class NutritionistController {

    private final NutritionistService nutritionistService;

    @GetMapping
    public List<Nutritionist> getAll(){
        return nutritionistService.getAll();
    }

    @GetMapping("/{id}")
    public Nutritionist findById(@PathVariable String id) {
        return nutritionistService.findById(id);
    }

    @PostMapping
    public Nutritionist create(@RequestBody Nutritionist nutritionist){
        return nutritionistService.create(nutritionist);
    }

    @DeleteMapping("/{registration}")
    public void delete(@PathVariable Long registration){
        nutritionistService.delete(registration);
    }

    @PutMapping
    public Nutritionist update(@RequestBody Nutritionist nutritionist){
        return nutritionistService.update(nutritionist);
    }

    @GetMapping("/healthplan/{healthPlan}")
    public List<Nutritionist> findAllByHealthPlan(@PathVariable String healthPlan){
        return nutritionistService.findAllByHealthPlan(healthPlan);
    }
}
