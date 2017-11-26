//We Love Doggos Team
package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver {
		private Boolean active;
		private Scene s;
		private Canvas c;
		private GraphicsContext gc;
		private Image image;
		
		public GameOver()
		{
			active=false;
		}
		
		public void init(Stage stage)
		{
			active=true;
			Group g = new Group();
			s = new Scene(g);
			c = new Canvas( 1280, 720 );
	        g.getChildren().add(c);
	        gc = c.getGraphicsContext2D();
	        stage.setScene(s);
			stage.setTitle( "Game Over" );
	        stage.setScene(s);
	        image = new Image("GameOver.png");
	        gc.drawImage(image, 0, 0);
		}
		
		public Boolean isActive()
		{
			return active;
		}
		public void setInactive()
		{
			active=false;
		}
		public void setActive(Stage stage)
		{
			active=true;
			stage.setTitle("Game Over");
			stage.setScene(s);
		}
		public Scene getScene()
		{
			return s;
		}
}
