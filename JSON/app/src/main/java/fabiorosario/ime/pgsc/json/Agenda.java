package fabiorosario.ime.pgsc.json;

import java.io.Serializable;

public class Agenda implements Serializable {
    private String nome;
    private String telefone;

    public Agenda(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public Agenda(){

    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

}
