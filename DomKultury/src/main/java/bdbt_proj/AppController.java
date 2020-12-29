package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	  
	@Autowired
	private Domy_kulturyDAO daoDomyKultury;
	@Autowired
	private PracownicyDAO daoPracownicy;
	
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	/* Dom kultury */
	@RequestMapping("/DK")
	public String viewDomyKultury(Model model) {
		List<Domy_kultury> listDomy = daoDomyKultury.list();
		model.addAttribute("listDomy", listDomy);
		return "domy_kultury";
	}
	
	@RequestMapping("/newDK")
	public String showNewDomyKultury(Model model) {
		
		Domy_kultury NowyDom = new Domy_kultury();
		model.addAttribute("NowyDom", NowyDom);
		return "new_domy_kultury";
	}
	
	@RequestMapping(value = "/saveDK", method = RequestMethod.POST)
	public String save(@ModelAttribute("NowyDom") Domy_kultury NowyDom) {
		
		daoDomyKultury.save(NowyDom);
		return "redirect:/DK";
	}
	
	/* Pracownicy */
	@RequestMapping("/P")
	public String viewPracownicy(Model model) {
		List<Pracownicy> listPracownicy = daoPracownicy.list(); //wywala nulla xD
		model.addAttribute("listPracownicy", listPracownicy);
		return "pracownicy";
	}
	
	@RequestMapping("/newP")
	public String showNewPracownicy(Model model) {
		
		Pracownicy NowyPracownik = new Pracownicy();
		model.addAttribute("NowyPracownik", NowyPracownik);
		return "new_pracownicy";
	}
	
	@RequestMapping(value = "/saveP", method = RequestMethod.POST)
	public String save(@ModelAttribute("NowyPracownik") Pracownicy NowyPracownik) {
		
		daoPracownicy.save(NowyPracownik);
		return "redirect:/P";
	}
	
}
