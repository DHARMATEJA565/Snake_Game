import javax.swing.JFrame;

public class GameFrame2 extends JFrame {
	
	GameFrame2(){
	this.add(new Board2());
	this.setVisible(true);
	this.setTitle("MEDIUM");
	this.setSize(330,330);
	this.setLocationRelativeTo(null);
}
}