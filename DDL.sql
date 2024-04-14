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