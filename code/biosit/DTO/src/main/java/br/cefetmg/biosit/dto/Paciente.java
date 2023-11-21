
package br.cefetmg.biosit.dto;


import java.util.Date;



/**
 *
 * @author Pedro Gabriel
 */
public class Paciente {
    private String nome;
    private String dataNasc;
    private String CPF;
    private String endereco;
    private String rg;
    private String tel;
    private Prontuario prontuario;
    
    public Paciente(String nome, String dataNasc, String CPF, String endereco) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.CPF = CPF;
        this.endereco = endereco;
        rg = "";
        tel = "";
        prontuario = null;
    }
    public String getNome() {
        return nome;
    }
    public String getCPF() {
        return CPF;
    }
    public String getNascimento() {
        return dataNasc;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getRG() {
        return rg;
    }
    public String getTel() {
        return tel;
    }
    public Prontuario getProntuario() {
        return prontuario;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNascimento(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setRG(String rg) {
        this.rg = rg;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setProntuario(Prontuario pron) {
        this.prontuario = pron;
    }
    
    public boolean equals(Paciente paciente) {
        return this.getCPF().equals(paciente.getCPF());
    }
}
