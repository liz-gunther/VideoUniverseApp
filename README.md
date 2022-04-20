 # Video Universe App
 
### It's safe to say that most of us have experienced what I call "Netflix fatigue" -- that annoyance you feel when you've been scrolling and scrolling through your streaming service(s) trying to find something to watch. 

### This app was designed for my local video store (yes, they still exist!) to be a fun way of exploring movies. The app has a few main features: to randomly generate a movie suggestion based on the genre selected, and to create/maintain "wishlists" of these movies so that you can remember everything you'd like to watch. Each user can also create multiple wishlists, so that movies can be sorted by mood or genre (or however else you want). 

### I've also included a "request a movie" functionality that allows the user to submit a movie that they would like the store to carry. 

- [Daily Progress](#Daily-Progress)
- [User Stories](#User-Stories)
- [Technical Architecture](#Technical-Architecture)
- [Technical Challenges](#Technical-Challenges)
- [Lessons Learned](#Lessons-Learned)
- [Future Improvements](#Future-Improvements)
- [Wireframe Diagram](#Wireframe-Diagram)
- [Schema Diagram](#Schema-Diagram)

## Daily Progress

**April 20th - about 99% done**

- I spent today finishing up my testing. I only have one test left - the parameterized test. I'm putting myself at 99% at this point because (aside from the last test) I have satisfied all of the requirements according to the capstone documentation. However, I do have some refactoring I'd like to do and some HTML I'd like to fix, but it is not necessary to fulfill the requirements. 

- EDIT: I also forgot to include wireframes -- I intended to redo them from my initial plans, as my front end has changed drastically since then. I was planning on just drawing them by hand and uploading a photo to this document.

**April 19th - about 96% done**

- I've added a 4th model, and done at least half of the tests I need to meet the requirements. Tonight and tomorrow I plan on finishing the testing, and everything else I'll need for the presentation.

**April 18th - about 93% done**

- I've started implementing tests. I've gotten one done successfully, and I've started on the remaining tests. I also have plans to implement a user submission form, so that the current user will be able to submit a request to the video store to carry a certain movie. I am planning on fleshing that out after I finish the tests for my existing service classes & custom queries.

- I also would like to finish organizing all of the writeups I'll need for my submission, including a summary of the app and plans for future improvements. 


**April 15th - about 90% done**


- Still trying to figure out how to add movies to a particular wishlist -- I used a drop-down menu in my movie
template page and populated it with each wishlist from the current user. I've been looking up ways to include
that in the controller - although I believe it just remembers the selection by default. Hopefully today I will
be able to finish this, as it's one of the last components of my app. After that, all I have to do is finish
all the testing.

- UPDATE: I did get the add movies working! Now all of my CRUD is working as it should and I can focus on getting
the right testing done.


**April 14th - about 80% done**


- Got all my CRUD working, except for the add movie to a particular user's wishlist. I was able to update and
delete the current user, as well as create multiple wishlists for each user. I am having an issue with
deleting wishlists, as they are connected to multiple tables. I still haven't gotten a good start on my tests
yet, but I plan to start in earnest tomorrow.


**April 13th - about 70% done**


- I finally got the login/registration working. Now I'm retrofitting my CRUD operations and mapping so that it
accurately reflects the details of the current user. Tonight I plan on fixing the delete and add functions of
my wishlists. The idea is that each user can add/edit/delete wishlists -- I had the CRUD working before I added
security but now I'm struggling to understand how to assign the ID of each wishlist to the user that created
it.

- I also plan on getting my tests finished up before the weekend is over. After that, most of the capstone requirements
will have been fulfilled.


**April 12th - about 55% done**


- Yesterday I attempted to add the registration page (per the lab we did together today in class) - today I hope
to get that ironed out so that I can move forward with restructuring my mapping so that it accurately reflects
the choices of the user who is currently on the app. I've got the registration part working - now just ironing
out the login page.



**April 11th - about 50% done**


- My best estimate for my project is that I'm a little more than halfway done.

- During the weekend, I got the CRUD operations working for my Users & Wishlists working, I am now in the process
of designing pages so that you can choose which wishlist you would like to view.

- I am hoping to get sessions working so that I can display the wishlists for the current user only.

## User Stories

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

13. As a user, I'd like to be able to request a movie so that the video store can carry it.

## Technical Architecture

![technical architecture of project][techstack]

[techstack]: https://github.com/liz-gunther/VideoUniverseApp/blob/master/resources/techstack.png

## Technical Challenges

This is the very first app I've ever built. I am brand new to every technology covered in this bootcamp, so I had my fair share of technical challenges to overcome. For brevity's sake, however, I'll stick to the first few that come to mind, in no particular order:

1. Utilizing Bootstrap 
   - I had big plans for my front end, and found a tutorial that I thought would be perfect for helping me build the web pages of my dreams. It turned out to be far more advanced than I was prepared for, and ended up building a lot of custom CSS classes that (I thought) would make designing multiple pages a lot smoother. However, once I got around to learning about and using Bootstrap elements, I found that a lot of my custom classes clashed with the ones needed for Bootstrap.
   - To fix this, I ended up renaming some of my custom classes. It took a bit of refactoring, but I made short work of that with good ol' search and find.
2. Thymeleaf
    - I don't think I'm alone in my struggles with Thymeleaf. There wasn't a ton of course material that covered it, so I was left to my own devices to figure out a lot of the annotations and how they worked. 
    - I overcame this particular challenge by trial and error -- doing things wrong (a lot of times) and figuring out how each element interacted with others.
3. Complex Entity Models
   - One final (and memorable) challenge I encountered was puzzling out my entity models. It was difficult to know how to connect the data in a way that was efficient and easily accessible. 
   - My solution to this was to seek help -- and LOTS of it. While reading Baeldung and StackOverflow solutions certainly helped, I found that I learned most effectively when I was able to interact with my fellow learners to hash things out. Which segues nicely to my next point...
   
## Lessons Learned

Building this app has been quite the intense experience for me. As I've said before, it's the first app I've ever attempted to build, and having to draw upon all of the knowledge that I've crammed into my brain over the last three months has pushed me in ways I've never experienced before. I am very proud of what I've accomplished, and I look forward to building on all of these skills that I've acquired.

I think my biggest takeaway from this exercise is that you make the most progress when you learn how and when to ask for help. I was very hard on myself for the first month of the bootcamp, and I was constantly overwhelmed with the feeling that I had to learn everything about every technology all at once, or I wouldn't be able to accomplish what had to be done (namely, building this application). 

Once I realized that NOBODY can learn how to program in just three months, a lot of that pressure I put on myself started to dissipate. I found a handful of people in my cohort who were almost always willing to take time outside of class to help with assignments or just explaining general concepts in a different way. Over time, I think I found a good balance between digging in and doing my own work and learning when to throw in the towel and reach out to those who know better than I do.

## Future Improvements

This is an app idea I've had for quite some time (from far before I ever learned how to build apps), so it's something I'd love to continuously improve as my skills grow. It's a local business that I care a lot about, so I'd be thrilled if it eventually became something that could be deployed at enterprise level.

One of the biggest things that I wish I could've done is added a search function. Ideally, this app would be backed by whatever movie database the business is actually using. It seems unlikely that their database hosts the kind of information needed to populate the templates I had made (links to movie posters and trailers, for example), but I'd imagine with the assistance of an API (not unlike the one I used) it could definitely be feasible. If this app was tied to their actual database, a search function would be a welcome addition. As it stands, it is only a mock database (containing about 300 sample movies) so including a search function seems kind of pointless. 

I'd also love to sharpen up the front end -- while I feel I did an adequate job of capturing the views I had imagined, there are some animations that I couldn't quite puzzle out, and there are some UI elements that need to be changed. Again, this is a project I very much look forward to revisiting. I'm very proud of the work I accomplished, but I already have big ideas for how I'd like to improve it.

## Wireframe Diagram

## Schema Diagram

![database schema][schema]

[schema]: https://github.com/liz-gunther/VideoUniverseApp/blob/master/resources/dbschema.png