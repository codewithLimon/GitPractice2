package system.projectlearningmanagement.LoginPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.*;

import java.net.URL;
import java.util.ResourceBundle;

public class GoogleController implements Initializable {

    @FXML
    private WebView webview;
    private WebEngine engine;
    @FXML
    private Button go;

    @FXML
    private TextField urlBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine=webview.getEngine();
        loadpage();
    }

    public void loadpage() {
        engine.load("https://"+urlBox.getText());
    }


}
