/**
 * 
 */
package BookRecords.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import BookRecords.BeanConfiguration.BeanConfiguration;
import BookRecords.Model.Book;
import BookRecords.Model.BookImplemention;

public class Service {
	public static void main(String... args) {
		try {
			System.out.println("HLEO");
			ApplicationContext act = new AnnotationConfigApplicationContext(BeanConfiguration.class);
			BookImplemention bookImplemention = act.getBean(BookImplemention.class);
			System.out.println(bookImplemention.read("1"));
			System.out.println("***********************************");
			Book book = bookImplemention.readObject("1");
			System.out.println(book.toString());

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}
