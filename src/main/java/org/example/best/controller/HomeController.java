package org.example.best.controller;

import java.util.List;
import java.util.ArrayList;

import org.example.best.classes.Movie;
import org.example.best.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	
	@GetMapping("/")
    public String home(Model model) {
		model.addAttribute("name", "Samuele Passiatore");
        return "index";
    }
	
	 private List<Movie> getBestMovies() {
	        
	        List<Movie> movies = new ArrayList<>();
	        movies.add(new Movie(1, "Movie 1"));
	        movies.add(new Movie(2, "Movie 2"));
	        movies.add(new Movie(3, "Movie 3"));
	        return movies;
		 }

	    private List<Song> getBestSongs() {
	      
	        List<Song> songs = new ArrayList<>();
	        songs.add(new Song(1, "Song 1"));
	        songs.add(new Song(2, "Song 2"));
	        songs.add(new Song(3, "Song 3"));
	        return songs;
	    }
	    

	    @GetMapping("/movies")
	    public String movies(Model model) {
	        List<Movie> movies = getBestMovies();
	        List<String> movieTitles = new ArrayList<>();
	        for (Movie movie : movies) {
	            movieTitles.add(movie.getTitle());
	        }
	        model.addAttribute("titlesMovies", String.join(", ", movieTitles));
	        return "movies";
	    }
	    
	    @GetMapping("/songs")
	    public String songs(Model model) {
	        List<Song> songs = getBestSongs();
	        List<String> songTitles = new ArrayList<>();
	        for (Song song : songs) {
	            songTitles.add(song.getTitle());
	        }
	        model.addAttribute("titlesSongs", String.join(", ", songTitles));
	        return "songs";
	    }
	    
	    @GetMapping("/movies/{id}")
	    public String movieDetails(@PathVariable("id") long id, Model model) {
	        List<Movie> movies = getBestMovies();
	        for (Movie movie : movies) {
	            if (movie.getId() == id) {
	                model.addAttribute("titlesMovies", movie.getTitle());
	                break;
	            }
	        }
	        return "movie-details";
	    }

	    @GetMapping("/songs/{id}")
	    public String songDetails(@PathVariable("id") long id, Model model) {
	        List<Song> songs = getBestSongs();
	        for (Song song : songs) {
	            if (song.getId() == id) {
	                model.addAttribute("titlesSongs", song.getTitle());
	                break;
	            }
	        }
	        return "song-details";
	    }

}