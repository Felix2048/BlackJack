package pers.felix.blackjack.entity;

import pers.felix.blackjack.enums.FaceValue;
import pers.felix.blackjack.enums.Suit;

import java.util.Objects;

/**
 * @Title: Card
 * @Description:
 * @author: Felix
 * @date: 10/26/2018 15:56
 **/

public class Card {

    private FaceValue faceValue;

    private Suit suit;

    public Card() {
    }

    public Card(FaceValue faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(FaceValue faceValue) {
        this.faceValue = faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return faceValue.getName() + " of " + suit.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return faceValue == card.faceValue &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceValue, suit);
    }
}
