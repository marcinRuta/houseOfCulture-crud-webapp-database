package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class WynagrodzeniaDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public WynagrodzeniaDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Wynagrodzenia> list(){
		String sql = "SELECT * from Wynagrodzenia";
		
		List<Wynagrodzenia> listWynagrodzenia = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
		return listWynagrodzenia;
	}
	
	/* Create */
	public void save(Wynagrodzenia wynagrodzenia) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Wynagrodzenia").usingColumns("Data_Wyslania_Wynagrodzenia","Kwota_Wynagrodzenia","ID_Pracownika");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenia);
		insertActor.execute(param);
	}
	
	/* Read */
	public Wynagrodzenia get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Wynagrodzenia wynagrodzenia) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}

}
