/*
Created: 12.11.2020
Modified: 17.11.2020
Project: Dom Kultury
Model: Dom_kultury
Company: Politechnika Warszawska
Author: Michał Prądziński, Marcin Ruta
Version: 1.4
Database: Oracle 12c
*/


-- Create sequences section -------------------------------------------------

CREATE SEQUENCE DomSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE AdresSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE PocztySeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE PracownikSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE DokumentSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE ZezwolenieSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE SpecjalizacjeSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE UczestnikSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE StanowiskoSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE SalaSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE WydarzenieSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE RealizacjaSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE WynagrodzenieSeq1
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

-- Create tables section -------------------------------------------------

-- Table Domy_Kultury

CREATE TABLE Domy_Kultury(
  ID_Domu Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL,
  Data_zalozenia Date NOT NULL,
  Dyrektor Varchar2(60 ) NOT NULL,
  ID_Adresu Integer NOT NULL
)
/

-- Create indexes for table Domy_Kultury

CREATE INDEX IX_Adres_posiada ON Domy_Kultury (ID_Adresu)
/

-- Add keys for table Domy_Kultury

ALTER TABLE Domy_Kultury ADD CONSTRAINT Unique_Identifier1 PRIMARY KEY (ID_Domu)
/

-- Table and Columns comments section

COMMENT ON COLUMN Domy_Kultury.Dyrektor IS 'Imie i nazwisko dyrektora'
/

-- Table Pracownicy

CREATE TABLE Pracownicy(
  ID_Pracownika Integer NOT NULL,
  Imie Varchar2(20 ) NOT NULL,
  Nazwisko Varchar2(30 ) NOT NULL,
  Data_Urodzenia Date NOT NULL,
  PESEL Char(11 ),
  Nr_telefonu Varchar2(12 ),
  Email Varchar2(50 ) NOT NULL,
  Plec Varchar2(15 ) NOT NULL
        CHECK (Plec IN ('Mezczyzna','Kobieta')),
  Data_Zatrudnienia Date NOT NULL,
  Data_Zwolnienia Date,
  ID_Domu Integer NOT NULL,
  ID_Adresu Integer NOT NULL,
  ID_Stanowiska Integer NOT NULL
)
/

-- Create indexes for table Pracownicy

CREATE INDEX IX_Zatrudnia ON Pracownicy (ID_Domu)
/

CREATE INDEX IX_Adres_jest_posiadany ON Pracownicy (ID_Adresu)
/

CREATE INDEX IX_Stanowisko_posiada ON Pracownicy (ID_Stanowiska)
/

-- Add keys for table Pracownicy

ALTER TABLE Pracownicy ADD CONSTRAINT Unique_Identifier2 PRIMARY KEY (ID_Pracownika)
/

-- Table Prowadzacy

CREATE TABLE Prowadzacy(
  ID_Pracownika Integer NOT NULL,
  Wyksztalcenie Varchar2(35 ) NOT NULL
        CHECK (Wyksztalcenie IN ('podstawowe','gimnazjalne','srednie','wyzsze','zasadnicze_zawodowe','zasadnicze_branzowe','srednie_branzowe')),
  Nr_Dokumentu Varchar2(30 ) NOT NULL,
  Data_Wydania_Dokumentu Date NOT NULL,
  ID_Dokumentu Integer NOT NULL
)
/

-- Create indexes for table Prowadzacy

CREATE INDEX IX_Jest_posiadany ON Prowadzacy (ID_Dokumentu)
/

-- Add keys for table Prowadzacy

ALTER TABLE Prowadzacy ADD CONSTRAINT Unique_Identifier3 PRIMARY KEY (ID_Pracownika)
/

-- Table Organizatorzy

CREATE TABLE Organizatorzy(
  ID_Pracownika Integer NOT NULL,
  Nr_Zezwolenia Varchar2(30 ) NOT NULL,
  Data_Wydania_Zezwolenia Date NOT NULL,
  Data_Waznosci_Zezwolenia Date
)
/

-- Add keys for table Organizatorzy

ALTER TABLE Organizatorzy ADD CONSTRAINT Unique_Identifier4 PRIMARY KEY (ID_Pracownika)
/

-- Table Wydarzenia

CREATE TABLE Wydarzenia(
  ID_Wydarzenia Integer NOT NULL,
  Nazwa_Wydarzenia Varchar2(50 ) NOT NULL,
  Maksymalna_ilosc_uczestnikow Integer NOT NULL,
  Wymagana_Zgoda_Rodzica Char(1 ) NOT NULL,
  ID_Domu Integer NOT NULL
)
/

-- Create indexes for table Wydarzenia

CREATE INDEX IX_Oferuje ON Wydarzenia (ID_Domu)
/

-- Add keys for table Wydarzenia

ALTER TABLE Wydarzenia ADD CONSTRAINT Unique_Identifier5 PRIMARY KEY (ID_Wydarzenia)
/

-- Table Uczestnicy

CREATE TABLE Uczestnicy(
  ID_Uczestnika Integer NOT NULL,
  Imie Varchar2(30 ) NOT NULL,
  Nazwisko Varchar2(30 ) NOT NULL,
  Plec Varchar2(15 ) NOT NULL
        CHECK (Plec IN ('Mezczyzna','Kobieta')),
  Data_Urodzenia Date NOT NULL,
  Numer_Telefonu Varchar2(12 ),
  Email Varchar2(50 ) NOT NULL,
  ID_Adresu Integer
)
/

