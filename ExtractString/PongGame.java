import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class PongGame extends JComponent implements ActionListener , MouseMotionListener {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PongGame game = new PongGame();
		JFrame window = new JFrame("Pong Game");
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//window.setDefaultCloseOperation()
		window.setVisible(true);
		window.setSize(600,450);
		Timer t = new Timer(100,game);
		t.start();
		window.addMouseMotionListener(game);
	}

	private int ballx=250;
	private int bally=180;
	private int paddlex=0;
	private int ballXSpeed = 5;
	private int ballYSpeed=7;
	private int points=0;

	@Override
	protected void paintComponent(Graphics g) {
		//draw the sky
		g.setColor(new Color(178,223,224));
		g.fillRect(0, 0, 600, 450);
		
		//draw the paddle
		g.setColor(new Color(110,61,23));
		g.fillRect(paddlex, 350, 100, 10);
		
		//draw the ball
		g.setColor(Color.magenta);
		g.fillOval(ballx,0, 25, 25);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ballx = ballx+ballXSpeed;
		bally = bally+ballYSpeed;
		if(ballx >= paddlex && ballx  <= paddlex + 100 && bally >= 350-25)
			ballYSpeed =  -7;
			points += 5;
		if(ballx >= 600-25)
			ballXSpeed =  -5;
		if(ballx <= 0)
			ballXSpeed = 5;
		if(bally <= 0)
			ballYSpeed =  7;
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		paddlex = e.getX()-50;
		repaint();
	}
}