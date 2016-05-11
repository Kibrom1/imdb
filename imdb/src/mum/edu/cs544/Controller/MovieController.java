package mum.edu.cs544.Controller;

import javax.annotation.Resource;

import mum.edu.cs544.Domain.Movie;
import mum.edu.cs544.Model.ActorDAO;
import mum.edu.cs544.Model.DirectorDAO;
import mum.edu.cs544.Model.MovieDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MovieController {

	@Resource
	private ActorDAO actorDAO;

	@Resource
	private DirectorDAO directorDAO;

	@Resource
	private MovieDAO movieDAO;

	@RequestMapping("/")
	public String redirectRoot() {

		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) throws Exception {

		try {
			model.addAttribute("movies", movieDAO.getAllMovie());
			model.addAttribute("artists", actorDAO.getAllActors());
			model.addAttribute("directors", directorDAO.getAllDirectors());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "index";
	}

	@RequestMapping(value = "/movie/add", method = RequestMethod.GET)
	public String addMovie(Model model) {

		Movie movie = new Movie();
		try {
			model.addAttribute("movie", movie);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "addMovie";
	}

	@RequestMapping(value = "/movie/add", method = RequestMethod.POST)
	public String saveMovie(@ModelAttribute("movie") Movie movie,
			BindingResult result, Model model) {

		try {
			movieDAO.addMovie(movie);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return "redirect:/home";
	}

	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(Model model, @PathVariable int id,
			final RedirectAttributes redirectAttributes) {

		try {
			movieDAO.deleteMovie(movieDAO.getMovie(id));
			redirectAttributes.addFlashAttribute("message",
					"Movie Deleted Successfully..");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/movie/edit/update/{id}", method = RequestMethod.POST)
	public String updateMovie(@PathVariable int id,
			@ModelAttribute("movie") Movie movie, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {
		try {
			movie.setId(id);
			movieDAO.updateMovie(movie);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			
		}

		redirectAttributes.addFlashAttribute("message",
				"Movie Updated Successfully..");
		return "redirect:/home";
	}
}
