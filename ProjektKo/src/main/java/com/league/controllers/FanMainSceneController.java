package com.league.controllers;

import com.league.utilities.HibernateUtil;
import javafx.event.ActionEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class FanMainSceneController extends Controller {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = HibernateUtil.getSessionFactory().openSession();

    public void signIn(ActionEvent e) throws IOException {
        this.changeScene(e, "/loginScene.fxml");
    }

    public void checkStandings(ActionEvent e) throws IOException {
        this.changeScene(e, "/leagueTableScene.fxml");
    }

    public void checkResults(ActionEvent e) throws IOException {
        this.changeScene(e, "/resultsTableScene.fxml");
    }

    public void checkPlayers(ActionEvent e) throws IOException {
        this.changeScene(e, "/playersTableScene.fxml");
    }

}
