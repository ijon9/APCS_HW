//Isaac Jon
//APCS1 pd 8
//HW 19 -- gcd 3 ways
//2017-10-19

public class Stats { 

	//Methods
	public static int mean(int a, int b) { //Mean of two integers
		return (a + b) / 2;
	}
//===================================================================================================
	public static double mean(double a, double b) { //Mean of two floats
		return (a + b) / 2;
	}
//===================================================================================================
	public static int max(int a, int b) { //Max of two integers
		if (a > b) {
			return a;
		}
		else {
			return b;
		}
	}
//===================================================================================================
	public static int min(int a, int b) { //Min of two integers
		if (a > b) {
			return b;
		}
		else {
			return a;
		}
	}
//===================================================================================================
	public static int max(int a, int b, int c) { //Max of three integers
		if (a > b && a > c) {
			return a;
		} 
		if (b >a && b > c) {
			return b;	
		}
		else {
			return c;
		}
	}
//===================================================================================================
	public static double max(double a, double b) { //Max of two floats
		if (a > b) {
			return a; 
		}
		else {
			return b;
		}
	}
//===================================================================================================
	public static double max(double a, double b, double c) { //Max of three floats
		if (a > b && a > c) {
			return a;
		} 
		if (b >a && b > c) {
			return b;	
		}
		else {
			return c;
		}
	}
//===================================================================================================
	public static int geoMean(int a, int b) { //Geometric mean of two integers
		return (int) Math.sqrt(a * b);
	}
//===================================================================================================
	public static int geoMean(int a, int b, int c) { //Geometric mean of three integers
		return (int) Math.pow((a * b * c), (1./3));
	}

//===================================================================================================
	public static double geoMean(double a, double b) { //geometric mean of two floats
		return Math.sqrt(a * b);
	}

//===================================================================================================
public static double geoMean(double a, double b, double c) { //Geometric mean of three 
		return Math.pow((a * b * c), (1./3));
	}

//===================================================================================================
public static int gcd(int a, int b) {
	int potGCD = min(a, b); //Sets potential GCD to smaller number
	if (a == 0 || b == 0) //If either int is 0, then the gcd is 0
		return 0;
	while (potGCD > 0) { //While loop checks if potGCD is GCD, and if not it decreases potGCD by 1
		if (min(a, b) % potGCD == 0 && max(a, b) % potGCD == 0) //If potGCD goes into both nums without remainder
			return potGCD; //It must be GCD
		potGCD -= 1; //Update
	}
	return potGCD;
}
//===================================================================================================
	public static int gcdER(int a, int b) {
		if (a == 0 || b == 0) //If either int is 0, then the gcd is 0
			return 0;
		if (max(a, b) % min(a, b) == 0) //If a goes into b then a is GCD
			return min(a, b);
		return gcdER(max(a, b) % min(a, b), min(a, b)); //Recalls method with remainder as a and samller of the two ints as b
	}
//===================================================================================================
	public static int gcdEW(int a, int b) {
		if (a == 0 || b == 0) //If either int is 0, then the gcd is 0
			return 0;
		while (max(a, b) % min(a, b) != 0) {//While smallerNum does not go into largerNum
			int errorDestroyer = min(a, b); //Sets the original a to a variable so it doesn't get lost
			a = max(a, b) % min(a, b); //Sets a to remainder of the two
			b = errorDestroyer; //Sets b to smaller of two nums (the a before statement above)
		}
		return min(a, b);//Returns smaller num
	}
//===================================================================================================

	public static void main(String[] args) { //Main method for testing

		// System.out.println(mean(6, 10)); //expecting 8
		// System.out.println(mean(3.6, 4.8)); //expecting 4.2
		// System.out.println(max(10, 6)); //expecting 10
		// System.out.println(max(19.5, 38.9)); //expecting 38.9
		// System.out.println(geoMean(2, 18)); // expecting 6
		// System.out.println(geoMean(5.5, 93.7)); //expecting 22.70132...
		// System.out.println(max(12, 39, 34)); //expecting 39
		// System.out.println(max(1.1, 2.3, 5.3)); // expecting 5.3
		// System.out.println(geoMean(2, 8, 4)); //expecting 8
		// System.out.println(geoMean(2.4, 5.6, 3.6)); //expecting 6.955...
		System.out.println("Testing gcd:==================");
		System.out.println(gcd(15, 20)); //5
		System.out.println(gcd(20, 15)); //5
		System.out.println(gcd(1, 5)); //1
		System.out.println(gcd(0, 3)); //0
		System.out.println(gcd(6, 15)); //3
		System.out.println(gcd(17, 21)); //1
		System.out.println("Testing gcdER:==================");
		System.out.println(gcdER(15, 20)); //5 
		System.out.println(gcdER(20, 15)); //5
		System.out.println(gcdER(1, 5)); //1
		System.out.println(gcdER(0, 3)); //0
		System.out.println(gcdER(6, 15)); //3
		System.out.println(gcdER(17, 21)); //1
		System.out.println("Testing gcdEW:==================");
		System.out.println(gcdEW(15, 20)); //5
		System.out.println(gcdEW(20, 15)); //5
		System.out.println(gcdEW(1, 5)); //1
		System.out.println(gcdEW(0, 3)); //0
		System.out.println(gcdEW(6, 15)); //3
		System.out.println(gcdEW(17, 21)); //1
	}
//===================================================================================================

//end Stats
}