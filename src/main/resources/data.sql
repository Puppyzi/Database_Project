-- Stations (10)
INSERT IGNORE INTO `stations` (`station_id`, `name`, `address`, `phone`) VALUES
  (1, 'Central Station', '100 Main St', '555-0100'),
  (2, 'North Precinct', '200 North Ave', '555-0101'),
  (3, 'South Precinct', '300 South Ave', '555-0102'),
  (4, 'East Precinct', '400 East Blvd', '555-0103'),
  (5, 'West Precinct', '500 West Blvd', '555-0104'),
  (6, 'Harbor Unit', '12 Dock Rd', '555-0105'),
  (7, 'Airport Unit', '1 Terminal Way', '555-0106'),
  (8, 'Downtown Substation', '75 Market St', '555-0107'),
  (9, 'Uptown Substation', '88 Hill Rd', '555-0108'),
  (10, 'Training Academy', '9 Academy Ln', '555-0109');

-- Officers (10)
INSERT IGNORE INTO `officers` (`officer_id`, `first_name`, `last_name`, `badge_number`, `rank`, `station_id`) VALUES
  (1, 'Alex', 'Rivera', 'B-1001', 'Sergeant', 1),
  (2, 'Jordan', 'Kim', 'B-1002', 'Officer', 2),
  (3, 'Taylor', 'Nguyen', 'B-1003', 'Detective', 1),
  (4, 'Casey', 'Patel', 'B-1004', 'Officer', 3),
  (5, 'Morgan', 'Reed', 'B-1005', 'Lieutenant', 4),
  (6, 'Riley', 'Lopez', 'B-1006', 'Detective', 5),
  (7, 'Cameron', 'Chen', 'B-1007', 'Officer', 6),
  (8, 'Avery', 'Davis', 'B-1008', 'Sergeant', 7),
  (9, 'Quinn', 'Johnson', 'B-1009', 'Officer', 8),
  (10, 'Skyler', 'Brown', 'B-1010', 'Detective', 9);

-- Cases (10)
INSERT IGNORE INTO `cases` (`case_id`, `title`, `description`, `status`, `date_opened`, `date_closed`, `lead_officer_id`) VALUES
  (1, 'Burglary - Market St', 'Reported burglary at a retail store on Market St.', 'OPEN', '2025-01-12', NULL, 3),
  (2, 'Vandalism - North Ave', 'Graffiti and property damage reported near North Ave.', 'CLOSED', '2024-12-05', '2024-12-20', 2),
  (3, 'Missing Person - Uptown', 'Missing person report filed by family.', 'OPEN', '2025-02-03', NULL, 10),
  (4, 'Fraud - Online Purchase', 'Online payment fraud investigation.', 'OPEN', '2025-01-25', NULL, 6),
  (5, 'Assault - Downtown', 'Assault reported outside a downtown venue.', 'CLOSED', '2024-11-10', '2024-11-28', 1),
  (6, 'Traffic Hit-and-Run', 'Vehicle fled scene after collision.', 'OPEN', '2025-03-01', NULL, 5),
  (7, 'Theft - Airport', 'Luggage theft reported at airport baggage claim.', 'OPEN', '2025-02-18', NULL, 8),
  (8, 'Harbor Trespassing', 'Unauthorized entry reported at harbor facility.', 'CLOSED', '2024-10-02', '2024-10-04', 7),
  (9, 'Shoplifting - West Blvd', 'Shoplifting report from retail store.', 'OPEN', '2025-01-08', NULL, 9),
  (10, 'Noise Complaints - South', 'Repeated disturbance/noise complaints.', 'CLOSED', '2024-09-15', '2024-09-18', 4);

-- Suspects (10)
INSERT IGNORE INTO `suspects` (`suspect_id`, `first_name`, `last_name`, `dob`, `address`, `case_id`) VALUES
  (1, 'Jamie', 'Foster', '1995-06-14', '22 Pine St', 1),
  (2, 'Drew', 'Walker', '1988-03-02', '410 North Ave', 2),
  (3, 'Sam', 'Carter', '2001-10-30', '19 Hill Rd', 3),
  (4, 'Blake', 'Simmons', '1992-01-09', '8 Lake View Dr', 4),
  (5, 'Reese', 'Howard', '1985-07-21', '77 Market St', 5),
  (6, 'Parker', 'Russell', '1999-12-12', '5 West Blvd', 6),
  (7, 'Kendall', 'Barnes', '1990-09-05', '1 Terminal Way', 7),
  (8, 'Rowan', 'Price', '1983-04-18', '12 Dock Rd', 8),
  (9, 'Hayden', 'Stewart', '2000-11-11', '500 West Blvd', 9),
  (10, 'Emerson', 'Brooks', '1997-02-27', '300 South Ave', 10); 
