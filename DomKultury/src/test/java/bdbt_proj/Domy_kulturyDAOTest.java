package bdbt_proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class Domy_kulturyDAOTest {
	
	private Domy_kulturyDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1");
		datasource.setUsername("DobrzeSieBawie1");
		datasource.setPassword("Password321");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		
		dao = new Domy_kulturyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Domy_kultury> listDomy = dao.list();
		assertTrue(listDomy.isEmpty());
	}

	@Test
	void testSave() {
		Domy_kultury domek = new Domy_kultury(2, "Transatlantycki", "1999-02-12", "Maciek", 1);
		dao.save(domek);
	}

	@Test
	void testGet() {
		int id = 1;
		Domy_kultury dom = dao.get(id);
		
		assertNotNull(dom);
	}

	@Test
	void testUpdate() {
		Domy_kultury dom = new Domy_kultury();
		dom.setID_Domu(21);
		dom.setData_zalozenia("2021-07-01");
		dom.setDyrektor("Michal");
		dom.setNazwa("Marcinek");
		dom.setID_Adresu(2);
		
		dao.update(dom);
		
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
