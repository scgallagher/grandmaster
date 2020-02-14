package com.scg.grandmaster.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scg.grandmaster.entity.GameState;

@Repository
public interface GameStateRepository extends CrudRepository<GameState, Long> {
	Optional<GameState> findById(Long id);
}
