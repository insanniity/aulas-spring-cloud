package br.com.insannity.limitessvc.services;

import br.com.insannity.limitessvc.entities.LimiteDiario;
import br.com.insannity.limitessvc.repositories.LimiteDiarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LimiteDiarioService {

    LimiteDiarioRepository limiteDiarioRepository;

    public LimiteDiarioService(LimiteDiarioRepository limiteDiarioRepository) {
        this.limiteDiarioRepository = limiteDiarioRepository;
    }

    @Transactional(readOnly = true)
    public LimiteDiario findById(Long id) {
        Optional<LimiteDiario> limiteDiario = limiteDiarioRepository.findById(id);
        if (limiteDiario.isPresent()) {
            return limiteDiario.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Limite Diario não encontrado");
    }
}
