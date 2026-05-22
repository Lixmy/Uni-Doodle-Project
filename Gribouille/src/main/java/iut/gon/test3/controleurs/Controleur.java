package iut.gon.test3.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille.modele.Dessin;
import iut.gon.gribouille.modele.Etoile;
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
	
	private Outil outil = new OutilCrayon(this);

    public final SimpleObjectProperty<Color> couleur = 
        new SimpleObjectProperty<>(Color.BLACK);
    
    public final SimpleIntegerProperty epaisseur = 
        new SimpleIntegerProperty(1);
    
    public SimpleObjectProperty<Dessin> figureCourante = 
        new SimpleObjectProperty<>();

    public final SimpleDoubleProperty precX = new SimpleDoubleProperty(0);
    public final SimpleDoubleProperty precY = new SimpleDoubleProperty(0);
    
    private Dessin dessin = new Dessin();
    private Figure trace;
    
    public void setDessinController(DessinController dc) {
    	this.dessinController = dc;
    }
    
    public Figure getTrace() {
		return trace;
	}

	public void setTrace(Figure trace) {
		this.trace = trace;
	}

	public DessinController getDessinController() {
		return dessinController;
	}

	public Dessin getDessin() {
		return dessin;
	}

	public void dessine() {
    	dessinController.efface();
    	for (Figure figure : dessin.getFigures()) {
    		dessinController.setEpaisseur(figure.getEpaisseur());
    		dessinController.setCouleur(Color.valueOf(figure.getCouleur()));
    		
    		if(figure instanceof Etoile) {
    			Etoile etoile = (Etoile) figure;
    			for(Point p : etoile.getPoints()) {
    				dessinController.trace(etoile.getCentre().getX(), etoile.getCentre().getY(), p.getX(), p.getY());
    			}
    		} else {
    			for (int i = 0; i < figure.getPoints().size()-1; i++) {
    				Point p = figure.getPoints().get(i);
    				Point p2 = figure.getPoints().get(i+1);
    				dessinController. trace(p.getX(), p.getY(), p2.getX(), p2.getY());
    			}
    		}
		}
    }
    
    public void onMousePressed(MouseEvent e) {
    	outil.onMousePressed(e);
		precX.set(e.getX());
		precY.set(e.getY());
    }
    
    public void onMouseDragged(MouseEvent e) {
    	outil.onMouseDragged(e);
		precX.set(e.getX());
		precY.set(e.getY());
    }
    
    public void onCrayon() {
    	outil = new OutilCrayon(this);
    	statutController.outil.setText("Crayon");
    }
    
    public void onEtoile() {
    	outil = new OutilEtoile(this);
    	statutController.outil.setText("Etoile");
    }
    
    public void setEpaisseur(int val) {
    	epaisseur.set(val);
    	dessinController.setEpaisseur(val);
    }
    
    public void setCouleur(Color c) {
    	couleur.set(c);
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