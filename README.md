/* -----------------------------*/
/*      Video Universe App      */
/* -----------------------------*/
- [Daily Progress] (#Daily-Progress)
- [User Stories] (#User-Stories)
- [Technical Architecture] (#Technical-Architecture)
- [Technical Challenges] (#Technical-Challenges)
- [Lessons Learned] (#Lessons-Learned)
- [Future Improvements] (#Future-Improvements)
- [Wireframe Diagram] (#Wireframe-Diagram)
- [Schema Diagram] (#Schema-Diagram)

(#Daily-Progress)

/* -----------------------------*/
/* April 15th - about 90% done  */
/* -----------------------------*/

- Still trying to figure out how to add movies to a particular wishlist -- I used a drop-down menu in my movie
template page and populated it with each wishlist from the current user. I've been looking up ways to include
that in the controller - although I believe it just remembers the selection by default. Hopefully today I will
be able to finish this, as it's one of the last components of my app. After that, all I have to do is finish
all the testing.

- UPDATE: I did get the add movies working! Now all of my CRUD is working as it should and I can focus on getting
the right testing done.

/* -----------------------------*/
/* April 14th - about 80% done  */
/* -----------------------------*/

- Got all my CRUD working, except for the add movie to a particular user's wishlist. I was able to update and
delete the current user, as well as create multiple wishlists for each user. I am having an issue with
deleting wishlists, as they are connected to multiple tables. I still haven't gotten a good start on my tests
yet, but I plan to start in earnest tomorrow.

/* -----------------------------*/
/* April 13th - about 70% done  */
/* -----------------------------*/

- I finally got the login/registration working. Now I'm retrofitting my CRUD operations and mapping so that it
accurately reflects the details of the current user. Tonight I plan on fixing the delete and add functions of
my wishlists. The idea is that each user can add/edit/delete wishlists -- I had the CRUD working before I added
security but now I'm struggling to understand how to assign the ID of each wishlist to the user that created
it.

- I also plan on getting my tests finished up before the weekend is over. After that, most of the capstone requirements
will have been fulfilled.

/* -----------------------------*/
/* April 12th - about 55% done  */
/* -----------------------------*/

- Yesterday I attempted to add the registration page (per the lab we did together today in class) - today I hope
to get that ironed out so that I can move forward with restructuring my mapping so that it accurately reflects
the choices of the user who is currently on the app. I've got the registration part working - now just ironing
out the login page.


/* -----------------------------*/
/* April 11th - about 50% done  */
/* -----------------------------*/

- My best estimate for my project is that I'm a little more than halfway done.

- During the weekend, I got the CRUD operations working for my Users & Wishlists working, I am now in the process
of designing pages so that you can choose which wishlist you would like to view.

- I am hoping to get sessions working so that I can display the wishlists for the current user only.


#User-Stories
/* -----------------------------*/
/*         USER STORIES         */
/* -----------------------------*/

1. As a user, I want to be able to create multiple wishlists so that I can easily organize the collections of movies
    I want to watch.

2. As a user, I want to be able to delete my wishlists once I no longer need them to keep my profile organized.

3. As a user, I want to be able to add movies to a wishlist of my choice.

4. As a user, I want to be able to edit each wishlist individually so that I can add more movies if I desire or remove
    them once I've seen them.

5. As a user, I want to be able to select a genre and have a recommendation randomly generated so that I have a better
    idea of what to rent.

6. As a user, I want the relevant information for each random movie that is generated displayed so I can easily determine
    if it's one I want to add to a wishlist.

7. As a user, I want to be able to add a movie to a wishlist with only a few button clicks.

8. As a user, I want to be able to create a user profile so that my wishlists and movie selections will be remembered.

9. As a user, I want to be able to edit my user profile so that I can change my preferred name/email address.

10. As a user, I want to be able to login/logout so that my personal information is secure.

11. As a user, I want to see information about the store, so I can know what they're about and also relevant contact
    information.

12. As a user, I want easy access to location information about the store so that I can easily visit when I'm ready
    to rent a movie.