package br.com.insannity.transactionBFF.controlllers;

import br.com.insannity.transactionBFF.dtos.LimiteDiario;
import br.com.insannity.transactionBFF.feign.LimiteClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limites")
public class LimiteController {

    private final LimiteClient limiteClient;

    public LimiteController(LimiteClient limiteClient) {
        this.limiteClient = limiteClient;
    }

    @GetMapping("/{agencia}/{conta}")
    public LimiteDiario buscarLimiteDiario(@PathVariable Long agencia, @PathVariable Long conta) {
        return limiteClient.buscarLimiteDiario(agencia, conta);
    }

}
