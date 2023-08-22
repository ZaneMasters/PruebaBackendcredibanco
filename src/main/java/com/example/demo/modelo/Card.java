package com.example.demo.modelo;

public class Card {
    private String cardId;
    private boolean activated;
    private double balance;

    public Card(String cardId) {
        this.cardId = cardId;
        this.activated = false;
    }

    public String getCardId() {
        return cardId;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

	public void setBlocked(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void addBalance(double balance) {
		this.balance = balance;
		
	}

	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
}
