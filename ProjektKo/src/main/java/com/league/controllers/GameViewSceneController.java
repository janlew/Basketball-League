package com.league.controllers;

import com.league.model.Game;
import com.league.model.Player;
import com.league.model.PlayerStats;
import com.league.model.tableViews.GameStatsTable;
import com.league.model.tableViews.LeagueTable;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class GameViewSceneController extends Controller implements Initializable {
    @FXML private Label homeName;
    @FXML private Label pts;
    @FXML private Label awayName;
    @FXML private Label referee;
    @FXML private Label date;

    @FXML private TableView<GameStatsTable> tableView;
    @FXML private TableColumn<GameStatsTable, String> tab1;
    @FXML private TableColumn<GameStatsTable, String> tab2;
    @FXML private TableColumn<GameStatsTable, String> tab3;
    @FXML private TableColumn<GameStatsTable, String> tab4;
    @FXML private TableColumn<GameStatsTable, String> tab5;
    @FXML private TableColumn<GameStatsTable, String> tab6;

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();

    public void backButtonAction (ActionEvent e) throws IOException {
        this.changeScene(e, getBackFromGame());
    }

    private ObservableList<GameStatsTable> gameData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        session.getTransaction().begin();
        tableView.setItems(gameData);

        PlayerCtrl pc = new PlayerCtrl();

        List<PlayerStats> allPS = loadAllData(PlayerStats.class, session);
        List<Game> allGames = loadAllData(Game.class, session);

        for (Game game : allGames) {
            if (game.getGame_id() == getGameID()) {

                homeName.setText(game.getHome().getName());
                pts.setText(game.getTeam1pts() + " - " + game.getTeam2pts());
                awayName.setText(game.getAway().getName());
                if (game.getReferee() == null) {
                    referee.setText("no referee");
                } else {
                    referee.setText(game.getReferee().getName() + " " + game.getReferee().getSurname());
                }
                date.setText(""+ game.getTermin());
            }
        }

        for (PlayerStats ps : allPS) {
            if (ps.getGame().getGame_id() == getGameID()) {

                Button button = new Button("");
                button.setId("btn");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            setPlayerID(ps.getPlayer().getPlayer_id());
                            setLastScene("/gameViewScene.fxml");
                            changeScene(event, "/playerViewScene.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                String fullname = ps.getPlayer().getName() + " " + ps.getPlayer().getSurname();
                GameStatsTable gs = new GameStatsTable(fullname, ps.getPlayer().getTeam().getName(), ps.getPts(), ps.getAst(), ps.getReb(), button);

                tab1.setCellValueFactory(new PropertyValueFactory<>("fullname"));
                tab2.setCellValueFactory(new PropertyValueFactory<>("team"));
                tab3.setCellValueFactory(new PropertyValueFactory<>("points"));
                tab4.setCellValueFactory(new PropertyValueFactory<>("asissts"));
                tab5.setCellValueFactory(new PropertyValueFactory<>("rebounds"));
                tab6.setCellValueFactory(new PropertyValueFactory<>("button"));

                gameData.add(gs);
            }
        }
        session.close();
    }
}
