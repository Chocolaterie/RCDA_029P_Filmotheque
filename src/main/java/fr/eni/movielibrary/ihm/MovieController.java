package fr.eni.movielibrary.ihm;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.ServiceResult;

@Controller
@SessionAttributes({"loggedUser"})
public class MovieController {

	@Autowired
	MovieService movieService;
	
	public Movie findMovie(long id) {
		return movieService.getMovieById(id);
	}
	
	public List<Movie> showAllMovies(){
		return movieService.getAllMovies();
	}
	
	/**
	 * Route pour afficher la fiche publique d'un Film
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("movie/{id}")
	public String movie(@PathVariable("id") int id, Model model) {
		
		// Récupérer une film mock
		Movie movie = movieService.getMovieById(id);
		
		// Envoyer dans le model
		model.addAttribute("movie", movie);
		
		return "movie/movie-form";
	}
	
	/**
	 * Route pour afficher formulaire creation Film
	 * @param model
	 * @return
	 */
	@GetMapping("create-movie")
	public String createMovie(Model model) {
		
		// Envoyer dans le model
		model.addAttribute("movie", new Movie());
		
		// Envoyer la liste des genres
		model.addAttribute("genreOptions", movieService.getGenres());
		
		// Envoyer la liste des participants
		model.addAttribute("participantOptions", movieService.getParticipants());
		
		return "movie/movie-form";
	}
	
	@PostMapping("create-movie")
	public String createMovie(@ModelAttribute("movie") Movie movie, Model model) {
		// Appeler le service ajouter le film
		ServiceResult result = movieService.addMovie(movie);
		
		// Si le traitement est ok
		if (result.isValid()) {
			// Redirection
			return "redirect:/";
		}
		// Sinon
		// -- Envoyer le message d'erreur dans la vue
		model.addAttribute("errors", result.getErrors());
		
		// -- Afficher le formulaire
		return "movie/movie-form";
	}

	
	@GetMapping("/")
	public String showMovies(Model model) {		
		// 1 : Envoyer les données dans le model pour la vue
		model.addAttribute("movies", movieService.getAllMovies());
		
		// 2 : Retourner la vue
		return "movie/movie-list";
	}
}
