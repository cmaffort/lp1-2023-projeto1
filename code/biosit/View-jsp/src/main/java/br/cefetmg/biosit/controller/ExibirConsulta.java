package br.cefetmg.biosit.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.service.implement.AgendarConsulta;
/**
 *
 * @author Pedro Gabriel
 */
public class ExibirConsulta {
    public static String execute(HttpServletRequest request) {
        String jsp = "/infoConsultas.jsp";
        try {
            String id = request.getParameter("idExibir");

            AgendarConsulta agendarConsulta = new AgendarConsulta();
            Consulta consulta = agendarConsulta.pesquisar(id);
            
            request.setAttribute("consulta_exib", consulta);
        } catch(Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("tperror", "buscar Consulta");
            jsp = "/index.jsp";
        }
        return jsp;
    }
}
