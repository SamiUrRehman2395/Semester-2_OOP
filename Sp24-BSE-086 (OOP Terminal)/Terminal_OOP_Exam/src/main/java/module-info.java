module com.example.terminal_oop_exam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.terminal_oop_exam to javafx.fxml;
    exports com.example.terminal_oop_exam;
}