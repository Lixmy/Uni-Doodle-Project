package iut.gon.tp3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
    	
    	GrilleModel gm = new GrilleModel();
    	GrilleController gc = new GrilleController(gm);
    	
        scene = new Scene(loadFXML("primary", gc), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml, GrilleController gc) throws IOException {
        scene.setRoot(loadFXML(fxml, gc));
    }

    private static Parent loadFXML(String fxml, GrilleController gc) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(gc);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}