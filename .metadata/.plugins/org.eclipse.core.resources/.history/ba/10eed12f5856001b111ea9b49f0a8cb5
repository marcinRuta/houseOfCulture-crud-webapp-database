package bdbt_proj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
	
	/* List */
	public List<Wynagrodzenia> plist(String cos){
		Object[] args = { cos };
		String sql = "SELECT * from Wynagrodzenia WHERE ID_Pracownika=" + args[0];
		
		List<Wynagrodzenia> plistWynagrodzenia = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
		return plistWynagrodzenia;
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
		Object[] args = { id };
		String sql = "SELECT * FROM Wynagrodzenia WHERE ID_Wynagrodzenia =" + args[0];
		Wynagrodzenia wynagrodzenia = jdbcTemplate.queryForObject(sql,
				BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));

		return wynagrodzenia;
	}
	
	/* Update */
	public void update(Wynagrodzenia wynagrodzenia) {
		String sql = "UPDATE Wynagrodzenia SET Data_Wyslania_Wynagrodzenia=:Data_Wyslania_Wynagrodzenia, Kwota_Wynagrodzenia=:Kwota_Wynagrodzenia, ID_Pracownika=:ID_Pracownika WHERE ID_Wynagrodzenia=:ID_Wynagrodzenia";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenia);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);
	}
	
	/* Delete */
	public void delete(int id) {
		String sql = "DELETE FROM Wynagrodzenia WHERE ID_Wynagrodzenia = ?";
		jdbcTemplate.update(sql,id);
	}

}
