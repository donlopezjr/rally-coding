package exercises.exercise2;

/**
 * Enumerates all card suits and defines how the text-based shorthand
 * maps to actual suits
 * 
 * @author donlopezjr
 *
 */
public enum CardSuit {
	SPADES, HEARTS, CLUBS, DIAMONDS;
	
	/**
	 * Resolve a text-based shorthand for the rank into a typesafe value
	 * 
	 * @param suit
	 * @return
	 */
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
