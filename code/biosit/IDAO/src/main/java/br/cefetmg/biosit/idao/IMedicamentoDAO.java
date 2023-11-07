package br.cefetmg.biosit.idao;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.dto.exception.CadastroException;
import java.util.Date;
/**
 *
 * @author Aluno
 */
public interface IMedicamentoDAO {
    boolean inserir(Medicamento medicamento) throws CadastroException;
    boolean atualizar(Medicamento medicamento) throws Exception;
    boolean deletar(Medicamento medicamento) throws Exception;
    List<Medicamento> pesquisarNome(String nome) throws Exception;
    List<Medicamento> pesquisarFornecedora(String fornecedora) throws Exception;
    List<Medicamento> pesquisarLote(int lote) throws Exception;
    List<Medicamento> pesquisarQuantidade(int quantidade) throws Exception;
    List<Medicamento> pesquisarValidade(String validade) throws Exception;
    List<Medicamento> pesquisarTodos() throws Exception;
}