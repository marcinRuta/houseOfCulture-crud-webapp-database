package bdbt_proj;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

		if (daoLogin.porwnajP(login)) {
			wybuchy = login.getLogin();
			return "redirect:/v/tables";
		} else {
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

		if (daoLogin.porwnajA(login)) {
			return "redirect:/tables";
		} else {
			return "redirect:/logErr";
		}
	}

	@RequestMapping("logErr")
	public String Error() {
		return "logError";
	}

	@RequestMapping("/saveErr")
	public String viewSaveError() {
		return "cannotSave";
	}

	@RequestMapping("/delErr")
	public String viewDeleteError() {
		return "cannotDelete";
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
	public String save(@Valid @ModelAttribute("NowyDom") Domy_kultury NowyDom, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoDomyKultury.save(NowyDom);
			return "redirect:/DK";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("/editDK/{ID_Domu}")
	public ModelAndView showEditFormDomy(@PathVariable(name = "ID_Domu") int id) {
		ModelAndView mav = new ModelAndView("edit_form_domy");
		Domy_kultury EditDomy = daoDomyKultury.get(id);
		mav.addObject("EditDomy", EditDomy);

		return mav;
	}

	@RequestMapping(value = "/updateDK", method = RequestMethod.POST)
	public String updateDomy(@Valid @ModelAttribute("EditDomy") Domy_kultury domy_kultury,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoDomyKultury.update(domy_kultury);

			return "redirect:/DK";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteDK/{ID_Domu}")
	public String deleteDomy(@PathVariable(name = "ID_Domu") int id) {
		try {
			daoDomyKultury.delete(id);

			return "redirect:/DK";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
	}

	/* Pracownicy */
	@RequestMapping("/P")
	public String viewPracownicy(Model model) {
		List<Pracownicy> listPracownicy = daoPracownicy.list();
		model.addAttribute("listPracownicy", listPracownicy);
		return "pracownicy";
	}
	
	@RequestMapping("/RefreshPNazw")
	public String viewPracownicyByNazw(Model model) {
		List<Pracownicy> listPracownicy = daoPracownicy.listSortedByNazw();
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
	public String save(@Valid @ModelAttribute("NowyPracownik") Pracownicy NowyPracownik, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoPracownicy.save(NowyPracownik);
			return "redirect:/P";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("/editP/{ID_Pracownika}")
	public ModelAndView showEditFormPracownicy(@PathVariable(name = "ID_Pracownika") int id) {
		ModelAndView mav = new ModelAndView("edit_form_pracownicy");
		Pracownicy EditPracownicy = daoPracownicy.get(id);
		mav.addObject("EditPracownicy", EditPracownicy);

		return mav;
	}

	@RequestMapping(value = "/updateP", method = RequestMethod.POST)
	public String updatePracownicy(@Valid @ModelAttribute("EditPracownicy") Pracownicy pracownicy,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoPracownicy.update(pracownicy);
			return "redirect:/P";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteP/{ID_Pracownika}")
	public String deletePracownicy(@PathVariable(name = "ID_Pracownika") int id) {
		try {
			daoPracownicy.delete(id);
			return "redirect:/P";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
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
	public String save(@Valid @ModelAttribute("NowyAdres") Adresy NowyAdres, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoAdresy.save(NowyAdres);
			return "redirect:/A";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("/editA/{ID_Adresu}")
	public ModelAndView showEditFormAdresy(@PathVariable(name = "ID_Adresu") int id) {
		ModelAndView mav = new ModelAndView("edit_form_adresy");
		Adresy EditAdresy = daoAdresy.get(id);
		mav.addObject("EditAdresy", EditAdresy);

		return mav;
	}

	@RequestMapping(value = "/updateA", method = RequestMethod.POST)
	public String updateAdresy(@Valid @ModelAttribute("EditAdresy") Adresy adresy, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoAdresy.update(adresy);

			return "redirect:/A";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteA/{ID_Adresu}")
	public String deleteAdresy(@PathVariable(name = "ID_Adresu") int id) {
		try {
			daoAdresy.delete(id);
			return "redirect:/A";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
	}

	/* Wynagrodzenia */
	@RequestMapping("/WYN")
	public String viewWynagrodzenia(Model model) {
		List<Wynagrodzenia> listWynagrodzenia = daoWynagrodzenia.list();
		model.addAttribute("listWynagrodzenia", listWynagrodzenia);
		return "wynagrodzenia";
	}
	
	@RequestMapping("/RefreshWynPrac")
	public String viewWynagrodzeniaSortedByPrac(Model model) {
		List<Wynagrodzenia> listWynagrodzenia = daoWynagrodzenia.listSortedByPrac();
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
	public String save(@Valid @ModelAttribute("NoweWynagrodzenie") Wynagrodzenia NoweWynagrodzenie,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoWynagrodzenia.save(NoweWynagrodzenie);
			return "redirect:/WYN";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("/editWYN/{ID_Wynagrodzenia}")
	public ModelAndView showEditFormWynagrodzenia(@PathVariable(name = "ID_Wynagrodzenia") int id) {
		ModelAndView mav = new ModelAndView("edit_form_wynagrodzenia");
		Wynagrodzenia EditWynagrodzenia = daoWynagrodzenia.get(id);
		mav.addObject("EditWynagrodzenia", EditWynagrodzenia);
		return mav;

	}

	@RequestMapping(value = "/updateWYN", method = RequestMethod.POST)
	public String updateWynagrodzenia(@Valid @ModelAttribute("EditWynagrodzenia") Wynagrodzenia wynagrodzenia,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoWynagrodzenia.update(wynagrodzenia);

			return "redirect:/WYN";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteWYN/{ID_Wynagrodzenia}")
	public String deleteWynagrodzenia(@PathVariable(name = "ID_Wynagrodzenia") int id) {
		try {
			daoWynagrodzenia.delete(id);
			return "redirect:/WYN";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
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
			@Valid @ModelAttribute("NoweObslugiwanie_wydarzenia") Obslugiwanie_wydarzenia NoweObslugiwanie_wydarzenia,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoObslugiwanie_wydarzenia.save(NoweObslugiwanie_wydarzenia);
			return "redirect:/OW";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteOW/{ID_Pracownika}/{id_realizacji_wydarzenia}")
	public String deleteObslugiWydarzenia(@PathVariable(name = "ID_Pracownika") int id1,
			@PathVariable(name = "id_realizacji_wydarzenia") int id2) {
		try {
			daoObslugiwanie_wydarzenia.delete(id1, id2);

			return "redirect:/OW";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
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
	public String save(@Valid @ModelAttribute("NoweWydarzenia") Wydarzenia NoweWydarzenia,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoWydarzenia.save(NoweWydarzenia);
			return "redirect:/W";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("/editW/{ID_Wydarzenia}")
	public ModelAndView showEditFormWydarzenia(@PathVariable(name = "ID_Wydarzenia") int id) {
		ModelAndView mav = new ModelAndView("edit_form_wydarzenia");
		Wydarzenia EditWydarzenia = daoWydarzenia.get(id);
		mav.addObject("EditWydarzenia", EditWydarzenia);

		return mav;
	}

	@RequestMapping(value = "/updateW", method = RequestMethod.POST)
	public String updateWydarzenia(@Valid @ModelAttribute("EditWydarzenia") Wydarzenia wydarzenia,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoWydarzenia.update(wydarzenia);

			return "redirect:/W";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteW/{ID_Wydarzenia}")
	public String deleteWydarzenia(@PathVariable(name = "ID_Wydarzenia") int id) {
		try {
			daoWydarzenia.delete(id);

			return "redirect:/W";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
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
	public String save(@Valid @ModelAttribute("NowaRealizacja_wydarzenia") Realizacje_wydarzen NowaRealizacja_wydarzen,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoRealizacje_wydarzen.save(NowaRealizacja_wydarzen);
			return "redirect:/RW";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("/editRW/{ID_Realizacji_Wydarzenia}")
	public ModelAndView showEditFormRealizacje(@PathVariable(name = "ID_Realizacji_Wydarzenia") int id) {
		ModelAndView mav = new ModelAndView("edit_form_realizacje");
		Realizacje_wydarzen EditRealizacje = daoRealizacje_wydarzen.get(id);
		mav.addObject("EditRealizacje", EditRealizacje);

		return mav;
	}

	@RequestMapping(value = "/updateRW", method = RequestMethod.POST)
	public String updateRealizacje(@Valid @ModelAttribute("EditRealizacje") Realizacje_wydarzen Realizacje_wydarzen,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoRealizacje_wydarzen.update(Realizacje_wydarzen);

			return "redirect:/RW";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteRW/{ID_Realizacji_Wydarzenia}")
	public String deleteRealizacje(@PathVariable(name = "ID_Realizacji_Wydarzenia") int id) {
		try {
			daoRealizacje_wydarzen.delete(id);

			return "redirect:/RW";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
	}

	/* Uczestnicy */
	@RequestMapping("/U")
	public String viewUczestnicy(Model model) {
		List<Uczestnicy> listUczestnicy = daoUczestnicy.list();
		model.addAttribute("listUczestnicy", listUczestnicy);
		return "uczestnicy";
	}
	
	@RequestMapping("/RefreshUNazw")
	public String viewUczestnicySortedByNazw(Model model) {
		List<Uczestnicy> listUczestnicy = daoUczestnicy.listSortedByNazw();
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
	public String save(@Valid @ModelAttribute("NowyUczestnik") Uczestnicy NowyUczestnik, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoUczestnicy.save(NowyUczestnik);
			return "redirect:/U";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("/editU/{ID_Uczestnika}")
	public ModelAndView showEditFormUczestnika(@PathVariable(name = "ID_Uczestnika") int id) {
		ModelAndView mav = new ModelAndView("edit_form_uczestnicy");
		Uczestnicy EditUczestnicy = daoUczestnicy.get(id);
		mav.addObject("EditUczestnicy", EditUczestnicy);

		return mav;
	}

	@RequestMapping(value = "/updateU", method = RequestMethod.POST)
	public String updateUczestnicy(@Valid @ModelAttribute("EditUczestnicy") Uczestnicy uczestnicy,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}

		try {
			daoUczestnicy.update(uczestnicy);

			return "redirect:/U";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteU/{ID_Uczestnika}")
	public String deleteUczestnicy(@PathVariable(name = "ID_Uczestnika") int id) {
		try {
			daoUczestnicy.delete(id);

			return "redirect:/U";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
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
	public String save(@Valid @ModelAttribute("NowyZapis_na_wydarzenie") Zapisy_na_wydarzenie NowyZapis_na_wydarzenie,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "redirect:/saveErr";
		}
		try {
			daoZapisy_na_wydarzenie.save(NowyZapis_na_wydarzenie);
			return "redirect:/ZNW";
		} catch (Exception e) {
			return "redirect:/saveErr";
		}

	}

	@RequestMapping("deleteZNW/{ID_Uczestnika}/{ID_Realizacji_Wydarzenia}")
	public String deleteZapisyNaWydarzenie(@PathVariable(name = "ID_Uczestnika") int id1,
			@PathVariable(name = "ID_Realizacji_Wydarzenia") int id2) {
		try {
			daoZapisy_na_wydarzenie.delete(id1, id2);

			return "redirect:/ZNW";
		} catch (DataIntegrityViolationException e) {
			return "redirect:/delErr";
		}
	}
}
