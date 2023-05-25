package org.example.best.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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
	        String mts = "";
	        Iterator<Movie> it = getBestMovies().iterator();
	        while(it.hasNext()) {
	        	mts += it.next().getTitle();
	        	
	        	if(it.hasNext())
	        		mts += ", ";
	        }
	        model.addAttribute("titlesMovies", mts);
	        return "movies";
	    }
	    
	    @GetMapping("/songs")
	    public String songs(Model model) {
	        String sts = "";
	        Iterator<Song> it = getBestSongs().iterator();
	        while(it.hasNext()) {
	        	sts += it.next().getTitle();
	        	
	        	if(it.hasNext())
	        		sts += ", ";
	        }
	        model.addAttribute("titlesSongs", sts);
	        return "songs";
	    }
	    
	    @GetMapping("/movies/{id}")
	    public String movieDetails(@PathVariable("id") long id, Model model) {
	    	Movie m1 = getBestMovies().get((int) id);
	        model.addAttribute("titlesMovies", m1);
	        return "movies";
	    }

	    @GetMapping("/songs/{id}")
	    public String songDetails(@PathVariable("id") long id, Model model) {
	    	
	    	Song s1 = getBestSongs().get((int) id);
	        model.addAttribute("titlesSongs", s1);
	        return "songs";
	    }

}
