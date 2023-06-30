/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionBD;

import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Iván
 */
public class ConsultaBD extends InterBD {

    public ConsultaBD() {

        super();

    }

    //Consulta los códigos de vuelo existentes en BD
    public ResultSet ConsultarCodVuelos() {

        try {

            try {

                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN");

            }

            st = cx.createStatement();

            ResultSet result = st.executeQuery("SELECT cod_vue FROM `MVuelos`;");

            System.out.println("QUERY EJECUTADO CORRECTAMENTE");

            return result;

        } catch (Exception e) {

            System.out.println("ERROR AL HACER EL QUERY");
            System.out.println(e.getMessage());
            return null;

        }

    }

    //Consulta un vuelo específico
    public ResultSet consultarVuelo(String cod_vue) {

        try {

            try {

                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN");

            }

            st = cx.createStatement();

            ResultSet result = st.executeQuery("SELECT * FROM `MVuelos` WHERE cod_vue = '" + cod_vue + "';");

            System.out.println("QUERY EJECUTADO CORRECTAMENTE");

            return result;

        } catch (Exception e) {

            System.out.println("ERROR AL HACER EL QUERY");
            System.out.println(e.getMessage());
            return null;

        }

    }

    //Consulta TODOS los vuelos
    public ResultSet consultarVuelo() {

        try {

            try {

                Class.forName(driver);

                cx = DriverManager.getConnection(url, user, password);

                System.out.println("CONEXIÓN ESTABLECIDA");

            } catch (Exception e) {

                System.out.println("ERROR AL ESTABLECER LA CONEXIÓN");

            }

            st = cx.createStatement();

            ResultSet result = st.executeQuery("SELECT * FROM `MVuelos`;");

            System.out.println("QUERY EJECUTADO CORRECTAMENTE");

            return result;

        } catch (Exception e) {

            System.out.println("ERROR AL HACER EL QUERY");
            System.out.println(e.getMessage());
            return null;

        }

    }

}
