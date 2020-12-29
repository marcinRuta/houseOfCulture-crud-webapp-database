package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class Obslugiwanie_wydarzeniaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public Obslugiwanie_wydarzeniaDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Obslugiwanie_wydarzenia> list(){
		String sql = "SELECT * from Obslugiwanie_wydarzenia";
		
		List<Obslugiwanie_wydarzenia> listObslugiwanie_wydarzenia = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Obslugiwanie_wydarzenia.class));
		return listObslugiwanie_wydarzenia;
	}
	
	/* Create */
	public void save(Obslugiwanie_wydarzenia obslugiwanie_wydarzenia) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Obslugiwanie_wydarzenia").usingColumns("ID_Pracownika","ID_Realizacji_Wydarzenia");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(obslugiwanie_wydarzenia);
		insertActor.execute(param);
	}
	
	/* Read */
	public Obslugiwanie_wydarzenia get(int id) {
		return null;
	}
	
	/* Update */
	public void update(Obslugiwanie_wydarzenia obslugiwanie_wydarzenia) {
		
	}
	
	/* Delete */
	public void delete(int id) {
		
	}

}