-- Create indexes for table Uczestnicy

CREATE INDEX IX_Adres_ma ON Uczestnicy (ID_Adresu)
/

-- Add keys for table Uczestnicy

ALTER TABLE Uczestnicy ADD CONSTRAINT Unique_Identifier6 PRIMARY KEY (ID_Uczestnika)
/

-- Table Sale

CREATE TABLE Sale(
  ID_Sali Integer NOT NULL,
  Numer_Sali Char(3 ) NOT NULL,
  Nazwa_Sali Varchar2(40 ),
  Maksymalna_Pojemnosc Integer NOT NULL,
  Czy_Rzutnik Char(1 ) NOT NULL,
  Czy_Internet Char(1 ) NOT NULL,
  ID_Domu Integer NOT NULL
)
/

-- Create indexes for table Sale

CREATE INDEX IX_Dom_posiada ON Sale (ID_Domu)
/

-- Add keys for table Sale

ALTER TABLE Sale ADD CONSTRAINT Unique_Identifier7 PRIMARY KEY (ID_Sali)
/

-- Table Obslugiwanie_wydarzenia

CREATE TABLE Obslugiwanie_wydarzenia(
  ID_Pracownika Integer NOT NULL,
  ID_Realizacji_Wydarzenia Integer NOT NULL
)
/

-- Table Zapisy_na_wydarzenie

CREATE TABLE Zapisy_na_wydarzenie(
  ID_Uczestnika Integer NOT NULL,
  ID_Realizacji_Wydarzenia Integer NOT NULL,
  Data_zapisu Date NOT NULL
)
/

-- Table and Columns comments section

COMMENT ON COLUMN Zapisy_na_wydarzenie.Data_zapisu IS 'Data zapisu na dane zajęcia'
/

-- Table Adresy

CREATE TABLE Adresy(
  ID_Adresu Integer NOT NULL,
  Ulica Varchar2(35 ) NOT NULL,
  Nr_domu Varchar2(8 ) NOT NULL,
  Nr_mieszkania Varchar2(6 ),
  ID_Poczty Integer NOT NULL
)
/

-- Create indexes for table Adresy

CREATE INDEX IX_Posiada_poczte ON Adresy (ID_Poczty)
/

-- Add keys for table Adresy

ALTER TABLE Adresy ADD CONSTRAINT PK_Adresy PRIMARY KEY (ID_Adresu)
/

-- Table and Columns comments section

COMMENT ON COLUMN Adresy.ID_Adresu IS 'Numer identyfikacyjny poczty'
/
COMMENT ON COLUMN Adresy.Ulica IS 'Nazwa ulicy'
/
COMMENT ON COLUMN Adresy.Nr_domu IS 'Numer domu'
/
COMMENT ON COLUMN Adresy.Nr_mieszkania IS 'Numer mieszkania'
/

-- Table Wynagrodzenia

CREATE TABLE Wynagrodzenia(
  ID_Wynagrodzenia Integer NOT NULL,
  Data_wyslania_wynagrodzenia Date NOT NULL,
  Kwota_wynagrodzenia Number(10,2) NOT NULL,
  ID_Pracownika Integer NOT NULL
)
/

-- Create indexes for table Wynagrodzenia

CREATE INDEX IX_Pracownik_otrzymuje ON Wynagrodzenia (ID_Pracownika)
/

-- Add keys for table Wynagrodzenia

ALTER TABLE Wynagrodzenia ADD CONSTRAINT PK_Wynagrodzenia PRIMARY KEY (ID_Wynagrodzenia)
/

-- Table and Columns comments section

COMMENT ON COLUMN Wynagrodzenia.ID_Wynagrodzenia IS 'Numer_identyfikacyjny_wynagrodzenia'
/
COMMENT ON COLUMN Wynagrodzenia.Kwota_wynagrodzenia IS 'Kwota wynagrodzenia'
/

-- Table Poczty

CREATE TABLE Poczty(
  ID_Poczty Integer NOT NULL,
  Kod_pocztowy Char(6 ) NOT NULL,
  Miasto Varchar2(35 ) NOT NULL
)
/

-- Add keys for table Poczty

ALTER TABLE Poczty ADD CONSTRAINT PK_Poczty PRIMARY KEY (ID_Poczty)
/

-- Table and Columns comments section

COMMENT ON COLUMN Poczty.ID_Poczty IS 'Numer identyfikacyjny poczty'
/
COMMENT ON COLUMN Poczty.Kod_pocztowy IS 'Kod pocztowy'
/
COMMENT ON COLUMN Poczty.Miasto IS 'Miasto poczty'
/

-- Table Stanowiska

CREATE TABLE Stanowiska(
  ID_Stanowiska Integer NOT NULL,
  Nazwa_stanowiska Varchar2(35 ) NOT NULL,
  Opis_stanowiska Varchar2(400 )
)
/

-- Add keys for table Stanowiska

ALTER TABLE Stanowiska ADD CONSTRAINT PK_Stanowiska PRIMARY KEY (ID_Stanowiska)
/

