
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
    boolean inserir(RegistroProntuario registro) throws Exception;
    boolean atualizar(RegistroProntuario registro) throws Exception;
    boolean deletar(int id) throws Exception;
    Prontuario pesquisar(String cpf) throws Exception;
}
