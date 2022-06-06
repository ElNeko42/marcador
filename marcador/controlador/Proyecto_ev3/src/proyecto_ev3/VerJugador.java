package proyecto_ev3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerJugador extends ConnDB {
    
    // Atributos
    private ResultSet rs; 
    
    /**
     *  Crea un objecto heredando la conexion de la clase padre
     */
    public VerJugador() {
        super();
    }
     
    /**
     *  Devuelve el valor del ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet getRs() {
        return rs;
    }
    
    /**
     *  Hace una consulta a la base de datos de la tabla jugadores y
     *  se guarda en el ResultSet
     * 
     *  @param idEquipo Equipo que se quiere escoger en la consulta
     */
    public void cargaDatos(int idEquipo) {
        Statement stmt = null;
        String query = "SELECT id_jugador, aka FROM jugadores WHERE id_equipo = " + idEquipo + " ORDER BY id_jugador";
        try {
            stmt = (com.mysql.jdbc.Statement) conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
