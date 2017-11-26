//We Love Doggos Team
package view;

import javafx.stage.Stage;
import model.*;
import javafx.scene.Scene;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * This is the view for the main game
 * 
 * @author Chase Booher
 */
public class GameLoop
{
	//The canvas dimensions
	private double xDim;
	private double yDim;
	private GraphicsContext gc;
	private Canvas c;
	private boolean active;
	
	public GameLoop(double x, double y)
	{
		xDim=x;
		yDim=y;
		active=false;
	}
	
	public void init(Stage stage, Group g, Scene s)
	{
		active=true;
		stage.setTitle( "Platformer Game" );
        c = new Canvas( xDim, yDim );
        g.getChildren().add(c);
        gc = c.getGraphicsContext2D();
        stage.setScene(s);
	}

    public void stuff(ArrayList<Entity> entities) 
    {
                // Clear the canvas
                gc.clearRect(0, 0, xDim,yDim);
                for(Entity e : entities)
                {
                	gc.drawImage( e.getImage(), e.getXCoord(), e.getYCoord());
                	e.act();
                }

    }
    public Boolean isActive()
    {
    	return active;
    }
    public void setInactive()
    {
    	active=false;
		c=null;
		gc=null;
    }
}