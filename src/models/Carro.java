package models;

import enums.CorEnum;

import java.util.Scanner;

public class Carro {
    protected CorEnum cor;
    private String placa;
    protected String marca;
    protected String modelo;

    public void cadastrarCarro(){
        Scanner leitor = new Scanner(System.in);
        String resposta;
        while (true){
            System.out.println("Qual a cor: \n1 - Vermelho\n2 - Branco\n3 - Preto\n4 - Cinza");
            resposta = leitor.nextLine();
            if (resposta.equals("1")){
                this.cor = CorEnum.VERMELHO;
                break;
            } else if (resposta.equals("2")) {
                this.cor = CorEnum.BRANCO;
                break;
            } else if (resposta.equals("3")) {
                this.cor = CorEnum.PRETO;
                break;
            } else if (resposta.equals("4")) {
                this.cor = CorEnum.CINZA;
                break;
            }else {
                System.out.println("Por Favor Informe uma resposta válida!");
            }
        }
        System.out.println("Qual a placa: ");
        placa = leitor.nextLine();
        System.out.println("Qual a marca: ");
        marca = leitor.nextLine();
        System.out.println("Qual o modelo: ");
        modelo = leitor.nextLine();
    }

    @Override
    public String toString() {
        return String.format("Cor: %s, Placa: %s, Marca: %s, Modelo: %s", cor, placa, marca, modelo);
    }

    //Getters e Setters

    public CorEnum getCor() {
        return cor;
    }

    public void setCor(CorEnum cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
