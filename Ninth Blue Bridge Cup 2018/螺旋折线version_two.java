import java.util.Scanner;

public class 螺旋折线{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long X = in.nextLong();
        long Y = in.nextLong();
        
        // 判断所在点所在的正方形
        long n = Math.max(Math.abs(X) , Math.abs(Y));

        // 1. 之前正方形的长度和
        long Sn = 4*(n-1)*n;
        
        // 2. 计算点(-n, -n) 到点(X, Y)的距离, 考虑清楚情况
        long sum = 0;
        long px = -n, py = -n;
        long d1 = X-px, d2 = Y-py;
        if (Y > X) {
            sum += (d1+d2);
        } else {
            sum += (8*n-d1-d2);    
        }
        System.out.println(sum + Sn);
    }
}

//Reference:https://blog.csdn.net/qq799028706/article/details/84312062
