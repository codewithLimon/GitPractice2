module system.projectlearningmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.web;


    opens system.projectlearningmanagement.LoginPage to javafx.fxml;
    exports system.projectlearningmanagement.LoginPage;

}