import java.sql.*;


//Clase con la única finalidad de probar todo el asunto
class JSP {

    public static void main(String args[]) {
        
        //Prueba de update

        /*
        UpdateBD prueba = new UpdateBD();
        
        System.out.println("EL RESULTADO ES DE " + prueba.RegistrarVuelo("Codigo_2", "Origen", "Destino", "2023-01-01", "1"));
        */

        //Prueba de ConsultarCodVuelo

        ConsultaBD consulta = new ConsultaBD();

        ResultSet ids = consulta.ConsultarCodVuelos();

        try {
            
            int contador = 0;

            while (ids.next()) {

                contador++;

                System.out.println("ID: " + ids.getString(1) + " Número: " + contador);

                
            }

        } catch (Exception e) {
            
            System.out.println("ERROR AL IMPRIMIR LOS DATOS");
            System.out.println(e.getMessage());

        }

        consulta.cerrar();

        //Prueba de ConsultarVuelo
        ResultSet result = consulta.consultarVuelo("Codigo");

        try {
            result.next();
            
            System.out.println("El código de vuelo es " + result.getString("cod_vue"));
            System.out.println("El código de vuelo es " + result.getString("ori_vue"));
            System.out.println("El código de vuelo es " + result.getString("des_vue"));
            System.out.println("El código de vuelo es " + result.getString("dia_vue"));
            System.out.println("El código de vuelo es " + result.getString("nda_vue"));

        } catch (Exception e) {
            
            System.out.println("ERROR AL IMPRIMIR EL VUELO");

        }

        consulta.cerrar();

    }
    
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

    public int RegistrarVuelo (String cod_vue, String ori_vue,  String des_vue,  String dia_vue, String nda_vue) {

        

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

            int resultadoCerrar = cerrar();

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