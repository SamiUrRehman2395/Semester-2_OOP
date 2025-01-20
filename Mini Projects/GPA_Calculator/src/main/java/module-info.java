module com.example.gpa_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gpa_calculator to javafx.fxml;
    exports com.example.gpa_calculator;
}