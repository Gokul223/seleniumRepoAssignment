package week3.day2Assign;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		int[] a1 = {3,2,11,4,6,7};
		int[] a2 = {1,2,8,4,9,7};
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		for(int i=0; i<a1.length;i++) {
		l1.add(a1[i]);
	}
		for(int i=0; i<a2.length;i++) {
			l2.add(a2[i]);
		}
		for(int i=0;i<l1.size();i++) {
			for(int j=0;j<l2.size();j++) {
				if(l1.get(i).equals(l2.get(j))) {
					l3.add(l1.get(i));
				}
			}
		}
		System.out.println("The intersection of two arrays are "+l3);
	}

	
}
