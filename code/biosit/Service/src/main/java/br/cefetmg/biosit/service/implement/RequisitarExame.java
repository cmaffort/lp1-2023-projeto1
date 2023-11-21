package br.cefetmg.biosit.service.implement;

import br.cefetmg.biosit.DAOMySQL.ExameDAO;
import br.cefetmg.biosit.dto.Exame;
import br.cefetmg.biosit.dto.exception.CadastroException;
import br.cefetmg.biosit.dto.exception.ExameDuplicadoException;
import br.cefetmg.biosit.service.util.Util;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.IRequisitarExame;
import br.cefetmg.biosit.idao.IExameDAO;


public class RequisitarExame implements IRequisitarExame{
      private IExameDAO exameDAO;

      public RequisitarExame() {
            exameDAO = new ExameDAO();
      }
      
      public String cadastrar(Exame exame) throws CadastroException, ExameDuplicadoException {
        
        if(Util.verify(exame.getPaciente())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        if(Util.verify(exame.getDataHora())) {
            throw new CadastroException("Cadastro Incompleto, insira uma data e hora");
        }
        if(Util.verify(exame.getExame())) {
            throw new CadastroException("Cadastro Incompleto, insira um exame");
        }
        
        if(exame.getPaciente().length() > 50) {
            throw new CadastroException("O nome não pode ter mais de 50 caracteres");
        }
        
        
        exameDAO.inserir(exame);
        
        return "";
    }
    

      
     public String atualizar(Exame exame) throws Exception {
        String id = "";
        if(Util.verify(exame.getPaciente())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        if(Util.verify(exame.getDataHora())) {
            throw new CadastroException("Cadastro Incompleto, insira uma data e hora");
        }
        if(Util.verify(exame.getExame())) {
            throw new CadastroException("Cadastro Incompleto, insira um exame");
        }

        System.out.println(exame);

        exameDAO.atualizar(exame);

        return null; 
    }

    
    public String excluir(String dataHora) throws Exception {
        String id = "";
        
        if(Util.verify(dataHora)) 
            throw new CadastroException("Erro");
        
        exameDAO.deletar(dataHora);
        
        return id;
    }
    
     public List<Exame> pesquisar(Exame exame) throws Exception {
    List<Exame> exames = new ArrayList<Exame>();
    exameDAO = new ExameDAO();

    if(Util.verify(exame.getPaciente())) {
        exames = exameDAO.pesquisarTodos();
    } else {
        if(!Util.verify(exame.getExame())) {
            exames.addAll(exameDAO.pesquisarExame(exame.getExame()));
        }
        if(!Util.verify(exame.getDataHora())) {
            List<Exame> novos = exameDAO.pesquisarDataHora(exame.getDataHora());
            for(Exame novo : novos) {
                boolean ver = true;
                for(Exame exist : exames) {
                    if(exist.equals(novo)) ver = false;
                }
                if(ver) exames.add(novo);
            }
        }
        if(!Util.verify(exame.getPaciente())) {
            Exame aux = exameDAO.pesquisarPaciente(exame.getPaciente());
            boolean ver = true;
            for(Exame pac : exames) {
                if(pac.equals(aux)) {
                    ver = false;
                }
            }
            if(ver) exames.add(aux);
        }
    }
    return exames;
}

    
    public Exame pesquisar(String cpf) throws Exception {
        Exame exame = null;
        exame = exameDAO.pesquisarPaciente(cpf);
        
        return exame;
    }
}
