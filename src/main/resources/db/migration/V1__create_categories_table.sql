CREATE TABLE moments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    value INTEGER NOT NULL
);

CREATE TABLE moments_categories (
    moment_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    PRIMARY KEY (moment_id, category_id),
    FOREIGN KEY (moment_id) REFERENCES moments(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);

CREATE TABLE bands (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE musics(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    band_id INTEGER NOT NULL,
    FOREIGN KEY (band_id) REFERENCES bands(id) ON DELETE CASCADE
);

CREATE TABLE musics_moments(
    music_id INTEGER NOT NULL,
    moment_id INTEGER NOT NULL,
    PRIMARY KEY (music_id, moment_id),
    FOREIGN KEY (music_id) REFERENCES musics(id) ON DELETE CASCADE,
    FOREIGN KEY (moment_id) REFERENCES moments(id) ON DELETE CASCADE
)
