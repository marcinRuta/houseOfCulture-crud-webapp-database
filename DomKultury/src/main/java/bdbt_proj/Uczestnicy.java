package bdbt_proj;

public class Uczestnicy {
	/* Fields */
	private int ID_Uczestnika;
	private String Imie;
	private String Nazwisko;
	private String Plec;
	private String Data_urodzenia;
	private String Numer_telefonu;
	private String Email;
	private int ID_Adresu;
	
	
	public Uczestnicy() {
		
	}


	public Uczestnicy(int iD_Uczestnika, String imie, String nazwisko, String plec, String data_urodzenia,
			String nR_Telefonu, String email, int iD_Adresu) {
		super();
		ID_Uczestnika = iD_Uczestnika;
		Imie = imie;
		Nazwisko = nazwisko;
		Plec = plec;
		Data_urodzenia = data_urodzenia;
		Numer_telefonu = nR_Telefonu;
		Email = email;
		ID_Adresu = iD_Adresu;
	}


	public int getID_Uczestnika() {
		return ID_Uczestnika;
	}


	public void setID_Uczestnika(int iD_Uczestnika) {
		ID_Uczestnika = iD_Uczestnika;
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


	public String getPlec() {
		return Plec;
	}


	public void setPlec(String plec) {
		Plec = plec;
	}


	public String getData_urodzenia() {
		return Data_urodzenia;
	}


	public void setData_urodzenia(String data_urodzenia) {
		Data_urodzenia = data_urodzenia;
	}




	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public int getID_Adresu() {
		return ID_Adresu;
	}


	public void setID_Adresu(int iD_Adresu) {
		ID_Adresu = iD_Adresu;
	}


	public String getNumer_telefonu() {
		return Numer_telefonu;
	}


	public void setNumer_telefonu(String numer_telefonu) {
		Numer_telefonu = numer_telefonu;
	}


	@Override
	public String toString() {
		return "Uczestnicy [ID_Uczestnika=" + ID_Uczestnika + ", Imie=" + Imie + ", Nazwisko=" + Nazwisko + ", Plec="
				+ Plec + ", Data_urodzenia=" + Data_urodzenia + ", Numer_telefonu=" + Numer_telefonu + ", Email="
				+ Email + ", ID_Adresu=" + ID_Adresu + "]";
	}


	
	
	

	
}
