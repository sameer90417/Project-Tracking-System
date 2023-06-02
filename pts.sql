create database pts;
use pts;
create table pts_credential(cid int primary key auto_increment, name varchar(50) not null, email varchar(30) not null, password varchar(50) not null);
create table pts_employee(eid int primary key auto_increment, cid int not null, name varchar(50) not null, profile varchar(50) not null, foreign key(cid) references pts_credential(cid));
create table pts_project(pid int primary key auto_increment, pname varchar(100) not null, pdescription text not null, designer int, coder int, tester int, assigndate date, enddate date);
create table pts_designer(did int primary key auto_increment, eid int not null, pid int not null, foreign key(eid) references pts_employee(eid), foreign key(pid) references pts_project(pid));
create table pts_coder(cdeid int primary key auto_increment, eid int not null, pid int not null, foreign key(eid) references pts_employee(eid), foreign key(pid) references pts_project(pid));
create table pts_tester(tid int primary key auto_increment, eid int not null, pid int not null, foreign key(eid) references pts_employee(eid), foreign key(pid) references pts_project(pid));
create table pts_project_tracker(sid int primary key auto_increment, pid int not null, Designers_task int not null, Coders_task int not null, Testers_task int not null, completed_designers_task int not null,completed_coders_task int not null, completed_testers_task int not null,  foreign key(pid) references pts_project(pid) );