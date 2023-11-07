
package br.cefetmg.biosit.dto;

public class Exame {
    private String exame;
    private int CPFpaciente;
    private String dataHora;
    
    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }
    public int getPaciente() {
        return CPFpaciente;
    }

    public void setPaciente(int CPFpaciente) {
        this.CPFpaciente = CPFpaciente;
    }
    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    
    public Exame (String exame, String paciente, String dataHora){
        
    }
}
