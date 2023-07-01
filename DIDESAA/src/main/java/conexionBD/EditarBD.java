package conexionBD;

/**
 *
 * @author Iván
 */
public class EditarBD extends InterBD {
    
    public EditarBD() {
        
        super();
        
    }
    
    public int editarVuelo(String original, String cod_vue, String ori_vue, String des_vue, String dia_vue, String nda_vue) {
        
        try {
            
            abrirCX(cx);
            
            st = cx.createStatement();
            
            st.execute("UPDATE MVuelos SET cod_vue = '" + cod_vue + "', ori_vue = '" + ori_vue + "' , des_vue = '" + des_vue + "', dia_vue = '" + dia_vue + "', nda_vue = '" + dia_vue + "' WHERE cod_vue = '" + original +"';");
            
            System.out.println("EDICIÓN REALIZADA");
            
            cerrar();
            
            return 1;
            
        } catch (Exception e) {
            
            
            return -1;
            
        }
        
    }
    
}
