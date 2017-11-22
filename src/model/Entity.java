//We Love Doggos Team
package model;
import javafx.scene.image.Image;
/**
 * This class provides the baseline for every entity in the game
 * and all classes in the model package should inherit it
 * 
 * @author Chase Booher
 */
public abstract class Entity {
	private int xCoordinate;
	private int yCoordinate;
	private Image image;
	
	public int getXCoord()
	{
		return xCoordinate;
	}
	public int getYCoord()
	{
		return yCoordinate;
	}
	public Image getImage()
	{
		return image;
	}
	public void setXCoord(int x)
	{
		xCoordinate=x;
	}
	public void setYCoord(int y)
	{
		yCoordinate=y;
	}
	public void setImage(Image i)
	{
		image=i;
	}
	//Every game loop an entity must perform its designated action
	abstract public void act();

}
