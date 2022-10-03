package week1.day2Assign;

public class FindIntersection {

	public static void main(String[] args) {
		int a[] = {3,2,11,4,6,7};
		int b[] = {1,2,8,4,9,7};
		int al = a.length;
		int bl = b.length;
		for(int i=0;i<al;i++) {
			for(int j=0; j<bl;j++) {
				if(a[i]==b[j]) {
					System.out.println("The intersection of array a[] and b[] are "+a[i]);
				}
			}
		}

	}

}
