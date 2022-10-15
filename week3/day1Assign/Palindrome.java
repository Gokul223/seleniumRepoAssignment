package week3.day1Assign;


public class Palindrome {

	public static void main(String[] args) {
		String input = "madam",rev ="";
		char[] ch = input.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			rev = rev + ch[i];
	}
		if( rev.equals(input)){
			System.out.println("The given input "+input+" is palindrome");
		}else {
			System.out.println("The given input "+input+" is not palindrome");
		}

}
}	
