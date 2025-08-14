package br.com.itauchallenge.itau_transaction_challenge.model;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class TransactionModel {

    @NotBlank                                 // Proibe valor ser em branco
    @PositiveOrZero                           // O valor deve ser positivo ou zero
    private Double valor;                     // Atributo privado valor

    @NotNull
    private OffsetDateTime dataHora;          // Atributo dataHora com OffsetDateTime para campos de data e hora, a uma precisão de nanossegundos



    // Métodos Getter e Setters
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

}
