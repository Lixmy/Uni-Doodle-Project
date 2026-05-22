package iut.gon.test3.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class DessinController implements Initializable {

	private Controleur controleur;
	
	@FXML
	public Pane pane;
	
	@FXML
	public Canvas canvas;
	
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	
		
		canvas.widthProperty().bind(pane.widthProperty());
		canvas.heightProperty().bind(pane.heightProperty());
		
		canvas.heightProperty().addListener((obs, old, newV) -> controleur.dessine());
		canvas.widthProperty().addListener((obs, old, newV) -> controleur.dessine());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void onMousePressed(MouseEvent e) {
		controleur.onMousePressed(e);
	}
	
	@FXML
	public void onMouseDragged(MouseEvent e) {
		controleur.onMouseDragged(e);
	}
	
	public void efface() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void trace(double x1, double y1, double x2, double y2) {
		canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
		canvas.getGraphicsContext2D().setLineWidth(controleur.epaisseur.get());
	}
	
	public void setEpaisseur(double val) {
		canvas.getGraphicsContext2D().setLineWidth(val);
	}
}
