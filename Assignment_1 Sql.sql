SELECT * FROM cg.instructor;
use cg;
create table instructorinfo(
recordId int primary key,
instructorCode int references Instructor(instructorCode),
address varchar(100),
email varchar(30),
phone_number  bigint (10),
firstLanguage varchar(20),
secondLanguage varchar(20));
insert into instructor (instructorCode, name, salary, jobStartyear)
values
    (1, 'John Doe', 50000, 2010),
    (2, 'Jane Smith', 60000, 2012),
    (3, 'Bob Johnson', 55000, 2013),
    (4, 'Alice Brown', 58000, 2014),
    (5, 'Ella Davis', 52000, 2015),
    (6, 'Mike Wilson', 53000, 2016),
    (7, 'Linda Lee', 57000, 2017),
    (8, 'Chris Evans', 61000, 2018),
    (9, 'David White', 54000, 2019),
    (10, 'Sarah Black', 59000, 2020),
    (11, 'Paul Adams', 51000, 2021),
    (12, 'Grace Brown', 56000, 2022),
    (13, 'Robert Smith', 60000, 2023),
    (14, 'Olivia Taylor', 52500, 2024),
    (15, 'James Johnson', 54500, 2025);
INSERT INTO instructorInfo (recordId, instructorCode, address, email, phone_number, firstLanguage, secondLanguage)
VALUES
    (1, 1, '123 Main St, City', 'john.doe@example.com', 1234567890, 'English', 'Spanish'),
    (2, 2, '456 Elm St, Town', 'jane.smith@example.com', 9876543210, 'English', 'French'),
    (3, 3, '789 Oak St, Village', 'bob.johnson@example.com', 5555555555, 'English', 'German'),
    (4, 4, '567 Pine St, Suburb', 'alice.brown@example.com', 9999999999, 'English', 'Italian'),
    (5, 5, '321 Oak Ave, City', 'ella.davis@example.com', 5551234567, 'English', 'Spanish'),
    (6, 6, '789 Elm Dr, Town', 'mike.wilson@example.com', 8888888888, 'English', 'French'),
    (7, 7, '456 Birch Rd, Village', 'linda.lee@example.com', 7777777777, 'English', 'German'),
    (8, 8, '654 Maple Ln, Suburb', 'chris.evans@example.com', 6666666666, 'English', 'Italian'),
    (9, 9, '789 Cedar St, City', 'david.white@example.com', 4444444444, 'English', 'Spanish'),
    (10, 10, '987 Oak St, Town', 'sarah.black@example.com', 3333333333, 'English', 'French'),
    (11, 11, '234 Elm Rd, Village', 'paul.adams@example.com', 2222222222, 'English', 'German'),
    (12, 12, '123 Pine Dr, Suburb', 'grace.brown@example.com', 1111111111, 'English', 'Italian'),
    (13, 13, '456 Birch Ave, City', 'robert.smith@example.com', 9998887777, 'English', 'Spanish'),
    (14, 14, '789 Oak Rd, Town', 'olivia.taylor@example.com', 8887776666, 'English', 'French'),
    (15, 15, '987 Maple Ln, Village', 'james.johnson@example.com', 7776665555, 'English', 'German');
-- 1
select * from instructor where salary>59000;
-- 2
alter table instructor
add TechnologyName varchar(50),
add InstructorType varchar(50);
-- 3
update instructor
set
    TechnologyName = case
        when instructorCode in (1, 4, 9, 12) then 'FSD'
        when instructorCode in (2, 7, 14) then'Angular'
        when instructorCode in (3, 11) then 'Testing'
        when instructorCode in (5, 6, 8, 10, 13, 15) then 'SAP'
        else 'SalesForce' -- For the remaining instructors
    end,
    InstructorType = case
        when instructorCode in (1, 4, 9, 12) then 'Programming'
        when instructorCode in (2, 7, 14) then 'Infra'
        when instructorCode in (3, 11) then 'Database'
        when instructorCode in (5, 6, 8, 10, 13, 15) then 'Communication'
        else 'Programming' -- For the remaining instructors
    end;
    -- 3
    select * from instructor where InstructorType='Programming';
    -- 4
    update instructor
    set salary =salary-20000 
    where InstructorType='Communication';
    select * from instructor;
    -- 5
select InstructorType, sum(salary) as TotalSal from instructor where InstructorType = 'Programming';
-- 6
select InstructorType, sum(salary) as TotalSal from instructor group by InstructorType;
-- 7
select * from instructor order by name;
-- 8
select * from instructorinfo where address='123 Main St, City'; 
-- 9
select * from instructor where TechnologyName='FSD';
-- 10
select instructor.instructorCode, 
instructor.name
from instructor
inner join instructorInfo on instructor.instructorCode = instructorInfo.instructorCode
where instructorInfo.secondLanguage = 'Spanish';
-- 11
select count(*) as Count from instructorInfo where secondLanguage = "Spanish";
-- 12
update instructor
SET salary = salary + 500
where instructorCode in (select instructorCode from instructorInfo 
where firstLanguage = 'Spanish');
-- 13
select i.instructorCode, i.jobStartyear, ii.email, ii.phone_number
from instructor as i
inner join instructorInfo as ii on i.instructorCode = ii.instructorCode
where ii.firstLanguage = 'Spanish';
-- 14 
alter table instructorInfo drop column secondLanguage;
