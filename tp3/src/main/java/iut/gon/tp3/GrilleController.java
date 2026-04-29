package iut.gon.tp3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GrilleController implements Initializable {
	private @FXML GridPane grille;
	private Label[][] labels = new Label[3][3];
	
	public void initialize(URL u ,ResourceBundle r) {
		grille.setStyle("-fx-background-color: seashell");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Label lbl = new Label();
				
				lbl.setText(String.format("L%dC%d", i, j));
				lbl.setOnMouseClicked(e -> {
					lbl.setText("bonjour");
				});
				grille.add(lbl, i, j);
				labels[i][j] = lbl;
				lbl.setMaxSize(1000, 1000);
				lbl.setAlignment(Pos.CENTER);
			}
		}
	}
}
