
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PaintApp extends JFrame implements ActionListener{
	
	
	MyCanvas myCanvas;
	
	JMenuBar menuBar;
	
	JMenu settingsMenu;
	
	JMenuItem brushColour;
	JMenuItem enableRainbow;
	JMenuItem brushSize;
	JMenuItem clearItem;
	
	PaintApp(){
		
		myCanvas = new MyCanvas();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		
		settingsMenu = new JMenu("Settings");
		
		brushColour = new JMenuItem("Brush Colour");
		enableRainbow = new JMenuItem("Enable Rainbow");
		brushSize = new JMenuItem("Brush Size");
		clearItem = new JMenuItem("Clear Canvas");
		
		brushColour.addActionListener(this);
		enableRainbow.addActionListener(this);
		brushSize.addActionListener(this);
		clearItem.addActionListener(this);
		
		settingsMenu.add(brushColour);
		settingsMenu.add(enableRainbow);
		settingsMenu.add(brushSize);
		settingsMenu.add(clearItem);
		
		menuBar.add(settingsMenu);
		
		this.setJMenuBar(menuBar);
		this.add(myCanvas);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==brushColour) {
			
			Color colour = JColorChooser.showDialog(null, "Pick a Colour", Color.black);
			
			myCanvas.setColour(colour);
			
		}
		
		if(e.getSource()==brushSize) {
			new SetBrushSize(myCanvas);
			
		}
		
		if(e.getSource()==clearItem) {
			myCanvas.removeAll();
			myCanvas.repaint();
		}
		
		if(e.getSource()==enableRainbow) {
			myCanvas.enableTheRaindbow();
		}
		
	}

}