-- Table and Columns comments section

COMMENT ON TABLE Stanowiska IS 'Encja opisująca stanowska '
/
COMMENT ON COLUMN Stanowiska.ID_Stanowiska IS 'Numer identyfikacyjny stanowiska'
/
COMMENT ON COLUMN Stanowiska.Nazwa_stanowiska IS 'Nazwa stanowiska'
/
COMMENT ON COLUMN Stanowiska.Opis_stanowiska IS 'Opis stanowiska'
/

-- Table Typy_zezwolen

CREATE TABLE Typy_zezwolen(
  ID_Zezwolenia Integer NOT NULL,
  Nazwa_zezwolenia Varchar2(50 ) NOT NULL,
  Opis_zezwolenia Varchar2(400 )
)
/

-- Add keys for table Typy_zezwolen

ALTER TABLE Typy_zezwolen ADD CONSTRAINT PK_Typy_zezwolen PRIMARY KEY (ID_Zezwolenia)
/

-- Table and Columns comments section

COMMENT ON COLUMN Typy_zezwolen.ID_Zezwolenia IS 'Numer indentyfikacyjny zezwolenia'
/
COMMENT ON COLUMN Typy_zezwolen.Nazwa_zezwolenia IS 'Nazwa zezwolenia, który upoważnia do wykonywania profesji'
/

-- Table Posiadanie_zezwolenia

CREATE TABLE Posiadanie_zezwolenia(
  ID_Pracownika Integer NOT NULL,
  ID_Zezwolenia Integer NOT NULL
)
/

-- Add keys for table Posiadanie_zezwolenia

ALTER TABLE Posiadanie_zezwolenia ADD CONSTRAINT PK_Posiadanie_zezwolenia PRIMARY KEY (ID_Pracownika,ID_Zezwolenia)
/

-- Table Specjalizacje

CREATE TABLE Specjalizacje(
  ID_Specjalizacji Integer NOT NULL,
  Nazwa_specjalizacji Varchar2(50 ) NOT NULL,
  Opis_specjalizacji Varchar2(400 )
)
/

-- Add keys for table Specjalizacje

ALTER TABLE Specjalizacje ADD CONSTRAINT PK_Specjalizacje PRIMARY KEY (ID_Specjalizacji)
/

-- Table and Columns comments section

COMMENT ON COLUMN Specjalizacje.ID_Specjalizacji IS 'Numer identyfikacyjny specjalizacji'
/
COMMENT ON COLUMN Specjalizacje.Nazwa_specjalizacji IS 'Nazwa specjalizacji, jaką się zajmuję'
/
COMMENT ON COLUMN Specjalizacje.Opis_specjalizacji IS 'Opis specjalizacji'
/

-- Table Posiadanie_specjalizacji

CREATE TABLE Posiadanie_specjalizacji(
  ID_Pracownika Integer NOT NULL,
  ID_Specjalizacji Integer NOT NULL
)
/

-- Add keys for table Posiadanie_specjalizacji

ALTER TABLE Posiadanie_specjalizacji ADD CONSTRAINT PK_Posiadanie_specjalizacji PRIMARY KEY (ID_Pracownika,ID_Specjalizacji)
/

-- Table Typy_dokumentow

CREATE TABLE Typy_dokumentow(
  ID_Dokumentu Integer NOT NULL,
  Nazwa_dokumentu Varchar2(50 ) NOT NULL,
  Opis_dokumentu Varchar2(400 )
)
/

-- Add keys for table Typy_dokumentow

ALTER TABLE Typy_dokumentow ADD CONSTRAINT PK_Typy_dokumentow PRIMARY KEY (ID_Dokumentu)
/

-- Table and Columns comments section

COMMENT ON COLUMN Typy_dokumentow.ID_Dokumentu IS 'Numer indentyfikacyjny dokumentu'
/
COMMENT ON COLUMN Typy_dokumentow.Nazwa_dokumentu IS 'Nazwa dokumentu, który upoważnia do wykonywania danego zawodu'
/
COMMENT ON COLUMN Typy_dokumentow.Opis_dokumentu IS 'Opis dokumentu'
/

-- Table Realizacje_Wydarzen

CREATE TABLE Realizacje_Wydarzen(
  ID_Realizacji_Wydarzenia Integer NOT NULL,
  Data_wydarzenia Date NOT NULL,
  Cena Number(10,2) NOT NULL,
  ID_Wydarzenia Integer NOT NULL,
  ID_Sali Integer NOT NULL
)
/

-- Create indexes for table Realizacje_Wydarzen

CREATE INDEX IX_Wydarzenie_ma ON Realizacje_Wydarzen (ID_Wydarzenia)
/

CREATE INDEX IX_Sala_posiada ON Realizacje_Wydarzen (ID_Sali)
/

-- Add keys for table Realizacje_Wydarzen

ALTER TABLE Realizacje_Wydarzen ADD CONSTRAINT PK_Realizacje_Wydarzen PRIMARY KEY (ID_Realizacji_Wydarzenia)
/

-- Table and Columns comments section

