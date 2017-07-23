select * from MEMBER

insert into member values('박지빈', 'cesti0777', '1234', 'shine3199@naver.com', member_seq_wid.nextval)

SET DEFINE OFF;
Insert into EXCHANGE (EID, ENAME) Values (1, 'bithumb');
Insert into EXCHANGE (EID, ENAME) Values (2, 'poloniex');
COMMIT;

select * from btc;

select amount from wallet where mid=?;

-- 시세 그래프
select p.day, b.last_price as BITHUMB, p.last_price as POLONEIX
from dash p, dash b
where p.day = b.day and p.eid = 2 and b.eid = 1;

-- 거래량 그래프
select p.day, b.last_price * b.volume as BITHUMB, p.volume as POLONEIX
from xrp p, xrp b
where p.day = b.day and p.eid = 2 and b.eid = 1;