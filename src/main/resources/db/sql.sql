insert roles (name) values ('MANAGER'),('DEVELOPER');
insert users (email, enabled, gender, name, password, surname)
values
       ('man1', true, 'man', 'Bob',123,'Tomas'),
       ('man2', true, 'woman', 'Dasha',123,'Petrova'),
       ('dev1', true, 'man', 'Tom',123,'Tomasovich'),
       ('dev2', true, 'man', 'Denis',123,'Denisovich'),
       ('dev3', true, 'woman', 'Nastya',123,'Kirilchuk'),
       ('dev4', true, 'man', 'Tom',123,'Kirilchuk'),
       ('dev5', true, 'woman', 'Sonya',123,'Kastrova');

insert users_roles (user_id, role_id)
VALUES
       (1,1),
       (2,1),
        (3,2),
        (4,2),
        (5,2),
        (6,2),
        (7,2);


insert projects (description, name, user_id)
VALUES
       ('Test project car delivery','Car delivery',1),
       ('Test project clothes delivery','Clothes delivery',2);

insert projects_users (user_id, project_id) VALUES
(3,1),
(4,1),
(5,2),
(6,2),
(7,2);