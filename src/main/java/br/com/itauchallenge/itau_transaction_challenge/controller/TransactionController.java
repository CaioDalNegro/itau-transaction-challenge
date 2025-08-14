package br.com.itauchallenge.itau_transaction_challenge.controller;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itauchallenge.itau_transaction_challenge.model.TransactionModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//@Controller //@Controller é usado para retornar páginas HTML (views), não objetos JSON.
@RestController
@RequestMapping("/transacao")
public class TransactionController {
    

    private Map<Long, TransactionModel> transactions = new HashMap<>();          // Lista para armazenar transactions
    private Long nextId = 1L;                                                    // L para o long carregar com 64bts

    // Criar Transaçoes ------------------->
    @PostMapping
    public TransactionModel createTransaction(@RequestBody TransactionModel transaction) {
        transaction.setId(nextId++);                                             // Define ID único
        transaction.setDataHora(OffsetDateTime.now());                           // Define a data e hora atual automaticamente
        transactions.put(transaction.getId(), transaction);                      // Guarda no mapa
        return transaction;                                                      // Retorna transação criada
    }
    

    // Apagar Transaçoes ------------------>
    @DeleteMapping("/{id}") 
    public String deleteTransaction(@PathVariable Long id){                                                
        if (transactions.remove(id) != null)                                     // Remove a transação do mapa usando o ID fornecido
            return "Transaçao removida!";                                        // Retorna mensagem de sucesso
        return "Transaçao nao foi removida!";                                    // Caso contrário, não havia transação com o ID informado
    }

    // Listar Transações------------------->
    @GetMapping                                                                  // Mapeia requisições HTTP GET para /transacao
    public Map<Long, TransactionModel> listarTransacoes() {                      
        return transactions;                                                     // Retorna o mapa de transações
    }
}
