package week3.day2Assign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		// create new empty TreeSet
		Set<Integer> set = new TreeSet<Integer>();
		//Add array to set using for loop
		for(int i=0; i<data.length;i++) {
			set.add(data[i]);
		}
		// Convert set to list
		List<Integer> list = new ArrayList<Integer>(set);
		// Find the maximum number and remove
		Integer LargestNum = Collections.max(list);
		list.remove(LargestNum);
		Integer SecondLargestNum = Collections.max(list);
		System.out.println("The Second largest number is "+SecondLargestNum);
	}

}
