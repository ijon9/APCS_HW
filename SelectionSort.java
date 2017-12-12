/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/
//Isaac Jon
//APCS1 pd8
//HW51 -- Selection
//2017-12-12

import java.util.ArrayList;

public class SelectionSort 
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data ) 
  {
      for(int pass = 0; pass < data.size()-1; pass++) { //Makes sure the comparable at pass is the smallest element in the arrayList, starts pass at 0 to start at the beginning of the arrayList
	  Comparable lowest = data.get(pass);
	  int lowestInd = pass;
	  for(int i = pass + 1; i < data.size(); i++) { //Compares element at pass to the other elements of the arrayList
	      if(lowest.compareTo(data.get(i)) > 0) { //If the element being compared to data[pass], then that element becomes the new lowest one, and will then be the one that will be compared to the remaining elements.  
		  lowest = data.get(i);
		  lowestInd = i;
	      }
	  }
	  data.set(pass, data.set(lowestInd, data.get(pass)));    
      }
  }//end selectionSortV


  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
  {
      ArrayList<Comparable> data = new ArrayList<Comparable>();
      for(Comparable c : input)
	  data.add(c);
      selectionSortV(data);
      return data;
  }//end selectionSort 


  public static void main( String [] args ) 
  {
      /*
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      selectionSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );
      
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      selectionSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      */
      
    	ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      
      
  }//end main

}//end class SelectionSort
