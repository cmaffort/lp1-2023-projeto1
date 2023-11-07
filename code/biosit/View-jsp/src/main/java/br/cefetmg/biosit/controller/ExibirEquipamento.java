package br.cefetmg.biosit.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.service.ICadastrarEquipamento;
import br.cefetmg.biosit.service.implement.ManterEquipamento;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;
import java.util.List;


public class ExibirEquipamento {
    public static String execute(HttpServletRequest request) {
        String jsp = "/equipamento.jsp";
        try {
            String nome = request.getParameter("nome"); 
            String fornecedora = request.getParameter("fornecedora");
            String data = request.getParameter("data");
            String setor = request.getParameter("setor");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));

            Equipamento equipamento = new Equipamento(nome, data, quantidade, fornecedora, setor);

            ManterEquipamento manterEquipamento = new ManterEquipamento();
            manterEquipamento.pesquisar(equipamento);            
            request.setAttribute("equipamento_exib", equipamento);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("tperror", "pesquisaEquipamento");
            jsp = "/equipamento.jsp";
        }
        return jsp;
    }
}
