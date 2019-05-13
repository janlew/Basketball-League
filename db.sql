CREATE DATABASE league;
DROP DATABASE league;
USE league;

DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS playerPosition;
DROP TABLE IF EXISTS playerStats;
DROP TABLE IF EXISTS coach;
DROP TABLE IF EXISTS referee;
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS stadium;
DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS address;

CREATE TABLE referee (
	referee_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL
);

CREATE TABLE address (
	address_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    city VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    num VARCHAR(10) NOT NULL
);

CREATE TABLE stadium (
	stadium_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    address_id INT UNIQUE NOT NULL REFERENCES address(address_id),
    name VARCHAR(50) NOT NULL,
    cap INT NOT NULL
);

CREATE TABLE team (
	team_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    stadium_id INT UNIQUE NOT NULL REFERENCES stadium(stadium_id),
	name VARCHAR(50) NOT NULL,
    wins INT,
    loss INT
);

CREATE TABLE coach (
	coach_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    team_id INT NOT NULL REFERENCES team(team_id),
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    birth DATE NOT NULL,
    PRIMARY KEY (coach_id)
);

CREATE TABLE playerPosition (
	playerPosition_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    name VARCHAR(50) NOT NULL,
    abbrev VARCHAR(5) NOT NULL
);

CREATE TABLE roles (
	roles_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
	name VARCHAR(30)
);

CREATE TABLE users (
	users_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    roles_id INT NOT NULL REFERENCES roles(roles_id),
    username VARCHAR(30),
    passwrd VARCHAR(30),
);

CREATE TABLE player (
  player_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
  team_id INT NOT NULL REFERENCES team(team_id),
  users_id INT NOT NULL REFERENCES users(users_id),
  playerPosition_id INT NOT NULL REFERENCES playerPosition(playerPosition_id),
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  birth DATE NOT NULL,
  height FLOAT NOT NULL,
  weight FLOAT NOT NULL,
  jerseyNum INT NOT NULL
);

CREATE TABLE game (
	game_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
    team1_id INT NOT NULL REFERENCES team(team_id),
    team2_id INT NOT NULL REFERENCES team(team_id),
    referee_id INT NOT NULL REFERENCES referee(referee_id),
    stadium_id INT NOT NULL REFERENCES stadium(stadium_id),
    termin DATE NOT NULL
);

CREATE TABLE playerStats (
	stat_id INT NOT NULL PRIMARY KEY IDENTITY(1, 1),
	player_id INT NOT NULL REFERENCES player(player_id),
    game_id INT NOT NULL REFERENCES game(game_id),
    minutes FLOAT NOT NULL,
    pts INT NOT NULL,
    reb INT NOT NULL,
    ast INT NOT NULL,
    stl INT NOT NULL,
    blk INT NOT NULL,
    fgm INT NOT NULL,
    fga INT NOT NULL,
    tfgm INT NOT NULL,
    tfga INT NOT NULL,
    ftm INT NOT NULL, 
    fta INT NOT NULL,
    turno INT NOT NULL,
    fouls INT NOT NULL
);

SELECT * FROM roles;
SELECT * FROM users;


    



    



