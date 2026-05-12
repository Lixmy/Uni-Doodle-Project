package iut.gon.test3.controleurs;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import java.net.URL;
import java.util.ResourceBundle;

public class MenusController implements Initializable {

    private Controleur controleur;

    @FXML
    private ToggleGroup groupe;
    @FXML
    private ToggleGroup groupe1;

    public void setControleur(Controleur c) {
        this.controleur = c;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    }
}