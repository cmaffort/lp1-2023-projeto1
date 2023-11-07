package br.cefetmg.biosit.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.service.ICadastrarEquipamento;
import br.cefetmg.biosit.service.implement.ManterEquipamento;

@WebServlet("/excluirEquipamento")
public class ExcluirEquipamento extends HttpServlet {
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
            manterEquipamento.excluir(equipamento); 


        } catch(Exception e) {
            request.setAttribute("tperror", "excluirEquipamento");
            request.setAttribute("error", e.getMessage());
            jsp = "/equipamento.jsp";
        }
        return jsp;
    }
}
