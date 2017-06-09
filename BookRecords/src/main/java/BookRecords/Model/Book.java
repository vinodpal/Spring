/**
 * 
 */
package BookRecords.Model;

import java.util.Comparator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")
public class Book implements Comparator {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Get Book!";
	}

	String id;
	String name;
	String author;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object == this)
			return true;
		if (!(object instanceof Book)) {
			return ((Book) object).getId().equals(this.getId()) && ((Book) object).getName().equals(this.getName());
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object o1, Object o2) {
		return ((Book) o1).getName().compareTo(((Book) o2).getName());
	}

	public static Comparator bookCompartor = new Comparator() {
		@Override
		public int compare(Object o1, Object o2) {
			return ((Book) o1).getName().compareTo(((Book) o2).getName());
		}

	};
	
	@Override
	public String toString(){
		return "Id : " +getId() + " , Name : "+getName() + " , Author : "+getAuthor();
	}

}
