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
	bestBubble.add(1);
	bestBubble.add(2);
	bestBubble.add(3);
	bestBubble.add(4);
	bestBubble.add(5);
	System.out.println("Best Case: " + bestBubble);
	MySorts.bubbleSortV(bestBubble);
	System.out.println("Sorted version: " + bestBubble);

	System.out.println("---------------------------");
       
	ArrayList worstBubble = new ArrayList<Comparable>();
	worstBubble.add(5);
	worstBubble.add(4);
	worstBubble.add(3);
	worstBubble.add(2);
	worstBubble.add(1);
	System.out.println("Worst Case: " + worstBubble);
	MySorts.bubbleSortV(worstBubble);
	System.out.println("Sorted version: " + worstBubble);

	System.out.println("================= SelectionSort: ===============");
	ArrayList bestSelection = new ArrayList<Comparable>();
	bestSelection.add(1);
	bestSelection.add(2);
	bestSelection.add(3);
	bestSelection.add(4);
	bestSelection.add(5);
	System.out.println("Best Case: " + bestSelection);
	MySorts.bubbleSortV(bestSelection);
	System.out.println("Sorted version: " + bestSelection);

	System.out.println("---------------------------");
       
	ArrayList worstSelection = new ArrayList<Comparable>();
	worstSelection.add(5);
	worstSelection.add(1);
	worstSelection.add(2);
	worstSelection.add(3);
	worstSelection.add(4);
	System.out.println("Worst Case: " + worstSelection);
	MySorts.bubbleSortV(worstSelection);
	System.out.println("Sorted version: " + worstSelection);

	System.out.println("================= InsertionSort: ===============");
	ArrayList bestInsertion = new ArrayList<Comparable>();
	bestInsertion.add(1);
	bestInsertion.add(2);
	bestInsertion.add(3);
	bestInsertion.add(4);
	bestInsertion.add(5);
	System.out.println("Best Case: " + bestInsertion);
	MySorts.bubbleSortV(bestInsertion);
	System.out.println("Sorted version: " + bestInsertion);

	System.out.println("---------------------------");
       
	ArrayList worstInsertion = new ArrayList<Comparable>();
	worstInsertion.add(5);
	worstInsertion.add(4);
	worstInsertion.add(3);
	worstInsertion.add(2);
	worstInsertion.add(1);
	System.out.println("Worst Case: " + worstInsertion);
	MySorts.bubbleSortV(worstInsertion);
	System.out.println("Sorted version: " + worstInsertion);

	System.out.println("====================================");



	


	
	
    }








}
