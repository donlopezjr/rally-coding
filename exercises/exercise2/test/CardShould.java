package exercises.exercise2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import exercises.exercise2.Card;
import exercises.exercise2.CardSuit;
import exercises.exercise2.CardRank;
import exercises.exercise2.InvalidCardException;

public class CardShould {
	
	@Test
	public void LoadCorrectly() throws InvalidCardException {
		Card card = new Card("Ah");
		assertEquals(CardSuit.HEARTS, card.getSuit());
		assertEquals(CardRank.ACE, card.getRank());
	}
	
	@Test
	public void LoadTwoDigitValueCorrectly() throws InvalidCardException {
		Card card = new Card("10d");
		assertEquals(CardSuit.DIAMONDS, card.getSuit());
		assertEquals(CardRank.TEN, card.getRank());
		
	}
	
	@Test
	public void CompareCorrectly() throws InvalidCardException {
		Card card1 = new Card("10d");
		Card card2 = new Card("Ah");
		
		assertTrue(card1.compareTo(card2) < 0);
	}
	
	@Test
	public void RejectInvalidInput() {
		Card card = null;
		
		try {
			card = new Card("9q");
			fail();
		}
		catch (InvalidCardException ex) {
			
		}
		
		assert(card == null);
	}
}
