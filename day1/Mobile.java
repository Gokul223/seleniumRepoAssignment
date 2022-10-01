package week1.day1;

public class Mobile {
	
	public void makeCall() {
		String mobileModel= "iphoneSe2";
		float mobileWeight= 147.99f;
		System.out.println("My mobile model is "+mobileModel);
		System.out.println("My mobile weight is "+mobileWeight+" grams");
		return;
	}
	
	
	public void sendMsg() {
		boolean isFullCharged = false;
		int mobileCost = 30000;
		System.out.println("My mobile is fully charged "+isFullCharged);
		System.out.println("My mobile cost is "+mobileCost);
	}
	
	public static void main(String[] args) {
		Mobile mob = new Mobile();
		mob.makeCall();
		mob.sendMsg();
		System.out.println("This is my mobile");
	}

}
