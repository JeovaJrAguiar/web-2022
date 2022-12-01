package web.ufc.br.classsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue
    private int codigo;
    private String nome;
    private int creditos;

    public Disciplina(int codigo, String nome, int creditos){
        this.codigo = codigo;
        this.nome = nome;
        this.creditos = creditos;
    }

    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getCreditos(){
        return creditos;
    }

    public void setCreditos(int creditos){
        this.creditos = creditos;
    }
}
