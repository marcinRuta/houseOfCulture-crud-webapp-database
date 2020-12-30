package bdbt_proj;

public class Realizacje_wydarzen {
	
	/* Fields */
	private int ID_Realizacji_Wydarzenia;
	private String Data_Wydarzenia;
	private float Cena;
	private int ID_Wydarzenia;
	private int ID_Sali;
	
	
	
	
	
	public Realizacje_wydarzen() {
		
	}





	public Realizacje_wydarzen(int iD_Realizacji_Wydarzenia, String data_Wydarzenia, float cena, int iD_Wydarzenia,
			int iD_Sali) {
		super();
		ID_Realizacji_Wydarzenia = iD_Realizacji_Wydarzenia;
		Data_Wydarzenia = data_Wydarzenia;
		Cena = cena;
		ID_Wydarzenia = iD_Wydarzenia;
		ID_Sali = iD_Sali;
	}





	public int getID_Realizacji_Wydarzenia() {
		return ID_Realizacji_Wydarzenia;
	}





	public void setID_Realizacji_Wydarzenia(int iD_Realizacji_Wydarzenia) {
		ID_Realizacji_Wydarzenia = iD_Realizacji_Wydarzenia;
	}





	public String getData_Wydarzenia() {
		return Data_Wydarzenia;
	}





	public void setData_Wydarzenia(String data_Wydarzenia) {
		Data_Wydarzenia = data_Wydarzenia;
	}





	public float getCena() {
		return Cena;
	}





	public void setCena(float cena) {
		Cena = cena;
	}





	public int getID_Wydarzenia() {
		return ID_Wydarzenia;
	}





	public void setID_Wydarzenia(int iD_Wydarzenia) {
		ID_Wydarzenia = iD_Wydarzenia;
	}





	public int getID_Sali() {
		return ID_Sali;
	}





	public void setID_Sali(int iD_Sali) {
		ID_Sali = iD_Sali;
	}





	@Override
	public String toString() {
		return "Realizacje_wydarzen [ID_Realizacji_Wydarzenia=" + ID_Realizacji_Wydarzenia + ", Data_Wydarzenia="
				+ Data_Wydarzenia + ", Cena=" + Cena + ", ID_Wydarzenia=" + ID_Wydarzenia + ", ID_Sali=" + ID_Sali
				+ "]";
	}
	
	

	
	
	
	
	
}
