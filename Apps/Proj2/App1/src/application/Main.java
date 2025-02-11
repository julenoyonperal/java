// https://www.youtube.com/watch?v=nz8P528uGjk
//--module-path "C:/openjfx-23.0.1/javafx-sdk-23.0.1/lib" --add-modules javafx.controls,javafx.fxml
// https://www.youtube.com/watch?v=_7OM-cMYWbQ
// https://openjfx.io/openjfx-docs/

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
