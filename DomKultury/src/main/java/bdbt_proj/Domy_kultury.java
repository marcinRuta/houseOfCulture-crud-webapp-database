package bdbt_proj;

import java.sql.Date;

public class Domy_kultury {
	
	/* Fields */
	private int ID_Domu;
	private String Nazwa;
	private Date Data_zalozenia;
	private String Dyrektor;
	private int ID_Adresu;
	
	
	/* Constructor from superclass */
	public Domy_kultury() {
		
	}
	
	/* Constructor with fields */
	public Domy_kultury(int iD_Domu, String nazwa, Date data_zalozenia, String dyrektor, int iD_Adresu) {
		super();
		this.ID_Domu = iD_Domu;
		this.Nazwa = nazwa;
		this.Data_zalozenia = data_zalozenia;
		this.Dyrektor = dyrektor;
		this.ID_Adresu = iD_Adresu;
	}
	
	/* Getters and setters */
	public int getID_Domu() {
		return ID_Domu;
	}

	public void setID_Domu(int iD_Domu) {
		ID_Domu = iD_Domu;
	}

	public String getNazwa() {
		return Nazwa;
	}

	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}

	public Date getData_zalozenia() {
		return Data_zalozenia;
	}

	public void setData_zalozenia(Date data_zalozenia) {
		Data_zalozenia = data_zalozenia;
	}

	public String getDyrektor() {
		return Dyrektor;
	}

	public void setDyrektor(String dyrektor) {
		Dyrektor = dyrektor;
	}

	public int getID_Adresu() {
		return ID_Adresu;
	}

	public void setID_Adresu(int iD_Adresu) {
		ID_Adresu = iD_Adresu;
	}
	
	/* toString() method */
	@Override
	public String toString() {
		return "Domy_kultury [ID_Domu=" + ID_Domu + ", Nazwa=" + Nazwa + ", Data_zalozenia=" + Data_zalozenia
				+ ", Dyrektor=" + Dyrektor + ", ID_Adresu=" + ID_Adresu + "]";
	}
	
	
	
	
	
}
