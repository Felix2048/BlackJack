package pers.felix.blackjack;

import pers.felix.blackjack.entity.Card;
import pers.felix.blackjack.entity.Hand;
import pers.felix.blackjack.enums.FaceValue;
import pers.felix.blackjack.enums.Suit;

/**
 * @Title: BlackJack
 * @Description: Black Jack Game
 * @author: Felix
 * @date: 10/16/2018 13:36
 **/

public class BlackJack {
    public static void main(String[] args) {
        Hand hand = new Hand();
        System.out.println("This is a Black Jack game.");
        hand.addCard(new Card(FaceValue.ACE, Suit.Spade));
        hand.addCard(new Card(FaceValue.NINE, Suit.Spade));
        System.out.println();
        System.out.println(hand.toString());
        System.out.println();
        System.out.println(hand.toString(true));
        System.out.println();
        System.out.println(hand.toString(false));
    }
}
