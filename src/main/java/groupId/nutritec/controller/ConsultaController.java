package groupId.nutritec.controller;

import groupId.nutritec.model.Consulta;
import groupId.nutritec.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Consulta> getAllById(@PathVariable String nutritionistId){
        return consultaService.getAllById(nutritionistId);
    }

    @PostMapping
    public Consulta create(@RequestBody Consulta consulta){
        return consultaService.create(consulta);
    }

}
