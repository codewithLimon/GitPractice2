package system.projectlearningmanagement.LoginPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGoogle implements Initializable {

    @FXML
    private WebView webpage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebEngine webEngine=new WebEngine();
    }
}
