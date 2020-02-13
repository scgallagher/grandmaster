package com.scg.grandmaster.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.scg.grandmaster.entity.GameState;

public interface GameStateRepository extends CrudRepository<GameState, Long> {
	Optional<GameState> findById(Long id);
}
