//We Love Doggos Team
package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOver {
		private Boolean active;
		private Scene s;
		
		public GameOver()
		{
			active=false;
		}
		
		public void init(Stage stage)
		{
			active=true;
			Label label1= new Label("GAME OVER."); 
			VBox layout1 = new VBox(20);     
			layout1.getChildren().addAll(label1);
			s= new Scene(layout1, 1280, 720);
			stage.setTitle( "Game Over" );
	        stage.setScene(s);
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
