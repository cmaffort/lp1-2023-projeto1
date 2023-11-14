/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.biosit.controller;

import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.service.implement.AgendarConsulta;

/**
 *
 * @author pjusti19
 */
public class AtualizarConsulta {
    public static String execute(HttpServletRequest request) {
        String jsp = "/infoConsultas.jsp";
        try {
            String nomePaciente = request.getParameter("nomePaciente");
            String descricao = request.getParameter("descricao");
            String urgencia = request.getParameter("urgencia");
            String medico = request.getParameter("medico");
            String data = request.getParameter("data");
            String horario = request.getParameter("horario");
            Consulta consulta = new Consulta(nomePaciente, descricao, urgencia, medico, data, horario);
            System.out.println(consulta);
            AgendarConsulta agendarConsulta = new AgendarConsulta();
            agendarConsulta.atualizar(consulta);
            
            request.setAttribute("consulta_exib", consulta);
            request.setAttribute("sucess", "Dados atualizados com sucesso");
            
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            jsp = "/infoConsultas.jsp";
        }
        return jsp;
    }
}