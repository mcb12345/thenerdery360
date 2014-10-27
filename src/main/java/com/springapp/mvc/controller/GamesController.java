package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by mbungert on 10/23/2014.
 */
@Controller
public class GamesController extends BaseController {

    private final static String error = "error";
    private final static String markAsOwnedError = "Error updating game. Please try again.";

    /**
     * @param model
     * @return
     * @desc displays lists of games
     */
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public String games(Model model) {

        super.getGamesAndCreateLists(gamesService.getGames());

        model.addAttribute("gotIt", gotIt);
        model.addAttribute("wantIt", wantIt);

        return "games";
    }

    /**
     * @param gameId
     * @param redirectAttributes
     * @return
     * @desc marks game as owned
     */
    @RequestMapping(value = "/games/owned", method = RequestMethod.POST)
    public String markAsOwned(int gameId, RedirectAttributes redirectAttributes) {
        if (!gamesService.markAsOwned(gameId)) {
            redirectAttributes.addFlashAttribute(error, markAsOwnedError);
        }

        return "redirect:/games";
    }
}
