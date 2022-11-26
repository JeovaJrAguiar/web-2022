package web.ufc.br.classsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
    
}
