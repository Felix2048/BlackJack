package pers.felix.blackjack.entity;


import pers.felix.blackjack.enums.FaceValue;
import pers.felix.blackjack.enums.Suit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Title: Deck
 * @Description:
 * @author: Felix
 * @date: 10/26/2018 15:56
 **/

public class Deck {

    private final int pokerCountWithoutJokers = 52;

    private ArrayList<Card> cards;

    public Deck() {
        init();
    }

    /**
     *  Initialize a deck of cards
     */
    public void init() {
        this.cards = new ArrayList<Card>(52);
        final Set<Suit> suits = new HashSet<>();
        suits.add(Suit.Spade);
        suits.add(Suit.Heart);
        suits.add(Suit.Diamond);
        suits.add(Suit.Club);
        final Set<FaceValue> faceValues = new HashSet<>();
        faceValues.add(FaceValue.ACE);
        faceValues.add(FaceValue.TWO);
        faceValues.add(FaceValue.THREE);
        faceValues.add(FaceValue.FOUR);
        faceValues.add(FaceValue.FIVE);
        faceValues.add(FaceValue.SIX);
        faceValues.add(FaceValue.SEVEN);
        faceValues.add(FaceValue.NINE);
        faceValues.add(FaceValue.TEN);
        faceValues.add(FaceValue.JACK);
        faceValues.add(FaceValue.QUEEN);
        faceValues.add(FaceValue.KING);
        for (int i = 0; i < pokerCountWithoutJokers; i++) {
            for(Suit suit: suits) {
                for (FaceValue faceValue: faceValues) {
                    cards.add(new Card(faceValue, suit));
                }
            }
        }
    }

    public int getSize() {
        return cards.size();
    }

    /**
     * Extract a card from the deck (remove the card from the deck)
     * @return Card
     */
    public Card extractCard() {
        int randomIndex = new Random().nextInt(getSize());
        Card card = cards.get(randomIndex);
        cards.remove(randomIndex);
        return card;
    }

}
