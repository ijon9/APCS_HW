/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/
//Isaac Jon
//APCS1 pd8
//HW49 -- Halving the Halves
//2017-12-08

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;
    private boolean firstRun;
    private int lo, hi, binInd;
   
    


    // default constructor initializes instance variable _data
    public OrderedArrayList()
    {
	_data = new ArrayList<Comparable>();
	firstRun = true; //Toggle to see if it is its first run
    }


    public String toString()
    {
	return _data.toString(); 
    }


    public Comparable remove( int index )
    {	
	return _data.remove(index); 
    }


    public int size()
    { 
	return _data.size();
    }

    
    public Comparable get( int index )
    { 
	return _data.get(index); 
    }


    /***
     * add takes as input any comparable object 
     * (i.e., any object of a class implementing interface Comparable)
     * inserts newVal at the appropriate index
     * maintains ascending order of elements
     * uses a linear search to find appropriate index
     ***/
    public void add( Comparable newVal )
    { 
	for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
		//newVal < oal[p]
		_data.add( p, newVal );
		return; //Q:why not break?
	    }
	}
	_data.add( newVal ); //newVal > every item in oal, so add to end 
    }

    //addBin(), which employs a binary search to locate the point of insertion for a new element.
    public void addBin( Comparable newVal )
    {
	if(firstRun) { //Toggle to make sure that recalling addBin won't reset lo and hi to original, when function is called recursively
	    lo = 0;
	    hi = _data.size() - 1;
	    binInd = (hi + lo) / 2;
	}
	if(_data.size() == 0) //If there are no elements, just add newVal. 
	    _data.add(newVal);
	else if(newVal.compareTo( _data.get(binInd - 1)) >= 0 && newVal.compareTo(_data.get(binInd)) <= 0) {
	    _data.add(binInd, newVal); //If newVal is less than element at bindInd and greater than the element before, insert it into that position. 
	    firstRun = true;
	}
	else if(newVal.compareTo(_data.get(binInd-1)) < 0){ //If newVal is smaller than the element at the index before, focus on the half from 0 to binInd
	    hi = binInd;
	    binInd = (hi + lo) / 2;
	    firstRun = false;
	    addBin(newVal);
	}
	else { //Else, newVal is larger than the element in front, so focus on the half from binInd to the last element
	    lo = binInd;
	    binInd = (hi + lo) / 2;
	    firstRun = false;
	    addBin(newVal);
	}
    }

    

    



    // main method solely for testing purposes
    public static void main( String[] args )
    {
	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.add( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	//check for sorted-ness
	//if msg does not appear, list was sorted
	for( int i=0; i<Franz.size()-1; i++ ) {
	    System.out.println("at i: " + Franz.get(i) );
	    if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
		System.out.println( " *** NOT sorted *** " );
		break;
	    }
	}

	//testing addBin()
	Franz.addBin(30);
	System.out.println(Franz);
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class OrderedArrayList
