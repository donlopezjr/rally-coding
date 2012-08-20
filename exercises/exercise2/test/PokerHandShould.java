package exercises.exercise2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise2.PokerHand;
import exercises.exercise2.PokerHandRank;

public class PokerHandShould {

	private PokerHand pokerHand;

	@Before
	public void init() {
		pokerHand = new PokerHand();

	}

	@Test
	public void SuccessfullyLoadHand() {

		pokerHand.loadHand("Ah As 10c 7d 6s");

	}

	@Test
	public void DetectPair() {

		pokerHand.loadHand("Ah As 10c 7d 6s");

		assertEquals(PokerHandRank.PAIR, pokerHand.getRank());
	}
	
	@Test
	public void DetectTwoPair() {
		
		pokerHand.loadHand("Kh Kc 3s 3h 2d");
		
		assertEquals(PokerHandRank.TWO_PAIR, pokerHand.getRank());
	}
	
	@Test
	public void DetectThreeOfAKind() {
		pokerHand.loadHand("Qs Qc 5s Qd 3c");
		
		assertEquals(PokerHandRank.THREE_OF_A_KIND, pokerHand.getRank());
		
	}
	
	@Test
	public void DetectStraight() {
		pokerHand.loadHand("6h 8s 5h 7s 4s");
		
		assertEquals(PokerHandRank.STRAIGHT, pokerHand.getRank());
	}
	
	@Test
	public void DetectAceLowStraight() {
		pokerHand.loadHand("Ah 4h 2c 5h 3h");
		
		assertEquals(PokerHandRank.STRAIGHT, pokerHand.getRank());
		
	}
	
	@Test
	public void DetectFlush() {
		pokerHand.loadHand("Ah Qh 10h 5h 3h");
		
		assertEquals(PokerHandRank.FLUSH, pokerHand.getRank());
		
	}
	
	@Test
	public void DetectFullHouse() {
		
		pokerHand.loadHand("10s 4s 10h 4d 10d");
		
		assertEquals(PokerHandRank.FULL_HOUSE, pokerHand.getRank());
	
	}
	
	@Test
	public void DetectFourOfAKind() {
		
		pokerHand.loadHand("10s 5d 10h 10c 10d");
		
		assertEquals(PokerHandRank.FOUR_OF_A_KIND, pokerHand.getRank());
		
		
	}
	
	@Test
	public void DetectStraightFlush() {
		
		pokerHand.loadHand("6h 4h 3h 7h 5h");
		
		assertEquals(PokerHandRank.STRAIGHT_FLUSH, pokerHand.getRank());
	}
	
	@Test
	public void DetectAceLowStraightFlush() {
		pokerHand.loadHand("Ah 4h 2h 5h 3h");
		
		assertEquals(PokerHandRank.STRAIGHT_FLUSH, pokerHand.getRank());
		
	}
	

}
