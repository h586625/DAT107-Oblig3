-- Skript for å opprette databasen og legge inn litt data
    -- Skjema = oblig_3
        -- Tabell(er) = ansatt 

-- MERK!!! DROP SCHEMA ... CASCADE sletter alt !!!
DROP SCHEMA IF EXISTS oblig_3 CASCADE;

CREATE SCHEMA oblig_3;
SET search_path TO oblig_3;
    
-- Ikke nødvendig å slette tabellen(e) siden vi har tomt skjema, men ...
-- DROP TABLE person;

CREATE TABLE oblig_3.avdeling
(
    avdelingid serial,
    navn VARCHAR(100) NOT NULL,
    sjef integer NOT NULL,
    CONSTRAINT avdeling_pk PRIMARY KEY (avdelingid)
);

CREATE SEQUENCE avdeling_seq START 10 INCREMENT 10 OWNED BY oblig_3.avdeling.avdelingid;

INSERT INTO
  oblig_3.avdeling(avdelingid, navn, sjef)
VALUES
    (nextval('avdeling_seq'), 'Support', 1001),
    (nextval('avdeling_seq'), 'Teknisk', 1002),
    (nextval('avdeling_seq'), 'Markedsføring', 1001);

CREATE TABLE Ansatt
(
	ansattid SERIAL NOT NULL,
	brukernavn VARCHAR(4) NOT NULL,
	fornavn VARCHAR(30) NOT NULL,
	etternavn VARCHAR(30) NOT NULL,
	ansettelsesdato DATE DEFAULT CURRENT_DATE NOT NULL,
	stilling VARCHAR(30) NOT NULL,
    lonn integer NOT NULL,
	avdelingid integer NOT NULL,
	FOREIGN KEY (avdelingid) REFERENCES oblig_3.avdeling (avdelingid),
    CONSTRAINT ansatt_pk PRIMARY KEY (ansattid)
);
CREATE SEQUENCE ansatt_seq START 1000 INCREMENT 1 OWNED BY oblig_3.ansatt.ansattid;

INSERT INTO
  Ansatt(ansattid, brukernavn, fornavn, etternavn, ansettelsesdato, stilling, lonn, avdelingid)
VALUES
    (nextval('ansatt_seq'), 'SPSH', 'Stian', 'Hauge', '2000-02-15', 'Leder', 1000000, 10),
    (nextval('ansatt_seq'), 'CBR', 'Chris', 'Riis', '2005-07-06', 'Pleb', 250000, 30),
    (nextval('ansatt_seq'), 'EKE', 'Eirik', 'Edgren', '2016-11-21', 'Pleb2', 1000000,20);

CREATE TABLE oblig_3.prosjekt
(
    prosjektid integer NOT NULL,
    navn VARCHAR(100) NOT NULL,
    beskrivelse VARCHAR(400),
    CONSTRAINT prosjekt_pk PRIMARY KEY (prosjektid)
);

INSERT INTO
  oblig_3.prosjekt(prosjektid, navn, beskrivelse)
VALUES
    (1, 'Dark matter weapon', 'Ask pleb Stian for description.'),
    (2, 'Deathray', 'Lethal but beautiful'),
    (3, 'Remotely controlled war-turtles', 'No commentary');

CREATE TABLE oblig_3.prosjekter
(
    prosjektid integer NOT NULL,
    ansattid integer NOT NULL,
    stilling VARCHAR(30),
    timeantall integer,
    FOREIGN KEY (prosjektid) REFERENCES oblig_3.prosjekt (prosjektid),
    FOREIGN KEY (ansattid) REFERENCES oblig_3.ansatt (ansattid)
);

INSERT INTO
  oblig_3.prosjekter(prosjektid, ansattid, stilling, timeantall)
VALUES
    (1, 1000, 'Mad scientist', 30),
    (1, 1002, 'Pleb', 10),
    (2, 1001, 'Pleb', 100);
	
ALTER TABLE oblig_3.avdeling ADD CONSTRAINT sjef_fk FOREIGN KEY (sjef) REFERENCES oblig_3.ansatt (ansattid);