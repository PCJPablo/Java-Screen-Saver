import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;



public class Triangle extends Shape{
	
	private int xPoints[]= {0, 50, 100};
	private int yPoints[] = {350, 400, 350};

	//constructor that sets some default values
	public Triangle(){
		
		setStartX(0);
		setStartY(350);
		setChangeX(5);
		setChangeY(5);
		setWidth(100);
		setHeight(50);
		
	}
	
	//changes the direction of the shape depending on if it hits a wall or not 
	public void move(shapesPanel sp){
				
		if (this.xPoints[1] >= (sp.getWidth() - getWidth()))
			setChangeX(-5);

		if (this.xPoints[0] <= 0)
			setChangeX(5);
	
		
		if (this.yPoints[1] >= (sp.getHeight()))
			setChangeY(-5);
		if (this.yPoints[0] <= 0)
			setChangeY(5);
		
		xPoints[0] += getChangeX();
		setStartX((getStartX() + getChangeX()));
		xPoints[1] += getChangeX();
		xPoints[2] += getChangeX();
		
		
		yPoints[0] += getChangeY();
		setStartY((getStartY() + getChangeY()));
		yPoints[1] += getChangeY();
		yPoints[2] += getChangeY();
		
	}//end move

	//draws the actual shape and colors it
	@Override public void paintComponent(Graphics g, shapesPanel sp){
				
		super.paintComponent(g, sp);
		Graphics2D g2d = (Graphics2D) g;		
			
		move(sp);
		
		g2d.setPaint(new GradientPaint(5,30,Color.RED,35,100,Color.YELLOW,true));
		g2d.fillPolygon(xPoints, yPoints, 3);
		
		
		}
	
	
}
