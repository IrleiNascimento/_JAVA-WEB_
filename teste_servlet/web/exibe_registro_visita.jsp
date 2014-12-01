<%--
    Document   : exibe_registro_visita
    Created on : 30/11/2014, 21:15:47
    Author     : Irlei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de visitas Utilizando Cookies</h1>
        <% Cookie c[] = request.getCookies();

            String pagina1 = "pagina1";
            String pagina2 = "pagina2";
            for (int i = 0; i < c.length; i++) {
                if (c[i].getName().equals(pagina1) || c[i].getName().equals(pagina2)) {

                    out.print("<br>Nome da pagina :" + c[i].getName()+".xhtml");
                    out.print("<br>Numero de visitas :" + c[i].getValue());
                    out.print("<br>____________________________________");

                } else if(i>0){
                    out.print("<br>Nenhum registro de visita...");
                }
            }
        %>

        <h1>Registro de visitas Utilizando ServletRequestListener</h1>
        <%
            int contador1 = (Integer) request.getServletContext().getAttribute(pagina1);
            int contador2 = (Integer) request.getServletContext().getAttribute(pagina2);
            if (contador1 != 0) {
                out.print("<br>Nome da pagina :" + pagina1+".xhtml");
                out.print("<br>Numero de visitas :" + contador1);
                out.print("<br>____________________________________");
            }
            if (contador2 != 0) {
                out.print("<br>Nome da pagina :" + pagina2+".xhtml");
                out.print("<br>Numero de visitas :" + contador2);
                out.print("<br>____________________________________");
            } else {
                out.print("<br>Nenhum registro de visita...");
            }
        %>
    </body>
</html>
