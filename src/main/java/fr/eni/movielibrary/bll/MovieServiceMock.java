package fr.eni.movielibrary.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.movielibrary.bo.Genre;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.bo.Participant;
import fr.eni.movielibrary.bo.Review;
import fr.eni.movielibrary.bo.ServiceResult;

@Service
@Profile("dev")
public class MovieServiceMock implements MovieService {
	// Attributs static pour gérer les valeurs à afficher
	private static List<Movie> lstMovies;
	private static List<Genre> lstGenres;
	private static List<Participant> lstParticipants;

	private static final String[] genres = { "Animation", "Science-fiction", "Documentaire", "Action", "Comédie",
			"Drame" };

	public MovieServiceMock() {
		// Création de la liste des genres
		lstGenres = new ArrayList<>();
		for (int index = 0; index < genres.length; index++) {
			lstGenres.add(new Genre(index + 1, genres[index]));
		}

		// Création de la liste des participants
		lstParticipants = new ArrayList<>();
		// 2 réalisateurs dont 1 pour 2 films
		Participant stevenSpielberg = new Participant(1, "Spielberg", "Steven");
		Participant davidCronenberg = new Participant(2, "Cronenberg", "David");
		lstParticipants.add(stevenSpielberg);
		lstParticipants.add(davidCronenberg);

		// 2 acteurs par film et l'un d'eux dans 2 films
		Participant richardAttenborough = new Participant(3, "Attenborough", "Richard");
		Participant jeffGoldblum = new Participant(4, "Goldblum", "Jeff");
		List<Participant> actorsJurassicPark = new ArrayList<>();
		actorsJurassicPark.add(richardAttenborough);
		actorsJurassicPark.add(jeffGoldblum);
		lstParticipants.addAll(actorsJurassicPark);

		Participant geenaDavis = new Participant(5, "Davis", "Geena");
		List<Participant> actorsTheFly = new ArrayList<>();
		actorsTheFly.add(jeffGoldblum);
		actorsTheFly.add(geenaDavis);
		lstParticipants.add(geenaDavis);

		Participant markRylance = new Participant(6, "Rylance", "Mark");
		Participant rubyBarnhill = new Participant(7, "Barnhill", "Ruby");
		List<Participant> actorsTheBFG = new ArrayList<>();
		actorsTheBFG.add(markRylance);
		actorsTheBFG.add(rubyBarnhill);
		lstParticipants.addAll(actorsTheBFG);

		// Création de la liste de films
		// 3 films
		lstMovies = new ArrayList<>();
		Movie jurassicPark = new Movie(1, "Jurassic Park", 1993, 128,
				"Le film raconte l'histoire d'un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.");
		jurassicPark.setGenre(lstGenres.get(1));
		jurassicPark.setDirector(stevenSpielberg);
		jurassicPark.setActors(actorsJurassicPark);
		//--
		jurassicPark.addReview(new Review(1, 4, "Trop fort les dinos"));
		jurassicPark.addReview(new Review(1, 1, "La scene avec goldblum et la tonne de ***** bof bof"));
		//
		lstMovies.add(jurassicPark);

		Movie theFly = new Movie(2, "The Fly", 1986, 95,
				"Il s'agit de l'adaptation cinématographique de la nouvelle éponyme de l'auteur George Langelaan.");
		theFly.setGenre(lstGenres.get(1));
		theFly.setDirector(davidCronenberg);
		theFly.setActors(actorsTheFly);
		lstMovies.add(theFly);

		Movie theBFG = new Movie(3, "The BFG", 2016, 117,
				"Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.");
		theBFG.setGenre(lstGenres.get(4));
		theBFG.setDirector(stevenSpielberg);
		theBFG.setActors(actorsTheBFG);
		lstMovies.add(theBFG);
	}

	@Override
	public List<Movie> getAllMovies() {
		return lstMovies;
	}

	@Override
	public Movie getMovieById(long id) {
		for (Movie movie : lstMovies) {
			if (movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}

	@Override
	public List<Genre> getGenres() {
		return lstGenres;
	}

	@Override
	public List<Participant> getParticipants() {
		return lstParticipants;
	}

	@Override
	public Genre getGenreById(long id) {
		for (Genre genre : lstGenres) {
			if (genre.getId() == id) {
				return genre;
			}
		}
		return null;
	}

	@Override
	public Participant getParticipantById(long id) {
		for (Participant participant : lstParticipants) {
			if (participant.getId() == id) {
				return participant;
			}
		}
		return null;
	}

	@Override
	public ServiceResult addMovie(Movie movie) {
		// Preparer le resultat du traitement 
		ServiceResult result = new ServiceResult();
		
		// Erreur : durée invalide
		if (movie.getDuration() < 1) {
			result.addError("La durée doit être supérieur à 0");
		}
		// Erreur : Synopsis invalide
		if (!(movie.getSynopsis().length() >= 20 && movie.getSynopsis().length() <= 250)) {
			result.addError("La Synopsis doit faire entre 20 et 250 caractères");
		}
			
		// Ajouter dans la liste le film
		if (result.isValid()) {
			lstMovies.add(movie);
		}
		
		return result;
	}

	@Override
	public void saveMovie(Movie movie) {
		// Chercher l'index
		int index = 0;
		int indexToEdit = -1;
		for (Movie currentMovie : lstMovies) {
			// Si le slug correspond à la personne renseigné
			if (currentMovie.getId() == movie.getId()) {
				indexToEdit = index;
			}
			index++;
		}
		
		// Modifier depuis l'index
		if (indexToEdit > -1) {
			lstMovies.set(indexToEdit, movie);
		}
	}

	@Override
	public ServiceResult addReview(Review review, int movieId) {
		ServiceResult result = new ServiceResult();
		
		// Récupérer
		Movie movie = getMovieById(movieId);
		
		// Si on trouve le film
		if (movie != null) {
			// Ajouter la review
			movie.addReview(review);
			
			// Sauvegarder le film
			saveMovie(movie);
		} else {
			result.addError("Le film n'existe pas");
		}
		
		return result;
	}
}
