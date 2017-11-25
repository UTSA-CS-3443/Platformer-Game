package model;

import javafx.scene.image.Image;

/**
 * An entity that can turn around
 * 
 * @author Chase Booher
 */
public class TurnAround extends Entity{
	private int movementDir;
	public TurnAround(double x, double y, Image i)
	{
		super(x,y,i);
		movementDir=-1;
	}
	
	public void act()
	{
		if(movementDir==-1)
			setXVel(-5);
		else
			setXVel(5);
		super.act();
		if(getHitWall()&&movementDir==-1)
			movementDir=1;
		else if(getHitWall()&&movementDir==1)
			movementDir=-1;
			
	}

}