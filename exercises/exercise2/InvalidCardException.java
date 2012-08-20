package exercises.exercise2;

/**
 * Indicates that a card could not be parsed
 * 
 * @author don
 *
 */
public class InvalidCardException extends Exception {
	private static final long serialVersionUID = -5887081264036390783L;

	public InvalidCardException(String Card) {
		super("The card "+Card+" is not a legal card shorthand");
	}
}
