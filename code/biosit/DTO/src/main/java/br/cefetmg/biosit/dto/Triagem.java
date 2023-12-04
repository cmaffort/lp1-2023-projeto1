/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.biosit.dto;

/**
 *
 * @author joaop
 */
public class Triagem {
    
    private String idcon;
    private String nome;
    private String dtnasc;
    private String cpf;
    private String medico;
    private String esp;
    private String consult;
    private String hora_ent;
    private String hora_prev;
    private String urg;
    
    public Triagem() {
        super();
}
    public Triagem(String idcon, String nome, String dtnasc, String cpf, String medico,
            String esp, String consult, String hora_ent, String hora_prev,
            String urg) {
        super();
        this.idcon = idcon;
        this.nome = nome;
        this.dtnasc = dtnasc;
        this.cpf = cpf;
        this.medico = medico;
        this.esp = esp;
        this.consult = consult;
        this.hora_ent = hora_ent;
        this.hora_prev = hora_prev;
        this.urg = urg;
        
    }

    public String getIdcon() {
        return idcon;
    }

    public void setIdcon(String idcon) {
        this.idcon = idcon;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public String getConsult() {
        return consult;
    }

    public void setConsult(String consult) {
        this.consult = consult;
    }

    public String getHora_ent() {
        return hora_ent;
    }

    public void setHora_ent(String hora_ent) {
        this.hora_ent = hora_ent;
    }

    public String getHora_prev() {
        return hora_prev;
    }

    public void setHora_prev(String hora_prev) {
        this.hora_prev = hora_prev;
    }

    public String getUrg() {
        return urg;
    }

    public void setUrg(String urg) {
        this.urg = urg;
    }


    
    
    
}
