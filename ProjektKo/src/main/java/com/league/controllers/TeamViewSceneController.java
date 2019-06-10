package com.league.controllers;

import com.league.model.*;
import com.league.model.tableViews.TeamGamesTable;
import com.league.utilities.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TeamViewSceneController extends Controller implements Initializable {

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
    private TableColumn<TeamGamesTable, Button> tab6;

    @FXML
    private TableView<TeamGamesTable> tableView1;
    @FXML
    private TableColumn<TeamGamesTable, String> tab11;
    @FXML
    private TableColumn<TeamGamesTable, String> tab12;
    @FXML
    private TableColumn<TeamGamesTable, String> tab13;

    @FXML
    private Label teamName;
    @FXML
    private Label coachName;

    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();

    public void backButtonAction(ActionEvent e) throws IOException {
        if (lastScene == "/coachMainScene.fxml" && getRoleID() == 2) {
            this.changeScene(e, "/coachMainScene.fxml");
        } else {
            this.changeScene(e, "/leagueTableScene.fxml");
        }
        session.close();
    }

    private ObservableList<TeamGamesTable> teamData = FXCollections.observableArrayList();
    private ObservableList<TeamGamesTable> teamData1 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        session.getTransaction().begin();
        tableView.setItems(teamData);
        tableView1.setItems(teamData1);
        List<Team> allTeams = this.loadAllData(Team.class, session);

        for (Team team : allTeams) {
            List<Game> teamGames = new ArrayList<>(team.getHomeGames());
            teamGames.addAll(team.getAwayGames());
            teamGames.sort(Comparator.comparing(Game::getTermin).reversed());

            if (getTeamID() == team.getTeam_id()) {
                teamName.setText(team.getName());
                if (team.getCoach() == null) {
                    coachName.setText("no coach");
                } else {
                    coachName.setText(team.getCoach().getName() + " " + team.getCoach().getSurname());
                }
                for (Game game : teamGames) {
                    if (game.getTermin().before(date) && game.getTeam1pts() != 0) {

                        Button button = new Button("");
                        button.setId("btn");
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                try {
                                    setGameID(game.getGame_id());
                                    setBackFromGame("/teamViewScene.fxml");
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
                teamGames.sort(Comparator.comparing(Game::getTermin));
                for (Game game : teamGames) {
                    if (game.getTermin().after(date) || (game.getTermin().before(date) && game.getTeam1pts() == 0)) {

                        TeamGamesTable t = new TeamGamesTable(game.getHome().getName(), game.getAway().getName(), game.getTermin());

                        tab11.setCellValueFactory(new PropertyValueFactory<>("homeName"));
                        tab12.setCellValueFactory(new PropertyValueFactory<>("awayName"));
                        tab13.setCellValueFactory(new PropertyValueFactory<>("date"));

                        teamData1.add(t);
                    }
                }
            }
        }
        session.close();
    }


}







































