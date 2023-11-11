/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.service.implement;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.biosit.service.IAgendarConsulta;
import br.cefetmg.biosit.dto.Consulta;
import br.cefetmg.biosit.dto.exception.*;
import br.cefetmg.biosit.service.util.Util;
import br.cefetmg.biosit.DAOMySQL.ConsultaDAO;
import br.cefetmg.biosit.idao.IConsultaDAO;
/**
 *
 * @author pjusti19
 */
public class AgendarConsulta implements IAgendarConsulta{
    
    private IConsultaDAO consultaDAO;
    
    public AgendarConsulta() {
        consultaDAO = new ConsultaDAO();
    }
    
    @Override
    public String cadastrar(Consulta consulta) throws CadastroException{
        
        if(Util.verify(consulta.getNomePaciente())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        if(Util.verify(consulta.getDescricao())) {
            throw new CadastroException("Cadastro Incompleto, insira uma descrição");
        }
        if(Util.verify(consulta.getUrgencia())) {
            throw new CadastroException("Cadastro Incompleto, insira a urgência");
        }
        if(Util.verify(consulta.getMedico())) {
            throw new CadastroException("Cadastro Incompleto, insira um nome");
        }
        if(Util.verify(consulta.getData())) {
            throw new CadastroException("Cadastro Incompleto, insira uma data");
        }
        if(Util.verify(consulta.getHorario())) {
            throw new CadastroException("Cadastro Incompleto, insira um horário");
        }

        if(consulta.getNomePaciente().length() > 50) {
            throw new CadastroException("O nome não pode ter mais de 50 caracteres");
        }
        if(consulta.getMedico().length() > 50) {
            throw new CadastroException("O nome não pode ter mais de 50 caracteres");
        }
        
        consultaDAO.inserir(consulta);
        
        return "";
    }
    
    @Override
    public String atualizar(Consulta consulta) throws Exception {
        String id = "";
        if(Util.verify(consulta.getNomePaciente())) {
            throw new CadastroException("Insira um nome");
        }
        if(Util.verify(consulta.getDescricao())) {
            throw new CadastroException("Insira uma descrição");
        }
        if(Util.verify(consulta.getUrgencia())) {
            throw new CadastroException("Insira a urgência");
        }
        if(Util.verify(consulta.getMedico())) {
            throw new CadastroException("Insira um nome");
        }
        if(Util.verify(consulta.getData())) {
            throw new CadastroException("Insira uma data");
        }
        if(Util.verify(consulta.getHorario())) {
            throw new CadastroException("Insira um horário");
        }
        
        System.out.println(consulta);
        consultaDAO.atualizar(consulta);
        
        return null;
    }
    
    @Override
    public String excluir(String nomePaciente) throws Exception {
        String id = "";
        
        if(Util.verify(nomePaciente)) 
            throw new CadastroException("Erro");
        
        consultaDAO.deletar(nomePaciente);
        
        return id;
    }
    
    @Override
    public List<Consulta> pesquisar(Consulta consulta) throws Exception {
        List<Consulta> consultas = new ArrayList<>();
        if(Util.verify(consulta)) {
            consultas = consultaDAO.pesquisarTodos();
        } else {
            if(!Util.verify(consulta.getNomePaciente())) {
                consultas.addAll(consultaDAO.pesquisarListaNomePaciente(consulta.getNomePaciente()));
            }
            if(!Util.verify(consulta.getMedico())) {
                Consulta aux = consultaDAO.pesquisarNomeMedico(consulta.getMedico());
                boolean ver = true;
                for(Consulta pac : consultas) {
                    if(pac.equals(aux)) {
                        ver = false;
                    }
                }
                if(ver) consultas.add(aux);
            }
            if(!Util.verify(consulta.getData())) {
                List<Consulta> novos = consultaDAO.pesquisarData(consulta.getData());
                for(Consulta novo : novos) {
                    boolean ver = true;
                    for(Consulta exist : consultas) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) consultas.add(novo);
                }
            }
            if(!Util.verify(consulta.getHorario())) {
                List<Consulta> novos = consultaDAO.pesquisarHorario(consulta.getHorario());
                for(Consulta novo : novos) {
                    System.out.println(novo);
                    boolean ver = true;
                    for(Consulta exist : consultas) {
                        if(exist.equals(novo)) ver = false;
                    }
                    if(ver) consultas.add(novo);
                }
            }
        }
        return consultas;
    }
    
    public Consulta pesquisar(String nomeMedico) throws Exception {
       Consulta consulta = null;
        consulta = consultaDAO.pesquisarNomeMedico(nomeMedico);
        
        return consulta;
    }
}
