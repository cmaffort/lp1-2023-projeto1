package br.cefetmg.biosit.service.implement;

import br.cefetmg.biosit.DAOMySQL.UsuarioDAO;
import br.cefetmg.biosit.dto.Usuario;
import br.cefetmg.biosit.dto.exception.CadastroException;
import br.cefetmg.biosit.idao.IUsuarioDAO;
import br.cefetmg.biosit.service.ILogarUsuario;
import br.cefetmg.biosit.service.util.Util;

public class LogarUsuario implements ILogarUsuario {
    private IUsuarioDAO usuarioDAO;
    
    public LogarUsuario() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public Usuario autenticarUsuario(Usuario usuario) throws Exception {
        
        if (Util.verify(usuario.getNomeUsuario())) {
            throw new CadastroException("Login Incompleto, insira um nome");
        }
        if (Util.verify(usuario.getSenhaUsuario())) {
            throw new CadastroException("Login Incompleto, insira uma senha");
        }
        
        return this.usuarioDAO.autenticacaoUsuario(usuario);
    }
}
