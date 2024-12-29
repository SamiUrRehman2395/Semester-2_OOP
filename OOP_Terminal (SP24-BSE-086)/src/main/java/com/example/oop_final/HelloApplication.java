package com.example.oop_final;



import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HelloApplication extends Application {

    Appliance app;
    final File file = new File("data.txt");
    String filePath = "data.txt";
    ObservableList<Appliance> list = FXCollections.observableArrayList();


    @Override
    public void start(Stage stage) throws IOException {


        Label home = new Label("Smart Home Management System");

        Button add = new Button("Add");

        add.setOnAction(e -> {
            try {
                add(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            Label l1 = new Label("Light Added Successfully");
        });

        Button view = new Button("View and Control Appliances");

        view.setOnAction(e -> {
            try{
                tableView(stage);
            }catch(IOException ex){
                throw new RuntimeException(ex);
            }
        });

//        Label label2 = new Label("Turned on");
//

//
//        BorderPane pane = new BorderPane();
//        pane.setBottom(hbox);

        VBox vbox = new VBox(home,add,view);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);



        Scene scene = new Scene(vbox,600,400);
        stage.setTitle("Smart Home Management System");
        stage.setScene(scene);
        stage.show();


    }

    public void addedSuccessFully(Stage stage) throws IOException {


        Label added = new Label("Added Successfully");
        Button back = new Button("Back");
        back.setOnAction(e -> {
            try {
                add(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox vbox = new VBox(added,back);
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox,600,400);
        stage.setTitle("Smart Home Management System");
        stage.setScene(scene);
        stage.show();

    }

    public void add(Stage stage) throws IOException {

        Label add = new Label("Add a new Appliance");

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Light", "Fan", "Thermostat");

        Button addButton = new Button("Add");
        Button backButton = new Button("Back");

        backButton.setOnAction(e -> {
            try {
                start(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        addButton.setOnAction(e -> {

            String name = comboBox.getValue();


            Appliance appliance = new Appliance(name);
            list.add(appliance);
            //list.add(new Appliance(name));

            saveToFile();

            try {
                addedSuccessFully(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox vbox = new VBox(add,comboBox,addButton,backButton);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox,600,400);
        stage.setTitle("Smart Home Management System");
        stage.setScene(scene);
        stage.show();

    }

//    public void saveToFile(){
//
//        try{
//            FileOutputStream data = new FileOutputStream(file);
//            ObjectOutputStream data1 = new ObjectOutputStream(data);
//            data1.writeObject(list);
//


    public void saveToFile(){
        try{
            FileOutputStream out = new FileOutputStream("data.txt");
            ObjectOutputStream outData = new ObjectOutputStream(out);
            outData.writeObject(new ArrayList<>(list));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        try{
            FileInputStream in = new FileInputStream("data.txt");
            ObjectInputStream inData = new ObjectInputStream(in);
            List<Appliance> loadedData = (List<Appliance>) inData.readObject();

            list.clear();
            list.addAll(loadedData);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



//    public void checkState(Stage stage) throws IOException{
//
////        loadFromFile();
//
//        RadioButton on = new RadioButton("On");
//        RadioButton off = new RadioButton("off");
//
//        ToggleGroup group = new ToggleGroup();
//        on.setToggleGroup(group);
//        off.setToggleGroup(group);
//        String value = ((RadioButton)group.getSelectedToggle()).getText();
//
//
//
//
//        TableView<Appliance> tableView = new TableView<>();
//        tableView.setItems(list);
//
////        TableColumn<Appliance, String> nameCol = new TableColumn<>("Name");
////        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//
////        tableView.getColumns().add(nameCol);
//
////        TableColumn<Appliance,String> tableColumn = new TableColumn<>("Name");
////        tableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//        TableColumn<Appliance,String> tableColumn2 = new TableColumn<>("State");
//        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("value"));
//
//        tableView.getColumns().addAll(tableColumn2);
//
//
//
//
//
//
//        HBox hbox = new HBox(on,off);
//        hbox.setSpacing(5);
//        hbox.setAlignment(Pos.CENTER);
//
//
//        Button back = new Button("Back");
//        back.setOnAction(e -> {
//            try {
//                start(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        VBox layout = new VBox(tableView,hbox, back);
//        layout.setPadding(new Insets(10,10,10,10));
//        layout.setSpacing(5);
//
//
//        on.setOnAction(e-> {
////            try {
////                turnedOn(stage);
////            } catch (IOException ex) {
////                throw new RuntimeException(ex);
////            }
////            Label turnedOn = new Label("Turned On");
//        });
//
//        off.setOnAction(e->{
////            try {
////                turnedOff(stage);
////            } catch (IOException ex) {
////                throw new RuntimeException(ex);
////            }
//            Label turnedoff = new Label("Turned Off");
//        });
//
//
//        if (on.isSelected()) {
//            turnedOn(stage);
//        } else if (off.isSelected()) {
//            turnedOff(stage);
//        }
//
//
//
//
//
//        Scene scene = new Scene(layout,600,400);
//        stage.setTitle("Smart Home Management System");
//        stage.setScene(scene);
//        stage.show();
//    }





    public void tableView(Stage stage) throws IOException {
        loadFromFile();

        TableView<Appliance> tableView = new TableView<>();
        tableView.setItems(list);

        TableColumn<Appliance, String> nameColumn = new TableColumn<>("Appliance");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Appliance, String> stateColumn = new TableColumn<>("State");
        stateColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStateAsString()));

        TableColumn<Appliance, Void> actionColumn = new TableColumn<>("Action");
        actionColumn.setCellFactory(col -> new TableCell<>() {

             Button toggleButton = new Button("On/Off");

            {
                toggleButton.setOnAction(e -> {
                    Appliance appliance = getTableView().getItems().get(getIndex());

                    appliance.setState(!appliance.getState());
                    saveToFile();


                    tableView.refresh();
                });
            }


            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(toggleButton);
                }


            }


        });

        tableView.getColumns().addAll(nameColumn, stateColumn, actionColumn);

        Button backButton = new Button("Back");


        backButton.setOnAction(e -> {
            try {
                start(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox layout = new VBox(tableView, backButton);
        layout.setSpacing(10);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 600, 400);
        stage.setTitle("Smart Home Management System");
        stage.setScene(scene);
        stage.show();
    }



//    public void turnedOn(Stage stage) throws IOException{
//
//        Label l2 = new Label("Turned On");
//        Button back = new Button("Back");
//
//        back.setOnAction(e -> {
//            try {
//                tableView(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        VBox vbox = new VBox(l2,back);
//        vbox.setSpacing(10);
//        vbox.setAlignment(Pos.CENTER);
//        Scene scene = new Scene(vbox,300,100);
//        stage.setTitle("Smart Home Management System");
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//    public void turnedOff(Stage stage) throws IOException{
//
//
//        Label l2 = new Label("Turned Off");
//
//        Button back = new Button("Back");
//        back.setOnAction(e -> {
//            try {
//                tableView(stage);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//        VBox vbox = new VBox(l2,back);
//        vbox.setSpacing(10);
//        vbox.setAlignment(Pos.CENTER);
//        Scene scene = new Scene(vbox,300,100);
//        stage.setTitle("Smart Home Management System");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//
//
//    public void controlAppliances(Stage stage) throws IOException {
//
//        Label control = new Label("Control Appliances");
//
//        loadFromFile();
//
//        ListView<Appliance> appliances = new ListView<>();
//
//
//        appliances.setItems(list);
//
//        appliances.getItems();
//
//        VBox layout = new VBox(control,appliances);
//        layout.setPadding(new Insets(10,10,10,10));
//        Scene scene = new Scene(layout,600,400);
//        stage.setTitle("Smart Home Management System");
//        stage.setScene(scene);
//        stage.show();
//
//    }

    public static void main(String[] args) {
        launch();
    }
}