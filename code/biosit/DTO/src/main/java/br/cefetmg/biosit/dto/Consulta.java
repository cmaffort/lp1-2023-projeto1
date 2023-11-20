package br.cefetmg.biosit.dto;

/**
 *
 * @author pjusti19
 */
public class Consulta {
    private String id;
    private String nomePaciente;
    private String descricao;
    private String urgencia;
    private String medico;
    private String data;
    private String horario;       
    
    public Consulta(String nomePaciente, String descricao, String urgencia, String medico, String data, String horario ){
        this.nomePaciente = nomePaciente;
        this.descricao = descricao;
        this.urgencia = urgencia;
        this.medico = medico;
        this.data = data;
        this.horario = horario;             
}
    
     public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }   
    
    public String getId(){
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }  
}

     