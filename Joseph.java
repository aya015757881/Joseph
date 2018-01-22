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
			System.out.print("������Լɪ�򻷵�������N=");
			do N=cin.nextInt();
			while(negNum(N,'N'));
			System.out.print("������Լɪ�򻷵ĳ�Ȧ����,number=");
			do num=cin.nextInt();
			while(negNum(num,'n'));
			System.out.print("�������1���������˵ı��,k=");
			do k=cin.nextInt();
			while(outOfRange(k,N));
			System.out.println("�����Ȧ�е��˵ĺ�����"+joseph(N,num,k)+"\n\n");
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
			System.out.print("��ű���Ϊ�������Ҳ��ܴ�������������������\n\nk=");
			flag=true;
		}
		return flag;
	}
	
	public static boolean negNum(int val,char idx)
	{
		boolean flag=false;
		if(val<=0)
		{
			System.out.println("����������\n\n");
			if(idx=='N')
				System.out.print("N=");
			else
				System.out.print("num=");
			flag=true;
		}
		return flag;
	}
}

