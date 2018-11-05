package pers.felix.blackjack.entity;

/**
 * @Title: Dealer
 * @Description:
 * @author: Felix
 * @date: 10/26/2018 15:58
 **/

public class Dealer extends PlayerBase{

    boolean isFirstCardHidden;

    public void cover() {
        isFirstCardHidden = true;
    }

    public void reveal() {
        isFirstCardHidden = false;
    }

    @Override
    public Deck turn(Deck deck) {
        this.deck = deck;
        reveal();
        while (!end) {
            showHand();
            hit();
            if (hand.isBurst() || hand.getMaxFaceValue() >= 17) {
                end = true;
            }
        }
        showHand();
        return this.deck;
    }

    public void showHand() {
        System.out.println("Dealer:");
        System.out.println(hand.toString(isFirstCardHidden));
    }
}
