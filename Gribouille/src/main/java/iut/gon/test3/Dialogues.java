package iut.gon.test3;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Dialogues {
	
	public static boolean confirmation() {
		Alert a = new Alert(Alert.AlertType.CONFIRMATION);
		a.setTitle("Vous êtes sûr ???");
		a.setContentText("ZETES SUR DE VOULOIR FAIRE CECI?");
		
		if(a.showAndWait().get() == ButtonType.YES) {
			return true;
		}
		return false;
	}
}
