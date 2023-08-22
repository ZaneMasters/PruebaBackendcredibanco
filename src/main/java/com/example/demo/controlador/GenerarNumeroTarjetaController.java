package com.example.demo.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerarNumeroTarjetaController {

	
	@GetMapping("/card/{productId}/number")
    public String generateCardNumber(@PathVariable String productId) {
        // Generar número de tarjeta utilizando el id del producto y dígitos aleatorios
		
		if(productId.length()==6) {
			
			String cardNumber = generateCardNumberFromProductId(productId);
			return cardNumber;
		}else {
			return "Inserte Id DEL PRODUCTO DE 6 DIGITOS";
		}
    }

    private String generateCardNumberFromProductId(String productId) {
        // Lógica para generar el número de tarjeta (simulación)
        String randomDigits = generateRandomDigits(10); // Genera 10 dígitos aleatorios
        String cardNumber = productId + randomDigits;
        return cardNumber;
    }

    private String generateRandomDigits(int length) {
        // Lógica para generar dígitos aleatorios (simulación)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }
}

