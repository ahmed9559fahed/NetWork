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

CREATE TABLE Device (
    ID int NOT NULL AUTO_INCREMENT,
    Name varchar(255),
    PRIMARY KEY (ID)
);

CREATE TABLE Host (
    ID int NOT NULL AUTO_INCREMENT,
    IP varchar(255) NOT NULL,
    SubnetID int,
    DeviceID int,
    FOREIGN KEY (DeviceID) REFERENCES Device(ID),
    FOREIGN KEY (SubnetID) REFERENCES Subnet(ID),
    Descreption  varchar(255),
    BitFormat varchar(255),
	 PRIMARY KEY (ID)
);




insert into network(IP,Prefix,BitFormat) values ('192.168.1.1',24,'00000000.11111111.11111111.11111111');
insert into subnet(IP,NetworkID,Class,BitFormat) values ('192.168.12.12',1,'a','00000000.11111111.10101010.00000000');
insert into subnet(IP,NetworkID,Class,BitFormat) values ('192.168.155.12',1,'b','00110000.11111111.10101010.00000000');
insert into subnet(IP,NetworkID,Class,BitFormat) values ('192.168.155.12',1,'c','00110000.11111111.10101010.11111100');

insert into device(Name) values ('PC');
insert into device(Name) values ('Laptop');
insert into device(Name) values ('Printer');
insert into device(Name) values ('Server');
insert into device(Name) values ('Fax');

insert into host(IP,SubnetID,Descreption,DeviceID,BitFormat) values ('192.168.2.1',1,'Test PC1',1,'11111111.00000000.11111111.00000000');
insert into host(IP,SubnetID,Descreption,DeviceID,BitFormat) values ('192.168.2.2',1,'Test PC2',2,'11111111.00000000.11111111.00000001');
insert into host(IP,SubnetID,Descreption,DeviceID,BitFormat) values ('192.168.2.3',1,'Test PC3',3,'11111111.00000000.11111111.00000010');




select * from host;
select * from subnet;
select * from network;
select * from device;