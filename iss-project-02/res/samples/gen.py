from random import randint

family_name = [
	"Nguyen",
	"Tran",
	"Le",
	"Ly",
	"Pham",
	"Thai",
	"Dinh",
	"Phan",
	"Ho",
	"Duong",
	"Vo",
	"Bui"
]

middle_name = [
	"Van",
	"Huu",
	"Thi",
	"Dinh",
	"Xuan",
	"Ha",
	"Thu",
	"Dong",
	"Kim",
	"Ba",
	"Manh",
	"Cam",
	"Chau",
	"Duc",
	"Hanh",
	"Bich"
]

last_name = [
	"Cuong",
	"Duc",
	"Duong",
	"An",
	"Ha",
	"Thien",
	"Tuyen",
	"Nhung",
	"Phong",
	"Lieu",
	"Duong",
	"Mieu",
	"Mao",
	"Gia Cat",
	"Xa"
]

mssv_seq = 0

def gen_fullname():
	fi = randint(0, len(family_name) - 1)
	mi = randint(0, len(middle_name) - 1)
	li = randint(0, len(last_name) - 1)
	fullname = family_name[fi] + " " + middle_name[mi] + " " + last_name[li]
	return fullname

def gen_mssv(k):
	global mssv_seq
	mssv_seq = mssv_seq + 1
	return "{:02d}".format(k) + "{:05d}".format(mssv_seq)

def make_sql(query, *strs):
	for s in strs:
		s = str(s)
		if (s[0] == "@"):
			query = query.replace("?", s.replace("@", "", 1), 1)
		else:
			query = query.replace("?", "\'" + str(s) + "\'", 1)
	return query

def gen_user():
	mssv = gen_mssv(17)
	name = gen_fullname()
	sex = randint(0, 1)
	fac = randint(1, 2)
	query = "EXECUTE sp_RegisterUser(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
	query = make_sql(query, mssv, mssv, name, sex, '227, Nguyen Van Cu, P12, Q5', '0399363292', '@TO_DATE(\'14/04/1999\', \'DD/MM/YYYY\')', 'duongngunhubo@gmail.com', fac, '@null', mssv, '3')
	print(query)


for i in range (100):
	gen_user()




