package exercises.exercise1;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * Input:  String (parseable by BigDecimal class) of a number in decimal format.
 * Output: Text-based representation appropriate for printing on a check. 
 * 
 * @author donlopezjr
 *
 */
public class CheckAmount {
	// Numbers that can't be composed algorithmically from other numbers
	private String[] irregulars = { "", "one", "two", "three", "four",
			"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen" };

	// Numbers representing the tens place used to compose two-digit numbers
	private String[] tens = { "", "", "twenty", "thirty", "forty", "fifty",
			"sixty", "seventy", "eighty", "ninety" };

	// Names representing powers of 1000 for large numbers
	private String[] largeNames = { "", "thousand", "million", "billion",
			"trillion", "quadrillion", "quintillion", "sextillion",
			"septillion", "octillion", "nonillion" };

	private BigDecimal value = new BigDecimal(0);
	private BigDecimal maxValue;
	
	public CheckAmount() {
		// Determine the maximum number that can be represented, based on the contents of the largeNames array
		maxValue = new BigDecimal(1000);
		maxValue = maxValue.pow(largeNames.length);
		maxValue = maxValue.subtract(new BigDecimal(0.01));
		maxValue = maxValue.setScale(2, RoundingMode.HALF_UP);

	}
	
	public String toString() {
		StringBuilder result = new StringBuilder(getBaseNumberAsString());

		result.append(getCentsString());

		result.append(" dollars");

		// Capitalize result
		result.setCharAt(0, Character.toUpperCase(result.charAt(0)));

		// Put parentheses around negative numbers
		if (value.compareTo(new BigDecimal(0)) < 0) {
			result.insert(0, "(");
			result.append(")");
		}
		return result.toString();
	}

	/**
	 * Convert the portion of the number after the decimal point
	 * into a string representation.
	 * 
	 * @return The cents portion of the string
	 */
	private String getCentsString() {
		// Get the part after the decimal point, ignoring sign
		BigDecimal remainder = value.remainder(new BigDecimal(1));
		remainder = remainder.abs();
		
		long cents = Math.round(remainder.doubleValue() * 100);
		return String.format(" and %02d/100", cents);
	}

	/**
	 * Convert the portion of the number before the decimal point 
	 * into its string representation.
	 * 
	 * @return The string representation of the base number
	 */
	private String getBaseNumberAsString() {
		StringBuilder result;
		int threeSet;
		int thousandsPower = 0;
		BigDecimal bdThous = new BigDecimal(1000);
		BigDecimal bdZero = new BigDecimal(0);
		
		// Get integer part of number and ignore sign
		BigDecimal value = this.value.divideToIntegralValue(new BigDecimal(1)).abs();

		result = new StringBuilder();

		if (value.compareTo(bdZero) == 0) {
			result.append("zero");
			return result.toString();
		}
		
		do {
			// Use last three digits for each iteration
			threeSet = value.remainder(bdThous).intValue();
			value = value.divideToIntegralValue(bdThous);

			// Insert text according to how many powers of one thousand this
			// group represents
			if (thousandsPower > 0 && threeSet > 0) {
				result.insert(0, " " + largeNames[thousandsPower]);
			}

			if (threeSet > 0) {
				result.insert(0, getThreeSetAsString(threeSet));
				// Add spacing if there is more to the left
				if (value.compareTo(bdZero) > 0)
					result.insert(0, " ");
			}

			// Increment how many powers of one thousand we have for the
			// remaining value
			thousandsPower++;

		} while (value.compareTo(bdZero) > 0);

		return result.toString();
	}

	/**
	 * Converts an individual three-digit sequence into its string
	 * representation.
	 * 
	 * @param value an integer from 0-999
	 * @return The string representation of a three-digit sequence
	 */
	private String getThreeSetAsString(int value) {
		StringBuilder result = new StringBuilder();

		int ones;
		int hundreds;
		// Seperate last two digits out for separate processing
		hundreds = value / 100;
		value = value % 100;

		// Handle last two digits
		if (value < 20) {
			result.insert(0, irregulars[value]);
		} else {
			ones = value % 10;
			if (ones > 0)
				result.insert(0, "-" + irregulars[ones]);

			result.insert(0, tens[value / 10]);
		}

		// Insert hundreds text
		if (hundreds > 0) {
			// Space after 'hundred' if there is a value after it
			if (value > 0)
				result.insert(0, " ");

			result.insert(0, irregulars[hundreds] + " hundred");
		}

		return result.toString();
	}

	/**
	 * Sets the underlying decimal number
	 * 
	 * @param decimalNumber 
	 * @throws NumberTooLargeException
	 */
	public void setValue(String decimalNumber) throws NumberTooLargeException {
		BigDecimal value = new BigDecimal(decimalNumber);
		
		// Check that the absolute value of this new number does not exceed our maximum
		if (value.abs().compareTo(maxValue) > 0)
			throw new NumberTooLargeException();
			
		this.value = value;
	}

}
