package exercises.exercise3.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exercises.exercise3.InvalidSizeException;
import exercises.exercise3.SpiralMatrix;

public class TripleDigitSpiralMatrixShould {
	
	
	private SpiralMatrix spiralMatrix;

	@Before
	public void init() {
		
		spiralMatrix = new SpiralMatrix();
	}
	
	@Test
	public void ExpandLeftward() throws InvalidSizeException {

		String result = "     72  73  74  75  76  77  78  79  80  81\n" +
						"     71  42  43  44  45  46  47  48  49  82\n" +
						"     70  41  20  21  22  23  24  25  50  83\n" +
						"     69  40  19   6   7   8   9  26  51  84\n" +
						"     68  39  18   5   0   1  10  27  52  85\n" + 
						"     67  38  17   4   3   2  11  28  53  86\n" + 
						"     66  37  16  15  14  13  12  29  54  87\n" +
						"     65  36  35  34  33  32  31  30  55  88\n" +
						"     64  63  62  61  60  59  58  57  56  89\n" +
						"100  99  98  97  96  95  94  93  92  91  90\n";
		
		spiralMatrix.setMaximum(100);
		
		assertEquals(result, spiralMatrix.toString());
		
	}

	@Test
	public void ExpandUpward() throws InvalidSizeException {

		String result = "110                                        \n" +
						"109  72  73  74  75  76  77  78  79  80  81\n" +
						"108  71  42  43  44  45  46  47  48  49  82\n" +
						"107  70  41  20  21  22  23  24  25  50  83\n" +
						"106  69  40  19   6   7   8   9  26  51  84\n" +
						"105  68  39  18   5   0   1  10  27  52  85\n" + 
						"104  67  38  17   4   3   2  11  28  53  86\n" + 
						"103  66  37  16  15  14  13  12  29  54  87\n" +
						"102  65  36  35  34  33  32  31  30  55  88\n" +
						"101  64  63  62  61  60  59  58  57  56  89\n" +
						"100  99  98  97  96  95  94  93  92  91  90\n";
		
		spiralMatrix.setMaximum(110);
		
		assertEquals(result, spiralMatrix.toString());
		
	}

	@Test
	public void DisplayCompleteMatrix() throws InvalidSizeException {

		String result = "110 111 112 113 114 115 116 117 118 119 120\n" +
						"109  72  73  74  75  76  77  78  79  80  81\n" +
						"108  71  42  43  44  45  46  47  48  49  82\n" +
						"107  70  41  20  21  22  23  24  25  50  83\n" +
						"106  69  40  19   6   7   8   9  26  51  84\n" +
						"105  68  39  18   5   0   1  10  27  52  85\n" + 
						"104  67  38  17   4   3   2  11  28  53  86\n" + 
						"103  66  37  16  15  14  13  12  29  54  87\n" +
						"102  65  36  35  34  33  32  31  30  55  88\n" +
						"101  64  63  62  61  60  59  58  57  56  89\n" +
						"100  99  98  97  96  95  94  93  92  91  90\n";
		
		spiralMatrix.setMaximum(120);
		
		assertEquals(result, spiralMatrix.toString());
		
	}

	@Test
	public void ExpandRightward() throws InvalidSizeException {

		String result = "110 111 112 113 114 115 116 117 118 119 120 121\n" +
						"109  72  73  74  75  76  77  78  79  80  81    \n" +
						"108  71  42  43  44  45  46  47  48  49  82    \n" +
						"107  70  41  20  21  22  23  24  25  50  83    \n" +
						"106  69  40  19   6   7   8   9  26  51  84    \n" +
						"105  68  39  18   5   0   1  10  27  52  85    \n" + 
						"104  67  38  17   4   3   2  11  28  53  86    \n" + 
						"103  66  37  16  15  14  13  12  29  54  87    \n" +
						"102  65  36  35  34  33  32  31  30  55  88    \n" +
						"101  64  63  62  61  60  59  58  57  56  89    \n" +
						"100  99  98  97  96  95  94  93  92  91  90    \n";
		
		spiralMatrix.setMaximum(121);
		
		assertEquals(result, spiralMatrix.toString());
		
	}

	
}
