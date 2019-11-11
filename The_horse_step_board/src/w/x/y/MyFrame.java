package w.x.y;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;



public class MyFrame extends JFrame {
	static int step = 1;
	static int[] xx=new int[] {-1,-1,-2,-2,1,1,2,2};
	static int[] yy=new int[] {-2,2,-1,1,-2,2,-1,1};
	static int [][]chess=new int[8][8];
    static Integer t1,t2;
public static void main(String[] args) {
	JFrame f=new JFrame("马踏棋盘");
	f.setBounds(600, 300,400,300);
	f.setVisible(true);
	 GridBagLayout layout=new GridBagLayout();
	f.setLayout(layout);
    JButton b=new JButton("开始");
    TextField tf=new TextField(20);
    TextField tf1=new TextField(20);
    Label lx=new Label("请输入x坐标(1-8)");
    Label ly=new Label("请输入y坐标(1-8)");
    b.setToolTipText("press me");//设置鼠标移动到该button的提示信息
    GridBagConstraints constraints =new  GridBagConstraints();
    //下面这些玩意都是用来设置窗口的
    constraints.gridx=1;
    constraints.gridy=0;
    constraints.gridheight=1;
    constraints.gridwidth=1;
    layout.setConstraints(lx, constraints);
    f.add(lx);
    
    constraints.gridx=1;
    constraints.gridy=1;
    constraints.gridheight=1;
    constraints.gridwidth=1;
    layout.setConstraints(tf, constraints);
    f.add(tf);
    
    constraints.gridx=1;
    constraints.gridy=2;
    constraints.gridheight=1;
    constraints.gridwidth=1;
    layout.setConstraints(ly, constraints);
    f.add(ly);
    
    constraints.gridx=1;
    constraints.gridy=3;
    constraints.gridheight=1;
    constraints.gridwidth=1;
    layout.setConstraints(tf1, constraints);
    f.add(tf1);
 
    constraints.gridx=1;
    constraints.gridy=4;
    constraints.gridheight=1;
    constraints.gridwidth=1;
    layout.setConstraints(b, constraints);
    f.add(b);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//当用户单击JFrame窗体的关闭图标时，将结束程序
   
    f.setVisible(true);//设置窗口可见
    
     b.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			t1=Integer.valueOf(tf.getText().trim());
			t2=Integer.valueOf(tf1.getText().trim());
			for(int i=0;i<8;i++)
				for(int j=0;j<8;j++)
				{
					Pointer p=new Pointer();
					p.x=i;
					p.y=j;
					Graph.graph[i][j]=p;
				}
			//int x,y;
			Pointer [] path=new Pointer[64];//遍历路径
			
			//Scanner sc = new Scanner(System.in); 
	       // System.out.println("请输入x坐标(1-8)，按回车结束");
	        //x=sc.nextInt();
	        //System.out.println("请输入y坐标(1-8)，按回车结束");
	        //y=sc.nextInt();
	        //System.out.println("请等待……");
	        
			int NUm_Of_City_Be_Travelled=0;//遍历格子的个数
			Deep_First_Search(Graph.graph,Graph.graph[t1-1][t2-1],path,NUm_Of_City_Be_Travelled);
			
		}
	});

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
		Draw2D d=new Draw2D();
		Graphics g1=d.getGraphics();
		try {
			d.paint(g1,path);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			System.exit(0);
	}
	
	g[p.x][p.y].Set_The_Next(g);
	
	for(int i=0;i<p.p.size();i++)
	{
		Deep_First_Search(g,p.p.get(i),path,NUm_Of_City_Be_Travelled);
	}
	g[p.x][p.y].flag=true;
	g[p.x][p.y].p=new  ArrayList<>();
	
}


}
