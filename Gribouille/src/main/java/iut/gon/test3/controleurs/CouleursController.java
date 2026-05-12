package iut.gon.test3.controleurs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;

public class CouleursController implements Initializable {
	
	private Controleur controleur;
	
	@FXML
	public ColorPicker choixCouleur;
	
	@FXML
	public Rectangle vert;

	@FXML
	public Rectangle bleu;

	@FXML
	public Rectangle cyan;

	@FXML
	public Rectangle violet;
	
	@FXML
	public Rectangle jaune;
	
	@FXML
	public Rectangle noir;
	
	@FXML
	public Rectangle blanc;

	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
