package mum.edu.cs544.Controller;

import javax.annotation.Resource;

import mum.edu.cs544.Domain.Actor;
import mum.edu.cs544.Model.ActorDAO;
import mum.edu.cs544.Model.MovieDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ActorController {

	@Resource
	private MovieDAO moviedDAO;
	@Resource
	private ActorDAO actorDAO;

	@RequestMapping(value = "/actor/edit/{id}", method = RequestMethod.GET)
	public String editArtist(@PathVariable int id, Model model) {
		
		try {
			Actor actor = actorDAO.getActor(id);
			model.addAttribute("actors", actor);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "actors";
	}

	@RequestMapping(value = "/actor/edit/{id}", method = RequestMethod.POST)
	public String updateArtist(@ModelAttribute("actor") Actor actor,
			@PathVariable int id, final RedirectAttributes redirectAttributes) {
		
		try {
			actor.setId(id);
			actorDAO.updateActor(actor);
			redirectAttributes.addFlashAttribute("message",
					"Director Updated Successfully..");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/actor/delete/{id}", method = RequestMethod.GET)
	public String deleteArtist(@PathVariable int id,
			final RedirectAttributes redirectAttributes) {
		
		try {
			actorDAO.deleteActor(actorDAO.getActor(id));
			redirectAttributes.addFlashAttribute("message",
					"Actor Deleted Successfully..");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "redirect:/home";
	}
}
