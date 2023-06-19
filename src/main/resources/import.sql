-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into A (id, field) values(1, 'field-1');
insert into A (id, field) values(2, 'field-2');
insert into A (id, field) values(3, 'field-3');
alter sequence a_seq restart with 4;