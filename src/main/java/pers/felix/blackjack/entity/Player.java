package pers.felix.blackjack.entity;

import javax.swing.plaf.SplitPaneUI;
import java.util.Scanner;

/**
 * @Title: Player
 * @Description:
 * @author: Felix
 * @date: 10/26/2018 15:56
 **/

public class Player extends PlayerBase {

    private int balance;

    public boolean isBankrupt() {
        return balance < 10;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * The player wagers
     * @return bet
     */
    public int wager() {
        hand.clear();
        end = false;
        System.out.println("Your current balance is: $" + getBalance());
        System.out.println("Please input your bet (more than $10): ");
        Scanner input = new Scanner(System.in);
        int bet = 0;
        do {
            bet = input.nextInt();
            if (bet < 10) {
                System.out.println("Your bet have to be more than $10!");
            }
            else if (bet > balance) {
                System.out.println("Insufficient funds!");
            }
            else {
                break;
            }
        } while (true);
        balance -= bet;
        return bet;
    }

    @Override
    public Deck turn(Deck deck) {
        this.deck = deck;
        while (!end) {
            showHand();
            System.out.println("Please input (H) for hit or (S) for stand:");
            switch (getCommand()) {
                case 'H':
                    hit();
                    break;
                case 'S':
                    stand();
                    break;
                default: break;
            }
            if (hand.isBurst()) {
                end = true;
            }
        }
        showHand();
        return this.deck;
    }

    public void showHand() {
        System.out.println("Player:");
        System.out.println(hand.toString(false));
    }

}
