/**
 * 
 */
package BookRecords.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import BookRecords.BeanConfiguration.BeanConfiguration;
import BookRecords.Model.Book;
import BookRecords.Model.BookImplemention;
import javassist.bytecode.Descriptor.Iterator;

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
			/*List<Map<String, Object>> list = bookImplemention.readListObject();
			for(int itr=0;itr<list.size();++itr){
				Map map =(Map)list.get(itr);
				map.forEach((x,y)->System.out.println(x+" : "+y.toString()));
			}*/
			
			List<Book> list =  bookImplemention.getListBooks(); 
			for(int itr= 0; itr<list.size(); ++itr){
				System.out.println(list.get(itr).toString());
			}
			
			//Delete Book using ids
			book = bookImplemention.getDelete("1");
			if(book!=null){
				System.out.println("Delete Book  : " +book.toString());
			}
			
			
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}
