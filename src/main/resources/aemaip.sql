drop database if exists mybatis;
create database mybatis CHARACTER SET UTF8;
use mybatis;

drop table if exists Character_Resource;

drop table if exists Characters;

drop table if exists Enclosure;

drop table if exists MonitoringPrograms;

drop table if exists OversightGroup;

drop table if exists ReservationSupervision;

drop table if exists Resource;

drop table if exists Supervisionnotice;

drop table if exists Supervisionrecord;

drop table if exists Supervisionreport;

drop table if exists Supervisiontype;

drop table if exists Supervisors;

drop table if exists Users;

drop table if exists accountcharacter;

drop table if exists company;

drop table if exists companyaddress;

drop table if exists docstate;

drop table if exists faoc;

drop table if exists mpstate;

drop table if exists prjfile;

drop table if exists prjstate;

drop table if exists project;

drop table if exists projectcompany;

drop table if exists qss;

drop table if exists qsspi;

drop table if exists spstaff;

drop table if exists state;

drop table if exists unitcharacter;

drop table if exists unitpi;

/*==============================================================*/
/* Table: Character_Resource                                    */
/*==============================================================*/
create table Character_Resource
(
   id                   int not null auto_increment,
   resourceid           int,
   cid                  int,
   primary key (id)
);

/*==============================================================*/
/* Table: Characters                                            */
/*==============================================================*/
create table Characters
(
   cid                  int not null auto_increment,
   mdg                  char(200),
   primary key (cid)
);

/*==============================================================*/
/* Table: Enclosure                                             */
/*==============================================================*/
create table Enclosure
(
   fileid               int not null auto_increment,
   adress               char(100),
   filename             char(100),
   msg                  char(200),
   primary key (fileid)
);

/*==============================================================*/
/* Table: MonitoringPrograms                                    */
/*==============================================================*/
create table MonitoringPrograms
(
   mpid                 int not null auto_increment,
   sid                  int,
   mps_sid              int,
   projectid            int,
   mpmsg                varchar(20000),
   primary key (mpid)
);

/*==============================================================*/
/* Table: OversightGroup                                        */
/*==============================================================*/
create table OversightGroup
(
   ogid                 int not null auto_increment,
   qsspiid              int,
   qssid                int,
   primary key (ogid)
);

/*==============================================================*/
/* Table: ReservationSupervision                                */
/*==============================================================*/
create table ReservationSupervision
(
   rsid                 int not null auto_increment,
   projectid            int,
   upiid                int,
   state                int,
   fdate                date,
   ldate                date,
   description          text,
   primary key (rsid)
);

/*==============================================================*/
/* Table: Resource                                              */
/*==============================================================*/
create table Resource
(
   resourceid           int not null auto_increment,
   Res_resourceid       int,
   resourcename         char(50),
   adress               char(100),
   number               int,
   primary key (resourceid)
);

/*==============================================================*/
/* Table: Supervisionnotice                                     */
/*==============================================================*/
create table Supervisionnotice
(
   snid                 integer not null,
   projectid            integer,
   rsid                 int,
   qsspiid              int,
   state                int,
   snnotice             text,
   date                 date,
   primary key (snid)
);

/*==============================================================*/
/* Table: Supervisionrecord                                     */
/*==============================================================*/
create table Supervisionrecord
(
   srid                 integer not null,
   projectid            integer,
   qsspiid              int,
   stid                 int,
   state                int,
   stateid              integer,
   supervisionrecord    text,
   supervisiontime      timestamp,
   primary key (srid)
);

/*==============================================================*/
/* Table: Supervisionreport                                     */
/*==============================================================*/
create table Supervisionreport
(
   sreportid            integer not null,
   projectid            integer,
   state                int,
   begintime            date,
   endtime              date,
   report               long varchar,
   result               char(30),
   checkresult          char(30),
   writettime           date,
   primary key (sreportid)
);

/*==============================================================*/
/* Table: Supervisiontype                                       */
/*==============================================================*/
create table Supervisiontype
(
   stid                 int not null,
   stname               char(50),
   primary key (stid)
);

/*==============================================================*/
/* Table: Supervisors                                           */
/*==============================================================*/
create table Supervisors
(
   sid                  int not null auto_increment,
   ogid                 int,
   qsspiid              int,
   primary key (sid)
);

/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users
(
   account              int not null auto_increment,
   stateid              int,
   username             char(50),
   passwd               char(100),
   primary key (account)
);

/*==============================================================*/
/* Table: accountcharacter                                      */
/*==============================================================*/
create table accountcharacter
(
   acid                 int not null auto_increment,
   account              int,
   cid                  int,
   primary key (acid)
);

/*==============================================================*/
/* Table: company                                               */
/*==============================================================*/
create table company
(
   companyid            int not null auto_increment,
   companytypeid        int,
   adressid             int,
   account              int,
   upiid                int,
   companyname          char(100),
   companyphone         char(20),
   companyjiontime      timestamp,
   primary key (companyid)
);

