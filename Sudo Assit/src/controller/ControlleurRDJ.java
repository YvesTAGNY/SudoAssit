package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class ControlleurRDJ  implements Initializable {
	
	   @FXML private WebView webView;
	   
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			webView.getEngine().load("file:///H:/Mes%20documents/4AIINFO/Dev%20IHM/MP_IHM/SudoAssit/Sudo%20Assit/resources/rdj/rdj.html");
		}
}
