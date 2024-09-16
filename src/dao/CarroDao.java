package dao;
import enums.CorEnum;
import models.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDao {

    private Connection conexao;
    public void cadastrarCarro(Carro carro){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try {
            String sql = "insert into tbl_carro( placa_car, cor_car, marca_car, modelo_car ) values (?,?,?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, carro.getPlaca());
            comandoSql.setString(2, carro.getCor().toString());
            comandoSql.setString(3, carro.getMarca());
            comandoSql.setString(4, carro.getModelo());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Carro> buscarTodosCarro(){
        List<Carro> carros = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = ConnectionFactory.obterConexao();
        try{
            comandoSql = conexao.prepareStatement("Select * from tbl_carro ");
            ResultSet rs = comandoSql.executeQuery();
            while(rs.next()){
                Carro carro = new Carro();
                carro.setPlaca(rs.getString(1));
                carro.setCor(CorEnum.valueOf(rs.getString(2)));
                carro.setMarca(rs.getString(3));
                carro.setModelo(rs.getString(4));

                carros.add(carro);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return carros;
    }
}
