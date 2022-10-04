create table streets
(
    id           serial,
    name         varchar(255) not null,
    cordinates   varchar(255) not null,
    lastmodified timestamp(6) not null
);