Drop Database ipcalculater;
create Database ipcalculater;

use ipcalculater;
CREATE TABLE network (
    id          int             NOT NULL AUTO_INCREMENT,
    ip          varchar(255)    NOT NULL,
    prefix      varchar(255),

    PRIMARY KEY (id)
);
CREATE TABLE subnet (
    id              int             NOT NULL AUTO_INCREMENT,
    ip              varchar(255)    NOT NULL,
    network_id      int,
    prefix          int,

	PRIMARY KEY (ID),
	FOREIGN KEY (network_id) REFERENCES network(id)
);

CREATE TABLE device (
    id      int             NOT NULL AUTO_INCREMENT,
    name    varchar(255),

    PRIMARY KEY (id)
);

CREATE TABLE host (
    id              int             NOT NULL AUTO_INCREMENT,
    ip              varchar(255)    NOT NULL,
    subnet_id       int,
    device_id       int,
    description     varchar(255),

	PRIMARY KEY (id),
	FOREIGN KEY (device_id) REFERENCES device(id),
    FOREIGN KEY (subnet_id) REFERENCES subnet(id)
);


insert into network (ip,Prefix,bit_format) values ('192.168.1.0',24,'00000000.11111111.11111111.11111111');
insert into subnet (ip,network_id,prefix,bit_format) values ('192.168.12.12',1,24,'00000000.11111111.10101010.00000000');
insert into subnet (ip,network_id,prefix,bit_format) values ('192.168.155.12',1,16,'00110000.11111111.10101010.00000000');
insert into subnet (ip,network_id,prefix,bit_format) values ('192.168.155.12',1,24,'00110000.11111111.10101010.11111100');

insert into device(name) values ('PC');
insert into device(name) values ('Laptop');
insert into device(name) values ('Printer');
insert into device(name) values ('Server');
insert into device(name) values ('Fax');

insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.1',1,'Test PC1',1,'11111111.00000000.11111111.00000000');
insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.2',1,'Test PC2',2,'11111111.00000000.11111111.00000001');
insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.3',1,'Test PC3',3,'11111111.00000000.11111111.00000010');

insert into network (ip,Prefix,bit_format) values ('192.168.1.0',24,'00000000.11111111.11111111.11111111');
insert into subnet (ip,network_id,prefix,bit_format) values ('192.168.12.12',1,24,'00000000.11111111.10101010.00000000');
insert into subnet (ip,network_id,prefix,bit_format) values ('192.168.155.12',1,16,'00110000.11111111.10101010.00000000');
insert into subnet (ip,network_id,prefix,bit_format) values ('192.168.155.12',1,24,'00110000.11111111.10101010.11111100');

insert into device(name) values ('PC');
insert into device(name) values ('Laptop');
insert into device(name) values ('Printer');
insert into device(name) values ('Server');
insert into device(name) values ('Fax');

insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.1',1,'Test PC1',1,'11111111.00000000.11111111.00000000');
insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.2',1,'Test PC2',2,'11111111.00000000.11111111.00000001');
insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.3',1,'Test PC3',3,'11111111.00000000.11111111.00000010');




select * from host;
select * from subnet;
select * from network;
select * from device;