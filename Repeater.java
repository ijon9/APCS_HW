// Isaac Jon
// APCS1 pd 8
// HW 17 -- Do I repeat myself?
// 2017-10-17

public class Repeater {
	
	public static String fenceW(int numPosts) {
		int posts = 1; //Initializes counter
		String fence = "|"; //Initializes result
		while (posts < numPosts) { //If counter is less than numPosts 
			fence += "--|"; //Add --|
			posts += 1; //Updates counter
		}
		return fence; //Returns result
	}

	public static String fenceR(int numPosts) {
		String fence = "|"; //Initializes result
		if (numPosts == 1) { //Base case
			return fence;		
		}
		fence += "--" + fenceR(numPosts - 1); //Recursive case
		return fence;
	}


	public static void main(String[] args) {
		//Tests for fenceW
		System.out.println(fenceW(1)); // -> "|"
		System.out.println(fenceW(2)); // -> "|--|"
		System.out.println(fenceW(3)); // -> "|--|--|"

		//Tests for fenceR
		System.out.println(fenceR(1)); // -> "|"
		System.out.println(fenceR(2)); // -> "|--|"
		System.out.println(fenceR(3)); // -> "|--|--|"
	}

}