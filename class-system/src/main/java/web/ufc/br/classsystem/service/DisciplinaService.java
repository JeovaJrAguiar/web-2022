package web.ufc.br.classsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import web.ufc.br.classsystem.model.Disciplina;

@Service
public class DisciplinaService {

    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public List<Disciplina> getDisciplinas() {
        List<Disciplina> buscaDisciplinas = new ArrayList<Disciplina>();
            for (Disciplina disciplina : disciplinas) {
                buscaDisciplinas.add(disciplina);
            }
            return buscaDisciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
    
}
