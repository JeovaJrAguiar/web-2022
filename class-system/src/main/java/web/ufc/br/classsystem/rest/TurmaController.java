package web.ufc.br.classsystem.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.ufc.br.classsystem.model.Turma;
import web.ufc.br.classsystem.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;
    
    @GetMapping
    List<Turma> getTurmas(){
        return turmaService.getTurmas();
    }

    @GetMapping(path = "/{codigo}")
    Turma getTurma(@PathVariable String id){
        return turmaService.getTurma(Integer.parseInt(id));
    }
}
