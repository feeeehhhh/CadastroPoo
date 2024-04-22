package model;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable{


    private String cnpj;

    public PessoaJuridica(String nome,String cnpj){
        super(nome);
        this.cnpj=cnpj;
    }
    private void setCnpj(String cnpj){
        this.cnpj=cnpj;
    }
    public String getCnpj(){
        return cnpj;
    }
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); // Chama o método exibirInformacoes da superclasse Pessoa
        System.out.println("CNPJ: " + cnpj);
        }
}
