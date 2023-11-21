package br.cefetmg.biosit.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.service.ICadastrarMedicamento;
import br.cefetmg.biosit.service.implement.ManterMedicamento;
import br.cefetmg.biosit.dto.exception.*;

@WebServlet(urlPatterns = {"/CadastrarMedicamento"})
public class CadastrarMedicamento extends HttpServlet {

    
    public static String execute(HttpServletRequest request) {
        String jsp = "/medicamento.jsp";
        try {
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            String dataValidade = request.getParameter("data");           
            int lote = Integer.parseInt(request.getParameter("lote"));
            int quantidadeRestante = Integer.parseInt(request.getParameter("quantidade"));
            System.out.println(nome);
            System.out.println(fornecedora);
            System.out.println(dataValidade);
            System.out.println(lote);
            System.out.println(quantidadeRestante);
            
            
            Medicamento medicamento = new Medicamento(nome, dataValidade, quantidadeRestante, fornecedora, lote);
            ICadastrarMedicamento manterMedicamento = new ManterMedicamento();
            System.out.println("controller");
            manterMedicamento.cadastrar(medicamento); 
            System.out.println("controller try");
            } catch (CadastroException ex) {
                System.out.println("Erro" + ex);
            }
        
        return jsp;
    }

}