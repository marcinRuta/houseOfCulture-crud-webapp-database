package bdbt_proj;

import java.sql.Date;

public class Pracownicy {
	
	/* Fields */
	private int ID_Pracownika;
	private String Imie;
	private String Nazwisko;
	private Date Data_urodzenia;
	private String PESEL;
	private String NR_Telefonu;
	private String Email;
	private String Plec;
	private Date Data_Zatrudnienia; 
	private Date Data_Zwolnienia;
	private int ID_Domu;
	private int ID_Adresu;
	private int ID_Stanowiska;
	
	
	
	/* Constructor from superclass */
	public Pracownicy() {
		
	}


	/* Constructor with fields*/
	public Pracownicy(int iD_Pracownika, String imie, String nazwisko, Date data_urodzenia, String pESEL,
			String nR_Telefonu, String email, String plec, Date data_Zatrudnienia, Date data_Zwolnienia,
			int iD_Domu, int iD_Adresu, int iD_Stanowiska) {
		super();
		this.ID_Pracownika = iD_Pracownika;
		this.Imie = imie;
		this.Nazwisko = nazwisko;
		this.Data_urodzenia = data_urodzenia;
		this.PESEL = pESEL;
		this.NR_Telefonu = nR_Telefonu;
		this.Email = email;
		this.Plec = plec;
		this.Data_Zatrudnienia = data_Zatrudnienia;
		this.Data_Zwolnienia = data_Zwolnienia;
		this.ID_Domu = iD_Domu;
		this.ID_Adresu = iD_Adresu;
		this.ID_Stanowiska = iD_Stanowiska;
	}

	/* Getters and setters */

	public int getID_Pracownika() {
		return ID_Pracownika;
	}



	public void setID_Pracownika(int iD_Pracownika) {
		ID_Pracownika = iD_Pracownika;
	}



	public String getImie() {
		return Imie;
	}



	public void setImie(String imie) {
		Imie = imie;
	}



	public String getNazwisko() {
		return Nazwisko;
	}



	public void setNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}



	public Date getData_urodzenia() {
		return Data_urodzenia;
	}



	public void setData_urodzenia(Date data_urodzenia) {
		Data_urodzenia = data_urodzenia;
	}



	public String getPESEL() {
		return PESEL;
	}



	public void setPESEL(String pESEL) {
		PESEL = pESEL;
	}



	public String getNR_Telefonu() {
		return NR_Telefonu;
	}



	public void setNR_Telefonu(String nR_Telefonu) {
		NR_Telefonu = nR_Telefonu;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public String getPlec() {
		return Plec;
	}



	public void setPlec(String plec) {
		Plec = plec;
	}



	public Date getData_Zatrudnienia() {
		return Data_Zatrudnienia;
	}



	public void setData_Zatrudnienia(Date data_Zatrudnienia) {
		Data_Zatrudnienia = data_Zatrudnienia;
	}



	public Date getData_Zwolnienia() {
		return Data_Zwolnienia;
	}



	public void setData_Zwolnienia(Date data_Zwolnienia) {
		Data_Zwolnienia = data_Zwolnienia;
	}


	public int getID_Domu() {
		return ID_Domu;
	}



	public void setID_Domu(int iD_Domu) {
		ID_Domu = iD_Domu;
	}



	public int getID_Adresu() {
		return ID_Adresu;
	}



	public void setID_Adresu(int iD_Adresu) {
		ID_Adresu = iD_Adresu;
	}



	public int getID_Stanowiska() {
		return ID_Stanowiska;
	}



	public void setID_Stanowiska(int iD_Stanowiska) {
		ID_Stanowiska = iD_Stanowiska;
	}


	@Override
	public String toString() {
		return "Pracownicy [ID_Pracownika=" + ID_Pracownika + ", Imie=" + Imie + ", Nazwisko=" + Nazwisko
				+ ", Data_urodzenia=" + Data_urodzenia + ", PESEL=" + PESEL + ", NR_Telefonu=" + NR_Telefonu
				+ ", Email=" + Email + ", Plec=" + Plec + ", Data_Zatrudnienia=" + Data_Zatrudnienia
				+ ", Data_Zwolnienia=" + Data_Zwolnienia + ", ID_Domu=" + ID_Domu + ", ID_Adresu=" + ID_Adresu
				+ ", ID_Stanowiska=" + ID_Stanowiska + "]";
	}

	
	

	
	
}
