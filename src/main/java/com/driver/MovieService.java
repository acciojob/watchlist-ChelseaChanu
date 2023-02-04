package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepo;

    public void addMovie(Movie movie){
        movieRepo.addMovie(movie);;
    }

    public void addDirector(Director director){
        movieRepo.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        movieRepo.addMovieDirectorPair(movieName, directorName);
    }

    public Movie getMovieByName(String name){
        return movieRepo.getMovieByName(name);
    }

    public Director getDirectorByName(String name){
        return movieRepo.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name){
        return movieRepo.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies(){
        return movieRepo.findAllMovies();
    }

    public void deleteDirectorByName(String name){
        movieRepo.deleteDirectorByName(name);
    }

    public void deleteAllDirectors(){
        movieRepo.deleteAllDirectors();
    }
}
