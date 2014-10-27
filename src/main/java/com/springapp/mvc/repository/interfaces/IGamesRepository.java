package com.springapp.mvc.repository.interfaces;

import com.springapp.mvc.games.model.Game;

import java.util.List;

/**
 * Created by MCB on 10/19/2014.
 */
public interface IGamesRepository {
    List<Game> getGames();
}
