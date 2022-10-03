package week1.day2Assign;

public class ConvertNegativeToPositive {

	public static void main(String[] args) {
		int num = -40;
		int t = num;
		
		if(num<0) {
			System.out.println("The number "+num+" is a negative number");
			// To convert negative number to positive number
			num=num*-1;
		}
		
		if(num != t) {
			System.out.println("The number "+t+" is converted to "+num);
		}
	}

}
