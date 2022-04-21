package com.lizgunther.videouniverse.movies;

import com.lizgunther.videouniverse.security.User;
import com.lizgunther.videouniverse.security.UserService;
import com.lizgunther.videouniverse.wishlists.FormObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final UserService userService;
    private final RequestService requestService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public MovieController(MovieService movieService, UserService userService, RequestService requestService) {
        this.movieService = movieService;
        this.userService = userService;
        this.requestService = requestService;
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
        logger.info("---INFO LOG TEST---");
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

    @GetMapping("/request")
    public String showRequests(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("requests",requestService.getRequestsByUserId(currentUser.getId()));
        return "request"; }

    @GetMapping("/add_request")
    public String addRequest(Model model) {
        Request request = new Request();
        model.addAttribute("request", request);
        return "add_request";
    }
    @PostMapping("/add_request")
    public String saveNewRequest(@ModelAttribute("request") Request request, Principal principal) {
        User currentUser = userService.findByEmail(principal.getName());
        //try-catch here
        requestService.saveRequest(request);
        currentUser.getRequests().add(request);
        userService.saveUser(currentUser);
        return "redirect:/request";
    }

}

