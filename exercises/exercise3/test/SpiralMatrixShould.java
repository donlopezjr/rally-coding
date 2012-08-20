package exercises.exercise3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise3.InvalidSizeException;
import exercises.exercise3.SpiralMatrix;

public class SpiralMatrixShould {
	
	private SpiralMatrix spiralMatrix;

	@Before
	public void init() {
		spiralMatrix = new SpiralMatrix();
	}
	
	@Test
	public void RejectNegativeInput() {
		
		try {
			spiralMatrix.setSize(-1);
			fail();
		}
		catch (InvalidSizeException ex) {
			
		}
		assertEquals("0\n", spiralMatrix.toString());

	}
	
	@Test
	public void CalculateZeroMatrix() throws InvalidSizeException {


		spiralMatrix.setSize(0);
		
		assertEquals("0\n", spiralMatrix.toString());
		
	}
	
	@Test
	public void ExpandRightward() throws InvalidSizeException {
		
		spiralMatrix.setSize(1);
		
		assertEquals("0 1\n", spiralMatrix.toString());
		
	}
	
	@Test
	public void ExpandDownward() throws InvalidSizeException {
		
		String result = "0 1\n" + 
						"  2\n";
		
		spiralMatrix.setSize(2);
		
		assertEquals(result, spiralMatrix.toString());
	}
	
	@Test
	public void ExpandLeftward() throws InvalidSizeException {
		
		String result = "  0 1\n" + 
						"4 3 2\n";
		
		spiralMatrix.setSize(4);
		
		assertEquals(result, spiralMatrix.toString());		
	}
	
	@Test
	public void ExpandUpward() throws InvalidSizeException {
		String result = "6    \n" +
						"5 0 1\n" + 
						"4 3 2\n";

		spiralMatrix.setSize(6);
		
		assertEquals(result, spiralMatrix.toString());		
		
	}
	
	@Test
	public void DisplayCompleteMatrix() throws InvalidSizeException {
		String result = "6 7 8\n" +
						"5 0 1\n" + 
						"4 3 2\n";

		spiralMatrix.setSize(8);
		
		assertEquals(result, spiralMatrix.toString());		
		
	}
	
	
}
