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

public class AtualizarEquipamento {
     public static String execute(HttpServletRequest request) {
        String jsp = "/medicamento.jsp";
        try {
             String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            String data = request.getParameter("data");
            String setor = request.getParameter("setor");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            
            Equipamento equipamento = new Equipamento(nome, data, quantidade, fornecedora, setor);
            
            
            ManterEquipamento manterEquipamento = new ManterEquipamento();
            manterEquipamento.atualizar(equipamento);
            
            request.setAttribute("medicamento_exib", equipamento);
            request.setAttribute("sucess", "Dados atualizados com sucesso");
            
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            jsp = "/index.jsp";
        }
        return jsp;
    }
}
