/**
 * 
 */
package BookRecords.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

		Book book = new Book();
		book.setId(rs.getString("id"));
		book.setName(rs.getString("name"));
		book.setAuthor(rs.getString("author"));
		return book;
	}
	static public List<Book> getAllBooksRowMapper(){  
		 return BookImplemention.jdbcTemplate.query("select * from book",new RowMapper<Book>(){  
		    @Override  
		    public Book mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	Book e=new Book();  
		        e.setId(rs.getString(1));  
		        e.setName(rs.getString(2));  
		        e.setAuthor(rs.getString(3));  
		        return e;  
		    }  
		    });  
		}
	static public int deleteBook(String id){
		return BookImplemention.jdbcTemplate.update("delete from book where id = "+id);
	}

}
