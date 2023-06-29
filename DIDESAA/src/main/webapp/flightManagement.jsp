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

                <%
                    
                    class BDConnector {
  
}

//Clase abstracta de la que heredan las otras. Para ahorrar líneas, básicamente.
abstract class InterBD {

    public int abrirCX (Connection con) {

        try {
            
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);

            System.out.println("CONEXIÓN ESTABLECIDA");

            return 1;

        } catch (Exception e) {
            
            return -1;

        }


    }

    public int cerrar() {

        try {
            
            cx.close();
            System.out.println("CONEXIÓN CERRADA");

            System.out.println("Código de resultado cerrar conexión: " + 2);

            return 2;
            
        } catch (Exception e) {

            System.out.println("Código de resultado cerrar conexión: " + -2);
            
            return -2;

        }

    }

    /*
     * Datos de la base de datos creada en la pc local de Iván. Si quieres usar el código,
     * créate tu propia base de datos en tu pc utilizando el archivo DIDESAABD.mwb, y coloca
     * aquí los datos relacionados la nombre de la base que decidas, así como tu contraseña de
     * mySQL y tu usuario.
     */
    protected String 
    password = "1Lapassword-",
    driver = "com.mysql.cj.jdbc.Driver", 
    user = "root", 
    url = "jdbc:mysql://localhost:3306/didesaa";

    protected Connection cx;
    protected Statement st;

}

//Clase que hace updates a BD

/*
 * 
 * ¿Quizá convenga hacer una clase para cada una de las ventanas de la aplicación, que sólo
 * implemente los métodos necesarios en cada página? Eso ahorraría líneas y lo haría todo mucho
 * más sencillo.
 * 
 * Aunque claro, eso sólo si se implementan más ventanas de la app...
 */
class UpdateBD  extends InterBD {

    public UpdateBD () {
        super();
    }

    public int registrarVuelo (String cod_vue, String ori_vue,  String des_vue,  String dia_vue, String nda_vue) {
        try {

            try {
            
                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN");

            }

            /*
            st = cx.prepareStatement("INSERT INTO `MVuelos`(`cod_vue`, `ori_vue`, `des_vue`, `dia_vue`, `nda_vue`) VALUES (?, ?, ?, ?, ?);");
            
            

            st.setString(1, cod_vue);
            st.setString(2, ori_vue);
            st.setString(3, des_vue);
            st.setString(4, dia_vue);
            st.setString(5, nda_vue);

            st.execute();
            */

            st = cx.createStatement();

            st.executeUpdate("INSERT INTO `MVuelos`(`cod_vue`, `ori_vue`, `des_vue`, `dia_vue`, `nda_vue`) VALUES ('" + cod_vue + "', '" + ori_vue + "', '" + des_vue + "', '" + dia_vue + "', '" + nda_vue + "');");

            System.out.println("UPDATE EJECUTADA CORRECTAMENTE");

            cerrar();

            return 3;

        } catch (Exception e) {
            
            System.out.println("ERROR AL HACER EL UPDATE");
            System.out.println(e.getMessage());
            return -3;

        }

    }

}

//Clase para realizar consultas a BD, básicamente, recuperar datos.
class ConsultaBD extends InterBD {

    public ConsultaBD () {

        super();

    }

    //Consulta los códigos de vuelo existentes en BD
    public ResultSet ConsultarCodVuelos() {

        try {
            
            try {

                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN");

            }

            st = cx.createStatement();

            ResultSet result = st.executeQuery("SELECT cod_vue FROM `MVuelos`;");

            System.out.println("QUERY EJECUTADO CORRECTAMENTE");

            return result;

        } catch (Exception e) {
            
            System.out.println("ERROR AL HACER EL QUERY");
            System.out.println(e.getMessage());
            return null;

        }

    }

    //Consulta un vuelo específico
    public ResultSet consultarVuelo (String cod_vue) {

        try {
            
            try {

                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN");

            }

            st = cx.createStatement();

            ResultSet result = st.executeQuery("SELECT * FROM `MVuelos` WHERE cod_vue = '" + cod_vue + "';");

            System.out.println("QUERY EJECUTADO CORRECTAMENTE");

            return result;

        } catch (Exception e) {
            
            System.out.println("ERROR AL HACER EL QUERY");
            System.out.println(e.getMessage());
            return null;

        }

    }

    //Consulta TODOS los vuelos
    public ResultSet consultarVuelo () {

        try {
            
            try {

                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN");

            }

            st = cx.createStatement();

            ResultSet result = st.executeQuery("SELECT * FROM `MVuelos`;");

            System.out.println("QUERY EJECUTADO CORRECTAMENTE");

            return result;

        } catch (Exception e) {
            
            System.out.println("ERROR AL HACER EL QUERY");
            System.out.println(e.getMessage());
            return null;

        }

    }

}

                    System.out.println("EJECUCIÓN");

                String 
                        cod_vue = request.getParameter("cod_vue"),
                        ori_vue = request.getParameter("ori_vue"),
                        des_vue = request.getParameter("des_vue"),
                        dia_vue = request.getParameter("dia_vue"),
                        nda_vue = request.getParameter("nda_vue");

                    UpdateBD conexion = new UpdateBD();

                    System.out.println(cod_vue);
                    System.out.println(ori_vue);
                    System.out.println(des_vue);
                    System.out.println(dia_vue);
                    System.out.println(nda_vue);

                    int resultado = conexion.registrarVuelo(cod_vue, ori_vue, des_vue, dia_vue, nda_vue);

                    System.out.println("El resultado del registro es " + resultado);
                %>


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
                            <tr>
                                <td>DX254SDA</td>
                                <td>CDMX</td>
                                <td>Culiacan</td>
                                <td>1-may-2024</td>
                                <td>120</td>
                            </tr>
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