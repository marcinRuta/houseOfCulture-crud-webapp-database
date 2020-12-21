package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	  
	@Autowired
	private Domy_kulturyDAO dao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		List<Domy_kultury> listDomy = dao.list();
		model.addAttribute("listDomy", listDomy);
		return "index";
	}

}
