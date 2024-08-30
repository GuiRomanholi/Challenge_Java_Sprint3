package models;

import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;


    public void cadastrarCliente(List<String> listaCliente){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o seu nome: ");
        nome = leitor.nextLine();
        System.out.println("Qual o seu cpf: ");
        cpf = leitor.nextLine();
        System.out.println("Quakl o seu telefone: ");
        telefone = leitor.nextLine();
        System.out.println("Qual o seu email: ");
        email = leitor.nextLine();

        listaCliente.add(nome);
        listaCliente.add(cpf);
        listaCliente.add(telefone);
        listaCliente.add(email);
        System.out.println("Você está Cadastrado!");
    }



    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
