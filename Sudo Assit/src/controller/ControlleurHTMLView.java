package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

public class ControlleurHTMLView  implements Initializable {
	
		public static int sreem = 0;
	   @FXML private WebView webViewrdj;
	   @FXML private WebView webViewtb;
	   
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			if(sreem == 1){
				final URL urlrdj = getClass().getResource("/resources/rdj.htm"); 
				webViewrdj.getEngine().load(urlrdj.toExternalForm());
			}
			if(sreem == 2){
				final URL urltb = getClass().getResource("/resources/tb.htm"); 
				webViewtb.getEngine().load(urltb.toExternalForm());
			}
		}
}
