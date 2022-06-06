package proyecto_ev3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Clase Anunciante
 * 
 *  @author angel
 */
public class Anunciante extends ConnDB {

    // Atributos
    private ResultSet rs; 
    private ResultSet rs2;
    private String[] camposTabla;
    
    /**
     *  Crea un objecto heredando la conexion de la clase padre y inicianizando
     *  las columnas de la tabla de la base de datos
     */
    public Anunciante() {
        super();
        camposTabla = new String[] {"id_anunciante", "nombre", "logo", "precio"};
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
     *  Devuleve el valor del segundo ResultSet
     * 
     *  @return ResultSet
     */
    public ResultSet getRs2() {
        return rs2;
    }
    
    /**
     *  Devuelve un array de string con los campos de la tabla anunciantes de
     *  la base de datos
     * 
     *  @return String[]
     */
    public String[] getCamposTabla() {
        return camposTabla;
    }
    
    /**
     *  Inserta los datos en la tabla anunciantes de la base de datos
     * 
     *  @param nombre Nombre del anunciante
     *  @param logo Logo del anunciante (nombre de la imagen)
     *  @param precio Precio que paga el anunciante
     */
    public void insertarDatos(String nombre, String logo, int precio) {
        String query = "INSERT INTO anunciantes "
                     + "VALUES (null,'" + nombre + "','" + logo + "'," + precio + ")";
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
     *  Actualiza los datos en la tabla anunciantes de la base de datos 
     * 
     *  @param idAnunciante Identificador único para actualizar el anunciante
     *  @param nombre Nombre del anunciante
     *  @param logo Logo del anunciante (nombre de la imagen)
     *  @param precio Precio que paga el anunciante 
     */
    public void actualizarDatos(int idAnunciante, String nombre, String logo, int precio) {
        String query = "UPDATE anunciantes " +
                       "SET nombre = '" + nombre +"', logo = '" + logo +"', precio = " + precio +
                       " WHERE id_anunciante = " + idAnunciante;
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
     *  Borra los datos en la tabla anunciantes de la base de datos
     * 
     *  @param idAnunciante Identificado único para borrar el anunciante
     */
    public void borrarDatos(int idAnunciante) {
        String query = "DELETE FROM anunciantes WHERE id_anunciante = " + idAnunciante;
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
     *  Hace una consulta a la base de datos de la tabla anunciantes y se
     *  guarda en el primer ResultSet
     */
    public void cargaDatos() {
        Statement stmt = null;
        String query = "SELECT * FROM anunciantes ORDER BY id_anunciante ASC";
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
     *  Hace una consulta a la base de datos de la tabla anunciantes y se
     *  guarda en el segundo ResultSet
     */
    public void cargaDatos2() {
        Statement stmt = null;
        String query = "SELECT * FROM anunciantes ORDER BY id_anunciante ASC";
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
     *  @return
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
     *  @return
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
