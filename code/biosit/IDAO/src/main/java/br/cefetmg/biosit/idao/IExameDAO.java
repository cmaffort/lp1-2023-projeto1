package br.cefetmg.biosit.idao;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.Exame;
import br.cefetmg.biosit.dto.exception.CadastroException;
/**
 *
 * @author Aluno
 */

public interface IExameDAO {
    boolean inserir(Exame exame) throws CadastroException;
    boolean atualizar(Exame exame) throws Exception;
    boolean deletar(Exame exame) throws Exception;
    List<Exame> pesquisarExame(String exame) throws Exception;
    List<Exame> pesquisarPaciente(int CPFpaciente) throws Exception;
    List<Exame> pesquisarDataHora(String dataHora) throws Exception;

} 