
package br.cefetmg.biosit.dto;

import java.util.ArrayList;

/**
 *
 * @author Pedro Gabriel
 */
public class Prontuario {
    private ArrayList<RegistroProntuario> registros;
    private String cpf;
    Paciente paciente;
//    private Consultas[] consultas;
    
    public Prontuario(Paciente pac) {
        this.paciente = pac;
        this.cpf = pac.getCPF();
        registros = new ArrayList<>();
    }
    
    public void addRegistro(RegistroProntuario reg) {
        reg.setID(registros.size());
        registros.add(reg);
    }
    
    public ArrayList<RegistroProntuario> listRegistros() {
        return registros;
    }
}
