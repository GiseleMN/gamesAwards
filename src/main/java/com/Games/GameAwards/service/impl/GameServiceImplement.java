package com.Games.GameAwards.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Games.GameAwards.domain.models.Game;
import com.Games.GameAwards.domain.models.GameRepository;
import com.Games.GameAwards.service.GameService;
import com.Games.GameAwards.service.exception.NoContentException;
import com.Games.GameAwards.service.exception.BusinessException;

public class GameServiceImplement implements GameService {

	@Autowired
	private GameRepository repository;
	
	
	@Override
	public List<Game> findAll() {
		List<Game> games = repository.findAll();
		return games; 
	}
	

	@Override
	public Game findById(Long id) {
		Optional<Game> games = repository.findById(id);
		return games.orElseThrow(() -> new NoContentException());
	}

	@Override
	public void insert(Game game) {
		if(Objects.nonNull(game.getId())) {
			throw new BusinessException("O ID e diferente de NULL na inclusao ");
		}
		repository.save(game);
	}

	@Override
	public void update(Long id, Game game) {
		Game gameDb =findById(id);
		if(gameDb.getId().equals(game.getId())) {
			repository.save(game);
		}else {
			throw new BusinessException("Os IDs para alteracao sao divergentes. ");
		}
	}

	@Override
	public void delete(Long id) {
		Game gameDb =findById(id);
		repository.delete(gameDb);
	}

}
