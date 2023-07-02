package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Iván
 */
public abstract class InterBD {

    public int abrirCX(Connection con) {

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
    final protected String 
            password = "1Lapassword-",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            url = "jdbc:mysql://localhost:3306/didesaa";

    protected Connection cx;
    protected Statement st;

}
