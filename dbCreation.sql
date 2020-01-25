create table crime (
category varchar(50),
location_type varchar(50),
location_id bigint references  location(id) on delete set null,
context varchar(50),
outcome_status varchar(50),
persistent_id varchar(50),
id bigserial primary key ,
location_subtype varchar(50),
month char

);

create table location (
    id bigserial primary key ,
latitude float,
longitude float,
street_id bigint references  street(id) on delete set null
);

create table street (
id bigserial primary key ,
name varchar(50)
);