package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class UczestnicyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public UczestnicyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Uczestnicy> list(){
		String sql = "SELECT * from Uczestnicy";
		
		List<Uczestnicy> listUczestnicy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Uczestnicy.class));
		return listUczestnicy;
	}
	
	/* List for pracownik view*/
	public List<Uczestnicy> plist(String cos){
		Object[] args = { cos };
		String sql = "SELECT Uczestnicy.ID_Uczestnika, Imie, Nazwisko, Plec, Data_urodzenia, Numer_telefonu, Email, Uczestnicy.ID_Adresu from Uczestnicy\r\n" + 
				"JOIN Zapisy_na_wydarzenie ON uczestnicy.id_uczestnika = zapisy_na_wydarzenie.id_uczestnika\r\n" + 
				"JOIN Realizacje_wydarzen ON zapisy_na_wydarzenie.id_realizacji_wydarzenia = realizacje_wydarzen.id_realizacji_wydarzenia\r\n" + 
				"JOIN Obslugiwanie_wydarzenia ON realizacje_wydarzen.id_realizacji_wydarzenia = obslugiwanie_wydarzenia.id_realizacji_wydarzenia\r\n" + 
				"WHERE Obslugiwanie_wydarzenia.id_pracownika=" +args[0];
		
		List<Uczestnicy> plistUczestnicy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Uczestnicy.class));
		return plistUczestnicy;
	}
	
	/* List for pracownik view - realizacje with uczestnicy*/
	public List<Uczestnicy> pulist(String cos, int eiti){
		Object[] args = { cos, eiti };
		String sql = "SELECT Uczestnicy.ID_Uczestnika, Imie, Nazwisko, Plec, Data_urodzenia, Numer_telefonu, Email, Uczestnicy.ID_Adresu from Uczestnicy\r\n" + 
				"JOIN Zapisy_na_wydarzenie ON uczestnicy.id_uczestnika = zapisy_na_wydarzenie.id_uczestnika\r\n" + 
				"JOIN Realizacje_wydarzen ON zapisy_na_wydarzenie.id_realizacji_wydarzenia = realizacje_wydarzen.id_realizacji_wydarzenia\r\n" + 
				"JOIN Obslugiwanie_wydarzenia ON realizacje_wydarzen.id_realizacji_wydarzenia = obslugiwanie_wydarzenia.id_realizacji_wydarzenia\r\n" + 
				"WHERE Obslugiwanie_wydarzenia.id_pracownika=" +args[0] + " and zapisy_na_wydarzenie.id_realizacji_wydarzenia=" + args[1];
		
		List<Uczestnicy> pulistUczestnicy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Uczestnicy.class));
		return pulistUczestnicy;
	}
	
	/* Create */
	public void save(Uczestnicy uczestnicy) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Uczestnicy").usingColumns("Imie","Nazwisko","Plec","Data_urodzenia","Numer_Telefonu","Email","ID_Adresu");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uczestnicy);
		insertActor.execute(param);
	}
	
	/* Read */
	public Uczestnicy get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM Uczestnicy WHERE ID_Uczestnika =" + args[0];
		Uczestnicy uczestnicy = jdbcTemplate.queryForObject(sql,
				BeanPropertyRowMapper.newInstance(Uczestnicy.class));
		return uczestnicy;
	}
	
	/* Update */
	public void update(Uczestnicy uczestnicy) {
		String sql = "UPDATE Uczestnicy SET Imie=:Imie, Nazwisko=:Nazwisko, Plec=:Plec, Data_urodzenia=:Data_urodzenia,  Numer_telefonu=:Numer_telefonu, Email=:Email,   ID_Adresu=:ID_Adresu WHERE ID_Uczestnika=:ID_Uczestnika";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uczestnicy);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		//data jako null
		template.update(sql, param);
	}
	
	/* Delete */
	public void delete(int id) {
		String sql = "DELETE FROM Uczestnicy WHERE ID_UCZESTNIKA = ?"; //trzeba usun¹æ wynagrodzenie!
		jdbcTemplate.update(sql,id);
	}
}
