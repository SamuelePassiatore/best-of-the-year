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
	    model.addAttribute("movies", movies);
	    model.addAttribute("name", "Samuele Passiatore");
	    return "movies";
	}

	@GetMapping("/songs")
	public String songs(Model model) {
	    List<Song> songs = getBestSongs();
	    model.addAttribute("songs", songs);
	    model.addAttribute("name", "Samuele Passiatore");
	    return "songs";
	}

	@GetMapping("/movies/{id}")
	public String movieDetails(@PathVariable("id") long id, Model model) {
		Movie m1 = null;
		for (Movie m : getBestMovies())
			if (m.getId() == id)
				m1 = m;
			if (m1 != null)
				model.addAttribute("titlesMovies", m1);
			else
				model.addAttribute("titlesMovies", "No found movie");
		model.addAttribute("name", "Samuele Passiatore");	
		return "movie-details";
	}

	@GetMapping("/songs/{id}")
	public String songDetails(@PathVariable("id") long id, Model model) {
		Song s1 = null;
		for (Song s : getBestSongs())
			if (s.getId() == id)
				s1 = s;
			if (s1 != null)
				model.addAttribute("titlesSongs", s1);
			else
				model.addAttribute("titlesSongs", "No found song");
		model.addAttribute("name", "Samuele Passiatore");	
		return "song-details";
	}

}
