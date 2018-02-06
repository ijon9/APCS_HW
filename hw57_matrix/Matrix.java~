/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/

//Isaac Jon
//APCS1 pd8
//HW57 -- How Deep Does the Rabbit Hole Go?
//2017-12-20


public class Matrix 
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix() 
  {
      matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a ) 
  {
      matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  private int size() 
  {
      int size = 0;
      for(Object[] row: matrix) {
	  for(Object o: row)
	      size += 1;
      }
      return size;
  }


  //return the item at the specified row & column   
  private Object get( int r, int c ) 
  {
      return matrix[r-1][c-1]; //Since first data is (1,1) not (0,0)
  }


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty( int r, int c ) 
  {
      return get(r, c) == null;
  }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal ) 
  {
      Object og = get(r, c);
      matrix[r-1][c-1] = newVal; //Since first data is not (0, 0)
      return og;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString() 
  {
      String result = "";
      for(Object[] row: matrix) {
	  result += "|";
	  for(Object o: row) {
	      result += " " + o;
	  }
	  result += " |" + "\n";
      }
      return result;
  }


  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Matrix rightSide ) 
  {
      if(size() == rightSide.size()) {
	  for(int row = 0; row < matrix.length; row++) {
	      for(int col = 0; col < matrix[row].length; col++) {
		  if(get(row+1 /*To account for the fact that col is 0 */, col+1) != rightSide.get(row+1, col+1))
		      return false;
	      }
	  }
      }
      else
	  return false;
      return true;
  }


  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) 
  {
      for(int row = 1; row < matrix.length + 1; row++) {
	  Object holdO = get(row, c1);
	  set(row, c1, get(row, c2));
	  set(row, c2, holdO);
      }
  }


  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  ) 
  {
      Object[] holdRow = matrix[r1-1];
      matrix[r1-1] = matrix[r2-1];
      matrix[r2-1] = holdRow;
  }


  //main method for testing
  public static void main( String[] args ) 
  {
      //New Matrix Bob
      Matrix bob = new Matrix();
      bob.set(1, 1, 1);
      bob.set(1, 2, 2);
      bob.set(2, 1, 3);
      System.out.println("==========");
      System.out.println("MATRIX BOB:");
      System.out.println(bob);
      System.out.println("Bob's size: " + bob.size());
      System.out.println("=========");
      //Testing get
      System.out.println("======Testing get=====");
      System.out.println(bob.get(1, 2));
      System.out.println(bob.get(2, 1));
      System.out.println("================");
      //Testing isEmpty
      System.out.println("========Testing isEmpty=========");
      System.out.println(bob.isEmpty(1, 2));
      System.out.println(bob.isEmpty(2, 2));
      System.out.println("===========================");
      //Testing swapColumns
      System.out.println("=========Testing swapColumns================");
      bob.swapColumns(1, 2);
      System.out.println("Bob after swapping columns...");
      System.out.println(bob);
      System.out.println("=======================");
      //Testing swapRows
      System.out.println("===============Testing swapRows=============");
      bob.swapRows(1, 2);
      System.out.println("Bob after swapping rows...");
      System.out.println(bob);
      System.out.println("==========================");

      //Testing equal

      //New Matrix tv
      Matrix tv = new Matrix();
      tv.set(1, 2, 3);
      tv.set(2, 1, 2);
      tv.set(2, 2, 1);
      System.out.println("========");
      System.out.println("MATRIX TV:");
      System.out.println(tv);
      System.out.println("tv's size: " + tv.size());
      System.out.println("==========");

      System.out.println("======Testing equals======");
      System.out.println(bob.equals(tv));
      System.out.println();
      tv.set(1, 1, 2);
      System.out.println("After changing tv...");
      System.out.println(tv);

      System.out.println("Testing equals again...");
      System.out.println(bob.equals(tv));
      
      System.out.println("================");
	  
  }

}//end class Matrix
