package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.Model;


public class MyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Context Initialized");
		event.getServletContext().setAttribute("model", new Model());
	}

}
