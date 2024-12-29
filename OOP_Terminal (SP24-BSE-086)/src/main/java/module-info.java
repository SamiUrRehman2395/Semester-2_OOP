module com.example.oop_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop_final to javafx.fxml;
    exports com.example.oop_final;
}