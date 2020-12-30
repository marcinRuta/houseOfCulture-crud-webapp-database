package bdbt_proj;

public class Wydarzenia {
	/* Fields */
	private int ID_Wydarzenia;
	private String Nazwa_Wydarzenia;
	private int Maksymalna_Ilosc_Uczestnikow;
	private String Wymagana_Zgoda_Rodzica;
	private int ID_Domu;
	
	
	
	public Wydarzenia() {
		
	}



	public Wydarzenia(int iD_Wydarzenia, String nazwa_Wydarzenia, int maksymalna_Ilosc_Uczestnikow,
			String wymagana_Zgoda_Rodzica, int iD_Domu) {
		super();
		this.ID_Wydarzenia = iD_Wydarzenia;
		this.Nazwa_Wydarzenia = nazwa_Wydarzenia;
		this.Maksymalna_Ilosc_Uczestnikow = maksymalna_Ilosc_Uczestnikow;
		this.Wymagana_Zgoda_Rodzica = wymagana_Zgoda_Rodzica;
		this.ID_Domu = iD_Domu;
	}



	public int getID_Wydarzenia() {
		return ID_Wydarzenia;
	}



	public void setID_Wydarzenia(int iD_Wydarzenia) {
		ID_Wydarzenia = iD_Wydarzenia;
	}



	public String getNazwa_Wydarzenia() {
		return Nazwa_Wydarzenia;
	}



	public void setNazwa_Wydarzenia(String nazwa_Wydarzenia) {
		Nazwa_Wydarzenia = nazwa_Wydarzenia;
	}



	public int getMaksymalna_Ilosc_Uczestnikow() {
		return Maksymalna_Ilosc_Uczestnikow;
	}



	public void setMaksymalna_Ilosc_Uczestnikow(int maksymalna_Ilosc_Uczestnikow) {
		Maksymalna_Ilosc_Uczestnikow = maksymalna_Ilosc_Uczestnikow;
	}



	public String getWymagana_Zgoda_Rodzica() {
		return Wymagana_Zgoda_Rodzica;
	}



	public void setWymagana_Zgoda_Rodzica(String wymagana_Zgoda_Rodzica) {
		Wymagana_Zgoda_Rodzica = wymagana_Zgoda_Rodzica;
	}



	public int getID_Domu() {
		return ID_Domu;
	}



	public void setID_Domu(int iD_Domu) {
		ID_Domu = iD_Domu;
	}



	@Override
	public String toString() {
		return "Wydarzenia [ID_Wydarzenia=" + ID_Wydarzenia + ", Nazwa_Wydarzenia=" + Nazwa_Wydarzenia
				+ ", Maksymalna_Ilosc_Uczestnikow=" + Maksymalna_Ilosc_Uczestnikow + ", Wymagana_Zgoda_Rodzica="
				+ Wymagana_Zgoda_Rodzica + ", ID_Domu=" + ID_Domu + "]";
	}
	
	
	

}
