package proyecto_ev3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Clase Jugador
 * 
 *  @author angel
 */
public class Jugador extends ConnDB {
    
    // Atributos
    private ResultSet rs;
    private ResultSet rs2;
    private String[] camposTabla;

    /**
     *  Crea un objecto heredando la conexion de la clase padre y inicianizando
     *  las columnas de la tabla de la base de datos
     */
    public Jugador() {
        super();
        camposTabla = new String[] {"id_jugador", "id_equipo", "nombre", "aka", "nacionalidad", "rol", "anhos_activo", "salario"};
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
     *  Inserta los datos en la tabla jugadores de la base de datos
     * 
     *  @param idEquipo Equipo en el que esta el jugador
     *  @param nombre Nombre real del jugador
     *  @param aka Nombre en el juego
     *  @param nacionalidad Origen del jugador
     *  @param rol Rol del jugador (awper, rifler, lurker...)
     *  @param fechaNac Fecha de nacimiento del jugador
     *  @param anhosActivo Años jugando
     *  @param salario Dinero que le pagan cada mes
     */
    public void insertarDatos(int idEquipo, String nombre, String aka, String nacionalidad, String rol, String fechaNac, String anhosActivo, int salario) {
        String query = "INSERT INTO jugadores "
                + "VALUES (null,"
                + idEquipo + ",'"
                + nombre + "', '"
                + aka + "', '"
                + nacionalidad + "',"
                + " '" + rol + "',"
                + " '" + fechaNac + "',"
                + " '" + anhosActivo + "',"
                + " " + salario + ")";
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
     *  Actualiza los datos en la tabla jugadores de la base de datos
     * 
     *  @param idJugador Identificador único para actualizar el jugador
     *  @param idEquipo Equipo en el que esta el jugador
     *  @param nombre Nombre real del jugador
     *  @param aka Nombre en el juego
     *  @param nacionalidad Origen del jugador
     *  @param rol Rol del jugador (awper, rifler, lurker...)
     *  @param fecha_nac Fecha de nacimiento del jugador
     *  @param aActivo Años jugando
     *  @param salario Dinero que le pagan cada mes
     */
    public void actualizarDatos(int idJugador, int idEquipo, String nombre, String aka, String nacionalidad, String rol, String fecha_nac, String aActivo, int salario) {
        String query = "UPDATE jugadores " +
                       "SET id_equipo = " + idEquipo +", nombre = '" + nombre +
                       "', aka = '" + aka + "', nacionalidad = '" + nacionalidad + "', rol = '"
                       + rol + "', fecha_nacimiento = '" + fecha_nac + "', anhos_activo = '" + aActivo +
                       "', salario = " + salario + " WHERE id_jugador = " + idJugador;
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
     *  Borrar los datos en la tabla jugadores de la base de datos 
     * 
     *  @param idJugador Identificador único para borrar al jugador
     */
    public void borrarDatos(int idJugador) {
        String query = "DELETE FROM jugadores WHERE id_jugador = " + idJugador;
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
     *  Hace una consulta a la base de datos de la tabla jugadores y
     *  se guarda en el primer ResultSet
     */
    public void cargaDatos() {
        Statement stmt = null;
        String query = "SELECT * FROM jugadores ORDER BY id_jugador ASC";
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
     *  Hace una consulta a la base de datos de la tabla jugadores y se guarda
     *  en el segundo ResultSet
     */
    public void cargaDatos2() {
        Statement stmt = null;
        String query = "SELECT * FROM jugadores ORDER BY id_jugador ASC";
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
