package pers.felix.blackjack.entity;

import pers.felix.blackjack.enums.FaceValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @Title: Hand
 * @Description:
 * @author: Felix
 * @date: 10/26/2018 15:57
 **/

public class Hand {

    private ArrayList<Card> cards = new ArrayList<>();

    public int getSize() {
        return cards.size();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Add a card to the hand
     *
     * @param card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Get a sorted array of face values of the hand
     *
     * @return faceValues
     */
    public ArrayList<Integer> getFaceValues() {
        ArrayList<Integer> faceValues = new ArrayList<>();
        faceValues.add(0);

        for (Card card : cards) {
            FaceValue faceValue = card.getFaceValue();
            int currentSize = faceValues.size();
            if (faceValue != FaceValue.ACE) {
                for (int i = 0; i < currentSize; i++) {
                    faceValues.set(i, faceValues.get(i) + faceValue.getValues().get(0));
                }
            } else {
                for (int i = 0; i < currentSize; i++) {
                    faceValues.add(faceValues.get(i) + faceValue.getValues().get(1));
                    faceValues.set(i, faceValues.get(i) + faceValue.getValues().get(0));
                }
            }
        }
        faceValues = getSingle(faceValues);
        Collections.sort(faceValues);
        return faceValues;
    }

    /**
     * Get the face value which is the closest to 21
     * @return
     */
    public int getMaxFaceValue() {
        int max = -1;
        ArrayList<Integer> faceValues = getFaceValues();
        for (Integer value: faceValues) {
            if (value > 21) {
                break;
            }
            max = max > value ? max : value;
        }
        return max;
    }


    public boolean isBlackJack() {
        return cards.size() == 2 && getFaceValues().contains(21);
    }

    public boolean isBurst() {
        return getFaceValues().get(0) > 21;
    }

    public boolean isPair() {
        return cards.size() == 2 && cards.get(0).getFaceValue() == cards.get(1).getFaceValue();
    }

    public void clear() {
        cards.clear();
    }

    public Hand splitHand() {
        Hand newHand = new Hand();
        if (getSize() == 2) {
            newHand.addCard(cards.get(1));
            cards.remove(1);
        }
        return newHand;
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean isFirstCardHidden) {
        StringBuilder  str = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            str.append("Card " + i + ": ");
            if (i == 0 && isFirstCardHidden) {
                str.append("Hidden");
            }
            else {
                str.append(cards.get(i).toString());
            }
            str.append("\n");
        }
        if (!isFirstCardHidden) {
            if (isBlackJack()) {
                str.append("Black Jack!");
            }
            else if (isBurst()) {
                str.append("Burst! Face value: ").append(getFaceValues().get(0));
            }
            else {
                str.append("Hand face value: ");
                ArrayList<Integer> faceValues = getFaceValues();
                for (int i = 0; i < faceValues.size(); i++) {
                    if (faceValues.get(i) <= 21) {
                        if (i > 0) {
                            str.append(" / ");
                        }
                        str.append(faceValues.get(i));
                    }
                }
            }
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * 去除重复元素
     * @param list
     * @return newList
     */
    private ArrayList<Integer> getSingle(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer obj = it.next();
            if (!newList.contains(obj)) {
                newList.add(obj);
            }
        }
        return newList;
    }

}
