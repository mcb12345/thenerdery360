package com.springapp.mvc.games.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MCB on 10/19/2014.
 */
@Entity
@Table(name = "game")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "owned")
    private boolean owned;

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

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Vote> votes; //= new HashSet<Vote>(0);
//
//    @OneToMany
//    @JoinColumn(name = "gameId")
//    private List<Vote> votes;

    public Game() {
    }

    public Game(String title, Timestamp created) {
        this.title = title;
        this.created = created;
    }

    public Game(String title, boolean owned, Timestamp created) {
        this.title = title;
        this.owned = owned;
        this.created = created;
    }

    public Game(String title, Timestamp created, Set<Vote> votes) {
        this.title = title;
        this.created = created;
        //this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }
}
