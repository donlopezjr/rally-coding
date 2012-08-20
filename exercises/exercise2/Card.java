package exercises.exercise2;

/**
 * Represents a single playing card, with its rank and suit.
 *
 * @author donlopezjr
 *
 */
public class Card implements Comparable<Card> {
	private CardSuit suit = null;
	private CardRank rank = null;
	
	/**
	 * Construct an instance of a card from the text-based shorthand.
	 * 
	 * @param card Righthand character represents the suit, the rest represents the rank
	 */
	public Card(String card) throws InvalidCardException {
		suit = CardSuit.resolve(card.substring(card.length() - 1));
		rank = CardRank.resolve(card.substring(0, card.length() - 1));
		
		if (suit == null || rank == null)
			throw new InvalidCardException(card);
	}

	public CardSuit getSuit() {
		return suit;
	}

	public CardRank getRank() {
		return rank;
	}

	/**
	 * By default, order cards by their rank.
	 */
	@Override
	public int compareTo(Card o) {
		return rank.compareTo(o.getRank());
	}

}
