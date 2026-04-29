package iut.gon.tp3;

import javafx.beans.property.SimpleStringProperty;

public class GrilleModel {
	private SimpleStringProperty[][] tab = new SimpleStringProperty[3][3];
	
	public GrilleModel() {
        for (int lg = 0; lg < 3; lg++) {
            for (int col = 0; col < 3; col++) {
                tab[lg][col] = new SimpleStringProperty("M" + lg + col);
            }
        }
    }
	
	public SimpleStringProperty getCase(int lg, int col) {
        return tab[lg][col];
    }

    public void setCase(int lg, int col, String texte) {
        tab[lg][col].set(texte);
    }
	
}
