package w.x.y;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int step = 1;
	static int[] xx=new int[] {-1,-1,-2,-2,1,1,2,2};
	static int[] yy=new int[] {-2,2,-1,1,-2,2,-1,1};
	static int [][]chess=new int[8][8];
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//��ʼ��Graph����
		
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
			{
				Pointer p=new Pointer();
				p.x=i;
				p.y=j;
				Graph.graph[i][j]=p;
			}
		
		Pointer [] path=new Pointer[64];//����·��
        int x,y;

		Scanner sc = new Scanner(System.in); 
        System.out.println("������x����(1-8)�����س�����");
        x=sc.nextInt();
        System.out.println("������y����(1-8)�����س�����");
        y=sc.nextInt();
        System.out.println("��ȴ�����");
		int NUm_Of_City_Be_Travelled=0;//�������ӵĸ���
		Deep_First_Search(Graph.graph,Graph.graph[x-1][y-1],path,NUm_Of_City_Be_Travelled);
		
		
		
	
		
		
        
	}
	public static void Deep_First_Search(Pointer[][] g,Pointer p,Pointer[]path,int NUm_Of_City_Be_Travelled)
	{
		
		if(p.x<0||p.y<0||p.x>7||p.y>7||g[p.x][p.y].flag==false)
		{
			return;
		}
		path[NUm_Of_City_Be_Travelled++]=p;
		g[p.x][p.y].flag=false;
		if(NUm_Of_City_Be_Travelled>63)
		{
			int x=0;
			for(int i=0;i<64;i++)
			{
				System.out.print((path[i].x+1)+" "+(1+path[i].y)+"->");
				x++;
				if(x%8==0)
				{
					System.out.println();
				}
			}
				System.exit(0);
		}
		
		g[p.x][p.y].Set_The_Next(g);
		//g[p.x][p.y].sort(g);
		
		for(int i=0;i<p.p.size();i++)
		{
			Deep_First_Search(g,p.p.get(i),path,NUm_Of_City_Be_Travelled);
		}
		g[p.x][p.y].flag=true;
		NUm_Of_City_Be_Travelled--;
		g[p.x][p.y].p=new  ArrayList<>();
		
	}
	
	
}

