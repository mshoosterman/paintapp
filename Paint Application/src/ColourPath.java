import java.awt.Color;

public class ColourPath {
	// This class defines a parametric curve path through the 3d colour space
	// and then sets those coordinates as a rgb colour value, allowing a 
	// continuously changing rainbow effect. 
	
	private int t;
	private int x;
	private int y;
	private int z;
	private double pi;
	private double halfpi;
	
	public Color color;
	
	ColourPath(){
		t = 0;
		pi = Math.PI;
		halfpi = (double) Math.PI/2;
		x = (int) (127.5*Math.cos((double)t/64)+127.5);
		y = (int) (127.5*Math.cos((double)t/70+pi)+127.5);
		z = (int) (127.5*Math.cos((double)t/60+halfpi)+127.5);
		
		color = new Color(x,y,z);
		
	}
	
	public void increment() {
		t++;
		x = (int) (128*Math.cos((double)t/64)+128);
		y = (int) (128*Math.cos((double)t/70+pi)+128);
		z = (int) (128*Math.cos((double)t/60+halfpi)+128);
		color = new Color(x,y,z);
		
	}
	
	

}
