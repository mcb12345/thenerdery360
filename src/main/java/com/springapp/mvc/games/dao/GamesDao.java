package com.springapp.mvc.games.dao;

import com.springapp.mvc.games.model.Game;
import com.springapp.mvc.games.model.Vote;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbungert on 10/20/2014.
 */
@Repository
public class GamesDao implements IGamesDao {

    private static final Logger logger = LoggerFactory.getLogger(GamesDao.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return games
     * @desc gets games from DB
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Game> getGames() {
        List<Game> gameList = new ArrayList<Game>();
        try {
            Session session = this.sessionFactory.getCurrentSession();
            gameList = session.createQuery("from Game").list();
            for (Game game : gameList) {
                logger.info("Games List::" + game);
            }
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
        return gameList;
    }

    /**
     * @param game
     * @return boolean
     * @desc updates a game in the DB
     */
    @Override
    public boolean updateGame(Game game) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.update(game);
            logger.info("Game updated successfully, Game Details=" + game);

            return true;
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * @param game
     * @return boolean
     * @desc adds a game to the DB
     */
    @Override
    public boolean addGame(Game game) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(game);
            logger.info("Game saved successfully, Game Details=" + game);

            return true;
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * @param gameId
     * @return game
     * @desc gets a game by id from DB
     */
    @Override
    public Game getGame(int gameId) {
        Game game = null;

        try {
            Session session = this.sessionFactory.getCurrentSession();
            game = (Game) session.load(Game.class, new Integer(gameId));
            logger.info("Game loaded successfully, Game details=" + game);

        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }

        return game;
    }

    /**
     * @param created
     * @param game
     * @return boolean
     * @desc adds a vote to a game
     */
    @Override
    public boolean addVote(Timestamp created, Game game) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(new Vote(created, game));
            return true;
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}
