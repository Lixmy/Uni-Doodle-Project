package fr.iutgon.tp6;

import fr.iutgon.tp6.modele.FabriqueProduits;
import fr.iutgon.tp6.modele.Ligne;
import fr.iutgon.tp6.modele.Produit;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberExpression;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class FactureController implements Initializable {
	public TableView<Ligne> table;
	public TableColumn<Ligne, Integer> qte;
	public TableColumn<Ligne, Produit> produit;
	public TableColumn<Ligne, Number> prixUnitaire;
	public TableColumn<Ligne, Number> totalHT;
	public TableColumn<Ligne, Number> totalTTC;
	public TextField sommeFacture;

	/**
	 * Called to initialize a controller after its root element has been completely
	 * processed.
	 * 
	 * @param location  The location used to resolve relative paths for the root
	 *                  object, or {@code null} if the location is not known.
	 * @param resources The resources used to localize the root object, or
	 *                  {@code null} if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		qte.setCellValueFactory(new PropertyValueFactory<>("qte"));
		qte.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		produit.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne, Produit>, ObservableValue<Produit>>() {
			public ObservableValue<Produit> call(TableColumn.CellDataFeatures<Ligne, Produit> cellData) {
				return cellData.getValue().produitProperty();
			}
		});
		
		ObservableList<Produit> listeProduits = FXCollections.observableList(FabriqueProduits.getProduits());
		produit.setCellFactory(ChoiceBoxTableCell.forTableColumn(new StringConverter<Produit>() {
		    public String toString(Produit p) {
		        return p.getNom();
		    }
		    public Produit fromString(String nom) {
		        for (Produit p : FabriqueProduits.getProduits()) {
		            if (p.getNom().equals(nom)) return p;
		        }
		        return null;
		    }
		}, listeProduits));
		
		totalHT.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne, Number>, ObservableValue<Number>>() {
	        public ObservableValue<Number> call(TableColumn.CellDataFeatures<Ligne, Number> cellData) {
	            return cellData.getValue().totalHTProperty();
	        }
	    });
		
		totalTTC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne, Number>, ObservableValue<Number>>() {
	        public ObservableValue<Number> call(TableColumn.CellDataFeatures<Ligne, Number> cellData) {
	            return cellData.getValue().totalTTCProperty();
	        }
	    });
		
		prixUnitaire.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ligne, Number>, ObservableValue<Number>>() {
		    public ObservableValue<Number> call(TableColumn.CellDataFeatures<Ligne, Number> cellData) {
		        return cellData.getValue().getProduit().prixProperty();
		    }
		});
		
		prixUnitaire.setCellFactory(col -> new CelluleMonetaire());
		totalHT.setCellFactory(col -> new CelluleMonetaire());
		totalTTC.setCellFactory(col -> new CelluleMonetaire());
	}


	public void onAjouter(ActionEvent actionEvent) {
		Random rand = new Random();
		List<Produit> produits = FabriqueProduits.getProduits();
		Produit produit = produits.get(rand.nextInt(produits.size()));

		int qte = rand.nextInt(10) + 1;

		Ligne ligne = new Ligne(qte, produit);
		table.getItems().add(ligne);
		
		NumberExpression somme = new SimpleIntegerProperty(0);
		for (Ligne l : table.getItems()) {
		    somme = Bindings.add(somme, l.totalTTCProperty());
		}
		sommeFacture.textProperty().bind(somme.asString("%.2f"));
	}
}
