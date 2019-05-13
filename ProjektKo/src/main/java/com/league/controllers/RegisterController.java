package com.league.controllers;

import com.league.model.Roles;
import com.league.model.Users;
import javafx.fxml.FXML;
import com.league.utilities.HibernateUtil;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class RegisterController extends Controller {
    SessionFactory factory = HibernateUtil.getSessionFactory();

    @FXML private TextField username;
    @FXML private PasswordField password;


    public void register(){
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        if(checkLogin(username.getText()) == 0) {

            Roles basicRole = new Roles("basic");
            session.save(basicRole);

            Users u1 = new Users();
            u1.setRole(basicRole);
            u1.setUsername(username.getText());
            u1.setPasswrd(password.getText());
            session.save(u1);
            session.getTransaction().commit();
        }
        else{
            System.out.println("login zajety");
            session.getTransaction().rollback();
        }
        session.close();

//
    }

    public int checkLogin(String username){
        List<Users> list = factory.getCurrentSession()
                .createQuery("from " + Users.class.getName() + " WHERE username = '" + username + "'").list();
        return list.size();
    }

}
