package model;

import javafx.scene.image.Image;
/**
 * This class provides the user controlled entity
 * 
 * @author Chase Booher
 */
public class Player extends Entity {
	private int lives;
	public Player(double x, double y, Image i) {
		super(x, y, i);
		lives=3;
	}
	public int getLives()
	{
		return lives;
	}
	public void setLives(int l)
	{
		lives=l;
	}
	public Boolean isAlive()
	{
		if(lives<1)
			return false;
		else
			return true;
	}
	public void act()
	{
		super.act();
		if(getHitWall())
		{
			lives--;
			setXCoord(getStartingX());
			setYCoord(getStartingY());
			setHitWall(false);
			
		}
	}

}
