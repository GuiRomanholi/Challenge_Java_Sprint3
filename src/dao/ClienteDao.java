package dao;

import enums.CorEnum;
import models.Carro;
import models.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Cliente> buscarTodosClientes(){
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = ConnectionFactory.obterConexao();
        try{
            comandoSql = conexao.prepareStatement("Select * from tbl_cliente ");
            ResultSet rs = comandoSql.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString(1));
                cliente.setNome(rs.getString(2));
                cliente.setEmail(rs.getString(3));
                cliente.setTelefone(rs.getString(4));

                clientes.add(cliente);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }
}
