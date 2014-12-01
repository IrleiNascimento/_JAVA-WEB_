/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.Cookie;

/**
 *
 * @author Irlei
 */
public class ContadorServletRequestListener implements ServletRequestListener{


    // ação realizada para quando o servlet for destruido
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
    // ação realizada para quando o servlet for inicializado
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
    // o paramentro sempre será o nome da pagiana
  String param=  sre.getServletRequest().getParameter("p");

  ServletContext sc = sre.getServletContext();
		synchronized (sc) {
    if(param!=null){
        int count =0;
        count = (Integer)sc.getAttribute(param);
        if(count!=0){
          count++;
        sc.setAttribute(param, new Integer(count));
        }else{
        sc.setAttribute(param, new Integer(1));
        }
    }
    }
    }

    }



