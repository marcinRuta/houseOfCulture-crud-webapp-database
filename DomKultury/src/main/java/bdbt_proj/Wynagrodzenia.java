package bdbt_proj;

import java.sql.Date;

public class Wynagrodzenia {
	
	/* Fields */
	private int ID_Wynagrodzenia;
	private Date Data_Wyslania_Wynagrodzenia;
	private float Kwota_Wynagrodzenia;
	private int ID_Pracownika;
	
	
	/* Constructor from superclass */
	public Wynagrodzenia() {

	}

	/* Constructor with fields*/
	public Wynagrodzenia(int iD_Wynagrodzenia, Date data_Wyslania_Wynagrodzenia, float kwota_Wynagrodzenia,
			int iD_Pracownika) {
		super();
		this.ID_Wynagrodzenia = iD_Wynagrodzenia;
		this.Data_Wyslania_Wynagrodzenia = data_Wyslania_Wynagrodzenia;
		this.Kwota_Wynagrodzenia = kwota_Wynagrodzenia;
		this.ID_Pracownika = iD_Pracownika;
	}

	/* Getters and setters */
	public int getID_Wynagrodzenia() {
		return ID_Wynagrodzenia;
	}

	public void setID_Wynagrodzenia(int iD_Wynagrodzenia) {
		ID_Wynagrodzenia = iD_Wynagrodzenia;
	}

	public Date getData_Wyslania_Wynagrodzenia() {
		return Data_Wyslania_Wynagrodzenia;
	}

	public void setData_Wyslania_Wynagrodzenia(Date data_Wyslania_Wynagrodzenia) {
		Data_Wyslania_Wynagrodzenia = data_Wyslania_Wynagrodzenia;
	}

	public float getKwota_Wynagrodzenia() {
		return Kwota_Wynagrodzenia;
	}

	public void setKwota_Wynagrodzenia(float kwota_Wynagrodzenia) {
		Kwota_Wynagrodzenia = kwota_Wynagrodzenia;
	}

	public int getID_Pracownika() {
		return ID_Pracownika;
	}

	public void setID_Pracownika(int iD_Pracownika) {
		ID_Pracownika = iD_Pracownika;
	}

	/* toString() method */
	@Override
	public String toString() {
		return "Wynagrodzenia [ID_Wynagrodzenia=" + ID_Wynagrodzenia + ", Data_Wyslania_Wynagrodzenia="
				+ Data_Wyslania_Wynagrodzenia + ", Kwota_Wynagrodzenia=" + Kwota_Wynagrodzenia + ", ID_Pracownika="
				+ ID_Pracownika + "]";
	}
	
	
	
	
	

}
