package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class Realizacje_wydarzenDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public Realizacje_wydarzenDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Realizacje_wydarzen> list(){
		String sql = "SELECT * from Realizacje_Wydarzen";
		
		List<Realizacje_wydarzen> listRealizacje_wydarzen = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Realizacje_wydarzen.class));
		return listRealizacje_wydarzen;
	}
	
	/* Create */
	public void save(Realizacje_wydarzen realizacje_wydarzen) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Realizacje_Wydarzen").usingColumns("Data_Wydarzenia","Cena","ID_Wydarzenia","ID_Sali");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(realizacje_wydarzen);
		insertActor.execute(param);
	}
	
	/* Read */
	public Realizacje_wydarzen get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Realizacje_wydarzen realizacje_wydarzen) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}

}
