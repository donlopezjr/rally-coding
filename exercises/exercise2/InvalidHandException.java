package exercises.exercise2;

/**
 * Thrown to indicate that a bad hand was given
 * 
 * @author donlopezjr
 *
 */
public class InvalidHandException extends Exception {
	private static final long serialVersionUID = 6852223843899686480L;

	public InvalidHandException() {
		super("A hand consists of exactly 5 valid cards");
	}
}
