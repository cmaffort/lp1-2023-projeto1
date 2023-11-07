package br.cefetmg.biosit.idao;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.Equipamento;
import br.cefetmg.biosit.dto.exception.CadastroException;

/**
 *
 * @author Aluno
 */
public interface IEquipamentoDAO {
    boolean inserir(Equipamento equipamento) throws CadastroException;
    boolean atualizar(Equipamento equipamento) throws Exception;
    boolean deletar(Equipamento equipamento) throws Exception;
    List<Equipamento> pesquisarNome(String nome) throws Exception;
    List<Equipamento> pesquisarQuantidade(int quantidade) throws Exception;
    List<Equipamento> pesquisarFornecedora(String fornecedora) throws Exception;
    List<Equipamento> pesquisarData(String data) throws Exception;
    List<Equipamento> pesquisarSetor(String setor) throws Exception;
    List<Equipamento> pesquisarTodos() throws Exception;

}