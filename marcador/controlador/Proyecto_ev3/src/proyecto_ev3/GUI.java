package proyecto_ev3;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *  Clase GUI
 * 
 *  @author angel
 */
public class GUI extends javax.swing.JFrame {

    // Atributos
    
    // Clases propias
    private Anunciante anunciante;
    private Equipo equipo;
    private EstadisticasJugador estadisticasJ;
    private Jugador jugador;
    private Partida partida;
    private Torneo torneo;
    private TorneoAnunciante torneoAnunciante;
    private TorneoEquipo torneoEquipo;
    
    // ResultSets de la pestaña actualizar
    private ResultSet datosAnunciantes;
    private ResultSet datosEquipos;
    private ResultSet datosEstadisticasJ;
    private ResultSet datosJugadores;
    private ResultSet datosPartidas;
    private ResultSet datosTorneos;
    private ResultSet datosTorneosAnunciantes;
    private ResultSet datosTorneosEquipos;
        
    // ResultSets de la pestaña borrar
    private ResultSet datosAnunciantes2;
    private ResultSet datosEquipos2;
    private ResultSet datosEstadisticasJ2;
    private ResultSet datosJugadores2;
    private ResultSet datosPartidas2;
    private ResultSet datosTorneos2;
    private ResultSet datosTorneosAnunciantes2;
    private ResultSet datosTorneosEquipos2;
    
    // Posiciones de la pestaña actualizar
    private int a_posicionActualA;
    private int a_posicionesTotalA;
    private int a_posicionActualE;
    private int a_posicionesTotalE;
    private int a_posicionActualEJ;
    private int a_posicionesTotalEJ;
    private int a_posicionActualJ;
    private int a_posicionesTotalJ;
    private int a_posicionActualP;
    private int a_posicionesTotalP;
    private int a_posicionActualT;
    private int a_posicionesTotalT;
    private int a_posicionActualTA;
    private int a_posicionesTotalTA;
    private int a_posicionActualTE;
    private int a_posicionesTotalTE;
    
    // Posiciones de la pestaña borrar
    private int b_posicionActualA;
    private int b_posicionesTotalA;
    private int b_posicionActualE;
    private int b_posicionesTotalE;
    private int b_posicionActualEJ;
    private int b_posicionesTotalEJ;
    private int b_posicionActualJ;
    private int b_posicionesTotalJ;
    private int b_posicionActualP;
    private int b_posicionesTotalP;
    private int b_posicionActualT;
    private int b_posicionesTotalT;
    private int b_posicionActualTA;
    private int b_posicionesTotalTA;
    private int b_posicionActualTE;
    private int b_posicionesTotalTE;
    
    // Todos los JTextField menos las fechas y horas
    private JTextField[][] insertarCampos;
    private JTextField[][] actualizarCampos;
    private JTextField[][] borrarCampos;
    
    // Todos los jugadores en la partida
    private int[] idJugadores;
    
