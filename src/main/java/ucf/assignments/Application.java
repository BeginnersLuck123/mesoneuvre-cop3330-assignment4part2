package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Dynie Mesoneuvre
 */
public class Application extends javafx.application.Application {
    @Override
    //sets up the beginning screen
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(root);
        //establishes title of the application
        stage.setTitle("TO-DO APP");
        stage.setScene(scene);
        //displays application
        stage.show();
    }

    //launches application
    public static void main(String[] args) {

        launch();
    }
}