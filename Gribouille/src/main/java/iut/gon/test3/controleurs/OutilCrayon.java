package iut.gon.test3.controleurs;

import iut.gon.gribouille.modele.Trace;
import javafx.scene.input.MouseEvent;

public class OutilCrayon extends Outil {
	
	public OutilCrayon(Controleur controleur) {
		super(controleur);
	}

	public void onMousePressed(MouseEvent e) {
		controleur.setTrace(new Trace(1, "", e.getX(), e.getY()));
		controleur.getDessin().addFigure(controleur.getTrace());
	}
	
	public void onMouseDragged(MouseEvent e) {
		controleur.getDessinController().trace(controleur.precX.get(), controleur.precY.get(), e.getX(), e.getY());
		controleur.getTrace().addPoint(controleur.precX.get(), controleur.precY.get());
	}

}
