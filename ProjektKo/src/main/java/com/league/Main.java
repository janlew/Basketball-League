package com.league;

import com.league.model.Roles;
import com.league.model.Users;
import com.league.utilities.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/firstScene.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//        Roles role = new Roles();
//        role.setName("player");
//        session.save(role);
//        session.getTransaction().commit();
//
//        session.beginTransaction();
//        Users user = new Users();
//        user.setUsername("test");
//        user.setPasswrd("test");
//        user.setRole(role);
//        session.save(user);
//       session.getTransaction().commit();

        launch(args);
    }
}
