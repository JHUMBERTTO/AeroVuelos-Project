<%-- 
    Document   : BorrarJSP
    Created on : 1 jul 2023, 15:19:41
    Author     : Iván
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="conexionBD.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrando...</title>
    </head>
    <body>
        <h1>Borrando...</h1>

        <%
            
        try {
        
        String cod_vue = request.getParameter("cod_vue");
        
        BorrarBD borrar = new BorrarBD();
        
        int resultado = borrar.borrarVuelo(cod_vue);
        
        out.println("<p>Resultado de borrar: " + resultado + "</p>");
        
        out.println("<p>" + borrar.getTrace() + "</p>");
        
        response.sendRedirect("../flightManagement.jsp");
        
            } catch (Exception e) {
            
            out.println("<p>Borrar falló</p>");
            
            out.println("<p>" + e.getMessage() + "</p>");
            
            }
        
        %>

    </body>
</html>
