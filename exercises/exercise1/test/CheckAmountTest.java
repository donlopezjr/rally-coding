package exercises.exercise1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise1.CheckAmount;
import exercises.exercise1.NumberTooLargeException;

public class CheckAmountTest {
	private CheckAmount checkAmount;

	@Before
	public void init() {
		checkAmount = new CheckAmount();
	}
	
	@Test
	public void CheckAmountDefaultsToZero () {
		assertEquals("Zero and 00/100 dollars", checkAmount.toString());
	}
	
	@Test
	public void CheckAmountTestDecimal() throws NumberTooLargeException {
		checkAmount.setValue("23.04");
		assertEquals("Twenty-three and 04/100 dollars", checkAmount.toString());
	}
}
