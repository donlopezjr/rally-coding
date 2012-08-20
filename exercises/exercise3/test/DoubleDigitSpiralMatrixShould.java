package exercises.exercise3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise3.InvalidSizeException;
import exercises.exercise3.SpiralMatrix;

public class DoubleDigitSpiralMatrixShould {
	private SpiralMatrix spiralMatrix;
	
	@Before
	public void init() {

		spiralMatrix = new SpiralMatrix();
			
	}
	
	@Test
	public void ExpandDownward() throws InvalidSizeException {
		
		String result = " 6  7  8  9\n" +
						" 5  0  1 10\n" + 
						" 4  3  2 11\n" + 
						"         12\n";

		spiralMatrix.setMaximum(12);
		
		assertEquals(result, spiralMatrix.toString());
	}
	
	@Test
	public void ExpandLeftward() throws InvalidSizeException {
		
		String result = "    6  7  8  9\n" +
						"    5  0  1 10\n" + 
						"    4  3  2 11\n" + 
						"16 15 14 13 12\n";
		
		spiralMatrix.setMaximum(16);
		
		assertEquals(result, spiralMatrix.toString());		
	}
	
	@Test
	public void ExpandUpward() throws InvalidSizeException {
		String result = "20            \n" +
						"19  6  7  8  9\n" +
						"18  5  0  1 10\n" + 
						"17  4  3  2 11\n" + 
						"16 15 14 13 12\n";

		spiralMatrix.setMaximum(20);

		assertEquals(result, spiralMatrix.toString());		
		
	}
	
	@Test
	public void DisplayCompleteMatrix() throws InvalidSizeException {
		String result = "20 21 22 23 24\n" +
						"19  6  7  8  9\n" +
						"18  5  0  1 10\n" + 
						"17  4  3  2 11\n" + 
						"16 15 14 13 12\n";

		spiralMatrix.setMaximum(24);

		assertEquals(result, spiralMatrix.toString());		
		
	}

	@Test
	public void ExpandRightward() throws InvalidSizeException {

		String result = "20 21 22 23 24 25\n" +
						"19  6  7  8  9   \n" +
						"18  5  0  1 10   \n" + 
						"17  4  3  2 11   \n" + 
						"16 15 14 13 12   \n";

		spiralMatrix.setMaximum(25);
		
		assertEquals(result, spiralMatrix.toString());
		
	}
	

}
