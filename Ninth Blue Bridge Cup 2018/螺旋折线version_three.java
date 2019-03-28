



import java.util.Scanner;

public class 螺旋折线 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int x = sc.nextInt(); //给出整点坐标(X,Y)
        int y = sc.nextInt();
        boolean ok = false; //设置判定条件
        int x1 = 0, y1 = 0,m=0,count=0;
        
        while(!ok){ //当ok为false时执行while循环语句,直到x1和y1匹配到设置的整点坐标(X,Y)的值
        	
            if(x1==x&&y1==y){
                ok = true; //当值匹配时ok条件变为true
                break;  //break:跳出当前循环;但是如果是嵌套循环,则只能跳出当前的这一层循环,只有逐层break才能跳出所有循环
            }
            m++;//m记录走的步数,若ok条件为true或者上面的if语句不成立为匹配到相应的X,Y值时,跳出if语句执行m++
            if(m%2==1){//奇数步
                for(int i = 0; i<m; i++){
                    if(x1==x&&y1==y){
                        ok = true;
                        break;//跳出当前语句
                    }
                    x1-=1;//x1=x1-1,
                    count++;//记录步数+1
                }
                for(int i = 0;i<m;i++){
                    if(x1==x&&y1==y){
                        ok = true;
                        break;
                    }
                    y1+=1;
                    count++;
                }
            }else if(m%2==0){//偶数步
                for(int i = 0; i<m; i++){
                    if(x1==x&&y1==y){
                        ok = true;
                        break;
                    }
                    x1+=1;
                    count++;
                }
                for(int i = 0;i<m;i++){
                    if(x1==x&&y1==y){
                        ok = true;
                        break;
                    }
                    y1-=1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
 
}

/*每一步走一个折线,
奇数步左上（x-n,y）(x-n,y+n),
偶数步右下（x+n,y）(x+n,y-n),
n为步数，在走的过程中判断最后加一个统计变量即可

转载:https://blog.csdn.net/qq_37669997/article/details/79796329*/
