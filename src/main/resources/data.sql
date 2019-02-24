insert into roles select * from (
select 1, 'admin' union
select 2, 'participant'
) x where not exists(select * from roles);

insert into users select * from (
select 'jdoe', 'password', 'John', 'Doe', 'jdoe@youremaildomain.com', 'Y'
) x where not exists(select *  from users);

insert into user_role select * from (
select 'jdoe', 1
) x where not exists(select *  from user_role);