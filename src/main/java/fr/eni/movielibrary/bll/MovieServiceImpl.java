package fr.eni.movielibrary.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Participant;
import fr.eni.movielibrary.bo.Review;
import fr.eni.movielibrary.bo.ServiceResult;
import fr.eni.movielibrary.dal.MovieDAOJPA;

@Service
@Profile("prod")
public class MovieServiceImpl implements MovieService {

	@Autowired 
	MovieDAOJPA movieDAOJPA;
	
	@Override
	public List<Movie> getAllMovies() {
		return movieDAOJPA.getAll();
	}

	@Override
	public Movie getMovieById(long id) {
		return movieDAOJPA.get(id);
	}

	@Override
	public List<Genre> getGenres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Participant> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre getGenreById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participant getParticipantById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServiceResult addReview(Review review, int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
