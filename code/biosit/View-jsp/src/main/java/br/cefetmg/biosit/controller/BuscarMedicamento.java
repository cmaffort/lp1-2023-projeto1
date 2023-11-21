
package br.cefetmg.biosit.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.service.ICadastrarMedicamento;
import br.cefetmg.biosit.service.implement.ManterMedicamento;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;
import java.util.List;


public class BuscarMedicamento {
    public static String execute(HttpServletRequest request) {
        String jsp = "/medicamento.jsp";
        
        try {
            List<Medicamento> medicamentos = new ArrayList<Medicamento>();
            
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            String dataValidade = request.getParameter("dataValidade");           
            int lote = Integer.parseInt(request.getParameter("lote"));
            int quantidadeRestante = Integer.parseInt(request.getParameter("quantidade"));
            
            Medicamento medicamento = new Medicamento(nome, dataValidade, quantidadeRestante, fornecedora, lote);
            
            ICadastrarMedicamento manterMedicamento = new ManterMedicamento();
            
            medicamentos = manterMedicamento.pesquisar(medicamento);
            request.setAttribute("medicamentos", medicamentos);
            
        } catch(Exception e) {
            request.setAttribute("tperror", "pesquisaMedicamento");
            request.setAttribute("error", e.getMessage());
            jsp = "/medicamento.jsp";
        }
        
        return jsp;
    }
}
