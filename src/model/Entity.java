//We Love Doggos Team
package model;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
/**
 * This class provides the baseline for every entity in the game
 * and all classes in the model package should inherit it
 * 
 * @author Chase Booher
 */
public abstract class Entity {
	private double startingX;
	private double startingY;
	private double xCoordinate;
	private double yCoordinate;
	private double xVel;
	private double yVel;
	private Image image;
	private Boolean inAir;
	private Boolean hitWall;
	
	public Entity(double x, double y, Image i)
	{
		startingX=x;
		startingY=y;
		start();
		image=i;
	}
	public double getXCoord()
	{
		return xCoordinate;
	}
	public double getYCoord()
	{
		return yCoordinate;
	}
	public double getStartingX()
	{
		return startingX;
	}
	public double getStartingY()
	{
		return startingY;
	}
	public double getXVel()
	{
		return xVel;
	}
	public double getYVel()
	{
		return yVel;
	}
	public Image getImage()
	{
		return image;
	}
	public Boolean getAirStatus()
	{
		return inAir;
	}
	public Boolean getHitWall()
	{
		return hitWall;
	}
	public void setXCoord(double x)
	{
		xCoordinate=x;
	}
	public void setYCoord(double y)
	{
		yCoordinate=y;
	}
	public void setXVel(double x)
	{
		xVel=x;
	}
	public void setYVel(double y)
	{
		yVel=y;
	}
	public void setImage(Image i)
	{
		image=i;
	}
	public void setInAir(Boolean a)
	{
		inAir=a;
	}
	public void setHitWall(Boolean w)
	{
		hitWall=w;
	}
	//creates a rectangle boundary that will be used for collision checking
	public Rectangle2D getBoundary()
    {
        return new Rectangle2D(xCoordinate,yCoordinate,image.getWidth(),image.getHeight());
    }
	//checks whether an entity has collided with another entity
    public boolean collides(Entity e)
    {
        return e.getBoundary().intersects(getBoundary());
    }
	//Every game loop an entity must perform its designated action, by default just provides gravity and boundary checking
	public void act()
	{
		wallCheck();
		moveY();
		gravity();
		
	}
	public void jump(double y) {
		if(!inAir)
		{
			yVel=y;
			inAir=true;
		}
	}
	public void moveX() {
		xCoordinate=(xCoordinate+xVel);
	}
	public void moveY() {
		yCoordinate=(yCoordinate+yVel);
	}
	public void wallCheck() {
		if(xCoordinate<0)
		{
			xVel=0;
			xCoordinate=0;
			hitWall=true;
		}
		else if(xCoordinate>(1280-image.getWidth()))
		{
			xVel=0;
			xCoordinate=(1280-image.getWidth());
			hitWall=true;
		}
		else if(!hitWall)
		{
			moveX();
		}
		else
		{
			xCoordinate=(xCoordinate-xVel);
			xVel=0;
		}
	}
	public void gravity()
	{
		//as long as they are above the ground, keep decelerating
		if(yCoordinate<(720-image.getHeight()))
		{
			yVel=(yVel+1);
		}
		//they are below the ground fix it
		else if(yCoordinate>720-image.getHeight())
		{
			yCoordinate=startingY;
			yVel=0;
			inAir=false;
		}
		//they have hit the ground stop acceleration
		else
		{
			yVel=0;
			inAir=false;
		}
	}
	public void start()
	{
		xCoordinate=startingX;
		yCoordinate=startingY;
		xVel=0;
		yVel=0;
		inAir=false;
		hitWall=false;
	}
	public abstract void collided();

}
