import javax.swing.*;
import java.awt.*;

public class window extends JFrame
{
	public window()
	{
		Field pan = new Field();
		Container con = getContentPane();
		con.add(pan);
		
		setTitle("Snake");
		setBounds(0, 0, 800, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		setVisible(true);
		
	}

}
