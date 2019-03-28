public class 方格计数 {
	public static void main(String[] args) {
		int R=1000;
		int a=1000,b=0,tb=b,count=0;
		for(a=1000;a>=0;a--) {
			while(a*a+b*b<=R*R)b++;
			b--;
			count+=a*(b-tb);
			tb=b;
		}
		System.out.println(count*4);
	}
}
