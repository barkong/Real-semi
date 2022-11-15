create table account (
a_id varchar(20) primary key,
a_password varchar(20) not null,
a_name varchar(5) not null,
a_birth datetime ,
a_gender varchar(1),  
a_email varchar(20),
a_phone varchar(20) not null,
a_interest varchar2(20 char) not null
);

insert into account values('abcd','1234','송준우','2022-11-15','남','abc@naver.com','01011112222','드라마');

select * from account;