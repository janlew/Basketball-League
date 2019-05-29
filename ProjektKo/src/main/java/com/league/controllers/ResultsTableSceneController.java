package com.league.controllers;

import com.league.model.Game;
import com.league.model.Team;
import com.league.model.tableViews.TeamGamesTable;
import com.league.utilities.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ResultsTableSceneController extends Controller implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private TableView<TeamGamesTable> tableView;
    @FXML
    private TableColumn<TeamGamesTable, String> tab1;
    @FXML
    private TableColumn<TeamGamesTable, String> tab2;
    @FXML
    private TableColumn<TeamGamesTable, String> tab3;
    @FXML
    private TableColumn<TeamGamesTable, String> tab4;
    @FXML
    private TableColumn<TeamGamesTable, String> tab5;
    @FXML
    private TableColumn<TeamGamesTable, String> tab6;

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();
    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    public void backButtonAction (ActionEvent e) throws IOException {
        if (getRoleID() == 1) {
            this.changeScene(e, "/adminMainScene.fxml");
        } else if (getRoleID() == 2) {
            this.changeScene(e, "/coachMainScene.fxml");
        } else {
            this.changeScene(e, "/fanMainScene.fxml");
        }
    }

    private ObservableList<TeamGamesTable> teamData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        session.getTransaction().begin();
        tableView.setItems(teamData);
        List<Team> allTeams = this.loadAllData(Team.class, session);
        List<Game> allGames = this.loadAllData(Game.class, session);
        allGames.sort(Comparator.comparing(Game::getTermin).reversed());

        for (Game game : allGames) {
            if (game.getTermin().before(date) && game.getTeam1pts() != 0) {

                Button button = new Button("x");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            setGameID(game.getGame_id());
                            setBackFromGame("/resultsTableScene.fxml");
                            changeScene(event, "/gameViewScene.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                TeamGamesTable t = new TeamGamesTable(game.getHome().getName(), game.getTeam1pts(), game.getTeam2pts(), game.getAway().getName(), game.getTermin(), button);

                tab1.setCellValueFactory(new PropertyValueFactory<>("homeName"));
                tab2.setCellValueFactory(new PropertyValueFactory<>("homePts"));
                tab3.setCellValueFactory(new PropertyValueFactory<>("awayPts"));
                tab4.setCellValueFactory(new PropertyValueFactory<>("awayName"));
                tab5.setCellValueFactory(new PropertyValueFactory<>("date"));
                tab6.setCellValueFactory(new PropertyValueFactory<>("button"));

                teamData.add(t);
            }
        }
        session.close();
    }

}
