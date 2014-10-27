package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.games.model.Game;

import java.util.List;

/**
 * Created by MCB on 10/19/2014.
 */
public interface IGamesService {
    List<Game> getGames();
    boolean addGame(String title);
    Game getGame(int gameId);
    boolean addVote(int gameId);
    boolean markAsOwned(int gameId);
    public long getMidnight();
}
