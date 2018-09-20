CREATE TABLE account(
  id int PRIMARY KEY,
  name text NOT NULL,
  created_on TIMESTAMP,
  balance REAL
);

select * from account;

insert into account (id, name, created_on, balance) values (0, 'Chase', '2017-02-05', 2345.67);
insert into account (id, name, created_on, balance) values (1, 'PNC Bank', '2018-04-07', 78900.25);
insert into account (id, name, created_on, balance) values (2, 'Barclays', '2017-12-28', 104.05);

