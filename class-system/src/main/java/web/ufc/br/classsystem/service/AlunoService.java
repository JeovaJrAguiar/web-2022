package web.ufc.br.classsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import web.ufc.br.classsystem.model.Aluno;

@Service
public class AlunoService {

    private static List<Aluno> alunos = new ArrayList<Aluno>();

    public List<Aluno> getAlunos() {
        List<Aluno> buscaAlunos = new ArrayList<Aluno>();
            for (Aluno aluno : alunos) {
                buscaAlunos.add(aluno);
            }
            return buscaAlunos;
    }

    public static void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    
}
