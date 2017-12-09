//Isaac Jon
//APCS1 pd 8
//HW 21 - Karmacomma
//2017-10-24

public class Commafier {

	public static int rmvLastThree(int n) { //Helper function for commafyR, removes last 3 digits of an int
		String s = Integer.toString(n);
		s = s.substring(0, s.length() - 3); //Removes last three digits of int by converting to string, removing last three characters, 
		return Integer.parseInt(s); //and converting back to int
	}

	public static String commafyF(int n) {
		int commaTestCtr = 0; //Ctr to count how many digits have been added
		String s = Integer.toString(n); //Turns n into a string
		String result = ""; //Initializes result
		if (n < 1000) //If n has less than four digits, 
			return s; //n is simply returned
		for (int x = s.length() - 1; x >= 0; x--) { //For loop, is called while length of s is greater than 0
			result = s.substring(x) + result; //If it is, the last character is added to result, allowing construction right to left
			s = s.substring(0, s.length() - 1); //sets s to original s with last character removed
			commaTestCtr += 1; //Once the character is added, test counter increases by one
			if (commaTestCtr == 3 && x > 0) { //If test coutner is 3, it adds a comma (only if there are still characters left in x
				result = "," + result;
				commaTestCtr = 0; //Resets counter once comma is added
			}
		}
		return result; //Once length of s is less than four digits, returns result
	}

	public static String commafyR(int n) {
		String s = Integer.toString(n); //Turns n into String so it can be easily manipulatied
		if (s.length() < 4) //If n has less than 4 digits, it returns a string representation of n (base case)
			return s;
		return commafyR(rmvLastThree(n)) + "," + s.substring(s.length() - 3); 
		//Revursive case (above) adds n with last three digits removed to a comma, and the last three digits of current n
	}

	public static void main(String[] args) {
		// System.out.println("====================Testing commafyF=======================");
		// System.out.println(commafyF(1)); //1
		// System.out.println(commafyF(101));  //101
		// System.out.println(commafyF(10)); //10
		// System.out.println(commafyF(1000)); //1,000
		// System.out.println(commafyF(12345)); //12,345
		// System.out.println(commafyF(100000000)); //100,000,000
		// System.out.println("==================Testing commafyR====================='=");
		// System.out.println(commafyR(1)); //1
		// System.out.println(commafyR(101)); //101
		// System.out.println(commafyR(10)); //10
		// System.out.println(commafyR(1000)); //1,000
		// System.out.println(commafyR(12345)); //12,345
		// System.out.println(commafyR(100000000)); //100,000,000
		for (String num: args) {
			System.out.println(commafyF(Integer.parseInt(num)));
		}
		
	}







}