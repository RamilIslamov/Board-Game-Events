create table if not exists games
(
    id                 serial primary key,
    game_name          varchar(50)  not null,
    max_players        integer      not null,
    round_duration_min integer      not null,
    equipment          varchar(50),
    rules              varchar(255) not null,
    genre              varchar(50),
    creation_date      timestamp
);

create table if not exists events
(
    event_id     serial primary key,
    event_name   varchar(50)  not null,
    description  varchar(255) not null,
    location     varchar(255) not null,
    event_date   timestamp    not null,
    players      integer      not null,
    curr_players integer,
    rating       numeric(3, 2),
    game_id      integer      not null references games (id),
    users_voted  integer
);

create table if not exists teams
(
    id             serial primary key,
    team_name      varchar(30) not null,
    leader         varchar(30) not null,
    members_amount integer     not null,
    events_visited integer,
    games_played   integer,
    games_won      integer,
    password       varchar(255)
);

create table if not exists places
(
    id          serial primary key,
    place_name  varchar(30)  not null,
    rating      decimal(2, 1),
    hosted      integer,
    event_id    integer      not null references events (event_id),
    description varchar(255) not null
);

create table if not exists users
(
    user_id  serial primary key,
    email    varchar(255) not null,
    password varchar(255) not null,
    username varchar(255)
);

create table if not exists users_events
(
    user_id  integer not null,
    event_id integer not null,
    primary key (user_id, event_id),
    foreign key (user_id) references users (user_id),
    foreign key (event_id) references events (event_id)
);

CREATE TABLE ratings
(
    id       serial primary key,
    user_id  integer not null,
    event_id integer not null,
    rating   float   not null,
    constraint fk_user foreign key (user_id) references users (user_id),
    constraint fk_event foreign key (event_id) references events (event_id)
);

