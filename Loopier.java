//Isaac Jon
//APCS1 pd 8
//HW 25 -- All Hallow's Eve
//2017-11-02

import java.util.Arrays;

public class Loopier {

    static int[] i = new int[5]; //Initiates int array i for testing randPop

    static int[] num = { //Defines num array
        1, 3, 4, 2, 5, 2, 2, 2, 2
    };

    public static void randPop(int[] arr) { 
        for (int pos = 0; pos < arr.length; pos++) { //While position is less than length, increment pos
            arr[pos] = (int) (100 * Math.random()); //Set value at position to random integer between 0 and 100
            // System.out.println(arr[pos]); //For testing purposes
        }
    }

    public static String[] intArrtoStr(int[] arr) {
        String[] result = new String[arr.length]; //Declares result array
        for (int pos = 0; pos < arr.length; pos++) { //While pos less than length, increment pos
            result[pos] = "" + arr[pos]; //Turn pos into string by adding empty string to it
            // System.out.println(result[pos]); //Testing
        }
        return result; 
    }

    public static int linSearch(int[] a, int target) {
        for (int pos = 0; pos < a.length; pos++) { //While pos less than length, increment pos
            if (a[pos] == target) //If value at pos = target, return pos
                return pos;
        }
        return -1; //If no value equals target, return -1
    }

    public static int linSearchR(int[] a, int target) {
        if (a.length < 1) //Makes sure length must be at least 1
            return 0; //Returns 0 if length is 0
        if (a[0] == target) //Base case: If value at first position = target
            return 0; //return 0 to end recursion
        return 1 + linSearchR(Arrays.copyOfRange(a, 1, a.length), target); //Recursive case, where the first value is omitted
    }

    
    public static int freq(int[] a, int target) {
        int result = 0; //Initialize result
        for (int pos = 0; pos < a.length; pos++) { //If pos < length, increment pos
            if (a[pos] == target) //If first value = target
                result += 1; //Add 1 to result
        }
        return result; 
    }

    public static int freqRec(int[] a, int target) {
        if (a.length < 1) //Makes sure length must be at least 1
            return 0; //Returns 0 if length is 0
        if (a[0] == target) //If first value = target
            return 1 + freqRec(Arrays.copyOfRange(a, 1, a.length), target); //Adds 1, and continues freqRec with first value removed  
        return freqRec(Arrays.copyOfRange(a, 1, a.length), target); //Recursive case: continues freqRec with first value removed
    }

    public static void main(String[] args) {
        // randPop(i);
        // intArrtoStr(i);
        System.out.println(linSearch(num, 2)); //3
        System.out.println(linSearchR(num, 2)); //3
        System.out.println(linSearch(num, 4)); //2
        System.out.println(linSearchR(num, 4)); //2
        System.out.println(freq(num, 4)); //1
        System.out.println(freqRec(num, 4)); //1
        System.out.println(freq(num, 2)); //5
        System.out.println(freqRec(num, 2)); //5
    }
}