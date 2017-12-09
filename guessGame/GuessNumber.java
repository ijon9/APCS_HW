/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/
//Isaac Jon
//APCS1 pd8
//HW48 -- Keep Guessing
//2017-12-07

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = a;
	_hi = b;
	_guessCtr = 1;
	_target = (int)(Math.random() * _hi) + _lo;
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	String s = "Guess a # fr " + _lo + "-" + _hi + ":"; //Question phrase
	System.out.print(s);
	int userInput = Keyboard.readInt();

	if(userInput - _target > 0) { //If user imput is greater than target, run PlayRec again but with _hi set to user input and increment guess counter
	    System.out.println("Too high");
	    _hi = userInput;
	    _guessCtr += 1;
	    playRec();
	}
	
	else if(userInput - _target < 0) {//Same as above but for an input too low
	    System.out.println("Too low");
	    _lo = userInput;
	    _guessCtr += 1;
	    playRec();
	}
	
	else { //Victory message
	    System.out.println("Correct! It took " + _guessCtr + " guesses");
	}
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	String s = "Guess a # fr " + _lo + "-" + _hi + ":"; //Question phrase
	System.out.print(s);
	int userInput = Keyboard.readInt();

	while(userInput != _target) {
	    if(userInput - _target > 0) { //If user Input is too high, set _hi to user input, increment guess Counter, and repeat question phrase
		System.out.println("Too high");
		_hi = userInput;
		_guessCtr += 1;
		System.out.print("Guess a # fr " + _lo + "-" + _hi + ":");
		userInput = Keyboard.readInt();
	    }
	    else if(userInput - _target < 0) {//Same as above but for an input too low
		System.out.println("Too low");
		_lo = userInput;
		_guessCtr += 1;
		System.out.print("Guess a # fr " + _lo + "-" + _hi + ":");
		userInput = Keyboard.readInt();
	    }
	}
	
	System.out.println("Correct! It took " + _guessCtr + " guesses");//Victory message	    
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	//playRec();
	playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {
	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();

    }//end main

}//end class
