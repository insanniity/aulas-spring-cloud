package br.com.insannity.limitessvc.controller;

import br.com.insannity.limitessvc.entities.LimiteDiario;
import br.com.insannity.limitessvc.services.LimiteDiarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/limite-diario")
public class LimiteDiarioController {

    private final LimiteDiarioService limiteDiarioService;

    public LimiteDiarioController(LimiteDiarioService limiteDiarioService) {
        this.limiteDiarioService = limiteDiarioService;
    }

    @GetMapping("/{id}")
    public LimiteDiario findById(@PathVariable("id") Long id) {
        return limiteDiarioService.findById(id);
    }

    @GetMapping("/{agencia}/{conta}")
    public LimiteDiario buscarLimiteDiario(@PathVariable Long agencia, @PathVariable Long conta) {
        final Optional<LimiteDiario> limiteDiario = limiteDiarioService.buscarLimiteDiario(agencia, conta);
        if(limiteDiario.isPresent()) {
            return limiteDiario.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Limite Diario não encontrado");
    }

}
