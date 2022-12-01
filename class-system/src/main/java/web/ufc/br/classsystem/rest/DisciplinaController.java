package web.ufc.br.classsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.ufc.br.classsystem.model.Disciplina;
import web.ufc.br.classsystem.service.DisciplinaService;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @GetMapping
    List<Disciplina> getDisciplinas(){
        return disciplinaService.getDisciplinas();
    }

    @PostMapping
    void addDisciplina(@RequestBody Disciplina disciplina){
        disciplinaService.addDisciplina(disciplina);
    }
}
