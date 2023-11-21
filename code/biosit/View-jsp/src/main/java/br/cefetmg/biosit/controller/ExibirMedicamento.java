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
        String jsp = "/listagemMedicamento.jsp";
        try {
            String nome = request.getParameter("nomeExibir");

            ManterMedicamento manterMedicamento = new ManterMedicamento();
            Medicamento medicamentoteste = new Medicamento();
            medicamentoteste.setNome(nome);
            List<Medicamento> medicamento = manterMedicamento.pesquisar(medicamentoteste);
            
            request.setAttribute("medicamento_exib", medicamento);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("tperror", "pesquisaMedicamento");
            jsp = "/medicamento.jsp";
        }
        return jsp;
    }
}