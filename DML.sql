-- Insert sample data into City
INSERT INTO City (Name, State, Country, Latitude, Longitude) VALUES
('New York', 'New York', 'USA', 40.7128, -74.0060),
('Los Angeles', 'California', 'USA', 34.0522, -118.2437);

-- Insert sample data into Theatre
INSERT INTO Theatre (Name, Address, CityID) VALUES
('Cineplex Theatre', '123 Broadway, New York, NY', 1),
('Hollywood Cinema', '456 Sunset Blvd, Los Angeles, CA', 2);

-- Insert sample data into KYCInfo
INSERT INTO KYCInfo (TheatreID, LicenceNumber, CertificateDetails, ExpiryDate) VALUES
(1, 'LIC123456', 'Business Licence', '2025-12-31'),
(2, 'LIC654321', 'Business Licence', '2025-12-31');

-- Insert sample data into Movie
INSERT INTO Movie (Title, Language, Genre, Duration) VALUES
('Inception', 'English', 'Sci-Fi', '02:28:00'),
('The Dark Knight', 'English', 'Action', '02:32:00');

-- Insert sample data into Screen
INSERT INTO Screen (TheatreID, ScreenNumber, Capacity, ScreenType) VALUES
(1, 1, 200, 'IMAX'),
(2, 1, 150, 'Standard');

-- Insert sample data into Seat
INSERT INTO Seat (ScreenID, SeatNumber, SeatType, Fare, Availability) VALUES
(1, 'A1', 'Regular', 15.00, TRUE),
(1, 'A2', 'VIP', 25.00, TRUE),
(2, 'B1', 'Regular', 12.00, TRUE),
(2, 'B2', 'Premium', 20.00, TRUE);

-- Insert sample data into Show
INSERT INTO Showing (MovieID, TheatreID, ScreenID, ShowTime, Date) VALUES
(1, 1, 1, '19:00:00', '2024-09-20'),
(2, 2, 1, '21:00:00', '2024-09-20');

-- Insert sample data into User
INSERT INTO User (Name, Email, Password, Role) VALUES
('Alice Johnson', 'alice.johnson@example.com', 'password123', 'Customer'),
('Bob Smith', 'bob.smith@example.com', 'password456', 'Theatre Partner');

-- Insert sample data into Booking
INSERT INTO Booking (UserID, ShowID, BookingDate, TotalAmount) VALUES
(1, 1, '2024-09-15', 30.00);

-- Insert sample data into BookingDetail
INSERT INTO BookingDetail (BookingID, SeatID, Fare, Discount) VALUES
(1, 1, 15.00, 0.00),
(1, 2, 25.00, 5.00);

-- Insert sample data into Payment
INSERT INTO Payment (BookingID, PaymentDate, Amount, PaymentStatus) VALUES
(1, '2024-09-15', 30.00, 'Completed');

-- Insert sample data into Campaign
INSERT INTO Campaign (Description, DiscountPercentage, StartDate, EndDate) VALUES
('Third Ticket 50% Off', 50.00, '2024-09-01', '2024-12-31');

-- Insert sample data into Notification
INSERT INTO Notification (UserID, NotificationType, Message, SentDate) VALUES
(1, 'Booking Confirmation', 'Your booking for Inception has been confirmed!', '2024-09-15');
