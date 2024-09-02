package models;

public class Diagnostico extends Pedido{

    private String descricaoSintoma;

    //Getters e Setters

    public String getDescricaoSintoma() {
        return descricaoSintoma;
    }

    public void setDescricaoSintoma(String descricaoSintoma) {
        this.descricaoSintoma = descricaoSintoma;
    }
}
