package w.x.y;


import java.util.ArrayList;

public class Pointer {
int x;
int y;
ArrayList<Pointer> p=new ArrayList<>();
boolean flag=true;


public Pointer() {
	
}
public Pointer(int xx,int yy)
{
	x=xx;
	y=yy;
}

public  static boolean If_This_Point_Can_Be_Use(int xx,int yy,Pointer[][] g)
{
	if(xx<0||xx>7||yy<0||yy>7) {
		return false;
	}
    if(g[xx][yy].flag==true)
    	return true;

    return false;
        
}

public void Set_The_Next(Pointer[][] g)
{
	
	int[] xx=new int[] {-1,-1,-2,-2,1,1,2,2};
	int[] yy=new int[] {-2,2,-1,1,-2,2,-1,1};
	int x,y;
	for(int i=0;i<8;i++)
	{
		x=this.x+xx[i];
		y=this.y+yy[i];
		if(If_This_Point_Can_Be_Use(x,y,g))
		{   
			this.p.add(g[x][y]);
		}
	}
}
public void sort(Pointer[][]g)
{
	 Pointer p;
	for(int i=0;i<this.p.size();i++)
	{
		p=this.p.get(i);
		p.Set_The_Next(g);
		this.p.set(i, p);
	}
	this.p.stream().sorted((a,b)->a.p.size()-b.p.size());
	for(int i=0;i<this.p.size();i++)
	{
		p=this.p.get(i);
		p.p=new ArrayList<>();
		this.p.set(i, p);
	}
}


}
