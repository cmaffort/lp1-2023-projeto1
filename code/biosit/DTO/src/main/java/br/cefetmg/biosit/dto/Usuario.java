package br.cefetmg.biosit.dto;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String senhaUsuario;
    private String tipoUsuario;
    
    public Usuario(int idUsuario, String tipoUsuario, String nomeUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }
    
    public String getTipoUsuario () {
        return tipoUsuario;
    }
    
    public void setTipoUsuario (String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}

