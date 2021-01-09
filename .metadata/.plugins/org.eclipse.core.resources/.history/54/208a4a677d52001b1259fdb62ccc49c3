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
		Object[] args = { id };
		String sql = "SELECT * FROM Wydarzenia WHERE id_wydarzenia =" + args[0];
		Wydarzenia Wydarzenie = jdbcTemplate.queryForObject(sql,
				BeanPropertyRowMapper.newInstance(Wydarzenia.class));

		return Wydarzenie;
	}
	
	/* Update */
	public void update(Wydarzenia wydarzenia) {
		String sql = "UPDATE Wydarzenia SET Nazwa_Wydarzenia=:Nazwa_Wydarzenia,  Maksymalna_Ilosc_Uczestnikow=:Maksymalna_Ilosc_Uczestnikow, Wymagana_Zgoda_Rodzica=:Wymagana_Zgoda_Rodzica, ID_Domu=:ID_Domu WHERE ID_Wydarzenia=:ID_Wydarzenia";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wydarzenia);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);
	}
	
	/* Delete */
	public void delete(int id) {
		String sql = "DELETE FROM Wydarzenia WHERE ID_Wydarzenia = ?";
		jdbcTemplate.update(sql,id);
	}
}