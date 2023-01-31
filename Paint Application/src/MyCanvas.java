import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MyCanvas extends JPanel{
	
	Point brushStart = new Point();
	Point brushEnd = new Point();
	
	Color brushColour;
	private boolean enableRainbow; 
	int squaresize;
	
	ColourPath myPath;
	
	
	MyCanvas(){
		this.setPreferredSize(new Dimension(1000,1000));
		
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		this.addMouseListener(clickListener);
		this.addMouseMotionListener(dragListener);
		
		enableRainbow = false;
		
		brushColour = new Color(0,0,0);
		squaresize = 5;
		
		myPath = new ColourPath();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g); //no idea what this does or why it is necessary
		
		Graphics2D g2D = (Graphics2D) g;
		
		if(enableRainbow) {
			g2D.setPaint(myPath.color);
		}
		else {
			g2D.setPaint(brushColour);
		}
		g2D.setStroke(new BasicStroke(1000));
		g2D.drawLine((int)brushStart.getX(), (int)brushStart.getY(), (int)brushEnd.getX(), (int)brushEnd.getY());
		
	}
	
	public void setColour(Color color) {
		brushColour = color;
		enableRainbow = false;
	}
	
	public void enableTheRaindbow() {
		enableRainbow = true;
	}
	
	public void setBrushSize(int size) {
		squaresize = size;
		
	}
	
	
	private class ClickListener extends MouseAdapter{
		
		public void mousePressed(MouseEvent e) {
			brushStart = e.getPoint();
			brushEnd = e.getPoint();
			repaint(e.getX(),e.getY(),squaresize,squaresize);
		}
		
	}
	
	private class DragListener extends MouseMotionAdapter{
		
		public void mouseDragged(MouseEvent e) {
			
			brushStart = brushEnd;
			brushEnd = e.getPoint();
			repaint(e.getX(),e.getY(),squaresize,squaresize);
			
			if(enableRainbow) {
				myPath.increment();
			}
		}
		
	}
	
	
	

}
