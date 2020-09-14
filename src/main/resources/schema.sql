create table if not exists Results_Table (
id varchar(5) not null,
name varchar(25) not null,
score varchar(5) not null,
date timestamp not null
);
--нужно ли добавлять инофрмацию или она сама сохранится после предыдущего сеанса?