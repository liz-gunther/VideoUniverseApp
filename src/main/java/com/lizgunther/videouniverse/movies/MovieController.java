package com.lizgunther.videouniverse.movies;

import com.lizgunther.videouniverse.security.User;
import com.lizgunther.videouniverse.security.UserService;
import com.lizgunther.videouniverse.wishlists.FormObject;
import com.lizgunther.videouniverse.wishlists.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class MovieController {

    private MovieService movieService;
    private UserService userService;
    private WishlistService wishlistService;


    @Autowired
    public MovieController(MovieService movieService, UserService userService, WishlistService wishlistService) {
        this.movieService = movieService;
        this.userService = userService;
        this.wishlistService = wishlistService;
    }

    @GetMapping("/explore")
    public String showExplorePage() {

        return "explore";
    }
    //populate the movie template page with a random movie selected from the database by genre
    @GetMapping("/category/{genre}")
    public String explorePageHorror(@PathVariable(value = "genre") String genre, Principal principal, Model model) {
        Movie movie = movieService.getMovieByGenre(genre);
        User currentUser = userService.findByEmail(principal.getName());
        FormObject formObject = new FormObject();
        model.addAttribute("formObject", formObject);
        model.addAttribute("wishlists", currentUser.getWishlists());
        model.addAttribute("movie", movie);
        return "movie_template";
    }
    //use the same concept from the previous method, but instead of filtering by genre it pulls ANY random movie from the database
    @GetMapping("/random")
    public String explorePageRandom(Principal principal, Model model) {
        Movie movie = movieService.getRandomMovie();
        User currentUser = userService.findByEmail(principal.getName());
        FormObject formObject = new FormObject();
        model.addAttribute("formObject", formObject);
        model.addAttribute("wishlists", currentUser.getWishlists());
        model.addAttribute("movie", movie);
        return "movie_template";
    }
    //the next three mappings are for the movies displayed on the home page
    //TODO: refactor so that the movieid is automatically passed in

    @GetMapping("/thebatman")
    public String explorePageBatman(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", currentUser.getWishlists());
        Movie movie = movieService.getMovieById(309);
        model.addAttribute("movie", movie);
        FormObject formObject = new FormObject();
        model.addAttribute("formObject", formObject);
        return "movie_template";
    }

    @GetMapping("/minari")
    public String explorePageMinari(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", currentUser.getWishlists());
        Movie movie = movieService.getMovieById(102);
        model.addAttribute("movie", movie);
        FormObject formObject = new FormObject();
        model.addAttribute("formObject", formObject);
        return "movie_template";
    }

    @GetMapping("/encanto")
    public String explorePageEncanto(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", currentUser.getWishlists());
        Movie movie = movieService.getMovieById(308);
        model.addAttribute("movie", movie);
        FormObject formObject = new FormObject();
        model.addAttribute("formObject", formObject);
        return "movie_template";
    }

}

