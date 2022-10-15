package week3.day1Assign;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String text1= "stops", text2 = "potss";
		int t1 = text1.length(), t2 = text2.length();
		char[] ch1 = text1.toCharArray();
		char[] ch2 = text2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if(t1==t2) {
			if(Arrays.equals(ch1, ch2)) {
				System.out.println("The String "+text1+" and "+text2+" are anagram");
			  }else {
				System.out.println("The String "+text1+" and "+text2+" are not anagram");
			  }
		}else {
			System.out.println("The String "+text1+" and "+text2+" are not anagram");
		}
	}

}
