import JGJAR.libraries.MyMath.*;

public class game 
{
	public int[][] mas;
	public int vect;
	public int newVect;
	private int length;
	private int gX, gY;
	public long record;
	public boolean gameOver = false;
	public boolean SUPER_HARDCORE = false;
	
	public game()
	{
		mas= new int[30][30];
		
	}
	private void rotate()
	{
		if(Math.abs((newVect-vect))!=2)
		{
			vect=newVect;
		
		}
		
	}
	private void makeNew()
	{
		while(true)
		{
			int x = (int) MyMath.random(0, 30);
			int y = (int) MyMath.random(0, 30);
			
			if(mas[y][x]==0)
			{
				mas[y][x]=-1;
				break;
				
			}
			
		}
		
	}
	public void start()
	{
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<30;j++)
			{
				mas[i][j]=0;
				
			}
			
		}
		mas[14][14]=1;
		mas[14][15]=2;
		mas[14][16]=3;
		gX=gY=14;
		length=3;
		gameOver=false;
		
		vect = /*(int) MyMath.random(0, 3)*/0;
		record = 0;
		
		makeNew();
		
	}
	public int moveHead()
	{
		//mas[gY][gX]=0;
		//to Left
		if(vect==0)
		{
			if((gX-1)>=0)
			{
				gX--;
				
			}
			else
			{
				gX=29;
				
			}
			
		}
		//to top
		else if(vect==1)
		{
			if((gY-1)>=0)
			{
				gY--;
				
			}
			else
			{
				gY=29;
				
			}
			
		}
		//to right
		else if(vect==2)
		{
			if((gX+1)<=29)
			{
				gX++;
				
			}
			else gX=0;
			
		}
		//to bottom
		if(vect==3)
		{
			if((gY+1)<=29)
			{
				gY++;
				
			}
			else
			{
				gY=0;
				
			}
			
		}
		
		int res = 0;
		
		if(mas[gY][gX]==-1)
		{
			//makeNew();
			//record+=MyMath.random(0, MyMath.max_value);
			res = 1;
			
		}
		else if(mas[gY][gX]==0) res = 2;
		else if(mas[gY][gX]>0) res = 3;
		mas[gY][gX]=-2;
		return res;
		
	}
	public void move()
	{
		int flag = moveHead();
		if(flag==3) gameOver = true;
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<30;j++)
			{
				if(mas[i][j]>0) mas[i][j]++;
				else if(mas[i][j]==-2) mas[i][j]=1;
				if(flag!=1)
				{
					if(mas[i][j]==(length+1)) mas[i][j]=0;
					
				}
				
			}
			
		}
		if(flag==1)
		{
			length++;
			makeNew();
			record++;
			
		}
		rotate();
		
		
	}

}
