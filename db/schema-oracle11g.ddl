-- ������Oracle SQL Developer Data Modeler 4.1.3.901
--   ʱ��:        2017-02-20 15:38:50 CST
--   վ��:      Oracle Database 11g
--   ����:      Oracle Database 11g




CREATE TABLE SYS_ORG
  (
    ID        VARCHAR2 (32) NOT NULL ,
    NAME      VARCHAR2 (50) ,
    PARENT_ID VARCHAR2 (32) ,
    VALID     CHAR (1) ,
    SORT_NUM  INTEGER
  ) ;
COMMENT ON COLUMN SYS_ORG.ID
IS
  '����' ;
  COMMENT ON COLUMN SYS_ORG.VALID
IS
  '0:���� 1����ɾ��' ;
  COMMENT ON COLUMN SYS_ORG.SORT_NUM
IS
  '�����' ;
ALTER TABLE SYS_ORG ADD PRIMARY KEY ( ID ) ;


CREATE TABLE SYS_ORG_USER
  (
    ID            INTEGER NOT NULL ,
    ORG_ID        VARCHAR2 (32) ,
    USER_ID       VARCHAR2 (32) ,
    POSITION_CODE CHAR (4) ,
    POSITION_NAME VARCHAR2 (50) ,
    START_DATE    DATE ,
    END_DATE      DATE ,
    VALID         CHAR (1)
  ) ;
COMMENT ON COLUMN SYS_ORG_USER.VALID
IS
  '0:���� 1����ɾ��' ;
ALTER TABLE SYS_ORG_USER ADD PRIMARY KEY ( ID ) ;


CREATE TABLE SYS_PERMISSION
  (
    ID          VARCHAR2 (32) NOT NULL ,
    "LEVEL"     CHAR (1) ,
    TYPE        CHAR (1) ,
    DESCRIPTION VARCHAR2 (32) ,
    URL         VARCHAR2 (50) ,
    ACTION      CHAR (1) ,
    PARENT_ID   VARCHAR2 (32) ,
    VALID       CHAR (1)
  ) ;
COMMENT ON COLUMN SYS_PERMISSION.ID
IS
  '����' ;
  COMMENT ON COLUMN SYS_PERMISSION."LEVEL"
IS
  'Levels of permission granularity
1.Resource Level ���Ϊ�� �˵�ҳ���ҳ���ϵ�CRUD����  create, read, update, and delete
2.Instance Level ���Ϊ�� ����Ȩ�� �������һ������ݣ������������еĿ�Ȫˮ��������
3.Attribute Level ���Ϊ�� ����Ȩ���еľ����ֶΣ��������������еĽ�����' ;
  COMMENT ON COLUMN SYS_PERMISSION.TYPE
IS
  '��Ӧ��LEVELΪ RESOUCE
1��ҳ�棨�˵���
2��ҳ�������CRUD��' ;
  COMMENT ON COLUMN SYS_PERMISSION.DESCRIPTION
IS
  '��������' ;
  COMMENT ON COLUMN SYS_PERMISSION.URL
IS
  'ҳ���URL' ;
  COMMENT ON COLUMN SYS_PERMISSION.ACTION
IS
  'CRUD
Common actions for data-related resources are create, read, update, and delete, commonly referred to as CRUD.' ;
  COMMENT ON COLUMN SYS_PERMISSION.PARENT_ID
IS
  '�㼶����һ����Ŀǰ���ڲ˵��㼶��' ;
  COMMENT ON COLUMN SYS_PERMISSION.VALID
IS
  '0����Ч 1����ɾ��' ;
ALTER TABLE SYS_PERMISSION ADD PRIMARY KEY ( ID ) ;


CREATE TABLE SYS_ROLE
  ( ID VARCHAR2 (32) NOT NULL , NAME VARCHAR2 (50)
  ) ;
ALTER TABLE SYS_ROLE ADD PRIMARY KEY ( ID ) ;


CREATE TABLE SYS_ROLE_PERMISSION
  (
    ID           INTEGER NOT NULL ,
    ROLE_ID      VARCHAR2 (32) ,
    PEMISSION_ID VARCHAR2 (32)
  ) ;
ALTER TABLE SYS_ROLE_PERMISSION ADD PRIMARY KEY ( ID ) ;


CREATE TABLE SYS_USER
  (
    ID         VARCHAR2 (32) NOT NULL ,
    NAME       VARCHAR2 (50) ,
    LOGIN_NAME VARCHAR2 (16) ,
    PASSWORD   VARCHAR2 (32) ,
    VALID      CHAR (1)
  ) ;
COMMENT ON COLUMN SYS_USER.VALID
IS
  '0:���� 1����ɾ��' ;
ALTER TABLE SYS_USER ADD PRIMARY KEY ( ID ) ;


CREATE TABLE SYS_USER_ROLE
  (
    ID      INTEGER NOT NULL ,
    USER_ID VARCHAR2 (32) ,
    ROLE_ID VARCHAR2 (32)
  ) ;
COMMENT ON COLUMN SYS_USER_ROLE.USER_ID
IS
  '�˴���Ϊ�˺����ɫ��ϵ��Ĭ��һ��һ�˺ţ�����userid���ɫ����' ;
ALTER TABLE SYS_USER_ROLE ADD PRIMARY KEY ( ID ) ;



-- Oracle SQL Developer Data Modeler ��Ҫ����: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             0
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
