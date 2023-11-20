package br.cefetmg.biosit.idao;


import java.util.List;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.dto.exception.*;

/**
 *
 * @author pjusti19
 */
public interface IConsultaDAO {
    boolean inserir(Consulta consulta) throws CadastroException;
    boolean atualizar(Consulta consulta) throws Exception;
    boolean deletar(String nomePaciente) throws Exception;
    List<Consulta> pesquisarListaNomePaciente (String nomePaciente) throws Exception;
    Consulta pesquisarNomePaciente (String nome) throws Exception;
    Consulta pesquisarId (String id) throws Exception;
    List<Consulta> pesquisarData(String data) throws Exception;
    List<Consulta> pesquisarHorario(String horario) throws Exception;
    List<Consulta> pesquisarListaNomeMedico(String medico) throws Exception;
    Consulta pesquisarNomeMedico (String nome) throws Exception;
    List<Consulta> pesquisarTodos() throws Exception;
}
