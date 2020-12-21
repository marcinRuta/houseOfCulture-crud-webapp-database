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
		datasource.setUrl("jdbc:oracle:thin:@192.168.0.185:1521/XEPDB1");
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
		fail("Not yet implemented");
	}

	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}