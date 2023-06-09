package fr.eni.movielibrary.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	protected int rating;
	protected String comment;
	
	@ManyToOne()
	protected Member membre;
	
	@ManyToOne()
	protected Movie movie;
	
	/**
	 * @param id
	 * @param rating
	 * @param comment
	 */
	public Review(long id, int rating, String comment) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Review() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the membre
	 */
	public Member getMembre() {
		return membre;
	}
	/**
	 * @param membre the membre to set
	 */
	public void setMembre(Member membre) {
		this.membre = membre;
	}
	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}
	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
