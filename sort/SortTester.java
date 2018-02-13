<<<<<<< HEAD
=======
//Xinyi Huang and Isaac Jon -- The Trainers
//APCS1 pd8
//HW53 -- Solid Comparative Analysis
//2017-12-14


>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
import java.util.ArrayList;

public class SortTester {
    //=================== HELPER METHODS ===================
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
    //======================================================

    
    public static void main(String[] args) {
	System.out.println("================= BubbleSort: ===============");
	ArrayList bestBubble = new ArrayList<Comparable>();
<<<<<<< HEAD
	bestBubble.add(1);
=======
	bestBubble.add(1); //Best case: Elements in ascending order
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
	bestBubble.add(2);
	bestBubble.add(3);
	bestBubble.add(4);
	bestBubble.add(5);
	System.out.println("Best Case: " + bestBubble);
	MySorts.bubbleSortV(bestBubble);
	System.out.println("Sorted version: " + bestBubble);

	System.out.println("---------------------------");
       
	ArrayList worstBubble = new ArrayList<Comparable>();
<<<<<<< HEAD
	worstBubble.add(5);
=======
	worstBubble.add(5); //Worst case: Elements in descending order
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
	worstBubble.add(4);
	worstBubble.add(3);
	worstBubble.add(2);
	worstBubble.add(1);
	System.out.println("Worst Case: " + worstBubble);
	MySorts.bubbleSortV(worstBubble);
	System.out.println("Sorted version: " + worstBubble);
<<<<<<< HEAD

	System.out.println("================= SelectionSort: ===============");
	ArrayList bestSelection = new ArrayList<Comparable>();
	bestSelection.add(1);
=======
	
	/*====Explanation for BubbleSort====
	  Best case scenario for ALL OF THE SORTS: is an ArrayList already in ascending order, as no changes / swaps need to be made to the ArrayList.

	  Worst Case: An arrayList in descending order, the last element repeatedly floats to the front of the arrayList like bubbles
	 ==================================*/
	System.out.println("================= SelectionSort: ===============");
	ArrayList bestSelection = new ArrayList<Comparable>();
	bestSelection.add(1);//Best case: Elements in ascending order
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
	bestSelection.add(2);
	bestSelection.add(3);
	bestSelection.add(4);
	bestSelection.add(5);
	System.out.println("Best Case: " + bestSelection);
	MySorts.bubbleSortV(bestSelection);
	System.out.println("Sorted version: " + bestSelection);

	System.out.println("---------------------------");
       
	ArrayList worstSelection = new ArrayList<Comparable>();
<<<<<<< HEAD
	worstSelection.add(5);
=======
	worstSelection.add(5);//Worst case: Element at index 0 is the largest, the rest of the elements are sorted in ascending order
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
	worstSelection.add(1);
	worstSelection.add(2);
	worstSelection.add(3);
	worstSelection.add(4);
	System.out.println("Worst Case: " + worstSelection);
	MySorts.bubbleSortV(worstSelection);
	System.out.println("Sorted version: " + worstSelection);
<<<<<<< HEAD

	System.out.println("================= InsertionSort: ===============");
	ArrayList bestInsertion = new ArrayList<Comparable>();
	bestInsertion.add(1);
=======
	/* ======Explanation for Selectionsort=========
	   Worst Case: An arrayList with the largest element at index 0, and the rest of the arrayList is relatively sorted, because the largest element will continually be swapped with the correct element, until the largest element reaches the end of the ArrayList. 
	=======================================*/
	System.out.println("================= InsertionSort: ===============");
	ArrayList bestInsertion = new ArrayList<Comparable>();
	bestInsertion.add(1);//Best case: Elements in ascending order
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
	bestInsertion.add(2);
	bestInsertion.add(3);
	bestInsertion.add(4);
	bestInsertion.add(5);
	System.out.println("Best Case: " + bestInsertion);
	MySorts.bubbleSortV(bestInsertion);
	System.out.println("Sorted version: " + bestInsertion);

	System.out.println("---------------------------");
       
	ArrayList worstInsertion = new ArrayList<Comparable>();
<<<<<<< HEAD
	worstInsertion.add(5);
=======
	worstInsertion.add(5);//Worst Case: Elements in descending order
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
	worstInsertion.add(4);
	worstInsertion.add(3);
	worstInsertion.add(2);
	worstInsertion.add(1);
	System.out.println("Worst Case: " + worstInsertion);
	MySorts.bubbleSortV(worstInsertion);
	System.out.println("Sorted version: " + worstInsertion);
<<<<<<< HEAD

=======
	/*=======Explanation for InsertionSort===========/
	  Worst Case: The ArrayList is in ascending order, because as the partition is moved to the right, every element beyond the partition has to be inserted at its correct position within the partition
	  =====================================*/
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
	System.out.println("====================================");



	


	
	
    }








}
