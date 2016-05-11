package mum.edu.cs544.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {

	@Id
	@GeneratedValue
	private int actorId;
	private String name;
	private Date dateOfBirth;
	private String placeOfBirth;
	private String biography;
	private byte[] picture;

	@ManyToMany(mappedBy = "actors", cascade = { CascadeType.PERSIST,
			CascadeType.REMOVE })
	private List<Movie> movies = new ArrayList<Movie>();

	public Actor() {
		super();
	}

	public Actor(String name, Date dob, String pob, String bio) {
		this.name = name;
		this.dateOfBirth = dob;
		this.placeOfBirth = pob;
		this.biography = bio;

	}
public void setId(int id){
	this.actorId = id;
}
	public int getActorId() {
		return actorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String bio) {
		this.biography = bio;
	}

}
