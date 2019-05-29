package com.league.controllers;

import com.league.model.Player;
import com.league.model.tableViews.LeagueTable;
import com.league.model.tableViews.PlayerTable;
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
import java.util.List;
import java.util.ResourceBundle;

public class PlayerTableSceneController extends Controller implements Initializable {

    @FXML
    private TableView<PlayerTable> tableView;
    @FXML private TableColumn<PlayerTable, String> tab1;
    @FXML private TableColumn<PlayerTable, String> tab2;
    @FXML private TableColumn<PlayerTable, String> tab3;
    @FXML private TableColumn<PlayerTable, String> tab4;
    @FXML private TableColumn<PlayerTable, String> tab5;
    @FXML private TableColumn<PlayerTable, String> tab6;

    @FXML private Button backButton;

    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();

    public void backButtonAction (ActionEvent e) throws IOException {
        if (getRoleID() == 1) {
            this.changeScene(e, "/adminMainScene.fxml");
        } else if (getRoleID() == 2) {
            this.changeScene(e, "/coachMainScene.fxml");
        } else {
            this.changeScene(e, "/fanMainScene.fxml");
        }
    }

    private ObservableList<PlayerTable> playerData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        session.getTransaction().begin();
        tableView.setItems(playerData);

        PlayerCtrl pc = new PlayerCtrl();
        pc.countPPG();
        pc.countAPG();
        pc.countRPG();

        List<Player> allPlayers = this.loadAllData(Player.class, session);

        for (Player player : allPlayers) {
            Button button = new Button("x");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        setPlayerID(player.getPlayer_id());
                        setLastScene("/playersTableScene.fxml");
                        changeScene(event, "/playerViewScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            String fullname = player.getName() + " " + player.getSurname();
            PlayerTable p = new PlayerTable(fullname, player.getPpg(), player.getApg(), player.getRpg(), player.getTeam().getName(), button);

            tab1.setCellValueFactory(new PropertyValueFactory<>("fullname"));
            tab2.setCellValueFactory(new PropertyValueFactory<>("ppg"));
            tab3.setCellValueFactory(new PropertyValueFactory<>("apg"));
            tab4.setCellValueFactory(new PropertyValueFactory<>("rpg"));
            tab5.setCellValueFactory(new PropertyValueFactory<>("teamName"));
            tab6.setCellValueFactory(new PropertyValueFactory<>("button"));


            playerData.add(p);
        }
        session.close();
    }
}
