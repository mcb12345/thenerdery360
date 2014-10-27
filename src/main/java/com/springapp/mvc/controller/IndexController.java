package com.springapp.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by MCB on 10/19/2014.
 */
@Controller
public class IndexController extends BaseController {

    private final static String error = "error";
    private final static String gameError = "Error adding game. Please try again.";
    private final static String gameCookieError = "Please wait until midnight to add another game.";
    private final static String voteError = "Error adding vote. Please try again.";
    private final static String voteCookieError = "Please wait until midnight to vote again.";
    private final static String cookieName = "nerderyXbox360";
    private final static String cookieValue = "";

    @Autowired
    private HttpServletRequest request;

    /**
     * @param model
     * @return index page
     * @desc displays index page with xbox games
     */
    @RequestMapping("/")
    public String index(Model model) {

        super.getGamesAndCreateLists(gamesService.getGames());

        model.addAttribute("gotIt", gotIt);
        model.addAttribute("wantIt", wantIt);

        return "index";
    }

    /**
     * @param gameId
     * @param response
     * @param redirectAttributes
     * @return redirect to home page.
     * @desc adds a vote to game
     */
    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public String addVote(int gameId,
                          HttpServletResponse response,
                          RedirectAttributes redirectAttributes) {
        if (hasCookie()) {
            redirectAttributes.addFlashAttribute(error, voteCookieError);
            return "redirect:/";
        }

        if (!gamesService.addVote(gameId)) {
            redirectAttributes.addFlashAttribute(error, voteError);
        } else {
            response.addCookie(createCookie());
        }
        return "redirect:/";
    }

    /**
     * @param title
     * @param response
     * @param redirectAttributes
     * @return redirect to home page
     * @desc adds a new game.
     */
    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    public String addGame(String title, HttpServletResponse response,
                          RedirectAttributes redirectAttributes) {
        if (hasCookie()) {
            redirectAttributes.addFlashAttribute(error, gameCookieError);
            return "redirect:/";
        }

        if (!gamesService.addGame(title)) {
            redirectAttributes.addFlashAttribute(error, gameError);
        } else {
            response.addCookie(createCookie());
        }
        return "redirect:/";
    }

    /**
     * @return cookie
     * @desc creates cookie
     */
    private Cookie createCookie() {
        long seconds = gamesService.getMidnight();
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge((int) (long) seconds);
        return cookie;
    }

    /**
     * @return boolean
     * @desc checks is user has cookie
     */
    private boolean hasCookie() {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(cookieName)) {
                return true;
            }
        }
        return false;
    }
}
