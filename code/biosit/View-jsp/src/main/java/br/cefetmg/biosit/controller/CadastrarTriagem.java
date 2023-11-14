
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


/**
 *
 * @author Pedro Gabriel
 */
public class CadastrarTriagem {
    
    public static String execute(HttpServletRequest request) {
        String jsp = "/triagem.jsp";
        
        try {
        
            System.out.println(request.getParameter("nome"));
//            System.out.println("nome:" + nome);
            System.out.println(request.getParameter("sintomas"));
//            System.out.println("cpf:" + cpf);

            

            request.setAttribute("sucess", "Paciente cadastrado com sucesso");
            
        }catch(Exception e) {
            request.setAttribute("tperror", "cadastroPaciente");
            request.setAttribute("error", "Não foi possível realizar o cadastro, tente novamente");
        }
        
        return jsp;
        
        
    }
}
