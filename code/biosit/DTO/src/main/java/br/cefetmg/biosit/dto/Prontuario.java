
package br.cefetmg.biosit.dto;

import java.util.ArrayList;

/**
 *
 * @author Pedro Gabriel
 */
public class Prontuario {
    private ArrayList<RegistroProntuario> registros;
    private String cpf;
//    private Consultas[] consultas;
    
    public Prontuario() {
        registros = new ArrayList<>();
    }

    public ArrayList<RegistroProntuario> getRegistros() {
        return registros;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void addRegistro(RegistroProntuario reg) {
        registros.add(reg);
    }
    
    public ArrayList<RegistroProntuario> listRegistros() {
        return registros;
    }
}
