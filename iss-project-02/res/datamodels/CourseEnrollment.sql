/*==============================================================*/
/* DBMS name:      ORACLE Version 12c                           */
/* Created on:     6/20/2020 4:42:00 PM                         */
/*==============================================================*/

DROP TABLE LUU_KEY;

drop index QUANLI_FK;

drop index CO_FK;

drop table BO_MON cascade constraints;

drop index SINHVIENDANGKYMONHOCMO_FK;

drop index THAMGIA_FK;

drop table DANG_KY cascade constraints;

drop table GIAO_VIEN cascade constraints;

drop table GIAO_VU cascade constraints;

drop index DIEUHANH_FK;

drop table KHOA cascade constraints;

drop index GOM_FK;

drop table MON_HOC cascade constraints;

drop index GIANGDAY_FK;

drop index MO_FK;

drop table MON_HOC_MO cascade constraints;

drop table NGUOI_DUNG cascade constraints;

drop index THUOCVAO_FK;

drop table SINH_VIEN cascade constraints;

drop table TRUONG_BO_MON cascade constraints;

drop table TRUONG_PHO_KHOA cascade constraints;

/*==============================================================*/
/* Table: BO_MON                                                */
/*==============================================================*/
create table BO_MON (
   MA_BO_MON            INTEGER             
      generated always as identity ( start with 1 increment by 1 nocycle noorder)  not null,
   MA_KHOA              INTEGER               not null,
   MA_TBM               INTEGER               not null,
   TEN_BO_MON           CHAR(50),
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
   DIEM                 FLOAT
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
/* Table: GIAO_VIEN                                             */
/*==============================================================*/
create table GIAO_VIEN (
   MA_GV                INTEGER               not null,
   constraint PK_GIAO_VIEN primary key (MA_GV)
);

/*==============================================================*/
/* Table: GIAO_VU                                               */
/*==============================================================*/
create table GIAO_VU (
   MA_GVU               INTEGER               not null,
   constraint PK_GIAO_VU primary key (MA_GVU)
);

/*==============================================================*/
/* Table: KHOA                                                  */
/*==============================================================*/
create table KHOA (
   MA_KHOA              INTEGER             
      generated always as identity ( start with 1 increment by 1 nocycle noorder)  not null,
   MA_TPK               INTEGER               not null,
   TEN_KHOA             CHAR(50),
   constraint PK_KHOA primary key (MA_KHOA)
);

/*==============================================================*/
/* Index: DIEUHANH_FK                                           */
/*==============================================================*/
create index DIEUHANH_FK on KHOA (
   MA_TPK ASC
);

/*==============================================================*/
/* Table: MON_HOC                                               */
/*==============================================================*/
create table MON_HOC (
   MA_MON_HOC           INTEGER             
      generated always as identity ( start with 1 increment by 1 nocycle noorder)  not null,
   MA_BO_MON            INTEGER               not null,
   TEN_MON_HOC          CHAR(50),
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
   HOC_KY               INTEGER               not null,
   NGAY_MO              DATE                  not null,
   SO_LUONG_TOI_DA      SMALLINT              not null,
   MA_MON_HOC_MO        INTEGER             
      generated always as identity ( start with 1 increment by 1 nocycle noorder)  not null,
   MA_MON_HOC           INTEGER               not null,
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
   USERNAME             CHAR(50),
   GIOI_TINH            SMALLINT,
   DIA_CHI              RAW(2000),
   SDT                  RAW(2000),
   NGAY_SINH            DATE,
   EMAIL                RAW(2000),
   constraint PK_NGUOI_DUNG primary key (MA_ND)
);

/*==============================================================*/
/* Table: SINH_VIEN                                             */
/*==============================================================*/
create table SINH_VIEN (
   MA_ND                INTEGER               not null,
   MA_BO_MON            INTEGER               not null,
   MSSV                 CHAR(10),
   constraint PK_SINH_VIEN primary key (MA_ND)
);

/*==============================================================*/
/* Index: THUOCVAO_FK                                           */
/*==============================================================*/
create index THUOCVAO_FK on SINH_VIEN (
   MA_BO_MON ASC
);

/*==============================================================*/
/* Table: TRUONG_BO_MON                                         */
/*==============================================================*/
create table TRUONG_BO_MON (
   MA_TBM               INTEGER               not null,
   constraint PK_TRUONG_BO_MON primary key (MA_TBM)
);

/*==============================================================*/
/* Table: TRUONG_PHO_KHOA                                       */
/*==============================================================*/
create table TRUONG_PHO_KHOA (
   MA_TPK               INTEGER               not null,
   constraint PK_TRUONG_PHO_KHOA primary key (MA_TPK)
);

CREATE TABLE LUU_KEY (
    MA_ND INTEGER,
    KEY_BYTES_RAW RAW(32),
    CONSTRAINT PK_LUU_KEY PRIMARY KEY (MA_ND, KEY_BYTES_RAW)
);
