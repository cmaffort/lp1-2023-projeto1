package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Usuario;


public interface ILogarUsuario {
    public Usuario autenticarUsuario(Usuario usuario) throws Exception;
}