COMMENT ON COLUMN Realizacje_Wydarzen.ID_Realizacji_Wydarzenia IS 'Numer indentyfikacyjny realizacji danego wydarzenia'
/
COMMENT ON COLUMN Realizacje_Wydarzen.Data_wydarzenia IS 'Data wydarzenia'
/
COMMENT ON COLUMN Realizacje_Wydarzen.Cena IS 'Cena wydarzenia'
/

-- Trigger for sequence DomSeq1 for column ID_Domu in table Domy_Kultury ---------
CREATE OR REPLACE TRIGGER ts_Domy_Kultury_DomSeq1 BEFORE INSERT
ON Domy_Kultury FOR EACH ROW
BEGIN
  :new.ID_Domu := DomSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Domy_Kultury_DomSeq1 AFTER UPDATE OF ID_Domu
ON Domy_Kultury FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Domu in table Domy_Kultury as it uses sequence.');
END;
/

-- Trigger for sequence PracownikSeq1 for column ID_Pracownika in table Pracownicy ---------
CREATE OR REPLACE TRIGGER ts_Pracownicy_PracownikSeq1 BEFORE INSERT
ON Pracownicy FOR EACH ROW
BEGIN
  :new.ID_Pracownika := PracownikSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Pracownicy_PracownikSeq1 AFTER UPDATE OF ID_Pracownika
ON Pracownicy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Pracownika in table Pracownicy as it uses sequence.');
END;
/

-- Trigger for sequence WydarzenieSeq1 for column ID_Wydarzenia in table Wydarzenia ---------
CREATE OR REPLACE TRIGGER ts_Wydarzenia_WydarzenieSeq1 BEFORE INSERT
ON Wydarzenia FOR EACH ROW
BEGIN
  :new.ID_Wydarzenia := WydarzenieSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Wydarzenia_WydarzenieSeq1 AFTER UPDATE OF ID_Wydarzenia
ON Wydarzenia FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Wydarzenia in table Wydarzenia as it uses sequence.');
END;
/

-- Trigger for sequence UczestnikSeq1 for column ID_Uczestnika in table Uczestnicy ---------
CREATE OR REPLACE TRIGGER ts_Uczestnicy_UczestnikSeq1 BEFORE INSERT
ON Uczestnicy FOR EACH ROW
BEGIN
  :new.ID_Uczestnika := UczestnikSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Uczestnicy_UczestnikSeq1 AFTER UPDATE OF ID_Uczestnika
ON Uczestnicy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Uczestnika in table Uczestnicy as it uses sequence.');
END;
/

-- Trigger for sequence SalaSeq1 for column ID_Sali in table Sale ---------
CREATE OR REPLACE TRIGGER ts_Sale_SalaSeq1 BEFORE INSERT
ON Sale FOR EACH ROW
BEGIN
  :new.ID_Sali := SalaSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Sale_SalaSeq1 AFTER UPDATE OF ID_Sali
ON Sale FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Sali in table Sale as it uses sequence.');
END;
/

-- Trigger for sequence AdresSeq1 for column ID_Adresu in table Adresy ---------
CREATE OR REPLACE TRIGGER ts_Adresy_AdresSeq1 BEFORE INSERT
ON Adresy FOR EACH ROW
BEGIN
  :new.ID_Adresu := AdresSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Adresy_AdresSeq1 AFTER UPDATE OF ID_Adresu
ON Adresy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Adresu in table Adresy as it uses sequence.');
END;
/

-- Trigger for sequence WynagrodzenieSeq1 for column ID_Wynagrodzenia in table Wynagrodzenia ---------
CREATE OR REPLACE TRIGGER ts_Wynagrodzenia_Wynagrodzen_0 BEFORE INSERT
ON Wynagrodzenia FOR EACH ROW
BEGIN
  :new.ID_Wynagrodzenia := WynagrodzenieSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Wynagrodzenia_Wynagrodze_0 AFTER UPDATE OF ID_Wynagrodzenia
ON Wynagrodzenia FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Wynagrodzenia in table Wynagrodzenia as it uses sequence.');
END;
/

-- Trigger for sequence PocztySeq1 for column ID_Poczty in table Poczty ---------
CREATE OR REPLACE TRIGGER ts_Poczty_PocztySeq1 BEFORE INSERT
ON Poczty FOR EACH ROW
BEGIN
  :new.ID_Poczty := PocztySeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Poczty_PocztySeq1 AFTER UPDATE OF ID_Poczty
ON Poczty FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Poczty in table Poczty as it uses sequence.');
END;
/

-- Trigger for sequence StanowiskoSeq1 for column ID_Stanowiska in table Stanowiska ---------
CREATE OR REPLACE TRIGGER ts_Stanowiska_StanowiskoSeq1 BEFORE INSERT
ON Stanowiska FOR EACH ROW
BEGIN
  :new.ID_Stanowiska := StanowiskoSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Stanowiska_StanowiskoSeq1 AFTER UPDATE OF ID_Stanowiska
ON Stanowiska FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Stanowiska in table Stanowiska as it uses sequence.');
END;
/

-- Trigger for sequence ZezwolenieSeq1 for column ID_Zezwolenia in table Typy_zezwolen ---------
CREATE OR REPLACE TRIGGER ts_Typy_zezwolen_ZezwolenieS_0 BEFORE INSERT
ON Typy_zezwolen FOR EACH ROW
BEGIN
  :new.ID_Zezwolenia := ZezwolenieSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Typy_zezwolen_Zezwolenie_0 AFTER UPDATE OF ID_Zezwolenia
