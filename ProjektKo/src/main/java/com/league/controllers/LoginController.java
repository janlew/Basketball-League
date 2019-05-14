package com.league.controllers;

import com.league.model.Users;
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
    public static int loggedUserId;
    @FXML private TextField login;
    @FXML private PasswordField password;
    @FXML private Button logInButton;

    public void logIn(){
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        if(checkLoggingIn(login.getText(), password.getText()) == 1) {

            logInButton.setOnAction(e ->{
                try {
                    System.out.println("zalogowano");
                    changeScene(e, "/mainScene.fxml");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
        }

        else{
            System.out.println("zle dane logowania");
            session.getTransaction().rollback();
        }
        session.close();

//
    }

    public int checkLoggingIn(String username, String password){
        List<Users> list = factory.getCurrentSession()
                .createQuery("from " + Users.class.getName() + " WHERE username = '" + username + "' AND passwrd = '" + password + "'").list();
        if(list.size() > 0)
            loggedUserId = list.get(0).getUsers_id();
        return list.size();
    }

}
