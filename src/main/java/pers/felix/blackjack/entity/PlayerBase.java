package pers.felix.blackjack.entity;

import java.util.Scanner;

public class PlayerBase {

    protected Deck deck;

    protected Hand hand = new Hand();

    protected boolean end = false;

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isEnd() {
        return end;
    }

    public Deck turn(Deck deck) {
        this.deck = deck;
        return this.deck;
    }

    public void hit() {
        Card newCard = deck.extractCard();
        hand.addCard(newCard);
    }

    public void stand() {
        end = true;
    }

    protected char getCommand() {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        return str.toUpperCase().charAt(0);
    }
}
