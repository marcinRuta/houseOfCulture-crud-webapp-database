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
public class Domy_kulturyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* Constructor for jdbcTemplate */
	public Domy_kulturyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/* List */
	public List<Domy_kultury> list() {
		String sql = "SELECT * from Domy_kultury";

		List<Domy_kultury> listDomy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Domy_kultury.class));
		return listDomy;
	}
	
	/* List for pracownik view */
	public List<Domy_kultury> plist(String cos) {
		Object[] args = { cos };
		String sql = "SELECT Domy_Kultury.ID_Domu, Nazwa, Data_zalozenia, Dyrektor, Domy_Kultury.ID_Adresu from Domy_Kultury\r\n" + 
				"JOIN Pracownicy ON Domy_kultury.ID_Domu = Pracownicy.ID_Domu\r\n" + 
				"WHERE pracownicy.id_pracownika =" + args[0];

		List<Domy_kultury> plistDomy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Domy_kultury.class));
		return plistDomy;
	}

	/* Create */
	public void save(Domy_kultury domy_kultury) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Domy_kultury").usingColumns("Nazwa", "Data_zalozenia", "Dyrektor", "ID_Adresu");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(domy_kultury);
		insertActor.execute(param);
	}

	/* Read */
	public Domy_kultury get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM Domy_Kultury WHERE id_domu =" + args[0];
		Domy_kultury domy_kultury = jdbcTemplate.queryForObject(sql,
				BeanPropertyRowMapper.newInstance(Domy_kultury.class));

		return domy_kultury;
	}

	/* Update */
	public void update(Domy_kultury domy_kultury) {
		String sql = "UPDATE Domy_kultury SET Nazwa=:Nazwa, Data_zalozenia=:Data_zalozenia, Dyrektor=:Dyrektor, ID_Adresu=:ID_Adresu WHERE ID_Domu=:ID_Domu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(domy_kultury);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

		template.update(sql, param);
	}

	/* Delete */
	public void delete(int id) {
		String sql = "DELETE FROM Domy_kultury WHERE ID_Domu = ?";
		jdbcTemplate.update(sql,id);
		
	}
}
