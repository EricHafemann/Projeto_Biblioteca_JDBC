package org.example.dao;
import org.example.config.ConnectionFactory;
import org.example.model.Usuario;

import java.sql.*;

public class UsuarioDAO {

    public void inserir(Usuario usuario) throws SQLException {

        String querySQL = "insert into usuarios (nome_usuario, username_usuario, senha_usuario, tipo_usuario) values (?, ?, ?, ?)";

        try(Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(querySQL, Statement.RETURN_GENERATED_KEYS))
        {
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getUsername());
                stmt.setString(3, usuario.getSenha());
                stmt.setString(4, usuario.getTipoUsuario());

                stmt.executeUpdate();

                try(ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next())
                    {
                            usuario.setId(rs.getInt(1));
                    }
                }
                 }
        catch (SQLException e) {
            throw new SQLException("Erro ao inserir usuário", e);
        }
    }


}
