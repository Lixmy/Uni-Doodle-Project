package iut.gon.tp2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TP2App extends Application {

  private BorderPane contenu;
  private ListView<String> gauche;
  private ListView<String> droite;
  private Button versGauche;
  private Button versDroite;
  private Button retireTout;
  private Button ajouteTout;

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(TP2App.class.getResource("Tp2.fxml"));
    contenu = fxmlLoader.load();
    Scene scene = new Scene(contenu);
    extraitIds(scene);

    prepareMenus((MenuBar) scene.lookup("#menus"));
    prepareListe();
    prepareBoutons();
    prepareFermeture(stage);
    versDroite.setOnAction(e -> deplacerElement(gauche, droite));
    versGauche.setOnAction(e -> deplacerElement(droite, gauche));

    stage.setTitle("Gestion de groupe");
    stage.setScene(scene);
    stage.show();
  }

  /** Prépare la fenêtre pour demander confirmation avant fermeture */
  private void prepareFermeture(Stage stage) {
    stage.setOnCloseRequest(event -> {
      //TODO confirmer ou consommer l'événement
    });
  }

  /** Prépare les actions des boutons */
  private void prepareBoutons() {
    ajouteTout.setOnAction(this::onAjouteTout);
    retireTout.setOnAction(this::onRetireTout);
    // TODO actions des deux boutons centraux
  }

  /** Ajoute tous les éléments de gauche dans la liste de droite
   Active le bouton "Retirer tout" et désactive le bouton "Ajouter tout" */
  private void onAjouteTout(ActionEvent actionEvent) {
    droite.getItems().addAll(gauche.getItems());
    gauche.getItems().clear();
    ajouteTout.setDisable(true);
    retireTout.setDisable(false);
    //TODO active/désactive les boutons
  }
  
  private void deplacerElement(ListView<String> source, ListView<String> destination) {
	  int i = source.getSelectionModel().getSelectedIndex();
	  if(i != -1) {
		  String element = source.getItems().remove(i);
		  destination.getItems().add(element);
	  }
  }

  /** Ajoute tous les éléments de droite dans la liste de gauche
   Active le bouton "Ajouter tout" et désactive le bouton "Retirer tout" */
  private void onRetireTout(ActionEvent actionEvent) {
	  gauche.getItems().addAll(droite.getItems());
	  droite.getItems().clear();
	  ajouteTout.setDisable(false);
	  retireTout.setDisable(true);
    //TODO
  }

  /** Prépare les menus et leurs événements */
  private void prepareMenus(MenuBar menus) {
	  Menu m1 = new Menu("_Fichiers");
	  Menu m2 = new Menu("_Aide");
	  menus.getMenus().addAll(m1, m2);
	  MenuItem i1 = new MenuItem("Quitter");
	  MenuItem i2 = new MenuItem("A propos");
	  m1.getItems().addAll(i1);
	  m2.getItems().addAll(i2);
	  i1.setOnAction(event -> Platform.exit());
	  i2.setOnAction(event -> {
		  Alert a = new Alert(AlertType.NONE, "", ButtonType.CLOSE);
		  a.setTitle("A propos");
		  a.setContentText("Fait par... moi");
		  a.show();
	  });
	  
    //TODO Remplir la barre de menus
  }

  /**
   Remplit la liste de gauche avec des valeurs
   Active le bouton "Ajouter tout"
   */
  private void prepareListe() {
	  String s1 = "jolie jonquilles";
	  String s2 = "parfaites paquerettes";
	  String s3 = "lisse lys";
	  String s4 = "prolétaires pivoines";
	  gauche.getItems().add(s1);
	  gauche.getItems().add(s2);
	  gauche.getItems().add(s3);
	  gauche.getItems().add(s4);
	  ajouteTout.setDisable(false);
	  
    //TODO active le bouton "Ajouter tout"
  }

  private void extraitIds(Scene scene) {
    gauche = (ListView<String>) scene.lookup("#gauche");
    droite = (ListView<String>) scene.lookup("#droite");
    versGauche = (Button) scene.lookup("#versGauche");
    versDroite = (Button) scene.lookup("#versDroite");
    retireTout = (Button) scene.lookup("#retireTout");
    ajouteTout = (Button) scene.lookup("#ajouteTout");
  }

  public static void main(String[] args) {
    launch();
  }
}
