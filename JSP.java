import java.sql.*;

class JSP {

    public static void main(String args[]) {
        
        UpdateBD prueba = new UpdateBD();
        
        System.out.println("EL RESULTADO ES DE " + prueba.RegistrarVuelo("Codigo", "Origen", "Destino", "2023-01-01", "1"));

        
    }
    
}

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

            return 2;
            
        } catch (Exception e) {
            
            return -2;

        }

    }

    protected String 
    password = "1Lapassword-",
    driver = "com.mysql.cj.jdbc.Driver", 
    user = "root", 
    url = "jdbc:mysql://localhost:3306/didesaa";

    protected Connection cx;
    protected Statement st;

}

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

            System.out.println("Código de resultado cerrar conexión: " + resultadoCerrar);

            return 3;

        } catch (Exception e) {
            
            System.out.println("ERROR AL HACER EL UPDATE");
            System.out.println(e.getMessage());
            return -3;

        }

    }

}