ON Typy_zezwolen FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Zezwolenia in table Typy_zezwolen as it uses sequence.');
END;
/

-- Trigger for sequence SpecjalizacjeSeq1 for column ID_Specjalizacji in table Specjalizacje ---------
CREATE OR REPLACE TRIGGER ts_Specjalizacje_Specjalizac_0 BEFORE INSERT
ON Specjalizacje FOR EACH ROW
BEGIN
  :new.ID_Specjalizacji := SpecjalizacjeSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Specjalizacje_Specjaliza_0 AFTER UPDATE OF ID_Specjalizacji
ON Specjalizacje FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Specjalizacji in table Specjalizacje as it uses sequence.');
END;
/

-- Trigger for sequence DokumentSeq1 for column ID_Dokumentu in table Typy_dokumentow ---------
CREATE OR REPLACE TRIGGER ts_Typy_dokumentow_DokumentS_0 BEFORE INSERT
ON Typy_dokumentow FOR EACH ROW
BEGIN
  :new.ID_Dokumentu := DokumentSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Typy_dokumentow_Dokument_0 AFTER UPDATE OF ID_Dokumentu
ON Typy_dokumentow FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Dokumentu in table Typy_dokumentow as it uses sequence.');
END;
/

-- Trigger for sequence RealizacjaSeq1 for column ID_Realizacji_Wydarzenia in table Realizacje_Wydarzen ---------
CREATE OR REPLACE TRIGGER ts_Realizacje_Wydarzen_Reali_0 BEFORE INSERT
ON Realizacje_Wydarzen FOR EACH ROW
BEGIN
  :new.ID_Realizacji_Wydarzenia := RealizacjaSeq1.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Realizacje_Wydarzen_Real_0 AFTER UPDATE OF ID_Realizacji_Wydarzenia
ON Realizacje_Wydarzen FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_Realizacji_Wydarzenia in table Realizacje_Wydarzen as it uses sequence.');
END;
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Pracownicy ADD CONSTRAINT Zatrudnia FOREIGN KEY (ID_Domu) REFERENCES Domy_Kultury (ID_Domu)
/



ALTER TABLE Sale ADD CONSTRAINT Posiada FOREIGN KEY (ID_Domu) REFERENCES Domy_Kultury (ID_Domu)
/



ALTER TABLE Wydarzenia ADD CONSTRAINT Oferuje FOREIGN KEY (ID_Domu) REFERENCES Domy_Kultury (ID_Domu)
/



ALTER TABLE Domy_Kultury ADD CONSTRAINT Dom_kultury_posiada_adres FOREIGN KEY (ID_Adresu) REFERENCES Adresy (ID_Adresu)
/



ALTER TABLE Pracownicy ADD CONSTRAINT Pracownik_posiada_adres FOREIGN KEY (ID_Adresu) REFERENCES Adresy (ID_Adresu)
/



ALTER TABLE Uczestnicy ADD CONSTRAINT Uczestnik_posiada_adres FOREIGN KEY (ID_Adresu) REFERENCES Adresy (ID_Adresu)
/



ALTER TABLE Adresy ADD CONSTRAINT Adres_posiada_poczte FOREIGN KEY (ID_Poczty) REFERENCES Poczty (ID_Poczty)
/



ALTER TABLE Pracownicy ADD CONSTRAINT Pracownik_posiada_stanowisko FOREIGN KEY (ID_Stanowiska) REFERENCES Stanowiska (ID_Stanowiska)
/



ALTER TABLE Wynagrodzenia ADD CONSTRAINT Ma_wynagrodzenie FOREIGN KEY (ID_Pracownika) REFERENCES Pracownicy (ID_Pracownika)
/



ALTER TABLE Posiadanie_zezwolenia ADD CONSTRAINT Posiada_zezwolenie FOREIGN KEY (ID_Pracownika) REFERENCES Organizatorzy (ID_Pracownika)
/



ALTER TABLE Posiadanie_zezwolenia ADD CONSTRAINT Jest_posiadane FOREIGN KEY (ID_Zezwolenia) REFERENCES Typy_zezwolen (ID_Zezwolenia)
/



ALTER TABLE Posiadanie_specjalizacji ADD CONSTRAINT Posiada_specjalizacje FOREIGN KEY (ID_Pracownika) REFERENCES Prowadzacy (ID_Pracownika)
/



ALTER TABLE Posiadanie_specjalizacji ADD CONSTRAINT Jest_posiadana FOREIGN KEY (ID_Specjalizacji) REFERENCES Specjalizacje (ID_Specjalizacji)
/



ALTER TABLE Prowadzacy ADD CONSTRAINT Jest_posiadany FOREIGN KEY (ID_Dokumentu) REFERENCES Typy_dokumentow (ID_Dokumentu)
/



ALTER TABLE Realizacje_Wydarzen ADD CONSTRAINT Wydarzenie_ma_realizacje FOREIGN KEY (ID_Wydarzenia) REFERENCES Wydarzenia (ID_Wydarzenia)
/



