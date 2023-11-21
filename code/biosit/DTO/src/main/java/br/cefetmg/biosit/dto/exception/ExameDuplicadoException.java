
package br.cefetmg.biosit.dto.exception;

public class ExameDuplicadoException extends Exception{
    public ExameDuplicadoException(String dataHora) {
        super("Já existe um exame agendado nesse horário " + dataHora);
    }
}
