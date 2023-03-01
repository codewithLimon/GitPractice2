package system.projectlearningmanagement.LoginPage;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class AlertDialog {
    public static void display(String text) {

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        Label label = new Label(text);

        VBox layout = new VBox(label);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 200, 100);

        stage.setTitle("Dialog");
        stage.setScene(scene);
        stage.show();
    }
}