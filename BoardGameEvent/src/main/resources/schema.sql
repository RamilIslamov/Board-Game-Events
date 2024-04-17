create table if not exists Game
(
    id serial primary key,
    game_name varchar(50) not null,
    max_players integer not null,
    round_duration_min integer not null,
    equipment varchar(50),
    rules varchar(255) not null
);

create table if not exists Event
(
    id serial primary key,
    event_name varchar(50) not null,
    description varchar(255) not null,
    location varchar(255) not null,
    event_date timestamp not null,
    players integer not null,
    game_id integer not null references Game(id)
);

create table if not exists Team
(
    id serial primary key,
    team_name varchar(30) not null,
    leader varchar(30) not null,
    members_amount integer not null,
    events_visited integer,
    games_played integer,
    games_won integer
);

create table if not exists Place
(
    id serial primary key,
    place_name varchar(30) not null,
    rating decimal(2,1),
    hosted integer,
    event_id integer not null references Event(id),
    description varchar(255) not null
);
