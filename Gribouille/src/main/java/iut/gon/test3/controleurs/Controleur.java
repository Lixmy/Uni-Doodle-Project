package iut.gon.test3.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille.modele.Dessin;
import iut.gon.gribouille.modele.Figure;
import iut.gon.gribouille.modele.Point;
import iut.gon.gribouille.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;

public class Controleur implements Initializable {
	
	@FXML
	private MenusController menusController;
	@FXML
	private StatutController statutController;
	@FXML
	private CouleursController couleursController;
	@FXML
	private DessinController dessinController;

    public final SimpleObjectProperty<Color> couleur = 
        new SimpleObjectProperty<>(Color.BLACK);
    
    public final SimpleIntegerProperty epaisseur = 
        new SimpleIntegerProperty(1);
    
    public SimpleObjectProperty<Dessin> figureCourante = 
        new SimpleObjectProperty<>();

    public final SimpleDoubleProperty precX = new SimpleDoubleProperty(0);
    public final SimpleDoubleProperty precY = new SimpleDoubleProperty(0);
    
    private Dessin dessin = new Dessin();
    private Trace trace;
    
    public void setDessinController(DessinController dc) {
    	this.dessinController = dc;
    }
    
    public void dessine() {
    	dessinController.efface();
    	for (Figure figure : dessin.getFigures()) {
			for (int i = 0; i < figure.getPoints().size()-1; i++) {
				Point p = figure.getPoints().get(i);
				Point p2 = figure.getPoints().get(i+1);
				dessinController. trace(p.getX(), p.getY(), p2.getX(), p2.getY());
			}
		}
    }
    
    public void onMousePressed(MouseEvent e) {
    	trace = new Trace(1, "", e.getX(), e.getY());
		precX.set(e.getX());
		precY.set(e.getY());
		dessin.addFigure(trace);
    }
    
    public void onMouseDragged(MouseEvent e) {
    	dessinController.trace(precX.get(), precY.get(), e.getX(), e.getY());
		precX.set(e.getX());
		precY.set(e.getY());
		trace.addPoint(precX.get(), precY.get());
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menusController.setControleur(this);
	    statutController.setControleur(this);
	    couleursController.setControleur(this);
	    dessinController.setControleur(this);
	    setDessinController(dessinController);
		
	}
}