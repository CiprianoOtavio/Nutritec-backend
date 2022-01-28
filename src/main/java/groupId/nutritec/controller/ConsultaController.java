package groupId.nutritec.controller;

import groupId.nutritec.model.Consulta;
import groupId.nutritec.model.ConsultaData;
import groupId.nutritec.model.Patient;
import groupId.nutritec.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consultas")
@RequiredArgsConstructor

public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping
    public List<Consulta> getAll(){
        return consultaService.getAll();
    }

    @GetMapping("/{nutritionistId}")
    public List<Consulta> getAllByNutritionistId(@PathVariable String nutritionistId){
        return consultaService.getAllByNutritionistId(nutritionistId);
    }

    @PostMapping
    public Consulta create(@RequestBody Consulta consulta){
        return consultaService.create(consulta);
    }

    @GetMapping("/data")
    public List<ConsultaData> getConsultasInAgeRange(){
        return consultaService.getConsultasInAgeRange();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        consultaService.delete(id);
    }

    @PutMapping
    public Consulta update(@RequestBody Consulta consulta){
        return consultaService.update(consulta);
    }

}
