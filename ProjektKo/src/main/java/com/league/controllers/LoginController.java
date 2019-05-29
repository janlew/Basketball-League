package com.league.controllers;

import com.league.model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.league.utilities.HibernateUtil;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;


public class LoginController extends Controller {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = HibernateUtil.getSessionFactory().openSession();
    public static int loggedUserId;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;

    public void backButtonAction(ActionEvent e) throws IOException {
        this.changeScene(e, "/fanMainScene.fxml");
        session.close();
    }

    public void buttonAction(ActionEvent e) throws IOException {
        logIn();
        if (logIn()) {
            Users u = session.get(Users.class, loggedUserId);
            int roleID = u.getRole().getRoles_id();
            if (roleID == 1) {
                setRoleID(1);
                this.changeScene(e, "/adminMainScene.fxml");
            } else if (roleID == 2) {
                int t = u.getCoach().getTeam().getTeam_id();
                setRoleID(2);
                setTeamID(t);
                this.changeScene(e, "/coachMainScene.fxml");
            }
        }
    }

    public boolean logIn() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();

        if (checkLoggingIn(login.getText(), password.getText()) == 1) {
            session.close();
            return true;
        } else {
            System.out.println("zle dane logowania");
            session.getTransaction().rollback();
        }
        session.close();
        return false;

    }

    public int checkLoggingIn(String username, String password) {
        List<Users> list = factory.getCurrentSession()
                .createQuery("from " + Users.class.getName() + " WHERE username = '" + username + "' AND passwrd = '" + password + "'").list();
        if (list.size() > 0)
            loggedUserId = list.get(0).getUsers_id();
        return list.size();
    }


}
