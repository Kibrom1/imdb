package mum.edu.cs544.Controller;

import javax.annotation.Resource;

import mum.edu.cs544.Domain.Actor;
import mum.edu.cs544.Model.ActorDAO;
import mum.edu.cs544.Model.MovieDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActorController {

	@Resource
	private MovieDAO moviedDAO;
	@Resource
	private ActorDAO actorDAO;

	@RequestMapping(value = "/actor/edit/{id}", method = RequestMethod.GET)
	public String editArtist(@PathVariable int id, Model model)
			throws Exception {
		Actor actor = actorDAO.getActor(id);
		model.addAttribute("actors", actor);
		return "actors";
	}
}