ALTER TABLE Zapisy_na_wydarzenie ADD CONSTRAINT Jest_uczeszczana FOREIGN KEY (ID_Realizacji_Wydarzenia) REFERENCES Realizacje_Wydarzen (ID_Realizacji_Wydarzenia)
/



ALTER TABLE Realizacje_Wydarzen ADD CONSTRAINT Zajmuje FOREIGN KEY (ID_Sali) REFERENCES Sale (ID_Sali)
/



ALTER TABLE Obslugiwanie_wydarzenia ADD CONSTRAINT Realizacja_jest_obslugiwana FOREIGN KEY (ID_Realizacji_Wydarzenia) REFERENCES Realizacje_Wydarzen (ID_Realizacji_Wydarzenia)
/


INSERT INTO Poczty (Kod_pocztowy, Miasto) VALUES('00-123', 'Warszawa');
INSERT INTO Poczty (Kod_pocztowy, Miasto) VALUES('00-543', 'Warszawa');
INSERT INTO Poczty (Kod_pocztowy, Miasto) VALUES('05-473', 'Mińsk Mazowiecki');
INSERT INTO Poczty (Kod_pocztowy, Miasto) VALUES('40-153', 'Gdańsk');


INSERT INTO Domy_Kultury (Nazwa, Data_zalozenia, Dyrektor, ID_Adresu) VALUES('Nadbałtycki Dom Kultury', TO_DATE('12/01/2000', 'dd/mm/yyyy'), 'Adam Michałowicz', 1);


INSERT INTO Adresy (Ulica, Nr_domu, Nr_mieszkania, ID_Poczty) VALUES('Chopina', 20, 2, 3);
INSERT INTO Adresy (Ulica, Nr_domu, Nr_mieszkania, ID_Poczty) VALUES('Aleje Ujazdowskie', 443, 2, 2);
INSERT INTO Adresy (Ulica, Nr_domu, Nr_mieszkania, ID_Poczty) VALUES('Chopina', 43, 1, 1);
INSERT INTO Adresy (Ulica, Nr_domu, Nr_mieszkania, ID_Poczty) VALUES('Feliksa Nowowiejskiego', 25, 1a, 4);
INSERT INTO Adresy (Ulica, Nr_domu, Nr_mieszkania, ID_Poczty) VALUES('Chłopska', 20, 2, 3);
INSERT INTO Adresy (Ulica, Nr_domu, ID_Poczty) VALUES('Feliksa Nowowiejskiego', 40, 4);
INSERT INTO Adresy (Ulica, Nr_domu, Nr_mieszkania, ID_Poczty) VALUES('Arbiturów', 3, '4b', 3);


INSERT INTO Stanowiska (Nazwa_Stanowiska, Opis_stanowiska) VALUES ('Nauczyciel języka angielskiego', 'Nauczyciel języka angielskiego na poziomie A2');
INSERT INTO Stanowiska (Nazwa_Stanowiska) VALUES ('Pracownik kina');
INSERT INTO Stanowiska (Nazwa_Stanowiska) VALUES ('Nauczyciel Tańca towarzystkiego');
INSERT INTO Stanowiska (Nazwa_Stanowiska, Opis_stanowiska) VALUES ('Nauczyciel języka hiszpańskiego', 'Nauczyciel języka hiszpańskiego na poziomie A1');


INSERT INTO Uczestnicy (Imie, Nazwisko, Plec, Data_Urodzenia, Email, ID_Adresu) VALUES('Adam', 'Wojnarowski', 'Mezczyzna', TO_DATE('14/02/2000', 'dd/mm/yyyy'), 'adamwojnarowski1@gmail.com', 2);
INSERT INTO Uczestnicy (Imie, Nazwisko, Plec, Data_Urodzenia, Email, ID_Adresu) VALUES('Michał', 'Wojnarowski', 'Mezczyzna', TO_DATE('14/02/2000', 'dd/mm/yyyy'), 'michalwojnarowski53@gmail.com', 2);
INSERT INTO Uczestnicy (Imie, Nazwisko, Plec, Data_Urodzenia, Numer_telefonu, Email, ID_Adresu) VALUES('Paweł', 'Gortat', 'Mezczyzna', TO_DATE('29/06/2004', 'dd/mm/yyyy'), '126784567', 'adjkdjkdsfgk1@wp.pl', 3);
INSERT INTO Uczestnicy (Imie, Nazwisko, Plec, Data_Urodzenia, Numer_telefonu, Email, ID_Adresu) VALUES('Julia', 'Wieniawa', 'Kobieta', TO_DATE('04/12/2008', 'dd/mm/yyyy'), '456289654','kochamkoty432532@gmail.com', 4);


