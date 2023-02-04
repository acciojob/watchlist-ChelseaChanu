package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController{

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully",HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,@RequestParam  String directorName){
        movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>("New director-movie pair added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@RequestParam String name){
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@RequestParam String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestParam String name){
        List<String> movieList =  movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(movieList, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movieList = movieService.findAllMovies();
        return new ResponseEntity<>(movieList,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(name + "Director and all its movies deleted successfully",HttpStatus.CREATED);

    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All records of directors and its movies deleted successfully",HttpStatus.CREATED);
    }

}