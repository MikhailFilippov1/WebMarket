CREATE TABLE students (
        id                  bigserial primary key,
        name               VARCHAR(255),
        age               int
       );
INSERT INTO students (name, age)
VALUES
('BILL', 25),
 ('BOB', 24),
  ('MIKE', 25),
   ('SUSANNE', 15),
    ('FILLIPP', 45);