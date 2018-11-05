package pers.felix.blackjack.core;

import pers.felix.blackjack.entity.*;

public class Round {

    private Player player;

    private Dealer dealer = new Dealer();

    private int bet;

    private Deck deck = new Deck();

    public Round(Player player) {
        this.player = player;
    }

    public void start() {
        bet = player.wager();
        drawCards();
        if (isDealerBlackJack()) {
            dealer.reveal();
            dealer.showHand();
            player.showHand();
            judge();
        }
        else {
            deck = player.turn(deck);
            if (isPlayerBurst()) {
                judge();
            }
            else {
                deck = dealer.turn(deck);
                judge();
            }
        }

    }

    public void judge() {
        int playerValue = player.getHand().getMaxFaceValue();
        int dealerValue = dealer.getHand().getMaxFaceValue();
        if (isPlayerBurst()) {
            System.out.println("Player burst. Dealer wins.");
        }
        else if (isDealerBurst()) {
            System.out.println("Dealer burst. Player wins.");
            player.setBalance(player.getBalance() + 2 * bet);
        }
        else if (playerValue == dealerValue) {
            System.out.println("It's a draw.");
            player.setBalance(player.getBalance() + bet);
        }
        else if(isPlayerBlackJack()) {
            System.out.println("Player got a black jack!");
            player.setBalance(player.getBalance() + 3 * bet);
        }
        else if(playerValue < dealerValue) {
            System.out.println("Dealer wins.");
        }
        else if(playerValue > dealerValue) {
            System.out.println("Player wins.");
            player.setBalance(player.getBalance() + 2 * bet);
        }

    }

    public boolean isDealerBlackJack() {
        return dealer.getHand().isBlackJack();
    }

    public boolean isPlayerBlackJack() {
        return player.getHand().isBlackJack();
    }

    public boolean isPlayerBurst() {
        return player.getHand().isBurst();
    }

    public boolean isDealerBurst() {
        return dealer.getHand().isBurst();
    }


    public void drawCards() {
        dealer.addCard(deck.extractCard());
        dealer.cover();
        dealer.addCard(deck.extractCard());
        dealer.showHand();
        player.addCard(deck.extractCard());
        player.addCard(deck.extractCard());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
