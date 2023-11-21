
package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.service.*;
import br.cefetmg.biosit.service.implement.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;

/**
 *
 * @author Pedro Gabriel
 */
public class ExcluirRegistroProntuario {
    public static String execute(HttpServletRequest request) {
        String jsp = "/prontuario.jsp";
        String cpf = request.getParameter("cpf");
        
        try {
            
            int id = Integer.parseInt(request.getParameter("id"));
            IManterProntuario manterProntuario = new ManterProntuario();
            manterProntuario.excluir(id);
            
        } catch(Exception e) {
            request.setAttribute("tperror", "excluirRegistro");
            request.setAttribute("error", "Não foi possível excluir o registro");
        }
        
        ManterPaciente manterPaciente = new ManterPaciente();
        Paciente paciente = null;
        try { paciente = manterPaciente.pesquisar(cpf); } catch(Exception e) {}
        request.setAttribute("paciente_exib", paciente);
        request.setAttribute("sucess", "Registro excluído com sucesso");
        
        return jsp;
    }
}
