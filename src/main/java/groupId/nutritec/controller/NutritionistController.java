package groupId.nutritec.controller;

import groupId.nutritec.model.Nutritionist;
import groupId.nutritec.service.NutritionistService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("nutritionists")
@RequiredArgsConstructor

public class NutritionistController {

    private final NutritionistService nutritionistService;

    @GetMapping
    public List<Nutritionist> getAll() {
        return nutritionistService.getAll();
    }

    @GetMapping("/{registration}")
    public Nutritionist findByRegistration(@PathVariable String registration) {
        return nutritionistService.findByRegistration(registration);
    }

    @PostMapping
    public ResponseEntity<Nutritionist> create(@RequestBody Nutritionist nutritionist) {
        nutritionist = nutritionistService.create(nutritionist);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nutritionist.getRegistration()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{registration}")
    public void delete(@PathVariable String registration) {
        nutritionistService.delete(registration);
    }

    @PutMapping
    public Nutritionist update(@RequestBody Nutritionist nutritionist) {
        return nutritionistService.update(nutritionist);
    }

    @GetMapping("/healthplan/{healthPlan}")
    public List<Nutritionist> findAllByHealthPlan(@PathVariable String healthPlan) {
        return nutritionistService.findAllByHealthPlan(healthPlan);
    }
}
