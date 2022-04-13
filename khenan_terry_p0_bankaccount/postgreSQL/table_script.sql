-- T01:
-- This should be a table for registering new accounts
-- This table also lists some properties about the accounts
create table account_registry(
    main_id varchar(32) unique primary key,
    shared_id varchar(32),
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    account_pin varchar(6) not null check(char_length(account_pin)>=4),
    share_state bool not null default(false),
    savings_state bool not null default(false),
    checking_state bool not null default(false)
);

-- T02:
-- This table is for savings accounts
-- Savings accounts are added to this table, if the user indicates so.
create table savings_account(
    shared_id varchar(32) primary key,
    savings_balance money not null default(0),
    foreign key(shared_id) references account_registry(main_id)
);

-- T03:
-- This table is for checking accounts
-- Checking accounts are added to this table, if the user indicates so.
create table checking_account(
    shared_id varchar(32) primary key,
    checking_balance money not null default(0),
    foreign key(shared_id) references account_registry(main_id)
);

-- T04:
-- This table records all transactions for the accounts
create table ledger(
    transaction_id serial primary key,
    transaction_date varchar(10),
    transaction_account varchar(20) not null,
    shared_id varchar(32) not null,
    balance_before money not null default(0),
    balance_after money not null default(0),
    balance_difference money not null default(0),
    foreign key(shared_id) references account_registry(main_id)
);


