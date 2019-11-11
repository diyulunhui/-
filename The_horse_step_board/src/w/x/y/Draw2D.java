package w.x.y;








   import java.awt.Color;
   import java.awt.Graphics;
   import java.awt.Point;
   import javax.swing.JFrame;


   @SuppressWarnings("serial")
   public class Draw2D extends JFrame {
   public Draw2D()
   {
   setSize(700,700);
   setLocation(new Point(400, 150));
   setVisible(true);
   setResizable(false);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

	
	public void paint(Graphics g,Pointer []path) throws InterruptedException
	{
	       super.paintComponents(g);
		   int width = getWidth(); // total width   
		   int height = getHeight(); // total height
		   int rRed=0;
		   int rGreen=0;
		   int rBlue=0;
		   int offset = 10;  //10*10的表格，每个单元格边长10个像素，60为表格整体偏移量

		   //Color of arc, below color is called "Taibao Lan"
		   rRed = 21;
		   rGreen = 101;
		   rBlue = 192;
		   Color color=Color.black;
		   
		   
		   //绘制1个8*8的表格
		   int p=0;
		   for (int i=0;i<8;i++)
		   {
			   for (int j=0;j<8;j++)
			   {
			   g.setColor(color);
			   //g.drawRect(150+(j+1)*30+offset, 70+(i+1)*30+offset, 30, 30);
			   if(p++%2==0)
			   {
				   g.setColor(Color.black);
			   }
			   else
			   {
				   g.setColor(Color.white);
			   }
			   g.fillRect((j+1)*70+offset, (i+1)*70+offset, 70, 70);
			   } 
			   p+=1;
		   }	   
		 
         for(int i=0;i<64;i++)
         {
        	 // g.setColor(Color.lightGray);
          //g.fillRect(150+(path[i].x+1)*30+offset,70+(path[i].y+1)*30+offset,30, 30);
              g.setColor(Color.red);
              g.drawString(String.valueOf(i+1), 30+(path[i].x+1)*70+offset, 50+(path[i].y+1)*70);
        	  Thread.sleep(800);
          }
	}

public static  void main(String[] args) {
	Draw2D d=new Draw2D();
	Graphics g=d.getGraphics();
	d.paint(g);
}

	
}
	
		

