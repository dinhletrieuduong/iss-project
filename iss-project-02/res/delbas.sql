TRUNCATE TABLE COURSEMAN.NGUOI_DUNG;
TRUNCATE TABLE COURSEMAN.BO_MON;
TRUNCATE TABLE COURSEMAN.DANG_KY;
TRUNCATE TABLE COURSEMAN.KHOA;
TRUNCATE TABLE COURSEMAN.LICH_HOC;
TRUNCATE TABLE COURSEMAN.MON_HOC_MO;
TRUNCATE TABLE COURSEMAN.MON_HOC;

BEGIN
    FOR u IN (
        SELECT USERNAME
        FROM DBA_USERS
        WHERE USERNAME LIKE 'CE_%')
    LOOP
        EXECUTE IMMEDIATE 'DROP USER "' || u.USERNAME || '"';
    END LOOP;
END;