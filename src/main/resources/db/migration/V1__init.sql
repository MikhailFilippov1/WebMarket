create table categories (id bigserial primary key, title varchar(255));
insert into categories (title)
values
('FOOD');

create table products (id bigserial primary key, title varchar(255), price int, category_id bigint references categories(id));
insert into products (table, price, category_id)
values
('Milk', 30, 1),
('Bread', 32, 1);