/*==============================================================*/
/* Table: companyaddress                                        */
/*==============================================================*/
create table companyaddress
(
   adressid             int not null auto_increment,
   pid                  int,
   name                 char(100),
   primary key (adressid)
);

/*==============================================================*/
/* Table: docstate                                              */
/*==============================================================*/
create table docstate
(
   state                int not null,
   msg                  char(200),
   primary key (state)
);

/*==============================================================*/
/* Table: faoc                                                  */
/*==============================================================*/
create table faoc
(
   faocid               integer not null,
   projectid            integer,
   faocdate             date,
   applicationreault    text,
   applicationadvice    char(200),
   primary key (faocid)
);

/*==============================================================*/
/* Table: mpstate                                               */
/*==============================================================*/
create table mpstate
(
   sid                  int not null auto_increment,
   msg                  char(200),
   primary key (sid)
);

/*==============================================================*/
/* Table: prjfile                                               */
/*==============================================================*/
create table prjfile
(
   fileid               int,
   projectid            int,
   ftype                char(50),
   id                   int not null auto_increment,
   primary key (id)
);

/*==============================================================*/
/* Table: prjstate                                              */
/*==============================================================*/
create table prjstate
(
   prjsid               int not null auto_increment,
   msg                  char(50),
   primary key (prjsid)
);

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project
(
   projectid            int not null auto_increment,
   ogid                 int,
   qssid                int,
   prjsid               int,
   name                 char(255),
   begintime            timestamp,
   endtime              timestamp,
   msg                  text,
   regao                char(255),
   primary key (projectid)
);

/*==============================================================*/
/* Table: projectcompany                                        */
/*==============================================================*/
create table projectcompany
(
   id                   int not null auto_increment,
   projectid            int,
   companyid            int,
   primary key (id)
);

/*==============================================================*/
/* Table: qss                                                   */
/*==============================================================*/
create table qss
(
   adressid             int,
   qssid                int not null auto_increment,
   name                 char(50),
   primary key (qssid)
);

alter table qss comment 'Quality Supervision Station';

/*==============================================================*/
/* Table: qsspi                                                 */
/*==============================================================*/
create table qsspi
(
   qsspiid              int not null auto_increment,
   name                 char(50),
   sex                  smallint,
   tel                  char(20),
   msg                  char(255),
   account              int,
   qssid                int,
   primary key (qsspiid)
);

alter table qsspi comment 'Quality supervision station personnel information';

/*==============================================================*/
/* Table: spstaff                                               */
/*==============================================================*/
create table spstaff
(
   spsid                int not null auto_increment,
   qsspiid              int,
   srid                 integer,
   primary key (spsid)
);

/*==============================================================*/
/* Table: state                                                 */
/*==============================================================*/
create table state
(
   stateid              int not null auto_increment,
   stateinformation     char(255),
   primary key (stateid)
);

/*==============================================================*/
/* Table: unitcharacter                                         */
/*==============================================================*/
create table unitcharacter
(
   ucid                 int not null auto_increment,
   id                   int,
   upiid                int,
   cname                char(50),
   msg                  char(200),
   primary key (ucid)
);

/*==============================================================*/
/* Table: unitpi                                                */
/*==============================================================*/
create table unitpi
(
   upiid                int not null auto_increment,
   companyid            int,
   adressid             int,
   name                 char(50),
   telephone            char(20),
   sex                  smallint,
   mag                  char(255),
   primary key (upiid)
);

alter table Character_Resource add constraint FK_Reference_15 foreign key (resourceid)
      references Resource (resourceid) on delete restrict on update restrict;

alter table Character_Resource add constraint FK_Reference_65 foreign key (cid)
      references Characters (cid) on delete restrict on update restrict;

alter table MonitoringPrograms add constraint FK_Reference_42 foreign key (projectid)
      references project (projectid) on delete restrict on update restrict;

alter table MonitoringPrograms add constraint FK_Reference_43 foreign key (sid)
      references Supervisors (sid) on delete restrict on update restrict;

alter table MonitoringPrograms add constraint FK_Reference_44 foreign key (mps_sid)
      references mpstate (sid) on delete restrict on update restrict;

alter table OversightGroup add constraint FK_Reference_37 foreign key (qsspiid)
      references qsspi (qsspiid) on delete restrict on update restrict;

alter table OversightGroup add constraint FK_Reference_38 foreign key (qssid)
      references qss (qssid) on delete restrict on update restrict;

alter table ReservationSupervision add constraint FK_Reference_48 foreign key (projectid)
      references project (projectid) on delete restrict on update restrict;

alter table ReservationSupervision add constraint FK_Reference_50 foreign key (upiid)
      references unitpi (upiid) on delete restrict on update restrict;

alter table ReservationSupervision add constraint FK_Reference_59 foreign key (state)
      references docstate (state) on delete restrict on update restrict;

