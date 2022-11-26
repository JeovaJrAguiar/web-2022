package web.ufc.br.classsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import web.ufc.br.classsystem.model.Aluno;
import web.ufc.br.classsystem.model.Turma;

@Service
public class TurmaService {
    
    private List<Turma> turmas = new ArrayList<Turma>();

    public List<Turma> getTurmas() {
            List<Turma> buscaTurmas = new ArrayList<Turma>();
            for (Turma turma : turmas) {
                    buscaTurmas.add(turma);
            }
            return buscaTurmas;
    }

    public Turma getTurma(int codigo) {
        for (Turma turma : turmas) {
            if(turma.getCodigo() == codigo)
                return turma;
        }
        return null;
    }

    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

    public void updateTurma(int codigo, Turma turmaNova) {
        for (Turma turma : turmas) {
            if(turma.getCodigo() == codigo)
            {
                turma.setDisciplina(turmaNova.getDisciplina());
                turma.setSemestre(turmaNova.getSemestre());
                turma.setAlunos(turmaNova.getAlunos());
                return;
            }
        }
    }

    public void deleteTurma(int codigo) {
        for (int i = 0; i < turmas.size(); i++) {
            Turma t = turmas.get(i);
            if(t.getCodigo() == codigo){
                turmas.remove(t);
            }
        }
    }

    public List<Aluno> getAlunosbyIdTurma(int codigo) {
        if(codigo != 0){
            List<Aluno> buscaAlunos = new ArrayList<Aluno>();

            for (Turma turma : turmas) {
                if(turma.getCodigo() == codigo)
                buscaAlunos = turma.getAlunos();
            }

            return buscaAlunos;
        } else return null;
    }

    // INCOMPLETO
    public void addAlunoByCodigoTurma(int codigo) {
        if(codigo != 0){
            List<Aluno> buscaAlunos = new ArrayList<Aluno>();

            for (Turma turma : turmas) {
                if(turma.getCodigo() == codigo)
                    buscaAlunos = turma.getAlunos();
            }

        } else return;
    }

    public void deleteAlunoByCodigoTurma(int codigo, int matricula) {
        if(codigo <= 0 && matricula <= 0){

            for (Turma turma : turmas) {
                if(turma.getCodigo() == codigo){
                    for( Aluno aluno : turma.getAlunos() ){
                        if(aluno.getMatricula() == matricula){
                            turma.deleteAlunoByMatricula(aluno.getMatricula());
                            return;
                        }
                    }
                }
            }

        } else return;
    }
}
