package model;

import javafx.scene.image.Image;
/**
 * This class provides the user controlled entity
 * 
 * @author Chase Booher
 */
public class Player extends Entity {
	private int lives;
	private Boolean died;
	public Player(double x, double y, Image i) {
		super(x, y, i);
		died=false;
		lives=1;
	}
	public int getLives()
	{
		return lives;
	}
	public void setLives(int l)
	{
		lives=l;
	}
	public Boolean getDeath()
	{
		return died;
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
	}
	public void start() {
		super.start();
		died=false;
	}
	public void collided() {
		died=true;
		lives--;
	}
	

}
