/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.DAOMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import br.cefetmg.biosit.dto.Triagem;

/**
 *
 * @author joaop
 */
public class TriagemDAO {
  private String driver = "com.mysql.cj.jdbc.Driver";
  private String url = "jdbc:mysql://localhost:3306/triagem2";
  private String user = "root";
  private String password = "joao34376600";

  private Connection conectar() {
    Connection con = null;
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, user, password);
      return con;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public void inserirTriagem(Triagem inserir) {
    String create = "INSERT INTO contatos (nome, dtnasc, cpf, medico, esp, consult, hora_ent, hora_prev, urg) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
      //abrir conexao
      Connection con = conectar();
      //preparar a query create
      PreparedStatement pst = con.prepareStatement(create);
      //substituir os parametros
     pst.setString(1, inserir.getNome());
     pst.setString(2, inserir.getDtnasc());
     pst.setString(3, inserir.getCpf());
     pst.setString(4, inserir.getMedico());
     pst.setString(5, inserir.getEsp());
     pst.setString(6, inserir.getConsult());
     pst.setString(7, inserir.getHora_ent());
     pst.setString(8, inserir.getHora_prev());
     pst.setString(9, inserir.getUrg());
      //ExecutarQuery
      pst.executeUpdate();
      //encerrar conexao
      con.close();
    } catch (Exception e) {

    }

  }
  
  public ArrayList<Triagem> listarContatos() {
      ArrayList<Triagem> contatos = new ArrayList<>();
      String read = "select * from contatos order by idcon";
      
      try {
      //abrir conexao
      Connection con = conectar();
      //preparar a query create
      PreparedStatement pst = con.prepareStatement(read);
      //substituir os parametros
      ResultSet rs = pst.executeQuery();
      while(rs.next()){
          String idcon = rs.getString(1);
          String nome = rs.getString(2);
          String dtnasc = rs.getString(3);
          String cpf = rs.getString(4);
          String medico = rs.getString(5);
          String esp = rs.getString(6);
          String consult = rs.getString(7);
          String hora_ent = rs.getString(8);
          String hora_prev = rs.getString(9);
          String urg = rs.getString(10);
          
          contatos.add(new Triagem(idcon, nome, dtnasc, cpf, medico,
            esp, consult, hora_ent, hora_prev, urg));
      }

      //encerrar conexao
      con.close();
      return contatos;
    } catch (Exception e) {
        return null;

    }
       
  }
  
public void selecionarTriagem(Triagem inserir) {
     
      String read2 = "select * from contatos where idcon = ?";
      
      try {
      //abrir conexao
      Connection con = conectar();
      //preparar a query create
      PreparedStatement pst = con.prepareStatement(read2);
      pst.setString(1, inserir.getIdcon());
      //substituir os parametros
      ResultSet rs = pst.executeQuery();
      while(rs.next()){
          inserir.setNome(rs.getString(2));
          inserir.setDtnasc(rs.getString(3));
          inserir.setCpf(rs.getString(4));
          inserir.setMedico(rs.getString(5));
          inserir.setEsp(rs.getString(6));
          inserir.setConsult(rs.getString(7));
          inserir.setHora_ent(rs.getString(8));
          inserir.setHora_prev(rs.getString(9));
          inserir.setUrg(rs.getString(10));
          
      }

      //encerrar conexao
      con.close();
      
    } catch (Exception e) {
       

    }
       
  }
 public void alterarContato(Triagem inserir) throws SQLException {
    String read2 = "update contatos set nome=?, dtnasc=?, cpf=?, esp=?, urg=? where idcon=?";
    
    try {
        // Abrir conexao
        Connection con = conectar();
        
        // Preparar a query create
        PreparedStatement pst = con.prepareStatement(read2);
        pst.setString(1, inserir.getNome());
        pst.setString(2, inserir.getDtnasc());
        pst.setString(3, inserir.getCpf());
        pst.setString(4, inserir.getEsp());
        pst.setString(5, inserir.getUrg());
        pst.setString(6, inserir.getIdcon());
        
        // Substituir os parametros
        int rowsAffected = pst.executeUpdate();

        // Encerrar conexao
        con.close();
        
        if (rowsAffected <= 0) {
            throw new SQLException("Falha ao atualizar o contato. Nenhuma linha foi afetada.");
        }
    } catch (SQLException e) {
        // Log ou relance a exceção para que o servlet a capture
        throw e;
    } catch (Exception e) {
        e.printStackTrace(); // Log da exceção (pode ser substituído por um framework de log)
        throw new SQLException("Falha ao atualizar o contato.", e);
    }
}
 
  public void excluirTriagem(Triagem inserir) throws SQLException {
    String read2 = "delete from contatos where idcon=?";
    
    try {
        // Abrir conexao
        Connection con = conectar();
        
        // Preparar a query create
        PreparedStatement pst = con.prepareStatement(read2);
        pst.setString(1, inserir.getIdcon());
        
        
        // Substituir os parametros
        int rowsAffected = pst.executeUpdate();

        // Encerrar conexao
        con.close();
        
        if (rowsAffected <= 0) {
            throw new SQLException("Falha ao atualizar o contato. Nenhuma linha foi afetada.");
        }
    } catch (SQLException e){
        // Log ou relance a exceção para que o servlet a capture
        throw e;
    } catch (Exception e) {
        e.printStackTrace(); // Log da exceção (pode ser substituído por um framework de log)
        throw new SQLException("Falha ao atualizar o contato.", e);
    }
}


  //teste de conexao

}