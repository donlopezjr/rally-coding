package exercises.exercise2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import exercises.exercise2.CardSuit;

public class CardSuitShould {

	@Test
	public void ResolveHearts() {
		assertEquals(CardSuit.HEARTS, CardSuit.resolve("h"));
	}
	
	@Test
	public void ResolveDiamonds() {
		assertEquals(CardSuit.DIAMONDS, CardSuit.resolve("d"));
	}
	
	@Test
	public void ResolveClubs() {
		assertEquals(CardSuit.CLUBS, CardSuit.resolve("c"));
	}
	
	@Test
	public void ResolveSpades() {
		assertEquals(CardSuit.SPADES, CardSuit.resolve("s"));
	}
	
	
}
