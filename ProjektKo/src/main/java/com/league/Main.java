package com.league;

import com.league.model.*;
import com.league.utilities.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("/fanMainScene.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/adminMainScene.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//
//        Team t1 = session.get(Team.class, 1);
//        System.out.println(t1.getTeamPlayers().get(0).getPlayer().getPlayerStats().get(0).getPts());
//
//        Player g1 = session.get(Player.class, 1);
//        System.out.println(g1.getPlayerStats().get(0).getAst());
//       session.getTransaction().commit();



        launch(args);
    }
}
