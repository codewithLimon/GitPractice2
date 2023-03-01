package system.projectlearningmanagement.LoginPage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML
    private TextField email;

    @FXML
    private Hyperlink forgotPass;

    @FXML
    private PasswordField password;

    @FXML
    private CheckBox rememberMe;

    public void loginClicked(){
        String mail=email.getText();
        String pass=password.getText();

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "limon";
        String password = "1122334455";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        try{

            String chk="Select * from User_accounts where email=?";
            Connection con;
            PreparedStatement pst;

            con=DriverManager.getConnection(url, username, password);
            pst=con.prepareStatement(chk);
            pst.setString(1,mail);
            ResultSet rs;
            rs=pst.executeQuery();

            if(rs.next()){
                String pas=rs.getString("pass");
                if(pas.equals(pass)){
                    String fullName=rs.getString("name");
                    String em=rs.getString("email");
                    String datofBirth=rs.getString("dob");
                    String gend=rs.getString("gender");
                    String usern=rs.getString("username");

                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Welcome");
                    alert.setHeaderText("Login Successful");
                    alert.setContentText("Name: "+fullName+"\nEmail: "+em+"\nDate of Birth: "+datofBirth+"\nGender: "+gend+"\nUsername: "+usern);
                    alert.showAndWait();

                }else {
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Wrong password");
                    alert.setContentText("Please enter your password correctly!");
                    alert.showAndWait();
                }
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong email/password");
                alert.setContentText("Please enter your email and password correctly!");
                alert.showAndWait();
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void createNewAccClicked() throws IOException {
        root=FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage=new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void loginWithGoogleClicked(){


    }
}

