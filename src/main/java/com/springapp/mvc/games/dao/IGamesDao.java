package com.springapp.mvc.games.dao;

import com.springapp.mvc.games.model.Game;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by mbungert on 10/20/2014.
 */
public interface IGamesDao {
    List<Game> getGames();
    boolean updateGame(Game game);
    boolean addGame(Game game);
    Game getGame(int gameId);
    boolean addVote(Timestamp created, Game game);
}
