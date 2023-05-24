package fr.eni.movielibrary.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bll.MovieService;
import fr.eni.movielibrary.bo.Movie;

@Component("movieBean")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	public Movie findMovie(long id) {
		return movieService.getMovieById(id);
	}
	
	public List<Movie> showAllMovies(){
		return movieService.getAllMovies();
	}
}
