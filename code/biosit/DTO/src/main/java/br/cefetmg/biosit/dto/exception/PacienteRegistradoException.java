
package br.cefetmg.biosit.dto.exception;

/**
 *
 * @author Pedro Gabriel
 */
public class PacienteRegistradoException extends Exception {
    public PacienteRegistradoException() {
        super("Não foi possível deletar o paciente. Tente deletar os registros de prontuário.");
    }
}
