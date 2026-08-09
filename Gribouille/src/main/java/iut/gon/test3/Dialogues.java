package iut.gon.test3;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Dialogues {

	public static boolean confirmation() {
		Alert a = new Alert(Alert.AlertType.CONFIRMATION, "ZETES SUR DE VOULOIR FAIRE CECI ? ", ButtonType.YES,
				ButtonType.NO);
		a.setTitle("Vous êtes sûr ???");

		if (a.showAndWait().get() == ButtonType.NO) {
			return true;
		}
		return false;
	}
}
