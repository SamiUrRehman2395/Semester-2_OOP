package com.example.electricity_bill;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class HomeScreen  {
    public static void main(String[] args) {
        launch(args);
    }

    public static void home(Stage stage){

        BackgroundImage bg = new BackgroundImage(
                new Image("file:e.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false,true,true)
        );

        MenuBar menuBar = new MenuBar();
        Menu bill = new Menu("Electricity Bill");
        Menu paybill = new Menu("Pay Bill");
        Menu helpMenu = new Menu("Help");
        Menu aboutMenu = new Menu("About");

        menuBar.getMenus().add(bill);
        menuBar.getMenus().add(paybill);
        menuBar.getMenus().add(helpMenu);
        menuBar.getMenus().add(aboutMenu);

        MenuItem cal = new MenuItem("Calculate Bill");
        MenuItem view = new MenuItem("View Latest Bill");
        MenuItem history = new MenuItem("Past Six Months History");

        bill.getItems().add(cal);
        bill.getItems().add(view);
        bill.getItems().add(history);

        cal.setOnAction(event -> {
            Calculate.calculate(stage);
        });

        BorderPane root = new BorderPane();

        root.setTop(menuBar);

        root.setBackground(new Background(bg));

        Scene scene = new Scene(root, 600,400);
        stage.setTitle("Electricity Bill");
        stage.setScene(scene);
        stage.show();





    }

}
