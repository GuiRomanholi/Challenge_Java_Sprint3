package tests;

import dao.CarroDao;
import dao.ClienteDao;
import models.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ClienteDao dao = new ClienteDao();
        CarroDao carroDao = new CarroDao();

        while (true) {
            System.out.println(
                    """
                   |=======================================|
                   |      M E N U - P R I N C I P A L      |
                   |=======================================|
                   | 1 - Cadastrar Cliente                 |
                   | 2 - Cadastro Carro                    |
                   | 3 - Chamar Guincho                    |
                   | 4 - Dados e Pagamento                 |
                   | 5 - Ver Oficina Direcionada           |
                   | 6 - Resolver Problema                 |
                   | 7 - Listar                            |
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
                dao.cadastrarCliente(cliente);
                System.out.println("Você está Cadastrado!");

            } else if (opcao.equals("2")) {
                System.out.println("Cadastro carro");
                Carro carro = new Carro();
                carro.cadastrarCarro();
                carroDao.cadastrarCarro(carro);
                System.out.println("Seu carro está cadastrado!");

            } else if (opcao.equals("3")) {
                System.out.println("Chamar guincho");
                Guincho guincho = new Guincho();
                guincho.setMarca("Ford");
                guincho.setPlaca("3FGU76");
                guincho.setAno_fabricacao("2000");
                boolean endereco_guin = guincho.acionarGuincho();

                if (endereco_guin) {
                    Endereco endereco = new Endereco();
                    endereco.setCep("08005-078");
                    endereco.setCidade("São Paulo");
                    endereco.setNumero("821");
                    endereco.setEstado("São Paulo");
                    System.out.println(endereco.exibirEndereco());
                    System.out.println("Pressione Enter para continuar");
                    leitor.nextLine();

                } else {
                    System.out.println("Retornando ao Menu Principal...");
                }

            } else if (opcao.equals("4")) {
                System.out.println("Dados do Pedido");
                Pedido pedido = new Pedido();
                LocalTime hora = LocalTime.now();
                LocalDate data = LocalDate.now();

                DateTimeFormatter horaFormatar = DateTimeFormatter.ofPattern("HH:mm");
                String formatadoHora = hora.format(horaFormatar);

                DateTimeFormatter dataFormatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formatadoData = data.format(dataFormatar);
                pedido.setValor(60);
                pedido.setNumero("1");
                pedido.setData(formatadoData);
                pedido.setHora(formatadoHora);
                pedido.dadosPedido();
                pedido.escolherForma();

            } else if (opcao.equals("5")) {
                System.out.println("Ver oficina direcionada");
                Oficina oficina = new Oficina();
                oficina.setCnpj("12.345.678/0001-95");
                oficina.setNome("Paulo Concertos");
                oficina.setRazao_social("Of de Claud.");
                oficina.setContato("(11) 96846-4922");
                System.out.println(oficina.oficinaRecebeuCarro());

            } else if (opcao.equals("6")) {
                System.out.println("Resolver Problema");
                Diagnostico diagnostico = new Diagnostico();
                diagnostico.exibirDiagnostico();

            } else if (opcao.equals("7")) {
                while (true) {
                    System.out.println("""
                        Listar:
                        1 - Clientes
                        2 - Carros
                        0 - Sair
                        Digite a opção desejada:
                        """);
                    String desejo = leitor.nextLine();
                    if (desejo.equals("1")) {
                        List<Cliente> listaCliente = dao.buscarTodosClientes();
                        for (Cliente c : listaCliente) {
                            System.out.println(c);
                            System.out.println("--------------------------------------------");
                        }
                        System.out.println("Pressione Enter para Continuar");
                        leitor.nextLine();
                    } else if (desejo.equals("2")) {
                        List<Carro> listaCarro = carroDao.buscarTodosCarro();
                        for (Carro c : listaCarro) {
                            System.out.println(c);
                            System.out.println("--------------------------------------------");
                        }
                        System.out.println("Pressione Enter para Continuar");
                        leitor.nextLine();
                    } else if (desejo.equals("0")) {
                        System.out.println("Retornando...");
                        break;
                    } else {
                        System.out.println("Por Favor digite uma opção válida");
                        System.out.println("Pressione Enter para Continuar");
                        leitor.nextLine();
                    }
                }

            } else {
                System.out.println("Por Favor digite um valor válido!");
                System.out.println("Pressione Enter para Continuar");
                leitor.nextLine();
            }
        }
    }
}
