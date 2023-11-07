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


public class ExibirMedicamento {
    public static String execute(HttpServletRequest request) {
        String jsp = "/medicamento.jsp";
        try {
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            String dataValidade = request.getParameter("dataValidade");           
            int lote = Integer.parseInt("lote");
            int quantidadeRestante = Integer.parseInt("quantidade");
            
            Medicamento medicamento = new Medicamento(nome, dataValidade, quantidadeRestante, fornecedora, lote);
            

            ManterMedicamento ManterMedicamento = new ManterMedicamento();
            ManterMedicamento.pesquisar(medicamento);
            
            request.setAttribute("medicamento_exib", medicamento);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("tperror", "pesquisaMedicamento");
            jsp = "/medicamento.jsp";
        }
        return jsp;
    }
}
