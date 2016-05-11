package mum.edu.cs544.Model;

import java.util.ArrayList;
import java.util.List;

import mum.edu.cs544.Domain.Movie;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MovieDAO {

	private SessionFactory sf;

	public MovieDAO(SessionFactory sf) {

		this.sf = sf;
	}

	public void addMovie(Movie movie) throws Exception {

		try {
			sf.getCurrentSession().persist(movie);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovie() throws Exception {

		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query sQuery = sf.getCurrentSession().createQuery("From Movie m");
			listMovies = sQuery.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	public Movie getMovie(int id) throws Exception {

		Movie movie = new Movie();
		try {

			movie = (Movie) sf.getCurrentSession().get(Movie.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
		return movie;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchByTitle(String title) throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery(
					"From Movie m where m.title like :title");
			query.setParameter("title", "%" + title + "%");

			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchByGenre(String gener) throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery(
					"From Movie m where m.gener like :gener");
			query.setParameter("gener", "%" + gener + "%");

			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchByRating(double rating) throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery(
					"From Movie m where m.rating like :rating");
			query.setParameter("rating", "%" + rating + "%");

			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchActor(String actorName) {

		List<Movie> movies = new ArrayList<Movie>();

		try {
			Query query = sf
					.getCurrentSession()
					.createQuery(
							"SELECT m FROM Movie m JOIN m.actor a where a.name = :actorName");
			query.setParameter("actorName", actorName);

			movies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchByYear(int year) throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery(
					"From Movie m where m.rating like :year");
			query.setParameter("year", "%" + year + "%");

			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	@SuppressWarnings("unused")
	public List<Movie> searchByDirector(String directorName) {

		List<Movie> movies = new ArrayList<Movie>();

		try {

			Query query = sf
					.getCurrentSession()
					.createQuery(
							"SELECT m FROM Movie m JOIN m.director d where d.name = :directorName");
			query.setParameter("directorName", directorName);

			movies = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	public void updateMovie(Movie m) throws Exception {

		try {
			sf.getCurrentSession().merge(m);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
	}

	public void deleteMovie(Movie mov) throws Exception {
		try {
			sf.getCurrentSession().delete(mov);

		} catch (Exception ex) {

			System.out.println(ex.getMessage());

		}
	}
}
