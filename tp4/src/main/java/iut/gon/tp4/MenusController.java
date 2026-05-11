package iut.gon.tp4;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MenusController {
	
	private GrilleModel modele;
    private Scores table;
    private GrilleController grille;
    
    public void setParams(GrilleModel modele, Scores table, GrilleController grilleController) {
    	this.modele = modele;
    	this.table = table;
    	this.grille = grilleController;
    }
	
	@FXML
	  public void onMenuNouvelle(ActionEvent evt) {
	    modele.nouvellePartie();
	  }
	  @FXML
	  public void onMenuTable(ActionEvent evt) throws IOException {
		  FXMLLoader fxmlLoader = new FXMLLoader(Morpion.class.getResource("table.fxml"));
		  Parent parent = fxmlLoader.load();
		  ((TableController) fxmlLoader.getController()).setScores(table);
		  grille.getGrille().getScene().setRoot(parent);
	  }

	  @FXML
	  public void onMenuQuitter(ActionEvent evt) {
	    Platform.exit();
	  }
	  
}
