-- VPD 

-- DROP VPD
BEGIN
    DBMS_RLS.DROP_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'NGUOI_DUNG',
        policy_name => 'KEY_ACCESS'
    );
END;
/   

BEGIN
    DBMS_RLS.DROP_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'GRADE_SINHVIEN_GIAOVIEN',
        policy_name => 'GRADE_ACCESS'
    );
END;
/


CREATE OR REPLACE FUNCTION func_User_Access_Grade (p_schema VARCHAR2, p_obj VARCHAR2)
RETURN VARCHAR2
AS
    USERNAME CHAR(50);
BEGIN
    USERNAME := '(SELECT SYS_CONTEXT(''USERENV'', ''SESSION_USER'') FROM DUAL)';
    RETURN 'U_SV = ' || USERNAME || ' OR U_GV = ' || USERNAME;
END;
/


BEGIN
    DBMS_RLS.ADD_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'GRADE_SINHVIEN_GIAOVIEN',
        policy_name => 'GRADE_ACCESS',
        function_schema => 'SEC_MGR',
        policy_function => 'func_User_Access_Grade',
        statement_types => 'SELECT'
        -- sec_relevant_cols => '',
        -- sec_relevant_cols_opt => DBMS_RLS.ALL_ROWS
    );
END;

-- PLUS, GV CAN UPDATE THEIR SV GRADE
CREATE OR REPLACE FUNCTION func_User_Access_Grade (p_schema VARCHAR2, p_obj VARCHAR2)
RETURN VARCHAR2
AS
    USERNAME CHAR(50);
BEGIN
    USERNAME := '(SELECT SYS_CONTEXT(''USERENV'', ''SESSION_USER'') FROM DUAL)';
    RETURN 'U_GV = ' || USERNAME;
END;
/

BEGIN
    DBMS_RLS.ADD_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'GRADE_SINHVIEN_GIAOVIEN',
        policy_name => 'GRADE_ACCESS',
        function_schema => 'SEC_MGR',
        policy_function => 'func_User_Access_Grade',
        statement_types => 'UPDATE'
        -- sec_relevant_cols => '',
        -- sec_relevant_cols_opt => DBMS_RLS.ALL_ROWS
    );
END;