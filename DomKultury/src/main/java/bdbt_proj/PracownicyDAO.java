package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class PracownicyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public PracownicyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Pracownicy> list(){
		String sql = "SELECT * from Pracownicy";
		
		List<Pracownicy> listPracownicy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Pracownicy.class));
		return listPracownicy;
	}
	
	/* Create */
	public void save(Pracownicy pracownicy) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Pracownicy").usingColumns("ID_Pracownika","Imie","Nazwisko","Data_urodzenia","PESEL","NR_Telefonu","Email","Plec","Data_Zatrudnienia","Data_Zwolnienia","ID_Domu","ID_Adresu","ID_Stanowiska");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
		insertActor.execute(param);
	}
	
	/* Read */
	public Pracownicy get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Pracownicy pracownicy) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}
}