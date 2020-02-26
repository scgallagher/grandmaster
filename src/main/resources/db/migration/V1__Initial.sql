CREATE TABLE game_state (
	id SERIAL NOT NULL PRIMARY KEY,
	created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE piece_state (
	id SERIAL NOT NULL PRIMARY KEY,
	game_state_id INTEGER NOT NULL,
	color VARCHAR NOT NULL,
	piece_type VARCHAR NOT NULL,
	name VARCHAR,
	short_name VARCHAR NOT NULL,
	location_row INTEGER NOT NULL,
	location_column INTEGER NOT NULL,
	FOREIGN KEY (game_state_id) REFERENCES game_state(id) ON DELETE CASCADE
);
