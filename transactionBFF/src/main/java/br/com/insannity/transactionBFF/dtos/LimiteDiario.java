package br.com.insannity.transactionBFF.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "id")
public class LimiteDiario {

    private Long id;
    private Long agencia;
    private Long conta;
    private BigDecimal valor;

}
