package com.league.controllers;

import com.league.model.*;
import com.league.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.DecimalFormat;
import java.util.List;

public class PlayerCtrl extends Controller {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();

    List<Player> allPlayers = this.loadAllData(Player.class, session);
    List<PlayerStats> allStats = this.loadAllData(PlayerStats.class, session);

    public void countPPG () {
        DecimalFormat df = new DecimalFormat("#.###");
        double pom;

        for (Player player : allPlayers) {
            int allPts = 0;
            int allGames = 0;
            for (PlayerStats ps : allStats) {
                if (player.getPlayer_id() == ps.getPlayer().getPlayer_id()) {
                    allPts += ps.getPts();
                    allGames++;
                    pom = (double) allPts / (double) allGames;
                    player.setPpg(df.format(pom));
                }
            }
        }
    }

    public void countAPG() {
        DecimalFormat df = new DecimalFormat("#.###");
        double pom;
        String ppg;

        for (Player player : allPlayers) {
            int allAst = 0;
            int allGames = 0;
            for (PlayerStats ps : allStats) {
                if (player.getPlayer_id() == ps.getPlayer().getPlayer_id()) {
                    allAst += ps.getAst();
                    allGames++;
                    pom = (double) allAst / (double) allGames;
                    player.setApg(df.format(pom));
                }
            }
        }
    }

    public void countRPG() {
        DecimalFormat df = new DecimalFormat("#.###");
        double pom;
        String ppg;

        for (Player player : allPlayers) {
            int allReb = 0;
            int allGames = 0;
            for (PlayerStats ps : allStats) {
                if (player.getPlayer_id() == ps.getPlayer().getPlayer_id()) {
                    allReb += ps.getReb();
                    allGames++;
                    pom = (double) allReb / (double) allGames;
                    player.setRpg(df.format(pom));
                }
            }
        }
    }



}
