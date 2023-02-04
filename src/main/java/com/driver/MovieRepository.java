package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    
    HashMap<String,Movie>movieDB;
    HashMap<String,Director>directorDB;
    HashMap<String,List<String>> directorMoviePair;

    
    public MovieRepository() {
        this.movieDB = new HashMap<>();
        this.directorDB = new HashMap<>();
        this.directorMoviePair = new HashMap<>();
    }

    public void addMovie(Movie movie){
       movieDB.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorDB.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director){
        if(movieDB.containsKey(movie) && directorDB.containsKey(director)){
            List<String> movieList =  new ArrayList<>();
            if(directorMoviePair.containsKey(director))
                movieList = directorMoviePair.get(director);
            movieList.add(movie);
            directorMoviePair.put(director, movieList);
        }
    }

    public Movie getMovieByName(String name){
        return movieDB.get(name);
    }

    public Director getDirectorByName(String name){
        return directorDB.get(name);
    }

    public List<String> getMoviesByDirectorName(String name){
        return directorMoviePair.get(name);
    }

    public List<String> findAllMovies(){
        List<String> movieList = new ArrayList<>();
        for(HashMap.Entry<String,List<String>>e: directorMoviePair.entrySet()){
            movieList.add(e.getKey());
        }
        return movieList;
    }

    public void deleteDirectorByName(String name){
        if(directorMoviePair.containsKey(name)){
            List<String> movieList = directorMoviePair.get(name);
            for(String movieName:movieList){
                if(movieDB.containsKey(movieName)){
                    movieDB.remove(movieName);
                }
            }
            directorMoviePair.remove(name);
        }

        if(directorDB.containsKey(name)){
            directorDB.remove(name);
        }
    }

    public void deleteAllDirectors(){
        directorDB.clear();
        for(String director:directorMoviePair.keySet()){
            for(String movie:directorMoviePair.get(director)){
                if(movieDB.containsKey(movie)){
                    movieDB.remove(movie);
                }
            }
        }
    }
}
