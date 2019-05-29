package com.league.controllers;

import com.league.model.tableViews.LeagueTable;
import com.league.model.Team;
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
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class LeagueTableSceneController extends Controller implements Initializable {

    @FXML
    private TableView<LeagueTable> tableView;
    @FXML
    private TableColumn<LeagueTable, String> tab1;
    @FXML
    private TableColumn<LeagueTable, String> tab2;
    @FXML
    private TableColumn<LeagueTable, String> tab3;
    @FXML
    private TableColumn<LeagueTable, String> tab4;
    @FXML
    private TableColumn<LeagueTable, String> tab5;
    @FXML
    private TableColumn<LeagueTable, String> tab6;
    @FXML
    private TableColumn<LeagueTable, String> tab61;
    @FXML
    private TableColumn<LeagueTable, String> tab62;
    @FXML
    private TableColumn<LeagueTable, String> tab7;
    @FXML
    private TableColumn<LeagueTable, String> tab8;
    @FXML
    private TableColumn<LeagueTable, Button> tab9;

    @FXML
    private Button backButton;

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();

    public void backButtonAction(ActionEvent e) throws IOException {
        if (getRoleID() == 1) {
            this.changeScene(e, "/adminMainScene.fxml");
        } else if (getRoleID() == 2) {
            this.changeScene(e, "/coachMainScene.fxml");
        } else {
            this.changeScene(e, "/fanMainScene.fxml");
        }
    }

    private ObservableList<LeagueTable> teamData = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        session.getTransaction().begin();
        tableView.setItems(teamData);

        List<Team> allTeams = this.loadAllData(Team.class, session);

        TeamCtrl tc = new TeamCtrl();
        tc.settingGamePlayed();
        tc.settingWonGames();
        tc.settingLosedGames();
        tc.settingWinPerc();
        tc.settingTeamPts();
        tc.settingPts();

        allTeams.sort(Comparator.comparing(Team::getPts).reversed());


        int i = 1;
        for (Team team : allTeams) {

            Button button = new Button("x");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        setTeamID(team.getTeam_id());
                        setLastScene("/leagueTableScene.fxml");
                        changeScene(event, "/teamViewScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            LeagueTable t = new LeagueTable(i, team.getName(), team.getGamesPlayed(), team.getWins(), team.getLoses(), team.getPtsGained(), team.getPtsLosed(), team.getWinP(), team.getPts(), button);

            tab1.setCellValueFactory(new PropertyValueFactory<>("standing"));
            tab2.setCellValueFactory(new PropertyValueFactory<>("name"));
            tab3.setCellValueFactory(new PropertyValueFactory<>("matchesPlayed"));
            tab4.setCellValueFactory(new PropertyValueFactory<>("wins"));
            tab5.setCellValueFactory(new PropertyValueFactory<>("loses"));
            tab61.setCellValueFactory(new PropertyValueFactory<>("ptsGained"));
            tab62.setCellValueFactory(new PropertyValueFactory<>("ptsLosed"));
            tab7.setCellValueFactory(new PropertyValueFactory<>("winPerc"));
            tab8.setCellValueFactory(new PropertyValueFactory<>("pts"));
            tab9.setCellValueFactory(new PropertyValueFactory<>("button"));

            teamData.add(t);
            i++;
        }

        session.close();
    }


}

























































