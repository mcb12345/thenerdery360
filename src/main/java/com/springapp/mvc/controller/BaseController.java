package com.springapp.mvc.controller;

import com.springapp.mvc.games.model.Game;
import com.springapp.mvc.service.interfaces.IGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MCB on 10/19/2014.
 */
public class BaseController {

    protected IGamesService gamesService;

    @Autowired(required = true)
    @Qualifier(value = "gamesService")
    public void setGamesService(IGamesService gamesService) {
        this.gamesService = gamesService;
    }

    protected List<Game> wantIt;
    protected List<Game> gotIt;

    /**
     * @desc creates two lists for games
     * @param games
     */
    protected void getGamesAndCreateLists(List<Game> games) {
        wantIt = new ArrayList<Game>();
        gotIt = new ArrayList<Game>();

        for (Game game : games) {
            if (game.isOwned()) {
                gotIt.add(game);
            } else {
                wantIt.add(game);
            }
        }
    }
}
