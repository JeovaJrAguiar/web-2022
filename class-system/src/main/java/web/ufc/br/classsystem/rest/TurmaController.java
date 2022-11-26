package web.ufc.br.classsystem.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import web.ufc.br.classsystem.model.Aluno;
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
    Turma getTurma(@PathVariable String codigo){
        return turmaService.getTurma(Integer.parseInt(codigo));
    }
    
    @PostMapping
    void addTurma(@RequestBody Turma turma){
        turmaService.addTurma(turma);
    }

    @PutMapping(path = "/{codigo}")
    void updateTurma(@PathVariable String codigo, @RequestBody Turma turma){
        turmaService.updateTurma(Integer.parseInt(codigo), turma);
    }

    @DeleteMapping(path = "/{codigo}")
    void deleteTurma(@PathVariable String codigo){
        turmaService.deleteTurma(Integer.parseInt(codigo));
    }

    @GetMapping(path = "/{id}/alunos")
    List<Aluno> getAlunosbyIdTurma(@PathVariable String codigo){
        return turmaService.getAlunosbyIdTurma(Integer.parseInt(codigo));
    }

    @PostMapping
    void addAlunoByCodigoTurma(@RequestBody String codigo){
        turmaService.addAlunoByCodigoTurma(Integer.parseInt(codigo));
    }

    @DeleteMapping(path = "/{codigo}/alunos/{matricula}")
    void deleteAlunoByCodigoTurma(@PathVariable String codigo, String matricula){
        turmaService.deleteAlunoByCodigoTurma(Integer.parseInt(codigo), Integer.parseInt(matricula));
    }
}
