-- ȸ��
DROP TABLE member cascade constraint;
-- ����
DROP TABLE wallet cascade constraint;
-- �ŷ���
DROP TABLE exchange cascade constraint;
-- ��Ʈ����
DROP TABLE btc cascade constraint;
-- �̴�����
DROP TABLE eth cascade constraint;
-- ����Ʈ����
DROP TABLE ltc cascade constraint;
-- �̴����� Ŭ����
DROP TABLE etc cascade constraint;
-- ����
DROP TABLE xrp cascade constraint;
-- �뽬
DROP TABLE dash cascade constraint;

CREATE TABLE member (
	mid 			VARCHAR2(30)  PRIMARY KEY,
	mname 		VARCHAR2(30) NOT NULL,
	pw 			VARCHAR2(30) NOT NULL,
	email 			VARCHAR2(50) NOT NULL
);

CREATE TABLE wallet (
	mid 			VARCHAR2(30) NOT NULL,
	cname 		VARCHAR2(30) NOT NULL,
	amount 		NUMBER(10) NOT NULL,
	price 			NUMBER(15) NOT NULL
);

CREATE TABLE exchange (
	eid	 			NUMBER(5) PRIMARY KEY,
	ename 		VARCHAR2(20) NOT NULL
);

CREATE TABLE btc (
	day 			VARCHAR2(20) NOT NULL,
	last_price 	NUMBER(15, 0) NOT NULL,
	volume 		NUMBER(15) NOT NULL,
	eid 			NUMBER(5) NOT NULL
);

CREATE TABLE eth (
	day 			VARCHAR2(20) NOT NULL,
	last_price 	NUMBER(15, 0) NOT NULL,
	volume 		NUMBER(15) NOT NULL,
	eid 			NUMBER(5) NOT NULL
);

CREATE TABLE ltc (
	day 			VARCHAR2(20) NOT NULL,
	last_price 	NUMBER(15, 0) NOT NULL,
	volume 		NUMBER(15) NOT NULL,
	eid 			NUMBER(5) NOT NULL
);

CREATE TABLE etc (
	day 			VARCHAR2(20) NOT NULL,
	last_price 	NUMBER(15, 0) NOT NULL,
	volume 		NUMBER(15) NOT NULL,
	eid 			NUMBER(5) NOT NULL
);

CREATE TABLE xrp (
	day 			VARCHAR2(20) NOT NULL,
	last_price 	NUMBER(15, 0) NOT NULL,
	volume 		NUMBER(15) NOT NULL,
	eid 			NUMBER(5) NOT NULL
);

CREATE TABLE dash (
	day 			VARCHAR2(20) NOT NULL,
	last_price 	NUMBER(15, 0) NOT NULL,
	volume 		NUMBER(15) NOT NULL,
	eid 			NUMBER(5) NOT NULL
);


ALTER TABLE wallet  ADD FOREIGN KEY (mid) REFERENCES member  (mid);
ALTER TABLE btc ADD FOREIGN KEY (eid) REFERENCES exchange  (eid);
ALTER TABLE eth ADD FOREIGN KEY (eid) REFERENCES exchange  (eid);
ALTER TABLE ltc ADD FOREIGN KEY (eid) REFERENCES exchange  (eid);
ALTER TABLE etc ADD FOREIGN KEY (eid) REFERENCES exchange  (eid);
ALTER TABLE xrp ADD FOREIGN KEY (eid) REFERENCES exchange  (eid);
ALTER TABLE dash ADD FOREIGN KEY (eid) REFERENCES exchange  (eid);