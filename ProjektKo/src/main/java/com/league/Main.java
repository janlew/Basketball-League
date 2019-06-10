package com.league;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fanMainScene.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/adminMainScene.fxml"));
        primaryStage.setTitle("Basketball League");
        primaryStage.getIcons().add(new Image("https://cdn4.iconfinder.com/data/icons/sports-balls/1024/BasketBall.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
