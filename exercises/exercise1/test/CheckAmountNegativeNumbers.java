package exercises.exercise1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise1.CheckAmount;
import exercises.exercise1.NumberTooLargeException;

public class CheckAmountNegativeNumbers {
	CheckAmount checkAmount;

	@Before
	public void init() {
		checkAmount = new CheckAmount();
	}

	@Test
	public void CheckAmountTestHundreds() throws NumberTooLargeException {
		checkAmount.setValue("-523.04");
		assertEquals("(Five hundred twenty-three and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestThousands() throws NumberTooLargeException {
		checkAmount.setValue("-2523.04");
		assertEquals(
				"(Two thousand five hundred twenty-three and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestThousandsWithWholeGroupZeroed()
			throws NumberTooLargeException {
		checkAmount.setValue("-2000.04");
		assertEquals("(Two thousand and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestTenThousands() throws NumberTooLargeException {
		checkAmount.setValue("-52523.04");
		assertEquals(
				"(Fifty-two thousand five hundred twenty-three and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestHundredThousands()
			throws NumberTooLargeException {
		checkAmount.setValue("-522523.04");
		assertEquals(
				"(Five hundred twenty-two thousand five hundred twenty-three and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestHundredThousandsWithZero()
			throws NumberTooLargeException {
		checkAmount.setValue("-502523.04");
		assertEquals(
				"(Five hundred two thousand five hundred twenty-three and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestHundredThousandsWithZeros()
			throws NumberTooLargeException {
		checkAmount.setValue("-500523.04");
		assertEquals(
				"(Five hundred thousand five hundred twenty-three and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestMillions() throws NumberTooLargeException {
		checkAmount.setValue("-3522523.04");
		assertEquals(
				"(Three million five hundred twenty-two thousand five hundred twenty-three and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestMillionsWithWholeGroupZeroed()
			throws NumberTooLargeException {
		checkAmount.setValue("-3000523.04");
		assertEquals(
				"(Three million five hundred twenty-three and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTestMillionsWithTwoGroupsZeroed()
			throws NumberTooLargeException {
		checkAmount.setValue("-3000000.04");
		assertEquals("(Three million and 04/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountTrillions() throws NumberTooLargeException {
		checkAmount.setValue("-15948755667598.20");
		assertEquals("(Fifteen trillion " + "nine hundred forty-eight billion "
				+ "seven hundred fifty-five million "
				+ "six hundred sixty-seven thousand "
				+ "five hundred ninety-eight and 20/100 dollars)",
				checkAmount.toString());
	}

	@Test
	public void CheckAmountZillions() throws NumberTooLargeException {
		checkAmount.setValue("-901231292342319234211233720368548.99");
		assertEquals("(Nine hundred one nonillion "
				+ "two hundred thirty-one octillion "
				+ "two hundred ninety-two septillion "
				+ "three hundred forty-two sextillion "
				+ "three hundred nineteen quintillion "
				+ "two hundred thirty-four quadrillion "
				+ "two hundred eleven trillion "
				+ "two hundred thirty-three billion "
				+ "seven hundred twenty million "
				+ "three hundred sixty-eight thousand "
				+ "five hundred forty-eight " + "and 99/100 dollars)",
				checkAmount.toString());

	}

	@Test
	public void CheckAmountZillionsZeroedGroups()
			throws NumberTooLargeException {
		checkAmount.setValue("-901231000342319234211000000368548.99");
		assertEquals("(Nine hundred one nonillion "
				+ "two hundred thirty-one octillion "
				+ "three hundred forty-two sextillion "
				+ "three hundred nineteen quintillion "
				+ "two hundred thirty-four quadrillion "
				+ "two hundred eleven trillion "
				+ "three hundred sixty-eight thousand "
				+ "five hundred forty-eight " + "and 99/100 dollars)",
				checkAmount.toString());

	}

}
