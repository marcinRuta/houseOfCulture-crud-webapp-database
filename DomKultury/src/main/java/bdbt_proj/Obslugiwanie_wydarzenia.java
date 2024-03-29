package bdbt_proj;

public class Obslugiwanie_wydarzenia {
	
	/* Fields */
	private int ID_Pracownika;
	private int ID_Realizacji_Wydarzenia;
	
	/* Constructor from superclass */
	public Obslugiwanie_wydarzenia() {

	}

	/* Constructor with fields*/
	public Obslugiwanie_wydarzenia(int iD_Pracownika, int iD_Realizacji_Wydarzenia) {
		super();
		this.ID_Pracownika = iD_Pracownika;
		this.ID_Realizacji_Wydarzenia = iD_Realizacji_Wydarzenia;
	}

	/* Getters and setters */
	public int getID_Pracownika() {
		return ID_Pracownika;
	}


	public void setID_Pracownika(int iD_Pracownika) {
		ID_Pracownika = iD_Pracownika;
	}


	public int getID_Realizacji_Wydarzenia() {
		return ID_Realizacji_Wydarzenia;
	}


	public void setID_Realizacji_Wydarzenia(int iD_Realizacji_Wydarzenia) {
		ID_Realizacji_Wydarzenia = iD_Realizacji_Wydarzenia;
	}

	/* toString() method */
	@Override
	public String toString() {
		return "Obslugiwanie_wydarzenia [ID_Pracownika=" + ID_Pracownika + ", ID_Realizacji_Wydarzenia="
				+ ID_Realizacji_Wydarzenia + "]";
	}
	
	
	
	
	
	
}
