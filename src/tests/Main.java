package tests;

import models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        Cliente cliente = new Cliente();

        while (true) {
            System.out.println(
                    """
                   
                   |=======================================|
                   |      M E N U - P R I N C I P A L      |
                   |=======================================|
                   | 1 - Cadastrar Cliente                 |
                   | 2 - Ver Detalhes Carro                |
                   | 3 - Chamar Guincho                    |
                   | 4 - Ver Detalhes Endereço             |
                   | 5 - Dados do Pedido                   |
                   | 6 - Forma de Pagamento                |
                   | 7 - Ver Oficina Direcionada           |
                   | 8 - Resolver Problema                 |
                   | 0 - Sair                              |
                   |=======================================|
                   Digite a opção desejada:\s"""
            );
            String opcao = leitor.nextLine();

            if (opcao.equals("0")) {
                System.out.println("Até Breve!");
                break;

            } else if (opcao.equals("1")) {
                System.out.println("Bem Vindo ao Cadastrar Cliente");
                cliente.cadastrarCliente();
                listaCliente.add(cliente);
                System.out.println(listaCliente);
                System.out.println("Você está Cadastrado!");

            } else if (opcao.equals("2")) {
                System.out.println("Ver detalhes carro");

            } else if (opcao.equals("3")) {
                System.out.println("Chamar guincho");

            } else if (opcao.equals("4")) {
                System.out.println("Ver detalhe endereço");

            } else if (opcao.equals("5")) {
                System.out.println("Dados pedido");

            } else if (opcao.equals("6")) {
                System.out.println("Forma Pagamento");

            } else if (opcao.equals("7")) {
                System.out.println("Ver oficina direcionada");

            } else if (opcao.equals("8")) {
                System.out.println("Resolver Problema");

            } else if (opcao.equals("9")) {
                System.out.println("Lista de Clientes Cadastrados:");
                //Aqui Ta Errado, não ta rodando todos os cadastrados qualquer coisa so tira.
                for (Cliente c : listaCliente) {
                    System.out.println(c);
                }

            } else {
                System.out.println("Por Favor digite um valor válido!");
            }
        }
    }
}
