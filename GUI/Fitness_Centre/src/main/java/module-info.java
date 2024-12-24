module com.example.fitness_centre {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.javadoc;


    opens com.example.fitness_centre to javafx.fxml;
    exports com.example.fitness_centre;
}