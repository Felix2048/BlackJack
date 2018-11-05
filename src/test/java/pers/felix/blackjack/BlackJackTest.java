package pers.felix.blackjack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pers.felix.blackjack.entity.Card;
import pers.felix.blackjack.entity.Deck;
import pers.felix.blackjack.entity.Hand;
import pers.felix.blackjack.enums.FaceValue;
import pers.felix.blackjack.enums.Suit;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    private Deck deck = new Deck();
    private Hand hand = new Hand();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addCardTest() {
    }

    @Test
    public void getFaceValuesTest() {
        hand.addCard(new Card(FaceValue.ACE, Suit.Spade));
        hand.addCard(new Card(FaceValue.ACE, Suit.Spade));
        Assert.assertEquals(2, hand.getFaceValues().get(0).intValue());
        Assert.assertEquals(12, hand.getFaceValues().get(1).intValue());
        Assert.assertEquals(22, hand.getFaceValues().get(2).intValue());

//        Card card1 = deck.extractCard();
//        Card card2 = deck.extractCard();
//        hand.addCard(card1);
//        hand.addCard(card2);
//        Assert.assertEquals(card1.getFaceValue().getValues().get(0) + card2.getFaceValue().getValues().get(0), hand.getFaceValues().get(0).intValue());
    }

    @Test
    public void isBlackJackTest() {
        hand.addCard(new Card(FaceValue.ACE, Suit.Spade));
        hand.addCard(new Card(FaceValue.ACE, Suit.Spade));
        hand.addCard(new Card(FaceValue.NINE, Suit.Spade));
        Assert.assertTrue(!hand.isBlackJack());
    }

    @Test
    public void isPairTest() {
        hand.addCard(new Card(FaceValue.ACE, Suit.Spade));
        hand.addCard(new Card(FaceValue.ACE, Suit.Spade));
        Assert.assertTrue(hand.isPair());
    }

}
