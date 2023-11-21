
package br.cefetmg.biosit.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.*;
import br.cefetmg.biosit.dto.*;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.service.util.Util;
import br.cefetmg.biosit.DAOMySQL.*;
import br.cefetmg.biosit.idao.*;

/**
 *
 * @author Pedro Gabriel
 */
public class ManterProntuario implements IManterProntuario {
    
    private IProntuarioDAO prontuarioDAO;
    
    public ManterProntuario() {
        prontuarioDAO = new ProntuarioDAO();
    }
    
    @Override
    public void adicionarRegistro(RegistroProntuario registro) throws Exception {
        if(Util.verify(registro.getData())) {
            throw new Exception("Erro");
        } if(Util.verify(registro.getDescricao())) {
            throw new Exception("Insira uma descrição");
        } if(Util.verify(registro.getTipo())) {
            throw new Exception("Selecione um tipo");
        } if(Util.verify(registro.getTitulo())) {
            throw new Exception("Insira um título");
        }
        
        prontuarioDAO.inserir(registro);
    }
    
    @Override
    public void editarRegistro(RegistroProntuario registro) throws Exception {
        if(Util.verify(registro.getDescricao())) {
            throw new Exception("Insira uma descrição");
        } if(Util.verify(registro.getTipo())) {
            throw new Exception("Selecione um tipo");
        } if(Util.verify(registro.getTitulo())) {
            throw new Exception("Insira um título");
        }
        
        prontuarioDAO.atualizar(registro);
    }
    
    
    @Override
    public Prontuario pesquisar(String cpf) throws Exception {
        Prontuario prontuario = prontuarioDAO.pesquisar(cpf);
        return prontuario;
    }
    
    @Override
    public void excluir(int id) throws Exception {
        prontuarioDAO.deletar(id);
    }
}
