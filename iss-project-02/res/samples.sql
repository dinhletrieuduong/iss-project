EXECUTE sp_RegisterUser('tccuong', 'tccuong', 'Thai Chi Cuong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, '', '2');
EXECUTE sp_RegisterUser('pvduc', 'pvduc', 'Phan Viet Duc', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, '', '2');
EXECUTE sp_RegisterUser('nva', 'nva', 'Nguyen Van A', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, '', '2');
EXECUTE sp_RegisterUser('nvb', 'nvb', 'Nguyen Van B', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, '', '2');
EXECUTE sp_RegisterUser('nvc', 'nvc', 'Nguyen Van C', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, '', '2');
EXECUTE sp_RegisterUser('nvd', 'nvd', 'Nguyen Van D', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, '', '2');
EXECUTE sp_RegisterUser('nve', 'nve', 'Nguyen Van E', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, '', '2');

EXECUTE sp_RegisterUser('dltduong', 'dltduong', 'Dinh Le Trieu Duong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, '', '1');

SELECT * FROM NGUOI_DUNG;
SELECT * FROM GIAO_VIEN;
SELECT * FROM GIAO_VU;

INSERT INTO KHOA (MA_TPK, TEN_KHOA)
VALUES(1, 'CNTT');

INSERT INTO BO_MON(MA_KHOA, MA_TBM, TEN_BO_MON)
VALUES (1, 3, 'HTTT');
INSERT INTO BO_MON(MA_KHOA, MA_TBM, TEN_BO_MON)
VALUES (1, 4, 'KHMT');
INSERT INTO BO_MON(MA_KHOA, MA_TBM, TEN_BO_MON)
VALUES (1, 5, 'KTPM');

INSERT INTO KHOA (MA_TPK, TEN_KHOA)
VALUES(2, 'HOA');

INSERT INTO BO_MON(MA_KHOA, MA_TBM, TEN_BO_MON)
VALUES (2, 6, 'HS');
INSERT INTO BO_MON(MA_KHOA, MA_TBM, TEN_BO_MON)
VALUES (2, 7, 'HHCHD');

SELECT * FROM BO_MON;
SELECT * FROM KHOA;

EXECUTE sp_RegisterUser('1700001', '1700001', 'Dinh Ha Tuyen', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700001', '3')
EXECUTE sp_RegisterUser('1700002', '1700002', 'Phan Bich Mao', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700002', '3')
EXECUTE sp_RegisterUser('1700003', '1700003', 'Nguyen Chau Mieu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700003', '3')
EXECUTE sp_RegisterUser('1700004', '1700004', 'Thai Kim Mieu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700004', '3')
EXECUTE sp_RegisterUser('1700005', '1700005', 'Ho Ha Lieu', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700005', '3')
EXECUTE sp_RegisterUser('1700006', '1700006', 'Pham Duc Mao', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700006', '3')
EXECUTE sp_RegisterUser('1700007', '1700007', 'Nguyen Hanh An', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700007', '3')
EXECUTE sp_RegisterUser('1700008', '1700008', 'Pham Ha Phong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700008', '3')
EXECUTE sp_RegisterUser('1700009', '1700009', 'Thai Xuan Mao', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700009', '3')
EXECUTE sp_RegisterUser('1700010', '1700010', 'Nguyen Hanh Mieu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700010', '3')
EXECUTE sp_RegisterUser('1700011', '1700011', 'Pham Ba Xa', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700011', '3')
EXECUTE sp_RegisterUser('1700012', '1700012', 'Nguyen Thu Thien', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700012', '3')
EXECUTE sp_RegisterUser('1700013', '1700013', 'Duong Dong Nhung', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700013', '3')
EXECUTE sp_RegisterUser('1700014', '1700014', 'Le Bich Xa', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700014', '3')
EXECUTE sp_RegisterUser('1700015', '1700015', 'Dinh Chau Tuyen', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700015', '3')
EXECUTE sp_RegisterUser('1700016', '1700016', 'Dinh Ha Duc', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700016', '3')
EXECUTE sp_RegisterUser('1700017', '1700017', 'Dinh Dinh Phong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700017', '3')
EXECUTE sp_RegisterUser('1700018', '1700018', 'Vo Dong Tuyen', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700018', '3')
EXECUTE sp_RegisterUser('1700019', '1700019', 'Vo Dong Duc', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700019', '3')
EXECUTE sp_RegisterUser('1700020', '1700020', 'Nguyen Hanh Cuong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700020', '3')
EXECUTE sp_RegisterUser('1700021', '1700021', 'Phan Manh Mao', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700021', '3')
EXECUTE sp_RegisterUser('1700022', '1700022', 'Duong Thi Lieu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700022', '3')
EXECUTE sp_RegisterUser('1700023', '1700023', 'Bui Cam Gia Cat', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700023', '3')
EXECUTE sp_RegisterUser('1700024', '1700024', 'Bui Ba Gia Cat', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700024', '3')
EXECUTE sp_RegisterUser('1700025', '1700025', 'Nguyen Xuan Tuyen', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700025', '3')
EXECUTE sp_RegisterUser('1700026', '1700026', 'Thai Cam Duong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700026', '3')
EXECUTE sp_RegisterUser('1700027', '1700027', 'Nguyen Huu Gia Cat', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700027', '3')
EXECUTE sp_RegisterUser('1700028', '1700028', 'Bui Bich Ha', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700028', '3')
EXECUTE sp_RegisterUser('1700029', '1700029', 'Pham Thi Thien', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700029', '3')
EXECUTE sp_RegisterUser('1700030', '1700030', 'Phan Thi Phong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700030', '3')
EXECUTE sp_RegisterUser('1700031', '1700031', 'Tran Ha Nhung', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700031', '3')
EXECUTE sp_RegisterUser('1700032', '1700032', 'Le Dinh Ha', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700032', '3')
EXECUTE sp_RegisterUser('1700033', '1700033', 'Dinh Thu Duc', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700033', '3')
EXECUTE sp_RegisterUser('1700034', '1700034', 'Le Ha Cuong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700034', '3')
EXECUTE sp_RegisterUser('1700035', '1700035', 'Dinh Van Ha', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700035', '3')
EXECUTE sp_RegisterUser('1700036', '1700036', 'Vo Bich Duc', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700036', '3')
EXECUTE sp_RegisterUser('1700037', '1700037', 'Phan Thu Ha', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700037', '3')
EXECUTE sp_RegisterUser('1700038', '1700038', 'Dinh Dinh Nhung', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700038', '3')
EXECUTE sp_RegisterUser('1700039', '1700039', 'Bui Manh Thien', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700039', '3')
EXECUTE sp_RegisterUser('1700040', '1700040', 'Nguyen Huu Duc', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700040', '3')
EXECUTE sp_RegisterUser('1700041', '1700041', 'Duong Ha Nhung', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700041', '3')
EXECUTE sp_RegisterUser('1700042', '1700042', 'Phan Ha Duong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700042', '3')
EXECUTE sp_RegisterUser('1700043', '1700043', 'Bui Van An', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700043', '3')
EXECUTE sp_RegisterUser('1700044', '1700044', 'Tran Huu Duc', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700044', '3')
EXECUTE sp_RegisterUser('1700045', '1700045', 'Phan Hanh Phong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700045', '3')
EXECUTE sp_RegisterUser('1700046', '1700046', 'Thai Hanh Nhung', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700046', '3')
EXECUTE sp_RegisterUser('1700047', '1700047', 'Pham Van Mieu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700047', '3')
EXECUTE sp_RegisterUser('1700048', '1700048', 'Phan Dinh Phong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700048', '3')
EXECUTE sp_RegisterUser('1700049', '1700049', 'Dinh Duc Duong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700049', '3')
EXECUTE sp_RegisterUser('1700050', '1700050', 'Vo Dong Tuyen', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700050', '3')
EXECUTE sp_RegisterUser('1700051', '1700051', 'Tran Chau Mao', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700051', '3')
EXECUTE sp_RegisterUser('1700052', '1700052', 'Ly Kim Phong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700052', '3')
EXECUTE sp_RegisterUser('1700053', '1700053', 'Nguyen Van Duc', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700053', '3')
EXECUTE sp_RegisterUser('1700054', '1700054', 'Pham Thi Phong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700054', '3')
EXECUTE sp_RegisterUser('1700055', '1700055', 'Phan Dinh Lieu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700055', '3')
EXECUTE sp_RegisterUser('1700056', '1700056', 'Ho Thi An', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700056', '3')
EXECUTE sp_RegisterUser('1700057', '1700057', 'Ly Thi Xa', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700057', '3')
EXECUTE sp_RegisterUser('1700058', '1700058', 'Vo Thi An', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700058', '3')
EXECUTE sp_RegisterUser('1700059', '1700059', 'Bui Dong An', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700059', '3')
EXECUTE sp_RegisterUser('1700060', '1700060', 'Pham Van Xa', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700060', '3')
EXECUTE sp_RegisterUser('1700061', '1700061', 'Phan Thi An', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700061', '3')
EXECUTE sp_RegisterUser('1700062', '1700062', 'Tran Van Duc', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700062', '3')
EXECUTE sp_RegisterUser('1700063', '1700063', 'Ly Thu Ha', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700063', '3')
EXECUTE sp_RegisterUser('1700064', '1700064', 'Vo Xuan Mieu', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700064', '3')
EXECUTE sp_RegisterUser('1700065', '1700065', 'Le Hanh Xa', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700065', '3')
EXECUTE sp_RegisterUser('1700066', '1700066', 'Vo Hanh Duong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700066', '3')
EXECUTE sp_RegisterUser('1700067', '1700067', 'Dinh Ha Duong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700067', '3')
EXECUTE sp_RegisterUser('1700068', '1700068', 'Dinh Ba Duong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700068', '3')
EXECUTE sp_RegisterUser('1700069', '1700069', 'Ly Dong Thien', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700069', '3')
EXECUTE sp_RegisterUser('1700070', '1700070', 'Bui Chau Mao', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700070', '3')
EXECUTE sp_RegisterUser('1700071', '1700071', 'Tran Bich Ha', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700071', '3')
EXECUTE sp_RegisterUser('1700072', '1700072', 'Pham Ha Duong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700072', '3')
EXECUTE sp_RegisterUser('1700073', '1700073', 'Ho Huu Phong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700073', '3')
EXECUTE sp_RegisterUser('1700074', '1700074', 'Nguyen Duc Thien', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700074', '3')
EXECUTE sp_RegisterUser('1700075', '1700075', 'Ho Bich Mao', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700075', '3')
EXECUTE sp_RegisterUser('1700076', '1700076', 'Pham Ha Xa', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700076', '3')
EXECUTE sp_RegisterUser('1700077', '1700077', 'Duong Thi Xa', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700077', '3')
EXECUTE sp_RegisterUser('1700078', '1700078', 'Ly Dong Thien', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700078', '3')
EXECUTE sp_RegisterUser('1700079', '1700079', 'Thai Duc Phong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700079', '3')
EXECUTE sp_RegisterUser('1700080', '1700080', 'Nguyen Hanh Gia Cat', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700080', '3')
EXECUTE sp_RegisterUser('1700081', '1700081', 'Pham Cam Lieu', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700081', '3')
EXECUTE sp_RegisterUser('1700082', '1700082', 'Duong Dinh Gia Cat', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700082', '3')
EXECUTE sp_RegisterUser('1700083', '1700083', 'Le Duc Duong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700083', '3')
EXECUTE sp_RegisterUser('1700084', '1700084', 'Thai Dinh Mao', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700084', '3')
EXECUTE sp_RegisterUser('1700085', '1700085', 'Duong Ha Duong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700085', '3')
EXECUTE sp_RegisterUser('1700086', '1700086', 'Dinh Ba Cuong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700086', '3')
EXECUTE sp_RegisterUser('1700087', '1700087', 'Ly Van Phong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700087', '3')
EXECUTE sp_RegisterUser('1700088', '1700088', 'Le Ha Duong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700088', '3')
EXECUTE sp_RegisterUser('1700089', '1700089', 'Nguyen Chau Nhung', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700089', '3')
EXECUTE sp_RegisterUser('1700090', '1700090', 'Tran Chau Gia Cat', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700090', '3')
EXECUTE sp_RegisterUser('1700091', '1700091', 'Ho Bich Duc', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700091', '3')
EXECUTE sp_RegisterUser('1700092', '1700092', 'Ho Ba Phong', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700092', '3')
EXECUTE sp_RegisterUser('1700093', '1700093', 'Nguyen Van Tuyen', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700093', '3')
EXECUTE sp_RegisterUser('1700094', '1700094', 'Tran Bich Lieu', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700094', '3')
EXECUTE sp_RegisterUser('1700095', '1700095', 'Phan Dong Duong', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700095', '3')
EXECUTE sp_RegisterUser('1700096', '1700096', 'Thai Thu An', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700096', '3')
EXECUTE sp_RegisterUser('1700097', '1700097', 'Bui Dinh Lieu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700097', '3')
EXECUTE sp_RegisterUser('1700098', '1700098', 'Ly Thu Lieu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700098', '3')
EXECUTE sp_RegisterUser('1700099', '1700099', 'Ho Thi Xa', '0', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '2', null, '1700099', '3')
EXECUTE sp_RegisterUser('1700100', '1700100', 'Le Bich Gia Cat', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', '1', null, '1700100', '3')

EXECUTE sp_RegisterUser('giaovu', 'giaovu', 'Giao Vu', '1', '227, Nguyen Van Cu, P12, Q5', '0399363292', TO_DATE('14/04/1999', 'DD/MM/YYYY'), 'duongngunhubo@gmail.com', null, null, null, 1);
