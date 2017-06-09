/**
 * 
 */
package BookRecords.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Dao {
	private static DriverManagerDataSource driverManagerDataSource;
	private static ResourceBundle resourceBundle;
	public static DriverManagerDataSource getDriverManagerDataSource() {
		return driverManagerDataSource;
	}
	static {
		setResourceBundle(null);
		setDriverManagerDataSource(null);
	}
	private static void setDriverManagerDataSource(DriverManagerDataSource driverManagerDataSource) {
		
		try {
			Dao.driverManagerDataSource = new DriverManagerDataSource();
			Dao.driverManagerDataSource
					.setDriverClassName(Dao.resourceBundle.getString("dataobject.jdbc.driverClassName"));
			Dao.driverManagerDataSource.setUrl(Dao.resourceBundle.getString("dataobject.jdbc.url"));
			Dao.driverManagerDataSource.setUsername(Dao.resourceBundle.getString("dataobject.jdbc.username"));
			Dao.driverManagerDataSource.setPassword(Dao.resourceBundle.getString("dataobject.jdbc.password"));

		}catch(Exception exception){
			
		}
		
	}

	public static ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public static void setResourceBundle(ResourceBundle resourceBundle) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(System.getenv("NB_HOME")).append(java.io.File.separator).append("database.properties");
			Dao.resourceBundle = new PropertyResourceBundle(new FileInputStream(new File(sb.toString())));
			} catch (Exception exception) {

		}
		//Dao.resourceBundle = resourceBundle;
	}
	
}

