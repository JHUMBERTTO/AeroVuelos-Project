package conexionBD;

import java.sql.DriverManager;

/**
 *
 * @author Iván
 */
public class RegistroBD extends InterBD {
    
    public RegistroBD () {
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
