ALTER TABLE game_state ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT NOW();

-- Change state column to json
--ALTER TABLE game_state DROP COLUMN state;
--ALTER TABLE game_state ADD COLUMN state JSONB NOT NULL;
