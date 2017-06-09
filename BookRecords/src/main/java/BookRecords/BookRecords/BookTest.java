/**
 * 
 */
package BookRecords.BookRecords;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author vinod<vinod.pal@nanobi.in(EmpId:1112)
 * @organization NanoBi Analytics
 */
@Path("/bookTest")
public class BookTest {
	
    @GET
	    @Produces(MediaType.TEXT_PLAIN)
	    public String getItb() {
	        return "Got it!";
	    }
	
}
