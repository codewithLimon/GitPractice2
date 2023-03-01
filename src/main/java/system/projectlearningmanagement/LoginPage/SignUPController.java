package system.projectlearningmanagement.LoginPage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SignUPController implements Initializable {
    @FXML
    private DatePicker DOB;

    @FXML
    private ComboBox<String > Gender;

    @FXML
    private TextField Name;

    @FXML
    private PasswordField confirmpassword;

    @FXML
    private TextField email;

    @FXML
    private PasswordField pass;

    @FXML
    private CheckBox showPass;

    @FXML
    private CheckBox show_pass;

    @FXML
    private Button signup;



    public void signUpClicked() throws SQLException {

        //connection start

        Connection con;
        PreparedStatement pst;

        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "limon";
        String password = "1122334455";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        //connection end




        String mail1="@gmail.com";
        String mail2="@yahoo.com";
        String mail3="@hotmail.com";
        String mail4="@";

        try {
            if((Name.getText()!=null) && (email.getText().contains(mail1) || email.getText().contains(mail2) || email.getText().contains(mail3) || email.getText().contains(mail4)) && (pass.getText().equals(confirmpassword.getText()) && pass.getText().length()>=8) && DOB!=null){
                try{


                    con=DriverManager.getConnection(url, username, password);

                    String name=Name.getText();
                    String mail =email.getText();
                    String password1=pass.getText();
                    String cpass=confirmpassword.getText();
                    String birth=DOB.getValue().toString();
                    String gen=Gender.getValue().toString();

                    String query11 = "select count(*) from User_accounts";
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery(query11);
                    rs.next();
                    int count=rs.getInt(1);

                    String smallName=Name.getText().toLowerCase();


                    String[] split=(smallName).split(" ");
                    String nUsername=split[0]+""+(count+1);


                    pst=con.prepareStatement("INSERT INTO User_accounts(name,email,pass,dob,gender,username) VALUES(?,?,?,?,?,?)");
                    pst.setString(1,name);
                    pst.setString(2,mail);
                    pst.setString(3,password1);
                    pst.setString(4,birth);
                    pst.setString(5, gen);
                    pst.setString(6,nUsername);
                    pst.execute();

                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Welcome");
                    alert.setHeaderText("Login Successful");
                    alert.setContentText("Sign up Successful\nAutomatically Generated Username: "+nUsername+"\nUse this username to login into your account");
                    alert.showAndWait();



                }catch (Exception e){
                    System.out.println(e);
                }
            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Sign UP Failed");
                alert.setContentText("Please enter all data correctly");
                alert.showAndWait();
            }

        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       Gender.getItems().addAll(
               "Male",
               "Female",
               "Custom"
       );
    }
}
