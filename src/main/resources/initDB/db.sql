DROP TABLE IF EXISTS students;

CREATE TABLE students (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(30) NOT NULL,
                          last_name VARCHAR(42) NOT NULL,
                          city VARCHAR(42) NOT NULL,
                          phone VARCHAR(20) NOT NULL,
                          gender VARCHAR(25) NOT NULL
);

INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Ailn', 'Rathmouth', 'Rathmouth', '05144461974', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Hounson', 'Port Lolamouth', 'Port Lolamouth', '1-136-366-9496', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Tison', 'Lavernastad', 'Lavernastad', '157-283-0337x872', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Surmeyers', 'Ethelville', 'Ethelville', '552.496.5910', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Bob', 'Schulistland', 'Schulistland', '895-877-0076x197', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Holdey', 'Kennithside', 'Kennithside', '(055)403-3761', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Blewmen', 'Oberbrunnerchester', 'Oberbrunnerchester', '(598)918-4548x480', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Vanacci', 'Marcoport', 'Marcoport', '013-440-6362', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Marflitt', 'New Adalineton', 'New Adalineton', '1-113-016-8153x30326', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Pietesch', 'East Kayla', 'East Kayla', '(177)500-7249', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Henrique', 'Kevinmouth', 'Kevinmouth', '1-241-311-9984', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Tynan', 'North Deondreland', 'North Deondreland', '(674)474-7300', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Pinkard', 'Port Adrianaborough', 'Port Adrianaborough', '02115446108', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Haslock', 'South Hunter', 'South Hunter', '09398525252', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Rickell', 'East Breanne', 'East Breanne', '692.772.5134x95174', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Bob', 'Port Thoraland', 'Port Thoraland', '1-628-108-7615', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Boxhill', 'West Jedediahville', 'West Jedediahville', '(725)577-0459', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Leeke', 'Franeckiland', 'Franeckiland', '1-889-468-2992x930', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Ori', 'Beattyburgh', 'Beattyburgh', '08253021064', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Tagg', 'Oberbrunnerport', 'Oberbrunnerport', '1-725-956-1107x13861', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Costerd', 'Ricofort', 'Ricofort', '096-776-9198', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Corrin', 'East Graycefurt', 'East Graycefurt', '(583)403-4746', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Bunford', 'West Joeport', 'West Joeport', '(245)726-8274x48974', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Lumley', 'Oceanestad', 'Oceanestad', '06965723793', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Whiles', 'Creolashire', 'Creolashire', '800.294.1751x13357', 'Male');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Presdee', 'North Ernestinaton', 'North Ernestinaton', '556-111-2276x003', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Bedberry', 'Jakaylaland', 'Jakaylaland', '1-078-468-7156', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Danilchev', 'North Esta', 'North Esta', '1-244-938-3948', 'Female');
INSERT INTO students (first_name, last_name, city, phone, gender) VALUES ( 'Whaplington', 'West Breanabury', 'West Breanabury', '1-045-399-1032x67023', 'Female');

DROP TABLE IF EXISTS marks;

CREATE TABLE marks (
                       id SERIAL PRIMARY KEY,
                       student_id INT NOT NULL,
                       mark INT NOT NULL,
                       subject VARCHAR(50) NOT NULL
);

INSERT INTO marks (student_id, mark, subject) VALUES ( 3, 23,  'Magic Survival');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 56,  'Planetary Geography');
INSERT INTO marks (student_id, mark, subject) VALUES ( 9, 77,  'Foreign Evolutionary Biology');
INSERT INTO marks (student_id, mark, subject) VALUES ( 6, 83,  'Intergallactic Relations');
INSERT INTO marks (student_id, mark, subject) VALUES ( 9, 45,  'Grand Strategy');
INSERT INTO marks (student_id, mark, subject) VALUES ( 7, 76,  'Foreign History');
INSERT INTO marks (student_id, mark, subject) VALUES ( 1, 98,  'Alien Dance History');
INSERT INTO marks (student_id, mark, subject) VALUES ( 7, 87,  'Foreign Social Skills');
INSERT INTO marks (student_id, mark, subject) VALUES ( 8, 65,  'Alien Social Skills');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 76,  'Magic Music');
INSERT INTO marks (student_id, mark, subject) VALUES ( 8, 76,  'Alien Genealogy');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 89,  'Magic Rituals');
INSERT INTO marks (student_id, mark, subject) VALUES ( 1, 69,  'Planetary Ecology');
INSERT INTO marks (student_id, mark, subject) VALUES ( 7, 79,  'Military Law');
INSERT INTO marks (student_id, mark, subject) VALUES ( 3, 57,  'Foreign Ethics');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 56,  'Foreign Instrumental Music');
INSERT INTO marks (student_id, mark, subject) VALUES ( 8, 59,  'Foreign Services');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 91,  'Alien Economics');
INSERT INTO marks (student_id, mark, subject) VALUES ( 1, 91,  'Alien Ethics');
INSERT INTO marks (student_id, mark, subject) VALUES ( 9, 23,  'Magic Arts');
INSERT INTO marks (student_id, mark, subject) VALUES ( 6, 34,  'Alien Social Studies');
INSERT INTO marks (student_id, mark, subject) VALUES ( 7, 54,  'Foreign Political Sciences');
INSERT INTO marks (student_id, mark, subject) VALUES ( 8, 56,  'Terraforming');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 76,  'Transmutation');
INSERT INTO marks (student_id, mark, subject) VALUES ( 1, 98,  'Space Travel');
INSERT INTO marks (student_id, mark, subject) VALUES ( 5, 76,  'Alien Medicine');
INSERT INTO marks (student_id, mark, subject) VALUES ( 3, 98,  'Foreign Statistics');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 100, 'Necromancy');
INSERT INTO marks (student_id, mark, subject) VALUES ( 6, 00,  'Magic Music');
INSERT INTO marks (student_id, mark, subject) VALUES ( 2, 34,  'Planetary History');
INSERT INTO marks (student_id, mark, subject) VALUES ( 6, 58,  'Herbalism');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 34,  'Dimensional Manipulation');
INSERT INTO marks (student_id, mark, subject) VALUES ( 4, 67,  'Nutrition Recognition');
INSERT INTO marks (student_id, mark, subject) VALUES ( 3, 56,  'Foreign Pathology');
INSERT INTO marks (student_id, mark, subject) VALUES ( 6, 88,  'Foreign Arts');
INSERT INTO marks (student_id, mark, subject) VALUES ( 7, 80,  'Alien Bioengineering');
INSERT INTO marks (student_id, mark, subject) VALUES ( 6, 81,  'Alien Physiology');
INSERT INTO marks (student_id, mark, subject) VALUES ( 2, 71,  'Mathematics');
INSERT INTO marks (student_id, mark, subject) VALUES ( 1, 72,  'Foreign Arts');
INSERT INTO marks (student_id, mark, subject) VALUES ( 3, 84,  'Galactic History');
INSERT INTO marks (student_id, mark, subject) VALUES ( 31, 84, 'Galactic History');