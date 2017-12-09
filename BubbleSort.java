/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/
//Isaac Jon
//APCS1 pd8
//HW50 -- Dat Bubbly Tho
//2017-12-11

import java.util.ArrayList; //Imports better version of SuperArray

public class BubbleSort {

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
	//setup for traversal fr right to left
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }

    //copies ArrrayList x into new ArrayList y
    public static void copyTo(ArrayList x, ArrayList y) {
	for(int i = 0; i < x.size(); i++) {
	    y.add(x.get(i));
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data )
    {
	//Runs based on how many passes there have been, stopping once pass = n - 1
	for(int pass = 1; pass < data.size()-1; pass++) {
	    for(int i = data.size()-1; i > 0; i--) { //Goes through the ArrayList, starting from the end
		Comparable hold = data.get(i);
		//Switches element at i with the previous one if i is less than that one
		if(hold.compareTo(data.get(i-1)) < 0) {
		    data.set(i, data.get(i-1));
		    data.set(i-1, hold);
		}
	    }
	}
    }


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
    {
	//Creates ArrayList data1 which will be sorted version of input
	ArrayList<Comparable> data1 = new ArrayList<Comparable>();
	copyTo(input, data1); //Copies input into data1

	//Same algorithm as in bubbleSortV, makes sure to not actually change the inputted ArrayList
	for(int pass = 1; pass < data1.size()-1; pass++) {
	    for(int i = data1.size()-1; i > 0; i--) {
		Comparable hold = data1.get(i);
		if(hold.compareTo(data1.get(i-1)) < 0) {
		    data1.set(i, data1.get(i-1));
		    data1.set(i-1, hold);
		}
	    }
	}
	
	return data1; //Returns sorted copy of input ArrayList
    }


    public static void main( String [] args )
    {
	/* ============================================
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bubbleSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bubbleSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	=================================================*/

	/* ==================================================
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = bubbleSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = bubbleSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	===================================================*/

    }//end main

}//end class BubbleSort
