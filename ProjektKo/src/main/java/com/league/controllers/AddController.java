package com.league.controllers;

import com.league.utilities.HibernateUtil;
import javafx.fxml.FXML;
import org.hibernate.SessionFactory;

public class AddController {
    SessionFactory factory = HibernateUtil.getSessionFactory();

}
