/**
 * 
 */
package BookRecords.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

		Book book = new Book();
		book.setId(rs.getString("id"));
		book.setId(rs.getString("name"));
		book.setId(rs.getString("author"));
		return book;
	}

}
