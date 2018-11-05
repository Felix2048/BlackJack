package pers.felix.blackjack.core;

import pers.felix.blackjack.entity.Dealer;
import pers.felix.blackjack.entity.Deck;
import pers.felix.blackjack.entity.Player;

import java.util.Scanner;

public class Game {

    final int initBalance = 1000;

    private Player player = new Player();

    private boolean gameOver = false;

    private boolean bankrupt = false;

    private int roundCount;

    public void startNewGame() {
        player.setBalance(initBalance);
        while(!gameOver && !bankrupt) {
            System.out.println("Round " + ++roundCount);
            Round round = new Round(player);
            round.start();
            player = round.getPlayer();
            bankrupt = player.isBankrupt();
            endGame();
        }
        if(bankrupt) {
            System.out.println("You are bankrupt!");
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void endGame() {
        System.out.println("Do you want to continue (Y/N)? ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        gameOver = str.toUpperCase().charAt(0) == 'N';
    }

}
