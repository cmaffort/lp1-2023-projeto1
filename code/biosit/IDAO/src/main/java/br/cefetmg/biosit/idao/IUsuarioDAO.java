package br.cefetmg.biosit.idao;

import br.cefetmg.biosit.dto.Usuario;

public interface IUsuarioDAO {
    Usuario autenticacaoUsuario(Usuario usuario) throws Exception;
}
