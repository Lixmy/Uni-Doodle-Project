package fr.unicaen.iut.tp5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class ControleurDemineur implements Initializable {
	
	private ModeleDemineur md;
	@FXML
	private TextField nbMarques;
	@FXML
	private TextField nbInconnues;
	@FXML
	private ToggleGroup difficulte;
	@FXML
	private GridPane grid;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		md = new ModeleDemineur(0,0,0);
		
		nbInconnues.textProperty().bind(md.nbInconnuesProperty().asString());
		nbMarques.textProperty().bind(md.nbMarquesProperty().asString());
		
		difficulte.selectedToggleProperty().addListener((obs, old, newV) -> {
				initGrille(newV.getUserData());
		});
	}
	
	public void initGrille(Object o) {
		grid.getRowConstraints().clear();
		grid.getColumnConstraints().clear();
		
		int[] values = ModeleDemineur.parseUserData(o.toString());
		md.setTaille(values[1], values[0], values[2]);
		for(int i = 0; i < values[0]; i++) {
			grid.getColumnConstraints().add(new ColumnConstraints(32));
		}
		for(int i = 0; i < values[1]; i++) {
			grid.getRowConstraints().add(new RowConstraints(32));
		}
		
		BackgroundFill inconnu = new BackgroundFill(Color.AQUA, new CornerRadii(20), null);
		BackgroundFill libre = new BackgroundFill(Color.LIGHTGRAY, null, null);
		BackgroundFill echec = new BackgroundFill(Color.RED, null, null);
		BackgroundFill marquee = new BackgroundFill(Color.LEMONCHIFFON, null, null);
		Background bgInconnu = new Background(inconnu);
		Background bgLibre= new Background(libre);
		Background bgEchec = new Background(echec);
		Background bgMarquee = new Background(marquee);
		grid.getChildren().clear();
		for(int i = 0; i < values[1]; i++) {
			for(int j = 0; j < values[0]; j++) {
				int lig = i;
				int col = j;
				Label l = new Label();
				l.setBackground(bgInconnu);
				l.setPrefSize(31, 31);
				l.setAlignment(Pos.CENTER);
				l.textProperty().bind(md.texteProperty(lig, col));
				l.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
					if(md.estPerdu() != true) {
						if(e.getButton() == MouseButton.PRIMARY) {
							md.revele(lig, col);
							if(md.getText(lig, col) == "X") {
								l.setBackground(bgEchec);
							}
							else {
								l.setBackground(bgLibre);
							}
						}
						if(e.getButton() == MouseButton.SECONDARY) {
							md.marque(lig, col);
							if(md.getText(lig, col) == "?") {
								l.setBackground(bgInconnu);
							}
							else {
								l.setBackground(bgMarquee);
							}
						}
					}
				});
				grid.add(l, col, lig);
			}
		}
	}
	
	
}
