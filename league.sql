CREATE DATABASE league;
DROP DATABASE league;
USE league;

CREATE TABLE roles (
	roles_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(30),
    PRIMARY KEY (roles_id)
);

INSERT INTO roles (name) VALUES ('admin'), ('coach'), ('player');

CREATE TABLE users (
	users_id INT NOT NULL AUTO_INCREMENT,
    roles_id INT NOT NULL,
    username VARCHAR(30),
    passwrd VARCHAR(30),
    PRIMARY KEY (users_id),
    FOREIGN KEY (roles_id) REFERENCES roles(roles_id)
);

INSERT INTO users (roles_id, username, passwrd) VALUES (1, 'admin', 'admin'), (2, 'coach', 'coach'), (3, 'player', 'player');

CREATE TABLE news (
	news_id INT NOT NULL AUTO_INCREMENT,
    users_id INT NOT NULL,
    title VARCHAR(30),
    content TEXT,
    PRIMARY KEY (news_id),
    FOREIGN KEY (users_id) REFERENCES users(users_id)
);

CREATE TABLE referee (
	referee_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    PRIMARY KEY (referee_id)
);

INSERT INTO referee (name, surname) VALUES ('Referee', 'Refo');

CREATE TABLE coach (
	coach_id INT NOT NULL AUTO_INCREMENT,
    users_id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    birth DATE NOT NULL,
    PRIMARY KEY (coach_id),
    FOREIGN KEY (users_id) REFERENCES users(users_id)
);

INSERT INTO coach (users_id, name, surname, birth) VALUES (2, 'Coach', 'Coa', '1970-01-01');
INSERT INTO coach (users_id, name, surname, birth) VALUES (2, 'Coach1', 'Coa1', '1970-01-01');

CREATE TABLE team (
	team_id INT NOT NULL AUTO_INCREMENT,
    coach_id INT UNIQUE NOT NULL,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (team_id),
    FOREIGN KEY (coach_id) REFERENCES coach(coach_id)
);

INSERT INTO team  (coach_id, name) VALUES (1, 'FirstTeam'), (2, 'SecondTeam');


CREATE TABLE training (
	training_id INT NOT NULL AUTO_INCREMENT,
    team_id INT NOT NULL,
    termin DATE NOT NULL,
    PRIMARY KEY (training_id),
    FOREIGN KEY (team_id) REFERENCES team(team_id)
);

CREATE TABLE playerPosition (
	playerPosition_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    abbrev VARCHAR(5) NOT NULL UNIQUE,
    PRIMARY KEY (playerPosition_id)
);

INSERT INTO playerPosition (name, abbrev) VALUES ('point guard', 'PG'), ('shooting guard', 'SG'), ('small forward', 'SF'), ('power forward', 'PF'), ('center', 'C');

CREATE TABLE player (
  player_id INT NOT NULL AUTO_INCREMENT,
  users_id INT NOT NULL,
  playerPosition_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  birth DATE NOT NULL,
  height FLOAT NOT NULL,
  weight FLOAT NOT NULL,
  jerseyNum INT NOT NULL,
  PRIMARY KEY (player_id),
  FOREIGN KEY (users_id) REFERENCES users(users_id),
  FOREIGN KEY (playerPosition_id) REFERENCES playerPosition(playerPosition_id)
);

INSERT INTO player (users_id, playerPosition_id, name, surname, birth, height, weight, jerseyNum) VALUES (3, 1, 'Jan', 'Lew', '1997-09-10', 1.90, 80, 24);

CREATE TABLE teamPlayers (
	teamPlayers_id INT NOT NULL AUTO_INCREMENT,
    team_id INT NOT NULL,
    player_id INT NOT NULL,
    PRIMARY KEY (teamPlayers_id),
    FOREIGN KEY (team_id) REFERENCES team(team_id),
	FOREIGN KEY (player_id) REFERENCES player(player_id)
);

INSERT INTO teamPlayers (team_id, player_id) VALUES (1, 1);

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

CREATE TABLE playerStats (
	playerStats_id INT NOT NULL AUTO_INCREMENT,
    player_id INT NOT NULL,
    game_id INT NOT NULL,
    mins INT NOT NULL,
    pts INT NOT NULL,
    ast INT NOT NULL,
    reb INT NOT NULL,
    PRIMARY KEY (playerStats_id),
	FOREIGN KEY (player_id) REFERENCES player(player_id),
	FOREIGN KEY (game_id) REFERENCES game(game_id)
);

INSERT INTO playerStats (player_id, game_id, mins, pts, ast, reb) VALUES (1, 1, 40, 100, 10, 45);

SELECT * FROM playerStats;
    
    





































