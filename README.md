# cinema :movie_camera: :tv:

**cinema** is an app for keeping up with the latest popular movies and TV series. It also allows users to search movies, TV series and people. It retrieves its data from [TMDb](https://www.themoviedb.org/).

## Setup

The project uses Navigation component and the Navigation component requires **Android Studio 3.3 or higher** and is **dependent on Java 8 language features**. Make sure your project meets these conditions.

You need to create an account and register for an API key to retrieve data from TMDB. You can find more information in [TMDb API Docs](https://developers.themoviedb.org/3/getting-started/introduction).

If you already have an API key, you'll need a **keys.properties** file. In your project, add a keys.properties file in your **app** folder. This is where the file is supposed to be: 

<img src="https://github.com/sevvalserbes/cinema/blob/master/art/key_properties.png" height="300">
In your file, set your API key:

```
TMDB_API_KEY=YOUR_API_KEY
```

## What's in it?
### Architecture

The project has a single-activity architecture and uses MVVM architectural pattern.
- [Data Binding](https://developer.android.com/topic/libraries/data-binding)
- [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Navigation](https://developer.android.com/guide/navigation)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
### UI

- [Material](https://material.io/develop/android) to use Material components
- [Glide](https://bumptech.github.io/glide/) for image loading
### Third party libraries  and tools

- [Hilt](https://dagger.dev/hilt/gradle-setup) for dependency injection
- [Retrofit](https://square.github.io/retrofit/)
- [OkHttp](https://square.github.io/okhttp/)
- [RxJava](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid) for aynchronous processes
- [Gson](https://github.com/google/gson) for parsing JSON data into data classes
- [Stetho](https://github.com/facebook/stetho) for inspecting layout elements and tracking network activity

## Package Structure

- **data**: This package consists of repository, service and response files.
- **domain**: In this package; there are domain models, mappers for mapping responses to domain models, UseCases and ViewStates.
- **ui**: This package has subpackages for each feature and these subpackages consist of UI files related to the features.
- **util**: Package for storing files that are used throughout the app.
- **di**: Package for dependency injection related files.

## Features
### Movie and Movie Detail screens

Movie screen displays the latest popular movies. This screen is also the starting point of the app. When user clicks on a movie on the list, Movie Detail screen fetches the related movie information and displays it.

![](https://media.giphy.com/media/zEkFFVGiVzKAKakURU/giphy.gif) ![](https://media.giphy.com/media/79wZhWlaj1AZ3cllvD/giphy.gif)

### TV Series and TV Series Detail screens

TV Series screen displays the latest popular TV series. User is directed to the TV Series Detail screen in a similar way to the Movie Detail screen. 

![](https://media.giphy.com/media/OS7DQRZPzykc1oiapd/giphy.gif) ![](https://media.giphy.com/media/hsc7L9HFSP5CZwc9x3/giphy.gif)

### Search screen

Search screen is quite self explanatory. :blush: Users are allowed to make searches if their search keywords consist of 3 characters and more. There is a 250 ms delay before sending each request. This way reduces the amount of requests and does not exhaust the servers. Otherwise, because the changes in the SearchView are detected, there would be a request for every single character user types and removes, which is unnecessary.

The search result includes three types of items: movies, TV series and people. These items can be distinguished according to the icons they have. When the user clicks on a movie item, the user is directed to the Movie Detail screen. If the user clicks on a TV series item, then the user will be directed to the TV Series Detail screen.

![](https://media.giphy.com/media/lx7oJP8V7yyK7IQMvf/giphy.gif) ![](https://media.giphy.com/media/BF6YApRdNJhA5PAlfo/giphy.gif)


## Coulda/Woulda/Shoulda

Here, I point out what could be done differently. I also treat this part as a TO-DO list so that I can get back to these subjects for improvement.  

- [ ] I would've searched for the best practice for handling onClick events with Data Binding. I am not sure if creating Handler interfaces and adding adapters "setHandler" for setting the Handlers is the best practice.
- [ ] I would've used another response instead of MultiSearch. There are three available response objects. I believe having one response for three of them is not the best way, seperation of concerns wise.
- [ ] I could've added pagination. (Bonus: I could've used the Pagination library)
- [ ] I could've added a Watchlist button and a Watchlist tab on the BottomNavigationView so that users can display the items they added to their Watchlist.
- [ ] I should've preserved UI state. 
- [ ] I would've written more unit tests covering the ViewModels and UseCases. But I am not the best at writing unit tests when asynchronous task are involved.
