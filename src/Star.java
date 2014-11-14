import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.Random;


public class Star extends Shape{
	
	private int xPoints[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
    private int yPoints[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
	private int angle = 5;
    
	//constructor that sets some default values
	public Star(){
		
		setWidth((xPoints[2] - xPoints [8]));
		setHeight(yPoints[4]);
		setStartX(200);
		setStartY(100);
		setChangeX(5);
		setChangeY(5);
		
	}
	
	//changes the direction of the shape depending on if it hits a wall or not 
	public void move(shapesPanel sp){	
		
		if (this.getStartX() >= (sp.getWidth() - getWidth()))
			setChangeX(-5);
		if (this.getStartX() <= 0)
			setChangeX(5);
	
		
		if (this.getStartY() >= (sp.getHeight() - getHeight()))
			setChangeY(-5);
		if (this.getStartY() <= 0)
			setChangeY(5);
		
		setStartX((getStartX() + getChangeX()));
		setStartY((getStartY() + getChangeY()));
		
		
	}//end move

	
	
	//draws the actual shape and colors it
	@Override public void paintComponent(Graphics g, shapesPanel sp){
		
		Random randomObj = new Random();
		
        Graphics2D g2d = ( Graphics2D ) g;
        AffineTransform keep = g2d.getTransform(); 
        g2d.rotate(Math.toRadians(angle), getStartX() + (getWidth()/2), getStartY() + (getHeight()/2));
        GeneralPath star = new GeneralPath();
        star.moveTo( xPoints[0], yPoints[0 ] );
        
        for ( int k = 1; k < xPoints.length; k++ )
            star.lineTo( xPoints[k], yPoints[k] );
        star.closePath();        
        
        g2d.translate( getStartX(), getStartY() ); 
        for ( int j = 1; j <= 20; j++ ) {
            
            g2d.setColor( new Color( randomObj.nextInt( 256 ), 
                                     randomObj.nextInt( 256 ), 
                                     randomObj.nextInt( 256 ) ) ); 
            g2d.fill( star );
		
		}
        
        g2d.setTransform(keep);
        move(sp);
        angle += 5;
	}
}