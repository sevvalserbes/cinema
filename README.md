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

*I read Yuichi Fujiki's [article](https://medium.com/@yfujiki/how-to-store-use-sensitive-information-in-android-development-bc352892ece7) and followed Step 1 to hide the sensitive data in the app in a **keys.properties** file.* 

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

![](https://media.giphy.com/media/zEkFFVGiVzKAKakURU/giphy.gif) ![](https://media.giphy.com/media/Atk7VSj9Zxd4Hy8dsN/giphy.gif)

### TV Series and TV Series Detail screens

TV Series screen displays the latest popular TV series. User is directed to the TV Series Detail screen in a similar way to the Movie Detail screen. 

![](https://media.giphy.com/media/OS7DQRZPzykc1oiapd/giphy.gif) ![](https://media.giphy.com/media/jeBbXB7gtlScj9xPwZ/giphy.gif)

### Search screen

Search screen is quite self explanatory. :blush: Users are allowed to make searches if their search keywords consist of 3 characters and more. There is a 250 ms delay before sending each request. This way reduces the amount of requests and does not exhaust the servers. Otherwise, because the changes in the SearchView are detected, there would be a request for every single character user types and removes, which is unnecessary.

The search result includes three types of items: movies, TV series and people. These items can be distinguished according to the icons they have. When the user clicks on a movie item, the user is directed to the Movie Detail screen. If the user clicks on a TV series item, then the user will be directed to the TV Series Detail screen.

![](https://media.giphy.com/media/lx7oJP8V7yyK7IQMvf/giphy.gif) ![](https://media.giphy.com/media/FkCOCECMcG4zLtEwdG/giphy.gif)


## Some of the questions this project might be answering

### How to inject a ViewModel that has parameters in its constructor to a fragment?

Thanks to **Hilt** and and [**Fragment KTX**](https://developer.android.com/kotlin/ktx#fragment), this can be achieved effortlessly. Assuming you already have set up Hilt for your app, you should add Fragment KTX dependency:
```
dependencies {
    implementation "androidx.fragment:fragment-ktx:<latest-version>"
}
```
Then, you add **@ViewModelInject** annotation to your ViewModel's constructor. Here is an example from the project:
```
class MoviesViewModel @ViewModelInject constructor(
    private val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase
)
```
Later, you can get an instance of your ViewModel in your fragment like this:

```
@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val viewModel by viewModels<MoviesViewModel>()
    
    ...
}
```

Make sure:
- Your fragment is annotated with **@AndroidEntryPoint** 
- The activity that hosts your fragment is annotated with **@AndroidEntryPoint**
- *Hilt currently only supports activities that extend ComponentActivity and fragments that extend androidx library Fragment*. So check whether your activities or fragments provide the requirements.
- For further information: [Hilt and Jetpack integrations](https://developer.android.com/training/dependency-injection/hilt-jetpack), [Hilt Gradle Setup](https://dagger.dev/hilt/gradle-setup)

### How to pass data between fragments while using the Navigation component?

I got a little bit of help from a Navigation component Gradle plugin named **Safe Args** to achieve this. Following the instructions [here](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args), you can Safe Args to your project.

This is the navigation graph of the cinema app:

<p align="center">
  <img height="400" src="https://github.com/sevvalserbes/cinema/blob/master/art/movieDetail.png">
</p>

The arrows represent the actions between destinations. The highlighted arrows represent the actions between MovieDetailFragment and other fragments. Here, MovieDetailFragment is the destination. When the user clicks on the movie item on the list, whether in MoviesFragment or SearchFragment, the app should navigate to the MovieDetailFragment passing the id of the movie the user clicked on at the same time. 

Because the MovieDetailFragment is the recipient of the movie id, a movieId value should be added to its arguments. When the MovieDetailFragment is selected on the navigation graph, **Arguments** show up on the **Attributes** panel. The following images show how to add an argument:

<p align="center">
    <img src="https://github.com/sevvalserbes/cinema/blob/master/art/arguments.png" height="200"> <img src="https://github.com/sevvalserbes/cinema/blob/master/art/add_argument.png" height="200">
</p>

Let's take a look at the code in the MoviesFragment. onMovieClick function is called when the user clicks on a movie item on the list.
```
override fun onMovieClick(movieId: Int) {
        val directions = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(movieId)
        findNavController().navigate(directions)
    }
```
When an action is added to the graph, Safe Args generates a class for the destination where the action **originates** and adds "Directions" at the end of the class. Because our action originates from MoviesFragment, a **MoviesFragmentDirections** class is generated. This class generates a funtion according to the action id. To navigate between destinations, a **NavController** object is needed. By calling one of the overloads of the **navigate** (in our case, we add directions as a parameter), we can navigate to the desired destination.

For each destination that is a recipient of an argument, Safe Args generates a class and adds "Args" at the end of the class. In our case, MovieDetailFragment is our recipient. By adding the code below, you can access the arguments of the MovieDetailFragment.

```
@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private val args: MovieDetailFragmentArgs by navArgs()
    
    ...
}
```
For further information: [Navigate to a destination](https://developer.android.com/guide/navigation/navigation-navigate), [Pass data between destinations](https://developer.android.com/guide/navigation/navigation-pass-data)

## Coulda/Woulda/Shoulda

Here, I point out what could be done differently. I also treat this part as a TO-DO list so that I can get back to these subjects for improvement.  

- [ ] I would've searched for the best practice for handling onClick events with Data Binding. I am not sure if creating Handler interfaces and adding adapters "setHandler" for setting the Handlers is the best practice.
- [ ] I would've used another response instead of MultiSearch. There are three available response objects. I believe having one response for three of them is not the best way, seperation of concerns wise.
- [ ] I could've added pagination. (Bonus: I could've used the Pagination library)
- [ ] ~I could've added a Watchlist button~ and a Watchlist tab on the BottomNavigationView so that users can display the items they added to their Watchlist.
- [ ] I should've preserved UI state. 
- [ ] I would've written more unit tests covering the ViewModels and UseCases. But I don't have experience with writing unit tests when asynchronous task are involved.
