ALTER TABLE game_state_det ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT NOW();

-- Change state column to json
ALTER TABLE game_state_det DROP COLUMN state;
ALTER TABLE game_state_det ADD COLUMN state JSONB NOT NULL;
