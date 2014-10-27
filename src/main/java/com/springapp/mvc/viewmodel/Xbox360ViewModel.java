package com.springapp.mvc.viewmodel;

import com.springapp.mvc.games.model.Game;

import java.util.List;

/**
 * Created by MCB-AIR on 10/21/2014.
 */
public class Xbox360ViewModel {
    private String errorMsg;
    private List<Game> wantIt;
    private List<Game> gotIt;

    public Xbox360ViewModel() {
    }

    public Xbox360ViewModel(List<Game> wantIt, List<Game> gotIt) {
        this.wantIt = wantIt;
        this.gotIt = gotIt;
    }

    public Xbox360ViewModel(List<Game> wantIt, List<Game> gotIt, String errorMsg) {
        this.wantIt = wantIt;
        this.gotIt = gotIt;
        this.errorMsg = errorMsg;
    }

    public List<Game> getWantIt() {
        return wantIt;
    }

    public void setWantIt(List<Game> wantIt) {
        this.wantIt = wantIt;
    }

    public List<Game> getGotIt() {
        return gotIt;
    }

    public void setGotIt(List<Game> gotIt) {
        this.gotIt = gotIt;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
