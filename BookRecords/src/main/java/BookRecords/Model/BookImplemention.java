/**
 * 
 */
package BookRecords.Model;

import org.springframework.jdbc.core.JdbcTemplate;


public class BookImplemention {
	private static JdbcTemplate jdbcTemplate = null;
	public String read(String id){
		return jdbcTemplate.queryForObject("select author From book where id = ?", new Object[]{id},String.class);
	}
	
	public Book readObject(String id){
		String sql = "SELECT * from book WHERE id = " + id;

		Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper());
		return book;
		
	}
	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		BookImplemention.jdbcTemplate = jdbcTemplate;
	}
	
}
