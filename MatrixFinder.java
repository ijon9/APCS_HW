/*
  Team Bop-It
  Brian Lin, Isaac Jon, Aleksandra Koroza
  APCS2 pd2
  HW #03: I Am Still Searching
  2018-02-01  
*/

/*
  Summary:
  Search starts at the bottom left corner.
  If this value is equal to target, return the location. 
  If this value is greater than the target, the search moves up (previous row). 
  If the value is less than the target, search moves right (next column).
  If target is not present in the matrix, returns (-1,1). 
  Best Case: target is to the right of the bottom left corner
  Worst Case: target is on the last row, last column (top right)
*/


public class MatrixFinder{

    public static String matrixSearch(int[][] matrix, int target){
	//tracking location
	int r = matrix.length - 1;
	int c = 0;

	//resulting String
	String result= "(";
	
    while (r != matrix.length && c!= matrix.length){
	//check if target is at bottom left corner
	if (matrix[r][c]== target) {
		result = result + (r + 1) + "," + (c + 1) + ")" ;
		return result;
	}
	    // check if value is bigger than target
    else if (matrix[r][c] > target) {
		r-=1;
    }

	    //check is value is smaller than target
    else if (matrix[r][c] < target) {
		c += 1;
    }


	}
	//not found
	result= result + "-1,-1)";
	return result;
    }

     public static void main(String[] args) {
	// ========== Worst Case Scenario Test Case ==========
	// Requires 4 runs 
	int[][] worst = new int[3][3];
	worst[0][0] = 1;
	worst[0][1] = 2;
	worst[0][2] = 16;
	worst[1][0] = 3;
	worst[1][1] = 4;
	worst[1][2] = 17;
	worst[2][0] = 4;
	worst[2][1] = 5;
	worst[2][2] = 26;
	/* Visual Diagram
	 | 1 2 16 |
	 | 3 4 17 |
	 | 4 5 26 |
	*/
	System.out.println(matrixSearch(worst, 16));  // Should return (1, 3) 
	// ========== Best Case Scenario Test Case ==========
	// Requires 1 run
	int[][] best = new int[4][4];
	best[0][0] = 3;
	best[0][1] = 7;
	best[0][2] = 8;
	best[0][3] = 9;
	best[1][0] = 10;
	best[1][1] = 11;
	best[1][2] = 14;
	best[1][3] = 17; 
	best[2][0] = 16;
	best[2][1] = 18;
	best[2][2] = 20;
	best[2][3] = 22;
	best[3][0] = 25;
	best[3][1] = 28;
	best[3][2] = 30;
	best[3][3] = 35;
	/* Visual Diagram
	 |  3  7  8  9  |
	 | 10 11 14 17  |
	 | 16 18 20 22  |
	 | 25 28 30 35  |
	*/
	System.out.println(matrixSearch(best, 25)); 
		// ========== Middle Case Scenario Test Case ==========
		// Requires 2 runs
	int[][] mid = new int[3][3];
	mid[0][0] = 1;
	mid[0][1] = 2;
	mid[0][2] = 3;
	mid[1][0] = 4;
	mid[1][1] = 6;
	mid[1][2] = 7;
	mid[2][0] = 5;
	mid[2][1] = 7;
	mid[2][2] = 8;
	/* Visual Diagram
	 | 1 2 3 |
	 | 4 6 7 |
	 | 5 7 8 |
	*/
	System.out.println(matrixSearch(mid, 6)); 


    }

}
