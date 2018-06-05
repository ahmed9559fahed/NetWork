Drop DataBase Ipcalculater;
CREATE DATABASE Ipcalculater;
use Ipcalculater;
CREATE TABLE Network (
    ID int NOT NULL AUTO_INCREMENT,
    IP varchar(255) NOT NULL,
    Prefix  varchar(255),
    BitFormat varchar(255),
    PRIMARY KEY (ID)
);
CREATE TABLE Subnet (
    ID int NOT NULL AUTO_INCREMENT,
    IP varchar(255) NOT NULL,
    NetworkID int,
    FOREIGN KEY (NetworkID) REFERENCES  Network(ID),
    Class varchar(255),
    BitFormat varchar(255),
	 PRIMARY KEY (ID)
);
CREATE TABLE Host (
    ID int NOT NULL AUTO_INCREMENT,
    IP varchar(255) NOT NULL,
    SubnetID int,
    FOREIGN KEY (SubnetID) REFERENCES Subnet(ID),
    Descreption  varchar(255),
    BitFormat varchar(255),
	 PRIMARY KEY (ID)
);
 