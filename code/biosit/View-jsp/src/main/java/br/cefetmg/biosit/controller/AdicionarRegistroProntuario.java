
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Pedro Gabriel
 */
public class AdicionarRegistroProntuario {
    public static String execute(HttpServletRequest request) {
        String jsp = "/prontuario.jsp";
        String cpf = request.getParameter("cpf");
        try {
            String titulo = request.getParameter("titulo-reg");
            String tipo = request.getParameter("tipo-reg");
            String desc = request.getParameter("desc-reg");
            
            Date dt = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String data = formato.format(dt);
            
            RegistroProntuario reg = new RegistroProntuario(cpf);
            reg.setData(data);
            reg.setTitulo(titulo);
            reg.setDescricao(desc);
            reg.setTipo(tipo);
            
            ManterProntuario manterProntuario = new ManterProntuario();
            manterProntuario.adicionarRegistro(reg);
           

        } catch(Exception e) {
            request.setAttribute("tperror", "adicionarRegistro");
            request.setAttribute("error", "Não foi possível adicionar o registro");
            
        }
        
        // coloca o objeto do paciente na requisição de novo para exibir na tela
        ManterPaciente manterPaciente = new ManterPaciente();
        Paciente paciente = null;
        try { paciente = manterPaciente.pesquisar(cpf); } catch(Exception e) {}
        request.setAttribute("paciente_exib", paciente);
        request.setAttribute("sucess", "Registro adicionado com sucesso");
            
        return jsp;
    }
}
