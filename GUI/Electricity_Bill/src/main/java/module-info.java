module com.example.electricity_bill {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.electricity_bill to javafx.fxml;
    exports com.example.electricity_bill;
}