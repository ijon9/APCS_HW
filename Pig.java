/*
  SUMMARY OF EXPANSIONS:
  The addition of final String PUNC was made to accomodate punctuation.
  The addition of the following methods were made:
      boolean isFirstCap(String w) -- a String is inputted into isFirstCap and the boolean value of the first character being capitalized is outputted.
      boolean hasPunct(String w) -- a String is inputted into hasPunct and the boolean value of the last character being a punctuation character of PUNC is outputted.
      boolean isYVowel(String w) -- a String is inputted into isYVowel and the boolean value of 
                                    if "y" should be a vowel based on the following conditions:
				    - does w begin with "y"?
				    - w contains no vowels but has "y"?
				    - is there a consonant before and after the first instance of "y"?
      String translate(String w) -- a String is inputted into translate and the pigified version of w is outputted, taking into account whitespace.
  The implementation of Scanner functionality where inputs are taken which are translated into Pig Latin and then outputted.
                                   
 */


import java.util.Scanner;

//Tres Mosqueteros (Isaac Jon, Kendrick Liang, Johnny Wong)
//APCS1 pd 8
//HW 24 -- Imetay Otay Ineshay
//2017-10-27

/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
    //Q: How does this initialization make your life easier?
    //A: VOWELS is constant and accessable by all of the methods in this class.
    private static final String VOWELS = "AaEeIiOoUu"; //VOWELS constant
    private static final String PUNC = "!?.,;:-"; 


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	if (w.length() == 0 || letter.length() != 1)
	    return false;
	return w.indexOf(letter) != -1; //Returns true if index of letter is not equal to -1 (meaning it is present)
    }


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	if (letter.length() != 1) //Returns false if input is not a single letter
	    return false;
	return hasA(VOWELS, letter); //If letter is part of VOWELS then true is returned
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	int pos = 0; //index of string
	int count = 0; //result, number of vowels
	if (w.length() == 0) //Returns 0 if w is null
	    return 0;
	while (pos < w.length()) { //While position is less than length of w
	    if (isAVowel(w.substring(pos, pos + 1))) //Check if the character is vowel 
		count += 1; //Add 1 to count if it is
	    pos += 1; //Add 1 to pos to continue to iterate through string  
	}
	return count; //Once pos reaches length of string, returns count
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	if (w.length() == 0) //If w is null, return false
	    return false;
	return countVowels(w) != 0; //If countVowels != 0, it means there is a vowel, so hasAVowel returns true
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	int pos = 0; //index of string
	String result = ""; //result, string containing all the vowels of w
	if (w.length() == 0) //If w is null, tell reader to input valid string
	    return "Please enter valid string";
	while (pos < w.length()) { //While position is less than length of w
	    if (isAVowel(w.substring(pos, pos + 1))) //Checks if character is vowel
		result += w.substring(pos, pos + 1); //Adds character to result if it is
	    pos += 1;  //Add 1 to pos to continue to iterate through string
	}
	return result; //Returns result once pos reaches length of string
    }
    /*=========================================
      pre: w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =========================================*/
    public static String firstVowel(String w) {
	if (hasAVowel(w)){
	    return allVowels(w).substring(0, 1); //If w has a vowel, assembles string of all vowels and returns first character
	}
	else{
	    return ""; //w can't be null, or not have a vowel
	}
    }
    /*=========================================
      pre: w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =========================================*/
    public static boolean beginsWithVowel(String w) {
	if (w.length() == 0) //w can't be null
	    return false;
	return isAVowel(w.substring(0, 1)); //returns boolean value of if first character is vowel
    }
    /*=========================================
      pre: w.length() > 0
      post: isFirstCap("Apple") --> true
      isFirstCap("apple") --> false
      =========================================*/
    public static boolean isFirstCap(String w){
	if (w.length() == 0){ //w can't be null
	    return false;
	}
	return w.substring(0,1).equals(w.substring(0,1).toUpperCase()); // returns boolean value of if first character is equal to the capitalized version of the first character
    }
    /*=========================================
      pre: w.length() > 0
      post: hasPunct("apple!") --> true
      hasPunct("apple") --> false
      =========================================*/
    public static boolean hasPunct(String w){
	if (w.length() == 0){ //w can't be null
	    return false;
	}
	return PUNC.indexOf(w.substring(w.length()-1)) != -1; // returns boolean value if punctuation is found at the end of the inputted String
    }
    /*=========================================
      pre: w.length() > 0
      post: isYVowel("yellow") --> false
      isYVowel("mystery") --> true
      isYVowel("rhythm") --> true
      =========================================*/
    public static boolean isYVowel(String w){
	if (w.length() == 0){ //w can't be null
	    return false;
	}
	w = w.toLowerCase(); // make w lowercase
	
	if (w.indexOf("y") == 0){ // test if first instance of 'y' is the first letter of w
	    return false;
	}
	else if (countVowels(w) == 0 && hasA(w, "y")){ // test if there are no vowels and w has "y"
	    return true;
	}
	else if (hasA(w, "y")){; // test if w has "y"
	    if (VOWELS.indexOf(w.substring(w.indexOf("y") - 1), w.indexOf("y")) == -1){ // test if letter preceding first instance of "y" is a consonant
		return (VOWELS.indexOf(w.substring(w.indexOf("y") + 1, w.indexOf("y") + 2)) == -1); // return boolean if letter after first instance of "y" is a consonant
	    }
	}
        return false;
	
    }
    


    
    /*=========================================
      pre: w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      =========================================*/
    
    public static String engToPig(String w){
	if (w.length() == 0){ //w can't be null
	    return "";
	}
        boolean wasCap = false;
        if (isFirstCap(w)){ // test if w began with a capital
	    wasCap = true; // assignment used later to recapitalize pigified w
	    w = w.toLowerCase(); // w assigned its lower case form
	}
	String wPig = ""; 
	if (isYVowel(w)){ // determine if "y" is a vowel for this instance of w
	    String newVowels = VOWELS + "yY"; // if so, newVowels assigned the final String VOWELS and "yY"
	    if (hasA(newVowels, w.substring(0,1))){ // the case that the first letter is a vowel
		wPig = w + "way";
	    }
	    else{ // case where first letter(s) are consonants
		if (hasA(w,"y")){ // if "y" can be found in w
		    if (w.indexOf("y") < w.indexOf(firstVowel(w)) || countVowels(w) == 0){ // test if "y" precedes the first vowel, if there is a vowel in the first place 
			String firstLetter = w.substring(w.indexOf("y"), w.indexOf("y") + 1);
		        wPig = firstLetter + w.substring(w.indexOf("y") + 1) + w.substring(0, w.indexOf("y")) + "ay";
		    }
		    else{ // if "y" does not precede the first vowel, pigify w as normal
			String firstLetter = w.substring(w.indexOf(firstVowel(w)), w.indexOf(firstVowel(w)) + 1);
			wPig = firstLetter + w.substring(w.indexOf(firstVowel(w)) + 1) + w.substring(0, w.indexOf(firstVowel(w))) + "ay";
		    }
		}
		else{ // if there is no "y", pigify w as normal
		    wPig = w.substring(w.indexOf(firstVowel(w)), w.indexOf(firstVowel(w)) + 1) + w.substring(w.indexOf(firstVowel(w)) + 1) + w.substring(0, w.indexOf(firstVowel(w))) + "ay";
		}
	    }
	}
	else if (beginsWithVowel(w)){ // if w begins with a vowel, pigify w by concatenating "way"
	    wPig = w + "way";
	}
	else if (hasAVowel(w)){ // if w does not begin with a vowel, but a vowel is present elsewhere, pigify as normal
	    String firstLetter = w.substring(w.indexOf(firstVowel(w)), w.indexOf(firstVowel(w)) + 1);
	    wPig = firstLetter + w.substring(w.indexOf(firstVowel(w)) + 1) + w.substring(0, w.indexOf(firstVowel(w))) + "ay";
	}
	else{ // if w lacks vowels, pigify as normal
	    wPig = w + "ay";
	}
	if (hasPunct(w)){ // test if there was punctuation at the end of w... if there is the form of punctuation is assigned to punc and concatenated to the end of wPig
	    String punct = w.substring(w.length()-1);
	    wPig = wPig.substring(0, wPig.indexOf(punct)) + wPig.substring(wPig.indexOf(punct) + 1) + punct;
	}
	if (wasCap){ // test if w wasCap... if it was then the first letter of wPig is capitalized 
	    String capFirst = wPig.substring(0,1).toUpperCase();
	    wPig = capFirst + wPig.substring(1);
	}
	return wPig; // return pigified version of w
    }
       

    /*=========================================
      pre: w.length() > 0
      post: translate("Hi there bud how are you?") -> "Ihay erethay udbay owhay areway ouyay?"
      translate("Don't be a bad piggy!") -> "On'tday ebay away adbay iggypay!"
      =========================================*/
    public static String translate(String w){
	if (w.length() == 0){ //w can't be null
	    return "";
	}
	if (hasA(w, " ")){ // if w has whitespace, call engToPig on the first word before whitespace and recursively convert the rest of the phrase to Pig Latin by calling translate again
	    return engToPig(w.substring(0, w.indexOf(" "))) + " " + translate(w.substring(w.indexOf(" ") + 1));
	}
	else{ // if there was no whitespace present, pigify w through method engToPig
	    return engToPig(w);
	}
    }


    public static void main( String[] args ) 
    {  /*
       System.out.println("========================Testing hasA=============================");
       System.out.println(hasA("cat", "a")); //true
       System.out.println(hasA("cat", "b")); //false
       System.out.println(hasA("", "a")); //false
       System.out.println(hasA("cat", "sd")); //false
       System.out.println("==========================Testing isAVowel==========================");
       System.out.println(isAVowel("a")); //true
       System.out.println(isAVowel("e")); //true
       System.out.println(isAVowel("b")); //false
       System.out.println(isAVowel("as")); //false
       System.out.println("=========================Testing countVowels========================");
       System.out.println(countVowels("meatballa")); //4
       System.out.println(countVowels("adlsfkjhwealjhfvablkjeahn")); //6
       System.out.println(countVowels("")); //0
       System.out.println("=========================Testing hasAVowel=========================");
       System.out.println(hasAVowel("cat")); //true
       System.out.println(hasAVowel("zzz")); //false
       System.out.println(hasAVowel("")); //false
       System.out.println("=====================Testing allVowels===============================");
       System.out.println(allVowels("meatballa")); //eaaa
       System.out.println(allVowels("wrtypg")); //""
       System.out.println(allVowels("cat")); //a
       System.out.println(allVowels("")); //Please enter valid string 
       System.out.println("====================Testing firstVowel======================");
       System.out.println(firstVowel("acet")); // a
       System.out.println(firstVowel("caet")); // a
       System.out.println(firstVowel("ctea")); // e
       System.out.println(firstVowel("")); // ""
       System.out.println("=======================Testing beginsWithVowel==========================");
       System.out.println(beginsWithVowel("")); // false
       System.out.println(beginsWithVowel("acat")); // true
       System.out.println(beginsWithVowel("cast")); // false
       System.out.println("=======================Testing isFirstCap==========================");
       System.out.println(isFirstCap("Apple")); // true
       System.out.println(isFirstCap("apple")); // false
       System.out.println(isFirstCap("")); // false
       System.out.println("=======================Testing hasPunct==========================");
       System.out.println(hasPunct("Apple!")); // true
       System.out.println(hasPunct("apple")); // false
       System.out.println(hasPunct("")); // false
       System.out.println("=======================Testing isYVowel==========================");
       System.out.println(isYVowel("Yellow")); // false
       System.out.println(isYVowel("mystery")); // true
       System.out.println(isYVowel("rhythm")); // true
       System.out.println(isYVowel("why")); // true

       System.out.println("===========================Testing engToPig==========================");
       System.out.println(engToPig("")); //""
       System.out.println(engToPig("apple")); //appleway
       System.out.println(engToPig("meatball")); //eatballmay
       System.out.println(engToPig("java")); //avajay
       System.out.println(engToPig("strong")); //ongstray
       System.out.println(engToPig("xD")); // xDay
       System.out.println(engToPig("Yellow")); // Ellowyay
       System.out.println(engToPig("mystery.")); // ysterymay.
       System.out.println(engToPig("rhythm")); // ythmrhay
       System.out.println("===========================Testing translate==========================");
       System.out.println(translate("Hi there bud how are you?")); //Ihay erethay udbay owhay areway ouyay?
       System.out.println(translate("Don't be a bad piggy!")); //On'tday ebay away adbay iggypay!
       System.out.println(translate("Mr. Brown")); //Mray. Ownbray
       */
	Scanner sc = new Scanner(System.in);
	while (sc.hasNext()){
	    System.out.println(translate(sc.next()));
	}
       
	
    }//end main()

}//end class Pig
