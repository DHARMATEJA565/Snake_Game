import javax.swing.JFrame;

public class GameFrame3 extends JFrame {
	GameFrame3(){
	this.add(new Board3());
	this.setVisible(true);
	this.setTitle("HARD");
	this.setSize(330,330);
	this.setLocationRelativeTo(null);
}
}