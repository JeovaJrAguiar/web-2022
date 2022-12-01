package web.ufc.br.classsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.ufc.br.classsystem.model.Aluno;
import web.ufc.br.classsystem.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    
    @Autowired
    AlunoService alunoService;

    @GetMapping
    List<Aluno> getAlunos(){
        return alunoService.getAlunos();
    }

    @PostMapping
    void addAluno(@RequestBody Aluno aluno){
        AlunoService.addAluno(aluno);
    }
}
