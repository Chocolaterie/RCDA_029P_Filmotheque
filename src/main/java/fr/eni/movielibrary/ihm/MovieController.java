package fr.eni.movielibrary.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Movie;

@Controller
public class MovieController {

	@Autowired
	MovieService movieService;
	
	public Movie findMovie(long id) {
		return movieService.getMovieById(id);
	}
	
	public List<Movie> showAllMovies(){
		return movieService.getAllMovies();
	}
	@GetMapping("movie/{id}")
	public String movie(@PathVariable("id") int id, Model model) {
		
		// Récupérer une film mock
		Movie movie = movieService.getMovieById(id);
		
		// Envoyer dans le model
		model.addAttribute("movie", movie);
		
		return "movie/movie-form";
	}

	
	@GetMapping("movies")
	public String showMovies(Model model) {		
		// 1 : Envoyer les données dans le model pour la vue
		model.addAttribute("movies", movieService.getAllMovies());
		
		// 2 : Retourner la vue
		return "movie/movie-list";
	}
}
