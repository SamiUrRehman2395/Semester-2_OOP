package com.example.fitness_centre;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;

public class HelloApplication extends Application {

    private final ObservableList<Member> members = FXCollections.observableArrayList();

    private final String filePath = "members.txt";

    @Override
    public void start(Stage stage) {

        Image img = new Image(getClass().getResource("/com/example/fitness_centre/images/img.jpg").toExternalForm());

        BackgroundImage bg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false,true,true)
        );

        loadDataFromFile();

        Label label = new Label("Fitness Centre");
        label.setStyle("-fx-font-size: 34px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");

        DropShadow outline = new DropShadow();
        outline.setOffsetX(0);
        outline.setOffsetY(0);
        outline.setColor(Color.BLACK);
        outline.setRadius(3);
        outline.setSpread(1);
        label.setEffect(outline);

        Button addMemberButton = new Button("Add Member");
        Button viewMembersButton = new Button("View Members");

        HBox hbox1 = new HBox(addMemberButton, viewMembersButton);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(40);

        VBox mainMenu = new VBox(label, hbox1);
        mainMenu.setAlignment(Pos.CENTER);
        mainMenu.setSpacing(40);
        mainMenu.setPadding(new Insets(20));

        mainMenu.setBackground(new Background(bg));

        Scene mainScene = new Scene(mainMenu, 600, 400);
        stage.setScene(mainScene);
        stage.setTitle("Fitness Centre");
        stage.show();


        addMemberButton.setOnAction(event ->
                showAddMemberForm(stage));

        viewMembersButton.setOnAction(event ->
                showMembersTable(stage));
    }

    private void showAddMemberForm(Stage stage) {




        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label genderLabel = new Label("Gender:");
        RadioButton maleButton = new RadioButton("Male");
        RadioButton femaleButton = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        maleButton.setToggleGroup(genderGroup);
        femaleButton.setToggleGroup(genderGroup);
        maleButton.setSelected(true);

        VBox v1 = new VBox(maleButton, femaleButton);
        v1.setSpacing(5);

        Label dobLabel = new Label("Date of Birth:");
        DatePicker dobPicker = new DatePicker();

        Label membershipLabel = new Label("Membership Type:");
        ComboBox<String> membershipBox = new ComboBox<>();
        membershipBox.getItems().addAll("Standard", "VIP", "Premium");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {

            String name2 = nameField.getText();
            String gender2 = ((RadioButton)genderGroup.getSelectedToggle()).getText();
            String membershipType2 = membershipBox.getValue();
            String dob2 = String.valueOf(dobPicker.getValue());



            Member member = new Member(name2, gender2, dob2, membershipType2);
            members.add(member);

            saveDataToFile();


            showSuccessWindow(stage);

        });

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> start(stage));

        GridPane formPane = new GridPane();



        formPane.setHgap(10);
        formPane.setVgap(20);
        //formPane.setPadding(new Insets(20));
        formPane.setPadding(new Insets(10,10,10,10));



        formPane.add(nameLabel,0,0);
        formPane.add(nameField,1,0);
        formPane.add(genderLabel,0,1);
        formPane.add(v1,1,1);
        formPane.add(dobLabel,0,2);
        formPane.add(dobPicker,1,2);
        formPane.add(membershipLabel,0,3);
        formPane.add(membershipBox,1,3);

        formPane.add(saveButton,1,5);

        formPane.add(backButton,0,8);


        Scene addMemberScene = new Scene(formPane, 600, 400);
        stage.setScene(addMemberScene);
    }

    private void showMembersTable(Stage stage) {

        loadDataFromFile();

        TableView<Member> tableView = new TableView<>();
        tableView.setItems(members);

        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Member, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Member, String> dobColumn = new TableColumn<>("Date of Birth");
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));

        TableColumn<Member, String> membershipColumn = new TableColumn<>("Membership Type");
        membershipColumn.setCellValueFactory(new PropertyValueFactory<>("membershipType"));

        tableView.getColumns().addAll(nameColumn, genderColumn, dobColumn, membershipColumn);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> start(stage));

        VBox tableLayout = new VBox(tableView, backButton);
        tableLayout.setSpacing(10);
        tableLayout.setPadding(new Insets(20));
        tableLayout.setAlignment(Pos.CENTER);

        Scene tableScene = new Scene(tableLayout, 600, 400);
        stage.setScene(tableScene);
    }

    private void saveDataToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Member member : members) {
                writer.write(member.getName() + "," + member.getGender() + "," +
                        member.getDob() + "," + member.getMembershipType());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadDataFromFile() {
        members.clear(); // Clear existing data
        File file = new File(filePath);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    if (fields.length == 4) {
                        members.add(new Member(fields[0], fields[1], fields[2], fields[3]));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



    private void showSuccessWindow(Stage stage) {

        Label newWindow = new Label("Successfully added member");

        newWindow.setAlignment(Pos.CENTER);

        Button mainmenu = new Button("Main Menu");
        mainmenu.setOnAction(event -> start(stage));


        VBox hBox = new VBox(newWindow, mainmenu);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        Scene sc = new Scene(hBox, 600,400);
        stage.setScene(sc);
        stage.setTitle("Success");
        stage.show();



    }




    public static void main(String[] args) {
        launch();
    }

}
