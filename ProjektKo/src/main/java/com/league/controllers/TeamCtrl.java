package com.league.controllers;

import com.league.model.Game;
import com.league.model.Team;
import com.league.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

public class TeamCtrl extends Controller {

    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    SessionFactory factory = HibernateUtil.getSessionFactory();
    Session session = factory.getCurrentSession();

    List<Team> allTeams = this.loadAllData(Team.class, session);
    List<Game> allGames = this.loadAllData(Game.class, session);

    public void settingGamePlayed() {
        int gamesPlayed;
        for (Team team : allTeams) {
            gamesPlayed = team.getGamesPlayed();
            for (Game game : allGames) {
                if (game.getTeam2pts() != 0) {
                    if (game.getAway().getTeam_id() == team.getTeam_id()) {
                        gamesPlayed++;
                        team.setGamesPlayed(gamesPlayed);
                    } else if (game.getHome().getTeam_id() == team.getTeam_id()) {
                        gamesPlayed++;
                        team.setGamesPlayed(gamesPlayed);
                    }
                }
            }
        }
    }

    public void settingWonGames() {
        int gamesWon;
        for (Team team : allTeams) {
            gamesWon = team.getWins();
            for (Game game : allGames) {
                if((game.getAway().getTeam_id() == team.getTeam_id()) && (game.getTeam1pts() < game.getTeam2pts())) {
                    gamesWon++;
                    team.setWins(gamesWon);
                } else if ((game.getHome().getTeam_id() == team.getTeam_id()) && (game.getTeam1pts() > game.getTeam2pts())) {
                    gamesWon++;
                    team.setWins(gamesWon);
                }
            }
        }
    }

    public void settingLosedGames() {
        int gamesLosed;
        for (Team team : allTeams) {
            gamesLosed = team.getLoses();
            for (Game game : allGames) {
                if((game.getAway().getTeam_id() == team.getTeam_id()) && (game.getTeam1pts() > game.getTeam2pts())) {
                    gamesLosed++;
                    team.setLoses(gamesLosed);
                } else if ((game.getHome().getTeam_id() == team.getTeam_id()) && (game.getTeam1pts() < game.getTeam2pts())) {
                    gamesLosed++;
                    team.setLoses(gamesLosed);
                }
            }
        }
    }

    public void settingWinPerc() {
        DecimalFormat df = new DecimalFormat("#.###");
        String winP;
        double pom;
        int w, m;
        for (Team team : allTeams) {
            w = team.getWins();
            m = team.getGamesPlayed();
            pom = (double) w/(double) m;
            team.setWinP(df.format(pom));
        }
    }

    public void settingTeamPts() {
        int ptsEarned;
        int ptsLosed;
        for (Team team : allTeams) {
            ptsEarned = team.getPtsGained();
            ptsLosed = team.getPtsLosed();
            for (Game game : allGames) {
                if(game.getAway().getTeam_id() == team.getTeam_id()) {
                    ptsEarned += game.getTeam2pts();
                    ptsLosed += game.getTeam1pts();
                    team.setPtsGained(ptsEarned);
                    team.setPtsLosed(ptsLosed);
                } else if (game.getHome().getTeam_id() == team.getTeam_id()) {
                    ptsEarned += game.getTeam1pts();
                    ptsLosed += game.getTeam2pts();
                    team.setPtsGained(ptsEarned);
                    team.setPtsLosed(ptsLosed);
                }
            }
        }
    }

    public void settingPts() {
        int pts, win, los;
        for (Team team : allTeams) {
            win = team.getWins();
            los = team.getLoses();
            pts = 2*win + los;
            team.setPts(pts);
        }
    }

}
