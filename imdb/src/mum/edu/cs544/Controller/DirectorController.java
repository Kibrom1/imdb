package mum.edu.cs544.Controller;

import javax.annotation.Resource;

import mum.edu.cs544.Domain.Director;
import mum.edu.cs544.Model.ActorDAO;
import mum.edu.cs544.Model.DirectorDAO;
import mum.edu.cs544.Model.MovieDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DirectorController {
	@Resource
	private MovieDAO moviedDAO;
	@Resource
	private ActorDAO actorDAO;
	@Resource
	private DirectorDAO directorDAO;

	@RequestMapping(value = "/director/edit/{id}", method = RequestMethod.GET)
	public String editDirector(Model model, @PathVariable int id) {
		
		try {
			Director director = directorDAO.getDirector(id);
			model.addAttribute("director", director);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "director";
	}

	@RequestMapping(value = "/director/edit/{id}", method = RequestMethod.POST)
	public String updateDirector(@ModelAttribute("director") Director director,
			@PathVariable int id, final RedirectAttributes redirectAttributes) {
		
		try {
			director.setId(id);
			directorDAO.updateDirector(director);
			redirectAttributes.addFlashAttribute("message",
					"Director Updated Successfully..");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/director/delete/{id}", method = RequestMethod.GET)
	public String deleteDirector(@PathVariable int id,
			final RedirectAttributes redirectAttributes) {
		
		try {
			directorDAO.deleteDirector(directorDAO.getDirector(id));
			redirectAttributes.addFlashAttribute("message",
					"Director Deleted Successfully..");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "redirect:/home";
	}

}
