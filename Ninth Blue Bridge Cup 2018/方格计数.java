/*标题：方格计数
如图p1.png所示，在二维平面上有无数个1x1的小方格。
我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
你能计算出这个圆里有多少个完整的小方格吗？ 
注意：需要提交的是一个整数，不要填写任何多余内容。*/
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

