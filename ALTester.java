//Isaac Jon
//APCS1 pd8
//HW#46 -- Al<B> Sorted! 
//2017-12-05

import java.util.ArrayList;

public class ALTester {
    
    public static void printArrList(ArrayList<Comparable> arrL) {
	String out = "[";
	for(int i = 0; i < arrL.size(); i++) {
	    out += arrL.get(i) + ",";
	}
	if (out.length() > 1) //shave off trailing comma
	    out = out.substring(0, out.length()-1);
	out += "]";
	System.out.println(out);
    }

    public static boolean sortCheck(ArrayList<Comparable> arrL) {
	for(int i = 1; i < arrL.size(); i++) {
	    if(!(arrL.get(i).compareTo(arrL.get(i-1)) >= 0))
		return false;
	}
	return true;
    }
    
    
    public static void main(String[] args) {
	ArrayList<Comparable> Bob = new ArrayList<Comparable>();
	
	for(int i = 0; i < 23; i++) { //Fills Bob with numbers from 0 - 22
	    Bob.add(i);
	}
	printArrList(Bob);
	System.out.println(sortCheck(Bob));

	int val = 1;
	int ind = 0;
	while (ind < 23) { //Fills Bob with Numbers 1 - 12, each repeating twice
	    Bob.set(ind, val);
	    if(ind + 1 < 23)
		Bob.set(ind + 1, val);
	    if(ind + 2 > 23)
		ind += 1;
	    else {
		ind += 2;
	    }
	    val += 1;
	}
	printArrList(Bob);
	System.out.println(sortCheck(Bob));

	Bob.set(3, 21); //Sets index 3 in Bob to 21
	printArrList(Bob);
	System.out.println(sortCheck(Bob));
	

	
	
	
    }



}
