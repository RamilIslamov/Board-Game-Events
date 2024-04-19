TRUNCATE  TABLE games CASCADE;
INSERT INTO games (game_name, max_players, round_duration_min, equipment, rules)
VALUES ('Chess', 2, 10, 'Chess board and pieces', 'Standard chess rules apply. Players take turns moving their pieces with the objective of capturing the opponent''s king while protecting their own'),
       ('Catan', 4, 40, 'Game board', 'Before you do anything else on your turn, you must roll the two dice. The result applies to everyone and usually means you get to take a resource from the resource stacks depending on the number you’ve rolled and where your settlements are based.'),
       ('Terraforming Mars', 5, 70, 'Game board', 'Each round of the game represents one generation of development and colonization on Mars. At the start of each round, the first player token moves to the next player.'),
       ('Pixies', 5, 10, 'Game board', 'On your turn, take a card from the display and place it in your area, whoever chose last chooses first next. To place a card there are a number of conditions.'),
       ('Monopoly', 5, 120, 'Game board', 'At the start of the game, each player is given a fixed amount of play money; the players then move around the board according to the throw of a pair of dice. Any player who lands on an unowned property may buy it.'),
       ('Wingspan', 5, 30, 'Game board', 'You are bird enthusiasts—researchers, bird watchers, ornithologists, and collectors—seeking to discover and attract the best birds to your network of wildlife preserves. Each bird extends a chain of powerful combinations in one of your habitats (actions).');
TRUNCATE  TABLE events CASCADE;
INSERT INTO events (event_name, description, location, event_date, players, rating, game_id)
VALUES ('Chess championship', 'Standard chess rules, 10min per game, 4 boards', 'Aloha bar', '2024-05-10 12:00:00', 20, 4.57, 1),
       ('Catan championship', 'Standard Catan rules, 30min per game, 4 boards', 'Evening caffe', '2024-08-13 10:00:00', 10, 4.28, 2),
       ('Terraforming Mars event', 'Standard Terraforming Mars rules, 40min per game, 1 board', 'Meow anticaffe', '2024-06-10 10:00:00', 5, 4.9, 3),
       ('Pixies event', 'Standard Pixies rules, 5min per game, 2 boards', 'Verdana place', '2024-05-18 18:00:00', 6, 3.18, 4),
       ('Monopoly event', 'Standard Monopoly rules, 30min per game, 1 board', 'Trade bar', '2024-05-19 19:00:00', 20, 4.01, 5),
       ('Chess championship', 'Standard chess rules, 10min per game, 4 boards', 'Greenwich bar', '2024-05-9 16:00:00', 10, 4.7, 6);