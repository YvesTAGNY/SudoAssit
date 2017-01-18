package controler;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ControlleurRDJ {
	
	   @FXML
	    private WebView webView;

	    @FXML
	    private void initialize()
	    {
	        WebEngine engine = webView.getEngine();
	        engine.load("http://www.e-sudoku.fr/regle-grille-sudoku.php");
	    }
}
