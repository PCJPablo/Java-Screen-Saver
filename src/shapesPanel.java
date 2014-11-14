import javax.swing.JPanel;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;





public class shapesPanel extends JPanel {


	private final int ANIMATION_DELAY = 30;
	Timer animationTimer = new Timer(ANIMATION_DELAY, new TimerHandler());

	private Shape shapeArray[] = new Shape[4];
	private int clicks = 1;
	private int newShape = 0;

	
	public shapesPanel() {
		
		
		
		setLayout(null);		
		animationTimer.start();
		
		shapeArray[0] = ((Shape) new Circle());
		shapeArray[1] = ((Shape) new Triangle());
		shapeArray[2] = ((Shape) new Square());		
		shapeArray[3] = ((Shape) new Star());
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				Random randomObj = new Random();
				int rand = randomObj.nextInt(4);
				
				Shape cloneArray[] = shapeArray.clone();
				shapeArray = new Shape[4 + clicks];
			
			
				for( int i = 0; i < cloneArray.length; i ++)
					shapeArray[i] = cloneArray[i];		
				
					switch (newShape){
					
					case 0: shapeArray[3 + clicks] = ((Shape) new Circle());
						break;
					case 1: shapeArray[3 + clicks] = ((Shape) new Triangle());
						break;
					case 2: shapeArray[3 + clicks] = ((Shape) new Square());
						break;
					case 3: shapeArray[3 + clicks] = ((Shape) new Star());
						break;
			
					
					}
					
					clicks ++;
					newShape ++;
					if (newShape == 4)
						newShape = 0;
					
				}
				
		
			
			
		});
		
		}
		
	
		
		
	
public void paintComponent(Graphics g){
		
		super.paintComponent(g);
	
		for (int i = 0; i < shapeArray.length; i ++){
			shapeArray[i].paintComponent(g, this);
			
		}
			
		}
		


	public void collison(){

		int circleX = shapeArray[0].getChangeX();
		int circleY = shapeArray[0].getChangeY();
		int triangleX = shapeArray[1].getChangeX();
		int triangleY = shapeArray[1].getChangeY();
		int squareX = shapeArray[2].getChangeX();
		int squareY = shapeArray[2].getChangeY();
		int starX = shapeArray[3].getChangeX();
		int starY = shapeArray[3].getChangeY();
		
		
		
		Rectangle2D.Double circle = new Rectangle2D.Double(shapeArray[0].getStartX(),shapeArray[0].getStartY(),
				shapeArray[0].getWidth(),shapeArray[0].getHeight());
		
		Rectangle2D.Double triangle = new Rectangle2D.Double(shapeArray[1].getStartX(),shapeArray[1].getStartY(),
				shapeArray[1].getWidth(),shapeArray[1].getHeight());
		
		Rectangle2D.Double square = new Rectangle2D.Double(shapeArray[2].getStartX(),shapeArray[2].getStartY(),
				shapeArray[2].getWidth(),shapeArray[2].getHeight());	

		Rectangle2D.Double star = new Rectangle2D.Double(shapeArray[3].getStartX(),shapeArray[3].getStartY(),
				shapeArray[3].getWidth(),shapeArray[3].getHeight());
		
		if (circle.intersects(square)){
			shapeArray[2].setChangeX(circleX);
			shapeArray[2].setChangeY(circleY);
			shapeArray[0].setChangeX(squareX);
			shapeArray[0].setChangeY(squareY);
		}
	
		if (circle.intersects(triangle)){
			shapeArray[1].setChangeX(circleX);
			shapeArray[1].setChangeY(circleY);
			shapeArray[0].setChangeX(triangleX);
			shapeArray[0].setChangeY(triangleY);
		}
		
		if (circle.intersects(star)){
			shapeArray[3].setChangeX(circleX);
			shapeArray[3].setChangeY(circleY);
			shapeArray[0].setChangeX(starX);
			shapeArray[0].setChangeY(starY);
		}
		
		if (square.intersects(triangle)){
			shapeArray[1].setChangeX(squareX);
			shapeArray[1].setChangeY(squareY);
			shapeArray[2].setChangeX(triangleX);
			shapeArray[2].setChangeY(triangleY);
		}
		
		if (square.intersects(star)){
			shapeArray[3].setChangeX(squareX);
			shapeArray[3].setChangeY(squareY);
			shapeArray[2].setChangeX(starX);
			shapeArray[2].setChangeY(starY);
		}
		
		if (triangle.intersects(star)){
			shapeArray[3].setChangeX(triangleX);
			shapeArray[3].setChangeY(triangleY);
			shapeArray[1].setChangeX(starX);
			shapeArray[1].setChangeY(starY);
		}
		
		
		
	}


	private class TimerHandler implements ActionListener{
	
		public void actionPerformed(ActionEvent actionEvent){
				
			
			repaint();
			collison();
		}
	
	}//end inner class TimerHandler


	
}


