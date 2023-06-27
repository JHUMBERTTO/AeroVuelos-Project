import java.sql.*;

class JSP {

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
    password = "",
    driver = "com.mysql.cj.jdbc.Driver", 
    user = "root", 
    url = "jdbc:mysql://localhost:3306/reg@losdb";

    protected Connection cx;
    protected PreparedStatement st;

}

class UpdateBD  extends InterBD {

    public UpdateBD () {
        super();
    }

    public int RegistrarVuelos () {

        try {
            
            abrirCX(cx);

            st = cx.prepareStatement("INSERT INTO ");

            st.executeUpdate(driver);

            return 1;

        } catch (Exception e) {
            
            return -1;

        }

    }

}