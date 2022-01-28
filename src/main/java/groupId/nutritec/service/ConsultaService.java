package groupId.nutritec.service;

import groupId.nutritec.model.Consulta;
import groupId.nutritec.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getAll() {
        return consultaRepository.findAll();
    }

    public List<Consulta> getAllById(String nutritionistId){
        return consultaRepository.findAllByNutritionistId(nutritionistId);
    }

    public Consulta create(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta update(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public void delete(String id){
        consultaRepository.deleteById(id);
    }
}
