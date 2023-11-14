package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.service.IAgendarConsulta;
import br.cefetmg.biosit.service.implement.AgendarConsulta;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;
import java.util.List;


public class BuscarConsulta {
    public static String execute(HttpServletRequest request) {
        String jsp = "/listagemConsultas.jsp";
        
        try {
            List<Consulta> consultas = new ArrayList<Consulta>();
            
            String nomePaciente = request.getParameter("nomePaciente");
            String descricao = request.getParameter("descricao");
            String urgencia = request.getParameter("urgencia");
            String medico = request.getParameter("medico");
            String data = request.getParameter("data");
            String horario = request.getParameter("horario");
            Consulta consulta = new Consulta(nomePaciente, descricao, urgencia, medico, data, horario);
            
            IAgendarConsulta agendarConsulta = new AgendarConsulta();
            
            consultas = agendarConsulta.pesquisar(consulta);
            request.setAttribute("consultas", consultas);
            
        } catch(Exception e) {
            request.setAttribute("tperror", "buscarConsulta");
            request.setAttribute("error", e.getMessage());
            jsp = "/listagemConsultas.jsp";
        }
        
        return jsp;
    }
}
