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
		controleur.setTrace(
				new Etoile(controleur.epaisseur.get(), controleur.couleur.get().toString(), e.getX(), e.getY()));
		controleur.getDessin().addFigure(controleur.getTrace());
		controleur.getDessinController().setCouleur(controleur.couleur.get());
		controleur.getDessinController().setEpaisseur(controleur.epaisseur.get());
	}

	public void onMouseDragged(MouseEvent e) {
		controleur.getDessinController().trace(centreX, centreY, e.getX(), e.getY());
		controleur.getTrace().addPoint(e.getX(), e.getY());
	}
}
