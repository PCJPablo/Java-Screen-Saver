import java.awt.Graphics;



public abstract class  Shape {

	private double startX = 0;
	private double startY = 0;
	private double width;
	private double height;
	private int changeX;
	private int changeY;
	
	//lots of getters and setters
	public double getStartX() {
		return startX;
	}

	public void setStartX(double startX) {
		this.startX = startX;
	}

	public double getStartY() {
		return startY;
	}

	public void setStartY(double startY) {
		this.startY = startY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
	public int getChangeX() {
		return changeX;
	}

	public void setChangeX(int changeX) {
		this.changeX = changeX;
	}

	public int getChangeY() {
		return changeY;
	}

	public void setChangeY(int changeY) {
		this.changeY = changeY;
	}

	public void paintComponent(Graphics g, shapesPanel sp) {
		
		
	}
	
	public abstract void move (shapesPanel sp);
	
	
	
	
}
