package proyecto_ev3;

import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Clase metodosSueltos
 * 
 *  @author angel
 */
public class MetodosSueltos {
    
    /**
     *  Junta la fecha en formato americano con barras (2019/08/23)
     * 
     *  @param jdc JDateChooser
     *  @return String
     */
    static public String juntarFecha(JDateChooser jdc) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = sdf.format(jdc.getDate());
        return strFecha;
    }

    /**
     *  Formatea un string a date
     * 
     *  @param rs ResultSet
     *  @param jdc JDateChooser
     *  @param dbColumna Columna de la base de datos
     */
    static public void formatearStringToDate(ResultSet rs, JDateChooser jdc, String dbColumna) {
        String date_string;
        SimpleDateFormat formatter;      
        Date date;      
        try {
            date_string = rs.getString(dbColumna);
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(date_string);
            jdc.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
}
