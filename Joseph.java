package aya;

import java.util.Scanner;

public class Joseph
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int N,num,k;
		while(true)
		{
			System.out.print("请输入约瑟夫环的人数，N=");
			do N=cin.nextInt();
			while(negNum(N,'N'));
			System.out.print("请输入约瑟夫环的出圈数字,number=");
			do num=cin.nextInt();
			while(negNum(num,'n'));
			System.out.print("请输入第1个报数的人的编号,k=");
			do k=cin.nextInt();
			while(outOfRange(k,N));
			System.out.println("最后还在圈中的人的号码是"+joseph(N,num,k)+"\n\n");
		}
	}
	
	public static int joseph(int N,int num,int k)
	{
		int numberOfPersonInLoop=N;
		boolean[] loop=new boolean[N];
		for(int i=k-1,count=0;;i=i==N-1?0:i+1)
		{
			if(loop[i])
				continue;
			if(numberOfPersonInLoop==1)
				return i+1;
			count++;
			if(count<num)
				continue;
			else
			{
				loop[i]=true;
				count=0;
				numberOfPersonInLoop--;
			}
		}
	}
	
	public static boolean outOfRange(int k,int N)
	{
		boolean flag=false;
		if(k>N||k<1)
		{
			System.out.print("编号必须为正数并且不能大于人数，请重新输入\n\nk=");
			flag=true;
		}
		return flag;
	}
	
	public static boolean negNum(int val,char idx)
	{
		boolean flag=false;
		if(val<=0)
		{
			System.out.println("请输入正数\n\n");
			if(idx=='N')
				System.out.print("N=");
			else
				System.out.print("num=");
			flag=true;
		}
		return flag;
	}
}

