package dao;

import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {

    private Connection conexao;

    public void cadastrarCliente(Cliente cliente){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try {
            String sql = "insert into tbl_cliente( cpf_clie, nm_clie, email_clie, tel_clie ) values (?,?,?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, cliente.getCpf());
            comandoSql.setString(2, cliente.getNome());
            comandoSql.setString(3, cliente.getEmail());
            comandoSql.setString(4, cliente.getTelefone());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
