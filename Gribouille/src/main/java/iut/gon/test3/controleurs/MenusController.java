package iut.gon.test3.controleurs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import java.net.URL;
import java.util.ResourceBundle;

public class MenusController implements Initializable {

    private Controleur controleur;

    @FXML
    private ToggleGroup groupe;
    @FXML
    private ToggleGroup groupe1;
    @FXML
    private RadioMenuItem etoile;
    @FXML
    private RadioMenuItem crayon;

    public void setControleur(Controleur c) {
        this.controleur = c;
        groupe.selectedToggleProperty().addListener((obs, old, newV) -> {
        	if(newV != null) {
        		int val = Integer.parseInt(((RadioMenuItem) newV).getText());
        		controleur.setEpaisseur(val);
        	}
        });
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	groupe1.selectedToggleProperty().addListener((obs, old, newV) -> {
	    	if(newV == crayon) {
	    		controleur.onCrayon();
	    	}
	    	else if(newV == etoile) {
	    		controleur.onEtoile();
	    	}
    	});
    }
}