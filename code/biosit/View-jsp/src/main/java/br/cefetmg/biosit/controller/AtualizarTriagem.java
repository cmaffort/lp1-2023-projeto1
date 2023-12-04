/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.biosit.controller;

import br.cefetmg.biosit.DAOMySQL.TriagemDAO;
import br.cefetmg.biosit.dto.Triagem;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author joaop
 */
@WebServlet(name = "AtualizarTriagem", urlPatterns = {
  "/AtualizarTriagem"
})
public class AtualizarTriagem extends HttpServlet {
  TriagemDAO dao = new TriagemDAO();

  Triagem inserir = new Triagem();

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String action = request.getServletPath();

    inserir.setNome(request.getParameter("nome"));
    inserir.setDtnasc(request.getParameter("dtnasc"));

    inserir.setCpf(request.getParameter("cpf"));

    inserir.setEsp(request.getParameter("esp"));

    inserir.setUrg(request.getParameter("urg"));
    inserir.setIdcon(request.getParameter("idcon"));

    try {
      // Seu código aqui

      dao.alterarContato(inserir);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/ExibirTriagem");
      dispatcher.forward(request, response);

    } catch (SQLException e) {
      e.printStackTrace(); // Log da exceção (pode ser substituído por um framework de log)
      // Adicione uma mensagem de erro ao request para exibição no JSP, por exemplo:
      out.println("Erro ao atualizar o contato: " + e.getMessage());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // </editor-fold>

  }
}