    /**
     *  Creates new form GUI
     * 
     *  Estructura de las variables:
     *      Primera letra indica la pestaña
     *          i_ == Insertar
     *          a_ == Actualizar
     *          b_ == Borrar
     *      
     *      Nombre del componente hasta llegar a las letras sueltas
     * 
     *      La útilma letra o letras en sueltas indican el nombre de la tabla
     *      de la base de datos
     * 
     */
    public GUI() {
        initComponents();
        a_posicionActualA = 1;
        a_posicionesTotalA = 0;
        a_posicionActualE = 1;
        a_posicionesTotalE = 0;
        a_posicionActualEJ = 1;
        a_posicionesTotalEJ = 0;
        a_posicionActualJ = 1;
        a_posicionesTotalJ = 0;
        a_posicionActualP = 1;
        a_posicionesTotalP = 0;
        a_posicionActualT = 1;
        a_posicionesTotalT = 0;
        a_posicionActualTA = 1;
        a_posicionesTotalTA = 0;
        a_posicionActualTE = 1;
        a_posicionesTotalTE = 0;
        
        b_posicionActualA = 1;
        b_posicionesTotalA = 0;
        b_posicionActualE = 1;
        b_posicionesTotalE = 0;
        b_posicionActualEJ = 1;
        b_posicionesTotalEJ = 0;
        b_posicionActualJ = 1;
        b_posicionesTotalJ = 0;
        b_posicionActualP = 1;
        b_posicionesTotalP = 0;
        b_posicionActualT = 1;
        b_posicionesTotalT = 0;
        b_posicionActualTA = 1;
        b_posicionesTotalTA = 0;
        b_posicionActualTE = 1;
        b_posicionesTotalTE = 0;
        
        idJugadores = new int[10];
        
        anunciante = new Anunciante();
        equipo = new Equipo();
        estadisticasJ = new EstadisticasJugador();
        jugador = new Jugador();
        partida = new Partida();
        torneo = new Torneo();
        torneoAnunciante = new TorneoAnunciante();
        torneoEquipo = new TorneoEquipo();
        
        insertarCampos = new JTextField[][]{{i_txtNombreA, i_txtPrecioA, i_txtLogoA},
                                            {i_txtNombreE, i_txtLogoE, i_txtLocalizacionE, i_txtCoachE},
                                            {i_txtIdPartidaEJ, i_txtIdJugadorEJ, i_txtKEJ, i_txtDEJ, i_txtAEJ, i_txtAdrEJ},
                                            {i_txtIdEquipoJ, i_txtNombreJ, i_txtAkaJ, i_txtNacionalidadJ, i_txtRolJ, i_txtAnhosActivoJ, i_txtSalarioJ},
                                            {i_txtIdEquipoP1, i_txtIdEquipoP2, i_txtGanadorP, i_txtResultadoRondasP, i_txtResultadoTotalP},
                                            {i_txtNombreT, i_txtEquipoGanadorT, i_txtLugarT, i_txtPremioT},
                                            {i_txtIdTorneoTA, i_txtIdAnuncianteTA},
                                            {i_txtIdTorneoTE, i_txtIdEquipoTE}};

        actualizarCampos = new JTextField[][]{{a_txtIdAnunciante, a_txtNombreA, a_txtLogoA, a_txtPrecioA},
                                              {a_txtIdEquipo, a_txtNombreE, a_txtLogoE, a_txtLocalizacionE, a_txtCoachE},
                                              {a_lblNombreJ, a_txtIdEstadistica, a_txtIdPartidaEJ, a_txtIdJugadorEJ, a_txtKEJ, a_txtDEJ, a_txtAEJ, a_txtAdrEJ},
                                              {a_txtIdJugador, a_txtIdEquipoJ, a_txtNombreJ, a_txtAkaJ, a_txtNacionalidadJ, a_txtRolJ, a_txtAnhosActivoJ, a_txtSalarioJ},
                                              {a_txtIdPartidaP, a_txtIdEquipoP1, a_txtIdEquipoP2, a_txtGanadorP, a_txtResultadoRondasP, a_txtResultadoTotalP},
                                              {a_txtIdTorneo, a_txtNombreT, a_txtEquipoGanadorT, a_txtLugarT, a_txtPremioT},
                                              {a_txtIdTorneoAnunciante, a_txtIdTorneoTA, a_txtIdAnuncianteTA},
                                              {a_txtIdTorneoEquipo, a_txtIdTorneoTE, a_txtIdEquipoTE}};
        
        borrarCampos = new JTextField[][]{{b_txtIdAnunciante, b_txtNombreA, b_txtLogoA, b_txtPrecioA},
                                              {b_txtIdEquipo, b_txtNombreE, b_txtLogoE, b_txtLocalizacionE, b_txtCoachE},
                                              {b_lblNombreJ, b_txtIdEstadistica, b_txtIdPartidaEJ, b_txtIdJugadorEJ, b_txtKEJ, b_txtDEJ, b_txtAEJ, b_txtAdrEJ},
                                              {b_txtIdJugador, b_txtIdEquipoJ, b_txtNombreJ, b_txtAkaJ, b_txtNacionalidadJ, b_txtRolJ, b_txtAnhosActivoJ, b_txtSalarioJ},
                                              {b_txtIdPartidaP, b_txtIdEquipoP1, b_txtIdEquipoP2, b_txtGanadorP, b_txtResultadoRondasP, b_txtResultadoTotalP},
                                              {b_txtIdTorneo, b_txtNombreT, b_txtEquipoGanadorT, b_txtLugarT, b_txtPremioT},
                                              {b_txtIdTorneoAnunciante, b_txtIdTorneoTA, b_txtIdAnuncianteTA},
                                              {b_txtIdTorneoEquipo, b_txtIdTorneoTE, b_txtIdEquipoTE}};

        
        setTabla("anunciantes", actualizarCampos, 1);
        setTabla("equipos", actualizarCampos, 1);
        setTabla("estadisticasJ", actualizarCampos, 1);
        setTabla("jugadores", actualizarCampos, 1);
        setTabla("partidas", actualizarCampos, 1);
        setTabla("torneos", actualizarCampos, 1);
        setTabla("torneosAnunciantes", actualizarCampos, 1);
        setTabla("torneosEquipos", actualizarCampos, 1);
        
        setTabla("anunciantes", borrarCampos, 2);
        setTabla("equipos", borrarCampos, 2);
        setTabla("estadisticasJ", borrarCampos, 2);
        setTabla("jugadores", borrarCampos, 2);
        setTabla("partidas", borrarCampos, 2);
        setTabla("torneos", borrarCampos, 2);
        setTabla("torneosAnunciantes", borrarCampos, 2);
        setTabla("torneosEquipos", borrarCampos, 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnG = new javax.swing.ButtonGroup();
        tpContenedor = new javax.swing.JTabbedPane();
        pInsertar = new javax.swing.JPanel();
        tpInsertar1 = new javax.swing.JTabbedPane();
        pAnunciantes = new javax.swing.JPanel();
        btnMeterDatosAnunciantes = new javax.swing.JButton();
        lblNombreA = new javax.swing.JLabel();
        lblPrecioA = new javax.swing.JLabel();
        i_txtNombreA = new javax.swing.JTextField();
        i_txtPrecioA = new javax.swing.JTextField();
        btnBorrarA = new javax.swing.JButton();
        i_txtLogoA = new javax.swing.JTextField();
        lblPrecioA3 = new javax.swing.JLabel();
        pEquipos = new javax.swing.JPanel();
        btnMeterDatosEquipos = new javax.swing.JButton();
        lblNombreE = new javax.swing.JLabel();
        i_txtNombreE = new javax.swing.JTextField();
        lblLogoE = new javax.swing.JLabel();
        i_txtLogoE = new javax.swing.JTextField();
        i_txtLocalizacionE = new javax.swing.JTextField();
        lblLocalizacion = new javax.swing.JLabel();
        lblCoachE = new javax.swing.JLabel();
        i_txtCoachE = new javax.swing.JTextField();
        lblFundadoE = new javax.swing.JLabel();
        i_txtFundadoE = new com.toedter.calendar.JDateChooser();
        btnBorrarE = new javax.swing.JButton();
        pEstadisticasJug = new javax.swing.JPanel();
        lblIdPartidaEJ = new javax.swing.JLabel();
        i_txtIdPartidaEJ = new javax.swing.JTextField();
        lblIdJugadorEJ = new javax.swing.JLabel();
        i_txtIdJugadorEJ = new javax.swing.JTextField();
        lblKEJ = new javax.swing.JLabel();
        i_txtKEJ = new javax.swing.JTextField();
        lblDEJ = new javax.swing.JLabel();
        i_txtDEJ = new javax.swing.JTextField();
        btnBorrarEJ = new javax.swing.JButton();
        btnMeterDatosEstadisticasJ = new javax.swing.JButton();
        lblAEJ = new javax.swing.JLabel();
        i_txtAEJ = new javax.swing.JTextField();
        i_txtAdrEJ = new javax.swing.JTextField();
        lblAdrEJ = new javax.swing.JLabel();
        pJugadores = new javax.swing.JPanel();
        btnMeterDatosJugadores = new javax.swing.JButton();
        lblIdEquipoJ = new javax.swing.JLabel();
        i_txtIdEquipoJ = new javax.swing.JTextField();
        lblNombreJ = new javax.swing.JLabel();
        i_txtNombreJ = new javax.swing.JTextField();
        lblAkaJ = new javax.swing.JLabel();
        i_txtAkaJ = new javax.swing.JTextField();
        lblFechaNacJ = new javax.swing.JLabel();
        lblRolJ = new javax.swing.JLabel();
        i_txtRolJ = new javax.swing.JTextField();
        i_txtNacionalidadJ = new javax.swing.JTextField();
        lblNacionalidadJ = new javax.swing.JLabel();
        i_txtSalarioJ = new javax.swing.JTextField();
        lblSalarioJ = new javax.swing.JLabel();
        lblAnhosActivoJ = new javax.swing.JLabel();
        i_txtAnhosActivoJ = new javax.swing.JTextField();
        i_txtFechaNacJ = new com.toedter.calendar.JDateChooser();
        btnBorrarJ = new javax.swing.JButton();
        pPartidas = new javax.swing.JPanel();
        lblIdEquipoP1 = new javax.swing.JLabel();
        i_txtIdEquipoP1 = new javax.swing.JTextField();
        lblIdEquipoP2 = new javax.swing.JLabel();
        i_txtIdEquipoP2 = new javax.swing.JTextField();
        lblGanadorP = new javax.swing.JLabel();
        i_txtGanadorP = new javax.swing.JTextField();
        lblFechaP = new javax.swing.JLabel();
        lblComienzoP = new javax.swing.JLabel();
        lblFinalP = new javax.swing.JLabel();
        lblResultadoRondasP = new javax.swing.JLabel();
        i_txtResultadoRondasP = new javax.swing.JTextField();
        lblResultadoTotalP = new javax.swing.JLabel();
        i_txtResultadoTotalP = new javax.swing.JTextField();
        btnBorrarP = new javax.swing.JButton();
        btnMeterDatosPartidas = new javax.swing.JButton();
        i_txtFechaP = new com.toedter.calendar.JDateChooser();
        i_txtComienzoP = new com.github.lgooddatepicker.components.TimePicker();
        i_txtFinalP = new com.github.lgooddatepicker.components.TimePicker();
        pTorneos = new javax.swing.JPanel();
        lblNombreT = new javax.swing.JLabel();
        i_txtNombreT = new javax.swing.JTextField();
        lblEquipoGanadorT = new javax.swing.JLabel();
        i_txtEquipoGanadorT = new javax.swing.JTextField();
        lblLugarT = new javax.swing.JLabel();
        i_txtLugarT = new javax.swing.JTextField();
        i_txtPremioT = new javax.swing.JTextField();
        lblPremioT = new javax.swing.JLabel();
        lblFechaFinT = new javax.swing.JLabel();
        lblFechaComT = new javax.swing.JLabel();
        btnMeterDatosTorneos = new javax.swing.JButton();
        btnBorrarT = new javax.swing.JButton();
        i_txtFechaComT = new com.toedter.calendar.JDateChooser();
        i_txtFechaFinT = new com.toedter.calendar.JDateChooser();
        pTorneosAnunciantes = new javax.swing.JPanel();
        lblIdTorneoTA = new javax.swing.JLabel();
        i_txtIdTorneoTA = new javax.swing.JTextField();
        lblIdAnuncianteTA = new javax.swing.JLabel();
        i_txtIdAnuncianteTA = new javax.swing.JTextField();
        btnBorrarTA = new javax.swing.JButton();
        btnMeterDatosTorneosA = new javax.swing.JButton();
        pTorneosEquipos = new javax.swing.JPanel();
        lblIdTorneoTE = new javax.swing.JLabel();
        i_txtIdTorneoTE = new javax.swing.JTextField();
        lblIdequipoTE = new javax.swing.JLabel();
        i_txtIdEquipoTE = new javax.swing.JTextField();
        btnBorrarTE = new javax.swing.JButton();
        btnMeterDatosTorneosE = new javax.swing.JButton();
        pModificar = new javax.swing.JPanel();
        pModificar1 = new javax.swing.JTabbedPane();
        pAnunciantes1 = new javax.swing.JPanel();
        lblNombreA1 = new javax.swing.JLabel();
        a_txtNombreA = new javax.swing.JTextField();
        lblPrecioA1 = new javax.swing.JLabel();
        a_txtPrecioA = new javax.swing.JTextField();
        btnActualizarDatosAnunciantes = new javax.swing.JButton();
        btnPrimeroA = new javax.swing.JButton();
        btnAnteriorA = new javax.swing.JButton();
        btnSiguienteA = new javax.swing.JButton();
        btnUltimoA = new javax.swing.JButton();
        a_txtIdAnunciante = new javax.swing.JTextField();
        lblIdAnunciante = new javax.swing.JLabel();
        a_lblPosicionesA = new javax.swing.JLabel();
        a_txtLogoA = new javax.swing.JTextField();
        lblLogoA = new javax.swing.JLabel();
        pEquipos1 = new javax.swing.JPanel();
        lblNombreE1 = new javax.swing.JLabel();
        a_txtNombreE = new javax.swing.JTextField();
        a_txtLogoE = new javax.swing.JTextField();
        lblLogoE1 = new javax.swing.JLabel();
        lblLocalizacion1 = new javax.swing.JLabel();
        a_txtLocalizacionE = new javax.swing.JTextField();
        a_txtCoachE = new javax.swing.JTextField();
        lblCoachE1 = new javax.swing.JLabel();
        lblFundadoE1 = new javax.swing.JLabel();
        a_txtFundadoE = new com.toedter.calendar.JDateChooser();
        btnActualizarDatosEquipos = new javax.swing.JButton();
        btnPrimeroE = new javax.swing.JButton();
        btnAnteriorE = new javax.swing.JButton();
        btnSiguienteE = new javax.swing.JButton();
        btnUltimoE = new javax.swing.JButton();
        a_txtIdEquipo = new javax.swing.JTextField();
        lblIdEquipo = new javax.swing.JLabel();
        a_lblPosicionesE = new javax.swing.JLabel();
        pEstadisticas1 = new javax.swing.JPanel();
        lblIdPartidaEJ1 = new javax.swing.JLabel();
        a_txtIdPartidaEJ = new javax.swing.JTextField();
        lblIdJugadorEJ1 = new javax.swing.JLabel();
        a_txtIdJugadorEJ = new javax.swing.JTextField();
        lblKEJ1 = new javax.swing.JLabel();
        a_txtKEJ = new javax.swing.JTextField();
        lblDEJ1 = new javax.swing.JLabel();
        a_txtDEJ = new javax.swing.JTextField();
        lblAEJ1 = new javax.swing.JLabel();
        a_txtAEJ = new javax.swing.JTextField();
        lblAdrEJ1 = new javax.swing.JLabel();
        a_txtAdrEJ = new javax.swing.JTextField();
        lblIdEstadistica = new javax.swing.JLabel();
        a_txtIdEstadistica = new javax.swing.JTextField();
        btnPrimeroEJ = new javax.swing.JButton();
        btnAnteriorEJ = new javax.swing.JButton();
        btnSiguienteEJ = new javax.swing.JButton();
        btnUltimoEJ = new javax.swing.JButton();
        btnActualizarDatosEstadisticasJ = new javax.swing.JButton();
        a_lblPosicionesEJ = new javax.swing.JLabel();
        a_lblNombreJ = new javax.swing.JTextField();
        pJugadores1 = new javax.swing.JPanel();
        lblIdEquipoJ1 = new javax.swing.JLabel();
        a_txtIdEquipoJ = new javax.swing.JTextField();
        lblNombreJ1 = new javax.swing.JLabel();
        a_txtNombreJ = new javax.swing.JTextField();
        lblAkaJ1 = new javax.swing.JLabel();
        a_txtAkaJ = new javax.swing.JTextField();
        lblNacionalidadJ1 = new javax.swing.JLabel();
        a_txtNacionalidadJ = new javax.swing.JTextField();
        lblRolJ1 = new javax.swing.JLabel();
        a_txtRolJ = new javax.swing.JTextField();
        lblFechaNacJ1 = new javax.swing.JLabel();
        a_txtFechaNacJ = new com.toedter.calendar.JDateChooser();
        lblAnhosActivoJ1 = new javax.swing.JLabel();
        a_txtAnhosActivoJ = new javax.swing.JTextField();
        lblSalarioJ1 = new javax.swing.JLabel();
        a_txtSalarioJ = new javax.swing.JTextField();
        a_txtIdJugador = new javax.swing.JTextField();
        lblIdJugador = new javax.swing.JLabel();
        btnPrimeroJ = new javax.swing.JButton();
        btnAnteriorJ = new javax.swing.JButton();
        btnSiguienteJ = new javax.swing.JButton();
        btnUltimoJ = new javax.swing.JButton();
        btnActualizarDatosJugadores = new javax.swing.JButton();
        a_lblPosicionesJ = new javax.swing.JLabel();
        pPartidas1 = new javax.swing.JPanel();
        lblIdEquipoP3 = new javax.swing.JLabel();
        a_txtIdEquipoP1 = new javax.swing.JTextField();
        lblIdEquipoP4 = new javax.swing.JLabel();
        a_txtIdEquipoP2 = new javax.swing.JTextField();
        lblGanadorP1 = new javax.swing.JLabel();
        a_txtGanadorP = new javax.swing.JTextField();
        lblFechaP1 = new javax.swing.JLabel();
        a_txtFechaP = new com.toedter.calendar.JDateChooser();
        lblComienzoP1 = new javax.swing.JLabel();
        a_txtComienzoP = new com.github.lgooddatepicker.components.TimePicker();
        lblFinalP1 = new javax.swing.JLabel();
        a_txtFinalP = new com.github.lgooddatepicker.components.TimePicker();
        lblResultadoRondasP1 = new javax.swing.JLabel();
        a_txtResultadoRondasP = new javax.swing.JTextField();
        lblResultadoTotalP1 = new javax.swing.JLabel();
        a_txtResultadoTotalP = new javax.swing.JTextField();
        a_txtIdPartidaP = new javax.swing.JTextField();
        lblIdPartida = new javax.swing.JLabel();
        btnPrimeroP = new javax.swing.JButton();
        btnAnteriorP = new javax.swing.JButton();
        btnSiguienteP = new javax.swing.JButton();
        btnUltimoP = new javax.swing.JButton();
        btnActualizarDatosPartidas = new javax.swing.JButton();
        a_lblPosicionesP = new javax.swing.JLabel();
        pTorneos1 = new javax.swing.JPanel();
        lblNombreT1 = new javax.swing.JLabel();
        a_txtNombreT = new javax.swing.JTextField();
        lblEquipoGanadorT1 = new javax.swing.JLabel();
        a_txtEquipoGanadorT = new javax.swing.JTextField();
        lblLugarT1 = new javax.swing.JLabel();
        a_txtLugarT = new javax.swing.JTextField();
        lblFechaComT1 = new javax.swing.JLabel();
        a_txtFechaComT = new com.toedter.calendar.JDateChooser();
        lblFechaFinT1 = new javax.swing.JLabel();
        a_txtFechaFinT = new com.toedter.calendar.JDateChooser();
        lblPremioT1 = new javax.swing.JLabel();
        a_txtPremioT = new javax.swing.JTextField();
        a_txtIdTorneo = new javax.swing.JTextField();
        lblIdTorneo = new javax.swing.JLabel();
        btnPrimeroT = new javax.swing.JButton();
        btnAnteriorT = new javax.swing.JButton();
        btnSiguienteT = new javax.swing.JButton();
        btnUltimoT = new javax.swing.JButton();
        btnActualizarDatosTorneos = new javax.swing.JButton();
        a_lblPosicionesT = new javax.swing.JLabel();
        pTorneosAnunciantes1 = new javax.swing.JPanel();
        lblIdTorneoTA1 = new javax.swing.JLabel();
        a_txtIdTorneoTA = new javax.swing.JTextField();
        lblIdAnuncianteTA1 = new javax.swing.JLabel();
        a_txtIdAnuncianteTA = new javax.swing.JTextField();
        a_txtIdTorneoAnunciante = new javax.swing.JTextField();
        lblIdTorneoAnunciante = new javax.swing.JLabel();
        btnPrimeroTA = new javax.swing.JButton();
        btnAnteriorTA = new javax.swing.JButton();
        btnSiguienteTA = new javax.swing.JButton();
        btnUltimoTA = new javax.swing.JButton();
        btnActualizarDatosTorneosA = new javax.swing.JButton();
        a_lblPosicionesTA = new javax.swing.JLabel();
        pTorneosEquipos1 = new javax.swing.JPanel();
        lblIdTorneoTE1 = new javax.swing.JLabel();
        a_txtIdTorneoTE = new javax.swing.JTextField();
        lblIdequipoTE1 = new javax.swing.JLabel();
        a_txtIdEquipoTE = new javax.swing.JTextField();
        lblIdTorneoTE2 = new javax.swing.JLabel();
        a_txtIdTorneoEquipo = new javax.swing.JTextField();
        btnPrimeroTE = new javax.swing.JButton();
        btnAnteriorTE = new javax.swing.JButton();
        btnSiguienteTE = new javax.swing.JButton();
        btnUltimoTE = new javax.swing.JButton();
        btnActualizarDatosTorneosE = new javax.swing.JButton();
        a_lblPosicionesTE = new javax.swing.JLabel();
        pBorrar = new javax.swing.JPanel();
        pBorrar2 = new javax.swing.JTabbedPane();
        pAnunciantes2 = new javax.swing.JPanel();
        lblNombreA2 = new javax.swing.JLabel();
        b_txtNombreA = new javax.swing.JTextField();
        lblLogoA2 = new javax.swing.JLabel();
        b_txtLogoA = new javax.swing.JTextField();
        btnBorrarDatosAnunciantes = new javax.swing.JButton();
        btnPrimeroA1 = new javax.swing.JButton();
        btnAnteriorA1 = new javax.swing.JButton();
        btnSiguienteA1 = new javax.swing.JButton();
        btnUltimoA1 = new javax.swing.JButton();
        b_txtIdAnunciante = new javax.swing.JTextField();
        lblIdAnunciante1 = new javax.swing.JLabel();
        b_lblPosicionesA = new javax.swing.JLabel();
        b_txtPrecioA = new javax.swing.JTextField();
        lblPrecioA4 = new javax.swing.JLabel();
        pEquipos2 = new javax.swing.JPanel();
        lblNombreE2 = new javax.swing.JLabel();
        b_txtNombreE = new javax.swing.JTextField();
        b_txtLogoE = new javax.swing.JTextField();
        lblLogoE2 = new javax.swing.JLabel();
        lblLocalizacion2 = new javax.swing.JLabel();
        b_txtLocalizacionE = new javax.swing.JTextField();
        b_txtCoachE = new javax.swing.JTextField();
        lblCoachE2 = new javax.swing.JLabel();
        lblFundadoE2 = new javax.swing.JLabel();
        b_txtFundadoE = new com.toedter.calendar.JDateChooser();
        btnBorrarDatosEquipos = new javax.swing.JButton();
        btnPrimeroE1 = new javax.swing.JButton();
        btnAnteriorE1 = new javax.swing.JButton();
        btnSiguienteE1 = new javax.swing.JButton();
        btnUltimoE1 = new javax.swing.JButton();
        b_txtIdEquipo = new javax.swing.JTextField();
        lblIdEquipo1 = new javax.swing.JLabel();
        b_lblPosicionesE = new javax.swing.JLabel();
        pEstadisticas2 = new javax.swing.JPanel();
        lblIdPartidaEJ2 = new javax.swing.JLabel();
        b_txtIdPartidaEJ = new javax.swing.JTextField();
        lblIdJugadorEJ2 = new javax.swing.JLabel();
        b_txtIdJugadorEJ = new javax.swing.JTextField();
        lblKEJ2 = new javax.swing.JLabel();
        b_txtKEJ = new javax.swing.JTextField();
        lblDEJ2 = new javax.swing.JLabel();
        b_txtDEJ = new javax.swing.JTextField();
        lblAEJ2 = new javax.swing.JLabel();
        b_txtAEJ = new javax.swing.JTextField();
        lblAdrEJ2 = new javax.swing.JLabel();
        b_txtAdrEJ = new javax.swing.JTextField();
        lblIdEstadistica1 = new javax.swing.JLabel();
        b_txtIdEstadistica = new javax.swing.JTextField();
        btnPrimeroEJ1 = new javax.swing.JButton();
        btnAnteriorEJ1 = new javax.swing.JButton();
        btnSiguienteEJ1 = new javax.swing.JButton();
        btnUltimoEJ1 = new javax.swing.JButton();
        btnBorrarDatosEstadisticasJ = new javax.swing.JButton();
        b_lblPosicionesEJ = new javax.swing.JLabel();
        b_lblNombreJ = new javax.swing.JTextField();
        pJugadores2 = new javax.swing.JPanel();
        lblIdEquipoJ2 = new javax.swing.JLabel();
        b_txtIdEquipoJ = new javax.swing.JTextField();
        lblNombreJ2 = new javax.swing.JLabel();
        b_txtNombreJ = new javax.swing.JTextField();
        lblAkaJ2 = new javax.swing.JLabel();
        b_txtAkaJ = new javax.swing.JTextField();
        lblNacionalidadJ2 = new javax.swing.JLabel();
        b_txtNacionalidadJ = new javax.swing.JTextField();
        lblRolJ2 = new javax.swing.JLabel();
        b_txtRolJ = new javax.swing.JTextField();
        lblFechaNacJ2 = new javax.swing.JLabel();
        b_txtFechaNacJ = new com.toedter.calendar.JDateChooser();
        lblAnhosActivoJ2 = new javax.swing.JLabel();
        b_txtAnhosActivoJ = new javax.swing.JTextField();
        lblSalarioJ2 = new javax.swing.JLabel();
        b_txtSalarioJ = new javax.swing.JTextField();
        b_txtIdJugador = new javax.swing.JTextField();
        lblIdJugador1 = new javax.swing.JLabel();
        btnPrimeroJ1 = new javax.swing.JButton();
        btnAnteriorJ1 = new javax.swing.JButton();
        btnSiguienteJ1 = new javax.swing.JButton();
        btnUltimoJ1 = new javax.swing.JButton();
        btnBorrarDatosJugadores = new javax.swing.JButton();
        b_lblPosicionesJ = new javax.swing.JLabel();
        pPartidas2 = new javax.swing.JPanel();
        lblIdEquipoP5 = new javax.swing.JLabel();
        b_txtIdEquipoP1 = new javax.swing.JTextField();
        lblIdEquipoP6 = new javax.swing.JLabel();
        b_txtIdEquipoP2 = new javax.swing.JTextField();
        lblGanadorP2 = new javax.swing.JLabel();
        b_txtGanadorP = new javax.swing.JTextField();
        lblFechaP2 = new javax.swing.JLabel();
        b_txtFechaP = new com.toedter.calendar.JDateChooser();
        lblComienzoP2 = new javax.swing.JLabel();
        b_txtComienzoP = new com.github.lgooddatepicker.components.TimePicker();
        lblFinalP2 = new javax.swing.JLabel();
        b_txtFinalP = new com.github.lgooddatepicker.components.TimePicker();
        lblResultadoRondasP2 = new javax.swing.JLabel();
        b_txtResultadoRondasP = new javax.swing.JTextField();
        lblResultadoTotalP2 = new javax.swing.JLabel();
        b_txtResultadoTotalP = new javax.swing.JTextField();
        b_txtIdPartidaP = new javax.swing.JTextField();
        lblIdPartida1 = new javax.swing.JLabel();
        btnPrimeroP1 = new javax.swing.JButton();
        btnAnteriorP1 = new javax.swing.JButton();
        btnSiguienteP1 = new javax.swing.JButton();
        btnUltimoP1 = new javax.swing.JButton();
        btnBorrarDatosPartidas = new javax.swing.JButton();
        b_lblPosicionesP = new javax.swing.JLabel();
        pTorneos2 = new javax.swing.JPanel();
        lblNombreT2 = new javax.swing.JLabel();
        b_txtNombreT = new javax.swing.JTextField();
        lblEquipoGanadorT2 = new javax.swing.JLabel();
        b_txtEquipoGanadorT = new javax.swing.JTextField();
        lblLugarT2 = new javax.swing.JLabel();
        b_txtLugarT = new javax.swing.JTextField();
        lblFechaComT2 = new javax.swing.JLabel();
        b_txtFechaComT = new com.toedter.calendar.JDateChooser();
        lblFechaFinT2 = new javax.swing.JLabel();
        b_txtFechaFinT = new com.toedter.calendar.JDateChooser();
        lblPremioT2 = new javax.swing.JLabel();
        b_txtPremioT = new javax.swing.JTextField();
        b_txtIdTorneo = new javax.swing.JTextField();
        lblIdTorneo1 = new javax.swing.JLabel();
        btnPrimeroT1 = new javax.swing.JButton();
        btnAnteriorT1 = new javax.swing.JButton();
        btnSiguienteT1 = new javax.swing.JButton();
        btnUltimoT1 = new javax.swing.JButton();
        btnBorrarDatosTorneos = new javax.swing.JButton();
        b_lblPosicionesT = new javax.swing.JLabel();
        pTorneosAnunciantes2 = new javax.swing.JPanel();
        lblIdTorneoTA2 = new javax.swing.JLabel();
        b_txtIdTorneoTA = new javax.swing.JTextField();
        lblIdAnuncianteTA2 = new javax.swing.JLabel();
        b_txtIdAnuncianteTA = new javax.swing.JTextField();
        b_txtIdTorneoAnunciante = new javax.swing.JTextField();
        lblIdTorneoAnunciante1 = new javax.swing.JLabel();
        btnPrimeroTA1 = new javax.swing.JButton();
        btnAnteriorTA1 = new javax.swing.JButton();
        btnSiguienteTA1 = new javax.swing.JButton();
        btnUltimoTA1 = new javax.swing.JButton();
        btnBorrarDatosTorneosA = new javax.swing.JButton();
        b_lblPosicionesTA = new javax.swing.JLabel();
        pTorneosEquipos2 = new javax.swing.JPanel();
        lblIdTorneoTE3 = new javax.swing.JLabel();
        b_txtIdTorneoTE = new javax.swing.JTextField();
        lblIdequipoTE2 = new javax.swing.JLabel();
        b_txtIdEquipoTE = new javax.swing.JTextField();
        lblIdTorneoTE4 = new javax.swing.JLabel();
        b_txtIdTorneoEquipo = new javax.swing.JTextField();
        btnPrimeroTE1 = new javax.swing.JButton();
        btnAnteriorTE1 = new javax.swing.JButton();
        btnSiguienteTE1 = new javax.swing.JButton();
        btnUltimoTE1 = new javax.swing.JButton();
        btnBorrarDatosTorneosE = new javax.swing.JButton();
        b_lblPosicionesTE = new javax.swing.JLabel();
        verJugador = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdEquipo1 = new javax.swing.JTextField();
        txtIdEquipo2 = new javax.swing.JTextField();
        btnVerJugadores = new javax.swing.JButton();
        btnSeleccionarJugador = new javax.swing.JButton();
        rbtnEq1J1 = new javax.swing.JRadioButton();
        rbtnEq1J2 = new javax.swing.JRadioButton();
        rbtnEq1J3 = new javax.swing.JRadioButton();
        rbtnEq1J5 = new javax.swing.JRadioButton();
        rbtnEq1J4 = new javax.swing.JRadioButton();
        rbtnEq2J1 = new javax.swing.JRadioButton();
        rbtnEq2J2 = new javax.swing.JRadioButton();
        rbtnEq2J3 = new javax.swing.JRadioButton();
        rbtnEq2J4 = new javax.swing.JRadioButton();
        rbtnEq2J5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto ev3");
        setResizable(false);
        setSize(new java.awt.Dimension(650, 550));

        tpContenedor.setMaximumSize(new java.awt.Dimension(650, 550));
        tpContenedor.setPreferredSize(new java.awt.Dimension(650, 550));

        pInsertar.setPreferredSize(new java.awt.Dimension(650, 522));

        tpInsertar1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        btnMeterDatosAnunciantes.setText("Meter datos");
        btnMeterDatosAnunciantes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterDatosAnunciantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterDatosAnunciantesActionPerformed(evt);
            }
        });

        lblNombreA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreA.setText("Nombre");
        lblNombreA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblPrecioA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecioA.setText("Precio");
        lblPrecioA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtNombreA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        i_txtPrecioA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnBorrarA.setText("Borrar");
        btnBorrarA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAActionPerformed(evt);
            }
        });

        i_txtLogoA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblPrecioA3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecioA3.setText("Logo");
        lblPrecioA3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pAnunciantesLayout = new javax.swing.GroupLayout(pAnunciantes);
        pAnunciantes.setLayout(pAnunciantesLayout);
        pAnunciantesLayout.setHorizontalGroup(
            pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAnunciantesLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAnunciantesLayout.createSequentialGroup()
                        .addComponent(btnBorrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btnMeterDatosAnunciantes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(pAnunciantesLayout.createSequentialGroup()
                        .addGroup(pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pAnunciantesLayout.createSequentialGroup()
                                .addComponent(lblPrecioA3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(i_txtLogoA, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pAnunciantesLayout.createSequentialGroup()
                                    .addComponent(lblNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(i_txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pAnunciantesLayout.createSequentialGroup()
                                    .addComponent(lblPrecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(i_txtPrecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(105, Short.MAX_VALUE))))
        );
        pAnunciantesLayout.setVerticalGroup(
            pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAnunciantesLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(i_txtPrecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(i_txtLogoA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioA3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMeterDatosAnunciantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        tpInsertar1.addTab("Anunciantes", pAnunciantes);

        btnMeterDatosEquipos.setText("Meter datos");
        btnMeterDatosEquipos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterDatosEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterDatosEquiposActionPerformed(evt);
            }
        });

        lblNombreE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreE.setText("Nombre");
        lblNombreE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtNombreE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLogoE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoE.setText("Logo");
        lblLogoE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtLogoE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        i_txtLocalizacionE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLocalizacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLocalizacion.setText("Localizacion");
        lblLocalizacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblCoachE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCoachE.setText("Coach");
        lblCoachE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtCoachE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFundadoE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFundadoE.setText("Fundado");
        lblFundadoE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtFundadoE.setDateFormatString("yyyy-MM-dd");
        i_txtFundadoE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnBorrarE.setText("Borrar");
        btnBorrarE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pEquiposLayout = new javax.swing.GroupLayout(pEquipos);
        pEquipos.setLayout(pEquiposLayout);
        pEquiposLayout.setHorizontalGroup(
            pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEquiposLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEquiposLayout.createSequentialGroup()
                        .addComponent(btnBorrarE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMeterDatosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(pEquiposLayout.createSequentialGroup()
                        .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFundadoE, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblLocalizacion, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(lblLogoE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCoachE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pEquiposLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(i_txtNombreE, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(i_txtLogoE, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(i_txtLocalizacionE, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(i_txtCoachE, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEquiposLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(i_txtFundadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(79, Short.MAX_VALUE))))
        );
        pEquiposLayout.setVerticalGroup(
            pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEquiposLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogoE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtLogoE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtLocalizacionE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCoachE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtCoachE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFundadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtFundadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(pEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMeterDatosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        tpInsertar1.addTab("Equipos", pEquipos);

        lblIdPartidaEJ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdPartidaEJ.setText("Id partida");
        lblIdPartidaEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdPartidaEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdJugadorEJ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdJugadorEJ.setText("Id jugador");
        lblIdJugadorEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdJugadorEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblKEJ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKEJ.setText("k");
        lblKEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtKEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblDEJ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDEJ.setText("d");
        lblDEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtDEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnBorrarEJ.setText("Borrar");
        btnBorrarEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarEJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarEJActionPerformed(evt);
            }
        });

        btnMeterDatosEstadisticasJ.setText("Meter datos");
        btnMeterDatosEstadisticasJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterDatosEstadisticasJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterDatosEstadisticasJActionPerformed(evt);
            }
        });

        lblAEJ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAEJ.setText("a");
        lblAEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtAEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        i_txtAdrEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAdrEJ.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAdrEJ.setText("adr");
        lblAdrEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pEstadisticasJugLayout = new javax.swing.GroupLayout(pEstadisticasJug);
        pEstadisticasJug.setLayout(pEstadisticasJugLayout);
        pEstadisticasJugLayout.setHorizontalGroup(
            pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticasJugLayout.createSequentialGroup()
                .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEstadisticasJugLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblKEJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdPartidaEJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdJugadorEJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdrEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(i_txtIdPartidaEJ)
                            .addComponent(i_txtIdJugadorEJ)
                            .addComponent(i_txtKEJ)
                            .addComponent(i_txtDEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(i_txtAEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(i_txtAdrEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pEstadisticasJugLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnBorrarEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnMeterDatosEstadisticasJ, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pEstadisticasJugLayout.setVerticalGroup(
            pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticasJugLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdPartidaEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdPartidaEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdJugadorEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdJugadorEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblKEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtKEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtDEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtAEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdrEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtAdrEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(pEstadisticasJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMeterDatosEstadisticasJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        tpInsertar1.addTab("Estadisticas_jug", pEstadisticasJug);

        btnMeterDatosJugadores.setText("Meter datos");
        btnMeterDatosJugadores.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterDatosJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterDatosJugadoresActionPerformed(evt);
            }
        });

        lblIdEquipoJ.setText("Id equipo");
        lblIdEquipoJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdEquipoJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNombreJ.setText("Nombre");
        lblNombreJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtNombreJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAkaJ.setText("Aka");
        lblAkaJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtAkaJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFechaNacJ.setText("Fecha_nac");
        lblFechaNacJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblRolJ.setText("Rol");
        lblRolJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtRolJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        i_txtNacionalidadJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNacionalidadJ.setText("Nacionalidad");
        lblNacionalidadJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtSalarioJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSalarioJ.setText("Salario");
        lblSalarioJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblAnhosActivoJ.setText("Años activo");
        lblAnhosActivoJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtAnhosActivoJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        i_txtFechaNacJ.setDateFormatString("yyyy-MM-dd");
        i_txtFechaNacJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnBorrarJ.setText("Borrar");
        btnBorrarJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarJActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pJugadoresLayout = new javax.swing.GroupLayout(pJugadores);
        pJugadores.setLayout(pJugadoresLayout);
        pJugadoresLayout.setHorizontalGroup(
            pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJugadoresLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblIdEquipoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAkaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaNacJ, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRolJ, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNacionalidadJ, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addComponent(lblAnhosActivoJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSalarioJ, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBorrarJ, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pJugadoresLayout.createSequentialGroup()
                        .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(i_txtIdEquipoJ)
                            .addComponent(i_txtNombreJ, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtAkaJ, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtRolJ, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtNacionalidadJ, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtSalarioJ, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtAnhosActivoJ, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtFechaNacJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pJugadoresLayout.createSequentialGroup()
                        .addComponent(btnMeterDatosJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        pJugadoresLayout.setVerticalGroup(
            pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pJugadoresLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdEquipoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAkaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtAkaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNacionalidadJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtNacionalidadJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRolJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtRolJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNacJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtFechaNacJ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnhosActivoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtAnhosActivoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalarioJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtSalarioJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(pJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMeterDatosJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        tpInsertar1.addTab("Jugadores", pJugadores);

        lblIdEquipoP1.setText("Id equipo 1");
        lblIdEquipoP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdEquipoP1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdEquipoP2.setText("Id equipo 2");
        lblIdEquipoP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdEquipoP2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblGanadorP.setText("Ganador");
        lblGanadorP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtGanadorP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFechaP.setText("Fecha");
        lblFechaP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblComienzoP.setText("Hora comienzo");
        lblComienzoP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFinalP.setText("Hora finalizacion");
        lblFinalP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblResultadoRondasP.setText("Resultado rondas");
        lblResultadoRondasP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtResultadoRondasP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblResultadoTotalP.setText("Resultado total");
        lblResultadoTotalP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtResultadoTotalP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnBorrarP.setText("Borrar");
        btnBorrarP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPActionPerformed(evt);
            }
        });

        btnMeterDatosPartidas.setText("Meter datos");
        btnMeterDatosPartidas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterDatosPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterDatosPartidasActionPerformed(evt);
            }
        });

        i_txtFechaP.setDateFormatString("yyyy-MM-dd");
        i_txtFechaP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pPartidasLayout = new javax.swing.GroupLayout(pPartidas);
        pPartidas.setLayout(pPartidasLayout);
        pPartidasLayout.setHorizontalGroup(
            pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartidasLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBorrarP, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(lblIdEquipoP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaP, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(lblGanadorP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdEquipoP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblResultadoTotalP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComienzoP, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFinalP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblResultadoRondasP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPartidasLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnMeterDatosPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pPartidasLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(i_txtFechaP, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtIdEquipoP1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtIdEquipoP2)
                            .addComponent(i_txtGanadorP, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtResultadoTotalP, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtResultadoRondasP, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtComienzoP, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(i_txtFinalP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49))
        );
        pPartidasLayout.setVerticalGroup(
            pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPartidasLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdEquipoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdEquipoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGanadorP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtGanadorP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtFechaP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(i_txtComienzoP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComienzoP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtFinalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultadoRondasP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtResultadoRondasP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultadoTotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtResultadoTotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(pPartidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMeterDatosPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        tpInsertar1.addTab("Partidas", pPartidas);

        lblNombreT.setText("Nombre");
        lblNombreT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtNombreT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblEquipoGanadorT.setText("Equipo ganador");
        lblEquipoGanadorT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtEquipoGanadorT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLugarT.setText("Lugar");
        lblLugarT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtLugarT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        i_txtPremioT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblPremioT.setText("Premio");
        lblPremioT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFechaFinT.setText("Fecha finalizacion");
        lblFechaFinT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFechaComT.setText("Fecha comienzo");
        lblFechaComT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnMeterDatosTorneos.setText("Meter datos");
        btnMeterDatosTorneos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterDatosTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterDatosTorneosActionPerformed(evt);
            }
        });

        btnBorrarT.setText("Borrar");
        btnBorrarT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTActionPerformed(evt);
            }
        });

        i_txtFechaComT.setDateFormatString("yyyy-MM-dd");
        i_txtFechaComT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtFechaFinT.setDateFormatString("yyyy-MM-dd");
        i_txtFechaFinT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pTorneosLayout = new javax.swing.GroupLayout(pTorneos);
        pTorneos.setLayout(pTorneosLayout);
        pTorneosLayout.setHorizontalGroup(
            pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEquipoGanadorT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaComT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaFinT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLugarT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPremioT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(i_txtLugarT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(i_txtEquipoGanadorT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(i_txtNombreT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(i_txtPremioT, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtFechaComT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(i_txtFechaFinT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(pTorneosLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btnBorrarT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnMeterDatosTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pTorneosLayout.setVerticalGroup(
            pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEquipoGanadorT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtEquipoGanadorT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLugarT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtLugarT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaComT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtFechaComT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaFinT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtFechaFinT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPremioT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtPremioT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(pTorneosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMeterDatosTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        tpInsertar1.addTab("Torneos", pTorneos);

        lblIdTorneoTA.setText("Id torneo");
        lblIdTorneoTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdTorneoTA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdAnuncianteTA.setText("Id anunciante");
        lblIdAnuncianteTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdAnuncianteTA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnBorrarTA.setText("Borrar");
        btnBorrarTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTAActionPerformed(evt);
            }
        });

        btnMeterDatosTorneosA.setText("Meter datos");
        btnMeterDatosTorneosA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterDatosTorneosA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterDatosTorneosAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pTorneosAnunciantesLayout = new javax.swing.GroupLayout(pTorneosAnunciantes);
        pTorneosAnunciantes.setLayout(pTorneosAnunciantesLayout);
        pTorneosAnunciantesLayout.setHorizontalGroup(
            pTorneosAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosAnunciantesLayout.createSequentialGroup()
                .addGroup(pTorneosAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTorneosAnunciantesLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pTorneosAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdAnuncianteTA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdTorneoTA, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(pTorneosAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(i_txtIdTorneoTA, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(i_txtIdAnuncianteTA)))
                    .addGroup(pTorneosAnunciantesLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnBorrarTA, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnMeterDatosTorneosA, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        pTorneosAnunciantesLayout.setVerticalGroup(
            pTorneosAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosAnunciantesLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pTorneosAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdTorneoTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdTorneoTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdAnuncianteTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdAnuncianteTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(164, 164, 164)
                .addGroup(pTorneosAnunciantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMeterDatosTorneosA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        tpInsertar1.addTab("Torneos_anunciantes", pTorneosAnunciantes);

        lblIdTorneoTE.setText("Id torneo");
        lblIdTorneoTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdTorneoTE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdequipoTE.setText("Id equipo");
        lblIdequipoTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        i_txtIdEquipoTE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnBorrarTE.setText("Borrar");
        btnBorrarTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTEActionPerformed(evt);
            }
        });

        btnMeterDatosTorneosE.setText("Meter datos");
        btnMeterDatosTorneosE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMeterDatosTorneosE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeterDatosTorneosEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pTorneosEquiposLayout = new javax.swing.GroupLayout(pTorneosEquipos);
        pTorneosEquipos.setLayout(pTorneosEquiposLayout);
        pTorneosEquiposLayout.setHorizontalGroup(
            pTorneosEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosEquiposLayout.createSequentialGroup()
                .addGroup(pTorneosEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTorneosEquiposLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pTorneosEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdequipoTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdTorneoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(pTorneosEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(i_txtIdTorneoTE, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(i_txtIdEquipoTE)))
                    .addGroup(pTorneosEquiposLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnBorrarTE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnMeterDatosTorneosE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        pTorneosEquiposLayout.setVerticalGroup(
            pTorneosEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosEquiposLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pTorneosEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdTorneoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdTorneoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdequipoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_txtIdEquipoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(164, 164, 164)
                .addGroup(pTorneosEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarTE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMeterDatosTorneosE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        tpInsertar1.addTab("Torneos_equipos", pTorneosEquipos);

        javax.swing.GroupLayout pInsertarLayout = new javax.swing.GroupLayout(pInsertar);
        pInsertar.setLayout(pInsertarLayout);
        pInsertarLayout.setHorizontalGroup(
            pInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpInsertar1)
        );
        pInsertarLayout.setVerticalGroup(
            pInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpInsertar1)
        );

        tpContenedor.addTab("Insertar", pInsertar);

        pModificar.setPreferredSize(new java.awt.Dimension(650, 522));

        pModificar1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        pModificar1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        lblNombreA1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreA1.setText("Nombre");
        lblNombreA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtNombreA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblPrecioA1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecioA1.setText("Precio");
        lblPrecioA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtPrecioA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnActualizarDatosAnunciantes.setText("Actualizar datos");
        btnActualizarDatosAnunciantes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizarDatosAnunciantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosAnunciantesActionPerformed(evt);
            }
        });

        btnPrimeroA.setText("<<");
        btnPrimeroA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroAActionPerformed(evt);
            }
        });

        btnAnteriorA.setText("<");
        btnAnteriorA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorAActionPerformed(evt);
            }
        });

        btnSiguienteA.setText(">");
        btnSiguienteA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteAActionPerformed(evt);
            }
        });

        btnUltimoA.setText(">>");
        btnUltimoA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoAActionPerformed(evt);
            }
        });

        a_txtIdAnunciante.setEditable(false);
        a_txtIdAnunciante.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdAnunciante.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdAnunciante.setText("Id anunciante");
        lblIdAnunciante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_lblPosicionesA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_lblPosicionesA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtLogoA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLogoA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoA.setText("Logo");
        lblLogoA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pAnunciantes1Layout = new javax.swing.GroupLayout(pAnunciantes1);
        pAnunciantes1.setLayout(pAnunciantes1Layout);
        pAnunciantes1Layout.setHorizontalGroup(
            pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAnunciantes1Layout.createSequentialGroup()
                .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pAnunciantes1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(a_lblPosicionesA, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pAnunciantes1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pAnunciantes1Layout.createSequentialGroup()
                                .addComponent(lblLogoA, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(a_txtLogoA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pAnunciantes1Layout.createSequentialGroup()
                                    .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnActualizarDatosAnunciantes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pAnunciantes1Layout.createSequentialGroup()
                                            .addComponent(btnPrimeroA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnAnteriorA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnSiguienteA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnUltimoA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pAnunciantes1Layout.createSequentialGroup()
                                    .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblIdAnunciante, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(lblNombreA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(a_txtNombreA, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(a_txtIdAnunciante)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pAnunciantes1Layout.createSequentialGroup()
                                    .addComponent(lblPrecioA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(a_txtPrecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        pAnunciantes1Layout.setVerticalGroup(
            pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAnunciantes1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a_txtIdAnunciante, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdAnunciante, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a_txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreA1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a_txtLogoA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogoA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a_txtPrecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioA1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(pAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_lblPosicionesA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarDatosAnunciantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pModificar1.addTab("Anunciantes", pAnunciantes1);

        lblNombreE1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreE1.setText("Nombre");
        lblNombreE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtNombreE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        a_txtLogoE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLogoE1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoE1.setText("Logo");
        lblLogoE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblLocalizacion1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLocalizacion1.setText("Localizacion");
        lblLocalizacion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtLocalizacionE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        a_txtCoachE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCoachE1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCoachE1.setText("Coach");
        lblCoachE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFundadoE1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFundadoE1.setText("Fundado");
        lblFundadoE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtFundadoE.setDateFormatString("yyyy-MM-dd");
        a_txtFundadoE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnActualizarDatosEquipos.setText("Actualizar datos");
        btnActualizarDatosEquipos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizarDatosEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosEquiposActionPerformed(evt);
            }
        });

        btnPrimeroE.setText("<<");
        btnPrimeroE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroEActionPerformed(evt);
            }
        });

        btnAnteriorE.setText("<");
        btnAnteriorE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorEActionPerformed(evt);
            }
        });

        btnSiguienteE.setText(">");
        btnSiguienteE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteEActionPerformed(evt);
            }
        });

        btnUltimoE.setText(">>");
        btnUltimoE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoEActionPerformed(evt);
            }
        });

        a_txtIdEquipo.setEditable(false);
        a_txtIdEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdEquipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdEquipo.setText("Id equipo");
        lblIdEquipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_lblPosicionesE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_lblPosicionesE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pEquipos1Layout = new javax.swing.GroupLayout(pEquipos1);
        pEquipos1.setLayout(pEquipos1Layout);
        pEquipos1Layout.setHorizontalGroup(
            pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEquipos1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEquipos1Layout.createSequentialGroup()
                        .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pEquipos1Layout.createSequentialGroup()
                                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblFundadoE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLocalizacion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLogoE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNombreE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCoachE1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(lblIdEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(a_txtFundadoE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pEquipos1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(a_txtIdEquipo)
                                            .addComponent(a_txtNombreE)
                                            .addComponent(a_txtLogoE)
                                            .addComponent(a_txtLocalizacionE)
                                            .addComponent(a_txtCoachE, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
                            .addGroup(pEquipos1Layout.createSequentialGroup()
                                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(a_lblPosicionesE, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pEquipos1Layout.createSequentialGroup()
                                        .addComponent(btnPrimeroE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAnteriorE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSiguienteE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUltimoE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEquipos1Layout.createSequentialGroup()
                        .addComponent(btnActualizarDatosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
        );
        pEquipos1Layout.setVerticalGroup(
            pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEquipos1Layout.createSequentialGroup()
                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEquipos1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEquipos1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(a_txtIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreE1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogoE1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtLogoE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLocalizacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtLocalizacionE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCoachE1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtCoachE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFundadoE1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtFundadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(a_lblPosicionesE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarDatosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pModificar1.addTab("Equipos", pEquipos1);

        lblIdPartidaEJ1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdPartidaEJ1.setText("Id partida");
        lblIdPartidaEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdPartidaEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdJugadorEJ1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdJugadorEJ1.setText("Id jugador");
        lblIdJugadorEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdJugadorEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblKEJ1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKEJ1.setText("k");
        lblKEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtKEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblDEJ1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDEJ1.setText("d");
        lblDEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtDEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAEJ1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAEJ1.setText("a");
        lblAEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtAEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAdrEJ1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAdrEJ1.setText("adr");
        lblAdrEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtAdrEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdEstadistica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdEstadistica.setText("Id estadistica");
        lblIdEstadistica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdEstadistica.setEditable(false);
        a_txtIdEstadistica.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnPrimeroEJ.setText("<<");
        btnPrimeroEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroEJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroEJActionPerformed(evt);
            }
        });

        btnAnteriorEJ.setText("<");
        btnAnteriorEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorEJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorEJActionPerformed(evt);
            }
        });

        btnSiguienteEJ.setText(">");
        btnSiguienteEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteEJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteEJActionPerformed(evt);
            }
        });

        btnUltimoEJ.setText(">>");
        btnUltimoEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoEJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoEJActionPerformed(evt);
            }
        });

        btnActualizarDatosEstadisticasJ.setText("Actualizar datos");
        btnActualizarDatosEstadisticasJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizarDatosEstadisticasJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosEstadisticasJActionPerformed(evt);
            }
        });

        a_lblPosicionesEJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_lblPosicionesEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_lblNombreJ.setEditable(false);
        a_lblNombreJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pEstadisticas1Layout = new javax.swing.GroupLayout(pEstadisticas1);
        pEstadisticas1.setLayout(pEstadisticas1Layout);
        pEstadisticas1Layout.setHorizontalGroup(
            pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticas1Layout.createSequentialGroup()
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(a_lblNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pEstadisticas1Layout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pEstadisticas1Layout.createSequentialGroup()
                                    .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblKEJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblIdPartidaEJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblIdJugadorEJ1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(lblIdEstadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblAdrEJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblAEJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblDEJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(a_txtIdPartidaEJ)
                                        .addComponent(a_txtIdJugadorEJ)
                                        .addComponent(a_txtKEJ)
                                        .addComponent(a_txtDEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a_txtAEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a_txtAdrEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(a_txtIdEstadistica)))
                                .addGroup(pEstadisticas1Layout.createSequentialGroup()
                                    .addComponent(btnPrimeroEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnActualizarDatosEstadisticasJ, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pEstadisticas1Layout.createSequentialGroup()
                                            .addComponent(btnAnteriorEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnSiguienteEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnUltimoEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(pEstadisticas1Layout.createSequentialGroup()
                            .addGap(175, 175, 175)
                            .addComponent(a_lblPosicionesEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        pEstadisticas1Layout.setVerticalGroup(
            pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticas1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(a_lblNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdPartidaEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdPartidaEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdJugadorEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdJugadorEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblKEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtKEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtDEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtAEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdrEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtAdrEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pEstadisticas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_lblPosicionesEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarDatosEstadisticasJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pModificar1.addTab("Estadisticas_jug", pEstadisticas1);

        lblIdEquipoJ1.setText("Id equipo");
        lblIdEquipoJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdEquipoJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNombreJ1.setText("Nombre");
        lblNombreJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtNombreJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAkaJ1.setText("Aka");
        lblAkaJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtAkaJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNacionalidadJ1.setText("Nacionalidad");
        lblNacionalidadJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtNacionalidadJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblRolJ1.setText("Rol");
        lblRolJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtRolJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFechaNacJ1.setText("Fecha_nac");
        lblFechaNacJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtFechaNacJ.setDateFormatString("yyyy-MM-dd");
        a_txtFechaNacJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblAnhosActivoJ1.setText("Años activo");
        lblAnhosActivoJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtAnhosActivoJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSalarioJ1.setText("Salario");
        lblSalarioJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtSalarioJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        a_txtIdJugador.setEditable(false);
        a_txtIdJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdJugador.setText("Id jugador");
        lblIdJugador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPrimeroJ.setText("<<");
        btnPrimeroJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroJActionPerformed(evt);
            }
        });

        btnAnteriorJ.setText("<");
        btnAnteriorJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorJActionPerformed(evt);
            }
        });

        btnSiguienteJ.setText(">");
        btnSiguienteJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteJActionPerformed(evt);
            }
        });

        btnUltimoJ.setText(">>");
        btnUltimoJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoJActionPerformed(evt);
            }
        });

        btnActualizarDatosJugadores.setText("Actualizar datos");
        btnActualizarDatosJugadores.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizarDatosJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosJugadoresActionPerformed(evt);
            }
        });

        a_lblPosicionesJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_lblPosicionesJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pJugadores1Layout = new javax.swing.GroupLayout(pJugadores1);
        pJugadores1.setLayout(pJugadores1Layout);
        pJugadores1Layout.setHorizontalGroup(
            pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJugadores1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pJugadores1Layout.createSequentialGroup()
                        .addComponent(btnPrimeroJ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnteriorJ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteJ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pJugadores1Layout.createSequentialGroup()
                        .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblIdEquipoJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAkaJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFechaNacJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRolJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNacionalidadJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAnhosActivoJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSalarioJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblIdJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(a_txtSalarioJ, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(a_txtAnhosActivoJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(a_txtFechaNacJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(a_txtRolJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(a_txtNacionalidadJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(a_txtAkaJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(a_txtNombreJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(a_txtIdEquipoJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(a_txtIdJugador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pJugadores1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(a_lblPosicionesJ, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarDatosJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        pJugadores1Layout.setVerticalGroup(
            pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJugadores1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdEquipoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAkaJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtAkaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNacionalidadJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtNacionalidadJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRolJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtRolJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNacJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtFechaNacJ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnhosActivoJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtAnhosActivoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalarioJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtSalarioJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(pJugadores1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarDatosJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_lblPosicionesJ, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pModificar1.addTab("Jugadores", pJugadores1);

        lblIdEquipoP3.setText("Id equipo 1");
        lblIdEquipoP3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdEquipoP1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdEquipoP4.setText("Id equipo 2");
        lblIdEquipoP4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdEquipoP2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblGanadorP1.setText("Ganador");
        lblGanadorP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtGanadorP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFechaP1.setText("Fecha");
        lblFechaP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtFechaP.setDateFormatString("yyyy-MM-dd");
        a_txtFechaP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblComienzoP1.setText("Hora comienzo");
        lblComienzoP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFinalP1.setText("Hora finalizacion");
        lblFinalP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblResultadoRondasP1.setText("Resultado rondas");
        lblResultadoRondasP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtResultadoRondasP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblResultadoTotalP1.setText("Resultado total");
        lblResultadoTotalP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtResultadoTotalP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        a_txtIdPartidaP.setEditable(false);
        a_txtIdPartidaP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdPartida.setText("Id partida");
        lblIdPartida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPrimeroP.setText("<<");
        btnPrimeroP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroPActionPerformed(evt);
            }
        });

        btnAnteriorP.setText("<");
        btnAnteriorP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorPActionPerformed(evt);
            }
        });

        btnSiguienteP.setText(">");
        btnSiguienteP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguientePActionPerformed(evt);
            }
        });

        btnUltimoP.setText(">>");
        btnUltimoP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoPActionPerformed(evt);
            }
        });

        btnActualizarDatosPartidas.setText("Actualizar datos");
        btnActualizarDatosPartidas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizarDatosPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosPartidasActionPerformed(evt);
            }
        });

        a_lblPosicionesP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_lblPosicionesP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pPartidas1Layout = new javax.swing.GroupLayout(pPartidas1);
        pPartidas1.setLayout(pPartidas1Layout);
        pPartidas1Layout.setHorizontalGroup(
            pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartidas1Layout.createSequentialGroup()
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPartidas1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdEquipoP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechaP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGanadorP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdEquipoP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResultadoTotalP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblComienzoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFinalP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResultadoRondasP1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(a_txtResultadoTotalP)
                            .addComponent(a_txtResultadoRondasP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a_txtFinalP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(a_txtComienzoP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(a_txtFechaP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(a_txtGanadorP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a_txtIdEquipoP2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a_txtIdEquipoP1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a_txtIdPartidaP)))
                    .addGroup(pPartidas1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnPrimeroP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnteriorP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPartidas1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(a_lblPosicionesP, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarDatosPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pPartidas1Layout.setVerticalGroup(
            pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartidas1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdPartidaP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoP3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdEquipoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoP4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdEquipoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGanadorP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtGanadorP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtFechaP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_txtComienzoP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComienzoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinalP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtFinalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultadoRondasP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtResultadoRondasP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultadoTotalP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtResultadoTotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPartidas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarDatosPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_lblPosicionesP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pModificar1.addTab("Partidas", pPartidas1);

        lblNombreT1.setText("Nombre");
        lblNombreT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtNombreT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblEquipoGanadorT1.setText("Equipo ganador");
        lblEquipoGanadorT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtEquipoGanadorT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLugarT1.setText("Lugar");
        lblLugarT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtLugarT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFechaComT1.setText("Fecha comienzo");
        lblFechaComT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtFechaComT.setDateFormatString("yyyy-MM-dd");
        a_txtFechaComT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFechaFinT1.setText("Fecha finalizacion");
        lblFechaFinT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtFechaFinT.setDateFormatString("yyyy-MM-dd");
        a_txtFechaFinT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblPremioT1.setText("Premio");
        lblPremioT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtPremioT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        a_txtIdTorneo.setEditable(false);
        a_txtIdTorneo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdTorneo.setText("Id torneo");
        lblIdTorneo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPrimeroT.setText("<<");
        btnPrimeroT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroTActionPerformed(evt);
            }
        });

        btnAnteriorT.setText("<");
        btnAnteriorT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorTActionPerformed(evt);
            }
        });

        btnSiguienteT.setText(">");
        btnSiguienteT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteTActionPerformed(evt);
            }
        });

        btnUltimoT.setText(">>");
        btnUltimoT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoTActionPerformed(evt);
            }
        });

        btnActualizarDatosTorneos.setText("Actualizar datos");
        btnActualizarDatosTorneos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizarDatosTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosTorneosActionPerformed(evt);
            }
        });

        a_lblPosicionesT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_lblPosicionesT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pTorneos1Layout = new javax.swing.GroupLayout(pTorneos1);
        pTorneos1.setLayout(pTorneos1Layout);
        pTorneos1Layout.setHorizontalGroup(
            pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneos1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdTorneo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEquipoGanadorT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaComT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaFinT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLugarT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPremioT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(a_txtLugarT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_txtEquipoGanadorT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_txtNombreT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_txtPremioT, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtFechaComT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a_txtFechaFinT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdTorneo, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(46, 46, 46))
            .addGroup(pTorneos1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnPrimeroT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarDatosTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pTorneos1Layout.createSequentialGroup()
                        .addComponent(btnAnteriorT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneos1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(a_lblPosicionesT, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
        );
        pTorneos1Layout.setVerticalGroup(
            pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneos1Layout.createSequentialGroup()
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTorneos1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblIdTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneos1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(a_txtIdTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreT1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEquipoGanadorT1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtEquipoGanadorT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLugarT1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtLugarT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaComT1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtFechaComT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaFinT1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtFechaFinT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPremioT1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtPremioT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pTorneos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(a_lblPosicionesT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnActualizarDatosTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pModificar1.addTab("Torneos", pTorneos1);

        lblIdTorneoTA1.setText("Id torneo");
        lblIdTorneoTA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdTorneoTA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdAnuncianteTA1.setText("Id anunciante");
        lblIdAnuncianteTA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdAnuncianteTA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        a_txtIdTorneoAnunciante.setEditable(false);
        a_txtIdTorneoAnunciante.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdTorneoAnunciante.setText("Id torneo anunciante");
        lblIdTorneoAnunciante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPrimeroTA.setText("<<");
        btnPrimeroTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroTAActionPerformed(evt);
            }
        });

        btnAnteriorTA.setText("<");
        btnAnteriorTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorTAActionPerformed(evt);
            }
        });

        btnSiguienteTA.setText(">");
        btnSiguienteTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteTAActionPerformed(evt);
            }
        });

        btnUltimoTA.setText(">>");
        btnUltimoTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoTAActionPerformed(evt);
            }
        });

        btnActualizarDatosTorneosA.setText("Actualizar datos");
        btnActualizarDatosTorneosA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizarDatosTorneosA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosTorneosAActionPerformed(evt);
            }
        });

        a_lblPosicionesTA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_lblPosicionesTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pTorneosAnunciantes1Layout = new javax.swing.GroupLayout(pTorneosAnunciantes1);
        pTorneosAnunciantes1.setLayout(pTorneosAnunciantes1Layout);
        pTorneosAnunciantes1Layout.setHorizontalGroup(
            pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosAnunciantes1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIdTorneoAnunciante, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(lblIdTorneoTA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdAnuncianteTA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(a_txtIdTorneoAnunciante)
                    .addComponent(a_txtIdTorneoTA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_txtIdAnuncianteTA, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(pTorneosAnunciantes1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTorneosAnunciantes1Layout.createSequentialGroup()
                        .addComponent(btnPrimeroTA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnteriorTA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteTA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoTA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosAnunciantes1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizarDatosTorneosA, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosAnunciantes1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(a_lblPosicionesTA, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );
        pTorneosAnunciantes1Layout.setVerticalGroup(
            pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosAnunciantes1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_txtIdTorneoAnunciante, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdTorneoAnunciante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdTorneoTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdTorneoTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdAnuncianteTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a_txtIdAnuncianteTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(pTorneosAnunciantes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(a_lblPosicionesTA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnActualizarDatosTorneosA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pModificar1.addTab("Torneos_anunciantes", pTorneosAnunciantes1);

        lblIdTorneoTE1.setText("Id torneo");
        lblIdTorneoTE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdTorneoTE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdequipoTE1.setText("Id equipo");
        lblIdequipoTE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdEquipoTE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdTorneoTE2.setText("Id torneo equipo");
        lblIdTorneoTE2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        a_txtIdTorneoEquipo.setEditable(false);
        a_txtIdTorneoEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnPrimeroTE.setText("<<");
        btnPrimeroTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroTEActionPerformed(evt);
            }
        });

        btnAnteriorTE.setText("<");
        btnAnteriorTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorTEActionPerformed(evt);
            }
        });

        btnSiguienteTE.setText(">");
        btnSiguienteTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteTEActionPerformed(evt);
            }
        });

        btnUltimoTE.setText(">>");
        btnUltimoTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoTEActionPerformed(evt);
            }
        });

        btnActualizarDatosTorneosE.setText("Actualizar datos");
        btnActualizarDatosTorneosE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnActualizarDatosTorneosE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosTorneosEActionPerformed(evt);
            }
        });

        a_lblPosicionesTE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_lblPosicionesTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pTorneosEquipos1Layout = new javax.swing.GroupLayout(pTorneosEquipos1);
        pTorneosEquipos1.setLayout(pTorneosEquipos1Layout);
        pTorneosEquipos1Layout.setHorizontalGroup(
            pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosEquipos1Layout.createSequentialGroup()
                .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTorneosEquipos1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdequipoTE1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblIdTorneoTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblIdTorneoTE2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(a_txtIdTorneoEquipo)
                            .addComponent(a_txtIdTorneoTE, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(a_txtIdEquipoTE, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                    .addGroup(pTorneosEquipos1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnPrimeroTE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnteriorTE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteTE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosEquipos1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosEquipos1Layout.createSequentialGroup()
                        .addComponent(btnActualizarDatosTorneosE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosEquipos1Layout.createSequentialGroup()
                        .addComponent(a_lblPosicionesTE, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        pTorneosEquipos1Layout.setVerticalGroup(
            pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosEquipos1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_txtIdTorneoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdTorneoTE2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_txtIdTorneoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdTorneoTE1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a_txtIdEquipoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdequipoTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(pTorneosEquipos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroTE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorTE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteTE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(a_lblPosicionesTE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnActualizarDatosTorneosE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        pModificar1.addTab("Torneos_equipos", pTorneosEquipos1);

        javax.swing.GroupLayout pModificarLayout = new javax.swing.GroupLayout(pModificar);
        pModificar.setLayout(pModificarLayout);
        pModificarLayout.setHorizontalGroup(
            pModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pModificar1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        pModificarLayout.setVerticalGroup(
            pModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pModificar1)
        );

        tpContenedor.addTab("Actualizar", pModificar);

        pBorrar.setPreferredSize(new java.awt.Dimension(650, 522));

        pBorrar2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        pBorrar2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        lblNombreA2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreA2.setText("Nombre");
        lblNombreA2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtNombreA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLogoA2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoA2.setText("Logo");
        lblLogoA2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtLogoA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnBorrarDatosAnunciantes.setText("Borrar datos");
        btnBorrarDatosAnunciantes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarDatosAnunciantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosAnunciantesActionPerformed(evt);
            }
        });

        btnPrimeroA1.setText("<<");
        btnPrimeroA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroA1ActionPerformed(evt);
            }
        });

        btnAnteriorA1.setText("<");
        btnAnteriorA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorA1ActionPerformed(evt);
            }
        });

        btnSiguienteA1.setText(">");
        btnSiguienteA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteA1ActionPerformed(evt);
            }
        });

        btnUltimoA1.setText(">>");
        btnUltimoA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoA1ActionPerformed(evt);
            }
        });

        b_txtIdAnunciante.setEditable(false);
        b_txtIdAnunciante.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdAnunciante1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdAnunciante1.setText("Id anunciante");
        lblIdAnunciante1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_lblPosicionesA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_lblPosicionesA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtPrecioA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblPrecioA4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecioA4.setText("Precio");
        lblPrecioA4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pAnunciantes2Layout = new javax.swing.GroupLayout(pAnunciantes2);
        pAnunciantes2.setLayout(pAnunciantes2Layout);
        pAnunciantes2Layout.setHorizontalGroup(
            pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAnunciantes2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAnunciantes2Layout.createSequentialGroup()
                        .addComponent(lblPrecioA4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_txtPrecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pAnunciantes2Layout.createSequentialGroup()
                            .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBorrarDatosAnunciantes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pAnunciantes2Layout.createSequentialGroup()
                                    .addComponent(btnPrimeroA1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAnteriorA1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSiguienteA1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pAnunciantes2Layout.createSequentialGroup()
                                    .addComponent(b_lblPosicionesA, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnUltimoA1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pAnunciantes2Layout.createSequentialGroup()
                            .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblIdAnunciante1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(lblNombreA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLogoA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(b_txtNombreA)
                                .addComponent(b_txtIdAnunciante)
                                .addComponent(b_txtLogoA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        pAnunciantes2Layout.setVerticalGroup(
            pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAnunciantes2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_txtIdAnunciante, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdAnunciante1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreA2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_txtLogoA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogoA2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_txtPrecioA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioA4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_lblPosicionesA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnBorrarDatosAnunciantes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pBorrar2.addTab("Anunciantes", pAnunciantes2);

        lblNombreE2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreE2.setText("Nombre");
        lblNombreE2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtNombreE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b_txtLogoE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLogoE2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogoE2.setText("Logo");
        lblLogoE2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblLocalizacion2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLocalizacion2.setText("Localizacion");
        lblLocalizacion2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtLocalizacionE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b_txtCoachE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblCoachE2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCoachE2.setText("Coach");
        lblCoachE2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFundadoE2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFundadoE2.setText("Fundado");
        lblFundadoE2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtFundadoE.setDateFormatString("yyyy-MM-dd");
        b_txtFundadoE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnBorrarDatosEquipos.setText("Borar datos");
        btnBorrarDatosEquipos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarDatosEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosEquiposActionPerformed(evt);
            }
        });

        btnPrimeroE1.setText("<<");
        btnPrimeroE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroE1ActionPerformed(evt);
            }
        });

        btnAnteriorE1.setText("<");
        btnAnteriorE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorE1ActionPerformed(evt);
            }
        });

        btnSiguienteE1.setText(">");
        btnSiguienteE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteE1ActionPerformed(evt);
            }
        });

        btnUltimoE1.setText(">>");
        btnUltimoE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoE1ActionPerformed(evt);
            }
        });

        b_txtIdEquipo.setEditable(false);
        b_txtIdEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdEquipo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdEquipo1.setText("Id equipo");
        lblIdEquipo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_lblPosicionesE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_lblPosicionesE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pEquipos2Layout = new javax.swing.GroupLayout(pEquipos2);
        pEquipos2.setLayout(pEquipos2Layout);
        pEquipos2Layout.setHorizontalGroup(
            pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEquipos2Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEquipos2Layout.createSequentialGroup()
                        .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pEquipos2Layout.createSequentialGroup()
                                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblFundadoE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLocalizacion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLogoE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNombreE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCoachE2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(lblIdEquipo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b_txtFundadoE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pEquipos2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(b_txtIdEquipo)
                                            .addComponent(b_txtNombreE)
                                            .addComponent(b_txtLogoE)
                                            .addComponent(b_txtLocalizacionE)
                                            .addComponent(b_txtCoachE, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
                            .addGroup(pEquipos2Layout.createSequentialGroup()
                                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(b_lblPosicionesE, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pEquipos2Layout.createSequentialGroup()
                                        .addComponent(btnPrimeroE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAnteriorE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSiguienteE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUltimoE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEquipos2Layout.createSequentialGroup()
                        .addComponent(btnBorrarDatosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))))
        );
        pEquipos2Layout.setVerticalGroup(
            pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEquipos2Layout.createSequentialGroup()
                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEquipos2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblIdEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEquipos2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_txtIdEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreE2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogoE2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtLogoE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLocalizacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtLocalizacionE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCoachE2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtCoachE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFundadoE2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtFundadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroE1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorE1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteE1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoE1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(b_lblPosicionesE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarDatosEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pBorrar2.addTab("Equipos", pEquipos2);

        lblIdPartidaEJ2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdPartidaEJ2.setText("Id partida");
        lblIdPartidaEJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdPartidaEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdJugadorEJ2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdJugadorEJ2.setText("Id jugador");
        lblIdJugadorEJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdJugadorEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblKEJ2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKEJ2.setText("k");
        lblKEJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtKEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblDEJ2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDEJ2.setText("d");
        lblDEJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtDEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAEJ2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAEJ2.setText("a");
        lblAEJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtAEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAdrEJ2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAdrEJ2.setText("adr");
        lblAdrEJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtAdrEJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdEstadistica1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdEstadistica1.setText("Id estadistica");
        lblIdEstadistica1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdEstadistica.setEditable(false);
        b_txtIdEstadistica.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnPrimeroEJ1.setText("<<");
        btnPrimeroEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroEJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroEJ1ActionPerformed(evt);
            }
        });

        btnAnteriorEJ1.setText("<");
        btnAnteriorEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorEJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorEJ1ActionPerformed(evt);
            }
        });

        btnSiguienteEJ1.setText(">");
        btnSiguienteEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteEJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteEJ1ActionPerformed(evt);
            }
        });

        btnUltimoEJ1.setText(">>");
        btnUltimoEJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoEJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoEJ1ActionPerformed(evt);
            }
        });

        btnBorrarDatosEstadisticasJ.setText("Borrar datos");
        btnBorrarDatosEstadisticasJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarDatosEstadisticasJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosEstadisticasJActionPerformed(evt);
            }
        });

        b_lblPosicionesEJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_lblPosicionesEJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_lblNombreJ.setEditable(false);
        b_lblNombreJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pEstadisticas2Layout = new javax.swing.GroupLayout(pEstadisticas2);
        pEstadisticas2.setLayout(pEstadisticas2Layout);
        pEstadisticas2Layout.setHorizontalGroup(
            pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticas2Layout.createSequentialGroup()
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pEstadisticas2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pEstadisticas2Layout.createSequentialGroup()
                                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblKEJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIdPartidaEJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblIdJugadorEJ2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(lblDEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAdrEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIdEstadistica1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(b_txtIdPartidaEJ)
                                    .addComponent(b_txtIdJugadorEJ)
                                    .addComponent(b_txtKEJ)
                                    .addComponent(b_txtDEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_txtAEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_txtAdrEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_txtIdEstadistica)))
                            .addGroup(pEstadisticas2Layout.createSequentialGroup()
                                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBorrarDatosEstadisticasJ, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pEstadisticas2Layout.createSequentialGroup()
                                        .addComponent(btnPrimeroEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAnteriorEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSiguienteEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUltimoEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pEstadisticas2Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(b_lblPosicionesEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEstadisticas2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_lblNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        pEstadisticas2Layout.setVerticalGroup(
            pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstadisticas2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_lblNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdEstadistica1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdPartidaEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdPartidaEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdJugadorEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdJugadorEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblKEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtKEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtDEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtAEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAdrEJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtAdrEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pEstadisticas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoEJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b_lblPosicionesEJ, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrarDatosEstadisticasJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pBorrar2.addTab("Estadisticas_jug", pEstadisticas2);

        lblIdEquipoJ2.setText("Id equipo");
        lblIdEquipoJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdEquipoJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNombreJ2.setText("Nombre");
        lblNombreJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtNombreJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblAkaJ2.setText("Aka");
        lblAkaJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtAkaJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNacionalidadJ2.setText("Nacionalidad");
        lblNacionalidadJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtNacionalidadJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblRolJ2.setText("Rol");
        lblRolJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtRolJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFechaNacJ2.setText("Fecha_nac");
        lblFechaNacJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtFechaNacJ.setDateFormatString("yyyy-MM-dd");
        b_txtFechaNacJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblAnhosActivoJ2.setText("Años activo");
        lblAnhosActivoJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtAnhosActivoJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblSalarioJ2.setText("Salario");
        lblSalarioJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtSalarioJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b_txtIdJugador.setEditable(false);
        b_txtIdJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdJugador1.setText("Id jugador");
        lblIdJugador1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPrimeroJ1.setText("<<");
        btnPrimeroJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroJ1ActionPerformed(evt);
            }
        });

        btnAnteriorJ1.setText("<");
        btnAnteriorJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorJ1ActionPerformed(evt);
            }
        });

        btnSiguienteJ1.setText(">");
        btnSiguienteJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteJ1ActionPerformed(evt);
            }
        });

        btnUltimoJ1.setText(">>");
        btnUltimoJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoJ1ActionPerformed(evt);
            }
        });

        btnBorrarDatosJugadores.setText("Borrar datos");
        btnBorrarDatosJugadores.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarDatosJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosJugadoresActionPerformed(evt);
            }
        });

        b_lblPosicionesJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_lblPosicionesJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pJugadores2Layout = new javax.swing.GroupLayout(pJugadores2);
        pJugadores2.setLayout(pJugadores2Layout);
        pJugadores2Layout.setHorizontalGroup(
            pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJugadores2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pJugadores2Layout.createSequentialGroup()
                        .addComponent(btnPrimeroJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnteriorJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pJugadores2Layout.createSequentialGroup()
                        .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblIdEquipoJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAkaJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFechaNacJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRolJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNacionalidadJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAnhosActivoJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSalarioJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblIdJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_txtSalarioJ, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(b_txtAnhosActivoJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(b_txtFechaNacJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(b_txtRolJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(b_txtNacionalidadJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(b_txtAkaJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(b_txtNombreJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(b_txtIdEquipoJ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(b_txtIdJugador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pJugadores2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_lblPosicionesJ, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarDatosJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        pJugadores2Layout.setVerticalGroup(
            pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJugadores2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdEquipoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtNombreJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAkaJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtAkaJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNacionalidadJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtNacionalidadJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRolJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtRolJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNacJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtFechaNacJ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnhosActivoJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtAnhosActivoJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalarioJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtSalarioJ, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(pJugadores2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarDatosJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_lblPosicionesJ, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pBorrar2.addTab("Jugadores", pJugadores2);

        lblIdEquipoP5.setText("Id equipo 1");
        lblIdEquipoP5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdEquipoP1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdEquipoP6.setText("Id equipo 2");
        lblIdEquipoP6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdEquipoP2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblGanadorP2.setText("Ganador");
        lblGanadorP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtGanadorP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFechaP2.setText("Fecha");
        lblFechaP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtFechaP.setDateFormatString("yyyy-MM-dd");
        b_txtFechaP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblComienzoP2.setText("Hora comienzo");
        lblComienzoP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFinalP2.setText("Hora finalizacion");
        lblFinalP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblResultadoRondasP2.setText("Resultado rondas");
        lblResultadoRondasP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtResultadoRondasP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblResultadoTotalP2.setText("Resultado total");
        lblResultadoTotalP2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtResultadoTotalP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b_txtIdPartidaP.setEditable(false);
        b_txtIdPartidaP.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdPartida1.setText("Id partida");
        lblIdPartida1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPrimeroP1.setText("<<");
        btnPrimeroP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroP1ActionPerformed(evt);
            }
        });

        btnAnteriorP1.setText("<");
        btnAnteriorP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorP1ActionPerformed(evt);
            }
        });

        btnSiguienteP1.setText(">");
        btnSiguienteP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteP1ActionPerformed(evt);
            }
        });

        btnUltimoP1.setText(">>");
        btnUltimoP1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoP1ActionPerformed(evt);
            }
        });

        btnBorrarDatosPartidas.setText("Borrar datos");
        btnBorrarDatosPartidas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarDatosPartidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosPartidasActionPerformed(evt);
            }
        });

        b_lblPosicionesP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_lblPosicionesP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pPartidas2Layout = new javax.swing.GroupLayout(pPartidas2);
        pPartidas2.setLayout(pPartidas2Layout);
        pPartidas2Layout.setHorizontalGroup(
            pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartidas2Layout.createSequentialGroup()
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPartidas2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdPartida1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdEquipoP6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechaP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGanadorP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdEquipoP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResultadoTotalP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblComienzoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFinalP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResultadoRondasP2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_txtResultadoTotalP)
                            .addComponent(b_txtResultadoRondasP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b_txtFinalP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_txtComienzoP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_txtFechaP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(b_txtGanadorP, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b_txtIdEquipoP2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b_txtIdEquipoP1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(b_txtIdPartidaP)))
                    .addGroup(pPartidas2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnPrimeroP1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnteriorP1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteP1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPartidas2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_lblPosicionesP, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarDatosPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pPartidas2Layout.setVerticalGroup(
            pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPartidas2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPartida1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdPartidaP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoP5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdEquipoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdEquipoP6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdEquipoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGanadorP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtGanadorP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtFechaP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_txtComienzoP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComienzoP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinalP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtFinalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultadoRondasP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtResultadoRondasP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultadoTotalP2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtResultadoTotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPartidas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarDatosPartidas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_lblPosicionesP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pBorrar2.addTab("Partidas", pPartidas2);

        lblNombreT2.setText("Nombre");
        lblNombreT2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtNombreT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblEquipoGanadorT2.setText("Equipo ganador");
        lblEquipoGanadorT2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtEquipoGanadorT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLugarT2.setText("Lugar");
        lblLugarT2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtLugarT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblFechaComT2.setText("Fecha comienzo");
        lblFechaComT2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtFechaComT.setDateFormatString("yyyy-MM-dd");
        b_txtFechaComT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblFechaFinT2.setText("Fecha finalizacion");
        lblFechaFinT2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtFechaFinT.setDateFormatString("yyyy-MM-dd");
        b_txtFechaFinT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblPremioT2.setText("Premio");
        lblPremioT2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtPremioT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b_txtIdTorneo.setEditable(false);
        b_txtIdTorneo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdTorneo1.setText("Id torneo");
        lblIdTorneo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPrimeroT1.setText("<<");
        btnPrimeroT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroT1ActionPerformed(evt);
            }
        });

        btnAnteriorT1.setText("<");
        btnAnteriorT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorT1ActionPerformed(evt);
            }
        });

        btnSiguienteT1.setText(">");
        btnSiguienteT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteT1ActionPerformed(evt);
            }
        });

        btnUltimoT1.setText(">>");
        btnUltimoT1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoT1ActionPerformed(evt);
            }
        });

        btnBorrarDatosTorneos.setText("Borrar datos");
        btnBorrarDatosTorneos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarDatosTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosTorneosActionPerformed(evt);
            }
        });

        b_lblPosicionesT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_lblPosicionesT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pTorneos2Layout = new javax.swing.GroupLayout(pTorneos2);
        pTorneos2.setLayout(pTorneos2Layout);
        pTorneos2Layout.setHorizontalGroup(
            pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneos2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdTorneo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEquipoGanadorT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaComT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaFinT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLugarT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPremioT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b_txtLugarT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_txtEquipoGanadorT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_txtNombreT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_txtPremioT, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtFechaComT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_txtFechaFinT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdTorneo, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(46, 46, 46))
            .addGroup(pTorneos2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarDatosTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pTorneos2Layout.createSequentialGroup()
                        .addComponent(btnPrimeroT1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnteriorT1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteT1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUltimoT1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneos2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_lblPosicionesT, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        pTorneos2Layout.setVerticalGroup(
            pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneos2Layout.createSequentialGroup()
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTorneos2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblIdTorneo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneos2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(b_txtIdTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEquipoGanadorT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtEquipoGanadorT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLugarT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtLugarT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaComT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtFechaComT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaFinT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtFechaFinT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPremioT2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtPremioT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pTorneos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroT1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorT1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteT1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoT1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_lblPosicionesT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnBorrarDatosTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pBorrar2.addTab("Torneos", pTorneos2);

        lblIdTorneoTA2.setText("Id torneo");
        lblIdTorneoTA2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdTorneoTA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdAnuncianteTA2.setText("Id anunciante");
        lblIdAnuncianteTA2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdAnuncianteTA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b_txtIdTorneoAnunciante.setEditable(false);
        b_txtIdTorneoAnunciante.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdTorneoAnunciante1.setText("Id torneo anunciante");
        lblIdTorneoAnunciante1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnPrimeroTA1.setText("<<");
        btnPrimeroTA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroTA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroTA1ActionPerformed(evt);
            }
        });

        btnAnteriorTA1.setText("<");
        btnAnteriorTA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorTA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorTA1ActionPerformed(evt);
            }
        });

        btnSiguienteTA1.setText(">");
        btnSiguienteTA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteTA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteTA1ActionPerformed(evt);
            }
        });

        btnUltimoTA1.setText(">>");
        btnUltimoTA1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoTA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoTA1ActionPerformed(evt);
            }
        });

        btnBorrarDatosTorneosA.setText("Borrar datos");
        btnBorrarDatosTorneosA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarDatosTorneosA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosTorneosAActionPerformed(evt);
            }
        });

        b_lblPosicionesTA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_lblPosicionesTA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pTorneosAnunciantes2Layout = new javax.swing.GroupLayout(pTorneosAnunciantes2);
        pTorneosAnunciantes2.setLayout(pTorneosAnunciantes2Layout);
        pTorneosAnunciantes2Layout.setHorizontalGroup(
            pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosAnunciantes2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIdTorneoAnunciante1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(lblIdTorneoTA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdAnuncianteTA2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(b_txtIdTorneoAnunciante)
                    .addComponent(b_txtIdTorneoTA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_txtIdAnuncianteTA, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(pTorneosAnunciantes2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnPrimeroTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarDatosTorneosA, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pTorneosAnunciantes2Layout.createSequentialGroup()
                        .addComponent(btnAnteriorTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosAnunciantes2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_lblPosicionesTA, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        pTorneosAnunciantes2Layout.setVerticalGroup(
            pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosAnunciantes2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_txtIdTorneoAnunciante, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdTorneoAnunciante1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdTorneoTA2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdTorneoTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdAnuncianteTA2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_txtIdAnuncianteTA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(pTorneosAnunciantes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoTA1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(b_lblPosicionesTA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnBorrarDatosTorneosA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pBorrar2.addTab("Torneos_anunciantes", pTorneosAnunciantes2);

        lblIdTorneoTE3.setText("Id torneo");
        lblIdTorneoTE3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdTorneoTE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdequipoTE2.setText("Id equipo");
        lblIdequipoTE2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdEquipoTE.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblIdTorneoTE4.setText("Id torneo equipo");
        lblIdTorneoTE4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        b_txtIdTorneoEquipo.setEditable(false);
        b_txtIdTorneoEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnPrimeroTE1.setText("<<");
        btnPrimeroTE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrimeroTE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroTE1ActionPerformed(evt);
            }
        });

        btnAnteriorTE1.setText("<");
        btnAnteriorTE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnteriorTE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorTE1ActionPerformed(evt);
            }
        });

        btnSiguienteTE1.setText(">");
        btnSiguienteTE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSiguienteTE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteTE1ActionPerformed(evt);
            }
        });

        btnUltimoTE1.setText(">>");
        btnUltimoTE1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUltimoTE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoTE1ActionPerformed(evt);
            }
        });

        btnBorrarDatosTorneosE.setText("Borrar datos");
        btnBorrarDatosTorneosE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrarDatosTorneosE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDatosTorneosEActionPerformed(evt);
            }
        });

        b_lblPosicionesTE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_lblPosicionesTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pTorneosEquipos2Layout = new javax.swing.GroupLayout(pTorneosEquipos2);
        pTorneosEquipos2.setLayout(pTorneosEquipos2Layout);
        pTorneosEquipos2Layout.setHorizontalGroup(
            pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosEquipos2Layout.createSequentialGroup()
                .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pTorneosEquipos2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdequipoTE2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblIdTorneoTE3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblIdTorneoTE4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(b_txtIdTorneoEquipo)
                            .addComponent(b_txtIdTorneoTE, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_txtIdEquipoTE, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                    .addGroup(pTorneosEquipos2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnPrimeroTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnteriorTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguienteTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimoTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosEquipos2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosEquipos2Layout.createSequentialGroup()
                        .addComponent(btnBorrarDatosTorneosE, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pTorneosEquipos2Layout.createSequentialGroup()
                        .addComponent(b_lblPosicionesTE, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))))
        );
        pTorneosEquipos2Layout.setVerticalGroup(
            pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pTorneosEquipos2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_txtIdTorneoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdTorneoTE4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_txtIdTorneoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdTorneoTE3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_txtIdEquipoTE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdequipoTE2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(pTorneosEquipos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeroTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguienteTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUltimoTE1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(b_lblPosicionesTE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnBorrarDatosTorneosE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pBorrar2.addTab("Torneos_equipos", pTorneosEquipos2);

        javax.swing.GroupLayout pBorrarLayout = new javax.swing.GroupLayout(pBorrar);
        pBorrar.setLayout(pBorrarLayout);
        pBorrarLayout.setHorizontalGroup(
            pBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBorrar2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        pBorrarLayout.setVerticalGroup(
            pBorrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBorrarLayout.createSequentialGroup()
                .addComponent(pBorrar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tpContenedor.addTab("Borrar", pBorrar);

        jLabel1.setText("Equipo1");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel2.setText("Equipo2");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        txtIdEquipo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdEquipo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtIdEquipo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdEquipo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnVerJugadores.setText("Ver jugadores");
        btnVerJugadores.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVerJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerJugadoresActionPerformed(evt);
            }
        });

        btnSeleccionarJugador.setText("Seleccionar jugador");
        btnSeleccionarJugador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSeleccionarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarJugadorActionPerformed(evt);
            }
        });

        btnG.add(rbtnEq1J1);
        rbtnEq1J1.setSelected(true);
        rbtnEq1J1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq1J2);
        rbtnEq1J2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq1J3);
        rbtnEq1J3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq1J5);
        rbtnEq1J5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq1J4);
        rbtnEq1J4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq2J1);
        rbtnEq2J1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq2J2);
        rbtnEq2J2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq2J3);
        rbtnEq2J3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq2J4);
        rbtnEq2J4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnG.add(rbtnEq2J5);
        rbtnEq2J5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout verJugadorLayout = new javax.swing.GroupLayout(verJugador);
        verJugador.setLayout(verJugadorLayout);
        verJugadorLayout.setHorizontalGroup(
            verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verJugadorLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verJugadorLayout.createSequentialGroup()
                        .addComponent(btnVerJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnSeleccionarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(verJugadorLayout.createSequentialGroup()
                        .addGroup(verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbtnEq1J5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnEq1J3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnEq1J1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(verJugadorLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbtnEq1J2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnEq1J4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(120, 120, 120)
                        .addGroup(verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnEq2J5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnEq2J3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnEq2J1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnEq2J2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(verJugadorLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(rbtnEq2J4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(117, 117, 117))))
        );
        verJugadorLayout.setVerticalGroup(
            verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verJugadorLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verJugadorLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtIdEquipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdEquipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verJugadorLayout.createSequentialGroup()
                        .addComponent(rbtnEq1J1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEq1J2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEq1J3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEq1J4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEq1J5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(verJugadorLayout.createSequentialGroup()
                        .addComponent(rbtnEq2J1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEq2J2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEq2J3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEq2J4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEq2J5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(verJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        tpContenedor.addTab("Ver jugador", verJugador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     *  Revisa si todos los JTextFields están llenos
     *  
     *  @param jtf Array de JTextFields
     *  @param indice Numero de fila que quieres ir
     *  @return boolean
     */
    private boolean camposLlenos(JTextField[][] jtf, int indice) {
        for (int i = 0; i < jtf[indice].length; i++) {
            if (jtf[indice][i].getText().equals("")) {
                return false;
            }
        }
        return true;
    }
    
    /**
     *  Vacia todos los JTextFields
     * 
     *  @param jtf Array de JTextFields
     *  @param indice Numero de fila que quieres ir
     */
    private void vaciarCampos(JTextField[][] jtf, int indice) {
        for (int i = 0; i < jtf[indice].length; i++) {
            jtf[indice][i].setText("");
        }
    }
    
    /**
     *  Mete un anunciante en la tabla anunciantes de la base de datos
     * 
     *  @param evt 
     */
    private void btnMeterDatosAnunciantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterDatosAnunciantesActionPerformed
        try {
            String nombreA = i_txtNombreA.getText().trim();
            String logoA = i_txtLogoA.getText().trim();
            int precioA = Integer.parseInt(i_txtPrecioA.getText());

            if (camposLlenos(insertarCampos, 0)) {
                anunciante.insertarDatos(nombreA, logoA, precioA);
                vaciarCampos(insertarCampos, 0);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnMeterDatosAnunciantesActionPerformed

    /**
     *  Mete un equipo en la tabla equipos de la base de datos
     * 
     *  @param evt 
     */
    private void btnMeterDatosEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterDatosEquiposActionPerformed
        try {
            String nombreE = i_txtNombreE.getText().trim();
            String logoE = i_txtLogoE.getText().trim();
            String localizacionE = i_txtLocalizacionE.getText().trim();
            String coachE = i_txtCoachE.getText().trim();
            String fecha = MetodosSueltos.juntarFecha(i_txtFundadoE);

            if (camposLlenos(insertarCampos, 1) && i_txtFundadoE != null) {
                equipo.insertarDatos(nombreE, logoE, localizacionE, coachE, fecha);
                vaciarCampos(insertarCampos, 1);
                i_txtFundadoE.setDate(null);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnMeterDatosEquiposActionPerformed

    /**
     *  Mete un jugador en la tabla jugadores de la base de datos
     * 
     *  @param evt 
     */
    private void btnMeterDatosJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterDatosJugadoresActionPerformed
        try {
            int idEquipoJ = Integer.parseInt(i_txtIdEquipoJ.getText().trim());
            String nombreJ = i_txtNombreJ.getText().trim();
            String akaJ = i_txtAkaJ.getText().trim();
            String nacionalidadJ = i_txtNacionalidadJ.getText().trim();
            String rolJ = i_txtRolJ.getText().trim();
            String fecha = MetodosSueltos.juntarFecha(i_txtFechaNacJ);
            String activoJ = i_txtAnhosActivoJ.getText().trim();
            int salarioJ = Integer.parseInt(i_txtSalarioJ.getText().trim());

            if (camposLlenos(insertarCampos, 3) && i_txtFechaNacJ != null) {
                jugador.insertarDatos(idEquipoJ, nombreJ, akaJ, nacionalidadJ, rolJ, fecha, activoJ, salarioJ);
                vaciarCampos(insertarCampos, 3);
                i_txtFechaNacJ.setDate(null);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnMeterDatosJugadoresActionPerformed

    /**
     *  Vacia todos los JTextField de la pestaña insertar (jugadores) 
     * 
     *  @param evt 
     */
    private void btnBorrarJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarJActionPerformed
        vaciarCampos(insertarCampos, 3);
        i_txtFechaNacJ.setDate(null);
    }//GEN-LAST:event_btnBorrarJActionPerformed

    /**
     *  Vacia todos los JTextField de la pestaña insertar (equipos)
     * 
     *  @param evt 
     */
    private void btnBorrarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarEActionPerformed
        vaciarCampos(insertarCampos, 1);
        i_txtFundadoE.setDate(null);
    }//GEN-LAST:event_btnBorrarEActionPerformed

    /**
     *  Vacia todos los JTextField de la pestaña insertar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnBorrarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAActionPerformed
        vaciarCampos(insertarCampos, 0);
    }//GEN-LAST:event_btnBorrarAActionPerformed

    /**
     *  Mete un torneo en la tabla torneos de la base de datos
     * 
     *  @param evt 
     */
    private void btnMeterDatosTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterDatosTorneosActionPerformed
        try {
            String nombreT = i_txtNombreT.getText().trim();
            String equipoGanadorT = i_txtEquipoGanadorT.getText().trim();
            String lugarT = i_txtLugarT.getText().trim();
            String fechaC = MetodosSueltos.juntarFecha(i_txtFechaComT);
            String fechaF = MetodosSueltos.juntarFecha(i_txtFechaFinT);
            int premioT = Integer.parseInt(i_txtPremioT.getText().trim());

            if (camposLlenos(insertarCampos, 5) && i_txtFechaComT.getDate() != null && i_txtFechaFinT.getDate() != null) {
                torneo.insertarDatos(nombreT, equipoGanadorT, lugarT, fechaC, fechaF, premioT);
                vaciarCampos(insertarCampos, 5);
                i_txtFechaComT.setDate(null);
                i_txtFechaFinT.setDate(null);
            }  
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnMeterDatosTorneosActionPerformed

    /**
     *  Vacia todos los JTextField de la pestaña insertar (torneos)
     * 
     *  @param evt 
     */
    private void btnBorrarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTActionPerformed
        vaciarCampos(insertarCampos, 5);
        i_txtFechaComT.setDate(null);
        i_txtFechaFinT.setDate(null);
    }//GEN-LAST:event_btnBorrarTActionPerformed

    /**
     *  Mete un torneo_anunciante en la tabla torneos_anunciantes de la base de datos
     * 
     *  @param evt 
     */
    private void btnMeterDatosTorneosAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterDatosTorneosAActionPerformed
        try {
            int idTorneoTA = Integer.parseInt(i_txtIdTorneoTA.getText().trim());
            int idAnuncianteTA = Integer.parseInt(i_txtIdAnuncianteTA.getText().trim());
        
            if (camposLlenos(insertarCampos, 6)) {
                torneoAnunciante.insertarDatos(idTorneoTA, idAnuncianteTA);
                vaciarCampos(insertarCampos, 6);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnMeterDatosTorneosAActionPerformed

    /**
     *  Vacia todos los JTextField de la pestaña insertar (torneos_equipos)
     * 
     *  @param evt 
     */
    private void btnBorrarTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTEActionPerformed
        vaciarCampos(insertarCampos, 7);
    }//GEN-LAST:event_btnBorrarTEActionPerformed

    /**
     *  Mete un torneo_equipo en la tabla torneos_equipos de la base de datos
     * 
     *  @param evt 
     */
    private void btnMeterDatosTorneosEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterDatosTorneosEActionPerformed
        try {
            int idTorneoTE = Integer.parseInt(i_txtIdTorneoTE.getText().trim());
            int idEquipoTE = Integer.parseInt(i_txtIdEquipoTE.getText().trim());
        
            if (camposLlenos(insertarCampos, 7)) {
                torneoEquipo.insertarDatos(idTorneoTE, idEquipoTE);
                vaciarCampos(insertarCampos, 7);
            } 
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnMeterDatosTorneosEActionPerformed

    /**
     *  Vacia todos los JTextField de la pestaña insertar (partidas)
     * 
     *  @param evt 
     */
    private void btnBorrarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPActionPerformed
        vaciarCampos(insertarCampos, 4);
        i_txtFechaP.setDate(null);
        i_txtComienzoP.setText(null);
        i_txtFinalP.setText(null);
    }//GEN-LAST:event_btnBorrarPActionPerformed

    /**
     *  Mete una partida en la tabla partidas de la base de datos
     * 
     *  @param evt 
     */
    private void btnMeterDatosPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterDatosPartidasActionPerformed
        try {
            int idEquipoP1 = Integer.parseInt(i_txtIdEquipoP1.getText().trim());
            int idEquipoP2 = Integer.parseInt(i_txtIdEquipoP2.getText().trim());
            int ganadorP = Integer.parseInt(i_txtGanadorP.getText().trim());
            String fecha = MetodosSueltos.juntarFecha(i_txtFechaP);
            String comienzoP = i_txtComienzoP.getText().trim();
            String finalP = i_txtFinalP.getText().trim();
            String resultadoRondasP = i_txtResultadoRondasP.getText().trim();
            String resultadoTotalP = i_txtResultadoTotalP.getText().trim();

            if (camposLlenos(insertarCampos, 4) && i_txtFechaP != null && i_txtComienzoP != null && i_txtFinalP != null) {
                partida.insertarDatos(idEquipoP1, idEquipoP2, ganadorP, fecha, comienzoP, finalP, resultadoRondasP, resultadoTotalP);
                vaciarCampos(insertarCampos, 4);
                i_txtFechaP.setDate(null);
                i_txtComienzoP.setText(null);
                i_txtFinalP.setText(null);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnMeterDatosPartidasActionPerformed

    /**
     *  Vacia todos los JTextField de la pestaña insertar (estadisticas_jugador)
     * 
     *  @param evt 
     */
    private void btnBorrarEJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarEJActionPerformed
        vaciarCampos(insertarCampos, 2);
    }//GEN-LAST:event_btnBorrarEJActionPerformed

    /**
     *  Mete una estadistica de jugador en la tabla estadisticas_jugador de la base de datos 
     * 
     *  @param evt 
     */
    private void btnMeterDatosEstadisticasJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeterDatosEstadisticasJActionPerformed
        try {
            int idPartidaEJ = Integer.parseInt(i_txtIdPartidaEJ.getText().trim());
            int idJugadorEJ = Integer.parseInt(i_txtIdJugadorEJ.getText().trim());
            int KEJ = Integer.parseInt(i_txtKEJ.getText().trim());
            int DEJ = Integer.parseInt(i_txtDEJ.getText().trim());
            int AEJ = Integer.parseInt(i_txtAEJ.getText().trim());
            int AdrEJ = Integer.parseInt(i_txtAdrEJ.getText().trim());

            if (camposLlenos(insertarCampos, 2)) {
                estadisticasJ.insertarDatos(idPartidaEJ, idJugadorEJ, KEJ, DEJ, AEJ, AdrEJ);
                vaciarCampos(insertarCampos, 2);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnMeterDatosEstadisticasJActionPerformed

    /**
     *  Vacia todos los JTextField de la pestaña insertar (torneoAnunciantes)
     * 
     *  @param evt 
     */
    private void btnBorrarTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTAActionPerformed
        vaciarCampos(insertarCampos, 6);
    }//GEN-LAST:event_btnBorrarTAActionPerformed

    /**
     *  Actualiza un anunciante en la tabla anunciantes de la base de datos
     * 
     *  @param evt 
     */
    private void btnActualizarDatosAnunciantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosAnunciantesActionPerformed
        int idAnunciante = Integer.parseInt(a_txtIdAnunciante.getText().trim());
        String nombreAnunciante = a_txtNombreA.getText().trim();
        String logoAnunciante = a_txtLogoA.getText().trim();
        int precioAnunciante = Integer.parseInt(a_txtPrecioA.getText().trim());
        
        anunciante.actualizarDatos(idAnunciante, nombreAnunciante, logoAnunciante, precioAnunciante);
    }//GEN-LAST:event_btnActualizarDatosAnunciantesActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña actualizar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnPrimeroAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroAActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosAnunciantes = anunciante.primerRegistro();
            muestraDatos(actualizarCampos, 0, datosAnunciantes, anunciante.getCamposTabla());
            a_posicionActualA = 1;
            a_lblPosicionesA.setText(String.valueOf(a_posicionActualA + " / " + a_posicionesTotalA));
            confBotones(a_posicionActualA, a_posicionesTotalA, btnPrimeroA, btnAnteriorA, btnSiguienteA, btnUltimoA);
        }
    }//GEN-LAST:event_btnPrimeroAActionPerformed

    /**
     *  Mostrar el registro anterior del ResultSet de la pestaña actualizar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnAnteriorAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorAActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosAnunciantes = anunciante.anteriorRegistro();
            muestraDatos(actualizarCampos, 0, datosAnunciantes, anunciante.getCamposTabla());
            a_posicionActualA--;
            a_lblPosicionesA.setText(String.valueOf(a_posicionActualA + " / " + a_posicionesTotalA));
            confBotones(a_posicionActualA, a_posicionesTotalA, btnPrimeroA, btnAnteriorA, btnSiguienteA, btnUltimoA);
        }
    }//GEN-LAST:event_btnAnteriorAActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña actualizar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnSiguienteAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteAActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosAnunciantes = anunciante.siguienteRegistro();
            muestraDatos(actualizarCampos, 0, datosAnunciantes, anunciante.getCamposTabla());
            a_posicionActualA++;
            a_lblPosicionesA.setText(String.valueOf(a_posicionActualA + " / " + a_posicionesTotalA));
            confBotones(a_posicionActualA, a_posicionesTotalA, btnPrimeroA, btnAnteriorA, btnSiguienteA, btnUltimoA);
        }
    }//GEN-LAST:event_btnSiguienteAActionPerformed

    /**
     *  Mostrar el último registro del ResultSet de la pestaña actualizar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnUltimoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoAActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosAnunciantes = anunciante.ultimoRegistro();
            muestraDatos(actualizarCampos, 0, datosAnunciantes, anunciante.getCamposTabla());
            a_posicionActualA = a_posicionesTotalA;
            a_lblPosicionesA.setText(String.valueOf(a_posicionActualA + " / " + a_posicionesTotalA));
            confBotones(a_posicionActualA, a_posicionesTotalA, btnPrimeroA, btnAnteriorA, btnSiguienteA, btnUltimoA);
        }
    }//GEN-LAST:event_btnUltimoAActionPerformed

    /**
     *  Actualiza un equipo en la tabla equipos de la base de datos
     * 
     *  @param evt 
     */
    private void btnActualizarDatosEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosEquiposActionPerformed
        int idEquipo = Integer.parseInt(a_txtIdEquipo.getText().trim());
        String nombreEquipo = a_txtNombreE.getText().trim();
        String logoEquipo = a_txtLogoE.getText().trim();
        String localizacionEquipo = a_txtLocalizacionE.getText().trim();
        String coachEquipo = a_txtCoachE.getText().trim();
        String fecha = MetodosSueltos.juntarFecha(a_txtFundadoE);

        equipo.actualizarDatos(idEquipo, nombreEquipo, logoEquipo, localizacionEquipo, coachEquipo, fecha);
    }//GEN-LAST:event_btnActualizarDatosEquiposActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña actualizar (equipos)
     * 
     *  @param evt 
     */
    private void btnPrimeroEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroEActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEquipos = equipo.primerRegistro();
            MetodosSueltos.formatearStringToDate(datosEquipos, a_txtFundadoE, "fundado");
            muestraDatos(actualizarCampos, 1, datosEquipos, equipo.getCamposTabla());
            a_posicionActualE = 1;
            a_lblPosicionesE.setText(String.valueOf(a_posicionActualE + " / " + a_posicionesTotalE));
            confBotones(a_posicionActualE, a_posicionesTotalE, btnPrimeroE, btnAnteriorE, btnSiguienteE, btnUltimoE);
        }
    }//GEN-LAST:event_btnPrimeroEActionPerformed

    /**
     *  Mostrar el registro anterior del ResultSet de la pestaña actualizar (equipos)
     * 
     *  @param evt 
     */
    private void btnAnteriorEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorEActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEquipos = equipo.anteriorRegistro();
            MetodosSueltos.formatearStringToDate(datosEquipos, a_txtFundadoE, "fundado");
            muestraDatos(actualizarCampos, 1, datosEquipos, equipo.getCamposTabla());
            a_posicionActualE--;
            a_lblPosicionesE.setText(String.valueOf(a_posicionActualE + " / " + a_posicionesTotalE));
            confBotones(a_posicionActualE, a_posicionesTotalE, btnPrimeroE, btnAnteriorE, btnSiguienteE, btnUltimoE);
        }
    }//GEN-LAST:event_btnAnteriorEActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña actualizar (equipos)
     * 
     *  @param evt 
     */
    private void btnSiguienteEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteEActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEquipos = equipo.siguienteRegistro();
            MetodosSueltos.formatearStringToDate(datosEquipos, a_txtFundadoE, "fundado");
            muestraDatos(actualizarCampos, 1, datosEquipos, equipo.getCamposTabla());
            a_posicionActualE++;
            a_lblPosicionesE.setText(String.valueOf(a_posicionActualE + " / " + a_posicionesTotalE));
            confBotones(a_posicionActualE, a_posicionesTotalE, btnPrimeroE, btnAnteriorE, btnSiguienteE, btnUltimoE);
        }
    }//GEN-LAST:event_btnSiguienteEActionPerformed

    /**
     *  Mostrar el último registro del ResultSet de la pestaña actualizar (equipos)
     * 
     *  @param evt 
     */
    private void btnUltimoEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoEActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEquipos = equipo.ultimoRegistro();
            MetodosSueltos.formatearStringToDate(datosEquipos, a_txtFundadoE, "fundado");
            muestraDatos(actualizarCampos, 1, datosEquipos, equipo.getCamposTabla());
            a_posicionActualE = a_posicionesTotalE;
            a_lblPosicionesE.setText(String.valueOf(a_posicionActualE + " / " + a_posicionesTotalE));
            confBotones(a_posicionActualE, a_posicionesTotalE, btnPrimeroE, btnAnteriorE, btnSiguienteE, btnUltimoE);
        }
    }//GEN-LAST:event_btnUltimoEActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña actualizar (estadisticasJugador)
     * 
     *  @param evt 
     */
    private void btnPrimeroEJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroEJActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEstadisticasJ = estadisticasJ.primerRegistro();
            muestraDatos(actualizarCampos, 2, datosEstadisticasJ, estadisticasJ.getCamposTabla());
            a_posicionActualEJ = 1;
            a_lblPosicionesEJ.setText(String.valueOf(a_posicionActualEJ + " / " + a_posicionesTotalEJ));
            confBotones(a_posicionActualEJ, a_posicionesTotalEJ, btnPrimeroEJ, btnAnteriorEJ, btnSiguienteEJ, btnUltimoEJ);
        }
    }//GEN-LAST:event_btnPrimeroEJActionPerformed

    /**
     *  Mostrar el registro anterior del ResultSet de la pestaña actualizar (estadisticasJugador)
     * 
     *  @param evt 
     */
    private void btnAnteriorEJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorEJActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEstadisticasJ = estadisticasJ.anteriorRegistro();
            muestraDatos(actualizarCampos, 2, datosEstadisticasJ, estadisticasJ.getCamposTabla());
            a_posicionActualEJ--;
            a_lblPosicionesEJ.setText(String.valueOf(a_posicionActualEJ + " / " + a_posicionesTotalEJ));
            confBotones(a_posicionActualEJ, a_posicionesTotalEJ, btnPrimeroEJ, btnAnteriorEJ, btnSiguienteEJ, btnUltimoEJ);
        }
    }//GEN-LAST:event_btnAnteriorEJActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña actualizar (estadisticasJugador)
     * 
     *  @param evt 
     */
    private void btnSiguienteEJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteEJActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEstadisticasJ = estadisticasJ.siguienteRegistro();
            muestraDatos(actualizarCampos, 2, datosEstadisticasJ, estadisticasJ.getCamposTabla());
            a_posicionActualEJ++;
            a_lblPosicionesEJ.setText(String.valueOf(a_posicionActualEJ + " / " + a_posicionesTotalEJ));
            confBotones(a_posicionActualEJ, a_posicionesTotalEJ, btnPrimeroEJ, btnAnteriorEJ, btnSiguienteEJ, btnUltimoEJ);
        }
    }//GEN-LAST:event_btnSiguienteEJActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña actualizar (estadisticasJugador)
     * 
     *  @param evt 
     */
    private void btnUltimoEJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoEJActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEstadisticasJ = estadisticasJ.ultimoRegistro();
            muestraDatos(actualizarCampos, 2, datosEstadisticasJ, estadisticasJ.getCamposTabla());
            a_posicionActualEJ = a_posicionesTotalEJ;
            a_lblPosicionesEJ.setText(String.valueOf(a_posicionActualEJ + " / " + a_posicionesTotalEJ));
            confBotones(a_posicionActualEJ, a_posicionesTotalEJ, btnPrimeroEJ, btnAnteriorEJ, btnSiguienteEJ, btnUltimoEJ);
        }
    }//GEN-LAST:event_btnUltimoEJActionPerformed

    /**
     *  Actualiza una estadistica de jugador en la tabla equipos de la base de datos
     * 
     *  @param evt 
     */
    private void btnActualizarDatosEstadisticasJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosEstadisticasJActionPerformed
        int idEstadistica = Integer.parseInt(a_txtIdEstadistica.getText().trim()); 
        int idPartida = Integer.parseInt(a_txtIdPartidaEJ.getText().trim());
        int idJugador = Integer.parseInt(a_txtIdJugadorEJ.getText().trim());
        int k = Integer.parseInt(a_txtKEJ.getText().trim());
        int d = Integer.parseInt(a_txtDEJ.getText().trim());
        int a = Integer.parseInt(a_txtAEJ.getText().trim());
        int adr = Integer.parseInt(a_txtAdrEJ.getText().trim());
        
        estadisticasJ.actualizarDatos(idEstadistica, idPartida, idJugador, k, d, a, adr);
    }//GEN-LAST:event_btnActualizarDatosEstadisticasJActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña actualizar (jugador)
     * 
     *  @param evt 
     */
    private void btnPrimeroJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroJActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosJugadores = jugador.primerRegistro();
            MetodosSueltos.formatearStringToDate(datosJugadores, a_txtFechaNacJ, "fecha_nacimiento");
            muestraDatos(actualizarCampos, 3, datosJugadores, jugador.getCamposTabla());
            a_posicionActualJ = 1;
            a_lblPosicionesJ.setText(String.valueOf(a_posicionActualJ + " / " + a_posicionesTotalJ));
            confBotones(a_posicionActualJ, a_posicionesTotalJ, btnPrimeroJ, btnAnteriorJ, btnSiguienteJ, btnUltimoJ);
        }
    }//GEN-LAST:event_btnPrimeroJActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña actualizar (jugador)
     * 
     *  @param evt 
     */
    private void btnAnteriorJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorJActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosJugadores = jugador.anteriorRegistro();
            MetodosSueltos.formatearStringToDate(datosJugadores, a_txtFechaNacJ, "fecha_nacimiento");
            muestraDatos(actualizarCampos, 3, datosJugadores, jugador.getCamposTabla());
            a_posicionActualJ--;
            a_lblPosicionesJ.setText(String.valueOf(a_posicionActualJ + " / " + a_posicionesTotalJ));
            confBotones(a_posicionActualJ, a_posicionesTotalJ, btnPrimeroJ, btnAnteriorJ, btnSiguienteJ, btnUltimoJ);
        }
    }//GEN-LAST:event_btnAnteriorJActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña actualizar (jugador)
     * 
     *  @param evt 
     */
    private void btnSiguienteJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteJActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosJugadores = jugador.siguienteRegistro();
            MetodosSueltos.formatearStringToDate(datosJugadores, a_txtFechaNacJ, "fecha_nacimiento");
            muestraDatos(actualizarCampos, 3, datosJugadores, jugador.getCamposTabla());
            a_posicionActualJ++;
            a_lblPosicionesJ.setText(String.valueOf(a_posicionActualJ + " / " + a_posicionesTotalJ));
            confBotones(a_posicionActualJ, a_posicionesTotalJ, btnPrimeroJ, btnAnteriorJ, btnSiguienteJ, btnUltimoJ);
        }
    }//GEN-LAST:event_btnSiguienteJActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña actualizar (jugador)
     * 
     *  @param evt 
     */
    private void btnUltimoJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoJActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosJugadores = jugador.ultimoRegistro();
            MetodosSueltos.formatearStringToDate(datosJugadores, a_txtFechaNacJ, "fecha_nacimiento");
            muestraDatos(actualizarCampos, 3, datosJugadores, jugador.getCamposTabla());
            a_posicionActualJ = a_posicionesTotalJ;
            a_lblPosicionesJ.setText(String.valueOf(a_posicionActualJ + " / " + a_posicionesTotalJ));
            confBotones(a_posicionActualJ, a_posicionesTotalJ, btnPrimeroJ, btnAnteriorJ, btnSiguienteJ, btnUltimoJ);
        }
    }//GEN-LAST:event_btnUltimoJActionPerformed

    /**
     *  Actualiza un jugador de la tabla jugadores de la base de datos
     * 
     *  @param evt 
     */
    private void btnActualizarDatosJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosJugadoresActionPerformed
        int idJugador = Integer.parseInt(a_txtIdJugador.getText().trim());
        int idEquipo = Integer.parseInt(a_txtIdEquipoJ.getText().trim());;
        String nombre = a_txtNombreJ.getText().trim();
        String aka = a_txtAkaJ.getText().trim();
        String nacionalidad = a_txtNacionalidadJ.getText().trim();
        String rol = a_txtRolJ.getText().trim();
        String fecha_nac = MetodosSueltos.juntarFecha(a_txtFechaNacJ);
        String aActivo = a_txtAnhosActivoJ.getText().trim();
        int salario = Integer.parseInt(a_txtSalarioJ.getText().trim());
        
        jugador.actualizarDatos(idJugador, idEquipo, nombre, aka, nacionalidad, rol, fecha_nac, aActivo, salario);
    }//GEN-LAST:event_btnActualizarDatosJugadoresActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña actualizar (partida)
     * 
     *  @param evt 
     */
    private void btnPrimeroPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroPActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosPartidas = partida.primerRegistro();
                MetodosSueltos.formatearStringToDate(datosPartidas, a_txtFechaP, "fecha");
                a_txtComienzoP.setText(datosPartidas.getString("hora_comienzo"));
                a_txtFinalP.setText(datosPartidas.getString("hora_finalizacion"));
                muestraDatos(actualizarCampos, 4, datosPartidas, partida.getCamposTabla());
                a_posicionActualP = 1;
                a_lblPosicionesP.setText(String.valueOf(a_posicionActualP + " / " + a_posicionesTotalP));
                confBotones(a_posicionActualP, a_posicionesTotalP, btnPrimeroP, btnAnteriorP, btnSiguienteP, btnUltimoP);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPrimeroPActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña actualizar (partida)
     * 
     *  @param evt 
     */
    private void btnAnteriorPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorPActionPerformed
        try {
                datosPartidas = partida.anteriorRegistro();
                MetodosSueltos.formatearStringToDate(datosPartidas, a_txtFechaP, "fecha");
                a_txtComienzoP.setText(datosPartidas.getString("hora_comienzo"));
                a_txtFinalP.setText(datosPartidas.getString("hora_finalizacion"));
                muestraDatos(actualizarCampos, 4, datosPartidas, partida.getCamposTabla());
                a_posicionActualP--;
                a_lblPosicionesP.setText(String.valueOf(a_posicionActualP + " / " + a_posicionesTotalP));
                confBotones(a_posicionActualP, a_posicionesTotalP, btnPrimeroP, btnAnteriorP, btnSiguienteP, btnUltimoP);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnAnteriorPActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña actualizar (partida)
     * 
     *  @param evt 
     */
    private void btnSiguientePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguientePActionPerformed
        try {
                datosPartidas = partida.siguienteRegistro();
                MetodosSueltos.formatearStringToDate(datosPartidas, a_txtFechaP, "fecha");
                a_txtComienzoP.setText(datosPartidas.getString("hora_comienzo"));
                a_txtFinalP.setText(datosPartidas.getString("hora_finalizacion"));
                muestraDatos(actualizarCampos, 4, datosPartidas, partida.getCamposTabla());
                a_posicionActualP++;
                a_lblPosicionesP.setText(String.valueOf(a_posicionActualP + " / " + a_posicionesTotalP));
                confBotones(a_posicionActualP, a_posicionesTotalP, btnPrimeroP, btnAnteriorP, btnSiguienteP, btnUltimoP);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnSiguientePActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña actualizar (partida)
     * 
     *  @param evt 
     */
    private void btnUltimoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoPActionPerformed
        try {
                datosPartidas = partida.ultimoRegistro();
                MetodosSueltos.formatearStringToDate(datosPartidas, a_txtFechaP, "fecha");
                a_txtComienzoP.setText(datosPartidas.getString("hora_comienzo"));
                a_txtFinalP.setText(datosPartidas.getString("hora_finalizacion"));
                muestraDatos(actualizarCampos, 4, datosPartidas, partida.getCamposTabla());
                a_posicionActualP = a_posicionesTotalP;
                a_lblPosicionesP.setText(String.valueOf(a_posicionActualP + " / " + a_posicionesTotalP));
                confBotones(a_posicionActualP, a_posicionesTotalP, btnPrimeroP, btnAnteriorP, btnSiguienteP, btnUltimoP);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnUltimoPActionPerformed

    /**
     *  Actualiza una partida de la tabla partidas de la base de datos
     * 
     *  @param evt 
     */
    private void btnActualizarDatosPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosPartidasActionPerformed
        int idPartida = Integer.parseInt(a_txtIdPartidaP.getText().trim());
        int idEquipo1 = Integer.parseInt(a_txtIdEquipoP1.getText().trim());
        int idEquipo2 = Integer.parseInt(a_txtIdEquipoP2.getText().trim());
        String ganador = a_txtGanadorP.getText().trim();
        String fecha = MetodosSueltos.juntarFecha(a_txtFechaP);
        String hComienzo = a_txtComienzoP.getText().trim();
        String hFinal = a_txtFinalP.getText().trim();
        String resRondas = a_txtResultadoRondasP.getText().trim();
        String resFinal = a_txtResultadoTotalP.getText().trim();
        
        partida.actualizarDatos(idPartida, idEquipo1, idEquipo2, ganador, fecha, hComienzo, hFinal, resRondas, resFinal);

    }//GEN-LAST:event_btnActualizarDatosPartidasActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña actualizar (torneo)
     * 
     *  @param evt 
     */
    private void btnPrimeroTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroTActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneos = torneo.primerRegistro();
            MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaComT, "fecha_comienzo");
            MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaFinT, "fecha_finalizacion");
            muestraDatos(actualizarCampos, 5, datosTorneos, torneo.getCamposTabla());
            a_posicionActualT = 1;
            a_lblPosicionesT.setText(String.valueOf(a_posicionActualT + " / " + a_posicionesTotalT));
            confBotones(a_posicionActualT, a_posicionesTotalT, btnPrimeroT, btnAnteriorT, btnSiguienteT, btnUltimoT);
        }
    }//GEN-LAST:event_btnPrimeroTActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña actualizar (torneo)
     * 
     *  @param evt 
     */
    private void btnAnteriorTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorTActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneos = torneo.anteriorRegistro();
            MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaComT, "fecha_comienzo");
            MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaFinT, "fecha_finalizacion");
            muestraDatos(actualizarCampos, 5, datosTorneos, torneo.getCamposTabla());
            a_posicionActualT--;
            a_lblPosicionesT.setText(String.valueOf(a_posicionActualT + " / " + a_posicionesTotalT));
            confBotones(a_posicionActualT, a_posicionesTotalT, btnPrimeroT, btnAnteriorT, btnSiguienteT, btnUltimoT);
        }
    }//GEN-LAST:event_btnAnteriorTActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña actualizar (torneo)
     * 
     *  @param evt 
     */
    private void btnSiguienteTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteTActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneos = torneo.siguienteRegistro();
            MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaComT, "fecha_comienzo");
            MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaFinT, "fecha_finalizacion");
            muestraDatos(actualizarCampos, 5, datosTorneos, torneo.getCamposTabla());
            a_posicionActualT++;
            a_lblPosicionesT.setText(String.valueOf(a_posicionActualT + " / " + a_posicionesTotalT));
            confBotones(a_posicionActualT, a_posicionesTotalT, btnPrimeroT, btnAnteriorT, btnSiguienteT, btnUltimoT);
        }
    }//GEN-LAST:event_btnSiguienteTActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña actualizar (torneo)
     * 
     *  @param evt 
     */
    private void btnUltimoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoTActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneos = torneo.ultimoRegistro();
            MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaComT, "fecha_comienzo");
            MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaFinT, "fecha_finalizacion");
            muestraDatos(actualizarCampos, 5, datosTorneos, torneo.getCamposTabla());
            a_posicionActualT = a_posicionesTotalT;
            a_lblPosicionesT.setText(String.valueOf(a_posicionActualT + " / " + a_posicionesTotalT));
            confBotones(a_posicionActualT, a_posicionesTotalT, btnPrimeroT, btnAnteriorT, btnSiguienteT, btnUltimoT);
        }
    }//GEN-LAST:event_btnUltimoTActionPerformed

    /**
     *  Actualiza un torneo de la tabla torneos de la base de datos
     * 
     *  @param evt 
     */
    private void btnActualizarDatosTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosTorneosActionPerformed
        int idTorneo = Integer.parseInt(a_txtIdTorneo.getText().trim());
        String nombre = a_txtNombreT.getText().trim();
        String eqGnador = a_txtEquipoGanadorT.getText().trim();
        String lugar = a_txtLugarT.getText().trim();
        String fechaC = MetodosSueltos.juntarFecha(a_txtFechaComT);
        String fechaF = MetodosSueltos.juntarFecha(a_txtFechaFinT);
        int premio = Integer.parseInt(a_txtPremioT.getText().trim());
        
        torneo.actualizarDatos(idTorneo, nombre, eqGnador, lugar, fechaC, fechaF, premio);
    }//GEN-LAST:event_btnActualizarDatosTorneosActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña actualizar (torneoAnunciantes)
     * 
     *  @param evt 
     */
    private void btnPrimeroTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroTAActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneosAnunciantes = torneoAnunciante.primerRegistro();
            muestraDatos(actualizarCampos, 6, datosTorneosAnunciantes, torneoAnunciante.getCamposTabla());
            a_posicionActualTA = 1;
            a_lblPosicionesTA.setText(String.valueOf(a_posicionActualTA + " / " + a_posicionesTotalTA));
            confBotones(a_posicionActualTA, a_posicionesTotalTA, btnPrimeroTA, btnAnteriorTA, btnSiguienteTA, btnUltimoTA);
        }
    }//GEN-LAST:event_btnPrimeroTAActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña actualizar (torneoAnunciantes)
     * 
     *  @param evt 
     */
    private void btnAnteriorTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorTAActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneosAnunciantes = torneoAnunciante.anteriorRegistro();
            muestraDatos(actualizarCampos, 6, datosTorneosAnunciantes, torneoAnunciante.getCamposTabla());
            a_posicionActualTA--;
            a_lblPosicionesTA.setText(String.valueOf(a_posicionActualTA + " / " + a_posicionesTotalTA));
            confBotones(a_posicionActualTA, a_posicionesTotalTA, btnPrimeroTA, btnAnteriorTA, btnSiguienteTA, btnUltimoTA);
        }
    }//GEN-LAST:event_btnAnteriorTAActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña actualizar (torneoAnunciantes)
     * 
     *  @param evt 
     */
    private void btnSiguienteTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteTAActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneosAnunciantes = torneoAnunciante.siguienteRegistro();
            muestraDatos(actualizarCampos, 6, datosTorneosAnunciantes, torneoAnunciante.getCamposTabla());
            a_posicionActualTA++;
            a_lblPosicionesTA.setText(String.valueOf(a_posicionActualTA + " / " + a_posicionesTotalTA));
            confBotones(a_posicionActualTA, a_posicionesTotalTA, btnPrimeroTA, btnAnteriorTA, btnSiguienteTA, btnUltimoTA);
        }
    }//GEN-LAST:event_btnSiguienteTAActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña actualizar (torneoAnunciantes)
     * 
     *  @param evt 
     */
    private void btnUltimoTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoTAActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneosAnunciantes = torneoAnunciante.ultimoRegistro();
            muestraDatos(actualizarCampos, 6, datosTorneosAnunciantes, torneoAnunciante.getCamposTabla());
            a_posicionActualTA = a_posicionesTotalTA;
            a_lblPosicionesTA.setText(String.valueOf(a_posicionActualTA + " / " + a_posicionesTotalTA));
            confBotones(a_posicionActualTA, a_posicionesTotalTA, btnPrimeroTA, btnAnteriorTA, btnSiguienteTA, btnUltimoTA);
        }
    }//GEN-LAST:event_btnUltimoTAActionPerformed

    /**
     *  Actualiza un torneoAnunciante de la tabla torneos_anunciantes de la base de datos
     * 
     *  @param evt 
     */
    private void btnActualizarDatosTorneosAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosTorneosAActionPerformed
        int idTorneoA = Integer.parseInt(a_txtIdTorneoAnunciante.getText().trim());
        int idTorneo = Integer.parseInt(a_txtIdTorneoTA.getText().trim());
        int idAnunciante = Integer.parseInt(a_txtIdAnuncianteTA.getText().trim());
        
        torneoAnunciante.actualizarDatos(idTorneoA, idTorneo, idAnunciante);
    }//GEN-LAST:event_btnActualizarDatosTorneosAActionPerformed

    /**
     *  Mostrar el primero registro del ResultSet de la pestaña actualizar (torneoEquipos)
     * 
     *  @param evt 
     */
    private void btnPrimeroTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroTEActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneosEquipos = torneoEquipo.primerRegistro();
            muestraDatos(actualizarCampos, 7, datosTorneosEquipos, torneoEquipo.getCamposTabla());
            a_posicionActualTE = 1;
            a_lblPosicionesTE.setText(String.valueOf(a_posicionActualTE + " / " + a_posicionesTotalTE));
            confBotones(a_posicionActualTE, a_posicionesTotalTE, btnPrimeroTE, btnAnteriorTE, btnSiguienteTE, btnUltimoTE);
        }
    }//GEN-LAST:event_btnPrimeroTEActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña actualizar (torneoEquipos)
     * 
     *  @param evt 
     */
    private void btnAnteriorTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorTEActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneosEquipos = torneoEquipo.anteriorRegistro();
            muestraDatos(actualizarCampos, 7, datosTorneosEquipos, torneoEquipo.getCamposTabla());
            a_posicionActualTE--;
            a_lblPosicionesTE.setText(String.valueOf(a_posicionActualTE + " / " + a_posicionesTotalTE));
            confBotones(a_posicionActualTE, a_posicionesTotalTE, btnPrimeroTE, btnAnteriorTE, btnSiguienteTE, btnUltimoTE);
        }
    }//GEN-LAST:event_btnAnteriorTEActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña actualizar (torneoEquipos)
     * 
     *  @param evt 
     */
    private void btnSiguienteTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteTEActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneosEquipos = torneoEquipo.siguienteRegistro();
            muestraDatos(actualizarCampos, 7, datosTorneosEquipos, torneoEquipo.getCamposTabla());
            a_posicionActualTE++;
            a_lblPosicionesTE.setText(String.valueOf(a_posicionActualTE + " / " + a_posicionesTotalTE));
            confBotones(a_posicionActualTE, a_posicionesTotalTE, btnPrimeroTE, btnAnteriorTE, btnSiguienteTE, btnUltimoTE);
        }
    }//GEN-LAST:event_btnSiguienteTEActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña actualizar (torneoEquipos)
     * 
     *  @param evt 
     */
    private void btnUltimoTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoTEActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosTorneosEquipos = torneoEquipo.ultimoRegistro();
            muestraDatos(actualizarCampos, 7, datosTorneosEquipos, torneoEquipo.getCamposTabla());
            a_posicionActualTE = a_posicionesTotalTE;
            a_lblPosicionesTE.setText(String.valueOf(a_posicionActualTE + " / " + a_posicionesTotalTE));
            confBotones(a_posicionActualTE, a_posicionesTotalTE, btnPrimeroTE, btnAnteriorTE, btnSiguienteTE, btnUltimoTE);
        }
    }//GEN-LAST:event_btnUltimoTEActionPerformed

    /**
     *  Actualiza un torneoEquipo de la tabla torneos_equipos de la base de datos
     * 
     *  @param evt 
     */
    private void btnActualizarDatosTorneosEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosTorneosEActionPerformed
        int idTorneoE = Integer.parseInt(a_txtIdTorneoEquipo.getText().trim());
        int idTorneo = Integer.parseInt(a_txtIdTorneoTE.getText().trim());
        int idEquipo = Integer.parseInt(a_txtIdEquipoTE.getText().trim());
        
        torneoEquipo.actualizarDatos(idTorneoE, idTorneo, idEquipo);
    }//GEN-LAST:event_btnActualizarDatosTorneosEActionPerformed

    /**
     *  Borra un anunciante de la tabla anunciantes de la base de datos
     * 
     *  @param evt 
     */
    private void btnBorrarDatosAnunciantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosAnunciantesActionPerformed
        int idAnunciante = Integer.parseInt(b_txtIdAnunciante.getText().trim());
        
        anunciante.borrarDatos(idAnunciante);
    }//GEN-LAST:event_btnBorrarDatosAnunciantesActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña borrar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnPrimeroA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroA1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosAnunciantes2 = anunciante.primerRegistro2();
            muestraDatos(borrarCampos, 0, datosAnunciantes2, anunciante.getCamposTabla());
            b_posicionActualA = 1;
            b_lblPosicionesA.setText(String.valueOf(b_posicionActualA + " / " + b_posicionesTotalA));
            confBotones(b_posicionActualA, b_posicionesTotalA, btnPrimeroA1, btnAnteriorA1, btnSiguienteA1, btnUltimoA1);
        }
    }//GEN-LAST:event_btnPrimeroA1ActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña borrar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnAnteriorA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorA1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosAnunciantes2 = anunciante.anteriorRegistro2();
            muestraDatos(borrarCampos, 0, datosAnunciantes2, anunciante.getCamposTabla());
            b_posicionActualA--;
            b_lblPosicionesA.setText(String.valueOf(b_posicionActualA + " / " + b_posicionesTotalA));
            confBotones(b_posicionActualA, b_posicionesTotalA, btnPrimeroA1, btnAnteriorA1, btnSiguienteA1, btnUltimoA1);
        }
    }//GEN-LAST:event_btnAnteriorA1ActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña borrar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnSiguienteA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteA1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosAnunciantes2 = anunciante.siguienteRegistro2();
            muestraDatos(borrarCampos, 0, datosAnunciantes2, anunciante.getCamposTabla());
            b_posicionActualA++;
            b_lblPosicionesA.setText(String.valueOf(b_posicionActualA + " / " + b_posicionesTotalA));
            confBotones(b_posicionActualA, b_posicionesTotalA, btnPrimeroA1, btnAnteriorA1, btnSiguienteA1, btnUltimoA1);
        }
    }//GEN-LAST:event_btnSiguienteA1ActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña borrar (anunciantes)
     * 
     *  @param evt 
     */
    private void btnUltimoA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoA1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosAnunciantes2 = anunciante.ultimoRegistro2();
            muestraDatos(borrarCampos, 0, datosAnunciantes2, anunciante.getCamposTabla());
            b_posicionActualA = b_posicionesTotalA;
            b_lblPosicionesA.setText(String.valueOf(b_posicionActualA + " / " + b_posicionesTotalA));
            confBotones(b_posicionActualA, b_posicionesTotalA, btnPrimeroA1, btnAnteriorA1, btnSiguienteA1, btnUltimoA1);
        }
    }//GEN-LAST:event_btnUltimoA1ActionPerformed

     /**
     *  Borra un equipo de la tabla equipos de la base de datos
     * 
     *  @param evt 
     */   
    private void btnBorrarDatosEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosEquiposActionPerformed
        int idEquipo = Integer.parseInt(b_txtIdEquipo.getText().trim());
        
        equipo.borrarDatos(idEquipo);
    }//GEN-LAST:event_btnBorrarDatosEquiposActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña borrar (equipos)
     * 
     *  @param evt 
     */ 
    private void btnPrimeroE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroE1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEquipos2 = equipo.primerRegistro2();
            MetodosSueltos.formatearStringToDate(datosEquipos2, b_txtFundadoE, "fundado");
            muestraDatos(borrarCampos, 1, datosEquipos2, equipo.getCamposTabla());
            b_posicionActualE = 1;
            b_lblPosicionesE.setText(String.valueOf(b_posicionActualE + " / " + b_posicionesTotalE));
            confBotones(b_posicionActualE, b_posicionesTotalE, btnPrimeroE1, btnAnteriorE1, btnSiguienteE1, btnUltimoE1);
        }
    }//GEN-LAST:event_btnPrimeroE1ActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña borrar (equipos)
     * 
     *  @param evt 
     */ 
    private void btnAnteriorE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorE1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEquipos2 = equipo.anteriorRegistro2();
            MetodosSueltos.formatearStringToDate(datosEquipos2, b_txtFundadoE, "fundado");
            muestraDatos(borrarCampos, 1, datosEquipos2, equipo.getCamposTabla());
            b_posicionActualE--;
            b_lblPosicionesE.setText(String.valueOf(b_posicionActualE + " / " + b_posicionesTotalE));
            confBotones(b_posicionActualE, b_posicionesTotalE, btnPrimeroE1, btnAnteriorE1, btnSiguienteE1, btnUltimoE1);
        }
    }//GEN-LAST:event_btnAnteriorE1ActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña borrar (equipos)
     * 
     *  @param evt 
     */ 
    private void btnSiguienteE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteE1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEquipos2 = equipo.siguienteRegistro2();
            MetodosSueltos.formatearStringToDate(datosEquipos2, b_txtFundadoE, "fundado");
            muestraDatos(borrarCampos, 1, datosEquipos2, equipo.getCamposTabla());
            b_posicionActualE++;
            b_lblPosicionesE.setText(String.valueOf(b_posicionActualE + " / " + b_posicionesTotalE));
            confBotones(b_posicionActualE, b_posicionesTotalE, btnPrimeroE1, btnAnteriorE1, btnSiguienteE1, btnUltimoE1);
        }
    }//GEN-LAST:event_btnSiguienteE1ActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña borrar (equipos)
     * 
     *  @param evt 
     */ 
    private void btnUltimoE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoE1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEquipos2 = equipo.ultimoRegistro2();
            MetodosSueltos.formatearStringToDate(datosEquipos2, b_txtFundadoE, "fundado");
            muestraDatos(borrarCampos, 1, datosEquipos2, equipo.getCamposTabla());
            b_posicionActualE = b_posicionesTotalE;
            b_lblPosicionesE.setText(String.valueOf(b_posicionActualE + " / " + b_posicionesTotalE));
            confBotones(b_posicionActualE, b_posicionesTotalE, btnPrimeroE1, btnAnteriorE1, btnSiguienteE1, btnUltimoE1);
        }
    }//GEN-LAST:event_btnUltimoE1ActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña borrar (estadisticasJugador)
     * 
     *  @param evt 
     */ 
    private void btnPrimeroEJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroEJ1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEstadisticasJ2 = estadisticasJ.primerRegistro2();
            muestraDatos(borrarCampos, 2, datosEstadisticasJ2, estadisticasJ.getCamposTabla());
            b_posicionActualEJ = 1;
            b_lblPosicionesEJ.setText(String.valueOf(b_posicionActualEJ + " / " + b_posicionesTotalEJ));
            confBotones(b_posicionActualEJ, b_posicionesTotalEJ, btnPrimeroEJ1, btnAnteriorEJ1, btnSiguienteEJ1, btnUltimoEJ1);
        }
    }//GEN-LAST:event_btnPrimeroEJ1ActionPerformed
    
    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña borrar (estadisticasJugador)
     * 
     *  @param evt 
     */ 
    private void btnAnteriorEJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorEJ1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEstadisticasJ2 = estadisticasJ.anteriorRegistro2();
            muestraDatos(borrarCampos, 2, datosEstadisticasJ2, estadisticasJ.getCamposTabla());
            b_posicionActualEJ--;
            b_lblPosicionesEJ.setText(String.valueOf(b_posicionActualEJ + " / " + b_posicionesTotalEJ));
            confBotones(b_posicionActualEJ, b_posicionesTotalEJ, btnPrimeroEJ1, btnAnteriorEJ1, btnSiguienteEJ1, btnUltimoEJ1);
        }
    }//GEN-LAST:event_btnAnteriorEJ1ActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña borrar (estadisticasJugador)
     * 
     *  @param evt 
     */ 
    private void btnSiguienteEJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteEJ1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEstadisticasJ2 = estadisticasJ.siguienteRegistro2();
            muestraDatos(borrarCampos, 2, datosEstadisticasJ2, estadisticasJ.getCamposTabla());
            b_posicionActualEJ++;
            b_lblPosicionesEJ.setText(String.valueOf(b_posicionActualEJ + " / " + b_posicionesTotalEJ));
            confBotones(b_posicionActualEJ, b_posicionesTotalEJ, btnPrimeroEJ1, btnAnteriorEJ1, btnSiguienteEJ1, btnUltimoEJ1);
        }
    }//GEN-LAST:event_btnSiguienteEJ1ActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña borrar (estadisticasJugador)
     * 
     *  @param evt 
     */ 
    private void btnUltimoEJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoEJ1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosEstadisticasJ2 = estadisticasJ.ultimoRegistro2();
            muestraDatos(borrarCampos, 2, datosEstadisticasJ2, estadisticasJ.getCamposTabla());
            b_posicionActualEJ = b_posicionesTotalEJ;
            b_lblPosicionesEJ.setText(String.valueOf(b_posicionActualEJ + " / " + b_posicionesTotalEJ));
            confBotones(b_posicionActualEJ, b_posicionesTotalEJ, btnPrimeroEJ1, btnAnteriorEJ1, btnSiguienteEJ1, btnUltimoEJ1);
        }
    }//GEN-LAST:event_btnUltimoEJ1ActionPerformed

    /**
     *  Borra una estadistica de jugador de la tabla estadisticas_jugador de la base de datos
     * 
     *  @param evt 
     */ 
    private void btnBorrarDatosEstadisticasJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosEstadisticasJActionPerformed
        int idEstadistica = Integer.parseInt(b_txtIdEstadistica.getText().trim());
        
        estadisticasJ.borrarDatos(idEstadistica);
    }//GEN-LAST:event_btnBorrarDatosEstadisticasJActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña borrar (jugador)
     * 
     *  @param evt 
     */ 
    private void btnPrimeroJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroJ1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosJugadores2 = jugador.primerRegistro2();
            MetodosSueltos.formatearStringToDate(datosJugadores2, b_txtFechaNacJ, "fecha_nacimiento");
            muestraDatos(borrarCampos, 3, datosJugadores2, jugador.getCamposTabla());
            b_posicionActualJ = 1;
            b_lblPosicionesJ.setText(String.valueOf(b_posicionActualJ + " / " + b_posicionesTotalJ));
            confBotones(b_posicionActualJ, b_posicionesTotalJ, btnPrimeroJ1, btnAnteriorJ1, btnSiguienteJ1, btnUltimoJ1);
        }
    }//GEN-LAST:event_btnPrimeroJ1ActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña borrar (jugador)
     * 
     *  @param evt 
     */ 
    private void btnAnteriorJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorJ1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosJugadores2 = jugador.anteriorRegistro2();
            MetodosSueltos.formatearStringToDate(datosJugadores2, b_txtFechaNacJ, "fecha_nacimiento");
            muestraDatos(borrarCampos, 3, datosJugadores2, jugador.getCamposTabla());
            b_posicionActualJ--;
            b_lblPosicionesJ.setText(String.valueOf(b_posicionActualJ + " / " + b_posicionesTotalJ));
            confBotones(b_posicionActualJ, b_posicionesTotalJ, btnPrimeroJ1, btnAnteriorJ1, btnSiguienteJ1, btnUltimoJ1);
        }
    }//GEN-LAST:event_btnAnteriorJ1ActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña borrar (jugador)
     * 
     *  @param evt 
     */ 
    private void btnSiguienteJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteJ1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosJugadores2 = jugador.siguienteRegistro2();
            MetodosSueltos.formatearStringToDate(datosJugadores2, b_txtFechaNacJ, "fecha_nacimiento");
            muestraDatos(borrarCampos, 3, datosJugadores2, jugador.getCamposTabla());
            b_posicionActualJ++;
            b_lblPosicionesJ.setText(String.valueOf(b_posicionActualJ + " / " + b_posicionesTotalJ));
            confBotones(b_posicionActualJ, b_posicionesTotalJ, btnPrimeroJ1, btnAnteriorJ1, btnSiguienteJ1, btnUltimoJ1);
        }
    }//GEN-LAST:event_btnSiguienteJ1ActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña borrar (jugador)
     * 
     *  @param evt 
     */ 
    private void btnUltimoJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoJ1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            datosJugadores2 = jugador.ultimoRegistro2();
            MetodosSueltos.formatearStringToDate(datosJugadores2, b_txtFechaNacJ, "fecha_nacimiento");
            muestraDatos(borrarCampos, 3, datosJugadores2, jugador.getCamposTabla());
            b_posicionActualJ = b_posicionesTotalJ;
            b_lblPosicionesJ.setText(String.valueOf(b_posicionActualJ + " / " + b_posicionesTotalJ));
            confBotones(b_posicionActualJ, b_posicionesTotalJ, btnPrimeroJ1, btnAnteriorJ1, btnSiguienteJ1, btnUltimoJ1);
        }
    }//GEN-LAST:event_btnUltimoJ1ActionPerformed

    /**
     *  Borra un jugador de la tabla jugadores de la base de datos
     * 
     *  @param evt 
     */ 
    private void btnBorrarDatosJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosJugadoresActionPerformed
        int idJugador = Integer.parseInt(b_txtIdJugador.getText().trim());
        
        jugador.borrarDatos(idJugador);
    }//GEN-LAST:event_btnBorrarDatosJugadoresActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña borrar (partida)
     * 
     *  @param evt 
     */
    private void btnPrimeroP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroP1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosPartidas2 = partida.primerRegistro2();
                MetodosSueltos.formatearStringToDate(datosPartidas2, b_txtFechaP, "fecha");
                b_txtComienzoP.setText(datosPartidas2.getString("hora_comienzo"));
                b_txtFinalP.setText(datosPartidas2.getString("hora_finalizacion"));
                muestraDatos(borrarCampos, 4, datosPartidas2, partida.getCamposTabla());
                b_posicionActualP = 1;
                b_lblPosicionesP.setText(String.valueOf(b_posicionActualP + " / " + b_posicionesTotalP));
                confBotones(b_posicionActualP, b_posicionesTotalP, btnPrimeroP1, btnAnteriorP1, btnSiguienteP1, btnUltimoP1);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPrimeroP1ActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña borrar (partida)
     * 
     *  @param evt 
     */
    private void btnAnteriorP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorP1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosPartidas2 = partida.anteriorRegistro2();
                MetodosSueltos.formatearStringToDate(datosPartidas2, b_txtFechaP, "fecha");
                b_txtComienzoP.setText(datosPartidas2.getString("hora_comienzo"));
                b_txtFinalP.setText(datosPartidas2.getString("hora_finalizacion"));
                muestraDatos(borrarCampos, 4, datosPartidas2, partida.getCamposTabla());
                b_posicionActualP--;
                b_lblPosicionesP.setText(String.valueOf(b_posicionActualP + " / " + b_posicionesTotalP));
                confBotones(b_posicionActualP, b_posicionesTotalP, btnPrimeroP1, btnAnteriorP1, btnSiguienteP1, btnUltimoP1);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAnteriorP1ActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña borrar (partida)
     * 
     *  @param evt 
     */
    private void btnSiguienteP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteP1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosPartidas2 = partida.siguienteRegistro2();
                MetodosSueltos.formatearStringToDate(datosPartidas2, b_txtFechaP, "fecha");
                b_txtComienzoP.setText(datosPartidas2.getString("hora_comienzo"));
                b_txtFinalP.setText(datosPartidas2.getString("hora_finalizacion"));
                muestraDatos(borrarCampos, 4, datosPartidas2, partida.getCamposTabla());
                b_posicionActualP++;
                b_lblPosicionesP.setText(String.valueOf(b_posicionActualP + " / " + b_posicionesTotalP));
                confBotones(b_posicionActualP, b_posicionesTotalP, btnPrimeroP1, btnAnteriorP1, btnSiguienteP1, btnUltimoP1);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSiguienteP1ActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña borrar (partida)
     * 
     *  @param evt 
     */
    private void btnUltimoP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoP1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosPartidas2 = partida.ultimoRegistro2();
                MetodosSueltos.formatearStringToDate(datosPartidas2, b_txtFechaP, "fecha");
                b_txtComienzoP.setText(datosPartidas2.getString("hora_comienzo"));
                b_txtFinalP.setText(datosPartidas2.getString("hora_finalizacion"));
                muestraDatos(borrarCampos, 4, datosPartidas2, partida.getCamposTabla());
                b_posicionActualP = b_posicionesTotalP;
                b_lblPosicionesP.setText(String.valueOf(b_posicionActualP + " / " + b_posicionesTotalP));
                confBotones(b_posicionActualP, b_posicionesTotalP, btnPrimeroP1, btnAnteriorP1, btnSiguienteP1, btnUltimoP1);
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUltimoP1ActionPerformed

    /**
     *  Borra una partida de la tabla partidas de la base de datos
     * 
     *  @param evt 
     */ 
    private void btnBorrarDatosPartidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosPartidasActionPerformed
        int idPartida = Integer.parseInt(b_txtIdPartidaP.getText().trim());
        
        partida.borrarDatos(idPartida);
    }//GEN-LAST:event_btnBorrarDatosPartidasActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña borrar (torneos)
     * 
     *  @param evt 
     */
    private void btnPrimeroT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroT1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneos2 = torneo.primerRegistro2();
                MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaComT, "fecha_comienzo");
                MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaFinT, "fecha_finalizacion");
                muestraDatos(borrarCampos, 5, datosTorneos2, torneo.getCamposTabla());
                b_posicionActualT = 1;
                b_lblPosicionesT.setText(String.valueOf(b_posicionActualT + " / " + b_posicionesTotalT));
                confBotones(b_posicionActualT, b_posicionesTotalT, btnPrimeroT1, btnAnteriorT1, btnSiguienteT1, btnUltimoT1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPrimeroT1ActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña borrar (torneos)
     * 
     *  @param evt 
     */
    private void btnAnteriorT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorT1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneos2 = torneo.anteriorRegistro2();
                MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaComT, "fecha_comienzo");
                MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaFinT, "fecha_finalizacion");
                muestraDatos(borrarCampos, 5, datosTorneos2, torneo.getCamposTabla());
                b_posicionActualT--;
                b_lblPosicionesT.setText(String.valueOf(b_posicionActualT + " / " + b_posicionesTotalT));
                confBotones(b_posicionActualT, b_posicionesTotalT, btnPrimeroT1, btnAnteriorT1, btnSiguienteT1, btnUltimoT1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAnteriorT1ActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña borrar (torneos)
     * 
     *  @param evt 
     */
    private void btnSiguienteT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteT1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneos2 = torneo.siguienteRegistro2();
                MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaComT, "fecha_comienzo");
                MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaFinT, "fecha_finalizacion");
                muestraDatos(borrarCampos, 5, datosTorneos2, torneo.getCamposTabla());
                b_posicionActualT++;
                b_lblPosicionesT.setText(String.valueOf(b_posicionActualT + " / " + b_posicionesTotalT));
                confBotones(b_posicionActualT, b_posicionesTotalT, btnPrimeroT1, btnAnteriorT1, btnSiguienteT1, btnUltimoT1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSiguienteT1ActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña borrar (torneos)
     * 
     *  @param evt 
     */
    private void btnUltimoT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoT1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneos2 = torneo.ultimoRegistro2();
                MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaComT, "fecha_comienzo");
                MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaFinT, "fecha_finalizacion");
                muestraDatos(borrarCampos, 5, datosTorneos2, torneo.getCamposTabla());
                b_posicionActualT = b_posicionesTotalT;
                b_lblPosicionesT.setText(String.valueOf(b_posicionActualT + " / " + b_posicionesTotalT));
                confBotones(b_posicionActualT, b_posicionesTotalT, btnPrimeroT1, btnAnteriorT1, btnSiguienteT1, btnUltimoT1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUltimoT1ActionPerformed

    /**
     *  Borra un torneo de la tabla torneos de la base de datos
     * 
     *  @param evt 
     */ 
    private void btnBorrarDatosTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosTorneosActionPerformed
        int idTorneo = Integer.parseInt(b_txtIdTorneo.getText());
        
        torneo.borrarDatos(idTorneo);
    }//GEN-LAST:event_btnBorrarDatosTorneosActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña borrar (torneos_anunciantes)
     * 
     *  @param evt 
     */
    private void btnPrimeroTA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroTA1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneosAnunciantes2 = torneoAnunciante.primerRegistro2();
                muestraDatos(borrarCampos, 6, datosTorneosAnunciantes2, torneoAnunciante.getCamposTabla());
                b_posicionActualTA = 1;
                b_lblPosicionesTA.setText(String.valueOf(b_posicionActualTA + " / " + b_posicionesTotalTA));
                confBotones(b_posicionActualTA, b_posicionesTotalTA, btnPrimeroTA1, btnAnteriorTA1, btnSiguienteTA1, btnUltimoTA1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPrimeroTA1ActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña borrar (torneos_anunciantes)
     * 
     *  @param evt 
     */
    private void btnAnteriorTA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorTA1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneosAnunciantes2 = torneoAnunciante.anteriorRegistro2();
                muestraDatos(borrarCampos, 6, datosTorneosAnunciantes2, torneoAnunciante.getCamposTabla());
                b_posicionActualTA--;
                b_lblPosicionesTA.setText(String.valueOf(b_posicionActualTA + " / " + b_posicionesTotalTA));
                confBotones(b_posicionActualTA, b_posicionesTotalTA, btnPrimeroTA1, btnAnteriorTA1, btnSiguienteTA1, btnUltimoTA1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAnteriorTA1ActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña borrar (torneos_anunciantes)
     * 
     *  @param evt 
     */
    private void btnSiguienteTA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteTA1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneosAnunciantes2 = torneoAnunciante.siguienteRegistro2();
                muestraDatos(borrarCampos, 6, datosTorneosAnunciantes2, torneoAnunciante.getCamposTabla());
                b_posicionActualTA++;
                b_lblPosicionesTA.setText(String.valueOf(b_posicionActualTA + " / " + b_posicionesTotalTA));
                confBotones(b_posicionActualTA, b_posicionesTotalTA, btnPrimeroTA1, btnAnteriorTA1, btnSiguienteTA1, btnUltimoTA1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSiguienteTA1ActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña borrar (torneos_anunciantes)
     * 
     *  @param evt 
     */
    private void btnUltimoTA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoTA1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneosAnunciantes2 = torneoAnunciante.ultimoRegistro2();
                muestraDatos(borrarCampos, 6, datosTorneosAnunciantes2, torneoAnunciante.getCamposTabla());
                b_posicionActualTA = b_posicionesTotalTA;
                b_lblPosicionesTA.setText(String.valueOf(b_posicionActualTA + " / " + b_posicionesTotalTA));
                confBotones(b_posicionActualTA, b_posicionesTotalTA, btnPrimeroTA1, btnAnteriorTA1, btnSiguienteTA1, btnUltimoTA1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUltimoTA1ActionPerformed

    /**
     *  Borra un torneo_anunciante de la tabla torneos_anunciantes de la base de datos
     * 
     *  @param evt 
     */ 
    private void btnBorrarDatosTorneosAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosTorneosAActionPerformed
        int idTorneo = Integer.parseInt(b_txtIdTorneoAnunciante.getText());
        
        torneoAnunciante.borrarDatos(idTorneo);
    }//GEN-LAST:event_btnBorrarDatosTorneosAActionPerformed

    /**
     *  Mostrar el primer registro del ResultSet de la pestaña borrar (torneos_equipos)
     * 
     *  @param evt 
     */
    private void btnPrimeroTE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroTE1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneosEquipos2 = torneoEquipo.primerRegistro2();
                muestraDatos(borrarCampos, 7, datosTorneosEquipos2, torneoEquipo.getCamposTabla());
                b_posicionActualTE = 1;
                b_lblPosicionesTE.setText(String.valueOf(b_posicionActualTE + " / " + b_posicionesTotalTE));
                confBotones(b_posicionActualTE, b_posicionesTotalTE, btnPrimeroTE1, btnAnteriorTE1, btnSiguienteTE1, btnUltimoTE1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPrimeroTE1ActionPerformed

    /**
     *  Mostrar el anterior registro del ResultSet de la pestaña borrar (torneos_equipos)
     * 
     *  @param evt 
     */
    private void btnAnteriorTE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorTE1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneosEquipos2 = torneoEquipo.anteriorRegistro2();
                muestraDatos(borrarCampos, 7, datosTorneosEquipos2, torneoEquipo.getCamposTabla());
                b_posicionActualTE--;
                b_lblPosicionesTE.setText(String.valueOf(b_posicionActualTE + " / " + b_posicionesTotalTE));
                confBotones(b_posicionActualTE, b_posicionesTotalTA, btnPrimeroTE1, btnAnteriorTE1, btnSiguienteTE1, btnUltimoTE1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAnteriorTE1ActionPerformed

    /**
     *  Mostrar el siguiente registro del ResultSet de la pestaña borrar (torneos_equipos)
     * 
     *  @param evt 
     */
    private void btnSiguienteTE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteTE1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneosEquipos2 = torneoEquipo.siguienteRegistro2();
                muestraDatos(borrarCampos, 7, datosTorneosEquipos2, torneoEquipo.getCamposTabla());
                b_posicionActualTE++;
                b_lblPosicionesTE.setText(String.valueOf(b_posicionActualTE + " / " + b_posicionesTotalTE));
                confBotones(b_posicionActualTE, b_posicionesTotalTE, btnPrimeroTE1, btnAnteriorTE1, btnSiguienteTE1, btnUltimoTE1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSiguienteTE1ActionPerformed

    /**
     *  Mostrar el ultimo registro del ResultSet de la pestaña borrar (torneos_equipos)
     * 
     *  @param evt 
     */
    private void btnUltimoTE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoTE1ActionPerformed
        if (((javax.swing.JButton) evt.getSource()).isEnabled()) {
            try {
                datosTorneosEquipos2 = torneoEquipo.ultimoRegistro2();
                muestraDatos(borrarCampos, 7, datosTorneosEquipos2, torneoEquipo.getCamposTabla());
                b_posicionActualTE = b_posicionesTotalTE;
                b_lblPosicionesTE.setText(String.valueOf(b_posicionActualTE + " / " + b_posicionesTotalTE));
                confBotones(b_posicionActualTE, b_posicionesTotalTE, btnPrimeroTE1, btnAnteriorTE1, btnSiguienteTE1, btnUltimoTE1);
            } catch (Exception ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUltimoTE1ActionPerformed

    /**
     *  Borra un torneo_equipo de la tabla torneos_equipos de la base de datos
     * 
     *  @param evt 
     */ 
    private void btnBorrarDatosTorneosEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDatosTorneosEActionPerformed
        int idTorneo = Integer.parseInt(b_txtIdTorneoEquipo.getText());
        
        torneoEquipo.borrarDatos(idTorneo);
    }//GEN-LAST:event_btnBorrarDatosTorneosEActionPerformed

    /**
     *  Muestra los jugadores que hay en cada equipo
     *  
     *  @param evt 
     */
    private void btnVerJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerJugadoresActionPerformed
        VerJugador vj = new VerJugador();
        ResultSet rsEquipo1;
        ResultSet rsEquipo2;
        JRadioButton[] equipo1 = {rbtnEq1J1, rbtnEq1J2, rbtnEq1J3, rbtnEq1J4, rbtnEq1J5};
        JRadioButton[] equipo2 = {rbtnEq2J1, rbtnEq2J2, rbtnEq2J3, rbtnEq2J4, rbtnEq2J5};
        
        try {
            vj.cargaDatos(Integer.parseInt(txtIdEquipo1.getText().trim()));
            rsEquipo1 = vj.getRs();
        
            vj.cargaDatos(Integer.parseInt(txtIdEquipo2.getText().trim()));
            rsEquipo2 = vj.getRs();
            
            verJugadores(rsEquipo1, equipo1, 0);
            verJugadores(rsEquipo2, equipo2, 5);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnVerJugadoresActionPerformed

    /**
     *  Crea un fichero txt llamado idJugador.txt 
     * 
     *  @param evt 
     */
    private void btnSeleccionarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarJugadorActionPerformed
        JRadioButton[] equipos = {rbtnEq1J1, rbtnEq1J2, rbtnEq1J3, rbtnEq1J4, rbtnEq1J5, rbtnEq2J1, rbtnEq2J2, rbtnEq2J3, rbtnEq2J4, rbtnEq2J5};
        
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\angel\\Desktop\\wamp64\\www\\marcador\\idJugador.txt");
            myWriter.write("SELECT jugadores.aka, estadisticas_jugador.k, estadisticas_jugador.d, estadisticas_jugador.a, estadisticas_jugador.adr, jugadores.id_equipo " +
                           "FROM estadisticas_jugador " +
                           "LEFT JOIN jugadores " +
                           "ON estadisticas_jugador.id_jugador = jugadores.id_jugador\n" +
                           "WHERE estadisticas_jugador.id_jugador = " + idJugadores[numeroBoton(equipos)]);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSeleccionarJugadorActionPerformed
    
    /**
     *  Recoge los datos(jugadores) de la base de datos
     * 
     *  @param rs Resultset de la consulta
     *  @param rdb Array de JRadioButton
     *  @param j indice para rellenar el segundo equipo
     */
    private void verJugadores(ResultSet rs, JRadioButton[] rdb, int j) {
        int i = 0;
        try {
            while (rs.next()) {
                idJugadores[j] = Integer.parseInt(rs.getString("id_jugador"));
                rdb[i].setText(" " + rs.getString("aka"));
                i++;
                j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *  Saber que boton se esta pulsando  
     * 
     *  @param rdb Array de JRadioButton
     *  @return int
     */
    private int numeroBoton(JRadioButton[] rdb) {
        int numero = 0;
        for (int i = 0; i < rdb.length; i++) {
            if (rdb[i].isSelected()) {
                numero = i;
            }
        }
        return numero;
    }
    
    /**
     *  Muestra los datos de la abse de datos y los pone en JTextField
     * 
     *  @param jtf Array de JTextField
     *  @param indice Numero de fila que quieres
     *  @param rs ResultSet
     *  @param campos Campos de la tabla de la base de datos
     */
    private void muestraDatos(JTextField[][] jtf, int indice, ResultSet rs, String[] campos) {
        try {
            for (int i = 0; i < jtf[indice].length; i++) {
                jtf[indice][i].setText(rs.getString(campos[i]));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     *  Configuracion de los botones
     *  
     *  @param posActual Posicion actual del registro
     *  @param posTotal Posicion final del registro
     *  @param btnP Boton primero
     *  @param btnA Boton anterior
     *  @param btnS Boton siguiente
     *  @param btnU Boton Ultimo
     */
    private void confBotones(int posActual, int posTotal, JButton btnP, JButton btnA, JButton btnS, JButton btnU) {
        btnP.setEnabled(true);
        btnA.setEnabled(true);
        btnS.setEnabled(true);
        btnU.setEnabled(true);
        
        if (posActual == 1) {
            btnP.setEnabled(false);
            btnA.setEnabled(false);
        } else if (posActual == posTotal) {
            btnS.setEnabled(false);
            btnU.setEnabled(false);
        } 
    }
    
    /**
     *  Enseña el primer registro en cada pestaña
     * 
     *  @param tabla Escoger la tabla
     *  @param jtf Array de JTextField
     *  @param opcion Escoge en que pestaña quieres (1 actualizar, 2 borrar)
     */
    private void setTabla(String tabla, JTextField[][] jtf, int opcion) {
        switch (tabla) {
            case "anunciantes":
                try {
                    if (opcion == 1) {
                        anunciante.cargaDatos();
                        datosAnunciantes = anunciante.getRs();
                        datosAnunciantes.last();
                        a_posicionesTotalA = datosAnunciantes.getRow();
                        a_lblPosicionesA.setText(a_posicionActualA + " / " + a_posicionesTotalA);
                        datosAnunciantes.first();
                        muestraDatos(jtf, 0, datosAnunciantes, anunciante.getCamposTabla());
                        confBotones(a_posicionActualA, a_posicionesTotalA, btnPrimeroA, btnAnteriorA, btnSiguienteA, btnUltimoA);
                    } else if (opcion == 2) {
                        anunciante.cargaDatos2();
                        datosAnunciantes2 = anunciante.getRs2();
                        datosAnunciantes2.last();
                        b_posicionesTotalA = datosAnunciantes2.getRow();
                        b_lblPosicionesA.setText(b_posicionActualA + " / " + a_posicionesTotalA);
                        datosAnunciantes2.first();
                        muestraDatos(jtf, 0, datosAnunciantes2, anunciante.getCamposTabla());
                        confBotones(b_posicionActualA, b_posicionesTotalA, btnPrimeroA1, btnAnteriorA1, btnSiguienteA1, btnUltimoA1);
                    }
                } catch (Exception ex) {
                    //Logger.getLogger(VerCoches.class.getName()).log(Level.SEVERE, null, ex);
            }
            case "equipos":
                try {
                    if (opcion == 1) {
                        equipo.cargaDatos();
                        datosEquipos = equipo.getRs();
                        datosEquipos.last();
                        a_posicionesTotalE = datosEquipos.getRow();
                        a_lblPosicionesE.setText(a_posicionActualE + " / " + a_posicionesTotalE);
                        datosEquipos.first();
                        muestraDatos(jtf, 1, datosEquipos, equipo.getCamposTabla());
                        MetodosSueltos.formatearStringToDate(datosEquipos, a_txtFundadoE, "fundado");
                        confBotones(a_posicionActualE, a_posicionesTotalE, btnPrimeroE, btnAnteriorE, btnSiguienteE, btnUltimoE);
                    } else if (opcion == 2) {
                        equipo.cargaDatos2();
                        datosEquipos2 = equipo.getRs2();
                        datosEquipos2.last();
                        b_posicionesTotalE = datosEquipos2.getRow();
                        b_lblPosicionesE.setText(b_posicionActualE + " / " + b_posicionesTotalE);
                        datosEquipos2.first();
                        muestraDatos(jtf, 1, datosEquipos2, equipo.getCamposTabla());
                        MetodosSueltos.formatearStringToDate(datosEquipos2, b_txtFundadoE, "fundado");
                        confBotones(b_posicionActualE, b_posicionesTotalE, btnPrimeroE1, btnAnteriorE1, btnSiguienteE1, btnUltimoE1);
                    }
                } catch (Exception ex) {
                    //Logger.getLogger(VerCoches.class.getName()).log(Level.SEVERE, null, ex);
            }
            case "estadisticasJ":
                try {
                    if (opcion == 1) {
                        estadisticasJ.cargaDatos();
                        datosEstadisticasJ = estadisticasJ.getRs();
                        datosEstadisticasJ.last();
                        a_posicionesTotalEJ = datosEstadisticasJ.getRow();
                        a_lblPosicionesEJ.setText(a_posicionActualEJ + " / " + a_posicionesTotalEJ);
                        datosEstadisticasJ.first();
                        muestraDatos(jtf, 2, datosEstadisticasJ, estadisticasJ.getCamposTabla());
                        confBotones(a_posicionActualEJ, a_posicionesTotalEJ, btnPrimeroEJ, btnAnteriorEJ, btnSiguienteEJ, btnUltimoEJ);
                    } else if (opcion == 2) {
                        estadisticasJ.cargaDatos2();
                        datosEstadisticasJ2 = estadisticasJ.getRs2();
                        datosEstadisticasJ2.last();
                        b_posicionesTotalEJ = datosEstadisticasJ2.getRow();
                        b_lblPosicionesEJ.setText(b_posicionActualEJ + " / " + b_posicionesTotalEJ);
                        datosEstadisticasJ2.first();
                        muestraDatos(jtf, 2, datosEstadisticasJ2, estadisticasJ.getCamposTabla());
                        confBotones(b_posicionActualEJ, b_posicionesTotalEJ, btnPrimeroEJ1, btnAnteriorEJ1, btnSiguienteEJ1, btnUltimoEJ1);
                    }
                } catch (Exception ex) {
                    //Logger.getLogger(VerCoches.class.getName()).log(Level.SEVERE, null, ex);
            }
            case "jugadores":
                try {
                    if (opcion == 1) {
                        jugador.cargaDatos();
                        datosJugadores = jugador.getRs();
                        datosJugadores.last();
                        a_posicionesTotalJ = datosJugadores.getRow();
                        a_lblPosicionesJ.setText(a_posicionActualJ + " / " + a_posicionesTotalJ);
                        datosJugadores.first();
                        muestraDatos(jtf, 3, datosJugadores, jugador.getCamposTabla());
                        MetodosSueltos.formatearStringToDate(datosJugadores, a_txtFechaNacJ, "fecha_nacimiento");
                        confBotones(a_posicionActualJ, a_posicionesTotalJ, btnPrimeroJ, btnAnteriorJ, btnSiguienteJ, btnUltimoJ);
                    } else if (opcion == 2) {
                        jugador.cargaDatos2();
                        datosJugadores2 = jugador.getRs2();
                        datosJugadores2.last();
                        b_posicionesTotalJ = datosJugadores2.getRow();
                        b_lblPosicionesJ.setText(b_posicionActualJ + " / " + b_posicionesTotalJ);
                        datosJugadores2.first();
                        muestraDatos(jtf, 3, datosJugadores2, jugador.getCamposTabla());
                        MetodosSueltos.formatearStringToDate(datosJugadores2, b_txtFechaNacJ, "fecha_nacimiento");
                        confBotones(b_posicionActualJ, b_posicionesTotalJ, btnPrimeroJ1, btnAnteriorJ1, btnSiguienteJ1, btnUltimoJ1);
                    }
                } catch (Exception ex) {
                    //Logger.getLogger(VerCoches.class.getName()).log(Level.SEVERE, null, ex);
            }
            case "partidas":
                try {
                    if (opcion == 1) {
                        partida.cargaDatos();
                        datosPartidas = partida.getRs();
                        datosPartidas.last();
                        a_posicionesTotalP = datosPartidas.getRow();
                        a_lblPosicionesP.setText(a_posicionActualP + " / " + a_posicionesTotalP);
                        datosPartidas.first();
                        muestraDatos(jtf, 4, datosPartidas, partida.getCamposTabla());
                        MetodosSueltos.formatearStringToDate(datosPartidas, a_txtFechaP, "fecha");
                        a_txtComienzoP.setText(datosPartidas.getString("hora_comienzo"));
                        a_txtFinalP.setText(datosPartidas.getString("hora_finalizacion"));
                        confBotones(a_posicionActualP, a_posicionesTotalP, btnPrimeroP, btnAnteriorP, btnSiguienteP, btnUltimoP);
                    } else if(opcion == 2) {
                        partida.cargaDatos2();
                        datosPartidas2 = partida.getRs2();
                        datosPartidas2.last();
                        b_posicionesTotalP = datosPartidas2.getRow();
                        b_lblPosicionesP.setText(b_posicionActualP + " / " + b_posicionesTotalP);
                        datosPartidas2.first();
                        muestraDatos(jtf, 4, datosPartidas2, partida.getCamposTabla());
                        MetodosSueltos.formatearStringToDate(datosPartidas2, b_txtFechaP, "fecha");
                        b_txtComienzoP.setText(datosPartidas2.getString("hora_comienzo"));
                        b_txtFinalP.setText(datosPartidas2.getString("hora_finalizacion"));
                        confBotones(b_posicionActualP, b_posicionesTotalP, btnPrimeroP1, btnAnteriorP1, btnSiguienteP1, btnUltimoP1);
                    }
                } catch (Exception ex) {
                    //Logger.getLogger(VerCoches.class.getName()).log(Level.SEVERE, null, ex);
            }
            case "torneos":
                try {
                    if (opcion == 1) {
                        torneo.cargaDatos();
                        datosTorneos = torneo.getRs();
                        datosTorneos.last();
                        a_posicionesTotalT = datosTorneos.getRow();
                        a_lblPosicionesT.setText(a_posicionActualT + " / " + a_posicionesTotalT);
                        datosTorneos.first();
                        muestraDatos(jtf, 5, datosTorneos, torneo.getCamposTabla());
                        MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaComT, "fecha_comienzo");
                        MetodosSueltos.formatearStringToDate(datosTorneos, a_txtFechaFinT, "fecha_finalizacion");
                        confBotones(a_posicionActualT, a_posicionesTotalT, btnPrimeroT, btnAnteriorT, btnSiguienteT, btnUltimoT);
                    } else if(opcion == 2) {
                        torneo.cargaDatos2();
                        datosTorneos2 = torneo.getRs2();
                        datosTorneos2.last();
                        b_posicionesTotalT = datosTorneos2.getRow();
                        b_lblPosicionesT.setText(b_posicionActualT + " / " + b_posicionesTotalT);
                        datosTorneos2.first();
                        muestraDatos(jtf, 5, datosTorneos2, torneo.getCamposTabla());
                        MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaComT, "fecha_comienzo");
                        MetodosSueltos.formatearStringToDate(datosTorneos2, b_txtFechaFinT, "fecha_finalizacion");
                        confBotones(b_posicionActualT, b_posicionesTotalT, btnPrimeroT1, btnAnteriorT1, btnSiguienteT1, btnUltimoT1);
                    }
                } catch (Exception ex) {
                    //Logger.getLogger(VerCoches.class.getName()).log(Level.SEVERE, null, ex);
            }
            case "torneosAnunciantes":
                try {
                    if (opcion == 1) {
                        torneoAnunciante.cargaDatos();
                        datosTorneosAnunciantes = torneoAnunciante.getRs();
                        datosTorneosAnunciantes.last();
                        a_posicionesTotalTA = datosTorneosAnunciantes.getRow();
                        a_lblPosicionesTA.setText(a_posicionActualTA + " / " + a_posicionesTotalTA);
                        datosTorneosAnunciantes.first();
                        muestraDatos(jtf, 6, datosTorneosAnunciantes, torneoAnunciante.getCamposTabla());
                        confBotones(a_posicionActualTA, a_posicionesTotalTA, btnPrimeroTA, btnAnteriorTA, btnSiguienteTA, btnUltimoTA);
                    } else if(opcion == 2) {
                        torneoAnunciante.cargaDatos2();
                        datosTorneosAnunciantes2 = torneoAnunciante.getRs2();
                        datosTorneosAnunciantes2.last();
                        b_posicionesTotalTA = datosTorneosAnunciantes2.getRow();
                        b_lblPosicionesTA.setText(b_posicionActualTA + " / " + b_posicionesTotalTA);
                        datosTorneosAnunciantes2.first();
                        muestraDatos(jtf, 6, datosTorneosAnunciantes2, torneoAnunciante.getCamposTabla());
                        confBotones(b_posicionActualTA, b_posicionesTotalTA, btnPrimeroTA1, btnAnteriorTA1, btnSiguienteTA1, btnUltimoTA1);
                    }
                } catch (Exception ex) {
                    //Logger.getLogger(VerCoches.class.getName()).log(Level.SEVERE, null, ex);
            } 
            case "torneosEquipos":
                try {
                    if (opcion == 1) {
                        torneoEquipo.cargaDatos();
                        datosTorneosEquipos = torneoEquipo.getRs();
                        datosTorneosEquipos.last();
                        a_posicionesTotalTE = datosTorneosEquipos.getRow();
                        a_lblPosicionesTE.setText(a_posicionActualTE + " / " + a_posicionesTotalTE);
                        datosTorneosEquipos.first();
                        muestraDatos(jtf, 7, datosTorneosEquipos, torneoEquipo.getCamposTabla());
                        confBotones(a_posicionActualTE, a_posicionesTotalTE, btnPrimeroTE, btnAnteriorTE, btnSiguienteTE, btnUltimoTE);
                    } else if(opcion == 2) {
                        torneoEquipo.cargaDatos2();
                        datosTorneosEquipos2 = torneoEquipo.getRs2();
                        datosTorneosEquipos2.last();
                        b_posicionesTotalTE = datosTorneosEquipos2.getRow();
                        b_lblPosicionesTE.setText(b_posicionActualTE + " / " + b_posicionesTotalTE);
                        datosTorneosEquipos2.first();
                        muestraDatos(jtf, 7, datosTorneosEquipos2, torneoEquipo.getCamposTabla());
                        confBotones(b_posicionActualTE, b_posicionesTotalTE, btnPrimeroTE1, btnAnteriorTE1, btnSiguienteTE1, btnUltimoTE1);
                    }
                } catch (Exception ex) {
                    //Logger.getLogger(VerCoches.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a_lblNombreJ;
    private javax.swing.JLabel a_lblPosicionesA;
    private javax.swing.JLabel a_lblPosicionesE;
    private javax.swing.JLabel a_lblPosicionesEJ;
    private javax.swing.JLabel a_lblPosicionesJ;
    private javax.swing.JLabel a_lblPosicionesP;
    private javax.swing.JLabel a_lblPosicionesT;
    private javax.swing.JLabel a_lblPosicionesTA;
    private javax.swing.JLabel a_lblPosicionesTE;
    private javax.swing.JTextField a_txtAEJ;
    private javax.swing.JTextField a_txtAdrEJ;
    private javax.swing.JTextField a_txtAkaJ;
    private javax.swing.JTextField a_txtAnhosActivoJ;
    private javax.swing.JTextField a_txtCoachE;
    private com.github.lgooddatepicker.components.TimePicker a_txtComienzoP;
    private javax.swing.JTextField a_txtDEJ;
    private javax.swing.JTextField a_txtEquipoGanadorT;
    private com.toedter.calendar.JDateChooser a_txtFechaComT;
    private com.toedter.calendar.JDateChooser a_txtFechaFinT;
    private com.toedter.calendar.JDateChooser a_txtFechaNacJ;
    private com.toedter.calendar.JDateChooser a_txtFechaP;
    private com.github.lgooddatepicker.components.TimePicker a_txtFinalP;
    private com.toedter.calendar.JDateChooser a_txtFundadoE;
    private javax.swing.JTextField a_txtGanadorP;
    private javax.swing.JTextField a_txtIdAnunciante;
    private javax.swing.JTextField a_txtIdAnuncianteTA;
    private javax.swing.JTextField a_txtIdEquipo;
    private javax.swing.JTextField a_txtIdEquipoJ;
    private javax.swing.JTextField a_txtIdEquipoP1;
    private javax.swing.JTextField a_txtIdEquipoP2;
    private javax.swing.JTextField a_txtIdEquipoTE;
    private javax.swing.JTextField a_txtIdEstadistica;
    private javax.swing.JTextField a_txtIdJugador;
    private javax.swing.JTextField a_txtIdJugadorEJ;
    private javax.swing.JTextField a_txtIdPartidaEJ;
    private javax.swing.JTextField a_txtIdPartidaP;
    private javax.swing.JTextField a_txtIdTorneo;
    private javax.swing.JTextField a_txtIdTorneoAnunciante;
    private javax.swing.JTextField a_txtIdTorneoEquipo;
    private javax.swing.JTextField a_txtIdTorneoTA;
    private javax.swing.JTextField a_txtIdTorneoTE;
    private javax.swing.JTextField a_txtKEJ;
    private javax.swing.JTextField a_txtLocalizacionE;
    private javax.swing.JTextField a_txtLogoA;
    private javax.swing.JTextField a_txtLogoE;
    private javax.swing.JTextField a_txtLugarT;
    private javax.swing.JTextField a_txtNacionalidadJ;
    private javax.swing.JTextField a_txtNombreA;
    private javax.swing.JTextField a_txtNombreE;
    private javax.swing.JTextField a_txtNombreJ;
    private javax.swing.JTextField a_txtNombreT;
    private javax.swing.JTextField a_txtPrecioA;
    private javax.swing.JTextField a_txtPremioT;
    private javax.swing.JTextField a_txtResultadoRondasP;
    private javax.swing.JTextField a_txtResultadoTotalP;
    private javax.swing.JTextField a_txtRolJ;
    private javax.swing.JTextField a_txtSalarioJ;
    private javax.swing.JTextField b_lblNombreJ;
    private javax.swing.JLabel b_lblPosicionesA;
    private javax.swing.JLabel b_lblPosicionesE;
    private javax.swing.JLabel b_lblPosicionesEJ;
    private javax.swing.JLabel b_lblPosicionesJ;
    private javax.swing.JLabel b_lblPosicionesP;
    private javax.swing.JLabel b_lblPosicionesT;
    private javax.swing.JLabel b_lblPosicionesTA;
    private javax.swing.JLabel b_lblPosicionesTE;
    private javax.swing.JTextField b_txtAEJ;
    private javax.swing.JTextField b_txtAdrEJ;
    private javax.swing.JTextField b_txtAkaJ;
    private javax.swing.JTextField b_txtAnhosActivoJ;
    private javax.swing.JTextField b_txtCoachE;
    private com.github.lgooddatepicker.components.TimePicker b_txtComienzoP;
    private javax.swing.JTextField b_txtDEJ;
    private javax.swing.JTextField b_txtEquipoGanadorT;
    private com.toedter.calendar.JDateChooser b_txtFechaComT;
    private com.toedter.calendar.JDateChooser b_txtFechaFinT;
    private com.toedter.calendar.JDateChooser b_txtFechaNacJ;
    private com.toedter.calendar.JDateChooser b_txtFechaP;
    private com.github.lgooddatepicker.components.TimePicker b_txtFinalP;
    private com.toedter.calendar.JDateChooser b_txtFundadoE;
    private javax.swing.JTextField b_txtGanadorP;
    private javax.swing.JTextField b_txtIdAnunciante;
    private javax.swing.JTextField b_txtIdAnuncianteTA;
    private javax.swing.JTextField b_txtIdEquipo;
    private javax.swing.JTextField b_txtIdEquipoJ;
    private javax.swing.JTextField b_txtIdEquipoP1;
    private javax.swing.JTextField b_txtIdEquipoP2;
    private javax.swing.JTextField b_txtIdEquipoTE;
    private javax.swing.JTextField b_txtIdEstadistica;
    private javax.swing.JTextField b_txtIdJugador;
    private javax.swing.JTextField b_txtIdJugadorEJ;
    private javax.swing.JTextField b_txtIdPartidaEJ;
    private javax.swing.JTextField b_txtIdPartidaP;
    private javax.swing.JTextField b_txtIdTorneo;
    private javax.swing.JTextField b_txtIdTorneoAnunciante;
    private javax.swing.JTextField b_txtIdTorneoEquipo;
    private javax.swing.JTextField b_txtIdTorneoTA;
    private javax.swing.JTextField b_txtIdTorneoTE;
    private javax.swing.JTextField b_txtKEJ;
    private javax.swing.JTextField b_txtLocalizacionE;
    private javax.swing.JTextField b_txtLogoA;
    private javax.swing.JTextField b_txtLogoE;
    private javax.swing.JTextField b_txtLugarT;
    private javax.swing.JTextField b_txtNacionalidadJ;
    private javax.swing.JTextField b_txtNombreA;
    private javax.swing.JTextField b_txtNombreE;
    private javax.swing.JTextField b_txtNombreJ;
    private javax.swing.JTextField b_txtNombreT;
    private javax.swing.JTextField b_txtPrecioA;
    private javax.swing.JTextField b_txtPremioT;
    private javax.swing.JTextField b_txtResultadoRondasP;
    private javax.swing.JTextField b_txtResultadoTotalP;
    private javax.swing.JTextField b_txtRolJ;
    private javax.swing.JTextField b_txtSalarioJ;
    private javax.swing.JButton btnActualizarDatosAnunciantes;
    private javax.swing.JButton btnActualizarDatosEquipos;
    private javax.swing.JButton btnActualizarDatosEstadisticasJ;
    private javax.swing.JButton btnActualizarDatosJugadores;
    private javax.swing.JButton btnActualizarDatosPartidas;
    private javax.swing.JButton btnActualizarDatosTorneos;
    private javax.swing.JButton btnActualizarDatosTorneosA;
    private javax.swing.JButton btnActualizarDatosTorneosE;
    private javax.swing.JButton btnAnteriorA;
    private javax.swing.JButton btnAnteriorA1;
    private javax.swing.JButton btnAnteriorE;
    private javax.swing.JButton btnAnteriorE1;
    private javax.swing.JButton btnAnteriorEJ;
    private javax.swing.JButton btnAnteriorEJ1;
    private javax.swing.JButton btnAnteriorJ;
    private javax.swing.JButton btnAnteriorJ1;
    private javax.swing.JButton btnAnteriorP;
    private javax.swing.JButton btnAnteriorP1;
    private javax.swing.JButton btnAnteriorT;
    private javax.swing.JButton btnAnteriorT1;
    private javax.swing.JButton btnAnteriorTA;
    private javax.swing.JButton btnAnteriorTA1;
    private javax.swing.JButton btnAnteriorTE;
    private javax.swing.JButton btnAnteriorTE1;
    private javax.swing.JButton btnBorrarA;
    private javax.swing.JButton btnBorrarDatosAnunciantes;
    private javax.swing.JButton btnBorrarDatosEquipos;
    private javax.swing.JButton btnBorrarDatosEstadisticasJ;
    private javax.swing.JButton btnBorrarDatosJugadores;
    private javax.swing.JButton btnBorrarDatosPartidas;
    private javax.swing.JButton btnBorrarDatosTorneos;
    private javax.swing.JButton btnBorrarDatosTorneosA;
    private javax.swing.JButton btnBorrarDatosTorneosE;
    private javax.swing.JButton btnBorrarE;
    private javax.swing.JButton btnBorrarEJ;
    private javax.swing.JButton btnBorrarJ;
    private javax.swing.JButton btnBorrarP;
    private javax.swing.JButton btnBorrarT;
    private javax.swing.JButton btnBorrarTA;
    private javax.swing.JButton btnBorrarTE;
    private javax.swing.ButtonGroup btnG;
    private javax.swing.JButton btnMeterDatosAnunciantes;
    private javax.swing.JButton btnMeterDatosEquipos;
    private javax.swing.JButton btnMeterDatosEstadisticasJ;
    private javax.swing.JButton btnMeterDatosJugadores;
    private javax.swing.JButton btnMeterDatosPartidas;
    private javax.swing.JButton btnMeterDatosTorneos;
    private javax.swing.JButton btnMeterDatosTorneosA;
    private javax.swing.JButton btnMeterDatosTorneosE;
    private javax.swing.JButton btnPrimeroA;
    private javax.swing.JButton btnPrimeroA1;
    private javax.swing.JButton btnPrimeroE;
    private javax.swing.JButton btnPrimeroE1;
    private javax.swing.JButton btnPrimeroEJ;
    private javax.swing.JButton btnPrimeroEJ1;
    private javax.swing.JButton btnPrimeroJ;
    private javax.swing.JButton btnPrimeroJ1;
    private javax.swing.JButton btnPrimeroP;
    private javax.swing.JButton btnPrimeroP1;
    private javax.swing.JButton btnPrimeroT;
    private javax.swing.JButton btnPrimeroT1;
    private javax.swing.JButton btnPrimeroTA;
    private javax.swing.JButton btnPrimeroTA1;
    private javax.swing.JButton btnPrimeroTE;
    private javax.swing.JButton btnPrimeroTE1;
    private javax.swing.JButton btnSeleccionarJugador;
    private javax.swing.JButton btnSiguienteA;
    private javax.swing.JButton btnSiguienteA1;
    private javax.swing.JButton btnSiguienteE;
    private javax.swing.JButton btnSiguienteE1;
    private javax.swing.JButton btnSiguienteEJ;
    private javax.swing.JButton btnSiguienteEJ1;
    private javax.swing.JButton btnSiguienteJ;
    private javax.swing.JButton btnSiguienteJ1;
    private javax.swing.JButton btnSiguienteP;
    private javax.swing.JButton btnSiguienteP1;
    private javax.swing.JButton btnSiguienteT;
    private javax.swing.JButton btnSiguienteT1;
    private javax.swing.JButton btnSiguienteTA;
    private javax.swing.JButton btnSiguienteTA1;
    private javax.swing.JButton btnSiguienteTE;
    private javax.swing.JButton btnSiguienteTE1;
    private javax.swing.JButton btnUltimoA;
    private javax.swing.JButton btnUltimoA1;
    private javax.swing.JButton btnUltimoE;
    private javax.swing.JButton btnUltimoE1;
    private javax.swing.JButton btnUltimoEJ;
    private javax.swing.JButton btnUltimoEJ1;
    private javax.swing.JButton btnUltimoJ;
    private javax.swing.JButton btnUltimoJ1;
    private javax.swing.JButton btnUltimoP;
    private javax.swing.JButton btnUltimoP1;
    private javax.swing.JButton btnUltimoT;
    private javax.swing.JButton btnUltimoT1;
    private javax.swing.JButton btnUltimoTA;
    private javax.swing.JButton btnUltimoTA1;
    private javax.swing.JButton btnUltimoTE;
    private javax.swing.JButton btnUltimoTE1;
    private javax.swing.JButton btnVerJugadores;
    private javax.swing.JTextField i_txtAEJ;
    private javax.swing.JTextField i_txtAdrEJ;
    private javax.swing.JTextField i_txtAkaJ;
    private javax.swing.JTextField i_txtAnhosActivoJ;
    private javax.swing.JTextField i_txtCoachE;
    private com.github.lgooddatepicker.components.TimePicker i_txtComienzoP;
    private javax.swing.JTextField i_txtDEJ;
    private javax.swing.JTextField i_txtEquipoGanadorT;
    private com.toedter.calendar.JDateChooser i_txtFechaComT;
    private com.toedter.calendar.JDateChooser i_txtFechaFinT;
    private com.toedter.calendar.JDateChooser i_txtFechaNacJ;
    private com.toedter.calendar.JDateChooser i_txtFechaP;
    private com.github.lgooddatepicker.components.TimePicker i_txtFinalP;
    private com.toedter.calendar.JDateChooser i_txtFundadoE;
    private javax.swing.JTextField i_txtGanadorP;
    private javax.swing.JTextField i_txtIdAnuncianteTA;
    private javax.swing.JTextField i_txtIdEquipoJ;
    private javax.swing.JTextField i_txtIdEquipoP1;
    private javax.swing.JTextField i_txtIdEquipoP2;
    private javax.swing.JTextField i_txtIdEquipoTE;
    private javax.swing.JTextField i_txtIdJugadorEJ;
    private javax.swing.JTextField i_txtIdPartidaEJ;
    private javax.swing.JTextField i_txtIdTorneoTA;
    private javax.swing.JTextField i_txtIdTorneoTE;
    private javax.swing.JTextField i_txtKEJ;
    private javax.swing.JTextField i_txtLocalizacionE;
    private javax.swing.JTextField i_txtLogoA;
    private javax.swing.JTextField i_txtLogoE;
    private javax.swing.JTextField i_txtLugarT;
    private javax.swing.JTextField i_txtNacionalidadJ;
    private javax.swing.JTextField i_txtNombreA;
    private javax.swing.JTextField i_txtNombreE;
    private javax.swing.JTextField i_txtNombreJ;
    private javax.swing.JTextField i_txtNombreT;
    private javax.swing.JTextField i_txtPrecioA;
    private javax.swing.JTextField i_txtPremioT;
    private javax.swing.JTextField i_txtResultadoRondasP;
    private javax.swing.JTextField i_txtResultadoTotalP;
    private javax.swing.JTextField i_txtRolJ;
    private javax.swing.JTextField i_txtSalarioJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAEJ;
    private javax.swing.JLabel lblAEJ1;
    private javax.swing.JLabel lblAEJ2;
    private javax.swing.JLabel lblAdrEJ;
    private javax.swing.JLabel lblAdrEJ1;
    private javax.swing.JLabel lblAdrEJ2;
    private javax.swing.JLabel lblAkaJ;
    private javax.swing.JLabel lblAkaJ1;
    private javax.swing.JLabel lblAkaJ2;
    private javax.swing.JLabel lblAnhosActivoJ;
    private javax.swing.JLabel lblAnhosActivoJ1;
    private javax.swing.JLabel lblAnhosActivoJ2;
    private javax.swing.JLabel lblCoachE;
    private javax.swing.JLabel lblCoachE1;
    private javax.swing.JLabel lblCoachE2;
    private javax.swing.JLabel lblComienzoP;
    private javax.swing.JLabel lblComienzoP1;
    private javax.swing.JLabel lblComienzoP2;
    private javax.swing.JLabel lblDEJ;
    private javax.swing.JLabel lblDEJ1;
    private javax.swing.JLabel lblDEJ2;
    private javax.swing.JLabel lblEquipoGanadorT;
    private javax.swing.JLabel lblEquipoGanadorT1;
    private javax.swing.JLabel lblEquipoGanadorT2;
    private javax.swing.JLabel lblFechaComT;
    private javax.swing.JLabel lblFechaComT1;
    private javax.swing.JLabel lblFechaComT2;
    private javax.swing.JLabel lblFechaFinT;
    private javax.swing.JLabel lblFechaFinT1;
    private javax.swing.JLabel lblFechaFinT2;
    private javax.swing.JLabel lblFechaNacJ;
    private javax.swing.JLabel lblFechaNacJ1;
    private javax.swing.JLabel lblFechaNacJ2;
    private javax.swing.JLabel lblFechaP;
    private javax.swing.JLabel lblFechaP1;
    private javax.swing.JLabel lblFechaP2;
    private javax.swing.JLabel lblFinalP;
    private javax.swing.JLabel lblFinalP1;
    private javax.swing.JLabel lblFinalP2;
    private javax.swing.JLabel lblFundadoE;
    private javax.swing.JLabel lblFundadoE1;
    private javax.swing.JLabel lblFundadoE2;
    private javax.swing.JLabel lblGanadorP;
    private javax.swing.JLabel lblGanadorP1;
    private javax.swing.JLabel lblGanadorP2;
    private javax.swing.JLabel lblIdAnunciante;
    private javax.swing.JLabel lblIdAnunciante1;
    private javax.swing.JLabel lblIdAnuncianteTA;
    private javax.swing.JLabel lblIdAnuncianteTA1;
    private javax.swing.JLabel lblIdAnuncianteTA2;
    private javax.swing.JLabel lblIdEquipo;
    private javax.swing.JLabel lblIdEquipo1;
    private javax.swing.JLabel lblIdEquipoJ;
    private javax.swing.JLabel lblIdEquipoJ1;
    private javax.swing.JLabel lblIdEquipoJ2;
    private javax.swing.JLabel lblIdEquipoP1;
    private javax.swing.JLabel lblIdEquipoP2;
    private javax.swing.JLabel lblIdEquipoP3;
    private javax.swing.JLabel lblIdEquipoP4;
    private javax.swing.JLabel lblIdEquipoP5;
    private javax.swing.JLabel lblIdEquipoP6;
    private javax.swing.JLabel lblIdEstadistica;
    private javax.swing.JLabel lblIdEstadistica1;
    private javax.swing.JLabel lblIdJugador;
    private javax.swing.JLabel lblIdJugador1;
    private javax.swing.JLabel lblIdJugadorEJ;
    private javax.swing.JLabel lblIdJugadorEJ1;
    private javax.swing.JLabel lblIdJugadorEJ2;
    private javax.swing.JLabel lblIdPartida;
    private javax.swing.JLabel lblIdPartida1;
    private javax.swing.JLabel lblIdPartidaEJ;
    private javax.swing.JLabel lblIdPartidaEJ1;
    private javax.swing.JLabel lblIdPartidaEJ2;
    private javax.swing.JLabel lblIdTorneo;
    private javax.swing.JLabel lblIdTorneo1;
    private javax.swing.JLabel lblIdTorneoAnunciante;
    private javax.swing.JLabel lblIdTorneoAnunciante1;
    private javax.swing.JLabel lblIdTorneoTA;
    private javax.swing.JLabel lblIdTorneoTA1;
    private javax.swing.JLabel lblIdTorneoTA2;
    private javax.swing.JLabel lblIdTorneoTE;
    private javax.swing.JLabel lblIdTorneoTE1;
    private javax.swing.JLabel lblIdTorneoTE2;
    private javax.swing.JLabel lblIdTorneoTE3;
    private javax.swing.JLabel lblIdTorneoTE4;
    private javax.swing.JLabel lblIdequipoTE;
    private javax.swing.JLabel lblIdequipoTE1;
    private javax.swing.JLabel lblIdequipoTE2;
    private javax.swing.JLabel lblKEJ;
    private javax.swing.JLabel lblKEJ1;
    private javax.swing.JLabel lblKEJ2;
    private javax.swing.JLabel lblLocalizacion;
    private javax.swing.JLabel lblLocalizacion1;
    private javax.swing.JLabel lblLocalizacion2;
    private javax.swing.JLabel lblLogoA;
    private javax.swing.JLabel lblLogoA2;
    private javax.swing.JLabel lblLogoE;
    private javax.swing.JLabel lblLogoE1;
    private javax.swing.JLabel lblLogoE2;
    private javax.swing.JLabel lblLugarT;
    private javax.swing.JLabel lblLugarT1;
    private javax.swing.JLabel lblLugarT2;
    private javax.swing.JLabel lblNacionalidadJ;
    private javax.swing.JLabel lblNacionalidadJ1;
    private javax.swing.JLabel lblNacionalidadJ2;
    private javax.swing.JLabel lblNombreA;
    private javax.swing.JLabel lblNombreA1;
    private javax.swing.JLabel lblNombreA2;
    private javax.swing.JLabel lblNombreE;
    private javax.swing.JLabel lblNombreE1;
    private javax.swing.JLabel lblNombreE2;
    private javax.swing.JLabel lblNombreJ;
    private javax.swing.JLabel lblNombreJ1;
    private javax.swing.JLabel lblNombreJ2;
    private javax.swing.JLabel lblNombreT;
    private javax.swing.JLabel lblNombreT1;
    private javax.swing.JLabel lblNombreT2;
    private javax.swing.JLabel lblPrecioA;
    private javax.swing.JLabel lblPrecioA1;
    private javax.swing.JLabel lblPrecioA3;
    private javax.swing.JLabel lblPrecioA4;
    private javax.swing.JLabel lblPremioT;
    private javax.swing.JLabel lblPremioT1;
    private javax.swing.JLabel lblPremioT2;
    private javax.swing.JLabel lblResultadoRondasP;
    private javax.swing.JLabel lblResultadoRondasP1;
    private javax.swing.JLabel lblResultadoRondasP2;
    private javax.swing.JLabel lblResultadoTotalP;
    private javax.swing.JLabel lblResultadoTotalP1;
    private javax.swing.JLabel lblResultadoTotalP2;
    private javax.swing.JLabel lblRolJ;
    private javax.swing.JLabel lblRolJ1;
    private javax.swing.JLabel lblRolJ2;
    private javax.swing.JLabel lblSalarioJ;
    private javax.swing.JLabel lblSalarioJ1;
    private javax.swing.JLabel lblSalarioJ2;
    private javax.swing.JPanel pAnunciantes;
    private javax.swing.JPanel pAnunciantes1;
    private javax.swing.JPanel pAnunciantes2;
    private javax.swing.JPanel pBorrar;
    private javax.swing.JTabbedPane pBorrar2;
    private javax.swing.JPanel pEquipos;
    private javax.swing.JPanel pEquipos1;
    private javax.swing.JPanel pEquipos2;
    private javax.swing.JPanel pEstadisticas1;
    private javax.swing.JPanel pEstadisticas2;
    private javax.swing.JPanel pEstadisticasJug;
    private javax.swing.JPanel pInsertar;
    private javax.swing.JPanel pJugadores;
    private javax.swing.JPanel pJugadores1;
    private javax.swing.JPanel pJugadores2;
    private javax.swing.JPanel pModificar;
    private javax.swing.JTabbedPane pModificar1;
    private javax.swing.JPanel pPartidas;
    private javax.swing.JPanel pPartidas1;
    private javax.swing.JPanel pPartidas2;
    private javax.swing.JPanel pTorneos;
    private javax.swing.JPanel pTorneos1;
    private javax.swing.JPanel pTorneos2;
    private javax.swing.JPanel pTorneosAnunciantes;
    private javax.swing.JPanel pTorneosAnunciantes1;
    private javax.swing.JPanel pTorneosAnunciantes2;
    private javax.swing.JPanel pTorneosEquipos;
    private javax.swing.JPanel pTorneosEquipos1;
    private javax.swing.JPanel pTorneosEquipos2;
    private javax.swing.JRadioButton rbtnEq1J1;
    private javax.swing.JRadioButton rbtnEq1J2;
    private javax.swing.JRadioButton rbtnEq1J3;
    private javax.swing.JRadioButton rbtnEq1J4;
    private javax.swing.JRadioButton rbtnEq1J5;
    private javax.swing.JRadioButton rbtnEq2J1;
    private javax.swing.JRadioButton rbtnEq2J2;
    private javax.swing.JRadioButton rbtnEq2J3;
    private javax.swing.JRadioButton rbtnEq2J4;
    private javax.swing.JRadioButton rbtnEq2J5;
    private javax.swing.JTabbedPane tpContenedor;
    private javax.swing.JTabbedPane tpInsertar1;
    private javax.swing.JTextField txtIdEquipo1;
    private javax.swing.JTextField txtIdEquipo2;
    private javax.swing.JPanel verJugador;
    // End of variables declaration//GEN-END:variables
}
