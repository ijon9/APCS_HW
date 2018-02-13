<<<<<<< HEAD
=======
// Isaac Jon
// APCS2 pd2
// HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2018-02-06

>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
<<<<<<< HEAD

  ======================================*/

public class Merge
=======
  sort uses recursion to return a sorted array. The first part of the code is preliminary work
  which designates the two halves of arr. The first half is the array named first, and the second half is the array 
  named last. Then, it checks if the length of arr 
  is greater than 1. If it is, it calls merge on sort(first) and sort(last), the equivalent of handing the two 
  halves to two other thinkers. Calling merge means that the turtle expects two arrays of sorted ints back, then merges them.
  Since sort always returns a sorted array, calling merge on sort(first) and sort(last) will always result in the two sorted 
  arrays. 
  ======================================*/

public class MergeSort
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
<<<<<<< HEAD

=======
    int aInd = 0;
    int bInd = 0;
    int[] result = new int[a.length + b.length];
    for(int i = 0; i < result.length; i++) {
        if(aInd < a.length && bInd < b.length) {
            if(a[aInd] < b[bInd]) {
                result[i] = a[aInd];
                aInd += 1;
            }
            else {
                result[i] = b[bInd];            
                bInd += 1;
            }
        }
        else if(aInd >= a.length && bInd < b.length) {
            result[i] = b[bInd];
            bInd += 1;
        }
        else if(bInd >= b.length && aInd < a.length) {
            result[i] = a[aInd];
            aInd += 1;
        }
    }
    return result;
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
<<<<<<< HEAD

=======
    int lInd = 0;
    int mid = (arr.length / 2);
    int[] first = new int[mid];
    int[] last = new int[arr.length - mid];
    
    for(int i = 0; i < mid; i++) {
        first[i] = arr[i];
    }
    for(int i = mid; i < arr.length; i++ ) {
        last[lInd] = arr[i]; 
        lInd += 1;
    }

    if(arr.length > 1) {
        return merge(sort(first), sort(last));  
    }

    return arr;
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

<<<<<<< HEAD
    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
=======
   
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
<<<<<<< HEAD
=======
      int[] arr8 = {2, 3,4, 5, 12, 24, 35};
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

<<<<<<< HEAD
      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

=======
      System.out.println("\nMerging arr4 and arr8: ");
      printArray( merge(arr4,arr8) );
 
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
<<<<<<< HEAD
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
=======
      
>>>>>>> be2f54aadab08276401fd699f8cd9d33f4a2c284
  }//end main()

}//end class MergeSort
