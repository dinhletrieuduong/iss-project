/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     6/24/2020 9:41:14 AM                         */
/*==============================================================*/

BEGIN
   FOR u IN (
      SELECT USERNAME FROM DBA_USERS;
      WHERE USERNAME LIKE 'CE_%'
   ) LOOP
      EXECUTE IMMEDIATE 'DROP USER "' || u.USERNAME || '"';
   END LOOP;
END;

alter table BO_MON
   drop constraint FK_BO_MON_CO_KHOA;

alter table BO_MON
   drop constraint FK_BO_MON_QUANLI_NGUOI_DU;

alter table DANG_KY
   drop constraint FK_DANG_KY_SINHVIEND_MON_HOC_;

alter table DANG_KY
   drop constraint FK_DANG_KY_THAMGIA_NGUOI_DU;

alter table KHOA
   drop constraint FK_KHOA_DIEUHANH_NGUOI_DU;

alter table LICH_HOC
   drop constraint FK_LICH_HOC_COTHECO_MON_HOC_;

alter table MON_HOC
   drop constraint FK_MON_HOC_GOM_BO_MON;

alter table MON_HOC_MO
   drop constraint FK_MON_HOC__GIANGDAY_NGUOI_DU;

alter table MON_HOC_MO
   drop constraint FK_MON_HOC__MO_MON_HOC;

alter table NGUOI_DUNG
   drop constraint FK_NGUOI_DU_THEOKHOA_KHOA;

alter table NGUOI_DUNG
   drop constraint FK_NGUOI_DU_THUOCVAO_BO_MON;

drop index QUANLI_FK;

drop index CO_FK;

drop table BO_MON cascade constraints;

drop index SINHVIENDANGKYMONHOCMO_FK;

drop index THAMGIA_FK;

drop table DANG_KY cascade constraints;

drop index DIEUHANH_FK;

drop table KHOA cascade constraints;

drop index COTHECO_FK;

drop table LICH_HOC cascade constraints;

drop index GOM_FK;

drop table MON_HOC cascade constraints;

drop index GIANGDAY_FK;

drop index MO_FK;

drop table MON_HOC_MO cascade constraints;

drop table NGUOI_DUNG cascade constraints;

/*==============================================================*/
/* Table: BO_MON                                                */
/*==============================================================*/
create table BO_MON (
   MA_BO_MON            INTEGER             
      generated always as identity ( start with 1 nocycle noorder)  not null,
   MA_KHOA              INTEGER               not null,
   MA_TBM               INTEGER               not null,
   TEN_BO_MON           VARCHAR2(30),
   constraint PK_BO_MON primary key (MA_BO_MON)
);

/*==============================================================*/
/* Index: CO_FK                                                 */
/*==============================================================*/
create index CO_FK on BO_MON (
   MA_KHOA ASC
);

/*==============================================================*/
/* Index: QUANLI_FK                                             */
/*==============================================================*/
create index QUANLI_FK on BO_MON (
   MA_TBM ASC
);

/*==============================================================*/
/* Table: DANG_KY                                               */
/*==============================================================*/
create table DANG_KY (
   MA_MON_HOC_MO        INTEGER               not null,
   MA_SV                INTEGER               not null,
   DIEMTRUNGBINH        FLOAT,
   DIEMTHUCHANH         FLOAT,
   DIEMCUOIKY           FLOAT,
   DIEMCONG             FLOAT,
   DIEMGIUAKY           FLOAT,
   DIEMKHAC             FLOAT
);

/*==============================================================*/
/* Index: THAMGIA_FK                                            */
/*==============================================================*/
create index THAMGIA_FK on DANG_KY (
   MA_SV ASC
);

/*==============================================================*/
/* Index: SINHVIENDANGKYMONHOCMO_FK                             */
/*==============================================================*/
create index SINHVIENDANGKYMONHOCMO_FK on DANG_KY (
   MA_MON_HOC_MO ASC
);

/*==============================================================*/
/* Table: KHOA                                                  */
/*==============================================================*/
create table KHOA (
   MA_KHOA              INTEGER             
      generated always as identity ( start with 1 increment by 1 nocycle noorder)  not null,
   MA_TPK               INTEGER               not null,
   TEN_KHOA             VARCHAR2(30),
   constraint PK_KHOA primary key (MA_KHOA)
);

/*==============================================================*/
/* Index: DIEUHANH_FK                                           */
/*==============================================================*/
create index DIEUHANH_FK on KHOA (
   MA_TPK ASC
);

/*==============================================================*/
/* Table: LICH_HOC                                              */
/*==============================================================*/
create table LICH_HOC (
   MA_MON_HOC_MO        INTEGER               not null,
   THUTRONGTUAN         SMALLINT,
   CABATDAU             SMALLINT,
   CAKETTHUC            SMALLINT
);

