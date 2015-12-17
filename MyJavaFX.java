/* Basic JavaFX
*/



//import statements to include in every JavaFX GUI class
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import statement specific to only this example
import javafx.scene.control.Button;

//every JavaFX GUI is a subclass of Application
public class MyJavaFX extends Application {
	@Override //Override the start method in the Application class
	
	//provide the start() method in every JavaFX GUI
	public void start(Stage primaryStage) {
		//create a scene and place a button in the scene
		Button btOK = new Button("OK");
		Scene scene = new Scene(btOK, 200, 250);
		
		//set the window's title
		primaryStage.setTitle("MyJavaFX");
		
		//set the Stage's current scene to be the one we just now built
		primaryStage.setScene(scene);
		
		//show the Stage
		primaryStage.show();
	}
}



