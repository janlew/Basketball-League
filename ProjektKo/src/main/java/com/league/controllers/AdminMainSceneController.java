package com.league.controllers;

import com.league.model.*;

import com.league.model.tableViews.*;
import com.league.utilities.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Ref;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AdminMainSceneController extends Controller implements Initializable {

    public void signOut(ActionEvent e) throws IOException {
        setRoleID(3);
        this.changeScene(e, "/loginScene.fxml");
    }

    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem coachItem;
    @FXML
    private MenuItem playerItem;
    @FXML
    private MenuItem gameItem;
    @FXML
    private MenuItem playerStatsItem;
    @FXML
    private MenuItem refereeItem;
    @FXML
    private MenuItem teamItem;
    @FXML
    private MenuItem trainingItem;
    @FXML
    private MenuItem usersItem;

    @FXML
    private TableView<ACoachTable> coachTableView;
    @FXML
    private TableColumn<ACoachTable, String> coachTab1;
    @FXML
    private TableColumn<ACoachTable, String> coachTab2;
    @FXML
    private TableColumn<ACoachTable, String> coachTab3;
    @FXML
    private TableColumn<ACoachTable, String> coachTab4;
    @FXML
    private TableColumn<ACoachTable, String> coachTab5;
    @FXML
    private TableColumn<ACoachTable, String> coachTab6;
    @FXML
    private Button addCoach;

    @FXML
    private TableView<APlayerTable> playerTableView;
    @FXML
    private TableColumn<APlayerTable, String> playerTab1;
    @FXML
    private TableColumn<APlayerTable, String> playerTab2;
    @FXML
    private TableColumn<APlayerTable, String> playerTab3;
    @FXML
    private TableColumn<APlayerTable, String> playerTab4;
    @FXML
    private TableColumn<APlayerTable, String> playerTab5;
    @FXML
    private TableColumn<APlayerTable, String> playerTab6;
    @FXML
    private TableColumn<APlayerTable, String> playerTab7;
    @FXML
    private TableColumn<APlayerTable, String> playerTab8;
    @FXML
    private TableColumn<APlayerTable, String> playerTab9;
    @FXML
    private TableColumn<APlayerTable, String> playerTab10;
    @FXML
    private TableColumn<APlayerTable, String> playerTab11;
    @FXML
    private Button addPlayer;

    @FXML
    private TableView<AGameTable> gameTableView;
    @FXML
    private TableColumn<AGameTable, String> gameTab1;
    @FXML
    private TableColumn<AGameTable, String> gameTab2;
    @FXML
    private TableColumn<AGameTable, String> gameTab3;
    @FXML
    private TableColumn<AGameTable, String> gameTab4;
    @FXML
    private TableColumn<AGameTable, String> gameTab5;
    @FXML
    private TableColumn<AGameTable, String> gameTab6;
    @FXML
    private TableColumn<AGameTable, String> gameTab7;
    @FXML
    private TableColumn<AGameTable, String> gameTab8;
    @FXML
    private TableColumn<AGameTable, String> gameTab9;
    @FXML
    private Button addGame;

    @FXML
    private TableView<APlayerStats> psTableView;
    @FXML
    private TableColumn<APlayerStats, String> psTab1;
    @FXML
    private TableColumn<APlayerStats, String> psTab2;
    @FXML
    private TableColumn<APlayerStats, String> psTab3;
    @FXML
    private TableColumn<APlayerStats, String> psTab4;
    @FXML
    private TableColumn<APlayerStats, String> psTab5;
    @FXML
    private TableColumn<APlayerStats, String> psTab6;
    @FXML
    private TableColumn<APlayerStats, String> psTab7;
    @FXML
    private TableColumn<APlayerStats, String> psTab8;
    @FXML
    private Button addPS;

    @FXML
    private TableView<ARefereeTable> refTableView;
    @FXML
    private TableColumn<ARefereeTable, String> refTab1;
    @FXML
    private TableColumn<ARefereeTable, String> refTab2;
    @FXML
    private TableColumn<ARefereeTable, String> refTab3;
    @FXML
    private TableColumn<ARefereeTable, String> refTab4;
    @FXML
    private TableColumn<ARefereeTable, String> refTab5;
    @FXML
    private Button addRef;

    @FXML
    private TableView<ATeamTable> teamTableView;
    @FXML
    private TableColumn<ATeamTable, String> teamTab1;
    @FXML
    private TableColumn<ATeamTable, String> teamTab2;
    @FXML
    private TableColumn<ATeamTable, String> teamTab3;
    @FXML
    private TableColumn<ATeamTable, String> teamTab4;
    @FXML
    private TableColumn<ATeamTable, String> teamTab5;
    @FXML
    private Button addTeam;

    @FXML
    private TableView<ATrainingTable> trainingTableView;
    @FXML
    private TableColumn<ATrainingTable, String> trainingTab1;
    @FXML
    private TableColumn<ATrainingTable, String> trainingTab2;
    @FXML
    private TableColumn<ATrainingTable, String> trainingTab3;
    @FXML
    private TableColumn<ATrainingTable, String> trainingTab4;
    @FXML
    private TableColumn<ATrainingTable, String> trainingTab5;
    @FXML
    private Button addTraining;

    @FXML
    private TableView<AUsersTable> usersTableView;
    @FXML
    private TableColumn<AUsersTable, String> userTab1;
    @FXML
    private TableColumn<AUsersTable, String> userTab2;
    @FXML
    private TableColumn<AUsersTable, String> userTab3;
    @FXML
    private TableColumn<AUsersTable, String> userTab4;
    @FXML
    private TableColumn<AUsersTable, String> userTab5;
    @FXML
    private TableColumn<AUsersTable, String> userTab6;
    @FXML
    private Button addUser;

    @FXML
    private TextField edit1;
    @FXML
    private TextField edit2;
    @FXML
    private TextField edit3;
    @FXML
    private TextField edit4;
    @FXML
    private TextField edit5;
    @FXML
    private TextField edit6;
    @FXML
    private TextField edit7;
    @FXML
    private TextField edit8;


    private ObservableList<ACoachTable> coachData = FXCollections.observableArrayList();
    private ObservableList<APlayerTable> playerData = FXCollections.observableArrayList();
    private ObservableList<AGameTable> gameData = FXCollections.observableArrayList();
    private ObservableList<APlayerStats> psData = FXCollections.observableArrayList();
    private ObservableList<ARefereeTable> refData = FXCollections.observableArrayList();
    private ObservableList<ATeamTable> teamData = FXCollections.observableArrayList();
    private ObservableList<ATrainingTable> trainingData = FXCollections.observableArrayList();
    private ObservableList<AUsersTable> usersData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        List<Coach> allCoaches = this.loadAllData(Coach.class, session);
        List<Player> allPlayers = this.loadAllData(Player.class, session);
        List<PlayerPosition> allPos = this.loadAllData(PlayerPosition.class, session);
        List<Game> allGames = this.loadAllData(Game.class, session);
        List<Team> allTeams = this.loadAllData(Team.class, session);
        List<Users> allUsers = this.loadAllData(Users.class, session);
        List<Referee> allRefs = this.loadAllData(Referee.class, session);
        List<PlayerStats> allStats = this.loadAllData(PlayerStats.class, session);
        List<Training> allTrainings = this.loadAllData(Training.class, session);
        List<Roles> allRoles = this.loadAllData(Roles.class, session);
        session.close();


        //COACH//////////////////////////////////////////////
        coachItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                coachTableView.setVisible(true);
                addCoach.setVisible(true);
                coachTableView.setItems(coachData);
                edit1.setPromptText("users_id");
                edit1.setVisible(true);
                edit2.setPromptText("name");
                edit2.setVisible(true);
                edit3.setPromptText("surname");
                edit3.setVisible(true);
                edit4.setVisible(false);
                edit5.setVisible(false);
                edit6.setVisible(false);
                edit7.setVisible(false);
                edit8.setVisible(false);

                playerTableView.setVisible(false);
                addPlayer.setVisible(false);
                gameTableView.setVisible(false);
                addGame.setVisible(false);
                psTableView.setVisible(false);
                addPS.setVisible(false);
                refTableView.setVisible(false);
                addRef.setVisible(false);
                teamTableView.setVisible(false);
                addTeam.setVisible(false);
                trainingTableView.setVisible(false);
                addTraining.setVisible(false);
                usersTableView.setVisible(false);
                addUser.setVisible(false);
            }
        });

        addCoach.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session1 = factory.getCurrentSession();
                    session1.getTransaction().begin();
                    for (Users u : allUsers) {
                        if (Integer.parseInt(edit1.getText()) == u.getUsers_id()) {
                            if (edit2.getText().matches("[A-Z][a-z]+") && edit3.getText().matches("[A-Z][a-z]+")) {
                                Coach c = new Coach(u, edit2.getText(), edit3.getText());
                                session1.save(c);
                            }
                        }
                    }
                    session1.getTransaction().commit();
                    session1.close();
                    changeScene(event, "/adminMainScene.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Coach coach : allCoaches) {
            Button editButton = new Button("");
            editButton.setId("edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (edit1.getText().length() > 0) {
                            for (Users user : allUsers) {
                                if (Integer.parseInt(edit1.getText()) == user.getUsers_id()) {
                                    coach.setUser(allUsers.get(user.getUsers_id() - 1));
                                }
                            }
                        }
                        if (edit2.getText().length() > 0) {
                            coach.setName(edit2.getText());
                        }
                        if (edit3.getText().length() > 0) {
                            coach.setSurname(edit3.getText());
                        }
                        session.update(coach);
                        session.getTransaction().commit();
                        session.close();
                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Button deleteButton = new Button("");
            deleteButton.setId("delete");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (coach.getTeam() != null) {
                            for (Team team : allTeams) {
                                if (team.getCoach() == coach) {
                                    team.setCoach(null);
                                    session.update(team);
                                }
                            }
                        }
                        session.delete(coach);
                        session.getTransaction().commit();
                        session.close();

                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            ACoachTable ac;
            if (coach.getUser() == null) {
                ac = new ACoachTable(coach.getCoach_id(), null, coach.getName(), coach.getSurname(), editButton, deleteButton);
            } else {
                ac = new ACoachTable(coach.getCoach_id(), coach.getUser().getUsers_id(), coach.getName(), coach.getSurname(), editButton, deleteButton);
            }
            coachTab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            coachTab2.setCellValueFactory(new PropertyValueFactory<>("users_id"));
            coachTab3.setCellValueFactory(new PropertyValueFactory<>("name"));
            coachTab4.setCellValueFactory(new PropertyValueFactory<>("surname"));
            coachTab5.setCellValueFactory(new PropertyValueFactory<>("edit"));
            coachTab6.setCellValueFactory(new PropertyValueFactory<>("delete"));
            coachData.add(ac);
        }
        ///////////////////////////////////
        //PLAYER///////////////////////////
        playerItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playerTableView.setVisible(true);
                addPlayer.setVisible(true);
                playerTableView.setItems(playerData);
                edit1.setPromptText("pos_id");
                edit1.setVisible(true);
                edit2.setPromptText("team_id");
                edit2.setVisible(true);
                edit3.setPromptText("name");
                edit3.setVisible(true);
                edit4.setPromptText("surname");
                edit4.setVisible(true);
                edit5.setPromptText("birth");
                edit5.setVisible(true);
                edit6.setPromptText("height");
                edit6.setVisible(true);
                edit7.setPromptText("weight");
                edit7.setVisible(true);
                edit8.setPromptText("jerseyNum");
                edit8.setVisible(true);

                coachTableView.setVisible(false);
                addCoach.setVisible(false);
                gameTableView.setVisible(false);
                addGame.setVisible(false);
                psTableView.setVisible(false);
                addPS.setVisible(false);
                refTableView.setVisible(false);
                addRef.setVisible(false);
                teamTableView.setVisible(false);
                addTeam.setVisible(false);
                trainingTableView.setVisible(false);
                addTraining.setVisible(false);
                usersTableView.setVisible(false);
                addUser.setVisible(false);
            }
        });

        addPlayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session1 = factory.getCurrentSession();
                    session1.getTransaction().begin();

                    LocalDate dat = Date.valueOf(edit5.getText()).toLocalDate();
                    dat = dat.plusDays(1);
                    for (PlayerPosition pos : allPos) {
                        if (pos.getPlayerPosition_id() == Integer.parseInt(edit1.getText())) {
                            for (Team team : allTeams) {
                                if (team.getTeam_id() == Integer.parseInt(edit2.getText())) {
                                    Player p = new Player(pos, team, edit3.getText(), edit4.getText(), Date.valueOf(dat),
                                            Float.parseFloat(edit6.getText()), Float.parseFloat(edit7.getText()), Integer.parseInt(edit8.getText()));
                                    p.setPpg("0");
                                    p.setApg("0");
                                    p.setRpg("0");
                                    session1.save(p);
                                }
                            }
                        }
                    }
                    session1.getTransaction().commit();
                    session1.close();
                    changeScene(event, "/adminMainScene.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Player player : allPlayers) {

            Button editButton = new Button("");
            editButton.setId("edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();

                        if (edit1.getText().length() > 0) {
                            for (PlayerPosition pos : allPos) {
                                if (pos.getPlayerPosition_id() == Integer.parseInt(edit1.getText())) {
                                    player.setPlayerPosition(pos);
                                }
                            }
                        }
                        if (edit2.getText().length() > 0) {
                            for (Team team : allTeams) {
                                if (team.getTeam_id() == Integer.parseInt(edit2.getText())) {
                                    player.setTeam(team);
                                }
                            }
                        }
                        if (edit3.getText().length() > 0) {
                            player.setName(edit3.getText());
                        }
                        if (edit4.getText().length() > 0) {
                            player.setSurname(edit4.getText());
                        }
                        if (edit5.getText().length() > 0) {
                            LocalDate dat = Date.valueOf(edit5.getText()).toLocalDate();
                            dat = dat.plusDays(1);
                            player.setBirth(Date.valueOf(dat));
                        }
                        if (edit6.getText().length() > 0) {
                            player.setHeight(Float.parseFloat(edit6.getText()));
                        }
                        if (edit7.getText().length() > 0) {
                            player.setWeight(Float.parseFloat(edit7.getText()));
                        }
                        if (edit8.getText().length() > 0) {
                            player.setJerseyNum(Integer.parseInt(edit8.getText()));
                        }
                        session.update(player);
                        session.getTransaction().commit();
                        session.close();
                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Button deleteButton = new Button("");
            deleteButton.setId("delete");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        session.delete(player);
                        session.getTransaction().commit();
                        session.close();

                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            APlayerTable ap = new APlayerTable(player.getPlayer_id(), player.getPlayerPosition().getPlayerPosition_id(), player.getTeam().getTeam_id(), player.getName(),
                    player.getSurname(), player.getBirth(), player.getHeight(), player.getWeight(), player.getJerseyNum(), editButton, deleteButton);

            playerTab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            playerTab2.setCellValueFactory(new PropertyValueFactory<>("playerPosition_id"));
            playerTab3.setCellValueFactory(new PropertyValueFactory<>("team_id"));
            playerTab4.setCellValueFactory(new PropertyValueFactory<>("name"));
            playerTab5.setCellValueFactory(new PropertyValueFactory<>("surname"));
            playerTab6.setCellValueFactory(new PropertyValueFactory<>("birth"));
            playerTab7.setCellValueFactory(new PropertyValueFactory<>("height"));
            playerTab8.setCellValueFactory(new PropertyValueFactory<>("weight"));
            playerTab9.setCellValueFactory(new PropertyValueFactory<>("jerseyNum"));
            playerTab10.setCellValueFactory(new PropertyValueFactory<>("edit"));
            playerTab11.setCellValueFactory(new PropertyValueFactory<>("delete"));
            playerData.add(ap);

        }
        ////////////////////////////////////////////
        //GAME//////////////////////////////////////
        gameItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameTableView.setVisible(true);
                addGame.setVisible(true);
                gameTableView.setItems(gameData);
                edit1.setPromptText("referee_id");
                edit1.setVisible(true);
                edit2.setPromptText("home_id");
                edit2.setVisible(true);
                edit3.setPromptText("away_id");
                edit3.setVisible(true);
                edit4.setPromptText("termin");
                edit4.setVisible(true);
                edit5.setPromptText("home_pts");
                edit5.setVisible(true);
                edit6.setPromptText("away_pts");
                edit6.setVisible(true);

                edit7.setVisible(false);
                edit8.setVisible(false);

                coachTableView.setVisible(false);
                addCoach.setVisible(false);
                playerTableView.setVisible(false);
                addPlayer.setVisible(false);
                psTableView.setVisible(false);
                addPS.setVisible(false);
                refTableView.setVisible(false);
                addRef.setVisible(false);
                teamTableView.setVisible(false);
                addTeam.setVisible(false);
                trainingTableView.setVisible(false);
                addTraining.setVisible(false);
                usersTableView.setVisible(false);
                addUser.setVisible(false);
            }
        });

        addGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session1 = factory.getCurrentSession();
                    session1.getTransaction().begin();
                    Referee referee = new Referee();
                    Team home = new Team();
                    Team away = new Team();
                    LocalDate dat = Date.valueOf(edit4.getText()).toLocalDate();
                    dat = dat.plusDays(1);
                    for (Referee ref : allRefs) {
                        if (ref.getReferee_id() == Integer.parseInt(edit1.getText())) {
                            referee = ref;
                        }
                    }
                    for (Team team : allTeams) {
                        if (team.getTeam_id() == Integer.parseInt(edit2.getText())) {
                            home = team;
                        }
                    }
                    for (Team team : allTeams) {
                        if (team.getTeam_id() == Integer.parseInt(edit3.getText())) {
                            away = team;
                        }
                    }
                    Game g = new Game(referee, home, away, Date.valueOf(dat), Integer.parseInt(edit5.getText()), Integer.parseInt(edit6.getText()));
                    session1.save(g);
                    session1.getTransaction().commit();
                    session1.close();
                    changeScene(event, "/adminMainScene.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Game game : allGames) {

            Button editButton = new Button("");
            editButton.setId("edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (edit1.getText().length() > 0) {
                            for (Referee ref : allRefs) {
                                if (ref.getReferee_id() == Integer.parseInt(edit1.getText())) {
                                    game.setReferee(ref);
                                }
                            }
                        }
                        if (edit2.getText().length() > 0) {
                            for (Team team : allTeams) {
                                if (team.getTeam_id() == Integer.parseInt(edit2.getText())) {
                                    game.setHome(team);
                                }
                            }
                        }
                        if (edit3.getText().length() > 0) {
                            for (Team team : allTeams) {
                                if (team.getTeam_id() == Integer.parseInt(edit3.getText())) {
                                    game.setAway(team);
                                }
                            }
                        }
                        if (edit4.getText().length() > 0) {
                            LocalDate dat = Date.valueOf(edit4.getText()).toLocalDate();
                            dat = dat.plusDays(1);
                            game.setTermin(Date.valueOf(dat));
                        }
                        if (edit5.getText().length() > 0) {
                            game.setTeam1pts(Integer.parseInt(edit5.getText()));
                        }
                        if (edit6.getText().length() > 0) {
                            game.setTeam2pts(Integer.parseInt(edit6.getText()));
                        }
                        session.update(game);
                        session.getTransaction().commit();
                        session.close();
                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Button deleteButton = new Button("");
            deleteButton.setId("delete");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        session.delete(game);
                        session.getTransaction().commit();
                        session.close();

                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            AGameTable ag;
            if (game.getReferee() == null) {
                ag = new AGameTable(game.getGame_id(), null, game.getHome().getTeam_id(),
                        game.getAway().getTeam_id(), game.getTermin(), game.getTeam1pts(), game.getTeam2pts(), editButton, deleteButton);
            } else {
                ag = new AGameTable(game.getGame_id(), game.getReferee().getReferee_id(), game.getHome().getTeam_id(),
                        game.getAway().getTeam_id(), game.getTermin(), game.getTeam1pts(), game.getTeam2pts(), editButton, deleteButton);
            }

            gameTab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            gameTab2.setCellValueFactory(new PropertyValueFactory<>("ref_id"));
            gameTab3.setCellValueFactory(new PropertyValueFactory<>("homeid"));
            gameTab4.setCellValueFactory(new PropertyValueFactory<>("awayid"));
            gameTab5.setCellValueFactory(new PropertyValueFactory<>("termin"));
            gameTab6.setCellValueFactory(new PropertyValueFactory<>("homePts"));
            gameTab7.setCellValueFactory(new PropertyValueFactory<>("awayPts"));
            gameTab8.setCellValueFactory(new PropertyValueFactory<>("edit"));
            gameTab9.setCellValueFactory(new PropertyValueFactory<>("delete"));
            gameData.add(ag);

        }
        ////////////////////////////////////////////
        //PLAYERSTATS///////////////////////////////
        playerStatsItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                psTableView.setVisible(true);
                addPS.setVisible(true);
                psTableView.setItems(psData);
                edit1.setPromptText("player_id");
                edit1.setVisible(true);
                edit2.setPromptText("game_id");
                edit2.setVisible(true);
                edit3.setPromptText("pts");
                edit3.setVisible(true);
                edit4.setPromptText("ast");
                edit4.setVisible(true);
                edit5.setPromptText("reb");
                edit5.setVisible(true);

                edit6.setVisible(false);
                edit7.setVisible(false);
                edit8.setVisible(false);

                coachTableView.setVisible(false);
                addCoach.setVisible(false);
                gameTableView.setVisible(false);
                addGame.setVisible(false);
                playerTableView.setVisible(false);
                addPlayer.setVisible(false);
                refTableView.setVisible(false);
                addRef.setVisible(false);
                teamTableView.setVisible(false);
                addTeam.setVisible(false);
                trainingTableView.setVisible(false);
                addTraining.setVisible(false);
                usersTableView.setVisible(false);
                addUser.setVisible(false);
            }
        });

        addPS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session1 = factory.getCurrentSession();
                    session1.getTransaction().begin();
                    Player player = new Player();
                    Game game = new Game();
                    for (Player p : allPlayers) {
                        if (p.getPlayer_id() == Integer.parseInt(edit1.getText())) {
                            player = p;
                        }
                    }
                    for (Game g : allGames) {
                        if (g.getGame_id() == Integer.parseInt(edit2.getText())) {
                            game = g;
                        }
                    }
                    PlayerStats ps = new PlayerStats(player, game, Integer.parseInt(edit3.getText()), Integer.parseInt(edit4.getText()), Integer.parseInt(edit5.getText()));
                    session1.save(ps);
                    session1.getTransaction().commit();
                    session1.close();
                    changeScene(event, "/adminMainScene.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (PlayerStats ps : allStats) {

            Button editButton = new Button("");
            editButton.setId("edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (edit1.getText().length() > 0) {
                            for (Player player : allPlayers) {
                                if (player.getPlayer_id() == Integer.parseInt(edit1.getText())) {
                                    ps.setPlayer(player);
                                }
                            }
                        }
                        if (edit2.getText().length() > 0) {
                            for (Game game : allGames) {
                                if (game.getGame_id() == Integer.parseInt(edit2.getText())) {
                                    ps.setGame(game);
                                }
                            }
                        }
                        if (edit3.getText().length() > 0) {
                            ps.setPts(Integer.parseInt(edit3.getText()));
                        }
                        if (edit4.getText().length() > 0) {
                            ps.setAst(Integer.parseInt(edit4.getText()));
                        }
                        if (edit5.getText().length() > 0) {
                            ps.setReb(Integer.parseInt(edit5.getText()));
                        }
                        session.update(ps);
                        session.getTransaction().commit();
                        session.close();
                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Button deleteButton = new Button("");
            deleteButton.setId("delete");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        session.delete(ps);
                        session.getTransaction().commit();
                        session.close();

                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            APlayerStats pst = new APlayerStats(ps.getPlayerStats_id(), ps.getPlayer().getPlayer_id(), ps.getGame().getGame_id(), ps.getPts(), ps.getAst(), ps.getReb(), editButton, deleteButton);
            psTab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            psTab2.setCellValueFactory(new PropertyValueFactory<>("playerid"));
            psTab3.setCellValueFactory(new PropertyValueFactory<>("gameid"));
            psTab4.setCellValueFactory(new PropertyValueFactory<>("pts"));
            psTab5.setCellValueFactory(new PropertyValueFactory<>("ast"));
            psTab6.setCellValueFactory(new PropertyValueFactory<>("reb"));
            psTab7.setCellValueFactory(new PropertyValueFactory<>("edit"));
            psTab8.setCellValueFactory(new PropertyValueFactory<>("delete"));
            psData.add(pst);
        }
        /////////////////////////////////////////////////
        //REFEREE////////////////////////////////////////
        refereeItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                refTableView.setVisible(true);
                addRef.setVisible(true);
                refTableView.setItems(refData);
                edit1.setPromptText("name");
                edit1.setVisible(true);
                edit2.setPromptText("surname");
                edit2.setVisible(true);

                edit3.setVisible(false);
                edit4.setVisible(false);
                edit5.setVisible(false);
                edit6.setVisible(false);
                edit7.setVisible(false);
                edit8.setVisible(false);

                playerTableView.setVisible(false);
                addPlayer.setVisible(false);
                gameTableView.setVisible(false);
                addGame.setVisible(false);
                psTableView.setVisible(false);
                addPS.setVisible(false);
                coachTableView.setVisible(false);
                addCoach.setVisible(false);
                teamTableView.setVisible(false);
                addTeam.setVisible(false);
                trainingTableView.setVisible(false);
                addTraining.setVisible(false);
                usersTableView.setVisible(false);
                addUser.setVisible(false);
            }
        });

        addRef.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session1 = factory.getCurrentSession();
                    session1.getTransaction().begin();
                    Referee r = new Referee(edit1.getText(), edit2.getText());
                    session1.save(r);
                    session1.getTransaction().commit();
                    session1.close();
                    changeScene(event, "/adminMainScene.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Referee referee : allRefs) {

            Button editButton = new Button("");
            editButton.setId("edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (edit1.getText().length() > 0) {
                            referee.setName(edit1.getText());
                        }
                        if (edit2.getText().length() > 0) {
                            referee.setSurname(edit2.getText());
                        }
                        session.update(referee);
                        session.getTransaction().commit();
                        session.close();
                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Button deleteButton = new Button("");
            deleteButton.setId("delete");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (referee.getRefereeGames() != null) {
                            for (Game game : allGames) {
                                if (game.getReferee() != null) {
                                    if (referee.getReferee_id() == game.getReferee().getReferee_id()) {
                                        game.setReferee(null);
                                        session.update(game);
                                    }
                                }
                            }
                        }
                        session.delete(referee);
                        session.getTransaction().commit();
                        session.close();

                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            ARefereeTable ar = new ARefereeTable(referee.getReferee_id(), referee.getName(), referee.getSurname(), editButton, deleteButton);
            refTab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            refTab2.setCellValueFactory(new PropertyValueFactory<>("name"));
            refTab3.setCellValueFactory(new PropertyValueFactory<>("surname"));
            refTab4.setCellValueFactory(new PropertyValueFactory<>("edit"));
            refTab5.setCellValueFactory(new PropertyValueFactory<>("delete"));
            refData.add(ar);

        }
        /////////////////////////////////////////////////
        //TEAM///////////////////////////////////////////
        teamItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                teamTableView.setVisible(true);
                addTeam.setVisible(true);
                teamTableView.setItems(teamData);
                edit1.setPromptText("coach_id");
                edit1.setVisible(true);
                edit2.setPromptText("name");
                edit2.setVisible(true);

                edit3.setVisible(false);
                edit4.setVisible(false);
                edit5.setVisible(false);
                edit6.setVisible(false);
                edit7.setVisible(false);
                edit8.setVisible(false);

                playerTableView.setVisible(false);
                addPlayer.setVisible(false);
                gameTableView.setVisible(false);
                addGame.setVisible(false);
                psTableView.setVisible(false);
                addPS.setVisible(false);
                refTableView.setVisible(false);
                addRef.setVisible(false);
                coachTableView.setVisible(false);
                addCoach.setVisible(false);
                trainingTableView.setVisible(false);
                addTraining.setVisible(false);
                usersTableView.setVisible(false);
                addUser.setVisible(false);
            }
        });

        addTeam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session1 = factory.getCurrentSession();
                    session1.getTransaction().begin();
                    Coach coach = new Coach();
                    for (Coach c : allCoaches) {
                        if (c.getCoach_id() == Integer.parseInt(edit1.getText())) {
                            coach = c;
                        }
                    }
                    Team t = new Team(coach, edit2.getText());
                    t.setGamesPlayed(0);
                    t.setWins(0);
                    t.setLoses(0);
                    t.setWinP("0");
                    t.setPtsGained(0);
                    t.setPtsLosed(0);
                    t.setPts(0);
                    session1.save(t);
                    session1.getTransaction().commit();
                    session1.close();
                    changeScene(event, "/adminMainScene.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Team team : allTeams) {
            Button editButton = new Button("");
            editButton.setId("edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (edit1.getText().length() > 0) {
                            for (Coach c : allCoaches) {
                                if (c.getCoach_id() == Integer.parseInt(edit1.getText())) {
                                    team.setCoach(c);
                                }
                            }
                        }
                        if (edit2.getText().length() > 0) {
                            team.setName(edit2.getText());
                        }
                        session.update(team);
                        session.getTransaction().commit();
                        session.close();
                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Button deleteButton = new Button("");
            deleteButton.setId("delete");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        team.setCoach(null);
                        for (Player p : allPlayers) {
                            if (p.getTeam() == team) {
                                p.setTeam(null);
                                session.update(p);
                            }
                        }
                        session.update(team);
                        session.delete(team);
                        session.getTransaction().commit();
                        session.close();

                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            ATeamTable at;
            if (team.getCoach() == null) {
                at = new ATeamTable(team.getTeam_id(), null, team.getName(), editButton, deleteButton);
            } else {
                at = new ATeamTable(team.getTeam_id(), team.getCoach().getCoach_id(), team.getName(), editButton, deleteButton);
            }
            teamTab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            teamTab2.setCellValueFactory(new PropertyValueFactory<>("coachid"));
            teamTab3.setCellValueFactory(new PropertyValueFactory<>("name"));
            teamTab4.setCellValueFactory(new PropertyValueFactory<>("edit"));
            teamTab5.setCellValueFactory(new PropertyValueFactory<>("delete"));
            teamData.add(at);
        }
        /////////////////////////////////////////////////
        //TRAINING///////////////////////////////////////
        trainingItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                trainingTableView.setVisible(true);
                addTraining.setVisible(true);
                trainingTableView.setItems(trainingData);
                edit1.setPromptText("team_id");
                edit1.setVisible(true);
                edit2.setPromptText("termin");
                edit2.setVisible(true);

                edit3.setVisible(false);
                edit4.setVisible(false);
                edit5.setVisible(false);
                edit6.setVisible(false);
                edit7.setVisible(false);
                edit8.setVisible(false);

                playerTableView.setVisible(false);
                addPlayer.setVisible(false);
                gameTableView.setVisible(false);
                addGame.setVisible(false);
                psTableView.setVisible(false);
                addPS.setVisible(false);
                refTableView.setVisible(false);
                addRef.setVisible(false);
                teamTableView.setVisible(false);
                addTeam.setVisible(false);
                coachTableView.setVisible(false);
                addCoach.setVisible(false);
                usersTableView.setVisible(false);
                addUser.setVisible(false);
            }
        });

        addTraining.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session1 = factory.getCurrentSession();
                    session1.getTransaction().begin();
                    Team team = new Team();
                    LocalDate dat = Date.valueOf(edit2.getText()).toLocalDate();
                    dat = dat.plusDays(1);
                    for (Team t : allTeams) {
                        if (t.getTeam_id() == Integer.parseInt(edit1.getText())) {
                            team = t;
                        }
                    }
                    Training training = new Training(team, Date.valueOf(dat));
                    session1.save(training);
                    session1.getTransaction().commit();
                    session1.close();
                    changeScene(event, "/adminMainScene.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Training training : allTrainings) {
            Button editButton = new Button("");
            editButton.setId("edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (edit1.getText().length() > 0) {
                            for (Team t : allTeams) {
                                if (t.getTeam_id() == Integer.parseInt(edit1.getText())) {
                                    training.setTeam(t);
                                }
                            }
                        }
                        if (edit2.getText().length() > 0) {
                            LocalDate dat = Date.valueOf(edit2.getText()).toLocalDate();
                            dat = dat.plusDays(1);
                            training.setTermin(Date.valueOf(dat));
                        }
                        session.update(training);
                        session.getTransaction().commit();
                        session.close();
                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Button deleteButton = new Button("");
            deleteButton.setId("delete");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        session.delete(training);
                        session.getTransaction().commit();
                        session.close();

                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            ATrainingTable tr = new ATrainingTable(training.getTraining_id(), training.getTeam().getTeam_id(), training.getTermin(), editButton, deleteButton);
            trainingTab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            trainingTab2.setCellValueFactory(new PropertyValueFactory<>("teamid"));
            trainingTab3.setCellValueFactory(new PropertyValueFactory<>("termin"));
            trainingTab4.setCellValueFactory(new PropertyValueFactory<>("edit"));
            trainingTab5.setCellValueFactory(new PropertyValueFactory<>("delete"));
            trainingData.add(tr);
        }
        ////////////////////////////////////////////////
        //USERS/////////////////////////////////////////
        usersItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                usersTableView.setVisible(true);
                addUser.setVisible(true);
                usersTableView.setItems(usersData);
                edit1.setPromptText("role_id");
                edit1.setVisible(true);
                edit2.setPromptText("username");
                edit2.setVisible(true);
                edit3.setPromptText("password");
                edit3.setVisible(true);

                edit4.setVisible(false);
                edit5.setVisible(false);
                edit6.setVisible(false);
                edit7.setVisible(false);
                edit8.setVisible(false);

                playerTableView.setVisible(false);
                addPlayer.setVisible(false);
                gameTableView.setVisible(false);
                addGame.setVisible(false);
                psTableView.setVisible(false);
                addPS.setVisible(false);
                refTableView.setVisible(false);
                addRef.setVisible(false);
                teamTableView.setVisible(false);
                addTeam.setVisible(false);
                coachTableView.setVisible(false);
                addCoach.setVisible(false);
                trainingTableView.setVisible(false);
                addTraining.setVisible(false);
            }
        });

        addUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Session session1 = factory.getCurrentSession();
                    session1.getTransaction().begin();
                    Roles role = new Roles();
                    for (Roles r : allRoles) {
                        if (r.getRoles_id() == Integer.parseInt(edit1.getText())) {
                            role = r;
                        }
                    }
                    Users u = new Users(role, edit2.getText(), edit3.getText());
                    session1.save(u);
                    session1.getTransaction().commit();
                    session1.close();
                    changeScene(event, "/adminMainScene.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        for (Users user : allUsers) {
            Button editButton = new Button("");
            editButton.setId("edit");
            editButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (edit1.getText().length() > 0) {
                            for (Roles r : allRoles) {
                                if (r.getRoles_id() == Integer.parseInt(edit1.getText())) {
                                    user.setRole(r);
                                }
                            }
                        }
                        if (edit2.getText().length() > 0) {
                            user.setUsername(edit2.getText());
                        }
                        if (edit3.getText().length() > 0) {
                            user.setPasswrd(edit3.getText());
                        }
                        session.update(user);
                        session.getTransaction().commit();
                        session.close();
                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Button deleteButton = new Button("");
            deleteButton.setId("delete");
            deleteButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        SessionFactory factory = HibernateUtil.getSessionFactory();
                        Session session = factory.getCurrentSession();
                        session.getTransaction().begin();
                        if (user.getCoach() != null) {
                            for (Coach c : allCoaches) {
                                if (c.getUser() == user) {
                                    c.setUser(null);
                                    session.update(c);
                                    user.setCoach(null);
                                    session.update(user);
                                }
                            }
                        }
                        session.delete(user);
                        session.getTransaction().commit();
                        session.close();

                        changeScene(event, "/adminMainScene.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            AUsersTable au = new AUsersTable(user.getUsers_id(), user.getRole().getRoles_id(), user.getUsername(), user.getPasswrd(), editButton, deleteButton);
            userTab1.setCellValueFactory(new PropertyValueFactory<>("id"));
            userTab2.setCellValueFactory(new PropertyValueFactory<>("roleid"));
            userTab3.setCellValueFactory(new PropertyValueFactory<>("username"));
            userTab4.setCellValueFactory(new PropertyValueFactory<>("password"));
            userTab5.setCellValueFactory(new PropertyValueFactory<>("edit"));
            userTab6.setCellValueFactory(new PropertyValueFactory<>("delete"));
            usersData.add(au);

        }
        ////////////////////////////////////////////////
    }

}
