CREATE TABLE music_temperatures(
    id serial primary key,
    name varchar(255) not null
);

ALTER TABLE musics
    ADD COLUMN music_temperature_id integer;

ALTER TABLE musics
    ADD CONSTRAINT fk_musics_on_music_temperature FOREIGN KEY (music_temperature_id) REFERENCES music_temperatures (id);