alter table Resource add constraint FK_Reference_14 foreign key (Res_resourceid)
      references Resource (resourceid) on delete restrict on update restrict;

alter table Supervisionnotice add constraint FK_Reference_52 foreign key (projectid)
      references project (projectid) on delete restrict on update restrict;

alter table Supervisionnotice add constraint FK_Reference_53 foreign key (rsid)
      references ReservationSupervision (rsid) on delete restrict on update restrict;

alter table Supervisionnotice add constraint FK_Reference_54 foreign key (qsspiid)
      references qsspi (qsspiid) on delete restrict on update restrict;

alter table Supervisionnotice add constraint FK_Reference_66 foreign key (state)
      references docstate (state) on delete restrict on update restrict;

alter table Supervisionrecord add constraint FK_Reference_51 foreign key (projectid)
      references project (projectid) on delete restrict on update restrict;

alter table Supervisionrecord add constraint FK_Reference_55 foreign key (qsspiid)
      references qsspi (qsspiid) on delete restrict on update restrict;

alter table Supervisionrecord add constraint FK_Reference_56 foreign key (state)
      references docstate (state) on delete restrict on update restrict;

alter table Supervisionrecord add constraint FK_Reference_63 foreign key (stid)
      references Supervisiontype (stid) on delete restrict on update restrict;

alter table Supervisionreport add constraint FK_Reference_60 foreign key (projectid)
      references project (projectid) on delete restrict on update restrict;

alter table Supervisionreport add constraint FK_Reference_61 foreign key (state)
      references docstate (state) on delete restrict on update restrict;

alter table Supervisors add constraint FK_Reference_31 foreign key (ogid)
      references OversightGroup (ogid) on delete restrict on update restrict;

alter table Supervisors add constraint FK_Reference_32 foreign key (qsspiid)
      references qsspi (qsspiid) on delete restrict on update restrict;

alter table Users add constraint FK_Reference_39 foreign key (stateid)
      references state (stateid) on delete restrict on update restrict;

alter table accountcharacter add constraint FK_Reference_40 foreign key (account)
      references Users (account) on delete restrict on update restrict;

alter table accountcharacter add constraint FK_Reference_64 foreign key (cid)
      references Characters (cid) on delete restrict on update restrict;

alter table company add constraint FK_Reference_36 foreign key (account)
      references Users (account) on delete restrict on update restrict;

alter table company add constraint FK_Reference_49 foreign key (upiid)
      references unitpi (upiid) on delete restrict on update restrict;

alter table company add constraint FK_Reference_6 foreign key (adressid)
      references companyaddress (adressid) on delete restrict on update restrict;

alter table companyaddress add constraint FK_Reference_10 foreign key (pid)
      references companyaddress (adressid) on delete restrict on update restrict;

alter table faoc add constraint FK_Reference_62 foreign key (projectid)
      references project (projectid) on delete restrict on update restrict;

alter table prjfile add constraint FK_Reference_21 foreign key (fileid)
      references Enclosure (fileid) on delete restrict on update restrict;

alter table prjfile add constraint FK_Reference_22 foreign key (projectid)
      references project (projectid) on delete restrict on update restrict;

alter table project add constraint FK_Reference_33 foreign key (ogid)
      references OversightGroup (ogid) on delete restrict on update restrict;

alter table project add constraint FK_Reference_34 foreign key (qssid)
      references qss (qssid) on delete restrict on update restrict;

alter table project add constraint FK_Reference_35 foreign key (prjsid)
      references prjstate (prjsid) on delete restrict on update restrict;

alter table projectcompany add constraint FK_Reference_8 foreign key (projectid)
      references project (projectid) on delete restrict on update restrict;

alter table projectcompany add constraint FK_Reference_9 foreign key (companyid)
      references company (companyid) on delete restrict on update restrict;

alter table qss add constraint FK_Reference_11 foreign key (adressid)
      references companyaddress (adressid) on delete restrict on update restrict;

alter table qsspi add constraint FK_Reference_29 foreign key (account)
      references Users (account) on delete restrict on update restrict;

alter table qsspi add constraint FK_Reference_30 foreign key (qssid)
      references qss (qssid) on delete restrict on update restrict;

alter table spstaff add constraint FK_Reference_57 foreign key (srid)
      references Supervisionrecord (srid) on delete restrict on update restrict;

alter table spstaff add constraint FK_Reference_58 foreign key (qsspiid)
      references qsspi (qsspiid) on delete restrict on update restrict;

alter table unitcharacter add constraint FK_Reference_45 foreign key (id)
      references projectcompany (id) on delete restrict on update restrict;

alter table unitcharacter add constraint FK_Reference_47 foreign key (upiid)
      references unitpi (upiid) on delete restrict on update restrict;

alter table unitpi add constraint FK_Reference_5 foreign key (companyid)
      references company (companyid) on delete restrict on update restrict;

alter table unitpi add constraint FK_Reference_7 foreign key (adressid)
      references companyaddress (adressid) on delete restrict on update restrict;
