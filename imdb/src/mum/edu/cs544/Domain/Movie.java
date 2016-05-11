package mum.edu.cs544.Domain;

import mum.edu.cs544.Domain.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private int movieId;
	private String title;
	private String summary;
	private String gener;
	private double rating;
	private String year;
	private String poster;

	@ManyToMany
	@JoinTable(name = "Movie_Director")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private List<Director> directors = new ArrayList<Director>();

	@ManyToMany
	@JoinTable(name = "Movie_Actor")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private List<Actor> actors = new ArrayList<Actor>();

	@ElementCollection
	private List<String> comments = new ArrayList<String>();

	public Movie() {
		super();
	}

	public Movie(String poster, String summary, String title, String year,
			int rating) {
		this.poster = poster;
		this.summary = summary;
		this.title = title;
		this.year = year;
		this.rating = rating;
	}

	public int getMovieId() {
		return movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

}
