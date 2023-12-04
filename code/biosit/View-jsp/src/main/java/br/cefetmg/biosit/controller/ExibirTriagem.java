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
@WebServlet(name = "ExibirTriagem", urlPatterns = {
  "/ExibirTriagem"
})
public class ExibirTriagem extends HttpServlet {
    TriagemDAO dao = new TriagemDAO();
    
            



  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
      PrintWriter out = response.getWriter();
        String action = request.getServletPath();
        
        
        
        ArrayList<Triagem> lista = dao.listarContatos();
        String nome = lista.get(1).getNome();
        
        request.setAttribute("contatos",lista);
        request.setAttribute("Modal", false);
        request.setAttribute("Modalapagar", false);
        RequestDispatcher rd = request.getRequestDispatcher("triagem.jsp");
         rd.forward(request,response);
        
        
        
    

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

}}
