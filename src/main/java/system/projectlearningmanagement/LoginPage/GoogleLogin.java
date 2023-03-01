package system.projectlearningmanagement.LoginPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class GoogleLogin extends Application {
    public void start(Stage primaryStage)throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("google.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Maps");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
