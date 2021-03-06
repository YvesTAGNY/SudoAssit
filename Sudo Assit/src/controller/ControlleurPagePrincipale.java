package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Score;

public class ControlleurPagePrincipale implements Initializable {
	
	public static int gridPaneActive = 9;
	
	@FXML private Button plus;
	@FXML private GridPane grille9;
	@FXML private GridPane grille4;
	@FXML private Pane paneplus;
	@FXML private Pane scores;
	
	@FXML private TableView<Score> tableView;
	
	@FXML private TableColumn<Score, String> nameS;
	@FXML private TableColumn<Score, String> scoreS;
	
	@FXML private ComboBox<String> level;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		level.getItems().addAll("9*9","4*4");
		 
		level.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		public void changed(ObservableValue<? extends String> selected, String oldV, String newV) {
		    	
			    if (newV != null) {
			    	switch(newV){
				    	case "9*9" :{
				    		grille4.setVisible(false);
				    		grille9.setVisible(true);
				    		gridPaneActive = 9;
				    		break;
				    	}
				    	case "4*4" :{
				    		grille4.setVisible(true);
				    		grille9.setVisible(false);
				    		gridPaneActive = 4;
				    		break;
				    	}
			    	}
			   }
			}
	   });
	}
	
	@FXML
	protected void doTactiques(ActionEvent event) throws IOException {
		ControlleurHTMLView.sreem = 2;
		//ouverture de la fenetre Tactiques
        final URL url = getClass().getResource("/view/Tactiques.fxml");
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        final AnchorPane root = (AnchorPane) fxmlLoader.load();
        final Scene scene = new Scene(root);
        final Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
	}
	
	@FXML
	protected void doRegleDuJeu(ActionEvent event) throws IOException {
		  ControlleurHTMLView.sreem = 1;
        //ouverture de la fenetre Regle Du Jeu
        final URL url = getClass().getResource("/view/RegleDuJeu.fxml");
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        final AnchorPane root = (AnchorPane) fxmlLoader.load();
        final Scene scene = new Scene(root);
        final Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
	}
	
	@FXML
	protected void doSaisirGrille(ActionEvent event) throws IOException {
		//ouverture de la fenetre Saisir d'une Grille
        final URL url = getClass().getResource("/view/SaisirGrille.fxml");
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        final AnchorPane root = (AnchorPane) fxmlLoader.load();
        final Scene scene = new Scene(root);
        final Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
	}
	
	@FXML
	protected void doScannerGrille(ActionEvent event) throws IOException {
		//ouverture de la fenetre Scanner une Grille
        final URL url = getClass().getResource("/view/Scanner.fxml");
        final FXMLLoader fxmlLoader = new FXMLLoader(url);
        final AnchorPane root = (AnchorPane) fxmlLoader.load();
        final Scene scene = new Scene(root);
        final Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
	}
	
	@FXML
	protected void doPlus(ActionEvent event) throws IOException {
		
		if(paneplus.isVisible())
			paneplus.setVisible(false);
		else
			paneplus.setVisible(true);
	}
	
	@FXML
	protected void doOuvrir(ActionEvent event) throws IOException {
		paneplus.setVisible(false);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.showOpenDialog(tableView.getScene().getWindow());
	}
	
	@FXML
	protected void doSave(ActionEvent event) throws IOException {
		paneplus.setVisible(false);
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Partie");
        File file = fileChooser.showSaveDialog(tableView.getScene().getWindow());
	}
	
	@FXML
	protected void doScores(ActionEvent event) throws IOException {
			tableView.getItems().addAll(new Score("Albert",13),new Score("Pierre",10),new Score("Yves",7));
			nameS.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
			scoreS.setCellValueFactory(cellData -> cellData.getValue().scoreStringProperty());
			grille4.setVisible(false);
    		grille9.setVisible(false);
    		scores.setVisible(true);
    		paneplus.setVisible(false);
	}
	
	@FXML
	protected void doRetour(ActionEvent event) throws IOException {
		scores.setVisible(false);
		if(gridPaneActive == 9){
    		grille9.setVisible(true);
		}
		if(gridPaneActive == 4){
			grille4.setVisible(true);
		}
	}
}
