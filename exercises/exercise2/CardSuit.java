package exercises.exercise2;

public enum CardSuit {
	SPADES, HEARTS, CLUBS, DIAMONDS;
	
	public static CardSuit resolve(String suit) {
		switch(suit) {
		case "s":
			return SPADES;
		case "h":
			return HEARTS;
		case "c":
			return CLUBS;
		case "d":
			return DIAMONDS;
		default:
			return null;
		}
	}
}
