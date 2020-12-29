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
	@Autowired
	private AdresyDAO daoAdresy;
	@Autowired
	private WynagrodzeniaDAO daoWynagrodzenia;
	@Autowired
	private Obslugiwanie_wydarzeniaDAO daoObslugiwanie_wydarzenia;
	
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
		List<Pracownicy> listPracownicy = daoPracownicy.list();
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
	
	/* Adresy */
	@RequestMapping("/A")
	public String viewAdresy(Model model) {
		List<Adresy> listAdresy = daoAdresy.list();
		model.addAttribute("listAdresy", listAdresy);
		return "adresy";
	}
	
	@RequestMapping("/newA")
	public String showNewAdresy(Model model) {
		
		Adresy NowyAdres = new Adresy();
		model.addAttribute("NowyAdres", NowyAdres);
		return "new_adresy";
	}
	
	@RequestMapping(value = "/saveA", method = RequestMethod.POST)
	public String save(@ModelAttribute("NowyAdres") Adresy NowyAdres) {
		
		daoAdresy.save(NowyAdres);
		return "redirect:/A";
	}
	
	/* Wynagrodzenia */
	@RequestMapping("/WYN")
	public String viewWynagrodzenia(Model model) {
		List<Wynagrodzenia> listWynagrodzenia = daoWynagrodzenia.list();
		model.addAttribute("listWynagrodzenia", listWynagrodzenia);
		return "wynagrodzenia";
	}
	
	@RequestMapping("/newWYN")
	public String showNewWynagrodzenie(Model model) {
		
		Wynagrodzenia NoweWynagrodzenie = new Wynagrodzenia();
		model.addAttribute("NoweWynagrodzenie", NoweWynagrodzenie);
		return "new_wynagrodzenia";
	}
	
	@RequestMapping(value = "/saveWYN", method = RequestMethod.POST)
	public String save(@ModelAttribute("NoweWynagrodzenie") Wynagrodzenia NoweWynagrodzenie) {
		
		daoWynagrodzenia.save(NoweWynagrodzenie);
		return "redirect:/WYN";
	}
	
	/* Obslugiwanie_wydarzenia */
	@RequestMapping("/OW")
	public String viewObslugiwanie_wydarzenia(Model model) {
		List<Obslugiwanie_wydarzenia> listObslugiwanie_wydarzenia = daoObslugiwanie_wydarzenia.list();
		model.addAttribute("listObslugiwanie_wydarzenia", listObslugiwanie_wydarzenia);
		return "Obslugiwanie_wydarzenia";
	}
	
	@RequestMapping("/newOW")
	public String showNewObslugiwanie_wydarzenia(Model model) {
		
		Obslugiwanie_wydarzenia NoweObslugiwanie_wydarzenia = new Obslugiwanie_wydarzenia();
		model.addAttribute("NoweObslugiwanie_wydarzenia", NoweObslugiwanie_wydarzenia);
		return "new_obslugiwanie_wydarzenia";
	}
	
	@RequestMapping(value = "/saveOW", method = RequestMethod.POST)
	public String save(@ModelAttribute("NoweObslugiwanie_wydarzenia") Obslugiwanie_wydarzenia NoweObslugiwanie_wydarzenia) {
		
		daoObslugiwanie_wydarzenia.save(NoweObslugiwanie_wydarzenia);
		return "redirect:/OW";
	}
}
