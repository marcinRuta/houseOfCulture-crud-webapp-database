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
public class PracownicyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/* Constructor for jdbcTemplate */
	public PracownicyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/* List */
	public List<Pracownicy> list(){
		String sql = "SELECT * from Pracownicy ORDER BY ID_Pracownika";
		
		List<Pracownicy> listPracownicy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Pracownicy.class));
		
		return listPracownicy;
	}
	
	public List<Pracownicy> listSortedByNazw(){
		String sql = "SELECT * from Pracownicy ORDER BY Nazwisko ASC";
		
		List<Pracownicy> listPracownicy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Pracownicy.class));
		
		return listPracownicy;
	}
	
	/* List for pracownicy view*/
	public List<Pracownicy> plist(String cos){
		Object[] args = { cos };
		
		String sql = "SELECT * from Pracownicy WHERE ID_Pracownika=" + args[0] ;
		
		List<Pracownicy> plistPracownicy = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Pracownicy.class));
		return plistPracownicy;
	}
	
	
	/* Create */
	public void save(Pracownicy pracownicy) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Pracownicy").usingColumns("Imie","Nazwisko","Data_urodzenia","PESEL","NR_Telefonu","Email","Plec","Data_Zatrudnienia","Data_Zwolnienia","ID_Domu","ID_Adresu","ID_Stanowiska");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
		insertActor.execute(param);
	}
	
	/* Read */
	public Pracownicy get(int id) {
		Object[] args = { id };
		String sql = "SELECT * FROM Pracownicy WHERE ID_Pracownika =" + args[0];
		Pracownicy pracownicy = jdbcTemplate.queryForObject(sql,
				BeanPropertyRowMapper.newInstance(Pracownicy.class));

		return pracownicy;
	}
	
	/* Update */
	public void update(Pracownicy pracownicy) {
		String sql = "UPDATE Pracownicy SET Imie=:Imie, Nazwisko=:Nazwisko, Data_urodzenia=:Data_urodzenia, PESEL=:PESEL, NR_Telefonu=:NR_Telefonu, Email=:Email, Plec=:Plec, Data_Zatrudnienia=:Data_Zatrudnienia, Data_Zwolnienia=:Data_Zwolnienia, ID_Domu=:ID_Domu, ID_Adresu=:ID_Adresu, ID_Stanowiska=:ID_Stanowiska WHERE ID_Pracownika=:ID_Pracownika";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		
		template.update(sql, param);
	}
	
	/* Delete */
	public void delete(int id) {
		String sql = "DELETE FROM Pracownicy WHERE ID_Pracownika = ?"; 

		jdbcTemplate.update(sql,id);

	}
}
