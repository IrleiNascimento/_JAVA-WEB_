/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Irlei
 */
@WebServlet(name = "contadorDeVisitaServilet", urlPatterns = {"/resgistralink"})
public class ContadorDeVisitaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        // O REGISTRO UTLIZANDO ServletRequestListener  SE DÁ NO MOMENTO EM QUE ESTE SERVLET É CHAMADO




        // REGISTRANDO UTILIZANDO ACESSO UTILIZANDO COOKIES
        String nomePagina = request.getParameter("p");
        if (nomePagina != null) {
            Cookie visitas = null;
            Cookie cookies[] = request.getCookies();
            int count;
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    //o nome do cookie  será o o mesmo nome da pagina
                    if (cookies[i].getName().equals(nomePagina)) {
                        visitas = cookies[i];
                        break;
                    }
                }
                // se o cookie ainda com esse nome ainda não existe, entaõ ele sera criado
                if (visitas == null) {
                    Cookie cookie = new Cookie(nomePagina, "1");
                    response.addCookie(cookie);

                } else {
                    // ou se ja existe então apenas incrementa e adiciona
                    count = Integer.parseInt(visitas.getValue());
                    count++;
                    visitas.setValue(String.valueOf(count));
                    response.addCookie(visitas);
                }
            }

        }
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + request.getParameter("p") + ".xhtml</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + request.getParameter("p") + ".xhtml</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
