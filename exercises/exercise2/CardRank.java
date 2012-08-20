package exercises.exercise2;

public enum CardRank {
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
	
	public static CardRank resolve(String value) {
		switch (value) {
		case "A":
			return ACE;
		case "K":
			return KING;
		case "Q":
			return QUEEN;
		case "J":
			return JACK;
		case "10":
			return TEN;
		case "9":
			return NINE;
		case "8":
			return EIGHT;
		case "7":
			return SEVEN;
		case "6":
			return SIX;
		case "5":
			return FIVE;
		case "4":
			return FOUR;
		case "3":
			return THREE;
		case "2":
			return TWO;
		default:
			return null;
		}
		
		
	}
}
