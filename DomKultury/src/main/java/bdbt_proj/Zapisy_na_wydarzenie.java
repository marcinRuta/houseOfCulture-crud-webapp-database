package bdbt_proj;

import java.sql.Date;

public class Zapisy_na_wydarzenie {
	/* Fields */
	private int ID_Uczestnika;
	private int ID_Realizacji_Wydarzenia;
	private Date Data_Zapisu;
	
	
	public Zapisy_na_wydarzenie() {
		
	}


	public Zapisy_na_wydarzenie(int iD_Uczestnika, int iD_Realizacji_Wydarzenia, Date data_Zapisu) {
		super();
		ID_Uczestnika = iD_Uczestnika;
		ID_Realizacji_Wydarzenia = iD_Realizacji_Wydarzenia;
		Data_Zapisu = data_Zapisu;
	}


	public int getID_Uczestnika() {
		return ID_Uczestnika;
	}


	public void setID_Uczestnika(int iD_Uczestnika) {
		ID_Uczestnika = iD_Uczestnika;
	}


	public int getID_Realizacji_Wydarzenia() {
		return ID_Realizacji_Wydarzenia;
	}


	public void setID_Realizacji_Wydarzenia(int iD_Realizacji_Wydarzenia) {
		ID_Realizacji_Wydarzenia = iD_Realizacji_Wydarzenia;
	}


	public Date getData_Zapisu() {
		return Data_Zapisu;
	}


	public void setData_Zapisu(Date data_Zapisu) {
		Data_Zapisu = data_Zapisu;
	}


	@Override
	public String toString() {
		return "Zapisy_na_wydarzenie [ID_Uczestnika=" + ID_Uczestnika + ", ID_Realizacji_Wydarzenia="
				+ ID_Realizacji_Wydarzenia + ", Data_Zapisu=" + Data_Zapisu + "]";
	}
	
	
	
	
}
