create table if not exists games
(
    id serial primary key,
    game_name varchar(50) not null,
    max_players integer not null,
    round_duration_min integer not null,
    equipment varchar(50),
    rules varchar(255) not null
);

create table if not exists events
(
    id serial primary key,
    event_name varchar(50) not null,
    description varchar(255) not null,
    location varchar(255) not null,
    event_date timestamp not null,
    players integer not null,
    rating numeric(3,2),
    game_id integer not null references games(id)
);

create table if not exists teams
(
    id serial primary key,
    team_name varchar(30) not null,
    leader varchar(30) not null,
    members_amount integer not null,
    events_visited integer,
    games_played integer,
    games_won integer
);

create table if not exists places
(
    id serial primary key,
    place_name varchar(30) not null,
    rating decimal(2,1),
    hosted integer,
    event_id integer not null references events(id),
    description varchar(255) not null
);
