package models;

import models.enums.FrmPagamentoEnum;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Pedido {
    private LocalTime hora;
    private LocalDate data;
    private String numero;
    private double valor;

    public double fazerDesconto() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("O valor atual é de " + getValor());
        System.out.println("Deseja um desconto? 1 = Sim / 2 = Não");
        String opcao = leitor.nextLine();
        if (opcao.equals("1")) {
            double desconto = 10;
            this.valor = valor - desconto;
        } else if (opcao.equals("2")) {
            System.out.println("Muito Bem!");
            this.valor = valor;
        }
        return valor;
    }

    public void dadosPedido() {
        System.out.println("O seu pedido de número " + this.numero +
                " foi registrado, seu pedido foi feito às " + this.hora +
                " no dia " + this.data);
    }

    public void escolherForma() {
        Scanner leitor = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma das opções de pagamento pelo número entre ()");
            System.out.println("1 - Pix\n2 - Cartão de Débito\n3 - Cartão de Crédito\n0 - Sair");
            String opcao = leitor.nextLine();
            FrmPagamentoEnum pagamento = null;
            if (opcao.equals("1")) {
                pagamento = FrmPagamentoEnum.PIX;
                System.out.println("Será gerado o código em " + pagamento);
                break;

            } else if (opcao.equals("2")) {
                pagamento = FrmPagamentoEnum.C_DEBITO;
                System.out.println("Será gerado o código em " + pagamento);
                break;

            } else if (opcao.equals("3")) {
                pagamento = FrmPagamentoEnum.C_CREDITO;
                System.out.println("Será gerado o código em " + pagamento);
                break;

            } else if (opcao.equals("0")) {
                System.out.println("Retornando...");
                break;
            } else {
                System.out.println("Por favor insira uma opção válida!");
            }
        }
    }

    // Getters e Setters

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
