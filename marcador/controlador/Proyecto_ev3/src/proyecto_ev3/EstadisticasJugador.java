package proyecto_ev3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EstadisticasJugador extends ConnDB {
    
    // Atributos
    private ResultSet rs; 
    private ResultSet rs2; 
    private String[] camposTabla;

    /**
     *  Crea un objecto heredando la conexion de la clase padre y inicianizando
     *  las columnas de la tabla de la base de datos
     */
    public EstadisticasJugador() {
        super();
        System.out.println("¡Conexión correcta con la clase EstadisticasJugador");
        camposTabla = new String[] {"jugadores.aka", "estadisticas_jugador.id_estadistica", "estadisticas_jugador.id_partida", "estadisticas_jugador.id_jugador", "estadisticas_jugador.k", "estadisticas_jugador.d", "estadisticas_jugador.a", "estadisticas_jugador.adr"};
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
     *  Devuelve un array de string con los campos de la tabla estadisticas_jugador de
     *  la base de datos
     * 
     *  @return String[]
     */
    public String[] getCamposTabla() {
        return camposTabla;
    }
    
    /**
     *  Inserta los datos en la tabla estadisticas_jugador de la base de datos
     * 
     *  @param idPartida Partida que en la que está jugando el jugador
     *  @param idJugador Jugador que esta jugando esa partida
     *  @param k Veces que un jugador mató a un rival
     *  @param d Veces que un jugador murió
     *  @param a Veces que un jugador ayudo a un compañero
     *  @param adr Daño medio por ronda
     */
    public void insertarDatos(int idPartida, int idJugador, int k, int d, int a, int adr) {
        String query = "INSERT INTO estadisticas_jugador "
                     + "VALUES (null," + idPartida + "," + idJugador + "," + k + "," + d + "," + a + "," + adr +")";
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
     *  Actualiza los datos en la tabla estadisticas_jugador de la base de datos
     * 
     *  @param idEstadistica Identificador único para actualizar las estadisticas del jugador
     *  @param idPartida Partida que en la que está jugando el jugador
     *  @param idJugador Jugador que esta jugando esa partida
     *  @param k Veces que un jugador mató a un rival
     *  @param d Veces que un jugador murió
     *  @param a Veces que un jugador ayudo a un compañero
     *  @param adr Daño medio por ronda
     */
    public void actualizarDatos(int idEstadistica, int idPartida, int idJugador, int k, int d, int a, int adr) {
        String query = "UPDATE estadisticas_jugador " +
                       "SET id_partida = " + idPartida +", id_jugador = " + idJugador +
                       ", k = " + k + ", d = " + d + ", a = " + a + ", adr = " + adr + " WHERE id_estadistica = " + idEstadistica;
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
     *  Borrar los datos en la tabla estadisticas_jugador de la base de datos
     * 
     *  @param idEstadistica Identificador único para borrar las estadisticas del jugador
     */
    public void borrarDatos(int idEstadistica) {
        String query = "DELETE FROM estadisticas_jugador WHERE id_estadistica = " + idEstadistica;
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
     *  Hace una consulta a la base de datos de la tabla estadisticas_jugador y
     *  se guarda en el primer ResultSet
     */
    public void cargaDatos() {
        Statement stmt = null;
        String query = "SELECT jugadores.aka, estadisticas_jugador.*"
                     + " FROM estadisticas_jugador"
                     + " LEFT JOIN jugadores"
                     + " ON estadisticas_jugador.id_jugador = jugadores.id_jugador"
                     + " ORDER BY id_estadistica ASC";
        try {
            stmt = (com.mysql.jdbc.Statement) conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    /**
     *  Hace una consulta a la base de datos de la tabla estadisticas_jugador y se guarda
     *  en el segundo ResultSet
     */
    public void cargaDatos2() {
        Statement stmt = null;
        String query = "SELECT jugadores.aka, estadisticas_jugador.*"
                     + " FROM estadisticas_jugador"
                     + " LEFT JOIN jugadores"
                     + " ON estadisticas_jugador.id_jugador = jugadores.id_jugador"
                     + " ORDER BY id_estadistica ASC";
        try {
            stmt = (com.mysql.jdbc.Statement) conn.createStatement();
            rs2 = stmt.executeQuery(query);
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs2;
    }
    
    /**
     *  Mueve el cursor una fila hacia adelante desde su posición actual
     *  de el segundo ResultSet
     * 
     *  @return
     */
    public ResultSet siguienteRegistro2() {
        try {
            rs2.next();
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs2;
    }

    /**
     *  Mueve el cursor a la última fila de el segundo ResultSet
     * 
     *  @return
     */
    public ResultSet ultimoRegistro2() {
        try {
            rs2.last();
        } catch (SQLException ex) {
            //Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs2;
    }
}
