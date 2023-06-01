package fr.eni.movielibrary.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.dal.jpa.MovieRepository;

@Component
public class MovieDAOJPA {

	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> getAll() {
		return (List<Movie>) movieRepository.findAll();
	}
	
	public Movie get(long id) {
		return movieRepository.findById(id).get();
	}
}
