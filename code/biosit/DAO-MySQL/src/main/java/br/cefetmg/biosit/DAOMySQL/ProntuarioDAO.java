
package br.cefetmg.biosit.DAOMySQL;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.idao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Pedro Gabriel
 */
public class ProntuarioDAO implements IProntuarioDAO {
    
    private final String url;
    private final String password;
    private final String user;
    
    public ProntuarioDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        user = "root";
        password = "";
    }
    
    
    @Override
    public boolean inserir(RegistroProntuario registro) throws Exception {
        String query = "INSERT INTO prontuario (cpf, titulo, dataReg, descricao, tipo) VALUES (?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, registro.getCPF());
            preparedStatement.setString(2, registro.getTitulo());
            preparedStatement.setString(3, registro.getData());
            preparedStatement.setString(4, registro.getDescricao());
            preparedStatement.setString(5, registro.getTipo());
            
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return true;
    }
    @Override
    public boolean atualizar(RegistroProntuario registro) throws Exception {
        String query = "UPDATE prontuario set titulo = ?, tipo = ?, descricao = ? WHERE id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, registro.getTitulo());
            preparedStatement.setString(2, registro.getTipo());
            preparedStatement.setString(3, registro.getDescricao());
            preparedStatement.setInt(4, registro.getID());
            
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return true;
    }
    @Override
    public boolean deletar(int id) throws Exception {
        String query = "DELETE FROM prontuario WHERE id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            int r = preparedStatement.executeUpdate();
            if (!(r > 0)) {
                throw new Exception("Erro. Nenhum registro encontrado");
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o registro: " + e.getMessage());
        }
        return true;
    }
    @Override
    public Prontuario pesquisar(String cpf) throws Exception {
        String query = "SELECT * FROM prontuario WHERE cpf = ?";
        Prontuario pron = new Prontuario();
        pron.setCpf(cpf);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String data = resultSet.getString("dataReg");
                String descricao = resultSet.getString("descricao");
                String tipo = resultSet.getString("tipo");
                int id = resultSet.getInt("id");
                RegistroProntuario novoRegistro = new RegistroProntuario(cpf);
                novoRegistro.setTitulo(titulo);
                novoRegistro.setData(data);
                novoRegistro.setDescricao(descricao);
                novoRegistro.setID(id);
                novoRegistro.setTipo(tipo);
                pron.addRegistro(novoRegistro);
            }
            
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        
        return pron;
    }
    
    public static void main(String[] args) {
        try {
            ProntuarioDAO dao = new ProntuarioDAO();
            RegistroProntuario reg = new RegistroProntuario("12345678900");
            reg.setDescricao("desc teste");
            reg.setTitulo("titulo teste");
            reg.setTipo("Observação");
            reg.setID(12);
            dao.atualizar(reg);
            System.out.println("FUnciona: ");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
