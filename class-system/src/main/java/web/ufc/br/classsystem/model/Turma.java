package web.ufc.br.classsystem.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Turma {    
    @Id
    @GeneratedValue
    private int codigo;
    private String disciplina;
    private int semestre;
    private List<Aluno> alunos;
    private List<Date> horarios;
    @ManyToMany
    private Aluno aluno;
    @ManyToAny
    private Disciplina disciplinas;

    public Turma(int codigo, String disciplina, int semestre, List<Aluno> alunos) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.alunos = alunos;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDisciplina(){
        return disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    public int getSemestre(){
        return semestre;
    }

    public void setSemestre(int semestre){
        this.semestre = semestre;
    }

    public List<Aluno> getAlunos(){
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos){
        this.alunos = alunos;
    }

    public List<Date> getHorarios(){
        return horarios;
    }

    public void setHorarios(List<Date> horarios){
        this.horarios = horarios;
    }

    public int deleteAlunoByMatricula(int matricula){
        int aux = 0;
        for(Aluno aluno : this.alunos){
            if(aluno.getMatricula() == matricula){
                this.alunos.remove(aluno);
                aux = 1;
            }
        }
        return aux;
    }
}
