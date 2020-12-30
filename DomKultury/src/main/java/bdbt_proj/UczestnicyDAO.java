package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
	
	/* Create */
	public void save(Uczestnicy uczestnicy) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Uczestnicy").usingColumns("Imie","Nazwisko","Plec","Data_urodzenia","Numer_Telefonu","Email","ID_Adresu");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(uczestnicy);
		insertActor.execute(param);
	}
	
	/* Read */
	public Uczestnicy get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Uczestnicy uczestnicy) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}
}
