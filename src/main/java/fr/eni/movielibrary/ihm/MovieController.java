package fr.eni.movielibrary.ihm;

import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Review;
import fr.eni.movielibrary.bo.ServiceResult;

@Controller
public class MovieController extends EniController {

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
		
		// Preparer la model de donnée pour une review
		model.addAttribute("review", new Review());
		
		return "movie/movie-detail";
	}
	
	/**
	 * Route pour afficher formulaire creation Film
	 * @param model
	 * @return
	 */
	@GetMapping("create-movie")
	public String createMovie(Model model) {
		// Si je suis pas connecté alors je redirige sur login
		if (!isLogged(model)) {
			return "redirect:/login";
		}
		
		// Envoyer dans le model
		model.addAttribute("movie", new Movie());
		
		// Envoyer la liste des genres
		model.addAttribute("genreOptions", movieService.getGenres());
		
		// Envoyer la liste des participants
		model.addAttribute("participantOptions", movieService.getParticipants());
		
		return "movie/movie-form";
	}
	
	@PostMapping("create-movie")
	public String createMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model) {
	
		// Si je suis pas connecté alors je redirige sur login
		if (!isLogged(model)) {
			return "redirect:/login";
		}
				
		// Envoyer la liste des genres
		model.addAttribute("genreOptions", movieService.getGenres());
		
		// Envoyer la liste des participants
		model.addAttribute("participantOptions", movieService.getParticipants());
		
		// 1 :: Controle de surface (formulaire)
		if (!bindingResult.hasErrors()) {
			// Appeler le service ajouter le film
			ServiceResult result = movieService.addMovie(movie);
			
			// 2 :: Metier - Si le traitement est ok
			if (result.isValid()) {
				// Redirection
				return "redirect:/";
			}
			// -- Envoyer le message d'erreur dans la vue
			model.addAttribute("errors", result.getErrors());
		}
		
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
	
	@PostMapping("add-review/{id}")
	public String addReview(@PathVariable("id") int id, @ModelAttribute("review") Review review, Model model) {
		// Si je suis pas connecté alors je redirige sur login
		if (!isLogged(model)) {
			return "redirect:/login";
		}
				
		// Récupérer
		ServiceResult result = movieService.addReview(review, id);
		
		// Si on trouve le film
		if (result.isValid()) {
			
			// -- Redirigier sur le film
			return String.format("redirect:/movie/%d", id);
		}
	
		// Erreur
		System.out.println(String.format("Erreurs : %s", result.getErrors()));
		
		return String.format("redirect:/");
	}
}
