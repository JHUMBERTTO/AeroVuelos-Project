<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="conexionBD.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editando...</title>
    </head>
    <body>

        <h1>Editando...</h1>
        <%
            
            try {
            
            String cod_vue = request.getParameter("cod_vue");
            String ori_vue = request.getParameter("ori_vue");
            String des_vue = request.getParameter("des_vue");
            String dia_vue = request.getParameter("dia_vue");
            String nda_vue = request.getParameter("nda_vue");
            
            EditarBD editar = new EditarBD();
        
             int resultado = editar.editarVuelo(cod_vue, cod_vue, ori_vue, des_vue, dia_vue, nda_vue);
             
             System.out.println("El resultado de editar es " + resultado);
             out.println("<p>El resultado de editar es " + resultado + "</p>");
             out.println("<p>" + editar.getTrace() +  "</p>");
             
             response.sendRedirect("../flightManagement.jsp");
            
            } catch (Exception e) {
            
            System.out.println("ERROR AL EDITAR");
            
            out.println("<p>ERROR AL EDITAR</p>");
            out.println("<p>" + e.getMessage() + "</p>");
            
            //response.sendRedirect("../flightManagement.jsp");
            
            }
            
        %>
    </body>
</html>
