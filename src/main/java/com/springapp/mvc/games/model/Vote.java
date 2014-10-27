package com.springapp.mvc.games.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by MCB on 10/19/2014.
 */
@Entity
@Table(name = "vote")
public class Vote {

        @Id
    @GeneratedValue
    @Column(name = "vote_id")
    private int id;

//    @Column(name = "game_id")
//    private int gameId;

    @Column(name = "created")
    private Timestamp created;
/*
 <set name="items" table="ITEMS" fetch="select">
            <key>
                <column name="cart_id" not-null="true"></column>
            </key>
            <one-to-many class="Items"/>
        </set>
 */

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Vote() {
    }

    public Vote(Timestamp created) {
        this.created = created;
    }

    public Vote(Timestamp created, Game game) {
        this.created = created;
        this.game = game;
    }

//    public int getGameId() {
//        return gameId;
//    }
//
//    public void setGameId(int gameId) {
//        this.gameId = gameId;
//    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
