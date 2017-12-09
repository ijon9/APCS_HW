//Isaac Jon
//APCS1 pd 8
//HW 20 -- For the Love of Strings
//2017-10-20

public class Foresrever {
	
	public static String fenceF(int posts) { 
		String fence = "|"; //Initializes fence to |
		if (posts < 1) //Returns empty string if number of posts is 0 or below
			return "";
		//For loop binds x to posts and if greater than 1, add --| to fence, then updates. 
		for (int x = posts; x > 1; x -= 1) { 
			fence += "--|"; 
		} 
		return fence;
	}

	public static String reverseF(String s) {
		String result = ""; //Initializes result
		//For loop binds x to length of s - 1. If x >= 0, adds last character in s to result, removes that character from s, then updates.
		for (int x = s.length() - 1; x >= 0; x -= 1) {
			result += s.substring(x);
			s = s.substring(0, s.length() - 1);
		}
		return result;
	}

	public static String reverseR(String s) {
		String result = ""; //Initializes result
		if (s.length() < 2) //Base Case, returns string if it contains 1 or 0 characters
			return s;
		//Recursive case adds last character to result, then adds the call of reverseR with the last character removed from s.
		return s.substring(s.length() - 1) + reverseR(s.substring(0, s.length() - 1));  
	}

	public static void main(String[] args) {
		System.out.println("===================Testing fenceF:========================");
		System.out.println(fenceF(0)); //Empty String
		System.out.println(fenceF(1)); // |
		System.out.println(fenceF(2)); // |--|
		System.out.println(fenceF(3)); // |--|--|
		System.out.println("===================Testing reverseF:====================");
		System.out.println(reverseF("hello")); // olleh
		System.out.println(reverseF("stressed")); // desserts
		System.out.println(reverseR("hi")); //ih
		System.out.println(reverseF("h")); //h
		System.out.println(reverseF("")); //Empty String
		System.out.println("=====================Testing reverseR:=====================");
		System.out.println(reverseR("hello")); // olleh 
		System.out.println(reverseR("stressed")); // desserts
		System.out.println(reverseR("hi")); //ih
		System.out.println(reverseR("h")); //h
		System.out.println(reverseR("")); //Empty String
	}


}