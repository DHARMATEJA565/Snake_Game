import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Board3 extends JPanel implements ActionListener {
 static final int WIDTH = 330;
 static final int HEIGHT = 330;
 static final int DOT_SIZE = 10;
 static final int GAME_UNITS = (WIDTH*(HEIGHT))/DOT_SIZE;
 static final int DELAY = 140;
 final int X[]= new int[GAME_UNITS];
 final int Y[]=new int[GAME_UNITS];
 int dots = 3;
 int score;
 int appleX;
 int appleY;
 char direction = 'R';
 boolean running = false;
 Timer timer;
 Random random;

 Board3(){
 random = new Random();
 this.setSize(330,330);
 this.setBackground(Color.black);
 this.setFocusable(true);
 this.addKeyListener(new MyKeyAdapter());
 startGame();
 }
 public void startGame () {
 newApple();
 running=true;
 timer= new Timer(DELAY,this);
 timer.start();
 }
 public void paintComponent (Graphics g) {
 super.paintComponent(g);
 draw(g);
 }
 public void draw(Graphics g){
 if(running){
 
 //draw the food on the screen on a random place
 g.setColor(Color.green);
 g.fillOval(appleX,appleY,DOT_SIZE,DOT_SIZE);
 //draw the head and the body of the snake
 for(int i =0;i<dots;i++){
 if(i==0){
 g.setColor(Color.red); //for the head
 }else {
 g.setColor(Color.green); //for the body

 }
 g.fillOval(X[i],Y[i],DOT_SIZE,DOT_SIZE);
 //score

 }
 }else {
 gameOver(g);
 }

 }
 public void newApple(){
 appleX = random.nextInt((int) (WIDTH/DOT_SIZE-10))*DOT_SIZE ;
 appleY = random.nextInt((int) (HEIGHT/DOT_SIZE-10))*DOT_SIZE;
 }
 public void move(){
 for(int i = dots;i>0;i--){
 X[i] = X[i-1];
 Y[i]=Y[i-1];

 }
 switch (direction){
 case 'U':
 Y[0]=Y[0]-DOT_SIZE;
 break;
 case 'D':
 Y[0]=Y[0]+DOT_SIZE;
 break;
 case 'L':
 X[0]=X[0]-DOT_SIZE;
 break;
 case 'R':
 X[0]=X[0]+DOT_SIZE;
 break;
 }
 }
 public void checkApple(){
 if((X[0] == appleX) && (Y[0] == appleY)){
 dots++;
 score++;
 newApple();
 }
 }
 public void checkCollision(){
 //checks if head collide the body
 for(int i = dots;i>0;i--){
 if((X[0]== X[i]) && (Y[0]== Y[i])){
 running = false;
 }
 }
//check if head touches left border
if(X[0] < 0){
running = false;
}
//checks if head touches right border
if(X[0] >WIDTH-30){
running = false;
}
//checks if head touched top border
if(Y[0] < 0){
running = false;
}
//checks if head touched bottom border
if(Y[0] > HEIGHT-40){
running = false;
}
if(!running){
timer.stop();
}
}



 public void gameOver(Graphics g){
 //score
 g.setColor(Color.red);
 g.setFont( new Font("Helvetica",Font.BOLD, 35));
 g.drawString("Score: "+score,70,40);
 //Game over text
 g.setColor(Color.red);
 g.setFont(new Font("Helvetica",Font.BOLD,35));
 g.drawString("Game Over",60,145);
 }
 @Override
 public void actionPerformed(ActionEvent e) {
 if(running){
 move();
 checkApple();
 checkCollision();
 }
 repaint();
 }
 public class MyKeyAdapter extends KeyAdapter{
 @Override
 public void keyPressed(KeyEvent e){
 switch (e.getKeyCode()){
 case KeyEvent.VK_LEFT:
 if(direction != 'R'){
 direction = 'L';
 }
 break;
 case KeyEvent.VK_RIGHT:
 if(direction != 'L'){
 direction = 'R';
 }
 break;
 case KeyEvent.VK_UP:
 if(direction != 'D'){
 direction = 'U';
 }
 break;
 case KeyEvent.VK_DOWN:
 if(direction != 'U'){
 direction = 'D';
 }
 break;
 }
 }
 }
}