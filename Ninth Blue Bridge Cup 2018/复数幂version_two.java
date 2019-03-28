import java.math.BigInteger;

public class 复数幂 {
	public static void main(String[] args) {
		Complex cmp = new Complex(BigInteger.valueOf(2), BigInteger.valueOf(3));
		System.out.println(quickPow(cmp, 123456).toString());
	}
	
	private static Complex quickPow(Complex cmp, int n) {
		if (n == 0) {
			return new Complex(BigInteger.valueOf(1), BigInteger.valueOf(0));
		}
		Complex temp = quickPow(cmp, n / 2);
		temp.multiply(temp);
		if (n % 2 != 0) {
			temp.multiply(cmp);
		}
		return temp;
	}
}
 
class Complex {
	BigInteger a;  // 实部
	BigInteger b;  // 虚部
	
	public Complex(BigInteger a, BigInteger b) {
		this.a = a;
		this.b = b;
	}
	
	public void multiply(Complex cm) {
		BigInteger tempa = a.multiply(cm.a).subtract(b.multiply(cm.b));
		BigInteger tempb = a.multiply(cm.b).add(b.multiply(cm.a));
		a = tempa;
		b = tempb;
	}
	
	@Override
	public String toString() {
		String aStr = "" + a;
		String bStr = b + "i";
		if (b.compareTo(BigInteger.valueOf(0)) > 0) {
			bStr = "+" + bStr;
		} else if (b.compareTo(BigInteger.valueOf(0)) == 0) {
			bStr = "";
		}
		return aStr + bStr;
	}
}
