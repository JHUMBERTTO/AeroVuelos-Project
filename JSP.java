import java.sql.*;

class JSP {

}

abstract class InterBD {

    public int abrirCX (Statement stat) {

        try {
            
            Class.forName(driver);

            cx = DriverManager.getConnection(url, user, password);

            stat = cx.createStatement();

            return 1;

        } catch (Exception e) {
            
            return -1;

        }


    }

    public int cerrar() {

        try {
            
            cx.close();

            return 1
            
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
    protected Statement st;

}

class UpdateBD  extends InterBD {

    public UpdateBD () {
        super();
    }

    public int RegistrarVuelos () {

        try {
            
            abrirCX(st);

        } catch (Exception e) {
            
            return -1;

        }

    }

}