package exercises.exercise2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import exercises.exercise2.PokerHandRank;

public class PokerHandRankShould {

	@Test
	public void RankCorrectly() {
		assertTrue(PokerHandRank.STRAIGHT_FLUSH.compareTo(PokerHandRank.FOUR_OF_A_KIND) > 0);
		assertTrue(PokerHandRank.FOUR_OF_A_KIND.compareTo(PokerHandRank.FULL_HOUSE) > 0);
		assertTrue(PokerHandRank.FULL_HOUSE.compareTo(PokerHandRank.FLUSH) > 0);
		assertTrue(PokerHandRank.FLUSH.compareTo(PokerHandRank.STRAIGHT) > 0);
		assertTrue(PokerHandRank.STRAIGHT.compareTo(PokerHandRank.THREE_OF_A_KIND) > 0);
		assertTrue(PokerHandRank.THREE_OF_A_KIND.compareTo(PokerHandRank.TWO_PAIR) > 0);
		assertTrue(PokerHandRank.TWO_PAIR.compareTo(PokerHandRank.PAIR) > 0);
		assertTrue(PokerHandRank.PAIR.compareTo(PokerHandRank.HIGH_CARD) > 0);
		
	}
}
