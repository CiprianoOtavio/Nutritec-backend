package groupId.nutritec.controller;

import groupId.nutritec.model.Patient;
import groupId.nutritec.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patients")
@RequiredArgsConstructor

public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAll(){
        return patientService.getAll();
    }

    @GetMapping("/{CPF}")
    public Patient findByCPF(@PathVariable String CPF) {
        return patientService.findByCPF(CPF);
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient){
        return patientService.create(patient);
    }

    @DeleteMapping("/{CPF}")
    public void delete(@PathVariable String CPF){
        patientService.delete(CPF);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient){
        return patientService.update(patient);
    }

}
