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

/**
 *
 * @author joaop
 */
@WebServlet(name = "SelecionarTriagem", urlPatterns = {"/editarcontato", "/apagarcontato",
  "/SelecionarTriagem"
})
public class SelecionarTriagem extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String action = request.getServletPath();

    TriagemDAO dao = new TriagemDAO();
    Triagem inserir = new Triagem();

    ArrayList < Triagem > lista = dao.listarContatos();

    request.setAttribute("contatos", lista);
    String idcon = request.getParameter("idcon");

    inserir.setIdcon(idcon);

    dao.selecionarTriagem(inserir);

    request.setAttribute("nomemodal", inserir.getNome());
    request.setAttribute("espmodal", inserir.getEsp());
    request.setAttribute("cpfmodal", inserir.getCpf());
    request.setAttribute("dtnascmodal", inserir.getDtnasc());
    request.setAttribute("urgmodal", inserir.getUrg());
    request.setAttribute("idconmodal", inserir.getIdcon());
    
    if(action.equals("/editarcontato")){
    request.setAttribute("Modal", true);
    request.setAttribute("Modalapagar", false);
    RequestDispatcher dispatcher = request.getRequestDispatcher("triagem.jsp");
    dispatcher.forward(request, response);
    }
    else if(action.equals("/apagarcontato")){
    request.setAttribute("Modalapagar", true);
    request.setAttribute("Modal", false);
    RequestDispatcher dispatcher = request.getRequestDispatcher("triagem.jsp");
    dispatcher.forward(request, response);
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