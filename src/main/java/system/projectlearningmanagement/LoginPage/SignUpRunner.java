package system.projectlearningmanagement.LoginPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class SignUpRunner extends Application {
    public void start(Stage primaryStage)throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("signup.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
