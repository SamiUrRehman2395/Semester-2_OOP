package com.example.cricket;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    ObservableList<Player> players = FXCollections.observableArrayList();
    private final File file = new File("player.txt");

    @Override
    public void start(Stage stage) throws IOException {

        Label name = new Label("Name");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        Label age = new Label("Age");
        TextField ageField = new TextField();
        ageField.setPromptText("Enter Age");

        Label role = new Label("Role");
        RadioButton batsman = new RadioButton("Batsman");
        RadioButton bowler = new RadioButton("Bowler");
        RadioButton allRounder = new RadioButton("All Rounder");
        RadioButton wk = new RadioButton("Wicket Keeper");

        ToggleGroup group = new ToggleGroup();
        batsman.setToggleGroup(group);
        bowler.setToggleGroup(group);
        allRounder.setToggleGroup(group);
        wk.setToggleGroup(group);
        batsman.setSelected(true);
        bowler.setSelected(true);
        allRounder.setSelected(true);

        VBox roleBox = new VBox(batsman, bowler, allRounder,wk);
        roleBox.setSpacing(5);

        Label country = new Label("Country");
        ComboBox<String> countryBox = new ComboBox<>(FXCollections.observableArrayList("Pakistan","India","England","Australia","New Zealand","South Africa","West Indies","Bangladesh","Sri Lanka","Ireland","Zimbabwe","Afghanistan"));
        countryBox.setPromptText("Country");

        Button add = new Button("Add Player");

        Button back = new Button("Back");
        back.setOnAction(event -> {
            stage.close();
        });

        Button view = new Button("View");
        view.setOnAction(e -> {
            try {
                tableView(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(10,10,10,10));

        layout.add(name,0,0);
        layout.add(nameField,1,0);
        layout.add(age,0,1);
        layout.add(ageField,1,1);
        layout.add(role,0,2);
        layout.add(roleBox,1,2);
        layout.add(country,0,3);
        layout.add(countryBox,1,3);
        layout.add(add,0,5);
        layout.add(view,1,5);
        layout.add(back,0,6);

        Scene scene = new Scene(layout,600,400);
        stage.setTitle("Cricket");
        stage.setScene(scene);
        stage.show();



        add.setOnAction(e -> {
            String Name = nameField.getText();
            int Age = Integer.parseInt(ageField.getText());
            String Role = ((RadioButton)group.getSelectedToggle()).getText();
            String Country = countryBox.getValue();


            Player player = new Player(Name,Age,Role,Country);
            players.add(player);

            saveToFile();

            try {
                added(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


        });





    }

    public void saveToFile(){
        try{
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream outData = new ObjectOutputStream(out);
            outData.writeObject(new ArrayList<>(players));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loadFromFile(){
        try{
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream inData = new ObjectInputStream(in);
            List<Player> loadedData = (List<Player>) inData.readObject();

            players.clear();
            players.addAll(loadedData);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void tableView(Stage stage) throws IOException{

        loadFromFile();

        TableView<Player> tableView = new TableView<>();
        tableView.setItems(players);

        TableColumn<Player, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Player, Integer> ageCol = new TableColumn<>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<>("Age"));

        TableColumn<Player, String> roleCol = new TableColumn<>("Role");
        roleCol.setCellValueFactory(new PropertyValueFactory<>("Role"));

        TableColumn<Player, String> countryCol = new TableColumn<>("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory<>("Country"));

        tableView.getColumns().addAll(nameCol, ageCol, roleCol, countryCol);

        Button back = new Button("Back");
        back.setOnAction(e -> {
            try {
                start(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox layout = new VBox(tableView, back);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setSpacing(5);

        Scene scene = new Scene(layout,600,400);
        stage.setTitle("Cricket");
        stage.setScene(scene);
        stage.show();
    }

    public void added(Stage stage) throws IOException{

        Label added = new Label("Player Added Successfully");
        Button addMore = new Button("Add More Player");
        Button viewList = new Button("View Players");
        Button back = new Button("Back");

        addMore.setOnAction(e -> {
            try {
                start(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        viewList.setOnAction(e -> {
            try {
                tableView(stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        back.setOnAction(e -> {
            stage.close();
        });

        HBox hbox = new HBox(addMore,viewList);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);

        VBox vbox = new VBox(added,hbox,back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);

        Scene sc = new Scene(vbox,600,400);
        stage.setTitle("Cricket");
        stage.setScene(sc);
        stage.show();


    }


    public static void main(String[] args) {
        launch();
    }
}