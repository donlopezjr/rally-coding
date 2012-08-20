package exercises.exercise1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise1.CheckAmount;
import exercises.exercise1.NumberTooLargeException;

public class CheckAmountTestIrregulars {

	private CheckAmount checkAmount;

	@Before
	public void init() {
		checkAmount = new CheckAmount();		
	}
	
	@Test
	public void CheckAmountOne() throws NumberTooLargeException {
		checkAmount.setValue("1");
		assertEquals("One and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountTwo() throws NumberTooLargeException {
		checkAmount.setValue("2");
		assertEquals("Two and 00/100 dollars", checkAmount.toString());
	}	
	
	@Test
	public void CheckAmountThree() throws NumberTooLargeException {
		checkAmount.setValue("3");
		assertEquals("Three and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountFour() throws NumberTooLargeException {
		checkAmount.setValue("4");
		assertEquals("Four and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountFive() throws NumberTooLargeException {
		checkAmount.setValue("5");
		assertEquals("Five and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountSix() throws NumberTooLargeException {
		checkAmount.setValue("6");
		assertEquals("Six and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountSeven() throws NumberTooLargeException {
		checkAmount.setValue("7");
		assertEquals("Seven and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountEight() throws NumberTooLargeException {
		checkAmount.setValue("8");
		assertEquals("Eight and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountNine() throws NumberTooLargeException {
		checkAmount.setValue("9");
		assertEquals("Nine and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountTen() throws NumberTooLargeException {
		checkAmount.setValue("10");
		assertEquals("Ten and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountEleven() throws NumberTooLargeException {
		checkAmount.setValue("11");
		assertEquals("Eleven and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountTwelve() throws NumberTooLargeException {
		checkAmount.setValue("12");
		assertEquals("Twelve and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountThirteen() throws NumberTooLargeException {
		checkAmount.setValue("13");
		assertEquals("Thirteen and 00/100 dollars", checkAmount.toString());
	}

	@Test
	public void CheckAmountFourteen() throws NumberTooLargeException {
		checkAmount.setValue("14");
		assertEquals("Fourteen and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountFifteen() throws NumberTooLargeException {
		checkAmount.setValue("15");
		assertEquals("Fifteen and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountSixteen() throws NumberTooLargeException {
		checkAmount.setValue("16");
		assertEquals("Sixteen and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountSeventeen() throws NumberTooLargeException {
		checkAmount.setValue("17");
		assertEquals("Seventeen and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountEighteen() throws NumberTooLargeException {
		checkAmount.setValue("18");
		assertEquals("Eighteen and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountNineteen() throws NumberTooLargeException {
		checkAmount.setValue("19");
		assertEquals("Nineteen and 00/100 dollars", checkAmount.toString());
	}
	
	
	
	
}
