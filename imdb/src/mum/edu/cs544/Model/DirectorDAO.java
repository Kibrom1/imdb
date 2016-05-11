package mum.edu.cs544.Model;

import java.util.ArrayList;
import java.util.List;

import mum.edu.cs544.Domain.Director;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class DirectorDAO {

	private SessionFactory sf;

	public DirectorDAO(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Director> getAllDirectors() {

		List<Director> directors = new ArrayList<Director>();
		Transaction tx = null;
		try {

			Query sQuery = sf.getCurrentSession().createQuery(
					"From Director dir");
			directors = sQuery.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return directors;
	}

	public void addDirector(Director dir) throws Exception {

		try {
			sf.getCurrentSession().persist(dir);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Director getDirector(int id) throws Exception {

		Director dir = new Director();
		try {
			dir = sf.getCurrentSession().get(Director.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return dir;
	}

	public void updateDirector(Director dir) throws Exception {

		try {
			sf.getCurrentSession().merge(dir);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void deleteDirector(Director dir) throws Exception {

		try {
			sf.getCurrentSession().delete(dir);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
