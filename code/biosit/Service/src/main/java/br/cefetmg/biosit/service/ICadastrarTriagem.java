
package br.cefetmg.biosit.service;

import br.cefetmg.biosit.dto.Triagem;
import br.cefetmg.biosit.dto.exception.*;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Pedro Gabriel
 */
public interface ICadastrarTriagem {
    
    public String cadastrar(Triagem triagem) throws CadastroException, PacienteDuplicadoException;
   
    
}