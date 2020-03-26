CREATE TABLE translated_messages(
    key varchar(255) PRIMARY KEY,
    translated text not null default '',
    `space` varchar(255) not null default 'default',
    locale varchar(4) not null default 'en',
    created_at timestamp not null default NOW(),
    updated_at timestamp not null default NOW()
)
