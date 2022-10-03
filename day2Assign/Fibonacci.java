package week1.day2Assign;

public class Fibonacci {

	public static void main(String[] args) {
		int range = 8;
		int fn = 0;
		int sn = 1;
		System.out.println(fn);
		for(int i = 1; i<=range;i++) {
			int sum = fn+sn;
			fn = sn;
			sn = sum;
			System.out.println(sum);
			
		}
	}

}
