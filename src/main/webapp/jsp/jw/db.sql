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

insert into semi_account values('abcd','1234','�넚以��슦','2022-11-15','�궓','abc@naver.com','01011112222','SF');
insert into semi_account values('efgh','1234','�넚以��슦','2022-11-16','�궓','abcd@naver.com','01011112223','怨듯룷');
insert into semi_account values('ijkl','1234','�넚以��슦','2022-11-17','�궓','abce@naver.com','01011112224','濡쒕㎤�뒪');
insert into semi_account values('mnop','1234','�넚以��슦','2022-11-18','�궓','abcf@naver.com','01011112225','�샇�윭');

select * from semi_account;