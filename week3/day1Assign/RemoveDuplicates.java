package week3.day1Assign;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		int count = 0;
		String[] split = text.split(" ");
		System.out.println("Before removing duplicate string "+Arrays.toString(split));
		 for(int i =0;i<split.length;i++) {
			 for(int j=1; j<i;j++) {
				 if(split[i].equals(split[j])) {
					 count++;
					 if(count>=1) {
						 split[i] = " ";
					 }
				 }
			 }
		 }
		 System.out.print("After removing duplicate string "+Arrays.toString(split));
	}

}
