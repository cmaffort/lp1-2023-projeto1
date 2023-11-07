
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


public class BuscarEquipamento {
    public static String execute(HttpServletRequest request) {
        String jsp = "/equipamento.jsp";
        
        try {
            List<Equipamento> equipamentos = new ArrayList<Equipamento>();
            
            String nome = request.getParameter("nome");
            String fornecedora = request.getParameter("fornecedora");
            String data = request.getParameter("data");
            String setor = request.getParameter("setor");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            Equipamento equipamento = new Equipamento(nome, data, quantidade, fornecedora, setor);
            
            ICadastrarEquipamento manterEquipamento = new ManterEquipamento();
            
            equipamentos = manterEquipamento.pesquisar(equipamento);
            request.setAttribute("equipamentos", equipamentos);
            
        } catch(Exception e) {
            request.setAttribute("tperror", "pesquisaEquipamento");
            request.setAttribute("error", e.getMessage());
            jsp = "/equipamento.jsp";
        }
        
        return jsp;
    }
}
