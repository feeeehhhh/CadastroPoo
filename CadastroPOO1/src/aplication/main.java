package aplication;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridicaRepo;
import model.PessoaJuridica;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        int opcao;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Escolha o tipo (1 - Pessoa Física, 2 - Pessoa Jurídica):");
                    int tipo = scanner.nextInt();
                    if (tipo == 1) {
                        adicionarPessoaFisica(scanner, pessoaFisicaRepo);
                    } else if (tipo == 2) {
                        adicionarPessoaJuridica(scanner, pessoaJuridicaRepo);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 2:
                    System.out.println("Informe o ID da pessoa a ser alterada:");
                    int idAlteracao = scanner.nextInt();
                    PessoaFisica pessoaFisicaAlteracao = pessoaFisicaRepo.obter(idAlteracao);
                    if (pessoaFisicaAlteracao != null) {
                        // Solicitar novos dados para a pessoa física
                        System.out.println("Informe o novo nome:");
                        String novoNome = scanner.next();
                        System.out.println("Informe o novo CPF:");
                        String novoCPF = scanner.next();
                        System.out.println("Informe a nova idade:");
                        int novaIdade = scanner.nextInt();
                        // Atualizar os dados da pessoa física
                        pessoaFisicaAlteracao.setNome(novoNome);
                        pessoaFisicaAlteracao.setCpf(novoCPF);
                        pessoaFisicaAlteracao.setIdade(novaIdade);
                        // Salvar as alterações
                        pessoaFisicaRepo.alterar(pessoaFisicaAlteracao);
                        System.out.println("Pessoa física alterada com sucesso!");
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Informe o ID da pessoa a ser excluída:");
                    int idExclusao = scanner.nextInt();
                    pessoaFisicaRepo.excluir(idExclusao);
                    System.out.println("Pessoa excluída com sucesso!");
                    break;

                case 4:
                    System.out.println("Informe o ID da pessoa a ser exibida:");
                    int idExibicao = scanner.nextInt();
                    PessoaFisica pessoaExibicao = pessoaFisicaRepo.obter(idExibicao);
                    if (pessoaExibicao != null) {
                        pessoaExibicao.exibirInformacoes(); // Método para exibir as informações da pessoa
                    } else {
                        System.out.println("Pessoa não encontrada.");
                    }
                    break;

                case 5:
                    System.out.println("Pessoas Físicas:");
                    List<PessoaFisica> todasPessoasFisicas = pessoaFisicaRepo.obterTodos();
                    for (PessoaFisica pessoa : todasPessoasFisicas) {
                        pessoa.exibirInformacoes();
                    }

                    System.out.println("Pessoas Jurídicas:");
                    List<PessoaJuridica> todasPessoasJuridicas = pessoaJuridicaRepo.obterTodos();
                    for (PessoaJuridica pessoa : todasPessoasJuridicas) {
                        pessoa.exibirInformacoes();
                    }
                    break;

                case 6:
                    try {
                        pessoaFisicaRepo.persistir("pessoasFisicas.dat");
                        pessoaJuridicaRepo.persistir("pessoasJuridicas.dat");
                        System.out.println("Dados salvos com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        pessoaFisicaRepo.recuperar("pessoasFisicas.dat");
                        pessoaJuridicaRepo.recuperar("pessoasJuridicas.dat");
                        System.out.println("Dados recuperados com sucesso!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Finalizando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarPessoaFisica(Scanner scanner, PessoaFisicaRepo repo) {
        System.out.println("Informe o nome:");
        String nome = scanner.next();
        System.out.println("Informe o CPF:");
        String cpf = scanner.next();
        System.out.println("Informe a idade:");
        int idade = scanner.nextInt();
        PessoaFisica pessoaFisica = new PessoaFisica(nome, cpf, idade);
        repo.inserir(pessoaFisica);
        System.out.println("Pessoa física adicionada com sucesso!");
    }

    private static void adicionarPessoaJuridica(Scanner scanner, PessoaJuridicaRepo repo) {
        System.out.println("Informe o nome:");
        String nome = scanner.next();
        System.out.println("Informe o CNPJ:");
        String cnpj = scanner.next();
        PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, cnpj);
        repo.inserir(pessoaJuridica);
        System.out.println("Pessoa jurídica adicionada com sucesso!");
    }

}