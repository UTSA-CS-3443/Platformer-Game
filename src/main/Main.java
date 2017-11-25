//Team We Love Doggos
//Author Chase Booher
package main;
import model.*;

import java.util.ArrayList;

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
	    Scene s = new Scene( g );
	    primaryStage.setScene( s );
    	GameLoop gLoop= new GameLoop(1280,720);
    	gLoop.init(primaryStage, g, s);
        Image blob = new Image( "Blob.png" );
    	Player p = new Player(0,720-blob.getHeight(),blob);
    	Image redBlob = new Image("RedBlob.png");
    	TurnAround t = new TurnAround(600, 720-redBlob.getHeight(),redBlob);
    	Image blueBlob = new Image("BlueBlob.png");
    	DeadlyStill d = new DeadlyStill(800, 720-blueBlob.getHeight(), blueBlob);
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
                        String code = e.getCode().toString();
                        // makes sure there are no duplicate inputs
                        if ( !actionPlayer.getInput().contains(code) )
                            actionPlayer.addInput( code );
                    }
                });
    	s.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        actionPlayer.removeInput( code );
                    }
                });
    	new AnimationTimer()
        {
            public void handle(long currentTime)
            {
            	actionPlayer.takeAction(p);
                gLoop.stuff(detector.getList());
            }
        }
        .start();
        primaryStage.show();
		
	}
}
