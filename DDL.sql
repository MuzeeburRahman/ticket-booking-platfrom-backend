-- Create database
CREATE DATABASE MovieTicketBooking;
USE MovieTicketBooking;

-- User Table
CREATE TABLE User (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    Role ENUM('Customer', 'Theatre Partner') NOT NULL
);

-- City Table
CREATE TABLE City (
    CityID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    State VARCHAR(255),
    Country VARCHAR(255),
    Latitude DECIMAL(9, 6),
    Longitude DECIMAL(9, 6)
);

-- Theatre Table
CREATE TABLE Theatre (
    TheatreID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Address TEXT NOT NULL,
    CityID INT,
    FOREIGN KEY (CityID) REFERENCES City(CityID)
);
-- KYCInfo Table
CREATE TABLE KYCInfo (
    KYCInfoID INT AUTO_INCREMENT PRIMARY KEY,
    TheatreID INT,
    LicenceNumber VARCHAR(255),
    CertificateDetails TEXT,
    ExpiryDate DATE,
    FOREIGN KEY (TheatreID) REFERENCES Theatre(TheatreID)
);



-- Movie Table
CREATE TABLE Movie (
    MovieID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Language VARCHAR(100),
    Genre VARCHAR(100),
    Duration TIME
);

-- Screen Table
CREATE TABLE Screen (
    ScreenID INT AUTO_INCREMENT PRIMARY KEY,
    TheatreID INT,
    ScreenNumber INT NOT NULL,
    Capacity INT NOT NULL,
    ScreenType VARCHAR(100),
    FOREIGN KEY (TheatreID) REFERENCES Theatre(TheatreID)
);

-- Seat Table
CREATE TABLE Seat (
    SeatID INT AUTO_INCREMENT PRIMARY KEY,
    ScreenID INT,
    SeatNumber VARCHAR(10),
    SeatType VARCHAR(100),
    Fare DECIMAL(10, 2),
    Availability BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (ScreenID) REFERENCES Screen(ScreenID)
);

-- Show Table
CREATE TABLE Showing (
    ShowID INT AUTO_INCREMENT PRIMARY KEY,
    MovieID INT,
    TheatreID INT,
    ScreenID INT,
    ShowTime TIME,
    Date DATE,
    FOREIGN KEY (MovieID) REFERENCES Movie(MovieID),
    FOREIGN KEY (TheatreID) REFERENCES Theatre(TheatreID),
    FOREIGN KEY (ScreenID) REFERENCES Screen(ScreenID)
);

-- Booking Table
CREATE TABLE Booking (
    BookingID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    ShowID INT,
    BookingDate DATE,
    TotalAmount DECIMAL(10, 2),
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (ShowID) REFERENCES Showing(ShowID)
);

-- BookingDetail Table
CREATE TABLE BookingDetail (
    BookingDetailID INT AUTO_INCREMENT PRIMARY KEY,
    BookingID INT,
    SeatID INT,
    Fare DECIMAL(10, 2),
    Discount DECIMAL(10, 2),
    FOREIGN KEY (BookingID) REFERENCES Booking(BookingID),
    FOREIGN KEY (SeatID) REFERENCES Seat(SeatID)
);

-- Payment Table
CREATE TABLE Payment (
    PaymentID INT AUTO_INCREMENT PRIMARY KEY,
    BookingID INT,
    PaymentDate DATE,
    Amount DECIMAL(10, 2),
    PaymentStatus ENUM('Pending', 'Completed', 'Failed'),
    FOREIGN KEY (BookingID) REFERENCES Booking(BookingID)
);

-- Campaign Table
CREATE TABLE Campaign (
    CampaignID INT AUTO_INCREMENT PRIMARY KEY,
    Description VARCHAR(255),
    DiscountPercentage DECIMAL(5, 2),
    StartDate DATE,
    EndDate DATE
);

-- Notification Table
CREATE TABLE Notification (
    NotificationID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    NotificationType VARCHAR(100),
    Message TEXT,
    SentDate DATE,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

select * from Notification