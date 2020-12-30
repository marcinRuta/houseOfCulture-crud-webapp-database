package bdbt_proj;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class Zapisy_na_wydarzenieDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public Zapisy_na_wydarzenieDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Zapisy_na_wydarzenie> list(){
		String sql = "SELECT * from Zapisy_na_wydarzenie";
		
		List<Zapisy_na_wydarzenie> listZapisy_na_wydarzenie = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Zapisy_na_wydarzenie.class));
		return listZapisy_na_wydarzenie;
	}
	
	/* Create */
	public void save(Zapisy_na_wydarzenie Zapisy_na_wydarzenie) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Zapisy_na_wydarzenie").usingColumns("ID_Uczestnika","ID_Realizacji_Wydarzenia","Data_Zapisu");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Zapisy_na_wydarzenie);
		insertActor.execute(param);
	}
	
	/* Read */
	public Zapisy_na_wydarzenie get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Zapisy_na_wydarzenie Zapisy_na_wydarzenie) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}

}
