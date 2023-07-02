<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*"%>
<%@ page import="conexionBD.*"%>
<%@ page import="conexionBD.RegistroBD"%>

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
                <form  action="flightManagement.jsp" method="POST" id="formulario">

                    <div class="Main-container-form">
                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Codigo del vuelo</label>
                            <input class="Main-container-form-input" type="text" name="cod_vue" id="cod_vue">
                        </div>

                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Origen del vuelo</label>
                            <input class="Main-container-form-input" type="text" name="ori_vue" id="ori_vue">
                        </div>

                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Destino del vuelo</label>
                            <input class="Main-container-form-input" type="text" name="des_vue" id="des_vue">
                        </div>

                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Salida del vuelo</label>
                            <input class="Main-container-form-input" type="date" name="dia_vue" id="dia_vue">
                        </div>

                        <div class="Main-container-div">
                            <label class="Main-container-form-label" for="">Numero de asientos del vuelo</label>
                            <input class="Main-container-form-input" type="number" name="nda_vue" id="nda_vue"> 
                        </div>
                    </div>

                    <div class="Main-container-div-buttons">
                        <button class="Main-container-buttons" type="submit">Guardar</button>
                        <button class="Main-container-buttons" id="Editar-button">Editar</button>
                        <button class="Main-container-buttons" id="Borrar-button">Borrar</button>
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

                        <script>
                            //Creación del array que contendrá los objetos sobre los datos de cada vuelo
                            const infoElementos = [];
                        </script>
                        
                        <!--JSP que registra vuelos-->
                        <%
                    
                            System.out.println("Hola!");
                            try {
                
                            String cod_vue = request.getParameter("cod_vue");
                            String ori_vue = request.getParameter("ori_vue");
                            String des_vue = request.getParameter("des_vue");
                            String dia_vue = request.getParameter("dia_vue");
                            String nda_vue = request.getParameter("nda_vue");
                    
                            RegistroBD registrar = new RegistroBD();
                
                            registrar.registrarVuelo(cod_vue, ori_vue, des_vue, dia_vue, nda_vue);
                
                            } catch (Exception e) {
                    
                            System.out.println("ERROR AL LEER LOS DATOS DEL REQUEST");
                    
                            }
                            
                        %>

                        <!--El contenido (tbody) de genera con jsp-->

                        <%
                                
                        ConsultaBD consulta = new ConsultaBD();
                        ResultSet vuelos = consulta.consultarVuelo();
                            
                        try {
                            
                        int contador = 0;
                            
                            while (vuelos.next()) {
                                
                            contador++;

                            //Ésto imprime la tabla
                                    out.println("<tr class='Flight-list-element' id='List-element-" + contador + "'>");
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
                                        
                                    //Éste script crea objetos con los valores de cada entrada
                                    out.println("<script>");
                                    
                                    out.println("infoElementos.push({");
                                    out.println("cod_vue: '" + vuelos.getString(1) + "',");
                                    out.println("ori_vue: '" + vuelos.getString(2) + "',");
                                    out.println("des_vue: '" + vuelos.getString(3) + "',");
                                    out.println("dia_vue: '" + vuelos.getString(4) + "',");
                                    out.println("nda_vue: " + vuelos.getString(5));
                                    out.println("});");
                                    
                                    out.println("</script>");
                                    
                                }
                                    
                                out.println("<script>");
                                    
                                out.println("const numElementos = " + contador + ";");
                                    
                                out.println("</script>");
                                
                            consulta.cerrar();
                            
                            } catch (Exception e) {
                                
                                System.out.println("ERROR AL IMPRIMIR LOS RESULTADOS");

                                out.println("<tr>");

                                out.println("<td colspan='5'>");

                                out.println("<p>¡No hay vuelos para mostrar!</p>");

                                out.println("</td>");

                                out.println("</tr>");
                                
                            }
                            

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


    <script>

        console.log("El número de elementos es de " + numElementos);
        const elementoLista = (numeroElemento) => {

            const elemento = document.querySelector("#List-element-" + numeroElemento);
            //Aquí la acción al dar click
            elemento.addEventListener('click', () => {

                console.log("click en " + numeroElemento);
                //Obteniendo los inputs
                const codigo = document.getElementById("cod_vue");
                const origen = document.getElementById("ori_vue");
                const destino = document.getElementById("des_vue");
                const salida = document.getElementById("dia_vue");
                const asientos = document.getElementById("nda_vue");
                codigo.value = infoElementos[numeroElemento - 1].cod_vue;
                origen.value = infoElementos[numeroElemento - 1].ori_vue;
                destino.value = infoElementos[numeroElemento - 1].des_vue;
                salida.value = infoElementos[numeroElemento - 1].dia_vue;
                asientos.value = infoElementos[numeroElemento - 1].nda_vue;
            });
          };
          
        //Función para el botón EDITAR
         const editar = (elemento) => {

            elemento.addEventListener('click', () => {

                const form = document.getElementById("formulario");

                form.action = "BDJSP/EditarJSP.jsp";

                form.submit();

                 });

        };
        
        //Función para el botón BORRAR
        const borrar = (elemento) => {
          
          elemento.addEventListener('click', () => {
             
            const form = document.getElementById("formulario");
            
            form.action ="BDJSP/BorrarJSP.jsp";
            
          });
        
        };

        //Asignando la función a cada elemento de la lista
        for (let contador = numElementos; contador > 0; contador--) {

        elementoLista(contador);
        }

        //Asignando la función a cada botón

        editar(document.getElementById("Editar-button"));
        
        borrar(document.getElementById("Borrar-button"));

    </script>
</html>