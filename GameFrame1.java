import javax.swing.*;

public class GameFrame1 extends JFrame {
	GameFrame1(){
	this.add(new Board1());
	this.setVisible(true);
	this.setTitle("EASY");
	this.setSize(330,330);
	this.setLocationRelativeTo(null);
}
}