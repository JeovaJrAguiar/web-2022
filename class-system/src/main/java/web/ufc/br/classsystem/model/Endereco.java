package web.ufc.br.classsystem.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Entity
@Embeddable
public class Endereco {
    
    private char estado;
    private String cidade;
    private String logradouro;
    private String numero;
    private int cep;

    public Endereco(char estado, String cidade, String logradouro, String numero, int cep){
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }

    public char getEstado(){
        return estado;
    }

    public void setEstado(char estado){
        this.estado = estado;
    }

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String  getLogradouro(){
        return logradouro;
    }

    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public int getCep(){
        return cep;
    }

    public void setCep(int cep){
        this.cep = cep;
    }
}
