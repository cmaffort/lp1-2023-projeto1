
package br.cefetmg.biosit.controller;

import java.util.Date;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.biosit.dto.Paciente;
import br.cefetmg.biosit.service.IManterPaciente;
import br.cefetmg.biosit.service.implement.ManterPaciente;
import br.cefetmg.biosit.dto.exception.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Pedro Gabriel
 */
public class BuscarPaciente {
    public static String execute(HttpServletRequest request) {
        String jsp = "/listagemPaciente.jsp";
        
        try {
            List<Paciente> pacientes = new ArrayList<Paciente>();
            
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String dataNasc = request.getParameter("data-nascimento");
            String endereco = request.getParameter("endereco");
            Paciente paciente = new Paciente(nome, dataNasc, cpf, endereco);
            
            IManterPaciente manterPaciente = new ManterPaciente();
            
            pacientes = manterPaciente.pesquisar(paciente);
            request.setAttribute("pacientes", pacientes);
            
        } catch(Exception e) {
            request.setAttribute("tperror", "pesquisaPaciente");
            request.setAttribute("error", e.getMessage());
            jsp = "/paciente.jsp";
        }
        
        return jsp;
    }
}
