package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class WydarzeniaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public WydarzeniaDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Wydarzenia> list(){
		String sql = "SELECT * from Wydarzenia";
		
		List<Wydarzenia> listWydarzenia = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Wydarzenia.class));
		return listWydarzenia;
	}
	
	/* Create */
	public void save(Wydarzenia wydarzenia) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Wydarzenia").usingColumns("Nazwa_Wydarzenia","Maksymalna_ilosc_uczestnikow","Wymagana_zgoda_rodzica","ID_Domu");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wydarzenia);
		insertActor.execute(param);
	}
	
	/* Read */
	public Wydarzenia get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Wydarzenia wydarzenia) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}
}