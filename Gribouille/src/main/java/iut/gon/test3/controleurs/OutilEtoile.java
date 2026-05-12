package iut.gon.test3.controleurs;

import iut.gon.gribouille.modele.Etoile;
import javafx.scene.input.MouseEvent;

public class OutilEtoile extends Outil {

	private double centreX;
	private double centreY;
	
	public OutilEtoile(Controleur controleur) {
		super(controleur);
		// TODO Auto-generated constructor stub
	}

	public void onMousePressed(MouseEvent e) {
		centreX = e.getX();
		centreY = e.getY();
		controleur.setTrace(new Etoile(1, "", e.getX(), e.getY()));
		controleur.getDessin().addFigure(controleur.getTrace());
	}
	
	public void onMouseDragged(MouseEvent e) {
		controleur.getDessinController().trace(centreX, centreY, e.getX(), e.getY());
		controleur.getTrace().addPoint(e.getX(), e.getY());
	}
}
