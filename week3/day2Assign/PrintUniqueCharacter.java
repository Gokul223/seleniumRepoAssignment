package week3.day2Assign;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		String input = "babu";
		char[] ch = input.toCharArray();
		Set<Character> cha = new HashSet<Character>();
		System.out.println("The given string is --> "+input);
		for(int i=0;i<ch.length;i++) {
			cha.add(ch[i]);
		}
		for(int i=0;i<ch.length;i++) {
			for(int j=(i+1);j<ch.length;j++) {
				if(ch[i]==ch[j]) {
					cha.remove(ch[i]);
				}
			}
		}
		
		System.out.println("The unique character in the given String is --> "+cha);
	}

}
