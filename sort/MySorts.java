import java.util.ArrayList;

public class MySorts {

    public static void bubbleSortV( ArrayList<Comparable> data ) {
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) 
		    data.set( i, data.set(i+1,data.get(i)) );	
		//System.out.println(data); //diag: show current state of list
	    }
	}
    }

    public static void selectionSortV( ArrayList<Comparable> data ) {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	}
    }//end selectionSortV

    public static void insertionSortV( ArrayList<Comparable> data ) {
	//starts index of partition
	for(int partition = 0; partition < data.size()-1; partition++) {
	    for(int walkEle = partition+1; walkEle > 0; walkEle--) { //Sets element to be walked as the element right after the partition
		if(data.get(walkEle).compareTo(data.get(walkEle-1)) < 0)//Swaps walkEle with the element before
		    data.set(walkEle, data.set(walkEle-1, data.get(walkEle)));
		else
		    break; //Ends the for loop if it doesn't meet the condition of the swap, meaning that its in the correct position in the partition
	    }
	}
    }//end insertionSortV

}