INSERT INTO PRACOWNICY (Imie, Nazwisko, Data_urodzenia, PESEL, Nr_telefonu, Email, Plec, Data_zatrudnienia, ID_Domu, ID_Adresu, ID_stanowiska) VALUES ('Stefan', 'Baczyński', TO_DATE('14/07/1998', 'dd/mm/yyyy'),'19980714123','123456789', 'stefanb123@gmail.com', 'Mezczyzna', TO_DATE('14/07/2012', 'dd/mm/yyyy'), 1, 5, 1);
INSERT INTO PRACOWNICY (Imie, Nazwisko, Data_urodzenia, PESEL, Nr_telefonu, Email, Plec, Data_zatrudnienia, ID_Domu, ID_Adresu, ID_stanowiska) VALUES ('Emila', 'Adamska', TO_DATE('23/08/1997', 'dd/mm/yyyy'), '19970823456', '789456123','anitaolga@gmail.com', 'Kobieta', TO_DATE('06/07/2013', 'dd/mm/yyyy'), 1, 6, 2);
INSERT INTO PRACOWNICY (Imie, Nazwisko, Data_urodzenia, PESEL, Nr_telefonu, Email, Plec, Data_zatrudnienia, ID_Domu, ID_Adresu, ID_stanowiska) VALUES ('Micha', 'Dworak', TO_DATE('24/06/1996', 'dd/mm/yyyy'), '19960624456','598456123', 'kochamkocty@gmail.com', 'Mezczyzna', TO_DATE('14/06/2014', 'dd/mm/yyyy'), 1, 4, 3);
INSERT INTO PRACOWNICY (Imie, Nazwisko, Data_urodzenia, Email, Plec, Data_zatrudnienia, ID_Domu, ID_Adresu, ID_stanowiska) VALUES ('Kamil', 'Baczyński', TO_DATE('14/07/1998', 'dd/mm/yyyy'), 'jkrfshjsfjk@gmail.com', 'Mezczyzna', TO_DATE('18/02/2013', 'dd/mm/yyyy'), 1, 5, 3);
INSERT INTO PRACOWNICY (Imie, Nazwisko, Data_urodzenia, Email, Plec, Data_zatrudnienia, ID_Domu, ID_Adresu, ID_stanowiska) VALUES ('Olga', 'Tuszyńska', TO_DATE('14/09/1995', 'dd/mm/yyyy'), 'wojkte@gmail.com', 'Kobieta', TO_DATE('13/07/2014', 'dd/mm/yyyy'), 1, 3, 4);


INSERT INTO Wynagrodzenia (Data_wyslania_wynagrodzenia,Kwota_wynagrodzenia, ID_Pracownika) VALUES (TO_DATE('10/10/2020', 'dd/mm/yyyy'), 3000, '1');
INSERT INTO Wynagrodzenia (Data_wyslania_wynagrodzenia,Kwota_wynagrodzenia, ID_Pracownika) VALUES (TO_DATE('10/10/2020', 'dd/mm/yyyy'), 3200, '2');
INSERT INTO Wynagrodzenia (Data_wyslania_wynagrodzenia,Kwota_wynagrodzenia, ID_Pracownika) VALUES (TO_DATE('10/10/2020', 'dd/mm/yyyy'), 2200, '3');
INSERT INTO Wynagrodzenia (Data_wyslania_wynagrodzenia,Kwota_wynagrodzenia, ID_Pracownika) VALUES (TO_DATE('10/10/2020', 'dd/mm/yyyy'), 5200, '4');
INSERT INTO Wynagrodzenia (Data_wyslania_wynagrodzenia,Kwota_wynagrodzenia, ID_Pracownika) VALUES (TO_DATE('10/10/2020', 'dd/mm/yyyy'), 2600, '5');


INSERT INTO Sale(Numer_Sali, Maksymalna_Pojemnosc, Czy_Rzutnik, Czy_Internet, ID_Domu ) VALUES('1',  30, 'T', 'T', 1);
INSERT INTO Sale (Numer_Sali, Maksymalna_Pojemnosc, Czy_Rzutnik, Czy_Internet, ID_Domu ) VALUES('2',  25, 'T', 'T', 1);
INSERT INTO Sale (Numer_Sali, Maksymalna_Pojemnosc, Czy_Rzutnik, Czy_Internet, ID_Domu ) VALUES('3',  40, 'T', 'N', 1);
INSERT INTO Sale (Numer_Sali, Nazwa_sali, Maksymalna_Pojemnosc, Czy_Rzutnik, Czy_Internet, ID_Domu ) VALUES('10','Informatyczna',  40, 'T', 'T', 1);


INSERT INTO Wydarzenia (Nazwa_wydarzenia, Maksymalna_ilosc_uczestnikow, Wymagana_zgoda_rodzica, ID_domu) VALUES('Język Angielski', 25, 'N', 1);
INSERT INTO Wydarzenia (Nazwa_wydarzenia, Maksymalna_ilosc_uczestnikow, Wymagana_zgoda_rodzica, ID_domu) VALUES('Nauka Tańca Towarzyskiego', 20, 'N', 1);
INSERT INTO Wydarzenia (Nazwa_wydarzenia, Maksymalna_ilosc_uczestnikow, Wymagana_zgoda_rodzica, ID_domu) VALUES('Seans Młodzi Gniewni', 40, 'T', 1);
INSERT INTO Wydarzenia (Nazwa_wydarzenia, Maksymalna_ilosc_uczestnikow, Wymagana_zgoda_rodzica, ID_domu) VALUES('Język Hiszpański', 25, 'N', 1);


