package proyecto_ev3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Clase Torneo
 * 
 *  @author angel
 */
public class Torneo extends ConnDB {
    
    // Atributos
    private ResultSet rs; 
    private ResultSet rs2;
    private String[] camposTabla;

    /**
     *  Crea un objecto heredando la conexion de la clase padre y inicianizando
     *  las columnas de la tabla de la base de datos
     */
    public Torneo() {
        super();
        camposTabla = new String[] {"id_torneo", "nombre", "equipo_ganador", "lugar", "premio"};
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
     *  Inserta los datos en la tabla torneos de la base de datos
     * 
     *  @param nombre Nombre del torneo
     *  @param equipoGanador Equipo que ganó el torneo
     *  @param lugar Lugar en donde se compite el torneo
     *  @param fechaComienzo Fecha que empieza el torneo
     *  @param fechaFinalizacion Fecha en la que acaba el torneo
     *  @param premio Premio por ganar el torneo
     */
    public void insertarDatos(String nombre, String equipoGanador, String lugar, String fechaComienzo, String fechaFinalizacion, int premio) {
        String query = "INSERT INTO torneos "
                + "VALUES (null,'"
                + nombre + "','"
                + equipoGanador + "', '"
                + lugar + "', '"
                + fechaComienzo + "',"
                + " '" + fechaFinalizacion + "',"
                + " " + premio + ")";
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
     *  Actualiza los datos en la tabla torneos de la base de datos
     * 
     *  @param idTorneo Identificador único para actualizar el torneo
     *  @param nombre Nombre del torneo
     *  @param equipoGanador Equipo que ganó el torneo
     *  @param lugar Lugar en donde se compite el torneo
     *  @param fechC Fecha que empieza el torneo
     *  @param fechF Fecha en la que acaba el torneo
     *  @param premio Premio por ganar el torneo
     */
    public void actualizarDatos(int idTorneo, String nombre, String equipoGanador, String lugar, String fechC, String fechF, int premio) {
        String query = "UPDATE torneos " +
                       "SET nombre = '" + nombre + "', equipo_ganador = '" + equipoGanador +
                       "', lugar = '" + lugar + "', fecha_comienzo = '" + fechC + "', fecha_finalizacion = '"
                       + fechF + "', premio = " + premio + " WHERE id_torneo = " + idTorneo;
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
     *  Borrar los datos en la tabla torneos de la base de datos
     * 
     *  @param idTorneo Identificador único para borrar el torneo
     */
    public void borrarDatos(int idTorneo) {
        String query = "DELETE FROM torneos WHERE id_torneo = " + idTorneo;
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
     *  Hace una consulta a la base de datos de la tabla torneos y
     *  se guarda en el primer ResultSet
     */
    public void cargaDatos() {
        Statement stmt = null;
        String query = "SELECT * FROM torneos ORDER BY id_torneo ASC";
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
     *  Hace una consulta a la base de datos de la tabla torneos y se guarda
     *  en el segundo ResultSet
     */
    public void cargaDatos2() {
        Statement stmt = null;
        String query = "SELECT * FROM torneos ORDER BY id_torneo ASC";
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
