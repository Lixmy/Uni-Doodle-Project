package iut.gon.test3;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille.modele.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GribouilleController implements Initializable {

	private SimpleDoubleProperty prevX;
	private SimpleDoubleProperty prevY;
	private Dessin dessin;
	private Trace trace;

	@FXML
	private Label abscisse;

	@FXML
	private Rectangle blanc;

	@FXML
	private Rectangle bleu;

	@FXML
	private Canvas canvas;

	@FXML
	private ColorPicker choixCouleur;

	@FXML
	private Rectangle cyan;

	@FXML
	private Label epaisseur;

	@FXML
	private ToggleGroup groupe;

	@FXML
	private ToggleGroup groupe1;

	@FXML
	private Rectangle jaune;

	@FXML
	private Rectangle noir;

	@FXML
	private Label ordonnee;

	@FXML
	private Pane pane;

	@FXML
	private Rectangle rouge;

	@FXML
	private Rectangle vert;

	@FXML
	private Rectangle violet;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		prevX = new SimpleDoubleProperty(0);
		prevY = new SimpleDoubleProperty(0);
		
		
		abscisse.textProperty().bind(prevX.asString());;
		ordonnee.textProperty().bind(prevY.asString());
		
		canvas.widthProperty().bind(pane.widthProperty());
		canvas.heightProperty().bind(pane.heightProperty());
		
		canvas.heightProperty().addListener((obs, old, newV) -> {
			for (Figure figure : dessin.getFigures()) {
				for (int i = 0; i < figure.getPoints().size()-1; i++) {
					Point p = figure.getPoints().get(i);
					Point p2 = figure.getPoints().get(i+1);
					canvas.getGraphicsContext2D().strokeLine(p.getX(), p.getY(), p2.getX(), p2.getY());
				}
			}
		});
		
		canvas.widthProperty().addListener((obs, old, newV) -> {
			for (Figure figure : dessin.getFigures()) {
				for (int i = 0; i < figure.getPoints().size()-1; i++) {
					Point p = figure.getPoints().get(i);
					Point p2 = figure.getPoints().get(i+1);
					canvas.getGraphicsContext2D().strokeLine(p.getX(), p.getY(), p2.getX(), p2.getY());
				}
			}
		});

	}

	public void setDessin(Dessin d) {
		this.dessin = d;
	}

	public void onMousePressed(MouseEvent e) {
		trace = new Trace(1, "", e.getX(), e.getY());
		prevX.set(e.getX());
		prevY.set(e.getY());
		dessin.addFigure(trace);
	}

	public void onMouseDragged(MouseEvent e) {
		canvas.getGraphicsContext2D().strokeLine(prevX.get(), prevY.get(), e.getX(), e.getY());
		prevX.set(e.getX());
		prevY.set(e.getY());
		trace.addPoint(prevX.get(), prevY.get());
	}

}
