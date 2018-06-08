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


select * from host;
select * from subnet;
select * from network;
select * from device;