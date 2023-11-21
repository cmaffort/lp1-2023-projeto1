
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
public class EditarRegistroProntuario {
    public static String execute(HttpServletRequest request) {
        String jsp = "/prontuario.jsp";
        Paciente paciente = null;
        String cpf = request.getParameter("cpf");
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo-reg");
            String desc = request.getParameter("desc-reg");
            String tipo = request.getParameter("tipo-reg");
            
            RegistroProntuario registro = new RegistroProntuario(cpf);
            registro.setDescricao(desc);
            registro.setTitulo(titulo);
            registro.setTipo(tipo);
            registro.setID(id);
            IManterProntuario manterProntuario = new ManterProntuario();
            manterProntuario.editarRegistro(registro);
        } catch (Exception e) {
            request.setAttribute("tperror", "editarRegistro");
            request.setAttribute("error", "Não foi possível editar o registro");
        }
        
        // coloca o objeto do paciente na requisição de novo para exibir na tela
        System.out.println("chego aq");
        ManterPaciente manterPaciente = new ManterPaciente();
        try { paciente = manterPaciente.pesquisar(cpf); } catch(Exception e) {}
        request.setAttribute("paciente_exib", paciente);
        request.setAttribute("sucess", "Registro editado com sucesso");
            
        return jsp;
    }
}
