package bdbt_proj;

public class Adresy {
	
	/* Fields */
	private int ID_Adresu;
	private String Ulica;
	private String Nr_Domu;
	private String Nr_mieszkania;
	private int ID_Poczty;
	
	/* Constructor from superclass */
	public Adresy() {
		
	}
	
	/* Constructor with fields*/
	public Adresy(int iD_Adresu, String ulica, String nr_Domu, String nr_mieszkania, int iD_Poczty) {
		super();
		this.ID_Adresu = iD_Adresu;
		this.Ulica = ulica;
		this.Nr_Domu = nr_Domu;
		this.Nr_mieszkania = nr_mieszkania;
		this.ID_Poczty = iD_Poczty;
	}
	
	/* Getters and Setters */
	public int getID_Adresu() {
		return ID_Adresu;
	}

	public void setID_Adresu(int iD_Adresu) {
		ID_Adresu = iD_Adresu;
	}

	public String getUlica() {
		return Ulica;
	}

	public void setUlica(String ulica) {
		Ulica = ulica;
	}

	public String getNr_Domu() {
		return Nr_Domu;
	}

	public void setNr_Domu(String nr_Domu) {
		Nr_Domu = nr_Domu;
	}

	public String getNr_mieszkania() {
		return Nr_mieszkania;
	}

	public void setNr_mieszkania(String nr_mieszkania) {
		Nr_mieszkania = nr_mieszkania;
	}

	public int getID_Poczty() {
		return ID_Poczty;
	}

	public void setID_Poczty(int iD_Poczty) {
		ID_Poczty = iD_Poczty;
	}

	/* toString() method */
	@Override
	public String toString() {
		return "Adresy [ID_Adresu=" + ID_Adresu + ", Ulica=" + Ulica + ", Nr_Domu=" + Nr_Domu + ", Nr_mieszkania="
				+ Nr_mieszkania + ", ID_Poczty=" + ID_Poczty + "]";
	}

}
