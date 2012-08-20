package exercises.exercise2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise2.InvalidCardException;
import exercises.exercise2.InvalidHandException;
import exercises.exercise2.PokerHand;
import exercises.exercise2.PokerHandRank;

public class PokerHandShould {

	private PokerHand pokerHand;

	@Before
	public void init() {
		pokerHand = new PokerHand();

	}

	@Test
	public void SuccessfullyLoadHand() throws InvalidHandException, InvalidCardException {

		pokerHand.loadHand("Ah As 10c 7d 6s");

	}
	
	@Test
	public void RejectTooManyCards() throws InvalidCardException {
		
		try {
			pokerHand.loadHand("Ah As 10c 7d 6s 7s Qh");
			fail();
		}
		catch (InvalidHandException ex) {
			
		}
		
	}
	@Test
	public void RejectTooFewCards() throws InvalidCardException {
		
		try {
			pokerHand.loadHand("Ah As 10c 7d");
			fail();
		}
		catch (InvalidHandException ex) {
			
		}
		
	}
	
	@Test
	public void RejectInvalidCards() throws InvalidHandException {
		
		try {
			pokerHand.loadHand("Ah As 10c 7x 6s");
			fail();
		}
		catch (InvalidCardException ex) {
						
		}
	}


	@Test
	public void DetectPair() throws InvalidHandException, InvalidCardException {

		pokerHand.loadHand("Ah As 10c 7d 6s");

		assertEquals(PokerHandRank.PAIR, pokerHand.getRank());
	}
	
	@Test
	public void DetectTwoPair() throws InvalidHandException, InvalidCardException {
		
		pokerHand.loadHand("Kh Kc 3s 3h 2d");
		
		assertEquals(PokerHandRank.TWO_PAIR, pokerHand.getRank());
	}
	
	@Test
	public void DetectThreeOfAKind() throws InvalidHandException, InvalidCardException {
		pokerHand.loadHand("Qs Qc 5s Qd 3c");
		
		assertEquals(PokerHandRank.THREE_OF_A_KIND, pokerHand.getRank());
		
	}
	
	@Test
	public void DetectStraight() throws InvalidHandException, InvalidCardException {
		pokerHand.loadHand("6h 8s 5h 7s 4s");
		
		assertEquals(PokerHandRank.STRAIGHT, pokerHand.getRank());
	}
	
	@Test
	public void DetectAceLowStraight() throws InvalidHandException, InvalidCardException {
		pokerHand.loadHand("Ah 4h 2c 5h 3h");
		
		assertEquals(PokerHandRank.STRAIGHT, pokerHand.getRank());
		
	}
	
	@Test
	public void DetectFlush() throws InvalidHandException, InvalidCardException {
		pokerHand.loadHand("Ah Qh 10h 5h 3h");
		
		assertEquals(PokerHandRank.FLUSH, pokerHand.getRank());
		
	}
	
	@Test
	public void DetectFullHouse() throws InvalidHandException, InvalidCardException {
		
		pokerHand.loadHand("10s 4s 10h 4d 10d");
		
		assertEquals(PokerHandRank.FULL_HOUSE, pokerHand.getRank());
	
	}
	
	@Test
	public void DetectFourOfAKind() throws InvalidHandException, InvalidCardException {
		
		pokerHand.loadHand("10s 5d 10h 10c 10d");
		
		assertEquals(PokerHandRank.FOUR_OF_A_KIND, pokerHand.getRank());
		
		
	}
	
	@Test
	public void DetectStraightFlush() throws InvalidHandException, InvalidCardException {
		
		pokerHand.loadHand("6h 4h 3h 7h 5h");
		
		assertEquals(PokerHandRank.STRAIGHT_FLUSH, pokerHand.getRank());
	}
	
	@Test
	public void DetectAceLowStraightFlush() throws InvalidHandException, InvalidCardException {
		pokerHand.loadHand("Ah 4h 2h 5h 3h");
		
		assertEquals(PokerHandRank.STRAIGHT_FLUSH, pokerHand.getRank());
		
	}
	
	@Test
	public void DetectOnlyHighCard() throws InvalidHandException, InvalidCardException {

		pokerHand.loadHand("Ah Qs 10c 7d 6s");

		assertEquals(PokerHandRank.HIGH_CARD, pokerHand.getRank());
	}
}
