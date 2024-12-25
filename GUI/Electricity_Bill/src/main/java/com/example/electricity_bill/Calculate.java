package com.example.electricity_bill;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static javafx.application.Application.launch;

public class Calculate {

public static double billAmount =0;
    public static void main(String[] args) {
        launch(args);
    }


    public static void calculate(Stage stage){

//        BackgroundImage bg = new BackgroundImage(
//                new Image("file:e.jpg"),
//                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.CENTER,
//                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false,true,true)
//        );

        Label city = new Label("City");
//        city.setFont(Font.font("Arial", 16)); // Set font and size
//        city.setTextFill(Color.BLACK);



        ComboBox<String> cityBox = new ComboBox<>();
        cityBox.setPromptText("Select City");

        cityBox.getItems().addAll("Karachi", "Lahore","Islamabad","Multan","Faisalabad");

        Label label1 = new Label("Meter Category");
        RadioButton b1 = new RadioButton("Residential");
        b1.setSelected(true);
        RadioButton b2 = new RadioButton("Commercial");
        b2.setSelected(true);

        ToggleGroup group = new ToggleGroup();
        b1.setToggleGroup(group);
        b2.setToggleGroup(group);

        Label label = new Label("Units Consumed");
        TextField unitsBox = new TextField();
        unitsBox.setPromptText("Enter number of Units");
        unitsBox.setMaxWidth(200);

        Button calculate = new Button("Calculate");
        calculate.setOnAction(e -> {

        });

        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(city, cityBox);
        vbox1.setSpacing(10);


        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(label1, b1,b2);
        vbox2.setSpacing(10);

        VBox vbox3 = new VBox();
        vbox3.getChildren().addAll(label, unitsBox);
        vbox3.setSpacing(10);

        VBox vbox4 = new VBox();
        vbox4.getChildren().addAll(calculate);
        vbox4.setSpacing(10);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);
        //vbox.setBackground(new Background(bg));





        vbox.setSpacing(40);
        vbox.setPadding(new Insets(10,10,10,10));

        Scene sc = new Scene(vbox,600,400);
        stage.setTitle("Calculate Bill");
        stage.setScene(sc);
        stage.show();



        calculate.setOnAction(e -> {

            int units = getUnits(unitsBox);

            if(units == -1) return;

            String meterType = getMeterType(b1,b2);

            billAmount = calculateBill(units,meterType);

            String selectedCity = cityBox.getValue();

            //System.out.println(billAmount);
            calculatedScreen(stage,units,meterType,billAmount, selectedCity);

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("bill.txt",true));
                writer.write(  "City: "+selectedCity + "\nUnits Consumed: "+unitsBox.getText() + "\n" + "Meter Category: "+meterType+ "\n" + "Bill Amount: "+billAmount+ "\n"  + "\n");
                writer.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });




    }

    public static void calculatedScreen(Stage stage, int units, String meterType, double billAmount, String cityBox){



        Label label = new Label(  "City: "+cityBox + "\nUnits Consumed: " + units + "\nMeterType: " +meterType + "\nBill Amount: " + billAmount + " Rs" );
        VBox vbox = new VBox();
        vbox.getChildren().addAll(label);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);
        Scene sc = new Scene(vbox,600,400);
        stage.setScene(sc);
        stage.show();
    }



    public static double calculateCommercial(int units){
        double bill = 0;

        if(units <=100){
            bill = units * 40;
        }
        else if(units <=200){
            bill = units * 50;
        }
        else if(units <=400){
            bill = units * 60;
        }
        else{
            bill = units * 80;
        }
        return bill;
    }

    public static double calculateResidential(int units){
        double bill = 0;

        if(units <=100){
            bill = units * 20;
        }
        else if(units <=200){
            bill = units * 30;
        }
        else if(units <=400){
            bill = units * 40;
        }
        else{
            bill = units * 50;
        }
        return bill;
    }

    public static int getUnits(TextField unitsBox){
        return Integer.parseInt(unitsBox.getText().trim());

    }

    public static String getMeterType(RadioButton b1, RadioButton b2){
        if(b1.isSelected()){
            return "Residential";
        }
        else if(b2.isSelected()){
            return "Commercial";
        }
        return null;
    }

    public static double calculateBill(int units, String meterType){
        if("Residential".equals(meterType)){
            return calculateResidential(units);
        }
        else if("Commercial".equals(meterType)){
            return calculateCommercial(units);
        }
        return 0;
    }

}
