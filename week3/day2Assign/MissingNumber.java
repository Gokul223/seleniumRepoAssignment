package week3.day2Assign;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		int[] data = {1,3,8,10,9,2,4,3,2,5,8,6};
		Set<Integer> set = new TreeSet<Integer>();
		for(int i=0; i<data.length;i++) {
			set.add(data[i]);
		}
		List<Integer> list = new ArrayList<Integer>(set);
		System.out.println(set);
		for (int i=0;i<set.size();i++) {
				if(list.get(i).equals(i+1)) {
					
				}else {
					System.out.println("The missing number is "+(i+1));
					break;
				}
		}
	}
}
