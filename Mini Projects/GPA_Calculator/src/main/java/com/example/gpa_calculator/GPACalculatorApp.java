package com.example.gpa_calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.collections.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class GPACalculatorApp extends Application {

    private TextField courseNameField;
    private TextField creditHoursField;
    private TextField marksField;
    private Label cumulativeGPALabel;
    private TableView<Course> courseTable;
    private ObservableList<Course> courseList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GPA Calculator");

        // Input fields
        Label courseNameLabel = new Label("Course Name:");
        courseNameLabel.setFont(new Font("Arial", 14));
        courseNameLabel.setTextFill(Color.WHITE);

        courseNameField = new TextField();

        Label creditHoursLabel = new Label("Credit Hours:");
        creditHoursLabel.setFont(new Font("Arial", 14));
        creditHoursLabel.setTextFill(Color.WHITE);

        creditHoursField = new TextField();

        Label marksLabel = new Label("Obtained Marks:");
        marksLabel.setFont(new Font("Arial", 14));
        marksLabel.setTextFill(Color.WHITE);

        marksField = new TextField();

        Button addCourseButton = new Button("Add Course");
        styleButton(addCourseButton);
        addCourseButton.setOnAction(e -> addCourse());

        Button calculateGPAButton = new Button("Calculate SGPA");
        styleButton(calculateGPAButton);
        calculateGPAButton.setOnAction(e -> calculateCumulativeGPA());

        Button resetButton = new Button("Reset");
        styleButton(resetButton);
        resetButton.setOnAction(e -> resetFields());

        // Table to display courses
        courseTable = new TableView<>();
        courseList = FXCollections.observableArrayList();

        TableColumn<Course, String> courseCol = new TableColumn<>("Course");
        courseCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCourseName()));

        TableColumn<Course, Integer> creditCol = new TableColumn<>("Credit Hours");
        creditCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getCreditHours()).asObject());

        TableColumn<Course, Integer> marksCol = new TableColumn<>("Marks");
        marksCol.setCellValueFactory(data -> new javafx.beans.property.SimpleIntegerProperty(data.getValue().getMarks()).asObject());

        TableColumn<Course, String> gradeCol = new TableColumn<>("Grade");
        gradeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getGrade()));

        TableColumn<Course, Double> gpaCol = new TableColumn<>("GPA");
        gpaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleDoubleProperty(data.getValue().getGpa()).asObject());

        TableColumn<Course, Void> deleteCol = new TableColumn<>();
        deleteCol.setCellFactory(param -> new TableCell<>() {
            private final Button deleteButton = new Button("x");
            {
                deleteButton.setStyle("-fx-background-color: #f62c2c; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 1px 6px; -fx-background-radius: 100;");
                deleteButton.setOnMouseEntered(e -> deleteButton.setStyle("-fx-background-color: #d31a1a; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 1px 6px; -fx-background-radius: 100;"));
                deleteButton.setOnMouseExited(e -> deleteButton.setStyle("-fx-background-color: #f62c2c; -fx-text-fill: white;  -fx-font-weight: bold; -fx-padding: 1px 6px; -fx-background-radius: 100;"));
                deleteButton.setOnAction(e -> getTableView().getItems().remove(getIndex()));
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(deleteButton);
                }
            }
        });

        courseTable.getColumns().addAll(courseCol, creditCol, marksCol, gradeCol, gpaCol, deleteCol);
        courseTable.setItems(courseList);
        //courseTable.setStyle("-fx-table-cell-border-color: transparent; -fx-background-color: #E6F7FF;");

        // Cumulative GPA label
        cumulativeGPALabel = new Label("SGPA: 0.00");
        cumulativeGPALabel.setFont(new Font("Arial Bold", 16));
        cumulativeGPALabel.setTextFill(Color.DARKGREEN);

        // Layout
        GridPane inputGrid = new GridPane();
        inputGrid.setPadding(new Insets(10));
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.add(courseNameLabel, 0, 0);
        inputGrid.add(courseNameField, 1, 0);
        inputGrid.add(creditHoursLabel, 0, 1);
        inputGrid.add(creditHoursField, 1, 1);
        inputGrid.add(marksLabel, 0, 2);
        inputGrid.add(marksField, 1, 2);
        inputGrid.add(addCourseButton, 0, 3);
        inputGrid.add(calculateGPAButton, 1, 3);
        inputGrid.add(resetButton, 2, 3);

        VBox root = new VBox(10, inputGrid, courseTable, cumulativeGPALabel);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #07274f, #1e5bad,white);");

        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void styleButton(Button button) {
        button.setStyle("-fx-background-color: #e1c61a; -fx-text-fill: white; -fx-font-size: 13px; -fx-font-weight: bold; -fx-padding: 5px 8px; -fx-background-radius: 5;");
       button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #c4aa2c; -fx-text-fill: white; -fx-font-size: 13px; -fx-font-weight: bold; -fx-padding: 5px 8px; -fx-background-radius: 5;"));
       button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #e1c61a; -fx-text-fill: white; -fx-font-size: 13px; -fx-font-weight: bold; -fx-padding: 5px 8px; -fx-background-radius: 5;"));
    }

    private void addCourse() {
        try {
            String courseName = courseNameField.getText();
            int creditHours = Integer.parseInt(creditHoursField.getText());
            int marks = Integer.parseInt(marksField.getText());

            if (marks < 0 || marks > 100) {
                showAlert("Invalid Input", "Marks should be between 0 and 100.");
                return;
            }

            Course newCourse = new Course(courseName, creditHours, marks);
            courseList.add(newCourse);

            courseNameField.clear();
            creditHoursField.clear();
            marksField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter valid numbers for credit hours and marks.");
        }
    }

    private void resetFields() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Reset Confirmation");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Are you sure you want to reset all the fields?");

        ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);

        confirmationAlert.getButtonTypes().setAll(yesButton, noButton);

        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == yesButton) {
                courseNameField.clear();
                creditHoursField.clear();
                marksField.clear();
                courseList.clear();
                cumulativeGPALabel.setText("SGPA: 0.00");
            }
        });
    }

    private void calculateCumulativeGPA() {
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Course course : courseList) {
            totalGradePoints += course.getGpa() * course.getCreditHours();
            totalCredits += course.getCreditHours();
        }

        double cumulativeGPA = totalCredits == 0 ? 0 : totalGradePoints / totalCredits;
        cumulativeGPALabel.setText(String.format("SGPA: %.2f", cumulativeGPA));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}