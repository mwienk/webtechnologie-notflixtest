package application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class MyResourceConfig extends ResourceConfig {

	public MyResourceConfig() {
		System.out.println("Config loaded");
		packages("resources");
		register(com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider.class);
	}
	
}
