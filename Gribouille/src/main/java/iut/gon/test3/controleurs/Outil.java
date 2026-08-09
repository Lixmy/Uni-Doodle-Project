package iut.gon.test3.controleurs;

import javafx.scene.input.MouseEvent;

public abstract class Outil {

	protected Controleur controleur;

	public Outil(Controleur controleur) {
		this.controleur = controleur;
	}

	public void onMousePressed(MouseEvent e) {

	}

	public void onMouseDragged(MouseEvent e) {

	}
}
