

/*
思路:
按象限划分四个部分，以拐点为突破口。
根据给定坐标求解拐点是比较简单的，我们对于每个点都求出它x和y中较大的那个值，然后我们可以得到： 
拐点处坐标   第一、二、四象限|dx|==|dy|即绝对值相等    第三象限  dy=dx+1
Math.abs(x)=|x| 
第一象限的拐点坐标——dx = max(abs(x), abs(y)),dy = dx 
第二象限的拐点坐标——dx = -max(abs(x), abs(y)),dy = -dx 
第三象限的拐点坐标——dx = -max(abs(x), abs(y)),dy = dx + 1 
第四象限的拐点坐标——dx = max(abs(x), abs(y)),dy = -dx

假定拐点坐标为(dx, dy),我们有 
第一象限的拐点的dfs()——(abs(dx)+abs(dy))^2  即 df = (dx + dy) * (dx + dy);
第二象限的拐点的dfs()——(abs(dx)+abs(dy)) * (abs(dx)+abs(dy) - 1) 
第三象限的拐点的dfs()——(abs(dx)+abs(dy))^2 
第四象限的拐点的dfs()——(abs(dx)+abs(dy)) * (abs(dx)+abs(dy) + 1)
之后根据给定坐标(x, y)与拐点坐标(dx, dy)的关系就可以轻松的解出来了。 
还要特别注意给定坐标中x或y等于0的情况，这里我把四种情况分别归到了四个象限中
时间复杂度为O(1)
 * */

import java.util.Scanner;

public class 螺旋折线 {
    static int x, y; 
    static int df = 0;  //static类型的df值用于记录步长
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        x = in.nextInt();  //输入的坐标X,Y
        y = in.nextInt();

        if (x > 0 && y >= 0) {  //第一象限
            int dx = Math.max(x, y);  //拐点坐标dx为输入的定坐标(x,y)的最大值
            int dy = dx; //第一象限处拐点值dx=dy
            df = (dx + dy) * (dx + dy); //当拐点坐标即定坐标时
            if (x < dx) { //定坐标x值小于拐点坐标dx值时,df=df-(dx-x)
                df -= (dx - x);
            }
            if (y < dy) {//定坐标y值小于拐点坐标dy值时,df=df+(dy-y)
                df += (dy - y);
            }
        }
        else if (x >= 0 && y < 0) { //第四象限
            int dx = Math.max(Math.abs(x), Math.abs(y));//求第四象限内的定坐标(x,y)的绝对值的最大值
            int dy = -dx; //dy为-,dx为+
            df = (dx + Math.abs(dy)) * (dx + Math.abs(dy) + 1);
            if (x < dx) { //dx和x均为正数
                df += (dx - x);
                
            }
            if (y > dy) { //dy和y均为负数
                df -= (y - dy);
            }
        } 
        else if (x < 0 && y <= 0) { //第三象限,拐点坐标中dy=dx-1
            int dx = -Math.max(Math.abs(x), Math.abs(y));
            int dy = dx + 1;
            df = (Math.abs(dx) + Math.abs(dy)) * (Math.abs(dx) + Math.abs(dy));
            if (x > dx) {
                df -= (x - dx);
            }
            if (y > dy) {
                df += (y - dy);
            }
        } 
        else  if (x <= 0 && y > 0) { //第二象限
            int dx = -Math.max(Math.abs(x), Math.abs(y));
            int dy = -dx;
            df = (Math.abs(dx) + Math.abs(dy)) * (Math.abs(dx) + Math.abs(dy) - 1);
            if (x > dx) {
                df += (x - dx);
            }
            if (y < dy) {
                df -= (y - dy);
            }
        }
        System.out.println(df);
    }
}

