package br.com.insannity.transactionsvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class Conta implements Serializable {

    private static final long serialVersionUID = 2806412403585360625L;


    @NotNull(message = "Informar o código da Agência.")
    private Long codigoAgencia;
    @NotNull(message = "Informar o código da Conta.")
    private Long codigoConta;
}

