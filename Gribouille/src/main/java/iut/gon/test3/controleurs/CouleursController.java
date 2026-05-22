package iut.gon.test3.controleurs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class CouleursController implements Initializable {

	private Controleur controleur;

	@FXML
	public ColorPicker choixCouleur;

	@FXML
	public Rectangle rouge;

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

	@FXML
	public Rectangle rectangleCourant = null;

	public void onCouleurCliquee(MouseEvent e) {
		Rectangle rect = (Rectangle) e.getTarget();

		if (rectangleCourant != null) {
			rectangleCourant.setArcWidth(5);
			rectangleCourant.setArcHeight(5);
			rectangleCourant.setStrokeWidth(1);
		}
		rect.setArcWidth(10);
		rect.setArcHeight(10);
		rect.setStrokeWidth(5);

		rectangleCourant = rect;

		Color couleur = (Color) rect.getFill();
		controleur.setCouleur(couleur);
	}

	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
