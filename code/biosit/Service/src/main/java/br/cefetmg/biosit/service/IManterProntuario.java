
package br.cefetmg.biosit.service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.IManterPaciente;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.service.util.Util;
import br.cefetmg.biosit.DAOMySQL.*;
import br.cefetmg.biosit.idao.*;
/**
 *
 * @author Pedro Gabriel
 */
public interface IManterProntuario {
    void adicionarRegistro(RegistroProntuario registro) throws Exception;
    public void editarRegistro(RegistroProntuario registro) throws Exception;
    Prontuario pesquisar(String cpf) throws Exception;
    void excluir(int id) throws Exception;
}
