-- VPD 
BEGIN
    DBMS_RLS.DROP_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'LUU_KEY',
        policy_name => 'KEY_ACCESS'
    );
END;
/

-- START VPD
-- VPD ONLY ALOW USER TO ACCESS TO THEIR OWN KEY TO DECRYPT
CREATE OR REPLACE FUNCTION func_User_Access_Key (p_schema VARCHAR2, p_obj VARCHAR2)
RETURN VARCHAR2
AS
    MA_ND CHAR(250);
BEGIN
    IF (SYS_CONTEXT('USERENV', 'SESSION_USER') = 'COURSEMAN') THEN
      RETURN '';  
    END IF;
    
    MA_ND := '(SELECT MA_ND FROM COURSEMAN.NGUOI_DUNG)';
    
    IF (SYS_CONTEXT('USERENV', 'SESSION_USER') = 'CE_GIAOVU') THEN
      RETURN 'USERNAME = ''CE_GIAOVU'' AND MA_ND = ' || MA_ND;
    END IF;
    
    
    RETURN 'MA_ND = ' || MA_ND;
END;
/
BEGIN
    DBMS_RLS.ADD_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'LUU_KEY',
        policy_name => 'KEY_ACCESS',
        policy_function => 'func_User_Access_Key',
        statement_types => 'SELECT'
);
END;
/