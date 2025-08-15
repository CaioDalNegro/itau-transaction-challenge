package br.com.itauchallenge.itau_transaction_challenge.services;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

import org.springframework.stereotype.Service;

import br.com.itauchallenge.itau_transaction_challenge.model.StatisticModel;
import br.com.itauchallenge.itau_transaction_challenge.model.TransactionModel;

@Service
public class StatisticService {
    
    private final TransactionService transactionService;                                                  // Dependência para acessar as transações registradas

    public StatisticService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public StatisticModel calcularEstatisticas() {
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);

        DoubleSummaryStatistics stats = transactionService.getTransacoes().stream()
            .filter(t -> t.getDataHora().isAfter(limite))                                                  // últimos 60s
            .mapToDouble(TransactionModel::getValor)                                                       // pega valor
            .summaryStatistics();

        if (stats.getCount() == 0) {
            return new StatisticModel(0, 0, 0, 0, 0);
        }

        return new StatisticModel(
            stats.getCount(),
            stats.getSum(),
            stats.getAverage(),
            stats.getMin(),
            stats.getMax()
        );
    }
}
