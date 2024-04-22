package model;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.UUID;

public class Pessoa implements Serializable {



    private static int contador = 0;
    private int id;
    private String nome;

    //Métodos


    public Pessoa(String nome){
        this.setNome(nome);
        contador++;
        id = contador;
        
    }
    public void exibirInformacoes() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
    }
    private void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }


    public int getId(){
        return this.id;
        
    }
}
