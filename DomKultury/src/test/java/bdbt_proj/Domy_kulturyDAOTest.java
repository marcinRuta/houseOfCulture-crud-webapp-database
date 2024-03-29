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
		
	}

	@Test
	void testGet() {
		int id = 1;
		Domy_kultury dom = dao.get(id);
		
		assertNotNull(dom);
	}

	@Test
	void testUpdate() {

		
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
