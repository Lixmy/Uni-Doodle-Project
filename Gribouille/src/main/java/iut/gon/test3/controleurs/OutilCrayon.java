package iut.gon.test3.controleurs;

import iut.gon.gribouille.modele.Trace;
import javafx.scene.input.MouseEvent;

public class OutilCrayon extends Outil {
	
	public OutilCrayon(Controleur controleur) {
		super(controleur);
	}

	public void onMousePressed(MouseEvent e) {
		controleur.setTrace(new Trace(controleur.epaisseur.get(), controleur.couleur.get().toString(), e.getX(), e.getY()));
		controleur.getDessin().addFigure(controleur.getTrace());
		controleur.getDessinController().setCouleur(controleur.couleur.get());
		controleur.getDessinController().setEpaisseur(controleur.epaisseur.get());
	}
	
	public void onMouseDragged(MouseEvent e) {
		controleur.getDessinController().trace(controleur.precX.get(), controleur.precY.get(), e.getX(), e.getY());
		controleur.getTrace().addPoint(controleur.precX.get(), controleur.precY.get());
	}

}
