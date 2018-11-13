package pers.felix.blackjack;

import pers.felix.blackjack.core.Game;

import java.util.Scanner;

/**
 * @Title: BlackJack
 * @Description: Black Jack Game
 * @author: Felix
 * @date: 10/16/2018 13:36
 **/

public class BlackJack {

    public static boolean running = true;

    public static void main(String[] args) {
        System.out.println("This is a Black Jack game.");
        System.out.println();
        while(running) {
            Game game = new Game();
            game.startNewGame();
            if(game.isGameOver()) {
                running = false;
            }
            else {
                System.out.println("Do you want to start a new game (Y/N)? ");
                Scanner input = new Scanner(System.in);
                String str = input.nextLine();
                running = str.toUpperCase().charAt(0) != 'N';
            }
        }
        Scanner input = new Scanner(System.in);
        input.close();
    }

}
