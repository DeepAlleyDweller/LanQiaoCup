public class 摔手机 {
	public static void main(String[] args) {
		System.out.println(DroppingPhone(3, 1000));
	}
 
	private static long DroppingPhone(long phone, long floors) {
		long times = 1;
		while (DroppingMax(phone, times) < floors) {
			++times;
		}
		return times;
	}
 
	private static long DroppingMax(long phone, long times) {
		if (phone == 1) {
			return times;
		}
 
		if (phone >= times) {
			return (long) Math.pow(2, times) - 1;
		}
 
		return DroppingMax(phone, times - 1) + DroppingMax(phone - 1, times - 1) + 1;
		//f(p,t)=f(p,t-1)+f(p-1,t-1)+1;加1为本次情况,
		//f(p,t-1)指手机未摔坏,层数-1;
		//f(p-1,t-1)指手机摔坏了,在层数t-1的基础上不变仍为t-1
	}
}
