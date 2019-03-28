/*给定三个整数数组 A = [A1, A2, ... AN], B = [B1, B2, ... BN], C = [C1, C2,... CN]
   请你统计有多少个三元组(i, j, k) 满足：
    1 <= i, j, k <= N
      Ai < Bj < Ck
【输入格式】 第一行包含一个整数N。 第二行包含N个整数A1, A2, ... AN。 第三行包含N个整数B1, B2, ... BN。
第四行包含N个整数C1, C2, ... CN。

对于30%的数据,1 <= N <= 100 
对于60%的数据,1 <= N <= 1000 
对于100%的数据,1 <= N <=100000
0<= Ai,Bi,Ci<= 100000

【输出格式】 一个整数表示答案

【输入样例】 
3
1 1 1
2 2 2
3 3 3

【输出样例】
27

资源约定： 峰值内存消耗（含虚拟机） < 256M CPU消耗 < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。 主类的名字必须是：Main，否则按无效代码处理。*/


import java.io.*;
import java.util.*;

  public class 递增三元组 {
		static DataInputStream in=new DataInputStream(System.in);//数据输入流
		static int n;
		public static void main(String[] args) throws IOException {	
			n=nextInt(); //它只读取int值，nextInt()在读取输入后将光标放在同一行
			int[] a=new int[n],b=new int[n],c=new int[n]; //三个整数数组的定义
			f1(a);
			f1(b);
			f1(c);
			//...以上输入与排序
			//第一步
			int p1=0,p2=0;
			int[] db=new int[n],sdb=new int[n];
			while(p1<n) { //双循环结构
				while(p2<n&&c[p2]<=b[p1])
					p2++;
				db[p1]=n-p2;
				sdb[p1]=(p1==0?0:sdb[p1-1])+db[p1];//Sn=Sn-1 + an;
				p1++;
			}
			//第二步
			p1=0;p2=0;int ans=0;
			while(p1<n) {
				while(p2<n&&b[p2]<=a[p1])p2++;
				ans+=sdb[n-1]-(p2==0?0:sdb[p2-1]);//加上b[p2]~b[n],注意处理边界
				p1++;
			}
			System.out.println(ans);
		}	
		static void f1(int[] a) throws IOException  {
			for(int i=0;i<n;i++)a[i]=nextInt();
			Arrays.sort(a);
		}
		static int nextInt() throws IOException {
			char c=(char)in.read();int x=0;
			while(c<=32)c=(char)in.read();
			while(c>='0'&&c<='9') {x=x*10+c-'0';c=(char)in.read();}
			return x;
		}	
  }
