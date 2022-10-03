package week1.day2Assign;

public class Palindrome {

	public static void main(String[] args) {
		int num =34343;
		int reverse = 0;
		for(int i = num ;i>0;i=i/10){
			int reminder = i%10;
			reverse = reverse *10 + reminder;
		}
		System.out.println(reverse);
		if(num == reverse) {
			System.out.println(reverse+" is a palindrome");
		}else {
			System.out.println(reverse+" is not a palindrome");
		}
		
	}

}
