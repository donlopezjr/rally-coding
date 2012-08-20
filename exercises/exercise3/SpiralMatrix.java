package exercises.exercise3;

/**
 * Creates a matrix in a spiral format up to a given maximum integer and 
 * outputs it as a string.
 * 
 * @author donlopezjr
 *
 */
public class SpiralMatrix {
	// The array that holds the spiral matrix
	private int[][] matrix;
	// The height/width of the above array
	int matrixSize;
	// The number of characters required to represent the largest number in the matrix
	private int fieldSize;
	// The last number in the spiral pattern
	private int maximum;
	
	public SpiralMatrix() {
		try {
			setMaximum(0);
		}
		catch (InvalidSizeException ex) {
			// A value of 0 should never trigger an exception
		}
	}
	
	/**
	 * Set the last number in the spiral pattern
	 * 
	 * @param maximum The last number in the spiral pattern
	 * @throws InvalidSizeException Only sizes >= 0 are allowed
	 */
	public void setMaximum(int maximum) throws InvalidSizeException {
		if (maximum < 0)
			throw new InvalidSizeException();
		
		this.maximum = maximum;
		
		// Calculate how large the field needs to be to accomodate the largest number
		if (maximum > 0)
			fieldSize = (int) Math.floor(Math.log10(maximum)) + 1;
		else
			fieldSize = 1;
		
		matrix = null;
	}

	/**
	 * Construct the underlying matrix of integers used to print out the pattern.
	 */
	private void createMatrix() {
		// Current coordinates
		int x, y;
		// Current value
		int k = 0;
		// Dimensions of the sub-matrix we are working on during our spiral tracing
		int subMatrixLeft;
		int subMatrixTop;
		int subMatrixRight;
		int subMatrixBottom;
		int subMatrixSize = 1;
		
		// What number will trigger the next sub-matrix
		int nextExpansionAt = 1;

		// Get total memory requirement and allocate an array
		matrixSize = getMatrixWidth();
		matrix = new int[matrixSize][matrixSize];
		
		// Default all cells to -1 to indicate that they are blank
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				matrix[i][j] = -1;
			}
		}
		
		// Get the dimensions for the initial sub-matrix (just the center cell)
		x = matrixSize/2;
		y = matrixSize/2;
		subMatrixLeft = x;
		subMatrixTop = y;
		subMatrixRight = x;
		subMatrixBottom = y;
		
		while (k <= maximum) {
			// Plot this number
			matrix[x][y] = k;
			
			k++;
			
			// If we have filled our submatrix, create the next part of the spiral 
			if (k == nextExpansionAt) {
				// Expand out one in each direction
				subMatrixSize += 2;
				subMatrixLeft--;
				subMatrixRight++;
				subMatrixTop--;
				subMatrixBottom++;
				
				// The next expansion occurs when we have filled all the cells in our sub-matrix
				nextExpansionAt = subMatrixSize * subMatrixSize;
			}

			if (x == subMatrixRight) {
				if (y < subMatrixBottom)
					// Move down the right side
					y++;
				else
					// Move left from the bottom-right corner
					x--;
			}
			else if (x == subMatrixLeft) {
				if (y > subMatrixTop)
					// Move up the left side
					y--;
				else
					// Move right from the top-left corner
					x++;
			}
			else if (y == subMatrixBottom) {
				// Move left along the bottom
				x--;
			}
			else {
				// Move right along the top
				x++;
			}
			
		}
		
	}

	/**
	 * Calculates the size of the underlying matrix required based on the max value
	 * 
	 * @return The height/width of the required matrix.
	 */
	private int getMatrixWidth() {
		double matrixWidth;
		
		// A 0 matrix is 1x1.
		// Anytime a perfect square of an odd number is reached, we have exceeded the available slots,
		// expand by 2 in each direction
		matrixWidth = Math.sqrt(maximum + 1);
		matrixWidth = Math.ceil(matrixWidth);
		if (matrixWidth % 2 == 0)
			matrixWidth++;
		
		return (int) matrixWidth;
	}
	
	public String toString() {
		StringBuilder result;
		int bottom;
		int top;
		int left;
		
		if (matrix == null)
			createMatrix();
		
		result = new StringBuilder();
		
		// Ignore the top row if it is entirely blank
		if (matrix[0][0] != -1)
			top = 0;
		else
			top = 1;
		
		// Ignore the left column if it is entirely blank
		if (matrix[0][matrixSize-1] != -1)
			left = 0;
		else
			left = 1;
		
		// Ignore the bottom row if it is entirely blank
		if (matrix[matrixSize-1][matrixSize-1] != -1)
			bottom = matrixSize;
		else
			bottom = matrixSize - 1;
		
		// Print out each row of values, ignoring blank border row/columns.
		for (int j = top; j < bottom; j++) {
			
			result.append(getValueAsString(left, j));
			
			for (int i = left+1; i < matrixSize; i++) {
				result.append(" "+getValueAsString(i,j));
			}
			result.append("\n");
		}
				
		return result.toString();
	}

	/**
	 * Gets a string representation of the requested cell
	 * 
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @return A uniformly padded string representation of the requested cell
	 */
	private String getValueAsString(int x, int y) { 
		// Pad to the field size that we calculated earlier, -1 indicates a blank cell
		if (matrix[x][y] == -1)
			return String.format("%" + fieldSize + "s", "");
		else
			return String.format("%" + fieldSize + "d", matrix[x][y]);
		
	}
}
