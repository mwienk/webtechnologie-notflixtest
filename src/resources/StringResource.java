package resources;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.Model;

@Path("/strings")
public class StringResource {
	
	@Context
	private ServletContext context; 
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})
	public String returnString(){
		Model model = (Model) context.getAttribute("model");
		
		return model.toString();
	}
	

}
