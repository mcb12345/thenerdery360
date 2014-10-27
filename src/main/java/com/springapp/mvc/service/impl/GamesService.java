package com.springapp.mvc.service.impl;

import com.springapp.mvc.games.dao.IGamesDao;
import com.springapp.mvc.games.model.Game;
import com.springapp.mvc.service.interfaces.IGamesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by MCB on 10/19/2014.
 */
@Service
public class GamesService implements IGamesService {

    private IGamesDao gamesDao;

    public void setGamesDao(IGamesDao gamesDao) {
        this.gamesDao = gamesDao;
    }

    /**
     * @desc gets games
     * @return games
     */
    @Override
    @Transactional
    public List<Game> getGames() {
        return gamesDao.getGames();
    }

    /**
     * @desc adds game
     * @param title
     * @return boolean
     */
    @Override
    @Transactional
    public boolean addGame(String title) {
        if (canVoteOrAddGame()) {
            List<Game> games = getGames();
            for (Game game : games) {
                if (title.toLowerCase().equals(game.getTitle().toLowerCase())) {
                    return false;
                }
            }

            Game game = new Game(title, getNowTimeStamp());
            return gamesDao.addGame(game);
        }
        return false;
    }

    /**
     * @desc gets a game by id
     * @param gameId
     * @return game
     */
    @Override
    @Transactional
    public Game getGame(int gameId) {
        return gamesDao.getGame(gameId);
    }

    /**
     * @desc adds a vote if possible
     * @param gameId
     * @return
     */
    @Override
    @Transactional
    public boolean addVote(int gameId) {
        if (canVoteOrAddGame()) {
            Game game = gamesDao.getGame(gameId);
            if (game != null) {
                return gamesDao.addVote(getNowTimeStamp(), game);
            }
        }
        return false;
    }

    /**
     * @desc marks a game as owned
     * @param gameId
     * @return if markAsOwned was successful
     */
    @Override
    @Transactional
    public boolean markAsOwned(int gameId) {
        Game game = getGame(gameId);
        if (game != null) {
            game.setOwned(true);
            return gamesDao.updateGame(game);
        }
        return false;
    }

    /**
     * @desc gets a timestamp for now
     * @return timestamp.
     */
    private Timestamp getNowTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        return new Timestamp(now.getTime());
    }

    /**
     * @desc checks the current day of the week
     * @return boolean
     */
    private boolean canVoteOrAddGame() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
            return false;
        }
        return true;
    }

    /**
     * @desc gets seconds until midnight tonight
     * @return long.
     */
    @Override
    public long getMidnight() {
        Calendar calEnd = new GregorianCalendar();
        Date now = new Date();
        calEnd.setTime(now);
        calEnd.set(Calendar.DAY_OF_YEAR, calEnd.get(Calendar.DAY_OF_YEAR) + 1);
        calEnd.set(Calendar.HOUR_OF_DAY, 0);
        calEnd.set(Calendar.MINUTE, 0);
        calEnd.set(Calendar.SECOND, 0);
        calEnd.set(Calendar.MILLISECOND, 0);
        Date midnightTonight = calEnd.getTime();
        long seconds = (midnightTonight.getTime() - now.getTime()) / 1000;

        return seconds;
    }
}
