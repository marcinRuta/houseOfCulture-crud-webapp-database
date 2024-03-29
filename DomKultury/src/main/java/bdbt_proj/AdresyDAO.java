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
		String sql = "SELECT * from Adresy ORDER BY ID_Adresu";
		
		List<Adresy> listAdresy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Adresy.class));
		return listAdresy;
	}
	
	/* List for pracownik view */
	public List<Adresy> plist(String cos){
		Object[] args = { cos };
		
		String sql = "SELECT Adresy.ID_Adresu, Ulica, Nr_domu, Nr_mieszkania, ID_poczty from Adresy\r\n" + 
				"JOIN Pracownicy ON Adresy.ID_Adresu = Pracownicy.ID_Adresu\r\n" + 
				"WHERE pracownicy.id_pracownika =" + args[0];
		
		List<Adresy> plistAdresy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Adresy.class));
		return plistAdresy;
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
		Object[] args = { id };
		String sql = "SELECT * FROM Adresy WHERE ID_Adresu =" + args[0];
		Adresy adresy = jdbcTemplate.queryForObject(sql,
				BeanPropertyRowMapper.newInstance(Adresy.class));

		return adresy;
	}
	
	/* Update */
	public void update(Adresy adresy) {
		String sql = "UPDATE Adresy SET Ulica=:Ulica, Nr_Domu=:Nr_Domu, Nr_mieszkania=:Nr_mieszkania, ID_Poczty=:ID_Poczty WHERE ID_Adresu=:ID_Adresu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);
	}
	
	/* Delete */
	public void delete(int id) {
		String sql = "DELETE FROM Adresy WHERE ID_Adresu = ?";
		jdbcTemplate.update(sql,id);
	}
}
