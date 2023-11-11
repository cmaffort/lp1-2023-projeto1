
package br.cefetmg.biosit.idao;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
/**
 *
 * @author Pedro Gabriel
 */
public interface IProntuarioDAO {
    boolean inserir(Prontuario prontuario) throws CadastroException;
    boolean atualizar(Prontuario prontuario) throws Exception;
    boolean deletar(String cpf) throws Exception;
    Prontuario pesquisarCPF(String cpf) throws Exception;
}
