package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable{
    

    
    private String cpf;
    private int idade;

    public PessoaFisica (String nome, String cpf, int idade){
        super(nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    private void  setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return cpf;
    }


    private void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return idade;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); 
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    }

}
