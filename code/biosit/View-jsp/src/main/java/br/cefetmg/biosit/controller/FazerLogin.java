package br.cefetmg.biosit.controller;

import br.cefetmg.biosit.dto.Usuario;
import br.cefetmg.biosit.service.implement.LogarUsuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class FazerLogin {

    public static String execute(HttpServletRequest request) {
        String jsp = "/index.jsp";

        try {
            String nomeUsuario = request.getParameter("nome");
            String senhaUsuario = request.getParameter("senha");

            Usuario usuario = new Usuario(0, "", nomeUsuario, senhaUsuario);

            Usuario usuarioLogado = new Usuario(0, "", "", "");

            LogarUsuario logarUsuario = new LogarUsuario();
            usuarioLogado = logarUsuario.autenticarUsuario(usuario);

            if (usuarioLogado != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("usuarioLogado", true);
                session.setAttribute("tipoUsuario",usuarioLogado.getTipoUsuario());
            } else {
                jsp = "/login.jsp";
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            jsp = "/login.jsp";
        }
        return jsp;
    }
}
