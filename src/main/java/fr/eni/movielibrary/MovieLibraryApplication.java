package fr.eni.movielibrary;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.eni.movielibrary.bo.Movie;
import fr.eni.movielibrary.ihm.MovieController;

@SpringBootApplication
public class MovieLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieLibraryApplication.class, args);
	}
}
