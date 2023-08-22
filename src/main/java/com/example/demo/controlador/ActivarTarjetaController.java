package com.example.demo.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.BalanceRechargeRequest;
import com.example.demo.modelo.Card;
import com.example.demo.modelo.CardActivationRequest;

@RestController
public class ActivarTarjetaController {

	
	private Map<String, Card> cards = new HashMap<>();


    @PostMapping("/card/enroll")
    public ResponseEntity<String> activateCard(@RequestBody CardActivationRequest request) {
        String cardId = request.getCardId();

        if (cards.containsKey(cardId)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Card already activated.");
        }

        cards.put(cardId, new Card(cardId));
        return ResponseEntity.ok("Card activated successfully.");
    }
    
    
    @DeleteMapping("/card/{cardId}")
    public ResponseEntity<String> blockCard(@PathVariable String cardId) {
        if (!cards.containsKey(cardId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found.");
        }

        cards.get(cardId).setBlocked(true);
        return ResponseEntity.ok("Card blocked successfully.");
    }
    

    @PostMapping("/card/balance")
    public ResponseEntity<String> rechargeBalance(@RequestBody BalanceRechargeRequest request) {
        String cardId = request.getCardId();
        double balance = request.getBalance();

        if (!cards.containsKey(cardId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found.");
        }

        cards.get(cardId).addBalance(balance);
        return ResponseEntity.ok("Balance recharged successfully.");
    }
    
    
    
    
    @GetMapping("/card/balance/{cardId}")
    public ResponseEntity<Double> getBalance(@PathVariable String cardId) {
        if (!cards.containsKey(cardId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        double balance = cards.get(cardId).getBalance();
        return ResponseEntity.ok(balance);
    }
    
    
  
}
