package BookRecords.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;


public class BookImplemention {
	public static JdbcTemplate jdbcTemplate = null;

	public String read(String id) {
		return jdbcTemplate.queryForObject("select author From book where id = ?", new Object[] { id }, String.class);
	}

	public Book readObject(String id) {
		String sql = "SELECT * from book WHERE id = " + id;
		Book book = jdbcTemplate.queryForObject(sql, new BookRowMapper());
		return book;
	}

	public List<Map<String, Object>> readListObject() {
		String sql = "Select * From book";
		List<Map<String, Object>> listOfBooks = jdbcTemplate.queryForList(sql, new BookRowMapper());
		return listOfBooks;
	}

	public List<Book> getListBooks() {
		return BookRowMapper.getAllBooksRowMapper();
	}

	public Book getDelete(String id) {
		Book bookObject = readObject(id);
		if (BookRowMapper.deleteBook(id) > 0) {
			return bookObject;
		} else {
			return null;
		}
	}

	public int save(Book book) {
		String sql = "INSERT INTO book (id,name,author) values (\"" + book.getId() + "\",\"" + book.getName() + "\",\""
				+ book.getAuthor() + "\"";
		return jdbcTemplate.update(sql);
	}

	public int update(Book book) {
		String sql = "UPDATE book set name = \"" + book.getName() + "\", author = \"" + book.getAuthor()
				+ "\" WHERE id =\"" + book.getId() + "\"";
		return jdbcTemplate.update(sql);
	}

	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		BookImplemention.jdbcTemplate = jdbcTemplate;
	}
}
