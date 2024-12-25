package com.example.electricity_bill;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;

public class Login extends Application {



    public static final String Credentials = "credentials.txt";

    public static void main(String[] args) {
        launch(args);
    }

   private void login(Stage stage) {

       BackgroundImage bg = new BackgroundImage(
               new Image("file:e.jpg"),
               BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
               BackgroundPosition.CENTER,
               new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false,true,true)
       );


       Label username = new Label("Username");

       TextField usernameField = new TextField();
       usernameField.setMaxWidth(300);
       usernameField.setPromptText("Enter Your Username");

       Label id =  new Label("ID");
       TextField idField = new TextField();
       idField.setMaxWidth(300);
       idField.setPromptText("Enter Your ID");

       Button login = new Button("Login");
       login.setOnAction(e -> {

           String user = usernameField.getText();
           String pass = idField.getText();

           try {
               if(validateLogin(user,pass)){
                   HomeScreen.home(stage);
               }
               else{
                   Label l1 = new Label("Invalid Credentials");
               }
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }


       });

       Button cancel = new Button("Cancel");
       cancel.setOnAction(e -> {
           stage.close();
       });

       Button register = new Button("Register");
       register.setOnAction(e -> {
           register(stage);
       });

       HBox hbox = new HBox(login,register);
       hbox.setSpacing(10);
       hbox.setAlignment(Pos.CENTER);



       VBox loginLayout = new VBox();
       loginLayout.getChildren().addAll(username,usernameField,id, idField, hbox,cancel);
       loginLayout.setSpacing(10);
       loginLayout.setAlignment(Pos.CENTER);

       loginLayout.setBackground(new Background(bg));

       Scene loginScene = new Scene(loginLayout, 600,400);
       stage.setScene(loginScene);
       stage.setTitle("Login");
       stage.show();

   }

   public static void register(Stage stage) {
       Label username = new Label("Username");
       TextField usernameField = new TextField();
       usernameField.setMaxWidth(300);
       usernameField.setPromptText("Enter Your Username");

       Label id =  new Label("ID");
       TextField idField = new TextField();
       idField.setMaxWidth(300);
       idField.setPromptText("Set Your ID");

       Button signUp = new Button("Sign Up");

       signUp.setOnAction(e -> {

           String user = usernameField.getText().trim();
           String userId = idField.getText().trim();

           try {
               BufferedWriter writer = new BufferedWriter(new FileWriter("credentials.txt",true));
               writer.write(user+":"+userId);
               writer.newLine();
               writer.close();
           } catch (IOException ex) {
               throw new RuntimeException(ex);
           }
           HomeScreen.home(stage);
       });

       VBox registerLayout = new VBox();
       registerLayout.getChildren().addAll(username,usernameField,id, idField, signUp);
       registerLayout.setSpacing(10);
       registerLayout.setAlignment(Pos.CENTER);
       Scene registerScene = new Scene(registerLayout, 600,400);
       stage.setScene(registerScene);
       stage.setTitle("Register");
       stage.show();
   }

   private boolean validateLogin(String username, String id) throws IOException {

       BufferedReader reader = new BufferedReader(new FileReader(Credentials));
       String line;
       while((line = reader.readLine()) != null){
           String [] credentials = line.split(":");
           if(credentials[0].equals(username) && credentials[1].equals(id)){
               return true;
           }

       }

       return false;
   }

    @Override
    public void start(Stage stage) throws Exception {
        login(stage);
    }

}
