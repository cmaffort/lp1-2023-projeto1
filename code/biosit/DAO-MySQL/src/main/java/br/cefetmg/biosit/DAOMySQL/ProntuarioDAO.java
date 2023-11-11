
package br.cefetmg.biosit.DAOMySQL;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.idao.*;
import java.util.Date;

/**
 *
 * @author Pedro Gabriel
 */
public class ProntuarioDAO implements IProntuarioDAO {
    public boolean inserir(Prontuario prontuario) throws CadastroException {
        return false;
    }
    public boolean atualizar(Prontuario prontuario) throws Exception {
        return false;
    }
    public boolean deletar(String cpf) throws Exception {
        return false;
    }
    public Prontuario pesquisarCPF(String cpf) throws Exception {
        return null;
    }
}
