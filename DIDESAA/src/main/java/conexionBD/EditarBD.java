package conexionBD;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Iván
 */
public class EditarBD extends InterBD {
    
    public EditarBD() {
        
        super();
        
        trace = "No trace";
        
    }
    
    public int editarVuelo(String original, String cod_vue, String ori_vue, String des_vue, String dia_vue, String nda_vue) {
        
        try {
            
            try {

                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA CON EXITO");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN NO TUVIMOS EXITO");

            }
            
            st = cx.createStatement();
            
        } catch (SQLException e) {
            
            trace = e.getMessage();
            
            return -1;
            
        }
        
        try {
            
            st.execute("UPDATE didesaa.mvuelos SET ori_vue = '" + ori_vue + "' , des_vue = '" + des_vue + "', dia_vue = '" + dia_vue + "', nda_vue = " + nda_vue + " WHERE cod_vue = '" + original +"';");
            
        } catch  (SQLException e) {
            
            trace = e.getMessage();
            
            return -2;
            
        }
        
        try {
            
            System.out.println("EDICIÓN REALIZADA");
            
            cerrar();
            
            return 1;
            
        } catch (Exception e) {
            
            trace = e.getMessage();
            
            return -3;
            
        }
        
    }
    
    public String getTrace() {
        
        return trace;
        
    }
    
    public String trace;
}
