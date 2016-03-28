
create table Jobs(
work_id int not null AUTO_INCREMENT,
job_name varchar(50),
fname varchar(20),
lname varchar(20),
street varchar(50),
city varchar(25),
state varchar(20),
zip_code varchar(5),
phone_num varchar(12),
materials varchar(120),
date varchar(10),
hours int,
startTime varchar(6),
endTime varChar(6),
notes varChar(120),
pdfs varchar(20),
images varchar(20),
primary key(work_id)
) 