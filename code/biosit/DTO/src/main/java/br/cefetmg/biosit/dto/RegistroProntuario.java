
package br.cefetmg.biosit.dto;

import java.util.Date;



/**
 *
 * @author Pedro Gabriel
 */
public class RegistroProntuario {
    private String tipo;
    private String titulo;
    private String data;
    private String descricao;
    
    private String cpf;
    private int id;
    
    public RegistroProntuario() {
        this.tipo = null;
        this.titulo = null;
        this.data = null;
        this.descricao = null;
        this.cpf = null;
    }
    
    public RegistroProntuario(String cpf) {
        this.tipo = null;
        this.titulo = null;
        this.data = null;
        this.descricao = null;
        
        this.cpf = cpf;
    }

    public String getData() {
        return data;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getTipo() {
        return tipo;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getID() {
        return id;
    }
    public String getCPF() {
        return cpf;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setID(int id) {
        this.id  = id;
    }
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
}
