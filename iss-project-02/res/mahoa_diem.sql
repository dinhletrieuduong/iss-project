set serveroutput on

BEGIN
DBMS_RLS.DROP_POLICY(
object_schema => 'COURSEMAN',
object_name => 'DANG_KY',
policy_name => 'DIEM_MON_HOC'
);
END;
/

CREATE OR REPLACE PROCEDURE sp_InsertUpdateGrade
(ma_user in INTEGER, ma_monhoc in INTEGER, dtb FLOAT, dth FLOAT, dgk FLOAT, dck FLOAT, dk FLOAT, dc FLOAT)
AS
c1 SYS_REFCURSOR;
user_key RAW (32);
encrypted_dtb RAW (2000);
encrypted_dth RAW (2000);
encrypted_dgk RAW (2000);
encrypted_dck RAW (2000);
encrypted_dc RAW (2000);
encrypted_dk RAW (2000);
BEGIN
SELECT user_key into user_key FROM LUU_KEY WHERE MA_ND = ma_user;

sp_EncryptData(dtb, encrypted_dtb, user_key);
UPDATE DANG_KY SET DIEMTRUNGBINH = encrypted_dtb WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;

sp_EncryptData(dgk, encrypted_dgk, user_key);
UPDATE DANG_KY SET DIEMGIUAKY = encrypted_dgk WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;

sp_EncryptData(dck, encrypted_dck, user_key);
UPDATE DANG_KY SET DIEMCUOIKY = encrypted_dck WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;

sp_EncryptData(dth, encrypted_dth, user_key);
UPDATE DANG_KY SET DIEMTHUCHANH = encrypted_dth WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;

sp_EncryptData(dc, encrypted_dc, user_key);
UPDATE DANG_KY SET DIEMCONG = encrypted_dc WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;

sp_EncryptData(dk, encrypted_dk, user_key);
UPDATE DANG_KY SET DIEMKHAC = encrypted_dk WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;

END;
/
CREATE OR REPLACE PROCEDURE sp_GetStudentGrade
(ma_user in INTEGER, ma_monhoc in INTEGER, dtb out FLOAT, dth out FLOAT, dgk out FLOAT, dck out FLOAT, dk out FLOAT, dc out FLOAT)
AS
c1 SYS_REFCURSOR;
c2 SYS_REFCURSOR;
key_bytes_raw RAW (32);
encrypted_dtb RAW (2000);
encrypted_dth RAW (2000);
encrypted_dgk RAW (2000);
encrypted_dck RAW (2000);
encrypted_dk RAW (2000);
encrypted_dc RAW (2000);
decrypted_dtb RAW (2000);
decrypted_dth RAW (2000);
decrypted_dgk RAW (2000);
decrypted_dck RAW (2000);
decrypted_dk RAW (2000);
decrypted_dc RAW (2000);
BEGIN

SELECT user_key into key_bytes_raw FROM LUU_KEY WHERE MA_ND = ma_user;

SELECT DIEMTRUNGBINH into encrypted_dtb FROM DANG_KY WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;
SELECT DIEMTHUCHANH into encrypted_dth FROM DANG_KY WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;
SELECT DIEMGIUAKY into encrypted_dgk FROM DANG_KY WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;
SELECT DIEMCUOIKY into encrypted_dck FROM DANG_KY WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;
SELECT DIEMKHAC into encrypted_dk FROM DANG_KY WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;
SELECT DIEMCONG into encrypted_dc FROM DANG_KY WHERE MA_SV = ma_user AND MA_MON_HOC_MO = ma_monhoc;

sp_DecryptData(dtb, encrypted_dtb, key_bytes_raw);
sp_DecryptData(dth, encrypted_dth, key_bytes_raw);
sp_DecryptData(dgk, encrypted_dgk, key_bytes_raw);
sp_DecryptData(dck, encrypted_dck, key_bytes_raw);
sp_DecryptData(dk, encrypted_dk, key_bytes_raw);
sp_DecryptData(dc, encrypted_dc, key_bytes_raw);

END;
/



