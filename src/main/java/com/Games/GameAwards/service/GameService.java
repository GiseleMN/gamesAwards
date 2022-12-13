package com.Games.GameAwards.service;

import java.util.List;

import com.Games.GameAwards.domain.models.Game;

public interface GameService {
	
	List<Game>findAll();
	
Game findById(Long id);
	
	void insert(Game game);
	
	void update(Long id, Game game);
	
	void delete(Long id);

}
