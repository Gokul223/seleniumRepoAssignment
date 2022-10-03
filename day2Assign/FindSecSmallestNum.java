package week1.day2Assign;

import java.util.Arrays;

public class FindSecSmallestNum {

	public static void main(String[] args) {
		int a[] = {23,45,67,32,89,22};
		Arrays.sort(a);
		System.out.println("The second smallest number of array is "+a[1]);
	}

}
