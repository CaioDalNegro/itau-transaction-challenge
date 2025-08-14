package br.com.itauchallenge.itau_transaction_challenge.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itauchallenge.itau_transaction_challenge.model.TransactionModel;

@Controller
@RequestMapping("/transacao")
public class TransactionController {
    

    private Map<Long, TransactionModel> transactions = new HashMap<>();          // Lista para armazenar transactions
    private Long nextId = 1L;                                                    // L para o long carregar com 64bts

    //
}
