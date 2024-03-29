package bdbt_proj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginDao {

	public LoginDao() {
		super();
	}

	public boolean porwnajA(Login login) {
		Properties propA = new Properties();

		try {
			String pathA = new File("src/main/resources/a.properties").getCanonicalPath();

			InputStream inputA = new FileInputStream(pathA);

			propA.load(inputA);

			if (propA.getProperty(login.getLogin()).equals(login.getPassword())) {
				return true;
			} else {
				return false;
			}

		} catch (IOException e) {
			return false;
		}

		catch (NullPointerException e) {
			return false;
		}

	}

	public boolean porwnajP(Login login) {
		Properties propP = new Properties();

		try {
			String pathP = new File("src/main/resources/p.properties").getCanonicalPath();

			InputStream inputP = new FileInputStream(pathP);

			propP.load(inputP);

			if (propP.getProperty(login.getLogin()).equals(login.getPassword())) {
				return true;
			} else {
				return false;
			}

		} catch (IOException e) {
			return false;
		}

		catch (NullPointerException e) {
			return false;
		}

	}
}
