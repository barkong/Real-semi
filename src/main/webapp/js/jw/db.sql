create table semi_account (
a_id varchar2(30) primary key,
a_password varchar2(20) not null,
a_name varchar2(10) not null,
a_birth date,
a_gender varchar2(3) not null,  
a_email varchar2(30) not null,
a_phone varchar2(20) not null,
a_interest varchar2(30 char) not null
);

insert into semi_account values('abcd','1234','송준우','05/03/2000','남','abc@naver.com','01011112222','SF');
insert into semi_account values('efgh','1234','송준우','05/04/2001','남','abcd@naver.com','01011112223','공포');
insert into semi_account values('ijkl','1234','송준우','05/05/2002','남','abce@naver.com','01011112224','로맨스');
insert into semi_account values('mnop','1234','송준우','05/06/2003','남','abcf@naver.com','01011112225','호러');

select * from semi_account;