/*==============================================================*/
/* Index: COTHECO_FK                                            */
/*==============================================================*/
create index COTHECO_FK on LICH_HOC (
   MA_MON_HOC_MO ASC
);

/*==============================================================*/
/* Table: MON_HOC                                               */
/*==============================================================*/
create table MON_HOC (
   MA_MON_HOC           INTEGER             
      generated always as identity ( start with 1 increment by 1 nocycle noorder)  not null,
   MA_BO_MON            INTEGER               not null,
   TEN_MON_HOC          VARCHAR2(100),
   constraint PK_MON_HOC primary key (MA_MON_HOC)
);

/*==============================================================*/
/* Index: GOM_FK                                                */
/*==============================================================*/
create index GOM_FK on MON_HOC (
   MA_BO_MON ASC
);

/*==============================================================*/
/* Table: MON_HOC_MO                                            */
/*==============================================================*/
create table MON_HOC_MO (
   MA_MON_HOC_MO        INTEGER             
      generated always as identity ( start with 1 increment by 1 nocycle noorder)  not null,
   MA_MON_HOC           INTEGER               not null,
   HOC_KY               INTEGER               not null,
   NGAY_MO              DATE                  not null,
   SO_LUONG_TOI_DA      SMALLINT              not null,
   NGAY_KET_THUC        DATE                  not null,
   MA_GV                INTEGER               not null,
   constraint PK_MON_HOC_MO primary key (MA_MON_HOC_MO)
);

/*==============================================================*/
/* Index: MO_FK                                                 */
/*==============================================================*/
create index MO_FK on MON_HOC_MO (
   MA_MON_HOC ASC
);

/*==============================================================*/
/* Index: GIANGDAY_FK                                           */
/*==============================================================*/
create index GIANGDAY_FK on MON_HOC_MO (
   MA_GV ASC
);

/*==============================================================*/
/* Table: NGUOI_DUNG                                            */
/*==============================================================*/
create table NGUOI_DUNG (
   MA_ND                INTEGER             
      generated always as identity ( start with 1 increment by 1 nocycle noorder)  not null,
   USERNAME             VARCHAR2(30)          not null unique,
   GIOI_TINH            SMALLINT              not null,
   DIA_CHI              VARCHAR2(250),
   SDT                  CHAR(12),
   NGAY_SINH            DATE,
   EMAIL                VARCHAR2(100),
   HO_TEN               VARCHAR2(50),
   KIEUND               SMALLINT              not null,
   MA_BO_MON            INTEGER,
   MA_KHOA              INTEGER,
   MSSV                 CHAR(10)			  unique,
   KIEUGV               SMALLINT,
   constraint PK_NGUOI_DUNG primary key (MA_ND)
);

alter table BO_MON
   add constraint FK_BO_MON_CO_KHOA foreign key (MA_KHOA)
      references KHOA (MA_KHOA);

alter table BO_MON
   add constraint FK_BO_MON_QUANLI_NGUOI_DU foreign key (MA_TBM)
      references NGUOI_DUNG (MA_ND);

alter table DANG_KY
   add constraint FK_DANG_KY_SINHVIEND_MON_HOC_ foreign key (MA_MON_HOC_MO)
      references MON_HOC_MO (MA_MON_HOC_MO);

alter table DANG_KY
   add constraint FK_DANG_KY_THAMGIA_NGUOI_DU foreign key (MA_SV)
      references NGUOI_DUNG (MA_ND);

alter table KHOA
   add constraint FK_KHOA_DIEUHANH_NGUOI_DU foreign key (MA_TPK)
      references NGUOI_DUNG (MA_ND);

alter table LICH_HOC
   add constraint FK_LICH_HOC_COTHECO_MON_HOC_ foreign key (MA_MON_HOC_MO)
      references MON_HOC_MO (MA_MON_HOC_MO);

alter table MON_HOC
   add constraint FK_MON_HOC_GOM_BO_MON foreign key (MA_BO_MON)
      references BO_MON (MA_BO_MON);

alter table MON_HOC_MO
   add constraint FK_MON_HOC__GIANGDAY_NGUOI_DU foreign key (MA_GV)
      references NGUOI_DUNG (MA_ND);

alter table MON_HOC_MO
   add constraint FK_MON_HOC__MO_MON_HOC foreign key (MA_MON_HOC)
      references MON_HOC (MA_MON_HOC);

alter table NGUOI_DUNG
   add constraint FK_NGUOI_DU_THEOKHOA_KHOA foreign key (MA_KHOA)
      references KHOA (MA_KHOA);

alter table NGUOI_DUNG
   add constraint FK_NGUOI_DU_THUOCVAO_BO_MON foreign key (MA_BO_MON)
      references BO_MON (MA_BO_MON);

