package org.example.dao;
import org.example.config.ConnectionFactory;
import org.example.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

                try(ResultSet rs = stmt.getGeneratedKeys())
                {
                    if (rs.next())
                    {
                            usuario.setId(rs.getInt(1));
                    }
                }
                 }
        catch (SQLException e)
        {
            throw new SQLException("Erro ao inserir usuário", e);
        }
    }

    public Usuario buscarPorId(int id) throws SQLException {
        String querySQL = "SELECT id_usuario, nome_usuario, username_usuario, senha_usuario, tipo_usuario FROM usuarios WHERE id_usuario = ?";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(querySQL)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNome(rs.getString("nome_usuario"));
                    usuario.setUsername(rs.getString("username_usuario"));
                    usuario.setSenha(rs.getString("senha_usuario"));
                    usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                    return usuario;
                }
            }
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao buscar usuário com o ID: " + id, e);
        }
        return null;
    }

    public Usuario buscarPorUsername(String username) throws SQLException {
        String querySQL = "select id_usuario, nome_usuario, username_usuario, senha_usuario, tipo_usuario from usuarios where username_usuario = ?";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(querySQL)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNome(rs.getString("nome_usuario"));
                    usuario.setUsername(rs.getString("username_usuario"));
                    usuario.setSenha(rs.getString("senha_usuario"));
                    usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar usuário com username: " + username, e);
        }

        return null;
    }

    public List<Usuario> buscarTodos() throws SQLException {
        String querySQL = "select id_usuario, nome_usuario, username_usuario, senha_usuario, tipo_usuario from usuarios";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(querySQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setUsername(rs.getString("username_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar todos os usuários", e);
        }

        return usuarios;
    }

    public boolean atualizar(Usuario usuario) throws SQLException {
        String querySQL = "update usuarios set nome_usuario = ?, username_usuario = ?, senha_usuario = ?, tipo_usuario = ? where id_usuario = ?";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(querySQL)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsername());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTipoUsuario());
            stmt.setInt(5, usuario.getId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar usuário com ID: " + usuario.getId(), e);
        }
    }

    public boolean deletar(int id) throws SQLException {
        String querySQL = "delete from usuarios where id_usuario = ?";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(querySQL)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar usuário com ID: " + id, e);
        }
    }



}
