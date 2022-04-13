-- correct significant digits
select cast(4 as decimal(4,2));

-- checking MD5 conversion
SELECT MD5('KhenanTerry1234');		--( 5f5d6dae65367c5c65b5d980d3960fb7 )
SELECT MD5('KhenanTerry12345');		--( 96f8fb604a8fb722672a189562f9af3a )
SELECT MD5('KhenanTerry12346');		--( 9e074031009462a4395e3182110b9fa6 )
SELECT MD5('BrandonTerry1234');		--( a64f9453a4a0b6482db3c5a83848a1fb )
select MD5('BraydenTaylor123456');	--( 4293f18782cb162235cf14f648429bff )

-- drop tables
drop table account_registry; 
drop table savings_account;
drop table checking_account; 
drop table ledger;

-- sample Accounts
insert into account_registry values('hello1','hello1','DBeaver01','Example01','12345',true,true,true);
insert into account_registry values('hello2','hello2','DBeaver02','Example02','2468',true,false,true);
insert into account_registry values('hello3','hello3','DBeaver03','Example03','555555',false,true,true);
insert into account_registry values('hello4','hello1','Unknown','Example','5432',true,true,false);
select * from account_registry;

delete from account_registry *;
update account_registry set first_name = 'DBeaver04', last_name= 'Example04' where main_id='hello4';
---- sample savings
insert into savings_account values('hello1',5);
select * from savings_account;

delete from savings_account *;
---- sample checking
insert into checking_account values('hello1',15);
select * from checking_account;

delete from checking_account *;
---- sample ledger entry
insert into ledger values(default,'2022/04/11','Savings','hello1',default,default,default);
select * from ledger;
insert into ledger values(default,'2022/04/12','Checking','hello1',default,20,20);

delete from ledger *;
-- Get values
select * from account_registry where main_id = 'hello2';
select * from account_registry where shared_id = 'hello1';
select main_id from account_registry where (first_name='DBeaver01');

-- JOIN examples
---- INNER JOIN
select * from account_registry inner join savings_account on account_registry.shared_id = savings_account.shared_id;
select * from account_registry inner join checking_account on account_registry.shared_id = checking_account.shared_id;

select * from account_registry inner join ledger on account_registry.shared_id = ledger.shared_id;
---- LEFT JOIN
select * from account_registry left join savings_account on account_registry.shared_id = savings_account.shared_id;
select * from account_registry left join checking_account on account_registry.shared_id = checking_account.shared_id;

select * from account_registry left join ledger on account_registry.shared_id = ledger.shared_id;
