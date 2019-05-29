CREATE DATABASE league;
DROP DATABASE league;
USE league;

CREATE TABLE roles (
	roles_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(30),
    PRIMARY KEY (roles_id)
);

INSERT INTO roles (name) VALUES ('admin'), ('coach'), ('fan');

CREATE TABLE users (
	users_id INT NOT NULL AUTO_INCREMENT,
    roles_id INT NOT NULL,
    username VARCHAR(30),
    passwrd VARCHAR(30),
    PRIMARY KEY (users_id),
    FOREIGN KEY (roles_id) REFERENCES roles(roles_id)
);

INSERT INTO users (roles_id, username, passwrd) VALUES (1, 'admin', 'admin'), (2, 'c', 'c'), (2, 'cc', 'cc'), (2, 'ccc', 'ccc'), (2, 'cccc', 'cccc');
INSERT INTO users (roles_id, username, passwrd) VALUES (2, 't', 't');
select * from users;
CREATE TABLE referee (
	referee_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    PRIMARY KEY (referee_id)
);

INSERT INTO referee (name, surname) VALUES ('Ted', 'Bell'), ('Bradley', 'Cooper'), ('Martin', 'Moon');

CREATE TABLE coach (
	coach_id INT NOT NULL AUTO_INCREMENT,
    users_id INT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    PRIMARY KEY (coach_id),
    FOREIGN KEY (users_id) REFERENCES users(users_id)
);

INSERT INTO coach (users_id, name, surname) VALUES (2, 'Coach', 'Coa');
INSERT INTO coach (users_id, name, surname) VALUES (3, 'Coach1', 'Coa1');
INSERT INTO coach (users_id, name, surname) VALUES (4, 'Coach2', 'Coa2');
INSERT INTO coach (users_id, name, surname) VALUES (5, 'brak', 'brak');


CREATE TABLE team (
	team_id INT NOT NULL AUTO_INCREMENT,
    coach_id INT DEFAULT 4,
	name VARCHAR(50) NOT NULL,
    gamesPlayed INT NOT NULL DEFAULT 0,
    wins INT NOT NULL DEFAULT 0,
    loses INT NOT NULL DEFAULT 0,
    winP VARCHAR(7) NOT NULL DEFAULT '0',
    ptsGained INT NOT NULL DEFAULT 0,
    ptsLosed INT NOT NULL DEFAULT 0,
    pts INT NOT NULL DEFAULT 0,
	PRIMARY KEY (team_id),
    FOREIGN KEY (coach_id) REFERENCES coach(coach_id)
);

INSERT INTO team (coach_id, name) VALUES (1, 'FirstTeam'), (2, 'SecondTeam'), (3, 'ThirdTeam');

CREATE TABLE training (
	training_id INT NOT NULL AUTO_INCREMENT,
    team_id INT NOT NULL,
    termin DATE NOT NULL,
    PRIMARY KEY (training_id),
    FOREIGN KEY (team_id) REFERENCES team(team_id)
);

INSERT INTO training (team_id, termin) VALUES (1, '2019-05-22'), (2, '2019-05-23'), (3, '2019-05-24');

CREATE TABLE playerPosition (
	playerPosition_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    abbrev VARCHAR(5) NOT NULL UNIQUE,
    PRIMARY KEY (playerPosition_id)
);

INSERT INTO playerPosition (name, abbrev) VALUES ('point guard', 'PG'), ('shooting guard', 'SG'), ('small forward', 'SF'), ('power forward', 'PF'), ('center', 'C');

CREATE TABLE player (
  player_id INT NOT NULL AUTO_INCREMENT,
  playerPosition_id INT NOT NULL,
  team_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  birth DATE NOT NULL,
  height FLOAT NOT NULL,
  weight FLOAT NOT NULL,
  jerseyNum INT NOT NULL,
  ppg VARCHAR(7) DEFAULT '0',
  apg VARCHAR(7) DEFAULT '0',
  rpg VARCHAR(7) DEFAULT '0',
  PRIMARY KEY (player_id),
  FOREIGN KEY (playerPosition_id) REFERENCES playerPosition(playerPosition_id),
  FOREIGN KEY (team_id) REFERENCES team(team_id)
);

