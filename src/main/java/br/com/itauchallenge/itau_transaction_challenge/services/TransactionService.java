package br.com.itauchallenge.itau_transaction_challenge.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.itauchallenge.itau_transaction_challenge.model.TransactionModel;

@Service
public class TransactionService {
        
    private final List<TransactionModel> transacoes = Collections.synchronizedList(new ArrayList<>());            // Lista de transações

    public void adicionarTransacao(TransactionModel transacao) {                                                  // Adiciona uma nova transação à lista
        transacoes.add(transacao);
    }

    public List<TransactionModel> getTransacoes() {                                                               // Retorna todas as transações registradas
        return transacoes;
    }

    public void limparTransacoes() {                                                                              // Remove todas as transações da lista
        transacoes.clear();
    }
}