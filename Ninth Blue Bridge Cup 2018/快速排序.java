/*
以下代码可以从数组a[]中找出第k小的元素。  
它使用了类似快速排序中的分治算法，期望时间复杂度是O(N)的。
*/


import java.util.Random;
public class 快速排序{
	public static int quickSelect(int a[], int l, int r, int k) { //l=0,r=5,k=4 其中i=l为起始位置下标,j=r为终止位置下标
		Random rand = new Random(); //取一个0-1的随机数rand
		int p = rand.nextInt(r - l + 1) + l;//[l,r+1)取一个随机值即从[0,6)中取一个值，a[]共6个元素
		//public int nextInt(int n)该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
		int x = a[p];//x的值随机数为a[p]的值,x为随即赋的比较值
		int tmp = a[p]; //tmp为中间变量
		a[p] = a[r]; //
		a[r] = tmp;
		int i = l, j = r;
		while(i < j) { //快速排序,从表的两端交替向中间扫描 i为起始点下标，j为终止点下标
                	while(i < j && a[i] < x) //x为随机的比较值,最后i==j 或者 a[i]>=x
                		i++;   //i=i+1继续向后继续比较
                	if(i < j) {//即a[i]大于等于随机数x,不满足while循环
                        	a[j] = a[i]; //选一个比x大的数放到高位 
                        	j--; //相应的j位置的下标由终止位置前移一个单位
                	}
                	while(i < j && a[j] > x)// 最后j==i 或者 a[i]<=x
                		j--; //再从后向前搜索(依次轮替,从前往后从后往前)
                	if(i < j) { //即a[i]<=随机数x
                        	a[i] = a[j];//选一个比x小的数放到低位
                        	i++;//相应的i位置的下标由起始位置后移一个单位
                	}
        	}
        	a[i] = x;//支点pivot记录到位,即最初的赋值比较对象
        	p = i;//这里改了p的值 说明会用到p 
        	if(i - l + 1 == k) //支点的下标位置-起始坐标位置+1=k时即支点下标为3时即a[3]为第四小的元素
        		return a[i];
        	if(i - l + 1 < k)  //若支点的下标位置-起始坐标位置+1<k,则
        		return quickSelect(a,i + 1,r,k-i+l-1); //填空
                /* Other Anser:a, p+1, r, k-(i-l+1)
                 * 这里的p就等于i的值,或者写为r+1
                 * 第二个参数我们要找的是区间端点，p+1就是右区间不包括下标为p的数的下标，
                 * 第四个参数k-(i-l+1) 就是还需要找多少个，是原始数组中第k大的。如果p不加1，那么第四个参数应该要算上下标为p的这个数，
                 * 在新一轮递归中找到第k-(i-l+1)+1大的数,也就等于k-i+l。*/
        	else return quickSelect(a, l, i - 1, k);	
	}
	public static void main(String args[]) {
		int [] a = {1, 4, 2, 8, 5, 7};
		System.out.println(quickSelect(a, 0, 5, 4));
	}
}


/*Interpretation:
 回到快速排序的各个指针的变化：
l~i区间内都是比枢纽小的,一共i-l+1个元素；
i+1~r都是比枢纽大的
如果i-l+1比k大,说明要在l~i-1中找;还是找第k个元素(l=0)
如果i-l+1比k小,说明要在i+1~r某个值中找,这个值是多少呢？
要看还需要找到新一轮递归中找第多少小的元素,这里新参数k就等于原k减去当前一轮的l~i的个数 即k-(i-l+1)
 */
