package fr.eni.movielibrary.dal.jpa;

import org.springframework.data.repository.CrudRepository;

import fr.eni.movielibrary.bo.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

}
