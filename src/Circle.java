import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;



public class Circle extends Shape{
	

	//constructor that sets some default values
	public Circle(){
		
	setStartX(400);
	setStartY(400);
	setChangeX(2);
	setChangeY(2);
	setWidth(40);
	setHeight(40);

		
	}//end circle
		
	//changes the direction of the shape depending on if it hits a wall or not 
	public void move(shapesPanel sp){
		
		
		
		if (this.getStartX() >= (sp.getWidth() - getWidth()))
			setChangeX(-2);
					
		if (this.getStartX() <= 0)
			setChangeX(2);
	
		
		if (this.getStartY() >= (sp.getHeight() - getHeight()))
			setChangeY(-2);
		
		if (this.getStartY() <= 0)
			setChangeY(2);
		
		setStartX((getStartX() + getChangeX()));
		setStartY((getStartY() + getChangeY()));
		
		
		
	}//end move
	
	

	//draws the actual shape and colors it
	@Override public void paintComponent(Graphics g, shapesPanel sp){
			
		super.paintComponent(g, sp);
		Graphics2D g2d = (Graphics2D) g;
		
		move(sp);
		g2d.setPaint(new GradientPaint(5,30,Color.RED,35,100,Color.YELLOW,true));
		g2d.fill(new Ellipse2D.Double(getStartX(),getStartY(),getWidth(),getHeight()));
				
		}

}//end class
