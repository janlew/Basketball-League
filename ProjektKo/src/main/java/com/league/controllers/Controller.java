package com.league.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.List;

public class Controller {

    public static int teamID;
    public static int roleID = 3;
    public static int gameID;
    public static int playerID;
    public static int coachID;
    public static String lastScene;
    public static String backFromGame;

    public void changeScene(ActionEvent event, String fxml) throws IOException {
        Parent newScene = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(newScene);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public <T> List<T> loadAllData(Class<T> className, Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(className);
        Root<T> rootEntry = cq.from(className);
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public static int getTeamID() {
        return teamID;
    }

    public static void setTeamID(int teamID) {
        Controller.teamID = teamID;
    }

    public static int getRoleID() {
        return roleID;
    }

    public static void setRoleID(int roleID) {
        Controller.roleID = roleID;
    }

    public static int getGameID() {
        return gameID;
    }

    public static void setGameID(int gameID) {
        Controller.gameID = gameID;
    }

    public static String getLastScene() {
        return lastScene;
    }

    public static void setLastScene(String lastScene) {
        Controller.lastScene = lastScene;
    }

    public static int getPlayerID() {
        return playerID;
    }

    public static void setPlayerID(int playerID) {
        Controller.playerID = playerID;
    }

    public static String getBackFromGame() {
        return backFromGame;
    }

    public static void setBackFromGame(String backFromGame) {
        Controller.backFromGame = backFromGame;
    }

    public static int getCoachID() {
        return coachID;
    }

    public static void setCoachID(int coachID) {
        Controller.coachID = coachID;
    }
}
