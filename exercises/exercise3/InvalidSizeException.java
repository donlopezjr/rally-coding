package exercises.exercise3;

public class InvalidSizeException extends Exception {

	private static final long serialVersionUID = -6035879350441178287L;

	public InvalidSizeException() {
		super("The size must be greater than or equal to 0");
	}
}
