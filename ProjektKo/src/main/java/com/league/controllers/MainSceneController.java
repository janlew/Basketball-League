package com.league.controllers;

import com.league.utilities.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;

public class MainSceneController extends Controller {
    SessionFactory factory = HibernateUtil.getSessionFactory();

    @FXML private TableView tabela;
    //@FXML private TableColumn<Integer> position;
}
