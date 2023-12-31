package br.cefetmg.biosit.dto;

import java.util.Date;

/**
 *
 * @author David Eller
 */
public class Financeiro {

    private Date dataEmitida;
    private String categoria;
    private Integer valor;
    private Date dataFinal;

    public Financeiro(Date dataEmitida, String categoria, Date dataFinal, int valor) {
        this.dataEmitida = dataEmitida;
        this.categoria = categoria;
        this.dataFinal = dataFinal;
        this.valor = valor;
    }

    public Date getData() {
        return dataEmitida;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getValor() {
        return valor;
    }

    public void setData(Date dataEmitida) {
        this.dataEmitida = dataEmitida;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
