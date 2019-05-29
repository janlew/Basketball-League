package com.league.controllers;

import com.league.model.Player;
import com.league.model.PlayerStats;
import com.league.model.tableViews.GameStatsTable;
import com.league.model.tableViews.PlayerTable;
import com.league.utilities.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerViewSceneController extends Controller implements Initializable {

    @FXML
    Label fullname;
    @FXML
    Label teamName;
    @FXML
    Label birth;
    @FXML
    Label jersey;
    @FXML
    Label hei;
    @FXML
    Label wei;
    @FXML
    Label pos;

    @FXML
    private TableView<PlayerTable> tableView;
    @FXML
    private TableColumn<PlayerTable, String> tab1;
    @FXML
    private TableColumn<PlayerTable, String> tab2;
    @FXML
    private TableColumn<PlayerTable, String> tab3;

    @FXML
    private TableView<GameStatsTable> tableView1;
    @FXML
    private TableColumn<GameStatsTable, String> tab11;
    @FXML
    private TableColumn<GameStatsTable, String> tab12;
    @FXML
    private TableColumn<GameStatsTable, String> tab13;
    @FXML
    private TableColumn<GameStatsTable, String> tab14;
    @FXML
    private TableColumn<GameStatsTable, String> tab15;

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();

    public void backButtonAction(ActionEvent e) throws IOException {
        this.changeScene(e, getLastScene());
    }

    private ObservableList<PlayerTable> playerData = FXCollections.observableArrayList();
    private ObservableList<GameStatsTable> gameData = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        session.getTransaction().begin();
        tableView.setItems(playerData);
        tableView1.setItems(gameData);

        List<Player> players = this.loadAllData(Player.class, session);
        List<PlayerStats> allStats = this.loadAllData(PlayerStats.class, session);

        PlayerCtrl pc = new PlayerCtrl();
        pc.countRPG();
        pc.countAPG();
        pc.countRPG();
        for (Player player : players) {
            if (player.getPlayer_id() == getPlayerID()) {
                fullname.setText(player.getName() + " " + player.getSurname());
                teamName.setText(player.getTeam().getName());
                pos.setText(player.getPlayerPosition().getAbbrev());
                birth.setText("" + player.getBirth());
                jersey.setText("" + player.getJerseyNum());
                wei.setText("" + player.getWeight());
                hei.setText("" + player.getHeight());

                PlayerTable p = new PlayerTable(player.getPpg(), player.getApg(), player.getRpg());

                tab1.setCellValueFactory(new PropertyValueFactory<>("ppg"));
                tab2.setCellValueFactory(new PropertyValueFactory<>("apg"));
                tab3.setCellValueFactory(new PropertyValueFactory<>("rpg"));

                playerData.add(p);

                for (PlayerStats ps : allStats) {
                    if (ps.getPlayer().getPlayer_id() == player.getPlayer_id()) {
                        String opt;

                        if (player.getTeam().getName() == ps.getGame().getHome().getName()) {
                            opt = ps.getGame().getAway().getName();
                        } else {
                            opt = ps.getGame().getHome().getName();
                        }

                        GameStatsTable gs = new GameStatsTable(opt, ps.getPts(), ps.getAst(), ps.getReb(), ps.getGame().getTermin());
                        tab11.setCellValueFactory(new PropertyValueFactory<>("team"));
                        tab12.setCellValueFactory(new PropertyValueFactory<>("points"));
                        tab13.setCellValueFactory(new PropertyValueFactory<>("asissts"));
                        tab14.setCellValueFactory(new PropertyValueFactory<>("rebounds"));
                        tab15.setCellValueFactory(new PropertyValueFactory<>("date"));

                        gameData.add(gs);
                    }
                }
            }
        }
        session.close();
    }
}
