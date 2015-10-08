package application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class MyResourceConfig extends ResourceConfig {

	public MyResourceConfig() {
		packages("resources");
	}
	
}
