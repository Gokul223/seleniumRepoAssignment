package week1.day2Assign;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,6,7,8};
		Arrays.sort(a);
	    int al = a.length;
	    int i = 1;
	    while(i<al) {
	    	if((i != a[i]-1)) {
	    		System.out.println("The missing element in the array is "+(i+1));
	    		
	    		break;
	    	}
	    	++i;
	    } 
	}

}
