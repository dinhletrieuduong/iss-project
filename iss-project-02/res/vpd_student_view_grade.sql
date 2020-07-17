-- VPD 

-- DROP 
BEGIN
    DBMS_RLS.DROP_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'DANG_KY',
        policy_name => 'GRADE_ACCESS'
    );
END;
/


CREATE OR REPLACE FUNCTION func_Student_Access_Grade (p_schema VARCHAR2, p_obj VARCHAR2)
RETURN VARCHAR2
AS
    MA_ND CHAR(250);
BEGIN
    IF (SYS_CONTEXT('USERENV', 'SESSION_USER') = 'COURSEMAN') THEN
      RETURN '';
    END IF;
    
    MA_ND := '(SELECT MA_ND FROM COURSEMAN.NGUOI_DUNG)';
    RETURN 'MA_SV = ' || MA_ND;
END;
/


BEGIN
    DBMS_RLS.ADD_POLICY(
        object_schema => 'COURSEMAN',
        object_name => 'DANG_KY',
        policy_name => 'GRADE_ACCESS',
        policy_function => 'func_Student_Access_Grade',
        statement_types => 'SELECT'
    );
END;
