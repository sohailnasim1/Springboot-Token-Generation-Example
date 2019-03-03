insert into roles select * from (
select 1, 'admin' union
select 2, 'participant'
) x where not exists(select * from roles);

insert into users 
(username, password, firstName, lastName, emailAddress, active)
select
'jdoe', 'password', 'John', 'Doe', 'jdoe@youremaildomain.com', 'Y'
where 'jdoe' not in (
select username
from users 
);

insert into user_role (username, role_id)
select 'jdoe', 1
where not exists(select  1 from user_role where username='jdoe' and role_id=1);