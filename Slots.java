/*****************************************************
 * class Slots
 * simulates a slot machine in your very own terminal
 * Isaac Jon
 * APCS1 pd8
 * HW26 -- Spin Class
 * 2017-11-08
 *****************************************************/

public class Slots
{

  private static final String[] FRUITS = {
    "lime", "lime", "lime", 
    "lemon", "lemon", "lemon", 
    "cherry", "cherry", "cherry", 
    "orange", "orange", "orange", 
    "grapefruit", "grapefruit", "grapefruit", 
    "tangerine", "tangerine", "tangerine", 
    "ugli", "ugli", "ugli",
    "peach", "peach", "peach"
  };
  
  private String[] _fruits; //to be init'd by each instance

  //Helper functions
  public boolean allEquals(String a, String b, String c) { //Checks if all values are equal
    return a == b && a == c;
  }

  public boolean mutuallyDistinct(String a, String b, String c) { //Checks if all values are distinct
    return !allEquals(a, b, c);
  }


  /*=====================================
    Slots() -- default constructor
    pre:  constant array FRUITS exists, has been initialized
    post: mutable array _fruits contains same elements as FRUITS
    =====================================*/
  public Slots()
  {
    //allocate memory for _fruits based on size of FRUITS:
    _fruits = new String[FRUITS.length];
    //copy elements of FRUITS into _fruits:
    for(int pos = 0; pos < _fruits.length; pos++) {
      _fruits[pos] = FRUITS[pos];
    }
  }


  /*=====================================
    String toString() -- overrides inherited toString()
    pre:  
    post: returns String of elements in slots 0 thru 2, separated by tabs
    =====================================*/
  public String toString()
  {
    return _fruits[0] + "\t" + _fruits[1] + "\t" + _fruits[2];
  }


  /*=====================================
    void swap(int,int) -- array swap util fxn
    pre:  _fruits array exists
    post: elements at indices i, j are swapped
    =====================================*/
  private void swap( int i, int j )
  {
    String ogI = _fruits[i];
    String ogJ = _fruits[j];
    _fruits[i] = ogJ;
    _fruits[j] = ogI;
  }


  /*=====================================
    void spinOnce() -- simulate a pull of the slot machine lever
    pre:  _fruits array exists
    post: randomized order of elements in _fruits array
    =====================================*/
  public void spinOnce()
  {
    for(int pos = 0; pos < _fruits.length; pos++) {
      swap(pos, (int) (Math.random() * _fruits.length)); //Each fruit swaps with another random fruit in the array _fruits
    }
  }


  /*=====================================
    boolean jackpot() -- checks for a winning combo
    pre:  _fruits is existing array
    post: returns true if first 3 slots represent winning combo,
    false otherwise
    =====================================*/  
  public boolean jackpot() 
  {
    return allEquals(_fruits[0], _fruits[1], _fruits[2]);
  }


  /*=====================================
    boolean miniWin() -- checks for a winning combo
    pre:  _fruits is existing array
    post: returns true if first 3 slots represent winning combo,
    or if first 3 slots mutually distinct, 
    false otherwise
    =====================================*/
  public boolean miniWin() 
  {
    if (allEquals(_fruits[0], _fruits[1], _fruits[2]) || mutuallyDistinct(_fruits[0], _fruits[1], _fruits[2])) {
      return true;
    }
    return false;
  }


  //main() method for testing
  public static void main( String[] args )
  {
    //usage: move bar below down 1 line at a time to test functionality...
    
      Slots machine01 = new Slots();
      Slots machine02 = new Slots();

      //test to verify slot machines function indepently
      System.out.println( "Machine01 initial state:\t" + machine01);
      System.out.println( "Machine02 initial state:\t" + machine02);
      

      System.out.println( "\nSpinning machine01...\n" );

      machine01.spinOnce();

      System.out.println();
      System.out.println( "Machine01 state:\t" + machine01 );
      System.out.println( "Machine02 state:\t" + machine02 );
      System.out.println();


      // test gamble-until-you-win mechanism

      System.out.println( "Preparing to spin until a mini win! . . ." );
      System.out.println( "------------------------------------" );

      // //if you haven't won, spin again until you win!
      while( machine01.miniWin() == false ) {
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "LOSE\n" );
      machine01.spinOnce();
      }

      System.out.println( "====================================" );
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "WIN\n" );



      System.out.println( "Preparing to spin until...jackpot! . . ." );
      System.out.println( "------------------------------------" );

      // //if you haven't won, spin again until you win!
      while( machine01.jackpot() == false ) {
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "LOSE\n" );
      machine01.spinOnce();
      }

      System.out.println( "====================================" );
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "JACKPOT!\n" );
      
  }//end main

}//end class Slots