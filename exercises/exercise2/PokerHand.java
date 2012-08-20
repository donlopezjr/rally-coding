package exercises.exercise2;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Represents a 5-card poker hand.  Parses the text-based hand and 
 * determines rank for the hand.
 * 
 * @author donlopezjr
 *
 */
public class PokerHand {

	private Card[] cards = new Card[5];

	/**
	 * Loads the hand, replacing any previous hand
	 * 
	 * @param hand String representation of hand
	 */
	public void loadHand(String hand) throws InvalidHandException, InvalidCardException {
		int k = 0;
		
		StringTokenizer st = new StringTokenizer(hand);
		while (st.hasMoreTokens()) {
			try {
				cards[k] = new Card(st.nextToken());
			}
			catch (ArrayIndexOutOfBoundsException ex) {
				// There were more than five cards passed
				throw new InvalidHandException();
			}
			
			k++;
		}
		
		// Less than five cards were given
		if (k < 5) {
			throw new InvalidHandException();
		}

		Arrays.sort(cards);
	}

	/**
	 * Determines the rank of this hand according to standard 5-card poker rules
	 * 
	 * @return The rank of this hand
	 */
	public PokerHandRank getRank() {

		int pairCount = 0;
		int tripCount = 0;
		int quadCount = 0;

		// Get counts of each card, grouped by card rank
		Map<CardRank, Integer> valueInstances = getValueInstances();
		
		// Iterate through this list and determine presence of pairs/three of a kind/four of a kind
		Set<Entry<CardRank, Integer>> entrySet = valueInstances.entrySet();
		Iterator<Entry<CardRank, Integer>> it = entrySet.iterator();
		Entry<CardRank, Integer> entry;

		while (it.hasNext()) {
			entry = it.next();
			if (entry.getValue() == 2)
				pairCount++;
			else if (entry.getValue() == 3)
				tripCount++;
			else if (entry.getValue() == 4)
				quadCount++;
		}

		// Test for poker hands and return the highest hand ranking that applies to our hand
		if (hasFlush() && hasStraight()) {
			return PokerHandRank.STRAIGHT_FLUSH;
		}
		if (quadCount > 0) {
			return PokerHandRank.FOUR_OF_A_KIND;
		}
		if (tripCount > 0 && pairCount > 0) {
			return PokerHandRank.FULL_HOUSE;
		}
		if (hasFlush()) {
			return PokerHandRank.FLUSH;
		}
		if (hasStraight()) {
			return PokerHandRank.STRAIGHT;
		}
		if (tripCount > 0) {
			return PokerHandRank.THREE_OF_A_KIND;
		}
		if (pairCount == 2) {
			return PokerHandRank.TWO_PAIR;
		}
		if (pairCount == 1) {
			return PokerHandRank.PAIR;
		}

		return PokerHandRank.HIGH_CARD;
	}

	/**
	 * Tests for a flush by comparing the suits of all cards in the hand
	 * 
	 * @return whether or not a flush exists
	 */
	private boolean hasFlush() {
		if (cards[0].getSuit() == cards[1].getSuit()
				&& cards[0].getSuit() == cards[2].getSuit()
				&& cards[0].getSuit() == cards[3].getSuit()
				&& cards[0].getSuit() == cards[4].getSuit()) {
			return true;
		}

		return false;
	}

	/**
	 * Looks for a 5-card series of sequential rank.  Works for Aces high
	 * or Aces low. 
	 * 
	 * Assumes that the cards have been sorted
	 * 
	 * @return true if the hand has a straight
	 */
	private boolean hasStraight() {
		if (cards[4].getRank() == CardRank.ACE
				&& cards[0].getRank() == CardRank.TWO) {
			
			// Possible ace-low straight
			
			if (
					cards[1].getRank() == CardRank.THREE && 
					cards[2].getRank() == CardRank.FOUR &&
					cards[3].getRank() == CardRank.FIVE) {
				
				return true;
				
			}
		} else {
			if (cards[0].getRank().ordinal() == cards[1].getRank().ordinal() - 1
					&& cards[1].getRank().ordinal() == cards[2].getRank()
							.ordinal() - 1
					&& cards[2].getRank().ordinal() == cards[3].getRank()
							.ordinal() - 1
					&& cards[3].getRank().ordinal() == cards[4].getRank()
							.ordinal() - 1

			) {
				return true;
			}

		}
		
		return false;
	}

	/**
	 * Determines the frequency of each card rank to determine presence of pairs,
	 * three/four of a kind.
	 * 
	 * @return Map of card rank to frequency of the card rank in the current hand
	 */
	private Map<CardRank, Integer> getValueInstances() {
		
		Map<CardRank, Integer> instances = new EnumMap<CardRank, Integer>(
				CardRank.class);
		CardRank thisValue;
		Integer thisCount;

		for (int i = 0; i < cards.length; i++) {
			thisValue = cards[i].getRank();
			thisCount = instances.get(thisValue);

			if (thisCount == null)
				instances.put(thisValue, 1);
			else
				instances.put(thisValue, ++thisCount);

		}

		return instances;
	}

}
