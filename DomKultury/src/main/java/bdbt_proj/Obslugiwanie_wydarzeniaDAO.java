package bdbt_proj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
	
	/* List for pracownik view*/
	public List<Obslugiwanie_wydarzenia> plist(String cos){
		Object[] args = { cos };
		
		String sql = "SELECT * from Obslugiwanie_wydarzenia WHERE ID_Pracownika=" + args[0];
		
		List<Obslugiwanie_wydarzenia> plistObslugiwanie_wydarzenia = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Obslugiwanie_wydarzenia.class));
		return plistObslugiwanie_wydarzenia;
	}
	
	/* Create */
	public void save(Obslugiwanie_wydarzenia obslugiwanie_wydarzenia) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Obslugiwanie_wydarzenia").usingColumns("ID_Pracownika","ID_Realizacji_Wydarzenia");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(obslugiwanie_wydarzenia);
		insertActor.execute(param);
	}
	
	/* Delete */
	public void delete(int id1, int id2) {
		String sql = "DELETE FROM Obslugiwanie_wydarzenia WHERE ID_Pracownika=:id1 and id_realizacji_wydarzenia=:id2";
		
		Map<String, Object> parameters = new HashMap<String, Object>();  //b��d w object, z�e warto�ci kolumn?
        parameters.put("id1", id1);
        parameters.put("id2", id2);
		
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, parameters);
	}

}
