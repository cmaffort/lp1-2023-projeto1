/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.DAOMySQL;

import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.idao.IConsultaDAO;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Aluno
 */
public class ConsultaDAO implements IConsultaDAO{
    
    private final String url;
    private final String password;
    private final String user;
    
    public ConsultaDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb?serverTimezone=America/Sao_Paulo";
        password = "";
        user = "root";
    }
    
    @Override
    public boolean inserir(Consulta consulta) throws CadastroException{
        String query = "INSERT INTO consultas (nomePaciente, descricao, urgencia, medico, data, horario) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, consulta.getNomePaciente());
            preparedStatement.setString(2, consulta.getDescricao());
            preparedStatement.setString(3, consulta.getUrgencia());
            preparedStatement.setString(4, consulta.getMedico());
            preparedStatement.setString(5, consulta.getData());
            preparedStatement.setString(6, consulta.getHorario());
            
            preparedStatement.executeUpdate();
            connection.close();
        }catch (SQLException e) {
            /* if(e.getMessage().substring(0, 9).equals("Duplicate")) {
                throw new ConsultaDuplicadoException(consulta.getCPF());
            } */
            throw new CadastroException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }
    
    @Override
    public boolean atualizar(Consulta consulta) throws CadastroException {
    String query = "UPDATE consultas SET descricao = ?, urgencia = ?, medico = ?, data = ?, horario = ? WHERE nomePaciente = ?";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, consulta.getDescricao());
        preparedStatement.setString(2, consulta.getUrgencia());
        preparedStatement.setString(3, consulta.getMedico());
        preparedStatement.setString(4, consulta.getData());
        preparedStatement.setString(5, consulta.getHorario());
        preparedStatement.setString(6, consulta.getNomePaciente()); // Condição de atualização

        preparedStatement.executeUpdate();
        connection.close();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new CadastroException(e.getMessage());
    } catch (ClassNotFoundException e) {
        throw new CadastroException(e.getMessage());
    }
    return true;
}
    
    @Override
    public boolean deletar(String nomePaciente) throws Exception {
            String query = "DELETE FROM consultas WHERE nomePaciente = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nomePaciente);

            int r = preparedStatement.executeUpdate();
            if (!(r > 0)) {
                throw new Exception("Erro. Nenhuma consulta encontrada");
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar a consulta: " + e.getMessage());
        }
        return true;
    }
    
    @Override
    public List<Consulta> pesquisarTodos() throws Exception {
        String query = "SELECT * FROM consultas";
        List<Consulta> consultas = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Consulta consulta = new Consulta(resultSet.getString("nomePaciente"),resultSet.getString("descricao"),resultSet.getString("urgencia"),resultSet.getString("medico"),
                resultSet.getString("data"),resultSet.getString("horario"));
                consultas.add(consulta);
            }
            
            connection.close();
            
        }catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        
        return consultas;
    }
    
    @Override
    public List<Consulta> pesquisarListaNomePaciente(String nomePaciente) throws Exception {
        String query = "SELECT * FROM consultas WHERE nomePaciente = ?";
        List<Consulta> consultas = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nomePaciente);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Consulta consulta = new Consulta(resultSet.getString("nomePaciente"),resultSet.getString("descricao"),resultSet.getString("urgencia"),resultSet.getString("medico"),
                resultSet.getString("data"),resultSet.getString("horario"));
                consultas.add(consulta);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return consultas;
    }
    
    @Override
    public Consulta pesquisarNomePaciente(String nome) throws Exception {
        String query = "SELECT * FROM consultas WHERE nomePaciente = ?";
        Consulta consulta = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                String nomePaciente = resultSet.getString("nomePaciente");
                String descricao = resultSet.getString("descricao");
                String urgencia = resultSet.getString("urgencia");
                String medico = resultSet.getString("medico");
                String data = resultSet.getString("data");
                String horario = resultSet.getString("horario");
                consulta = new Consulta(nomePaciente, descricao, urgencia, medico, data, horario);
            }
            
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return consulta;
    }
    
    @Override
    public List<Consulta> pesquisarData(String data) throws Exception {
        String query = "SELECT * FROM consultas WHERE data = ?";
        List<Consulta> consultas = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, data);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Consulta consulta = new Consulta(resultSet.getString("nomePaciente"),resultSet.getString("descricao"),resultSet.getString("urgencia"),resultSet.getString("medico"),
                resultSet.getString("data"),resultSet.getString("horario"));
                consultas.add(consulta);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return consultas;
    }
    
    @Override
    public List<Consulta> pesquisarHorario(String horario) throws Exception {
        String query = "SELECT * FROM consultas WHERE horario = ?";
        List<Consulta> consultas = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, horario);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Consulta consulta = new Consulta(resultSet.getString("nomePaciente"),resultSet.getString("descricao"),resultSet.getString("urgencia"),resultSet.getString("medico"),
                resultSet.getString("data"),resultSet.getString("horario"));
                consultas.add(consulta);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return consultas;
    }
    
    @Override
    public List<Consulta> pesquisarListaNomeMedico(String medico) throws Exception {
        String query = "SELECT * FROM consultas WHERE nomeMedico = ?";
        List<Consulta> consultas = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, medico);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Consulta consulta = new Consulta(resultSet.getString("nomePaciente"),resultSet.getString("descricao"),resultSet.getString("urgencia"),resultSet.getString("medico"),
                resultSet.getString("data"),resultSet.getString("horario"));
                consultas.add(consulta);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return consultas;
    }
    
    @Override
    public Consulta pesquisarNomeMedico(String nome) throws Exception {
        String query = "SELECT * FROM consultas WHERE nomeMedico = ?";
        Consulta consulta = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                String nomePaciente = resultSet.getString("nomePaciente");
                String descricao = resultSet.getString("descricao");
                String urgencia = resultSet.getString("urgencia");
                String medico = resultSet.getString("medico");
                String data = resultSet.getString("data");
                String horario = resultSet.getString("horario");
                consulta = new Consulta(nomePaciente, descricao, urgencia, medico, data, horario);
            }
            
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return consulta;
    }
    
    public static void main(String[] args) {
        try {
            String nomePaciente = "Cristiano Maffort";
            ConsultaDAO q = new ConsultaDAO();
            Consulta p = q.pesquisarNomePaciente(nomePaciente);
            System.out.println(p);
        } catch(Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
}
