package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class Domy_kulturyDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public Domy_kulturyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List */
	public List<Domy_kultury> list(){
		String sql = "SELECT * from Domy_kultury";
		
		List<Domy_kultury> listDomy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Domy_kultury.class));
		return listDomy;
	}
	
	/* Create */
	public void save(Domy_kultury domy_kultury) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Domy_kultury").usingColumns("Nazwa","Data_zalozenia","Dyrektor","ID_Adresu");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(domy_kultury);
		insertActor.execute(param);
	}
	
	/* Read */
	public Domy_kultury get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Domy_kultury domy_kultury) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}
}
