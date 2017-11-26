//Team We Love Doggos
//Author Chase Booher
package main;
import model.*;

import controller.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import view.*;
/**
 * This sets up, runs the game, and provides the loop
 * 
 * @author Chase Booher
 */
public class Main extends Application{

    public static void main(String[] args) 
    {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
	    Group g = new Group();
	    Scene s = new Scene(g);
	    MainMenu mMenu= new MainMenu(primaryStage);
	    GameOver gOver = new GameOver();
    	GameLoop gLoop= new GameLoop(1280,720);
        Image hero = new Image( "StickMan.png" );
    	Player p = new Player(0,720-hero.getHeight(),hero);
    	Image star = new Image("Starman.png");
    	TurnAround t = new TurnAround(600, 720-star.getHeight(),star);
    	Image square = new Image("Square.png");
    	DeadlyStill d = new DeadlyStill(800, 720-square.getHeight(), square);
    	PlayerActions actionPlayer = new PlayerActions();
    	CollisionDetection detector = new CollisionDetection();
    	detector.addEntity(p);
    	detector.addEntity(t);
    	detector.addEntity(d);
    	s.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String in = e.getCode().toString();
                        // makes sure there are no duplicate inputs
                        if ( !actionPlayer.getInput().contains(in) )
                            actionPlayer.addInput( in );
                    }
                });
    	s.setOnKeyReleased(
    			
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String in = e.getCode().toString();
                        actionPlayer.removeInput( in );
                    }
                });
    	mMenu.getScene().setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                    	mMenu.setInactive();
                        gLoop.init(primaryStage, g, s, p);
                    }
                });
    	new AnimationTimer()
        {
            public void handle(long currentTime)
            {
            	if(!p.isAlive()&&!gOver.isActive())
            	{
            		gOver.init(primaryStage);
            	}
            	else if(gLoop.isActive())
            	{
	            	actionPlayer.takeAction(p);
	                gLoop.stuff(detector.getList());
	                detector.CollisionCheck();
	                if(p.getDeath())
	                {
	                	detector.reset();
	                }
            	}
                
            }
        }
        .start();
        primaryStage.show();
		
	}
}
