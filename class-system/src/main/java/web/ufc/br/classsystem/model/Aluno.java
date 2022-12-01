package web.ufc.br.classsystem.model;

import java.util.Date;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Aluno {
    @Id
    @GeneratedValue
    private int matricula;
    private String nome;
    private String email;
    private String telefone;
    private Date dataNasc;
    @Embedded
    private Endereco endereco;
    @ManyToMany
    private Turma turma;
    

    public Aluno(int matricula, String nome, String email, String telefone, Date dataNasc, Endereco endereco){
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
    }

    public int getMatricula() {
        return matricula;
    }
    
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public Date getDatanasc() {
        return dataNasc;
    }

    public void setDatanasc(Date dataNasc){
        this.dataNasc = dataNasc;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }   
}


