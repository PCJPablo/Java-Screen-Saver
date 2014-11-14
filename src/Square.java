import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public class Square extends Shape{

	private int sizeChange = 1;
	
	//constructor that sets some default values
	public Square(){
		
		setWidth(40);
		setHeight(40);	
		
	}
	
	//changes the direction of the shape depending on if it hits a wall or not 
	//also changes the size of the shape
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
		
		if (getWidth() == 40){
			
			sizeChange = 1;
			
		}
		if (getWidth() == 150){
			
			sizeChange = (-1);
			
		}
		
		setWidth((getWidth() + sizeChange));
		setHeight((getHeight() + sizeChange));
		
	}//end move
		
	//draws the actual shape and colors it
	@Override public void paintComponent(Graphics g, shapesPanel sp){
				
		super.paintComponent(g, sp);
		Graphics2D g2d = (Graphics2D) g;
		
		move(sp);
		
		g2d.setPaint(Color.RED);
		g2d.fill(new Rectangle2D.Double(getStartX(),getStartY(),getWidth(),getHeight()));
		
		
		}
	
}
