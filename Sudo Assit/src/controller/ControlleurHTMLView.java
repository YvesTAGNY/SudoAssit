package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class ControlleurHTMLView  implements Initializable {
	
	   @FXML private WebView webView;
	   
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			final URL url = getClass().getResource("/resources/rdj.htm"); 
			webView.getEngine().load(url.toExternalForm());
		}
}
