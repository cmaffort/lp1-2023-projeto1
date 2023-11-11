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
/**
 *
 * @author Pedro Gabriel
 */
public class ExibirConsulta {
    public static String execute(HttpServletRequest request) {
        String jsp = "/infoConsultas.jsp";
        try {
            String medico = request.getParameter("nomeExibir");

            AgendarConsulta agendarConsulta = new AgendarConsulta();
            Consulta consulta = agendarConsulta.pesquisar(medico);
            
            request.setAttribute("consulta_exib", consulta);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("tperror", "pesquisaConsulta");
            jsp = "/index.jsp";
        }
        return jsp;
    }
}
