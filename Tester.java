public class Tester 
{ 
 
    /** A two­dimensional array of single­character strings, 
	instantiated in the constructor */ 
    private String[][] letterBlock; 
    /** The number of rows of letterBlock, set by the constructor */ 
    private int numRows; 
    /** The number of columns of letterBlock, set by the constructor */ 
    private int numCols;

    public Tester() {
	letterBlock
    }
 
    /** Places a string into letterBlock in row­major order. 
     * @param str the string to be processed 
     * Postcondition: 
     * if str.length()<numRows*numCols, 
     *    "A" is placed in each unfilled cell
     * if str.length()>numRows*numCols, trailing characters are ignored 
     */
    private void fillBlock(String str) 
    {
	for(int k = 0; k < str.length(); k++) {
	    int row = 0;
	    int col = 0;
	    party[row][col] = str.substring(k, k+1);
	    if(col < numCols-1) {
		col += 1;
	    }
	    else if(row < numRows-1) {
		row += 1;
	    }
	    else
		break;
	}
    }
    /** Extracts encrypted string from letterBlock in column­major order. 
     * Precondition: letterBlock has been filled 
     * @return the encrypted string from letterBlock 
     */ 
    private String encryptBlock() 
    {
	int col = 0;
	int row = 0;
	String result = "";
	while(col < numCols-1) {
	    while(row < numRows) {
		result += letterBlock[row][col];
		row += 1;
	    }
	    row = 0;
	    col += 1;
	}
	return result;		
    }
     
    /** Encrypts a message. 
     * @param message the string to be encrypted 
     * @return the encrypted message; 
     * if message is the empty string, returns the empty string 
     */ 
public String encryptMessage(String message) 
{ /* to be implemented in part (b) */ } 
// There may be instance variables, constructors, 
// and methods that are not shown.
}
