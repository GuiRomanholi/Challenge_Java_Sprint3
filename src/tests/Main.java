package tests;

import models.Carro;
import models.Cliente;
import models.Guincho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNum = new Scanner(System.in);
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        ArrayList<Carro> listaCarro = new ArrayList<>();

        while (true) {
            System.out.println(
                    """
                   
                   |=======================================|
                   |      M E N U - P R I N C I P A L      |
                   |=======================================|
                   | 1 - Cadastrar Cliente                 |
                   | 2 - Cadastro Carro                    |
                   | 3 - Chamar Guincho                    |
                   | 4 - Ver Detalhes Endereço             |
                   | 5 - Dados do Pedido                   |
                   | 6 - Forma de Pagamento                |
                   | 7 - Ver Oficina Direcionada           |
                   | 8 - Resolver Problema                 |
                   | 9 - Listar                            |
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
                Cliente cliente = new Cliente();
                cliente.cadastrarCliente();
                listaCliente.add(cliente);
                System.out.println("Você está Cadastrado!");

            } else if (opcao.equals("2")) {
                System.out.println("Cadastro carro");
                Carro carro = new Carro();
                carro.cadastrarCarro();
                listaCarro.add(carro);
                System.out.println("Seu carro está cadastrado!");

            } else if (opcao.equals("3")) {
                System.out.println("Chamar guincho");
                Guincho guincho = new Guincho();
                guincho.setMarca("Ford");
                guincho.setPlaca("3FGU76");
                guincho.setAno_fabricacao("2000");
                guincho.acionarGuincho();

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
                while (true){
                    System.out.println("""
                        Listar:
                        1 - Clientes
                        2 - Carros
                        0 - Sair
                        Digite a opção desejada:
                        """);
                    String desejo = leitor.nextLine();
                    if (desejo.equals("1")){
                        for (Cliente c : listaCliente) {
                            System.out.println(c);
                            System.out.println("--------------------------------------------");
                        }
                        System.out.println("De Enter para Continuar");
                        leitor.nextLine();
                    } else if (desejo.equals("2")) {
                        for (Carro c : listaCarro) {
                            System.out.println(c);
                            System.out.println("--------------------------------------------");
                        }
                        System.out.println("De Enter para Continuar");
                        leitor.nextLine();
                    } else if (desejo.equals("0")) {
                        System.out.println("Retornando...");
                        break;
                    } else {
                        System.out.println("Por Favor digite uma opção válida");
                        System.out.println("De Enter para Continuar");
                        leitor.nextLine();
                    }
                }

            } else {
                System.out.println("Por Favor digite um valor válido!");
                System.out.println("De Enter para Continuar");
                leitor.nextLine();
            }
        }
    }
}
