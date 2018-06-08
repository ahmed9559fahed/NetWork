

insert into network (ip,Prefix) values ('192.168.1.0',24);
insert into subnet (ip,network_id,prefix) values ('192.168.12.12',1,24);
insert into subnet (ip,network_id,prefix) values ('192.168.155.12',1,16);
insert into subnet (ip,network_id,prefix) values ('192.168.155.12',1,24);

insert into device(name) values ('PC');
insert into device(name) values ('Laptop');
insert into device(name) values ('Printer');
insert into device(name) values ('Server');
insert into device(name) values ('Fax');

insert into host(ip,subnet_id,description,device_id) values ('192.168.2.1',1,'Test PC1',1);
insert into host(ip,subnet_id,description,device_id) values ('192.168.2.2',1,'Test PC2',2);
insert into host(ip,subnet_id,description,device_id) values ('192.168.2.3',1,'Test PC3',3);

insert into network (ip,Prefix) values ('192.168.1.0',24);
insert into subnet (ip,network_id,prefix) values ('192.168.12.12',1,24);
insert into subnet (ip,network_id,prefix) values ('192.168.155.12',1,16);
insert into subnet (ip,network_id,prefix) values ('192.168.155.12',1,24);

insert into device(name) values ('PC');
insert into device(name) values ('Laptop');
insert into device(name) values ('Printer');
insert into device(name) values ('Server');
insert into device(name) values ('Fax');

insert into host(ip,subnet_id,description,device_id) values ('192.168.2.1',1,'Test PC1',1);
insert into host(ip,subnet_id,description,device_id) values ('192.168.2.2',1,'Test PC2',2);
insert into host(ip,subnet_id,description,device_id) values ('192.168.2.3',1,'Test PC3',3);


