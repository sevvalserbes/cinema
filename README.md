# cinema 

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
### Third party libraries  and tools
- [Glide](https://bumptech.github.io/glide/) for image loading
- [Hilt](https://dagger.dev/hilt/gradle-setup) for dependency injection
- [Retrofit](https://square.github.io/retrofit/)
- [RxJava](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid) for aynchronous processes
- [Gson](https://github.com/google/gson) for parsing JSON data into data classes
- [Stetho](https://github.com/facebook/stetho) for inspecting layout elements and tracking network activity
