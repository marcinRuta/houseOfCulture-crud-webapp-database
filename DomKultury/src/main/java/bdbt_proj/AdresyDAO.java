package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class AdresyDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public AdresyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Adresy> list(){
		String sql = "SELECT * from Adresy";
		
		List<Adresy> listAdresy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Adresy.class));
		return listAdresy;
	}
	
	/* Create */
	public void save(Adresy adresy) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Adresy").usingColumns("Ulica","Nr_domu","Nr_mieszkania","ID_Poczty");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
		insertActor.execute(param);
	}
	
	/* Read */
	public Adresy get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Adresy adresy) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}
}