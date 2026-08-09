package iut.gon.test3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

import iut.gon.test3.controleurs.Controleur;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private double prevX;
	private double prevY;

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CadreGribouille.fxml"));
		scene = new Scene(fxmlLoader.load(), 640, 480);
		Controleur controleur = fxmlLoader.getController();
		stage.setScene(scene);
		stage.show();
		stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			controleur.onKeyPressed(e.getText());
		});
		stage.setOnCloseRequest(e -> {
			if (Dialogues.confirmation() == true) {
				e.consume();
			}
		});

	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}