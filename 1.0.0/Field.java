import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

@SuppressWarnings("serial")
public class Field extends JPanel
{
	private Field pan;
	private game myGame;
	private Timer tmDraw, tmUpd;
	private Image bg, body, head, food, go;
	private JLabel record;
	private JButton btn1, btn2;
	
	private class myKey implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) 
		{
			int key = arg0.getKeyCode();
			if(key == KeyEvent.VK_LEFT)
			{
				myGame.newVect=0;
				
			}
			else if(key == KeyEvent.VK_D)
			{
				myGame.newVect=2;
				
			}
			else if(key == KeyEvent.VK_W)
			{
				myGame.newVect=1;
				
			}
			else if(key == KeyEvent.VK_S)
			{
				myGame.newVect=3;
				
			}
			else if(key == KeyEvent.VK_A)
			{
				myGame.newVect=0;
				
			}
			else if(key == KeyEvent.VK_RIGHT)
			{
				myGame.newVect=2;
				
			}
			else if(key == KeyEvent.VK_UP)
			{
				myGame.newVect=1;
				
			}
			else if(key == KeyEvent.VK_DOWN)
			{
				myGame.newVect=3;
				
			}
			
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
		
		
	}
	
	public Field()
	{
		pan = this;
		this.addKeyListener(new myKey());
		this.setFocusable(true);
		try
		{
			bg = ImageIO.read(new File("fon.png"));
			body = ImageIO.read(new File("telo.png"));
			head = ImageIO.read(new File("golova.png"));
			food = ImageIO.read(new File("ob.png"));
			go = ImageIO.read(new File("endg.png"));
			
		}
		catch(IOException exp)
		{JOptionPane.showMessageDialog(null, exp+"\nТы дебил, короче, игру сломал");
			
		}
		
		myGame = new game();
		myGame.start();
		
		setLayout(null);
		
		record = new JLabel("Record: 0");
		record.setForeground(Color.YELLOW);
		record.setFont(new Font("comic sans",0,30));
		record.setBounds(630,200,150,150);
		add(record);
		
		btn1 = new JButton("New Game");
		btn1.setForeground(Color.YELLOW);
		btn1.setFont(new Font("comic sans",0,20));
		btn1.setBounds(630,30,150,50);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				myGame.start();
				
				btn1.setFocusable(false);
				btn2.setFocusable(false);
				pan.setFocusable(true);
				
			}
		});
		add(btn1);
		
		btn2 = new JButton("Exit");
		btn2.setForeground(Color.YELLOW);
		btn2.setFont(new Font("comic sans",0,30));
		btn2.setBounds(630,100,150,50);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
				
			}
		});
		add(btn2);
		tmDraw = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				repaint();
				
			}
		});
		tmDraw.start();
		
		tmUpd = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(!myGame.gameOver)
				{
					myGame.move();
					record.setText("Счёт: "+myGame.record);
					
				}
				
				
			}
		});
		tmUpd.start();
		
	}
	public void paintComponent(Graphics gr)
	{
		super.paintComponent(gr);
		
		gr.drawImage(bg, 0, 0, 800, 650, null);
		
		for(int i = 0; i<30; i++)
		{
			for(int j = 0; j<30; j++)
			{
				if(myGame.mas[i][j]!=0)
				{
					if(myGame.mas[i][j]==1)
					{
						gr.drawImage(head, 10+j*20, 10+i*20, 20, 20, null);
						
					}
					else if(myGame.mas[i][j]==-1)
					{
						gr.drawImage(food, 10+j*20, 10+i*20, 20, 20, null);
						
					}
					else if(myGame.mas[i][j]>1)
					{
						gr.drawImage(body, 10+j*20, 10+i*20, 20, 20, null);
						
					}
					if(myGame.gameOver)
					{
						gr.drawImage(go, 250, 200, 200, 100, null);
						
					}
					
				}
				
			}
			
		}
		gr.setColor(Color.CYAN);
		for(int i=0;i<=30;i++)
		{
			gr.drawLine(10+i*20, 10, 10+i*20, 610);
			gr.drawLine(10, 10+i*20, 610, 10+i*20);
			
		}
		
	}
	
}
