<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrar vuelo - AeroVuelos</title>
        <link rel="stylesheet" href="FlightManagement.css">
    </head>

    <body>
        <header class="Header">
            <nav class="Header-nav">
                <div class="Header-container-left">
                    <div class="Header-logo">
                        <a class="Header-alink" href="">
                            <img class="Header-img-left" src="./Public/img/iconAeroVuelos.png">
                            <img class="Header-img-right" src="./Public/img/aeroVuelosNameLogo.png">
                        </a>
                    </div>     
                    <div class="Header-menu">
                        <ul><a class="Header-option" href="">Inicio</a></ul>
                        <ul><a class="Header-option" href="">Contacto</a></ul>
                        <ul><a class="Header-option" href="">Area de Trabajo</a></ul>
                    </div>
                </div>
                <div class="Header-container-right">
                    <a href="">
                        <button class="Header-button-registrar">Registrar</button>
                    </a>
                </div>
            </nav>
        </header>
        <main class="Main">
            <div  class="Main-container-center">
                <h1 class="Main-container-title">
                    Administrar vuelos
                </h1>

                <!--Formulario-->
                <form  action="flightManagement.jsp" method="POST">

                    <div class="Main-container-form">
                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Codigo del vuelo</label>
                            <input class="Main-container-form-input" type="text" name="cod_vue">
                        </div>

                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Origen del vuelo</label>
                            <input class="Main-container-form-input" type="text" name="ori_vue">
                        </div>

                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Destino del vuelo</label>
                            <input class="Main-container-form-input" type="text" name="des_vue">
                        </div>

                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Salida del vuelo</label>
                            <input class="Main-container-form-input" type="date" name="dia_vue">
                        </div>

                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Numero de asientos del vuelo</label>
                            <input class="Main-container-form-input" type="number" name="nda_vue"> 
                        </div>
                    </div>

                    <div class="Main-container-div-buttons">
                        <button class="Main-container-buttons" type="submit">Guardar</button>
                        <button class="Main-container-buttons">Editar</button>
                        <button class="Main-container-buttons">Borrar</button>
                    </div>

                </form>


                <div class="Main-container-table">
                    <table>
                        <thead>
                            <tr>
                                <th>Codigo del vuelo</th>
                                <th>Origen del vuelo</th>
                                <th>Destino del vuelo</th>
                                <th>Salida del vuelo</th>
                                <th>Nda del vuelo</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!--El contenido (tbody) de genera con jsp-->
                            
                            <%
                                
                            ConsultaBD consulta = new ConsultaBD();
                            
                            
                            ResultSet vuelos = consulta.consultarVuelo();
                            
                            while (vuelos.next()) {
                            
                                out.println("<tr>");
                                out.println("<td>");
                                out.println(vuelos.getString(1));
                                out.println("</td>");
                                out.println("<td>");
                                out.println(vuelos.getString(2));
                                out.println("</td>");
                                out.println("<td>");
                                out.println(vuelos.getString(3));
                                out.println("</td>");
                                out.println("<td>");
                                out.println(vuelos.getString(4));
                                out.println("</td>");
                                out.println("<td>");
                                out.println(vuelos.getString(5));
                                out.println("</td>");
                                out.println("</tr>");
                            
                                }
                                
                                consulta.cerrar();

                             %>
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
        <footer>
            <div class="Main-container-bottom">
                <button class="Main-bottom-button" >Regresar</button>
            </div>
        </footer>
    </body>

</html>