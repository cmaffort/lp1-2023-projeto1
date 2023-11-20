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
 * @author pjusti19
 */
public class ExcluirConsulta {
    public static String execute(HttpServletRequest request) {
        String jsp = "/index.jsp";
        
        try {
            
            String id = request.getParameter("idExcluir");
            AgendarConsulta agendarConsulta = new AgendarConsulta();
            agendarConsulta.excluir(id);
            
        } catch(Exception e) {
            request.setAttribute("tperror", "excluirConsulta");
            request.setAttribute("error", e.getMessage());
            jsp = "/infoConsultas.jsp";
        }
        
        return jsp;
    }

}
