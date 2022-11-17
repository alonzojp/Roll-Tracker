module com.example.rolltracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rolltracker to javafx.fxml;
    exports com.example.rolltracker;
}