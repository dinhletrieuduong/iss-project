CREATE OR REPLACE FUNCTION func_User_View_Their_Info (p_schema VARCHAR2, p_obj VARCHAR2)
RETURN VARCHAR2
AS
    USERNAME CHAR(250);
    UROLE CHAR(100);
BEGIN
    USERNAME := SYS_CONTEXT('USERENV', 'SESSION_USER');
    
    IF (USERNAME = 'COURSEMAN' OR USERNAME = 'CE_GIAOVU') THEN
      RETURN '';
    END IF;

    RETURN 'USERNAME = (SELECT SYS_CONTEXT(''USERENV'', ''SESSION_USER'') FROM DUAL)';
END;
/

BEGIN 
    DBMS_RLS.DROP_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'NGUOI_DUNG',
        policy_name => 'USER_INFO'
    );
END;

BEGIN
    DBMS_RLS.ADD_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'NGUOI_DUNG',
        policy_name => 'USER_INFO',
        policy_function => 'func_User_View_Their_Info',
        statement_types => 'SELECT, UPDATE'
    );
END;
