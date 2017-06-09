/**
 * 
 */
package BookRecords.BeanConfiguration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import BookRecords.DAO.Dao;
import BookRecords.Model.BookImplemention;

@Configuration
public class BeanConfiguration {
	@Bean
	public 	BookImplemention getBookImplemention(){
		BookImplemention bookImplemention = new BookImplemention();
		bookImplemention.setJdbcTemplate(getJdbcTemplate());
		return bookImplemention;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	public DataSource getDataSource(){
		return Dao.getDriverManagerDataSource();
	}
}
