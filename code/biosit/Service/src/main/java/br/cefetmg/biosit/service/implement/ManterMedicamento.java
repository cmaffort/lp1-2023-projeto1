/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.service.implement;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.ICadastrarMedicamento;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.service.util.Util;
import br.cefetmg.biosit.DAOMySQL.MedicamentoDAO;
import br.cefetmg.biosit.dto.Medicamento;
import br.cefetmg.biosit.idao.IMedicamentoDAO;
/**
 *
 * @author Aluno
 */
public class ManterMedicamento implements ICadastrarMedicamento {
    private IMedicamentoDAO medicamentoDAO;
   
    @Override
    public String cadastrar(Medicamento medicamento) throws CadastroException {
        
        if(Util.verify(medicamento.getNome())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        if(Util.verify(medicamento.getFornecedora())) {
            throw new CadastroException("Cadastro Incompleto, insira uma fornecedora");
        }
        if(Util.verify(medicamento.getData())) {
            throw new CadastroException("Cadastro Incompleto, insira uma validade");
        }
        if(medicamento.getLote() == 0) {
            throw new CadastroException("Cadastro Incompleto, insira um lote");
        }
        if(medicamento.getQuantRestante() == 0) {
            throw new CadastroException("Cadastro Incompleto, insira uma quantidade");
        }
        
        
        medicamentoDAO.inserir(medicamento);
        return "?";
    }
    
    @Override
    public String atualizar(Medicamento medicamento) throws Exception {
        String id = "";
        return id;
    }
    @Override
    public String excluir(Medicamento medicamento) throws Exception {
        String id = "";
        return id;
    }
    
    
    @Override
    public List<Medicamento> pesquisar(Medicamento medicamento) throws Exception {
        List<Medicamento> medicamentos = new ArrayList<Medicamento>();
         if(true) { 
            medicamentos = medicamentoDAO.pesquisarTodos();
        } else {
            if(!Util.verify(medicamento.getNome())) {
                medicamentos.addAll(medicamentoDAO.pesquisarNome(medicamento.getNome()));
            }
            if(!Util.verify(medicamento.getFornecedora())) {
                List<Medicamento> aux = medicamentoDAO.pesquisarFornecedora(medicamento.getFornecedora());
                boolean ver = true;
                for(Medicamento pac : medicamentos) {
                    if(pac.equals(aux)) {
                        ver = false;
                    }
                }
                if(ver) medicamentos.add((Medicamento) aux);
            }
            if(!Util.verify(medicamento.getData())) {
                List<Medicamento> novos = medicamentoDAO.pesquisarValidade(medicamento.getData());
                for(Medicamento novo : novos) {
                    boolean ver = true;
                    for(Medicamento exist : medicamentos) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) medicamentos.add(novo);
                }
            }
            if(medicamento.getLote() != 0) {
                List<Medicamento> novos = medicamentoDAO.pesquisarLote(medicamento.getLote());
                for(Medicamento novo : novos) {
                    System.out.println(novo);
                    boolean ver = true;
                    for(Medicamento exist : medicamentos) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) medicamentos.add(novo);
                }
            }
        }
         return medicamentos;
    }
}
