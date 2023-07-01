
package conexionBD;

/**
 *
 * @author Iván
 */
public class BorrarBD extends InterBD {
    
    public BorrarBD() {
        super();
    }
    
    public int borrarVuelo(String cod_vue) {
        
        try {
            
            abrirCX(cx);
            
            st=cx.createStatement();
            
            st.execute("DELETE FROM MVuelos WHERE cod_vue = " + cod_vue + ";");
            
            System.out.println("ELIMICAIÓN EXITOSA");
            
            cerrar();
            
            return 1;
            
        } catch (Exception e) {
            
            System.out.println("ERROR AL ELIMINAR");
            
            return -1;
            
        }
        
    }
}
