


Comp3005 Final Project V2

Name: David Simonov
Student ID: 101232041

Name: Teniola Hambolu
Student ID: 101220076


list of files
SQL- directory containing the DDL and DML files
    - DDL.sql - for creating the database and all the required tables
    - DML.sql - for populating each table with database
ERmodel.pdf - contains the ER-model as well as the relational schema for the database
.java - the code for the application
for compilation
Git Repo Link: https://github.com/teniollaa/COMP3005FinalProject

Steps To Compile + Run Application:
1: Make sure postsql and Intellij and jdbc are installed and open.
2: On pgadmin4/postsql, make your database you wish to use.
3: Run pom.xml, as it will create the needed libraries for you.
4: On line 6 "jdbc:postgresql://localhost:5432/A3Q1" change host port and the name to what matches your computer.
5: Run the program and input 5 if you don't already have your student table created for your database, it will make the table and put in default values as per spec.
6: Input 1,2,3, or 4 to test all of the functions or 6 to exit as needed.

Input dll:
CREATE TABLE Members (
    member_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    height FLOAT NOT NULL,
    mass FLOAT NOT NULL,
    goal_weight FLOAT NOT NULL,
    achieved BOOLEAN DEFAULT FALSE,
    owed_bills FLOAT NOT NULL
);

CREATE TABLE Trainers (
    trainer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    start_availability INT NOT NULL,
    end_availability INT NOT NULL
);

CREATE TABLE Sessions ( --Session with trainer and which member.
    session_id SERIAL PRIMARY KEY,
    trainer_id INT NOT NULL,
    member_id INT NOT NULL,
    start_time INT NOT NULL, --Military Time
    end_time INT NOT NULL,
    room_number INT NOT NULL  
);

Input dml:
INSERT INTO Members (first_name, last_name, email, height, mass, goal_weight, achieved, owed_bills) VALUES
('Odell', 'Beckham', 'obj@gravens.com', 182.5, 95, 85, FALSE, 200.00),
('Tom', 'Sawyer', 'fence@huckleberry.com', 174, 80, 75, TRUE, 150.00),
('Elijah', 'Fisher', 'fishhhhh@gmail.com', 201, 90.7, 88, FALSE, 180.00),
('Wanda', 'Crown', 'fairly@ytv.com', 152, 62.3, 60, FALSE, 100.00),
('Cosmo', 'Crown', 'odd@ytv.com', 160, 70, 65, FALSE, 120.00),
('Timmy', 'Turner', 'parents@ytv.com', 170, 80.5, 75, FALSE, 140.00),
('Brodie', 'Johnson', 'shredz67n@gmail.com', 190, 98, 90, FALSE, 210.00),
('Bridgette', 'Mendler', 'Charlie@goodluck.com', 174.3, 68, 65, TRUE, 110.00),
('Spencer', 'Baker', 'allamerican@gmail.com', 179.4, 87.9, 85, FALSE, 175.00),
('Tyrel', 'Harris', 'relyharry@gmail.com', 170.4, 70.3, 68, FALSE, 90.00),
('Kentrel', 'Martin', 'youngboy@nba.com', 163.6, 86.4, 80, FALSE, 160.00),
('Teron', 'Beckham', 'fbaftermath@gmail.com', 152.4, 84.4, 79, TRUE, 150.00),
('Katie', 'Clarke', 'green@leadingscorer.com', 195.4, 90.3, 86, FALSE, 170.00),
('Taurus', 'Bartlet', 'polo.g@capalot.com', 200, 92.3, 88, TRUE, 180.00),
('Sam', 'Pucket', 'butter@sock.com', 174.4, 67.3, 62, FALSE, 100.00),
('Liv', 'Rooney', 'livarooney@gmail.com', 170.4, 78.5, 74, FALSE, 130.00),
('Madison', 'Rooney', 'maddyarooney@gmail.com', 152, 55.6, 53, FALSE, 80.00);

-- Populate Trainers
INSERT INTO Trainers (first_name, last_name, email, start_availability, end_availability) VALUES
('Dave', 'Santan', 'streathamborn@gmail.com', 06, 16),
('Aubrey', 'Graham', 'drake@ovosound.com', 09, 17),
('Franklin', 'Saint', 'saint@yahoo.com', 15, 22),
('Jermaine', 'Cole', 'blaza@dreamville.com', 14, 20),
('Rakim', 'Mayers', 'prettyflacko@asap.com', 07, 14);

-- Populate Sessions
INSERT INTO Sessions (trainer_id, member_id, start_time, end_time, room_number) VALUES
(1, 1, 800, 07, 09),
(1, 2, 910, 10, 12),
(1, 3, 1020, 14, 15),
(2, 4, 900, 10, 11),
(2, 5, 1010, 12, 15),
(2, 6, 1120, 16, 17),
(3, 7, 1000, 15, 16),
(3, 8, 1110, 17, 20),
(3, 9, 1220, 20, 22),
(4, 10, 1100, 14, 16),
(4, 11, 1210, 16, 20),
(4, 12, 1320, 20, 21),
(5, 13, 1200, 07, 10),
(5, 14, 1310, 10, 12),
(5, 15, 1420, 12, 14);
