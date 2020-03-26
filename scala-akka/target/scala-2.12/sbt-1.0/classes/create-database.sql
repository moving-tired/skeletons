CREATE TABLE accounts(
    balance NUMERIC(100, 4) not null default 0,
    user_id,
    created_at timestamp not null default NOW(),
    updated_at timestamp not null default NOW()
)

CREATE TABLE transactions(
    account_id,
    amount NUMERIC(100, 4) not null default 0,
    created_at timestamp not null default NOW()
)