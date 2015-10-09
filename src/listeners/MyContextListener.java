package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.Repository;

public class MyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Context Initialized");
		Repository.initialize();
	}

}
