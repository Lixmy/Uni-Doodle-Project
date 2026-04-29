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
	private GrilleModel model;
	
	public GrilleController(GrilleModel gm) {
		this.model = gm;
	}
	
	public void initialize(URL u ,ResourceBundle r) {
		grille.setStyle("-fx-background-color: seashell");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Label lbl = new Label(model.getCase(i, j));
				
				final int lig = i;
				final int col = j;
				
				lbl.setText(String.format("L%dC%d", i, j));
				lbl.setOnMouseClicked(e -> {
					model.setCase(lig, col, "bonjour");
					lbl.setText(model.getCase(lig, col));
				});
				grille.add(lbl, i, j);
				labels[i][j] = lbl;
				lbl.setMaxSize(1000, 1000);
				lbl.setAlignment(Pos.CENTER);
			}
		}
	}
	
	
}
