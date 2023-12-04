
package br.cefetmg.biosit.idao;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.Triagem;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
/**
 *
 * @author Aluno
 */
public interface ITriagemDAO {
    boolean inserir(Triagem triagem) throws CadastroException, PacienteDuplicadoException;

    
}
