package proyecto_ev3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TorneoEquipo extends ConnDB {
    
    // Atributos
    private ResultSet rs; 
    private ResultSet rs2; 
    private String[] camposTabla;
    
    /**
     *  Crea un objecto heredando la conexion de la clase padre y inicianizando
     *  las columnas de la tabla de la base de datos
     */
    public TorneoEquipo() {
        super();
        camposTabla = new String[] {"id_torneo_equipo", "id_torneo", "id_equipo"};
    }
       
    /**
     *  Devuelve el valor del primer ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet getRs() {
        return rs;
    }
    
    /**
     *  Devuelve el valor del segundo ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet getRs2() {
        return rs2;
    }
    
    /**
     *  Devuelve un array de string con los campos de la tabla jugadores de
     *  la base de datos
     * 
     *  @return String[]
     */
    public String[] getCamposTabla() {
        return camposTabla;
    }
    
    /**
     *  Inserta los datos en la tabla torneos_equipos de la base de datos
     * 
     *  @param idTorneo Torneo que se va a jugar
     *  @param idEquipo Equipo que juega en ese torneo
     */
    public void insertarDatos(int idTorneo, int idEquipo) {
        String query = "INSERT INTO torneos_equipos "
                     + "VALUES (null," + idTorneo + "," + idEquipo + ")";
        Statement stmt = null;
        try {
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *  Actualiza los datos en la tabla torneos_equipos de la base de datos
     *  
     *  @param idTorneoEquipo Identificador único para actualizar el torneo_equipo
     *  @param idTorneo Torneo que se va a jugar
     *  @param idEquipo Equipo que juega en ese torneo
     */
    public void actualizarDatos(int idTorneoEquipo, int idTorneo, int idEquipo) {
        String query = "UPDATE torneos_equipos " +
                       "SET id_torneo = " + idTorneo + ", id_equipo = " + idEquipo +
                       " WHERE id_torneo_equipo = " + idTorneoEquipo;
        Statement stmt = null;
        try {
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *  Borrar los datos en la tabla torneos_equipos de la base de datos
     * 
     *  @param idTorneoE Identificador único para borrar el torneo_equipo
     */
    public void borrarDatos(int idTorneoE) {
        String query = "DELETE FROM torneos_equipos WHERE id_torneo_equipo = " + idTorneoE;
        Statement stmt = null;
        try {
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *  Hace una consulta a la base de datos de la tabla torneo_equipos y
     *  se guarda en el primer ResultSet
     */
    public void cargaDatos() {
        Statement stmt = null;
        String query = "SELECT * FROM torneos_equipos ORDER BY id_torneo_equipo ASC";
        try {
            stmt = (com.mysql.jdbc.Statement) conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Mueve el cursor a la primera fila de el primer ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet primerRegistro() {
        try {
            rs.first();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    /**
     *  Mueve el cursor a la fila anterior de el primer ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet anteriorRegistro() {
        try {
            rs.previous();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    /**
     *  Mueve el cursor una fila hacia adelante desde su posición actual
     *  de el primer ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet siguienteRegistro() {
        try {
            rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    /**
     *  Mueve el cursor a la última fila de el primer ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet ultimoRegistro() {
        try {
            rs.last();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    
    /**
     *  Hace una consulta a la base de datos de la tabla torneos_anunciantes y se guarda
     *  en el segundo ResultSet
     */
    public void cargaDatos2() {
        Statement stmt = null;
        String query = "SELECT * FROM torneos_equipos ORDER BY id_torneo_equipo ASC";
        try {
            stmt = (com.mysql.jdbc.Statement) conn.createStatement();
            rs2 = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  Mueve el cursor a la primera fila de el segundo ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet primerRegistro2() {
        try {
            rs2.first();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs2;
    }
    
    /**
     *  Mueve el cursor a la fila anterior de el segundo ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet anteriorRegistro2() {
        try {
            rs2.previous();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs2;
    }
    
    /**
     *  Mueve el cursor una fila hacia adelante desde su posición actual
     *  de el segundo ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet siguienteRegistro2() {
        try {
            rs2.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs2;
    }

    /**
     *  Mueve el cursor a la última fila de el segundo ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet ultimoRegistro2() {
        try {
            rs2.last();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs2;
    }
}
