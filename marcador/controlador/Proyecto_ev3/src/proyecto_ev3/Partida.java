package proyecto_ev3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Partida extends ConnDB {
    
    // Atributos
    private ResultSet rs; 
    private ResultSet rs2; 
    private String[] camposTabla;

    /**
     *  Crea un objecto heredando la conexion de la clase padre y inicianizando
     *  las columnas de la tabla de la base de datos
     */
    public Partida() {
        super();
        camposTabla = new String[] {"id_partida", "id_equipo1", "id_equipo2", "ganador", "resultado_rondas", "resultado_total"};
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
     *  Inserta los datos en la tabla partidas de la base de datos
     * 
     *  @param idEquipo1 Primero equipo que juega en la partida
     *  @param idEquipo2 Segundo equipo que juega en la partida
     *  @param ganador El equipo que gano en la partida
     *  @param fecha Dia en que se juega la partida
     *  @param hComienzo Hora de comienzo de la partida
     *  @param hFinal Hora en que acaba la partida
     *  @param ResultadoRondas Rondas hasta llegar a 16 por un equipo
     *  @param resultadoTotal Puntos por cada equipo (max 2, para el ganador)
     */
    public void insertarDatos(int idEquipo1, int idEquipo2, int ganador, String fecha, String hComienzo, String hFinal, String ResultadoRondas, String resultadoTotal) {
        String query = "INSERT INTO partidas "
                     + "VALUES (null," + idEquipo1 + "," + idEquipo2 + ","
                     + ganador + ",'" + fecha + "','" + hComienzo + "','" + hFinal + "'" + ",'"
                     + ResultadoRondas + "','" + resultadoTotal + "')";
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
     *  Actualiza los datos en la tabla partidas de la base de datos
     * 
     *  @param idPartida Identificador único para actualizar la partida
     *  @param idEquipo1 Primero equipo que juega en la partida
     *  @param idEquipo2 Segundo equipo que juega en la partida
     *  @param ganador El equipo que gano en la partida
     *  @param fecha Dia en que se juega la partida
     *  @param hComienzo Hora de comienzo de la partida
     *  @param hFinal Hora en que acaba la partida
     *  @param resRondas Rondas hasta llegar a 16 por un equipo
     *  @param resFinal Puntos por cada equipo (max 2, para el ganador)
     */
    public void actualizarDatos(int idPartida, int idEquipo1, int idEquipo2, String ganador, String fecha, String hComienzo, String hFinal, String resRondas, String resFinal) {
        String query = "UPDATE partidas " +
                       "SET id_equipo1 = " + idEquipo1 +", id_equipo2 = " + idEquipo2 +
                       ", ganador = '" + ganador + "', fecha = '" + fecha + "', hora_comienzo = '"
                       + hComienzo + "', hora_finalizacion = '" + hFinal + "', resultado_rondas = '" + resRondas +
                       "', resultado_total = '" + resFinal + "' WHERE id_partida = " + idPartida;
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
     *  Borrar los datos en la tabla partidas de la base de datos
     * 
     *  @param idPartida Identificador único para borrar la partida
     */
    public void borrarDatos(int idPartida) {
        String query = "DELETE FROM partidas WHERE id_partida = " + idPartida;
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
     *  Hace una consulta a la base de datos de la tabla partidas y
     *  se guarda en el primer ResultSet
     */
    public void cargaDatos() {
        Statement stmt = null;
        String query = "SELECT * FROM partidas ORDER BY id_partida ASC";
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
     *  Hace una consulta a la base de datos de la tabla partidas y se guarda
     *  en el segundo ResultSet
     */
    public void cargaDatos2() {
        Statement stmt = null;
        String query = "SELECT * FROM partidas ORDER BY id_partida ASC";
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
