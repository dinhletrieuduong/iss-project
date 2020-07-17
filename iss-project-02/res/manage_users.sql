SET SERVEROUTPUT ON;
-- type = 1: giaovu
-- type = 2: giaovien
-- type = 3: sinhvien

CREATE OR REPLACE PROCEDURE sp_RegisterUser(
    p_username VARCHAR2,
    p_password VARCHAR2,
    p_ho_ten VARCHAR2,
    p_gioi_tinh NUMBER,
    p_dia_chi VARCHAR2,
    p_sdt CHAR,
    p_ngay_sinh DATE,
    p_email VARCHAR2,
    p_ma_khoa NUMBER,
    p_ma_bo_mon NUMBER,
    p_mssv CHAR,
    p_role NUMBER)
AS
    l_username VARCHAR2(30);
    l_ma_nd NUMBER;
    l_key RAW (32);
    l_encrypted_email RAW (2000);
    l_encrypted_sdt RAW (2000);
BEGIN
    l_username := 'CE_' || UPPER(p_username);
    l_key := DBMS_CRYPTO.RANDOMBYTES(32);
    
    BEGIN
      EXECUTE IMMEDIATE 'CREATE USER "' || l_username || '" IDENTIFIED BY "' || p_password || '"';
      EXECUTE IMMEDIATE 'GRANT CONNECT TO "' || l_username || '"';
    EXCEPTION WHEN OTHERS THEN
      RETURN;
    END;

    INSERT INTO COURSEMAN.NGUOI_DUNG (USERNAME, HO_TEN, GIOI_TINH, DIA_CHI, SDT, NGAY_SINH, EMAIL, KIEUND)
    VALUES (l_username, p_ho_ten, p_gioi_tinh, null, p_sdt, p_ngay_sinh, null, p_role)
    RETURNING MA_ND INTO l_ma_nd;
    
    INSERT INTO COURSEMAN.LUU_KEY VALUES (l_ma_nd, l_key);
        
    COURSEMAN.SP_ENCRYPTDATA(p_email, l_encrypted_email, l_key);
    COURSEMAN.SP_ENCRYPTDATA(p_sdt, l_encrypted_sdt, l_key);
    
    UPDATE COURSEMAN.NGUOI_DUNG
    SET SDT = l_encrypted_sdt,
      EMAIL = l_encrypted_email
    WHERE MA_ND = l_ma_nd;
    
    IF p_role = 1 THEN
        EXECUTE IMMEDIATE 'GRANT GIAOVU TO ' || l_username;
    ELSIF p_role = 2 THEN
        EXECUTE IMMEDIATE 'GRANT GIAOVIEN TO ' || l_username;
    ELSIF p_role = 3 THEN
        EXECUTE IMMEDIATE 'GRANT SINHVIEN TO ' || l_username;
        UPDATE COURSEMAN.NGUOI_DUNG
        SET MA_BO_MON = p_ma_bo_mon,
            MA_KHOA = p_ma_khoa,
            MSSV = p_mssv
        WHERE MA_ND = l_ma_nd;
    END IF;
END;
/



GRANT EXECUTE ON sp_RegisterUser TO GIAOVU;
COMMIT;