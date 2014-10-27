package com.springapp.mvc.repository.impl;

import com.springapp.mvc.games.model.Game;
import com.springapp.mvc.repository.interfaces.IGamesRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MCB on 10/19/2014.
 */
@Repository("gamesRepository")
public class GamesRepository implements IGamesRepository {

    @Override
    public List<Game> getGames() {
        List<Game> games = new ArrayList<Game>();
        for (int i = 1; i < 11; i++) {
            boolean owned = i % 2 == 1;
            //games.add(new Game(i, "title " + i, owned, new Date()));
        }
        return games;
    }
}
