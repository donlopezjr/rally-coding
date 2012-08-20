package exercises.exercise1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise1.CheckAmount;
import exercises.exercise1.NumberTooLargeException;

public class CheckAmountTestDoubleDigit {
	private CheckAmount checkAmount;

	@Before
	public void init() {
		checkAmount = new CheckAmount();
	}

	@Test
	public void CheckAmountTwenty() throws NumberTooLargeException {
		checkAmount.setValue("20");
		assertEquals("Twenty and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountTwentyOne() throws NumberTooLargeException {
		checkAmount.setValue("21");
		assertEquals("Twenty-one and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountThirtyTwo() throws NumberTooLargeException {
		checkAmount.setValue("32");
		assertEquals("Thirty-two and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountFortyThree() throws NumberTooLargeException {
		checkAmount.setValue("43");
		assertEquals("Forty-three and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountFiftyFour() throws NumberTooLargeException {
		checkAmount.setValue("54");
		assertEquals("Fifty-four and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountSixtyFive() throws NumberTooLargeException {
		checkAmount.setValue("65");
		assertEquals("Sixty-five and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountSeventySix() throws NumberTooLargeException {
		checkAmount.setValue("76");
		assertEquals("Seventy-six and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountEightySeven() throws NumberTooLargeException {
		checkAmount.setValue("87");
		assertEquals("Eighty-seven and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountNinetyEight() throws NumberTooLargeException {
		checkAmount.setValue("98");
		assertEquals("Ninety-eight and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountNinetyNine() throws NumberTooLargeException {
		checkAmount.setValue("99");
		assertEquals("Ninety-nine and 00/100 dollars", checkAmount.toString());
	}

}
