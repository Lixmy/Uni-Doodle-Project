package fr.iutgon.tp6;

import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import fr.iutgon.tp6.modele.Ligne;

public class CelluleMonetaire extends TableCell<Ligne, Number> {
	private static final PseudoClass negatifCSS = PseudoClass.getPseudoClass("negatif");
	
	public CelluleMonetaire() {
		setAlignment(Pos.CENTER_RIGHT);
	}
	
	protected void updateItem(Number valeur, boolean empty) {
        super.updateItem(valeur, empty);

        if (empty || valeur == null) {
            setGraphic(null);
            setText(null);
        } else {
            setText(String.format("%.2f €", valeur.floatValue()));
            pseudoClassStateChanged(negatifCSS, valeur.floatValue() < 0);
        }
    }
}
