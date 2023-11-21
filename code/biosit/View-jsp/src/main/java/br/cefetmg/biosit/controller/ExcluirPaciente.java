
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
 * @author Aluno
 */
public class ExcluirPaciente {
    public static String execute(HttpServletRequest request) {
        String jsp = "/paciente.jsp";
        String cpf = request.getParameter("cpfExcluir");
        
        try {
            
            ManterPaciente manterPaciente = new ManterPaciente();
            manterPaciente.excluir(cpf);
            
        } catch(PacienteRegistradoException e) {
            jsp = "/prontuario.jsp";
            // coloca o objeto do paciente na requisição de novo para exibir na tela
            ManterPaciente m = new ManterPaciente();
            Paciente paciente = null;
            try { paciente = m.pesquisar(cpf); } catch(Exception ex) {}
            request.setAttribute("paciente_exib", paciente);
            request.setAttribute("error", e.getMessage());
        } catch(Exception e) {
            request.setAttribute("tperror", "pesquisaPaciente");
            request.setAttribute("error", e.getMessage());
            jsp = "/paciente.jsp";
        }
        
        return jsp;
    }
}
