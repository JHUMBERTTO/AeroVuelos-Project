
package conexionBD;

import java.sql.DriverManager;

/**
 *
 * @author Iván
 */
public class BorrarBD extends InterBD {
    
    public BorrarBD() {
        super();
        
        trace = "notrace";
    }
    
    public int borrarVuelo(String cod_vue) {
        
        try {
            
            try {

                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN");
                
                trace = "Error al establecer la conexión";

            }
            
            st=cx.createStatement();
            
            st.execute("DELETE FROM MVuelos WHERE cod_vue='" + cod_vue + "';");
            
            System.out.println("ELIMINACIÓN EXITOSA");
            
            cerrar();
            
            return 1;
            
        } catch (Exception e) {
            
            System.out.println("ERROR AL ELIMINAR");
            
            trace = e.getMessage();
            
            return -1;
            
        }
        
    }
    
    public String getTrace() {
        
        return trace;
        
    }
    
    public String trace;
    
}
