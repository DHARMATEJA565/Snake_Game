import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Snake_Game{

	public static void main(String[] args){

		Game obj = new Game();

	}
}

class Game extends JFrame implements ActionListener {

JLabel title, label1;

JButton easy,medium,hard;

public Game() {

		title = new JLabel("SNAKE GAME");
		title.setBounds(50,5,300,40);
		title.setForeground(Color.BLACK);
		title.setFont(new Font(Font.SERIF,Font.BOLD,28));
		title.setOpaque(false);
		add(title);

		label1 = new JLabel("Select your Level");
		label1.setBounds(60,60,160,25);
		label1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		label1.setForeground(Color.BLACK);
		add(label1);

		easy = new JButton("EASY");
		easy.setBounds(85,120,100,20);//x axis,y axis,width,height
		easy.setBackground(new Color(133,70,30));
		easy.setForeground(Color.WHITE);
		add(easy);

		medium = new JButton("MEDIUM");
		medium.setBounds(85,170,100,20); //x axis,yaxis,width,height
		medium.setBackground(new Color(133,70,30));
		medium.setForeground(Color.WHITE);
		add(medium);

		hard = new JButton("HARD");
		hard.setBounds(85,220,100,20);//x axis,yaxis,width,height
		hard.setBackground(new Color(133,70,30));
		hard.setForeground(Color.WHITE);
		add(hard);

		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);

		setSize(300,300);  //width and height 
		setLayout(null);
		setVisible(true);
		setTitle("SNAKE GAME");
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(196,164,132));

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==easy) {
			new GameFrame1();
			
				
		}
		if(ae.getSource()==medium) {
			new GameFrame2();
		}
		if(ae.getSource()==hard) {
			new GameFrame3();

	}

}
}