INSERT INTO Realizacje_Wydarzen (Data_wydarzenia, Cena, ID_Wydarzenia, ID_sali) VALUES (TO_DATE('11/12/2020 20:00:00', 'dd/mm/yyyy hh24:mi:ss'),  10.50, 1, 1);
INSERT INTO Realizacje_Wydarzen (Data_wydarzenia, Cena, ID_Wydarzenia, ID_sali) VALUES (TO_DATE('14/11/2020 18:00:00', 'dd/mm/yyyy hh24:mi:ss'),  10, 2, 2);
INSERT INTO Realizacje_Wydarzen (Data_wydarzenia, Cena, ID_Wydarzenia, ID_sali) VALUES (TO_DATE('15/12/2020 14:30:00', 'dd/mm/yyyy hh24:mi:ss'),  12.50, 3, 3);


INSERT INTO Obslugiwanie_Wydarzenia (ID_Pracownika, ID_Realizacji_Wydarzenia) VALUES (1,1);
INSERT INTO Obslugiwanie_Wydarzenia (ID_Pracownika, ID_Realizacji_Wydarzenia) VALUES (3,2);
INSERT INTO Obslugiwanie_Wydarzenia (ID_Pracownika, ID_Realizacji_Wydarzenia) VALUES (2,3);


INSERT INTO Zapisy_na_wydarzenie (ID_Uczestnika, ID_realizacji_wydarzenia, Data_zapisu) VALUES (1, 1, TO_DATE('08/10/2020', 'dd/mm/yyyy'));
INSERT INTO Zapisy_na_wydarzenie (ID_Uczestnika, ID_realizacji_wydarzenia, Data_zapisu) VALUES (2, 1, TO_DATE('08/10/2020', 'dd/mm/yyyy'));
INSERT INTO Zapisy_na_wydarzenie (ID_Uczestnika, ID_realizacji_wydarzenia, Data_zapisu) VALUES (3, 2, TO_DATE('08/10/2020', 'dd/mm/yyyy'));
INSERT INTO Zapisy_na_wydarzenie (ID_Uczestnika, ID_realizacji_wydarzenia, Data_zapisu) VALUES (4, 3, TO_DATE('08/10/2020', 'dd/mm/yyyy'));


INSERT INTO Typy_dokumentow (Nazwa_Dokumentu) VALUES ('Dyplom ukonczenia szkoy językowej');
INSERT INTO Typy_dokumentow (Nazwa_Dokumentu) VALUES ('Dyplom ukonczenia szkoy tańca');
INSERT INTO Typy_dokumentow (Nazwa_Dokumentu) VALUES ('Dyplom ukonczenia szkoy filmowej');


INSERT INTO Specjalizacje (Nazwa_Specjalizacji) VALUES ('język agnielski');
INSERT INTO Specjalizacje (Nazwa_Specjalizacji) VALUES ('język hiszpanski');
INSERT INTO Specjalizacje (Nazwa_Specjalizacji) VALUES ('Nauczyciel tanga');
INSERT INTO Specjalizacje (Nazwa_Specjalizacji) VALUES ('język rosyjki');


INSERT INTO Typy_Zezwolen (Nazwa_Zezwolenia) VALUES ('Pozwolenia na organizacje wydarzeń masowych');
INSERT INTO Typy_Zezwolen (Nazwa_Zezwolenia) VALUES ('Pozwolenia do ochrony budynku');


INSERT INTO Prowadzacy (ID_Pracownika, Wyksztalcenie, Nr_dokumentu, Data_wydania_dokumentu, ID_Dokumentu) VALUES (1,'wyzsze', '45678946a', TO_DATE('11/01/2020', 'dd/mm/yyyy'), 1);
INSERT INTO Prowadzacy (ID_Pracownika, Wyksztalcenie, Nr_dokumentu, Data_wydania_dokumentu, ID_Dokumentu) VALUES (5,'wyzsze', '45654f6a', TO_DATE('12/01/2020', 'dd/mm/yyyy'), 1);
INSERT INTO Prowadzacy (ID_Pracownika, Wyksztalcenie, Nr_dokumentu, Data_wydania_dokumentu, ID_Dokumentu) VALUES (3,'wyzsze', '4dfgdsfa', TO_DATE('01/01/2020', 'dd/mm/yyyy'), 2);
INSERT INTO Prowadzacy (ID_Pracownika, Wyksztalcenie, Nr_dokumentu, Data_wydania_dokumentu, ID_Dokumentu) VALUES (4,'srednie', '4dfgffff6a', TO_DATE('02/12/2010', 'dd/mm/yyyy'), 2);


INSERT INTO Posiadanie_Specjalizacji (ID_Pracownika, ID_Specjalizacji) VALUES (1,1);
INSERT INTO Posiadanie_Specjalizacji (ID_Pracownika, ID_Specjalizacji) VALUES (5,2);
INSERT INTO Posiadanie_Specjalizacji (ID_Pracownika, ID_Specjalizacji) VALUES (3,3);
INSERT INTO Posiadanie_Specjalizacji (ID_Pracownika, ID_Specjalizacji) VALUES (4,3);


INSERT INTO Organizatorzy (ID_Pracownika, Nr_zezwolenia, Data_wydania_zezwolenia) VALUES (2, '5465456pa', TO_DATE('03/12/2019', 'dd/mm/yyyy'));


INSERT INTO Posiadanie_Zezwolenia (ID_Pracownika, ID_Zezwolenia) VALUES (2,1);




