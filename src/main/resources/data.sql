insert into user_details(id, birthdate, name)
values(10001, current_date(), 'Luka');

insert into user_details(id, birthdate, name)
values(10002, current_date(), 'Tommy');

insert into user_details(id, birthdate, name)
values(10003, current_date(), 'Charlie');

insert into post(id, description, user_id)
values(20001, 'I love frontend', 10001);

insert into post(id, description, user_id)
values(20002, 'I love backend', 10002);

insert into post(id, description, user_id)
values(20003, 'I love both', 10003);