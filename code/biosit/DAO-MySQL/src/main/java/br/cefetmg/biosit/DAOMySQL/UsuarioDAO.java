package br.cefetmg.biosit.DAOMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import br.cefetmg.biosit.dto.Usuario;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.cefetmg.biosit.idao.*;

public class UsuarioDAO implements IUsuarioDAO {
    private final String url;
    private final String password;
    private final String user;

    public UsuarioDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }        

    public Usuario autenticacaoUsuario(Usuario usuario) throws Exception {
        String query = "SELECT * FROM usuario where nomeUsuario = ? and senhaUsuario = ? ";

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNomeUsuario());
        preparedStatement.setString(2, usuario.getSenhaUsuario());

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            int idUsuario = rs.getInt("idUsuario");
            String tipoUsuario = rs.getString("tipoUsuario");
            Usuario usuarioLogado = new Usuario(idUsuario, tipoUsuario, "", "");
            return usuarioLogado;
        } else {
            throw new Exception("Usuário ou senha incorretos");
        }
        } catch(SQLException e){
            throw new Exception(e.getMessage());
        }     
    }
}