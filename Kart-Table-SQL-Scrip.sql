CREATE SCHEMA `kart_table` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci;

drop table if exists events;
drop table if exists laps;
drop table if exists players;
drop table if exists tracks;

create table events (event_id bigint not null auto_increment, date date, time time, id_track bigint, primary key (event_id)) engine=InnoDB;
create table laps (lap_id bigint not null auto_increment, duration bigint, id_event bigint, id_player bigint, id_track bigint, primary key (lap_id)) engine=InnoDB;
create table players (player_id bigint not null auto_increment, alias varchar(3) not null, first_name varchar(255) not null, last_name varchar(255), id_event bigint, primary key (player_id)) engine=InnoDB;
create table tracks (track_id bigint not null auto_increment, location varchar(255), name varchar(255) not null, primary key (track_id)) engine=InnoDB;

alter table tracks add constraint UK_2q4x1t51xpqqquojnnti17s68 unique (name);
alter table events add constraint FKpxbx1qjd5sr44emyncxfb769n foreign key (id_track) references tracks (track_id);
alter table laps add constraint FKm64vce700y8qehbnsgmvl1wsk foreign key (id_event) references events (event_id);
alter table laps add constraint FKdb5h80y0y4ewr3f570aoay0wt foreign key (id_player) references players (player_id);
alter table laps add constraint FKnlkbuer7cnbu6h6oihngga5o3 foreign key (id_track) references tracks (track_id);
alter table players add constraint FK98k22q2y2wjx15qmxhul1229b foreign key (id_event) references events (event_id);

INSERT INTO `kart_table`.`tracks` (`track_id`, `location`, `name`) VALUES ('1', 'WAW-BEM', 'Pole-Position1');
INSERT INTO `kart_table`.`tracks` (`track_id`, `location`, `name`) VALUES ('2', 'WAW-JAN', 'Pole-Position2');
INSERT INTO `kart_table`.`tracks` (`track_id`, `location`, `name`) VALUES ('3', 'WAW-PRA', 'A1');

INSERT INTO `kart_table`.`events` (`event_id`, `date`, `time`, `id_track`) VALUES ('1', '2017-06-15', '19:30:10', '1');
INSERT INTO `kart_table`.`events` (`event_id`, `date`, `time`, `id_track`) VALUES ('2', '2018-07-10', '15:07:55', '1');
INSERT INTO `kart_table`.`events` (`event_id`, `date`, `time`, `id_track`) VALUES ('3', '2020-02-03', '17:20:34', '2');

INSERT INTO `kart_table`.`players` (`player_id`, `alias`, `first_name`, `last_name`, `id_event`) VALUES ('1', 'KRA', 'Kamil', 'Raven', '1');
INSERT INTO `kart_table`.`players` (`player_id`, `alias`, `first_name`, `last_name`, `id_event`) VALUES ('2', 'OHA', 'Olgierd', 'Halski', '1');
INSERT INTO `kart_table`.`players` (`player_id`, `alias`, `first_name`, `last_name`, `id_event`) VALUES ('3', 'ESU', 'Ernest', 'Sumar', '1');
INSERT INTO `kart_table`.`players` (`player_id`, `alias`, `first_name`, `last_name`, `id_event`) VALUES ('4', 'JTU', 'Jan', 'Tuwara', '1');

INSERT INTO `kart_table`.`laps` (`lap_id`, `duration`, `id_event`, `id_player`, `id_track`) VALUES ('1', '123', '1', '1', '1');
INSERT INTO `kart_table`.`laps` (`lap_id`, `duration`, `id_event`, `id_player`, `id_track`) VALUES ('2', '222', '1', '1', '1');
INSERT INTO `kart_table`.`laps` (`lap_id`, `duration`, `id_event`, `id_player`, `id_track`) VALUES ('3', '333', '1', '2', '1');
INSERT INTO `kart_table`.`laps` (`lap_id`, `duration`, `id_event`, `id_player`, `id_track`) VALUES ('4', '345', '1', '2', '1');
INSERT INTO `kart_table`.`laps` (`lap_id`, `duration`, `id_event`, `id_player`, `id_track`) VALUES ('5', '346', '1', '3', '1');
INSERT INTO `kart_table`.`laps` (`lap_id`, `duration`, `id_event`, `id_player`, `id_track`) VALUES ('6', '654', '1', '3', '1');



