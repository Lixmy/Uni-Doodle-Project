package iut.gon.tp3;

import javafx.scene.control.Label;

public class GrilleModel {
	private String[][] model = new String[3][3];
	
	public GrilleModel() {
        for (int lg = 0; lg < 3; lg++) {
            for (int col = 0; col < 3; col++) {
                model[lg][col] = "truc " + lg + col;
            }
        }
    }
	
	public String getCase(int i, int j) {
		return model[i][j];
	}
	
	public void setCase(int i, int j, String texte) {
		model[i][j] = texte;
	}
	
	
	
}
