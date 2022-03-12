package br.com.insannity.transactionBFF.redis;

import br.com.insannity.transactionBFF.dtos.TransactionDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRedisRepository extends CrudRepository<TransactionDTO, String> {
}
