package mum.edu.cs544.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.CascadeType;

@Entity
public class Director {

	@Id
	@GeneratedValue
	private int directorId;
	private String name;

	@ManyToMany(mappedBy = "directors", cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE })
	private List<Movie> movies = new ArrayList<Movie>();

	public Director() {
		super();
	}

	public Director(String name) {
		this.name = name;
	}

	public int getDirectorId() {
		return directorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public void setId(int id) {

		this.directorId = id;

	}

}
