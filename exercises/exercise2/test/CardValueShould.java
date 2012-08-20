package exercises.exercise2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import exercises.exercise2.CardRank;

public class CardValueShould {
	
	@Test
	public void ResolveAce() {
		assertEquals(CardRank.ACE, CardRank.resolve("A"));
	}

	@Test
	public void ResolveKing() {
		assertEquals(CardRank.KING, CardRank.resolve("K"));
	}
	
	@Test
	public void ResolveQueen() {
		assertEquals(CardRank.QUEEN, CardRank.resolve("Q"));
	}

	@Test
	public void ResolveJack() {
		assertEquals(CardRank.JACK, CardRank.resolve("J"));
	}

	@Test
	public void ResolveTen() {
		assertEquals(CardRank.TEN, CardRank.resolve("10"));
	}

	@Test
	public void ResolveNine() {
		assertEquals(CardRank.NINE, CardRank.resolve("9"));
	}
	
	@Test
	public void ResolveEight() {
		assertEquals(CardRank.EIGHT, CardRank.resolve("8"));
	}

	@Test
	public void ResolveSeven() {
		assertEquals(CardRank.SEVEN, CardRank.resolve("7"));
	}

	@Test
	public void ResolveSix() {
		assertEquals(CardRank.SIX, CardRank.resolve("6"));
	}

	@Test
	public void ResolveFive() {
		assertEquals(CardRank.FIVE, CardRank.resolve("5"));
	}

	@Test
	public void ResolveFour() {
		assertEquals(CardRank.FOUR, CardRank.resolve("4"));
	}

	@Test
	public void ResolveThree() {
		assertEquals(CardRank.THREE, CardRank.resolve("3"));
	}

	@Test
	public void ResolveTwo() {
		assertEquals(CardRank.TWO, CardRank.resolve("2"));
	}

	@Test 
	public void RankCorrectly() {
		assertTrue( CardRank.ACE.compareTo(CardRank.KING) > 0 );
		assertTrue( CardRank.KING.compareTo(CardRank.QUEEN) > 0 );
		assertTrue( CardRank.QUEEN.compareTo(CardRank.JACK) > 0 );
		assertTrue( CardRank.JACK.compareTo(CardRank.TEN) > 0 );
		assertTrue( CardRank.TEN.compareTo(CardRank.NINE) > 0 );
		assertTrue( CardRank.NINE.compareTo(CardRank.EIGHT) > 0 );
		assertTrue( CardRank.EIGHT.compareTo(CardRank.SEVEN) > 0 );
		assertTrue( CardRank.SEVEN.compareTo(CardRank.SIX) > 0 );
		assertTrue( CardRank.SIX.compareTo(CardRank.FIVE) > 0 );
		assertTrue( CardRank.FIVE.compareTo(CardRank.FOUR) > 0 );
		assertTrue( CardRank.FOUR.compareTo(CardRank.THREE) > 0 );
		assertTrue( CardRank.THREE.compareTo(CardRank.TWO) > 0 );
	}

}
