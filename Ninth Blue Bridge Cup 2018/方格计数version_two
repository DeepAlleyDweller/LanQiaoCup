import java.util.Scanner;

public class 方格计数 {
	static int N = 10000; // 方格图的大小, 设置一个足够大的半径10000
	static int X = 5000, Y = 5000; // 圆心坐标
	static double[] l = new double[N]; 
	static double[] r = new double[N];
	static int R, ans = 0;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		for (int i = Y - R; i <= Y + R; i++) {
			l[i] = X - Math.sqrt(R * R - (Y - i) * (Y - i));
			r[i] = Math.min(N, (X << 1) - l[i]);
			if (l[i] < 0) {
				l[i] = 0;
			}
		}
		for (int i = Y - R; i <= Y - 1; i++) {
			int ll = (int) Math.ceil(l[i]), rr = (int) Math.floor(r[i]); 
			ans += rr - ll;
		}
		for (int i = Y; i <= Y + R - 1; i++) {
			int ll = (int) Math.ceil(l[i + 1]), rr = (int) Math.floor(r[i + 1]);
			ans += rr - ll;
		}
		System.out.println(ans);
	}
}
