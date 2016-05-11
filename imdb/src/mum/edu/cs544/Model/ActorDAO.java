package mum.edu.cs544.Model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.cs544.Domain.Actor;


@Transactional
public class ActorDAO {

	private SessionFactory sf;

	public ActorDAO(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Actor> getAllActors() {

		List<Actor> actors = new ArrayList<Actor>();

		try {
			Query sQuery = sf.getCurrentSession().createQuery("From Actor act");
			actors = sQuery.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return actors;
	}

	public void addActor(Actor actor) throws Exception {

		try {

			sf.getCurrentSession().persist(actor);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public Actor getActor(int id) throws Exception {

		Actor actor = new Actor();
		try {

			actor = sf.getCurrentSession().get(Actor.class, id);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
		return actor;
	}

	public void updateActor(Actor actor) throws Exception {

		try {

			sf.getCurrentSession().merge(actor);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void deleteActor(Actor actor) throws Exception {

		try {
			sf.getCurrentSession().delete(actor);

		} catch (Exception ex) {

			System.out.println(ex.getMessage());

		}
	}
}
