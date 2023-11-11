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
 * @author Aluno
 */

public class CadastrarConsulta {

    public static String execute(HttpServletRequest request) {
        String jsp = "/consulta.jsp";

        try {
            String nomePaciente = request.getParameter("nomePaciente");
//            System.out.println("pac:" + nomePaciente); 
            String descricao = request.getParameter("descricao");
//            System.out.println("des:" + descricao); 
            String urgencia = request.getParameter("urgencia");
//            System.out.println("urg:" + urgencia);            
            String medico = request.getParameter("medico");
//            System.out.println("med:" + medico);            
            String data = request.getParameter("data");
//            System.out.println("data:" + data);
            String horario = request.getParameter("horario");
//            System.out.println("hora:" + horario);
            Consulta consulta = new Consulta(nomePaciente, descricao, urgencia, medico, data, horario);
//            System.out.println("con:" + consulta);

            IAgendarConsulta agendarConsulta = new AgendarConsulta();
            agendarConsulta.cadastrar(consulta);

            request.setAttribute("sucess", "Consulta cadastrada com sucesso");
        } catch (CadastroException e) {
            request.setAttribute("tperror", "cadastrarConsulta");
            request.setAttribute("error", e.getMessage());
        } catch (Exception e) {
            request.setAttribute("tperror", "cadastrarConsulta");
            request.setAttribute("error", "Não foi possível realizar o cadastro, tente novamente");
        }

        return jsp;
    }
}
