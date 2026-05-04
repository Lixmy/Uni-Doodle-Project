package iut.gon.test3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class GribouilleController implements Initializable {
		
		private double prevX;
		private double prevY;

	    @FXML
	    private Label abscisse;

	    @FXML
	    private Rectangle blanc;

	    @FXML
	    private Rectangle bleu;

	    @FXML
	    private Canvas canvas;

	    @FXML
	    private ColorPicker choixCouleur;

	    @FXML
	    private Rectangle cyan;

	    @FXML
	    private Label epaisseur;

	    @FXML
	    private ToggleGroup groupe;

	    @FXML
	    private ToggleGroup groupe1;

	    @FXML
	    private Rectangle jaune;

	    @FXML
	    private Rectangle noir;

	    @FXML
	    private Label ordonnee;

	    @FXML
	    private Pane pane;

	    @FXML
	    private Rectangle rouge;

	    @FXML
	    private Rectangle vert;

	    @FXML
	    private Rectangle violet;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			canvas.widthProperty().bind(pane.widthProperty());
			canvas.heightProperty().bind(pane.heightProperty());
			
		}
	    
	    public void onMousePressed(MouseEvent e) {
	        prevX = e.getX();
	       	prevY = e.getY();
	    }
	    
	    
	    public void onMouseDragged(MouseEvent e) {
	    	canvas.getGraphicsContext2D().strokeLine(prevX, prevY, e.getX(), e.getY());
	    	prevX = e.getX();
        	prevY = e.getY();
	    }

}
