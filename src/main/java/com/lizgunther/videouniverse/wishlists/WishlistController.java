package com.lizgunther.videouniverse.wishlists;

import com.lizgunther.videouniverse.movies.Movie;
import com.lizgunther.videouniverse.movies.MovieService;
import com.lizgunther.videouniverse.security.User;
import com.lizgunther.videouniverse.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

@Controller
public class WishlistController {

    private WishlistService wishlistService;
    private MovieService movieService;
    private UserService userService;

    private final String URL = "/wishlists";

    @Autowired
    private WishlistController(WishlistService wishlistService, MovieService movieService, UserService userService) {
        this.wishlistService = wishlistService;
        this.movieService = movieService;
        this.userService = userService;
    }

    //This works
    @GetMapping(value = URL)
    public String showWishlists(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("wishlists", wishlistService.getWishlistsByUserId(currentUser.getId()));
        return "list_of_wishlists";
    }

    //This works
    @GetMapping("/add_wishlist")
    public String addWishlist(Model model) {
        Wishlist wishlist = new Wishlist();
        model.addAttribute("wishlist", wishlist);
        return "add_wishlist";
    }
    //This works
    @PostMapping("/add_wishlist")
    public String saveNewWishlist(@ModelAttribute("wishlist") Wishlist wishlist, Principal principal) {
        User currentUser = userService.findByEmail(principal.getName());
        //try-catch here
        wishlistService.saveWishlist(wishlist);
        currentUser.getWishlists().add(wishlist);
        userService.saveUser(currentUser);
        return "redirect:/wishlists";
    }

//    @GetMapping("/wishlist/{id}")
//    public String showFormForUpdateWishlist(@PathVariable(value = "id") long id, Model model) {
//        Wishlist wishlist = wishlistService.getWishlistById(id);
//        model.addAttribute("wishlist", wishlist);
//        return "wishlist";
//    }

    @GetMapping("/delete_wishlist/{id}")
    public String deleteWishlist(@PathVariable(value = "id") long id) {
        wishlistService.deleteWishlistById(id);
        return "redirect:/list_of_wishlists";
    }

    @PostMapping("/saveWishlist")
    public String saveWishlist(@ModelAttribute("wishlist") Wishlist wishlist, Model model, Principal principal) {
        User currentUser = userService.findByEmail(principal.getName());
        model.addAttribute("userId", currentUser.getId());
        wishlistService.saveToWishlist(wishlist);
        return "redirect:/list_of_wishlists";
    }

    @PostMapping("/add_movie_to_wishlist/{movieid}")
    public String addMovieTowishlist(@PathVariable(value = "movieid") long movieid, @ModelAttribute FormObject formObject) {
        System.out.println("Movie id =" + movieid + "Wishlist Id =" + formObject.getWishlistId());
        Movie movie = movieService.getMovieById(movieid);
        Wishlist wishlist = wishlistService.getWishlistById(formObject.getWishlistId());
        wishlist.getMovies().add(movie);
        wishlistService.saveToWishlist(wishlist);
        return String.format("redirect:/wishlist/%d", wishlist.getId());
    }
    
    @GetMapping("/deleteMovieFromWishlist/{movieid}/{wishlistid}")
    public String deleteMovieFromWishlist(@PathVariable(value = "movieid") long movieId, @PathVariable(value = "wishlistid") long wishlistId) {
        wishlistService.deleteMovieFromWishlist(wishlistId, movieService.getMovieById(movieId));
        return "redirect:/wishlist/" + wishlistId;
    }

    @GetMapping("/wishlist/{id}")
    public String showWishlist(@PathVariable(value="id") long id, Model model) {
        Wishlist wishlist = wishlistService.getWishlistById(id);
        model.addAttribute("moviesList", wishlist.getMovies());
        model.addAttribute("wishlistId", id);
        return "wishlist";

    }
    //works
    
    @RequestMapping(value = "/populateDropDownList", method = RequestMethod.GET)
    public String populateList(Principal principal, Model model) {
        User currentUser = userService.findByEmail(principal.getName());
        Set<Wishlist> wishlists = wishlistService.getWishlistsByUserId(currentUser.getId());
        model.addAttribute("wishlists", wishlists);
        return "dropDownList/dropDownList.html";
    }

}
