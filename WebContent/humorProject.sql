create table hpmember(
	id varchar2(12) primary key,
	password varchar2(12) not null,
	name varchar2(20) not null,
	address varchar2(50),
	tel varchar2(20) not null,
	reg_date date,
	del char(1)
);
alter table hpmember add(del char(1));
update hpmember set del ='n';
select * from HPMEMBER;
update hpmember set del = 'n' where id = 'jyyun21';
alter table hpmember add (del char(1));
delete from hpmember where id like 'a%';
update hpmember set del='n';
select * from hpmember;