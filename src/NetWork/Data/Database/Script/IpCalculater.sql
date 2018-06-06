CREATE TABLE network (
    id          int             NOT NULL AUTO_INCREMENT,
    ip          varchar(255)    NOT NULL,
    prefix      varchar(255),
    bit_format  varchar(255),

    PRIMARY KEY (id)
);
CREATE TABLE subnet (
    id              int             NOT NULL AUTO_INCREMENT,
    ip              varchar(255)    NOT NULL,
    network_id      int,
    class           varchar(255),
    bit_format      varchar(255),

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
    bit_format      varchar(255),

	PRIMARY KEY (id),
	FOREIGN KEY (device_id) REFERENCES device(id),
    FOREIGN KEY (subnet_id) REFERENCES subnet(id)
);


insert into network (ip,Prefix,bit_format) values ('192.168.1.1',24,'00000000.11111111.11111111.11111111');
insert into subnet (ip,network_id,class,bit_format) values ('192.168.12.12',1,'a','00000000.11111111.10101010.00000000');
insert into subnet (ip,network_id,class,bit_format) values ('192.168.155.12',1,'b','00110000.11111111.10101010.00000000');
insert into subnet (ip,network_id,class,bit_format) values ('192.168.155.12',1,'c','00110000.11111111.10101010.11111100');

insert into device(name) values ('PC');
insert into device(name) values ('Laptop');
insert into device(name) values ('Printer');
insert into device(name) values ('Server');
insert into device(name) values ('Fax');

insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.1',1,'Test PC1',1,'11111111.00000000.11111111.00000000');
insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.2',1,'Test PC2',2,'11111111.00000000.11111111.00000001');
insert into host(ip,subnet_id,description,device_id,bit_format) values ('192.168.2.3',1,'Test PC3',3,'11111111.00000000.11111111.00000010');