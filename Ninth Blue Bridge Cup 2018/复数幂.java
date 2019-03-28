/*标题：复数幂
设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。
答案写成 "实部±虚部i" 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。(2+3i)^2 写成: -5+12i，
(2+3i)^5 的写成: 122-597i
注*/

import java.io.*;
import java.math.BigInteger;
 
public class 复数幂1 {
	public static void main(String[] args) throws FileNotFoundException {//表示这个方法有可能会发生找不到文件这个错误。
		PrintStream ps=new PrintStream(new FileOutputStream("work.txt")); 
		//IO流:
		//打印输出流,相当于PrintStream ps=System.out; ps.print("hello"); 就等同于 System.out.println("hello");
	    System.setOut(ps);  //文件输出,重定向输出到ps对象中(即文件work.txt中)
		int n=123456;
		BigInteger a=new BigInteger("2");
		BigInteger b=new BigInteger("3");
		BigInteger a1=new BigInteger("2");  //a1,b1 即不变化的2+3i
		BigInteger b1=new BigInteger("3");
		for(int i=1;i<n;i++) {
			BigInteger ta=a;
			a=a.multiply(a1).subtract(b.multiply(b1));//a=a*a1-b*b1;  对于不含i部分的运算
			b=ta.multiply(b1).add(b.multiply(a1));//b=a*b1+b*a1    对于含i部分的运算
		}
		System.out.println(a+(b.compareTo(BigInteger.ZERO)>0?"+":"")+b+"i");
		//b.compareTo(BigInteger.ZERO)>0?"+":""  若b大于大数类的常数0则写+,否则不写
		//a为不含i的系数部分,b为含i的系数部分
	}
}

/*
作者：heyAmos 
来源：CSDN 
*/
