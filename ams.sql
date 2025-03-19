CREATE DATABASE AirlineReservation;

USE AirlineReservation;

CREATE TABLE User (
    userId VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('Customer', 'BusinessCustomer', 'AirlineAgent') NOT NULL
);


CREATE TABLE Customer (
    userId INT PRIMARY KEY,
    loyaltyPoints INT DEFAULT 0 CHECK (loyaltyPoints >= 0),
    FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE
);

CREATE TABLE BusinessCustomer (
    userId VARCHAR(50) PRIMARY KEY,
    companyName VARCHAR(255) NOT NULL,
    businessAccountId VARCHAR(50) NOT NULL,
    FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE
);


CREATE TABLE AirlineAgent (
    userId INT PRIMARY KEY,
    airline VARCHAR(100) NOT NULL,
    FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE
);

CREATE TABLE Flight (
    flightId VARCHAR(50) PRIMARY KEY,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departureTime DATETIME NOT NULL,
    arrivalTime DATETIME NOT NULL,
    Seats INT NOT NULL,
    seatNumber VARCHAR(10),
    price DECIMAL(10, 2) NOT NULL,
    seat_classes JSON NOT NULL, 
   meal_type ENUM('VEG', 'NON_VEG', 'VEGAN', 'KOSHER', 'HALAL') NOT NULL
);



CREATE TABLE Booking (
    bookingId VARCHAR(50) PRIMARY KEY,
    userId INT NOT NULL,
    flightId INT NOT NULL,
    seatClass ENUM('Economy', 'Business', 'First') NOT NULL,
    bookingDate DATETIME DEFAULT NOW(),
    status ENUM('CONFIRMED', 'CANCELED') DEFAULT 'CONFIRMED', -- Added status
    FOREIGN KEY (userId) REFERENCES User(userId) ON DELETE CASCADE,
    FOREIGN KEY (flightId) REFERENCES Flight(flightId) ON DELETE CASCADE,
    UNIQUE (userId, flightId)
);


CREATE TABLE Payment (
    paymentId VARCHAR(50) PRIMARY KEY,
    bookingId INT UNIQUE NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    status ENUM('PAID', 'REFUNDED') DEFAULT 'PAID', -- Added status
    paymentDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (bookingId) REFERENCES Booking(bookingId) ON DELETE CASCADE
);

