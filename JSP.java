import java.sql.*;

class JSP {

    public static void main(String args[]) {
        
        UpdateBD prueba = new UpdateBD();
        
        System.out.println(prueba.RegistrarVuelo("Codigo", "Origen", "Destino", "00/00/0000", 1));
        
    }
    
}

abstract class InterBD {

    public int abrirCX (Connection con) {

        try {
            
            Class.forName(driver);

            con = DriverManager.getConnection(url, user, password);

            return 1;

        } catch (Exception e) {
            
            return -1;

        }


    }

    public int cerrar() {

        try {
            
            cx.close();

            return 1;
            
        } catch (Exception e) {
            
            return -1;

        }

    }

    protected String 
    password = "1Lapassword-",
    driver = "com.mysql.cj.jdbc.Driver", 
    user = "root", 
    url = "jdbc:mysql://localhost:3306/didesaa";

    protected Connection cx;
    protected PreparedStatement st;

}

class UpdateBD  extends InterBD {

    public UpdateBD () {
        super();
    }

    public int RegistrarVuelo (String cod_vue, String ori_vue,  String des_vue,  String dia_vue, int nda_vue) {

        try {
            
            abrirCX(cx);

            st = cx.prepareStatement("INSERT INTO `MVuelos`(`cod_vue`, `ori_vue`, `des_vue`, `dia_vue`, `nda_vue`) VALUES ('?', '?', '?', '?', '?');");
            
            st.setString(1, cod_vue);
            st.setString(2, ori_vue);
            st.setString(3, des_vue);
            st.setString(4, dia_vue);
            st.setInt(5, nda_vue);

            st.execute();

            cerrar();

            return 1;

        } catch (Exception e) {
            
            return -1;

        }

    }

}