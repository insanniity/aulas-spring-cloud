package br.com.insannity.transactionBFF.services;

import br.com.insannity.transactionBFF.dtos.RequestTransactionDTO;
import br.com.insannity.transactionBFF.dtos.TransactionDTO;
import br.com.insannity.transactionBFF.redis.TransactionRedisRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRedisRepository transactionRedisRepository;

    public TransactionService(TransactionRedisRepository transactionRedisRepository) {
        this.transactionRedisRepository = transactionRedisRepository;
    }

    @Transactional
    public Optional<TransactionDTO> save(final RequestTransactionDTO requestTransactionDto) {
        requestTransactionDto.setData(LocalDateTime.now());
        return Optional.of(transactionRedisRepository.save(requestTransactionDto));
    }

    @Transactional(readOnly = true)
    public Optional<TransactionDTO> findById(final String id) {
        return transactionRedisRepository.findById(id);
    }

}

