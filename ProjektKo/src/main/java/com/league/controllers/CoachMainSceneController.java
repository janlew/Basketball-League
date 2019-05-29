package com.league.controllers;

import com.league.model.Game;
import com.league.model.Team;
import com.league.model.Training;
import com.league.model.Users;
import com.league.model.tableViews.LeagueTable;
import com.league.model.tableViews.TeamGamesTable;
import com.league.model.tableViews.TrainingTable;
import com.league.utilities.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class CoachMainSceneController extends Controller implements Initializable {

    @FXML
    private TableView<TeamGamesTable> tableView;
    @FXML
    private TableColumn<TeamGamesTable, String> tab1;
    @FXML
    private TableColumn<TeamGamesTable, String> tab2;

    @FXML
    private TableView<TrainingTable> tableView1;
    @FXML
    private TableColumn<TrainingTable, String> tab11;

    @FXML
    private TableView<LeagueTable> tableView2;
    @FXML
    private TableColumn<LeagueTable, String> tab21;
    @FXML
    private TableColumn<LeagueTable, String> tab22;

    @FXML
    DatePicker datePicker;

    private int timID;

    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());


    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();

    public void signOut(ActionEvent e) throws IOException {
        setRoleID(3);
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

    public void myTeam(ActionEvent e) throws IOException {
        setTeamID(timID);
        setLastScene("/coachMainScene.fxml");
        this.changeScene(e, "/teamViewScene.fxml");
        session.close();
    }

    public void addTraining(ActionEvent e) throws IOException {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        Users u = session.get(Users.class, LoginController.loggedUserId);
        Team t = session.get(Team.class, u.getCoach().getTeam().getTeam_id());
        LocalDate dat = datePicker.getValue();
        dat = dat.plusDays(1);
        Date dt = Date.valueOf(dat);
        if (dat != null) {
            Training training = new Training(t, dt);
            session.save(training);
            session.getTransaction().commit();
        } else {
            System.out.println("nie podano terminu");
            session.getTransaction().rollback();
        }
        session.close();
        this.changeScene(e, "/coachMainScene.fxml");
    }

    private ObservableList<TeamGamesTable> gameData = FXCollections.observableArrayList();
    private ObservableList<TrainingTable> trainingData = FXCollections.observableArrayList();
    private ObservableList<LeagueTable> wlData = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        session.getTransaction().begin();
        tableView.setItems(gameData);
        tableView1.setItems(trainingData);
        tableView2.setItems(wlData);
        Users u = session.get(Users.class, LoginController.loggedUserId);
        timID = u.getCoach().getTeam().getTeam_id();

        List<Game> allGames = this.loadAllData(Game.class, session);
        List<Team> allTeams = this.loadAllData(Team.class, session);
        List<Training> allTrainings = this.loadAllData(Training.class, session);
        allGames.sort(Comparator.comparing(Game::getTermin));
        String opp = "";

        for (Team team : allTeams) {
            List<Game> teamGames = new ArrayList<>(team.getHomeGames());
            teamGames.addAll(team.getAwayGames());
            teamGames.sort(Comparator.comparing(Game::getTermin));
            if (u.getCoach().getTeam().getTeam_id() == team.getTeam_id()) {
                for (Game game : teamGames) {
                    if (game.getTermin().after(date) || (game.getTermin().before(date) && game.getTeam1pts() == 0)) {
                        if (game.getAway().getName() == u.getCoach().getTeam().getName()) {
                            opp = game.getHome().getName();
                        } else if (game.getHome().getName() == u.getCoach().getTeam().getName()) {
                            opp = game.getAway().getName();
                        }

                        TeamGamesTable t = new TeamGamesTable(opp, game.getTermin());

                        tab1.setCellValueFactory(new PropertyValueFactory<>("awayName"));
                        tab2.setCellValueFactory(new PropertyValueFactory<>("date"));

                        gameData.add(t);
                    }
                }
                for (Training training : allTrainings) {
                    if (training.getTeam().getTeam_id() == team.getTeam_id()) {
                        if (training.getTermin().after(date)) {
                            TrainingTable tr = new TrainingTable(training.getTermin());

                            tab11.setCellValueFactory(new PropertyValueFactory<>("date"));

                            trainingData.add(tr);
                        }
                    }
                }
                TeamCtrl tc = new TeamCtrl();
                tc.settingWonGames();
                tc.settingLosedGames();

                LeagueTable lt = new LeagueTable(team.getWins(), team.getLoses());
                tab21.setCellValueFactory(new PropertyValueFactory<>("wins"));
                tab22.setCellValueFactory(new PropertyValueFactory<>("loses"));

                wlData.add(lt);
            }
        }
        session.close();
    }

}
