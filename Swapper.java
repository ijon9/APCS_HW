//Isaac Jon
//APCS1 p8
//HW40 -- Make it Better
//2017-11-27

/*
=====Summary=====
First, the main method creates an empty (filled with nulls) 2D array, b.
Then, it is populated with random digits, which have to be unique per row. 
It then prints out the board, and then asks for two inputs from the user:
One for the first swap position and another for the second.
Then, swap() switches positions of the two specified indexes before 
printing the updated board
 */
/*
====Additions====
I added rows and columns, so users will know how to nummber their pairs when asked to swap. Also, 
I created a while loop to continue running the program, instead of only swapping once.
*/

import cs1.Keyboard;

public class Swapper {

    //Checks if any values associated with indexes in b, before ind, are equal to car
    public static boolean hasABefore(String[] b, String car, int ind) {
	int pos = 0;
	while (pos < ind) {
	    if (b[pos] == car) {
		return true;
	    }
	    pos += 1;
	}
	return false;
    }

    //Prints the 2D array
    public static void print( String[][] a ) {
	int rowNum = 0;
	System.out.println("    0:1:2:3");
	System.out.println("    _ _ _ _ ");
	for(String[] row: a ){
	    System.out.print(rowNum + ": |");
	    for(String b: row){
		System.out.print(b + " ");
	    }
	    System.out.println("|");
	    rowNum += 1;
	}
    }

    //Populates the array with random unique values for each row
    public static void popArray(String[][] b) {
	for(String[] row: b) {
	    for(int ind = 0; ind < row.length; ind ++) {
		String newNum = "" + (int)(Math.random() * 10);
		while (hasABefore(row, newNum, ind)) {
		    newNum = "" + (int)(Math.random() * 10);
		}
		row[ind] = newNum;
	    }
	}
    }

    //Swaps the values in a 2D array specefied in pos1, and pos2 in the form "int,int"
    public static void swap(String[][] b, String pos1, String pos2) {
	int firstRow = Integer.parseInt(pos1.substring(0, 1));
	int firstColumn = Integer.parseInt(pos1.substring(2));
	int secondRow = Integer.parseInt(pos2.substring(0, 1));
	int secondColumn = Integer.parseInt(pos2.substring(2));
	
	String og1 = b[firstRow][firstColumn];
	String og2 = b[secondRow][secondColumn];

	b[firstRow][firstColumn] = og2;
	b[secondRow][secondColumn] = og1;
    }
   
    public static void main(String[] args) {
	/*
	=====Testing hasABefore=====
	String[] a = {"a", "b", "c", "d", "e"};
	System.out.println(hasABefore(a, "c", 2)); //False
	System.out.println(hasABefore(a, "c", 3)); //True
	System.out.println(hasABefore(a, "d", 2)); //False
	*/
	
	String[][] board = new String[4][4];
	popArray(board);
	System.out.println("=====Starting board=====");
        print(board);
	System.out.println("========================");
	System.out.println();
	
	while (true) {
	    System.out.println( "Please enter the row and column of two positions to swap. For example, \"2,3\".");
	    System.out.print("First position: ");
	    String first = Keyboard.readString();
	    System.out.print("Second position: ");
	    String second = Keyboard.readString();

	    swap(board, first, second);
	    System.out.println();
	    System.out.println("=====Final Board=====");
	    print(board);
	    System.out.println("=====================");
	}
	
    }
    




}
