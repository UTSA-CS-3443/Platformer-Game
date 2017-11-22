//We Love Doggos Team
package view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.animation.AnimationTimer;

// Currently just a placeholder, just moves an image around to demonstrate successful fx animation
public class Main extends Application 
{
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) 
    {
        stage.setTitle( "Platformer Game" );

        Group g = new Group();
        Scene s = new Scene(g);
        stage.setScene(s);
        Canvas c = new Canvas( 1280, 720 );
        g.getChildren().add(c);
        GraphicsContext gc = c.getGraphicsContext2D();
        Image blob = new Image( "blob.png" );

        new AnimationTimer()
        {
        	int x=0;
        	int y=0;
            public void handle(long currentTime)
            {
                // Clear the canvas
                gc.clearRect(0, 0, 1536,1024);
                // background image clears canvas
                gc.drawImage( blob, x, y );
                x++;
                y++;
                if(x>1280)
                {
                	x=0;
                }
                if(y>720)
                {
                	y=0;
                }
            }
        }
        .start();
        stage.show();
    }
}