module com.example.cricket {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cricket to javafx.fxml;
    exports com.example.cricket;
}