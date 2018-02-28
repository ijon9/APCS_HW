/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

/*

Isaac Jon
APCS2 pd2
HW#10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
2018-02-28

*/

public class QueenBoard
{
  private int[][] _board;
    
  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }

  
  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
  	return solveH(0);
  }

  
  /**
   *Helper method for solve. 
   */
  private boolean solveH( int col ) 
  {
  	if(col >= _board.length) {
  		return true;
  	}
  	//Checks column for available space to place queen
  	for(int row = 0; row < _board.length; row++) {
  		if(addQueen(row, col)) {
  			if(solveH(col+1))
  				return true;
  		}
  	}

  	/* If no available space in column, remove queen from previous column, returns to the for loop called in the 
  	  previous column */

  	if(col > 0) {
  		for(int colVal = 0; colVal < _board.length; colVal++) {
  			removeQueen(colVal, col-1);
  		}
  	}

    return false; 
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
	    	if(_board[r][c] <= 0)
        		ans += "-"+"\t";
        	if(_board[r][c] == 1)
        		ans += "Q" + "\t";
	    }
	    ans += "\n";
    }
    System.out.print(ans);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * <General description>
   * precondition: The tile (row, col) must have a value of 0 
   * postcondition: The tile (row, col) is changed to a value of 1, and subtracts 1 to 
   	 each of the tiles the Queen attacks, going diagonally top to the right, diagonally down to the left
   	 and across the row
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: The tile (row, col) must have a value of 1
   * postcondition: The Queen at the tile is removed, and adds 1 to each of the tiles the Queen attacked,
   	 diagonally top to the right, down to the left, and straigth across the row
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition: 
   * postcondition: Prints out a representation of the board
   */
  public String  toString() 
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(8);
    b.solve();
    b.printSolution();
  }
    
}//end class
