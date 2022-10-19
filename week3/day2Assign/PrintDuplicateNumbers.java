package week3.day2Assign;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintDuplicateNumbers {

	public static void main(String[] args) {
		int[] data = {4,3,6,8,29,1,2,4,7,8};
		Arrays.sort(data);
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<data.length-1;i++) {
			if(data[i]== data[(i+1)]) {
				set.add(data[i]);
			}
		}
		System.out.println("The duplicate numbers are "+set);
	}

}
