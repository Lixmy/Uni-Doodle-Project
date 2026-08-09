package iut.gon.test3.controleurs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StatutController implements Initializable {
	private Controleur controleur;

	@FXML
	public Label ordonnee;

	@FXML
	public Label abscisse;

	@FXML
	public Label epaisseur;

	@FXML
	public Label outil;

	@FXML
	public Label couleurLabel;

	public void setControleur(Controleur c) {
		this.controleur = c;
		abscisse.textProperty().bind(c.precX.asString("X : %.0f"));
		ordonnee.textProperty().bind(c.precY.asString("Y : %.0f"));
		epaisseur.textProperty().bind(c.epaisseur.asString("Epaisseur : %d"));
		couleurLabel.textProperty().bind(c.couleur.asString(""));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
