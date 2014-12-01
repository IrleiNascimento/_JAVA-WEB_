/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**
 *
 * @author Irlei
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class InicializaContextoListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		sc.setAttribute("pagina1", new Integer(0));
                sc.setAttribute("pagina2", new Integer(0));
	}

	public void contextDestroyed(ServletContextEvent event) {}

}