INSERT INTO player (playerPosition_id, team_id, name, surname, birth, height, weight, jerseyNum) VALUES (1, 1, 'P1', 'N1', '1997-09-10', 1.90, 80, 24);
INSERT INTO player (playerPosition_id, team_id, name, surname, birth, height, weight, jerseyNum) VALUES (1, 1, 'P2', 'N2', '1997-01-02', 1.91, 81, 25);
INSERT INTO player (playerPosition_id, team_id, name, surname, birth, height, weight, jerseyNum) VALUES (3, 2, 'P3', 'N3', '1997-02-10', 1.92, 82, 26);
INSERT INTO player (playerPosition_id, team_id, name, surname, birth, height, weight, jerseyNum) VALUES (4, 2, 'P4', 'N4', '1997-04-05', 1.93, 83, 27);
INSERT INTO player (playerPosition_id, team_id, name, surname, birth, height, weight, jerseyNum) VALUES (5, 3, 'P5', 'N5', '1997-06-07', 1.94, 84, 28);


CREATE TABLE game (
	game_id INT NOT NULL AUTO_INCREMENT,
    referee_id INT NOT NULL,
    home_id INT NOT NULL,
    away_id INT NOT NULL,
    termin DATE NOT NULL,
    team1pts INT,
    team2pts INT,
	PRIMARY KEY (game_id),
	FOREIGN KEY (referee_id) REFERENCES referee(referee_id),
    FOREIGN KEY (home_id) REFERENCES team(team_id),
    FOREIGN KEY (away_id) REFERENCES team(team_id)
);

INSERT INTO game (referee_id, home_id, away_id, termin, team1pts, team2pts) VALUES (1, 1, 2, '2019-01-01', 120, 100);
INSERT INTO game (referee_id, home_id, away_id, termin, team1pts, team2pts) VALUES (1, 1, 3, '2019-03-12', 12, 1);
INSERT INTO game (referee_id, home_id, away_id, termin, team1pts, team2pts) VALUES (1, 1, 3, '2019-04-09', 12, 100);
INSERT INTO game (referee_id, home_id, away_id, termin, team1pts, team2pts) VALUES (1, 3, 2, '2019-05-19', 0, 0);
INSERT INTO game (referee_id, home_id, away_id, termin, team1pts, team2pts) VALUES (1, 2, 1, '2019-06-19', 0, 0);
INSERT INTO game (referee_id, home_id, away_id, termin, team1pts, team2pts) VALUES (1, 3, 1, '2019-07-19', 0, 0);


CREATE TABLE playerStats (
	playerStats_id INT NOT NULL AUTO_INCREMENT,
    player_id INT NOT NULL,
    game_id INT NOT NULL,
    pts INT NOT NULL,
    ast INT NOT NULL,
    reb INT NOT NULL,
    PRIMARY KEY (playerStats_id),
	FOREIGN KEY (player_id) REFERENCES player(player_id),
	FOREIGN KEY (game_id) REFERENCES game(game_id)
);

INSERT INTO playerStats (player_id, game_id, pts, ast, reb) VALUES (1, 1, 23, 10, 7), (1, 3, 33, 8, 23);
INSERT INTO playerStats (player_id, game_id, pts, ast, reb) VALUES (2, 1, 12, 3, 6), (2, 2, 4, 8, 12);
INSERT INTO playerStats (player_id, game_id, pts, ast, reb) VALUES (3, 1, 22, 6, 3);
INSERT INTO playerStats (player_id, game_id, pts, ast, reb) VALUES (4, 1, 2, 13, 7);
INSERT INTO playerStats (player_id, game_id, pts, ast, reb) VALUES (5, 2, 33, 13, 16);

SELECT * FROM player;
select * from playerPosition;
select * from playerStats;
    
SELECT * FROM training;




































