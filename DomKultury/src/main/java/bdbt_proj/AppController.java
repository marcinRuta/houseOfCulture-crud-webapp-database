package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	private String wybuchy = "1";
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
	@Autowired
	private WydarzeniaDAO daoWydarzenia;
	@Autowired
	private Realizacje_wydarzenDAO daoRealizacje_wydarzen;
	@Autowired
	private UczestnicyDAO daoUczestnicy;
	@Autowired
	private Zapisy_na_wydarzenieDAO daoZapisy_na_wydarzenie;

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@RequestMapping("/LP")
	public String viewLoginPPage(Model model) {
		
		Login login = new Login();
		model.addAttribute(login);
		
		return "loginP";
	}

	@RequestMapping(value = "/logP", method = RequestMethod.POST)
	public String probaLogowaniaP(@ModelAttribute("login") Login login) {
		
		LoginDao daoLogin = new LoginDao();
		
		if(daoLogin.porwnajP(login)) {
			wybuchy = login.getLogin();
			return "redirect:/v/tables";
		}else {
			return "redirect:/logErr";
		}
	}
	
	@RequestMapping("/LA")
	public String viewLoginAPage(Model model) {
		
		Login login = new Login();
		model.addAttribute(login);
		
		return "LoginA";
	}

	@RequestMapping(value = "/logA", method = RequestMethod.POST)
	public String probaLogowaniaA(@ModelAttribute("login") Login login) {
		
		LoginDao daoLogin = new LoginDao();
		
		if(daoLogin.porwnajA(login)) {
			return "redirect:/tables";
		}else {
			return "redirect:/logErr";
		}
	}

	@RequestMapping("logErr")
	public String Error() {
		return "logError";
	}
	
	@RequestMapping("/tables")
	public String viewTablesPage() {
		return "tables";
	}
	
	@RequestMapping("/v/tables")
	public String viewPTablesPage() {
		return "ptables";
	}

	/* Dom kultury */
	@RequestMapping("/DK")
	public String viewDomyKultury(Model model) {
		List<Domy_kultury> listDomy = daoDomyKultury.list();
		model.addAttribute("listDomy", listDomy);
		return "domy_kultury";
	}
	
	@RequestMapping("/v/DK")
	public String viewPDomyKultury(Model model) {
		List<Domy_kultury> plistDomy = daoDomyKultury.plist(wybuchy);
		model.addAttribute("plistDomy", plistDomy);
		return "pdomy_kultury";
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

	@RequestMapping("/editDK/{ID_Domu}")
	public ModelAndView showEditFormDomy(@PathVariable(name = "ID_Domu") int id) {
		ModelAndView mav = new ModelAndView("edit_form_domy");
		Domy_kultury EditDomy = daoDomyKultury.get(id);
		mav.addObject("EditDomy", EditDomy);

		return mav;
	}

	@RequestMapping(value = "/updateDK", method = RequestMethod.POST)
	public String updateDomy(@ModelAttribute("EditDomy") Domy_kultury domy_kultury) {
		daoDomyKultury.update(domy_kultury);

		return "redirect:/DK";
	}

	@RequestMapping("deleteDK/{ID_Domu}")
	public String deleteDomy(@PathVariable(name = "ID_Domu") int id) {
		daoDomyKultury.delete(id);

		return "redirect:/DK";
	}

	/* Pracownicy */
	@RequestMapping("/P")
	public String viewPracownicy(Model model) {
		List<Pracownicy> listPracownicy = daoPracownicy.list();
		model.addAttribute("listPracownicy", listPracownicy);
		return "pracownicy";
	}
	
	@RequestMapping("/v/P")
	public String viewPPracownicy(Model model) {
		List<Pracownicy> plistPracownicy = daoPracownicy.plist(wybuchy);
		model.addAttribute("plistPracownicy", plistPracownicy);
		return "ppracownicy";
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
	
	@RequestMapping("/editP/{ID_Pracownika}")
	public ModelAndView showEditFormPracownicy(@PathVariable(name = "ID_Pracownika") int id) {
		ModelAndView mav = new ModelAndView("edit_form_pracownicy");
		Pracownicy EditPracownicy = daoPracownicy.get(id);
		mav.addObject("EditPracownicy", EditPracownicy);

		return mav;
	}

	@RequestMapping(value = "/updateP", method = RequestMethod.POST)
	public String updatePracownicy(@ModelAttribute("EditPracownicy") Pracownicy pracownicy) {
		daoPracownicy.update(pracownicy);

		return "redirect:/P";
	}

	@RequestMapping("deleteP/{ID_Pracownika}")
	public String deletePracownicy(@PathVariable(name = "ID_Pracownika") int id) {
		daoPracownicy.delete(id);

		return "redirect:/P";
	}

	

	/* Adresy */
	@RequestMapping("/A")
	public String viewAdresy(Model model) {
		List<Adresy> listAdresy = daoAdresy.list();
		model.addAttribute("listAdresy", listAdresy);
		return "adresy";
	}
	
	@RequestMapping("/v/A")
	public String viewPAdresy(Model model) {
		List<Adresy> plistAdresy = daoAdresy.plist(wybuchy);
		model.addAttribute("plistAdresy", plistAdresy);
		return "padresy";
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
	
	@RequestMapping("/editA/{ID_Adresu}")
	public ModelAndView showEditFormAdresy(@PathVariable(name = "ID_Adresu") int id) {
		ModelAndView mav = new ModelAndView("edit_form_adresy");
		Adresy EditAdresy = daoAdresy.get(id);
		mav.addObject("EditAdresy", EditAdresy);

		return mav;
	}

	@RequestMapping(value = "/updateA", method = RequestMethod.POST)
	public String updateAdresy(@ModelAttribute("EditAdresy") Adresy adresy) {
		daoAdresy.update(adresy);

		return "redirect:/A";
	}

	@RequestMapping("deleteA/{ID_Adresu}")
	public String deleteAdresy(@PathVariable(name = "ID_Adresu") int id) {
		daoAdresy.delete(id);

		return "redirect:/A";
	}


	/* Wynagrodzenia */
	@RequestMapping("/WYN")
	public String viewWynagrodzenia(Model model) {
		List<Wynagrodzenia> listWynagrodzenia = daoWynagrodzenia.list();
		model.addAttribute("listWynagrodzenia", listWynagrodzenia);
		return "wynagrodzenia";
	}
	
	@RequestMapping("/v/WYN")
	public String viewPWynagrodzenia(Model model) {
		List<Wynagrodzenia> plistWynagrodzenia = daoWynagrodzenia.plist(wybuchy);
		model.addAttribute("plistWynagrodzenia", plistWynagrodzenia);
		return "pwynagrodzenia";
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
	
	@RequestMapping("/editWYN/{ID_Wynagrodzenia}")
	public ModelAndView showEditFormWynagrodzenia(@PathVariable(name = "ID_Wynagrodzenia") int id) {
		ModelAndView mav = new ModelAndView("edit_form_wynagrodzenia");
		Wynagrodzenia EditWynagrodzenia = daoWynagrodzenia.get(id);
		mav.addObject("EditWynagrodzenia", EditWynagrodzenia);
		return mav;
		
	}
	@RequestMapping(value = "/updateWYN", method = RequestMethod.POST)
	public String updateWynagrodzenia(@ModelAttribute("EditWynagrodzenia") Wynagrodzenia wynagrodzenia) {
		daoWynagrodzenia.update(wynagrodzenia);

		return "redirect:/WYN";
	}

	@RequestMapping("deleteWYN/{ID_Wynagrodzenia}")
	public String deleteWynagrodzenia(@PathVariable(name = "ID_Wynagrodzenia") int id) {
		daoWynagrodzenia.delete(id);

		return "redirect:/WYN";
	}



	/* Obslugiwanie_wydarzenia */
	@RequestMapping("/OW")
	public String viewObslugiwanie_wydarzenia(Model model) {
		List<Obslugiwanie_wydarzenia> listObslugiwanie_wydarzenia = daoObslugiwanie_wydarzenia.list();
		model.addAttribute("listObslugiwanie_wydarzenia", listObslugiwanie_wydarzenia);
		return "Obslugiwanie_wydarzenia";
	}
	
	@RequestMapping("/v/OW")
	public String viewPObslugiwanie_wydarzenia(Model model) {
		List<Obslugiwanie_wydarzenia> plistObslugiwanie_wydarzenia = daoObslugiwanie_wydarzenia.plist(wybuchy);
		model.addAttribute("plistObslugiwanie_wydarzenia", plistObslugiwanie_wydarzenia);
		return "pObslugiwanie_wydarzenia";
	}

	@RequestMapping("/newOW")
	public String showNewObslugiwanie_wydarzenia(Model model) {

		Obslugiwanie_wydarzenia NoweObslugiwanie_wydarzenia = new Obslugiwanie_wydarzenia();
		model.addAttribute("NoweObslugiwanie_wydarzenia", NoweObslugiwanie_wydarzenia);
		return "new_obslugiwanie_wydarzenia";
	}

	@RequestMapping(value = "/saveOW", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("NoweObslugiwanie_wydarzenia") Obslugiwanie_wydarzenia NoweObslugiwanie_wydarzenia) {

		daoObslugiwanie_wydarzenia.save(NoweObslugiwanie_wydarzenia);
		return "redirect:/OW";
	}
	
	@RequestMapping("deleteOW/{ID_Pracownika}/{id_realizacji_wydarzenia}")
	public String deleteObslugiWydarzenia(@PathVariable(name = "ID_Pracownika") int id1, @PathVariable(name = "id_realizacji_wydarzenia") int id2) {
		daoObslugiwanie_wydarzenia.delete(id1, id2);

		return "redirect:/OW";
	}


	/* Wydarzenia */

	@RequestMapping("/W")
	public String viewWydarzenia(Model model) {
		List<Wydarzenia> listWydarzenia = daoWydarzenia.list();
		model.addAttribute("listWydarzenia", listWydarzenia);
		return "Wydarzenia";
	}
	
	@RequestMapping("/v/W")
	public String viewPWydarzenia(Model model) {
		List<Wydarzenia> plistWydarzenia = daoWydarzenia.plist(wybuchy);
		model.addAttribute("plistWydarzenia", plistWydarzenia);
		return "pWydarzenia";
	}

	@RequestMapping("/newW")
	public String showNewWydarzenia(Model model) {

		Wydarzenia NoweWydarzenia = new Wydarzenia();
		model.addAttribute("NoweWydarzenia", NoweWydarzenia);
		return "new_Wydarzenia";
	}

	@RequestMapping(value = "/saveW", method = RequestMethod.POST)
	public String save(@ModelAttribute("NoweWydarzenia") Wydarzenia NoweWydarzenia) {

		daoWydarzenia.save(NoweWydarzenia);
		return "redirect:/W";
	}
	
	@RequestMapping("/editW/{ID_Wydarzenia}")
	public ModelAndView showEditFormWydarzenia(@PathVariable(name = "ID_Wydarzenia") int id) {
		ModelAndView mav = new ModelAndView("edit_form_wydarzenia");
		Wydarzenia EditWydarzenia = daoWydarzenia.get(id);
		mav.addObject("EditWydarzenia", EditWydarzenia);

		return mav;
	}

	@RequestMapping(value = "/updateW", method = RequestMethod.POST)
	public String updateWydarzenia(@ModelAttribute("EditWydarzenia") Wydarzenia wydarzenia) {
		daoWydarzenia.update(wydarzenia);

		return "redirect:/W";
	}

	@RequestMapping("deleteW/{ID_Wydarzenia}")
	public String deleteWydarzenia(@PathVariable(name = "ID_Wydarzenia") int id) {
		daoWydarzenia.delete(id);

		return "redirect:/W";
	}

	/* Realizacja_wydarzen */
	@RequestMapping("/RW")
	public String viewRealizacja_wydarzen(Model model) {
		List<Realizacje_wydarzen> listRealizacje_wydarzen = daoRealizacje_wydarzen.list();
		model.addAttribute("listRealizacje_wydarzen", listRealizacje_wydarzen);
		return "realizacje_wydarzen";
	}
	
	@RequestMapping("/v/RW")
	public String viewPRealizacja_wydarzen(Model model) {
		List<Realizacje_wydarzen> plistRealizacje_wydarzen = daoRealizacje_wydarzen.plist(wybuchy);
		model.addAttribute("plistRealizacje_wydarzen", plistRealizacje_wydarzen);
		return "prealizacje_wydarzen";
	}
	
	@RequestMapping("/v/RW/{ID_Realizacji_Wydarzenia}")
	public String showPRWwithU(Model model, @PathVariable(name = "ID_Realizacji_Wydarzenia") int id) {
		
		List<Uczestnicy> pulistUczestnicy = daoUczestnicy.pulist(wybuchy, id);
		model.addAttribute("pulistUczestnicy", pulistUczestnicy);
		
		return "prealizacje_wydarzen_with_u";
	}

	@RequestMapping("/newRW")
	public String showNewRealizacje_wydarzen(Model model) {

		Realizacje_wydarzen NowaRealizacja_wydarzenia = new Realizacje_wydarzen();
		model.addAttribute("NowaRelizacja_wydarzenia", NowaRealizacja_wydarzenia);
		return "new_realizacje_wydarzen";
	}

	@RequestMapping(value = "/saveRW", method = RequestMethod.POST)
	public String save(@ModelAttribute("NowaRealizacja_wydarzenia") Realizacje_wydarzen NowaRealizacja_wydarzen) {

		daoRealizacje_wydarzen.save(NowaRealizacja_wydarzen);
		return "redirect:/RW";
	}
	
	@RequestMapping("/editRW/{ID_Realizacji_Wydarzenia}")
	public ModelAndView showEditFormRealizacje(@PathVariable(name = "ID_Realizacji_Wydarzenia") int id) {
		ModelAndView mav = new ModelAndView("edit_form_realizacje");
		Realizacje_wydarzen EditRealizacje = daoRealizacje_wydarzen.get(id);
		mav.addObject("EditRealizacje", EditRealizacje);

		return mav;
	}

	@RequestMapping(value = "/updateRW", method = RequestMethod.POST)
	public String updateRealizacje(@ModelAttribute("EditRealizacje") Realizacje_wydarzen Realizacje_wydarzen) {
		daoRealizacje_wydarzen.update(Realizacje_wydarzen);

		return "redirect:/RW";
	}

	@RequestMapping("deleteRW/{ID_Realizacji_Wydarzenia}")
	public String deleteRealizacje(@PathVariable(name = "ID_Realizacji_Wydarzenia") int id) {
		daoRealizacje_wydarzen.delete(id);

		return "redirect:/RW";
	}

	/* Uczestnicy */
	@RequestMapping("/U")
	public String viewUczestnicy(Model model) {
		List<Uczestnicy> listUczestnicy = daoUczestnicy.list();
		model.addAttribute("listUczestnicy", listUczestnicy);
		return "uczestnicy";
	}
	
	@RequestMapping("/v/U")
	public String viewPUczestnicy(Model model) {
		List<Uczestnicy> plistUczestnicy = daoUczestnicy.plist(wybuchy);
		model.addAttribute("plistUczestnicy", plistUczestnicy);
		return "puczestnicy";
	}

	@RequestMapping("/newU")
	public String showNewUczestnicy(Model model) {

		Uczestnicy NowyUczestnik = new Uczestnicy();
		model.addAttribute("NowyUczestnik", NowyUczestnik);
		return "new_uczestnicy";
	}

	@RequestMapping(value = "/saveU", method = RequestMethod.POST)
	public String save(@ModelAttribute("NowyUczestnik") Uczestnicy NowyUczestnik) {

		daoUczestnicy.save(NowyUczestnik);
		return "redirect:/U";

	}
	@RequestMapping("/editU/{ID_Uczestnika}")
	public ModelAndView showEditFormUczestnika(@PathVariable(name = "ID_Uczestnika") int id) {
		ModelAndView mav = new ModelAndView("edit_form_uczestnicy");
		Uczestnicy EditUczestnicy = daoUczestnicy.get(id);
		mav.addObject("EditUczestnicy", EditUczestnicy);

		return mav;
	}

	@RequestMapping(value = "/updateU", method = RequestMethod.POST)
	public String updateUczestnicy(@ModelAttribute("EditUczestnicy") Uczestnicy uczestnicy) {
		daoUczestnicy.update(uczestnicy);

		return "redirect:/U";
	}

	@RequestMapping("deleteU/{ID_Uczestnika}")
	public String deleteUczestnicy(@PathVariable(name = "ID_Uczestnika") int id) {
		daoUczestnicy.delete(id);

		return "redirect:/U";
	}


	/* Zapisy_na_Wydarzenie */
	@RequestMapping("/ZNW")
	public String viewZapisy_na_wydarzenie(Model model) {
		List<Zapisy_na_wydarzenie> listZapisy_na_wydarzenie = daoZapisy_na_wydarzenie.list();
		model.addAttribute("listZapisy_na_wydarzenie", listZapisy_na_wydarzenie);
		return "zapisy_na_wydarzenie";
	}

	@RequestMapping("/newZNW")
	public String showNewZapisy_na_wydarzenie(Model model) {

		Zapisy_na_wydarzenie NowyZapis_na_wydarzenie = new Zapisy_na_wydarzenie();
		model.addAttribute("NowyZapis_na_wydarzenie", NowyZapis_na_wydarzenie);
		return "new_zapisy_na_wydarzenie";
	}

	@RequestMapping(value = "/saveZNW", method = RequestMethod.POST)
	public String save(@ModelAttribute("NowyZapis_na_wydarzenie") Zapisy_na_wydarzenie NowyZapis_na_wydarzenie) {

		daoZapisy_na_wydarzenie.save(NowyZapis_na_wydarzenie);
		return "redirect:/ZNW";
	
	}
	@RequestMapping("deleteZNW/{ID_Uczestnika}/{ID_Realizacji_Wydarzenia}")
	public String deleteZapisyNaWydarzenie(@PathVariable(name = "ID_Uczestnika") int id1, @PathVariable(name = "ID_Realizacji_Wydarzenia") int id2) {
		daoZapisy_na_wydarzenie.delete(id1, id2);

		return "redirect:/ZNW";
	}
}
