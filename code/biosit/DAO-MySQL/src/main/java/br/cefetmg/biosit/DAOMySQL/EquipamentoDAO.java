package br.cefetmg.biosit.DAOMySQL;

import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.idao.IEquipamentoDAO;
import br.cefetmg.biosit.dto.exception.*;
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
public class EquipamentoDAO implements IEquipamentoDAO {

    private final String url;
    private final String password;
    private final String user;

    public EquipamentoDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }

    @Override
    public boolean inserir(Equipamento equipamento) throws CadastroException {
        String query = "INSERT INTO equipamento (nome, data, quantidade, fornecedora, setor) VALUES (?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, equipamento.getNome());
            preparedStatement.setString(2, equipamento.getData());
            preparedStatement.setInt(3, equipamento.getQuant());
            preparedStatement.setString(4, equipamento.getFornecedora());
            preparedStatement.setString(5, equipamento.getSetor());

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
    public boolean atualizar(Equipamento equipamento) throws CadastroException {
        String query = "UPDATE equipamento SET nome = ?, data = ?, fornecedora = ?, setor = ?, WHERE quantidade = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, equipamento.getNome());
            preparedStatement.setString(2, equipamento.getData());
            preparedStatement.setInt(3,    equipamento.getQuant());
            preparedStatement.setString(4, equipamento.getFornecedora());
            preparedStatement.setString(5, equipamento.getSetor());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean deletar(Equipamento equipamento) throws Exception {
        String query = "DELETE FROM equipamento WHERE nome = ?, data = ?,  quantidade = ?, fornecedora = ?, setor = ?";

        try {
            
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, equipamento.getNome());
            preparedStatement.setString(2, equipamento.getData());
            preparedStatement.setInt(3,    equipamento.getQuant());
            preparedStatement.setString(4, equipamento.getFornecedora());
            preparedStatement.setString(5, equipamento.getSetor());

            int r = preparedStatement.executeUpdate();
            if (!(r > 0)) {
                throw new Exception("Erro. Nenhum equipamento encontrado");
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return true;
    }

    @Override
    public List<Equipamento> pesquisarNome(String nome) throws Exception {
        String query = "SELECT * FROM equipamento WHERE nome = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), resultSet.getString("data"), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }

    public List<Equipamento> pesquisarQuantidade(int quantidade) throws Exception {
        String query = "SELECT * FROM equipamento WHERE quantidade = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, quantidade);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), resultSet.getString("data"), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }

    @Override
    public List<Equipamento> pesquisarFornecedora(String fornecedora) throws Exception {
        String query = "SELECT * FROM equipamento WHERE fornecedora = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, fornecedora);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), resultSet.getString("data"), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }

    @Override
    public List<Equipamento> pesquisarData(String data) throws Exception {
        String query = "SELECT * FROM equipamento WHERE data = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, data.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), resultSet.getString("data"), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }
    public List<Equipamento> pesquisarSetor(String setor) throws Exception {
        String query = "SELECT * FROM equipamento WHERE setor = ?";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, setor);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), resultSet.getString("data"), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            connection.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar o equipamento: " + e.getMessage());
        }
        return equipamentos;
    }
    public List<Equipamento> pesquisarTodos() throws Exception {
        String query = "SELECT * FROM equipamento";
        List<Equipamento> equipamentos = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Equipamento equipamento = new Equipamento(resultSet.getString("nome"), resultSet.getString("data"), resultSet.getInt("quantidade"), resultSet.getString("fornecedora"), resultSet.getString("setor"));
                equipamentos.add(equipamento);
            }
            
            connection.close();
            
        }catch (SQLException e) {
            throw new CadastroException(e.getMessage());
        }
        
        return equipamentos;
    }


}
