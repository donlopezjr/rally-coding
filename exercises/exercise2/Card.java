package exercises.exercise2;

public class Card implements Comparable<Card> {
	private CardSuit suit = null;
	private CardRank value = null;
	
	public Card(String card) {
		suit = CardSuit.resolve(card.substring(card.length() - 1));
		value = CardRank.resolve(card.substring(0, card.length() - 1));
	}

	public CardSuit getSuit() {
		return suit;
	}

	public CardRank getValue() {
		return value;
	}

	@Override
	public int compareTo(Card o) {
		return value.compareTo(o.getValue());
	}

}
