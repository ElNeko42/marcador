package proyecto_ev3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnDB {

    // Atributos
    public Connection conn;

    /**
     *  Crea un objecto para conectarse la base de datos por defecto
     */
    public ConnDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_ev3", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
