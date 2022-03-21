package br.com.insannity.limitessvc.repositories;

import br.com.insannity.limitessvc.entities.LimiteDiario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LimiteDiarioRepository extends CrudRepository<LimiteDiario, Long> {

    Optional<LimiteDiario> findByAgenciaAndConta(Long agencia, Long conta);

}
