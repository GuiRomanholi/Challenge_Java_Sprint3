package dao;
import models.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
