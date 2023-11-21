package br.cefetmg.biosit.DAOMySQL;

import br.cefetmg.biosit.dto.Exame;
import br.cefetmg.biosit.idao.IExameDAO;
import br.cefetmg.biosit.dto.exception.*;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExameDAO implements IExameDAO {

    private final String url;
    private final String password;
    private final String user;

    public ExameDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }

    @Override
    public boolean inserir(Exame exame) throws CadastroException {
        String query = "INSERT INTO exames (exame, paciente, dataHora) VALUES (?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, exame.getExame());
            preparedStatement.setString(2, exame.getPaciente());
            preparedStatement.setString(3, exame.getDataHora());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean atualizar(Exame exame) throws CadastroException {
        String query = "UPDATE exame SET exame = ?, dataHora = ?, WHERE paciente = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, exame.getExame());
            preparedStatement.setString(2, exame.getPaciente());
            preparedStatement.setString(3, exame.getDataHora());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

   
    public boolean deletar(String dataHora) throws Exception {
        String query = "DELETE FROM exames WHERE dataHora = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, dataHora);

            int r = preparedStatement.executeUpdate();
            if (!(r > 0)) {
                throw new Exception("Erro. Nenhum exame encontrado");
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o exame: " + e.getMessage());
        }
        return true;
    }

    @Override
    public List<Exame> pesquisarExame(String nomeExame) throws Exception {
        String query = "SELECT * FROM exame WHERE nomeExame = ?";
        List<Exame> exames = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nomeExame);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Exame exame = new Exame(resultSet.getString("nomeExame"),resultSet.getString("paciente"), resultSet.getString("dataHora"));
                exames.add(exame);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o exame: " + e.getMessage());
        }
        return exames;
    }

    public Exame pesquisarPaciente(String CPFpaciente) throws Exception {
        String query = "SELECT * FROM pacientes WHERE cpf = ?";
        Exame exame = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, CPFpaciente);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                String NomeExame = resultSet.getString("nome");
                String dataHora = resultSet.getString("dataHora");
                exame = new Exame(NomeExame, CPFpaciente, dataHora);
            }
            
            connection.close();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return exame;
    }

    @Override
    public List<Exame> pesquisarDataHora(String dataHora) throws Exception {
        String query = "SELECT * FROM exame WHERE dataHora = ?";
        List<Exame> exames = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(3, dataHora);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Exame exame = new Exame(resultSet.getString("nomeExame"),resultSet.getString("paciente"), resultSet.getString("dataHora"));
                exames.add(exame);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o exame: " + e.getMessage());
        }
        return exames;
    }

    @Override
    public List<Exame> pesquisarTodos() throws Exception {
        String query = "SELECT * FROM exames";
        List<Exame> exames = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Exame exame = new Exame(resultSet.getString("nomeExame"),resultSet.getString("paciente"), resultSet.getString("dataHora"));
                exames.add(exame);
            }
            
            connection.close();
            
        }catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        
        return exames;
    }

    public List<Exame> obterExamesParaSelect(String dataHora, String nome, String cpf, String dataNascimento, String endereco) throws Exception {
        String query = "SELECT * FROM exames WHERE dataHora = ? AND nome = ? AND cpf = ? AND dataNascimento = ? AND endereco = ?";
        List<Exame> exames = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, dataHora);
            preparedStatement.setString(2, nome);
            preparedStatement.setString(3, cpf);
            preparedStatement.setString(4, dataNascimento);
            preparedStatement.setString(5, endereco);
          
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Exame exame = new Exame(resultSet.getString("nomeExame"), resultSet.getString("paciente"), resultSet.getString("dataHora"));
                exames.add(exame);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao obter exames: " + e.getMessage());
        }
        return exames;
    }
